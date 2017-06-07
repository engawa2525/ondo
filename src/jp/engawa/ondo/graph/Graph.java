package jp.engawa.ondo.graph;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.Util;
import jp.engawa.ondo.entity.OdTargetLogEntity;

public class Graph implements Serializable {
	private static final long serialVersionUID = 4882011164364462401L;
	
	protected int width = 600;
	protected int height = 300;
	
	protected int margin_x = 60;
	protected int margin_y = 50;
	
	protected int margin_x2 = 10;
	protected int margin_y2 = 10;
	
	protected Label[] ylabels;
	protected Label[] xlabels;
	
	protected Line[] lines;
	
	public void sample() {
		ylabels = Label.buildY();
		this.xlabels = Label.buildX("20170309");
		this.lines = new Line[1];
		this.lines[0] = new Line();
		this.lines[0].setColor("#000000");
		this.lines[0].setItems(LineItem.buildSample());
	}
	
	public void build(String ymd,Db db,double min,double max) throws SQLException {
		this.ylabels = Label.buildY(min,max);
		this.xlabels = Label.buildX(ymd);
		this.lines = new Line[1];
		this.lines[0] = new Line();
		this.lines[0].setColor("#000000");
		List<OdTargetLogEntity> elist = new ArrayList<>();
		while(db.next()) {
			OdTargetLogEntity en = (OdTargetLogEntity)db.getEntity();
			elist.add(en);
		}
		LineItem[] items = LineItem.buildItem(this.xlabels,this.ylabels,elist);
		this.lines[0].setItems(items);
	}
	
	public void build2(String ymd,Db db,double min,double max) throws SQLException {
		this.ylabels = Label.buildY(min,max);
		this.xlabels = Label.buildX(ymd);
		this.lines = new Line[1];
		this.lines[0] = new Line();
		this.lines[0].setColor("#000000");
		List<OdTargetLogEntity> elist = new ArrayList<>();
		while(db.next()) {
			OdTargetLogEntity en = (OdTargetLogEntity)db.getEntity();
			elist.add(en);
		}
		LineItem[] items = LineItem.buildItem(this.xlabels,this.ylabels,elist);
		this.lines[0].setItems(items);
	}	

	public String getText() {
		StringBuilder sb = new StringBuilder();
		sb.append("<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" viewBox=\"0 0 "+width+" "+height+"\" width=\""+width+"\" height=\""+height+"\">");
		sb.append("<rect x=\"0\" y=\"0\" width=\""+width+"\" height=\""+height+"\" fill=\"#eee\" />");
		
		//軸
		int line_y_x0 = margin_x;
		int line_y_y0 = height - margin_y;
		int line_y_x1 = width - margin_x2;
		int line_y_y1 = height - margin_y;
		
		int line_x_x0 = margin_x;
		int line_x_y0 = height - margin_y;
		int line_x_x1 = margin_x;
		int line_x_y1 = margin_y2;
		
		sb.append("<line x1=\""+line_y_x0+"\" y1=\""+line_y_y0+"\" x2=\""+line_y_x1+"\" y2=\""+line_y_y1+"\" stroke=\"#444\" stroke-width=\"2\"/>");
		sb.append("<line x1=\""+line_x_x0+"\" y1=\""+line_x_y0+"\" x2=\""+line_x_x1+"\" y2=\""+line_x_y1+"\" stroke=\"#444\" stroke-width=\"2\"/>");
		
		//目盛り
		for(int ii=0;ii<this.ylabels.length;ii++) {
			Label lbl = this.ylabels[ii];
			double y0 = (double)margin_y2;
			double y1 = (double)(height - margin_y);
			double ysa = y1 - y0;
			double yp = (1d - lbl.getPosition()) * ysa;
			int ypi = ((int)yp) + margin_y2;
			int x1 = line_y_x0 - 3;
			int text_x = line_y_x0 - 5;
			int text_y = ypi + 5;
			sb.append("<line x1=\""+line_y_x0+"\" y1=\""+ypi+"\" x2=\""+x1+"\" y2=\""+ypi+"\" stroke=\"#444\" stroke-width=\"1\"/>");
			if(lbl.getLine_width() > 0) {
				sb.append("<line x1=\""+line_y_x0+"\" y1=\""+ypi+"\" x2=\""+line_y_x1+"\" y2=\""+ypi+"\" stroke=\"#444\" stroke-width=\""+lbl.getLine_width()+"\" stroke-dasharray=\"8 8\"/>");
			}
			sb.append("<text x=\""+text_x+"\" y=\""+text_y+"\" text-anchor=\"end\"　font-family=\"monospace;\" font-size=\"10\">"+lbl.getText()+"</text>");
			//+ "/" + new DecimalFormat("0.00").format(lbl.getPosition())
			//sb.append("<text x=\""+text_x+"\" y=\""+(text_y+10)+"\" text-anchor=\"end\"　font-family=\"monospace;\" font-size=\"10\">"+new DecimalFormat("0.00").format(lbl.getPosition())+"</text>");
		}
		for(int ii=0;ii<this.xlabels.length;ii++) {
			Label lbl = this.xlabels[ii];
			double x0 = (double)margin_x;
			double x1 = (double)(width - margin_x2);
			double xsa = x1 - x0;
			double xp = (lbl.getPosition()) * xsa;
			int xpi = ((int)xp) + margin_x;
			int y1 = line_x_y0 + 3;
			int text_x = xpi;
			int text_y = line_x_y0 + 15;
			sb.append("<line x1=\""+xpi+"\" y1=\""+line_x_y0+"\" x2=\""+xpi+"\" y2=\""+y1+"\" stroke=\"#444\" stroke-width=\"1\"/>");
			sb.append("<text x=\""+text_x+"\" y=\""+text_y+"\" text-anchor=\"middle\" font-family=\"monospace;\" font-size=\"8\">"+lbl.getText2()+"</text>");
			String t1 = lbl.getText();
			if(!Util.isEmpty(t1)) {
				int text_y2 = line_x_y0 + 30;
				sb.append("<text x=\""+text_x+"\" y=\""+text_y2+"\" text-anchor=\"middle\" font-family=\"monospace;\" font-size=\"8\">"+lbl.getText()+"</text>");
			}
		}
		
		for(int ii=0;ii<this.lines.length;ii++) {
			Line line = this.lines[ii];
			double x0 = (double)margin_x;
			double x1 = (double)(width - margin_x2);
			double xsa = x1 - x0;

			double y0 = (double)margin_y2;
			double y1 = (double)(height - margin_y);
			double ysa = y1 - y0;
			
			sb.append("<polyline points=\"");
			for(LineItem item:line.getItems()) {
				double yp = (1d - item.getY_pos()) * ysa;
				int ypi = ((int)yp) + margin_y2;
				double xp = (item.getX_pos()) * xsa;
				int xpi = ((int)xp) + margin_x;
				sb.append(xpi + "," + ypi + " ");
			}
			sb.append("\" stroke=\""+line.getColor()+"\" fill=\"none\" stroke-width=\"2\">");
		}
		
		sb.append("</svg>");
		return sb.toString();
	}
}
