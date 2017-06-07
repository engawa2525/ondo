package jp.engawa.ondo.graph;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jp.engawa.gs.common.Util;

public class Label {
	public static void main(String[] args) throws Exception {
		Label[] lbls = buildX("");
		for(int ii=0;ii<lbls.length;ii++) {
			Label lbl = lbls[ii];
			System.out.println(ii + "\t" + lbl.getText2() + "\t" + lbl.getPosition());
		}
	}
	public static Label[] buildY(double min,double max) {
		List<Label> list = new ArrayList<>();
		if(max > 50 && min <= 60) list.add(new Label("60"));
		if(max > 40 && min <= 50) list.add(new Label("50"));
		if(max > 30 && min <= 40) list.add(new Label("40"));
		if(max > 20 && min <= 30) list.add(new Label("30"));
		if(max > 10 && min <= 20) list.add(new Label("20"));
		if(max > 0 && min <= 10) list.add(new Label("10"));
		if(max > -10 && min <= 0) list.add(new Label("0",1));
		if(max > -20 && min <= -10) list.add(new Label("-10"));
		if(max > -30 && min <= -20) list.add(new Label("-20"));
		if(max > -40 && min <= -30) list.add(new Label("-30"));
		
		Label[] labels =  list.toArray(new Label[0]);
		buildPosition(labels,true);
		return labels;
	}

	public static Label[] buildY() {
		Label[] labels = new Label[]{
			new Label("30"),
			new Label("20"),
			new Label("10"),
			new Label("0",1),
			new Label("-10"),
			new Label("-20"),
			new Label("-30")
		};
		buildPosition(labels,true);
		return labels;
	}
	public static Label[] buildX(String ymd) {
		Date dt0 = Util.toDate(ymd);
		Calendar c = Calendar.getInstance();
		c.setTime(dt0);
		c.add(Calendar.DATE, +1);
		Date dt1 = c.getTime();
		String lbl = new SimpleDateFormat("MM/dd").format(dt0);
		Label[] labels = new Label[]{
			new Label(lbl,"00"),
			new Label("","01"),
			new Label("","02"),
			new Label("","03"),
			new Label("","04"),
			new Label("","05"),
			new Label("","06"),
			new Label("","07"),
			new Label("","08"),
			new Label("","09"),
			new Label("","10"),
			new Label("","11"),
			new Label("","12"),
			new Label("","13"),
			new Label("","14"),
			new Label("","15"),
			new Label("","16"),
			new Label("","17"),
			new Label("","18"),
			new Label("","19"),
			new Label("","20"),
			new Label("","21"),
			new Label("","22"),
			new Label("","23"),
			new Label("","24"),
		};
		labels[0].setTimestamp(dt0.getTime());
		labels[labels.length-1].setTimestamp(dt1.getTime());
		
		buildPosition(labels,false);
		return labels;		
	}
	
	public static void buildPosition(Label[] labels,boolean reverse) {
		if(labels == null) return;
		if(labels.length == 0) return;
		if(labels.length == 1) {
			labels[0].setPosition(0.5);
			return;
		}
		if(labels.length == 2) {
			if(reverse) {
				labels[0].setPosition(1);
				labels[1].setPosition(0);
			} else {
				labels[0].setPosition(0);
				labels[1].setPosition(1);
			}
			return;
		}
		int len = labels.length;
		
		labels[0].setPosition(1);
		double delta = 1d / (double)(len-1);
		for(int ii=1;ii<len-1;ii++) {
			double p = 1d - (delta * (double)ii);
			labels[ii].setPosition(p);
		}
		if(!reverse) {
			for(Label lbl:labels) {
				lbl.setPosition(1d - lbl.getPosition());
			}
		}
	}
	
	protected double position;
	protected String text;
	protected String text2;
	protected int line_width;
	protected double value;
	protected long timestamp;
	
	public Label(String text) {
		this.text = text;
		this.value = Util.toDbl(text);
	}
	public Label(String text,String text2) {
		this.text = text;
		this.text2 = text2;
	}
	public Label(String text,int line_width) {
		this.text = text;
		this.line_width = line_width;
	}
	
	public double getPosition() {
		return position;
	}
	public void setPosition(double position) {
		this.position = position;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getText2() {
		return text2;
	}
	public void setText2(String text2) {
		this.text2 = text2;
	}
	public int getLine_width() {
		return line_width;
	}
	public void setLine_width(int line_width) {
		this.line_width = line_width;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
