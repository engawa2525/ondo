package jp.engawa.ondo.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.engawa.gs.common.Util;
import jp.engawa.ondo.entity.OdTargetLogEntity;

public class LineItem {
	public static LineItem[] buildItem(Label[] xlabels,Label[] ylabels,List<OdTargetLogEntity> elist) {
		List<LineItem> list = new ArrayList<LineItem>();
		for(OdTargetLogEntity e:elist) {
			LineItem item = new LineItem();
			item.setCur_tmp(e.getColCurTmp());
			item.setDatetime(e.getColLogDt());
			list.add(item);
		}
		long t0 = xlabels[0].getTimestamp();
		long t1 = xlabels[xlabels.length-1].getTimestamp();
		long sa = t1 - t0;
		
		double max = ylabels[0].getValue();
		double min = ylabels[ylabels.length-1].getValue();
		
		double say = max - min;
		for(LineItem item:list) {
			Date ditem = item.getDatetime();
			long td = ditem.getTime();
			long td0 = td - t0;
			double r = (double)(td0) / (double)(sa);
			
			double tmp = item.getCur_tmp();
			double tmp1 = tmp - min;
			double r1 = tmp1 / say;
			item.setY_pos(r1);
			item.setX_pos(r);
		}	
		return list.toArray(new LineItem[0]);		
	}
	public static LineItem[] buildSample() {
		Label[] labelY = Label.buildY();
		
		List<LineItem> list = new ArrayList<LineItem>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/Users/okuyama/Documents/workspace/ondo/doc/log.txt")), "utf-8"));
			String line = reader.readLine();
			while(line != null) {
				String[] split = line.split("\t");
				if(split.length == 2) {
					LineItem item = new LineItem();
					item.setTime(split[0]);
					item.setCur_tmp(Util.toDbl(split[1]));
					list.add(item);
				}
				line = reader.readLine();
			}
			SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat ymdformat = new SimpleDateFormat("yyyyMMdd");
			Date d0 = ymdformat.parse("20170309");
			Date d1 = ymdformat.parse("20170310");
			long t0 = d0.getTime();
			long t1 = d1.getTime();
			long sa = t1 - t0;
			
			double max = labelY[0].getValue();
			double min = labelY[labelY.length-1].getValue();
			double say = max - min;
			for(LineItem item:list) {
				Date ditem = dformat.parse(item.getTime());
				long td = ditem.getTime();
				long td0 = td - t0;
				double r = (double)(td0) / (double)(sa);
				
				double tmp = item.getCur_tmp();
				double tmp1 = tmp - min;
				double r1 = tmp1 / say;
				item.setY_pos(r1);
				item.setX_pos(r);
			}
			
		} catch(IOException ex) {
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list.toArray(new LineItem[0]);
	}
	private String time;
	private Date datetime;
	private double cur_tmp;
	
	private double x_pos;
	private double y_pos;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getCur_tmp() {
		return cur_tmp;
	}
	public void setCur_tmp(double cur_tmp) {
		this.cur_tmp = cur_tmp;
	}
	public double getX_pos() {
		return x_pos;
	}
	public void setX_pos(double x_pos) {
		this.x_pos = x_pos;
	}
	public double getY_pos() {
		return y_pos;
	}
	public void setY_pos(double y_pos) {
		this.y_pos = y_pos;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
	
}
