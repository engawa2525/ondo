package jp.engawa.ondo.calendar;

import java.util.Calendar;

import jp.engawa.gs.common.Util;

public class Day {
	private String ymd;
	private int yobi;
	private int day;
	private boolean current;
	
	private Event[] events;
	private Target[] targets;
	
	public Day(){}
	public Day(String ymd) {
		this.ymd = ymd;
		Calendar c = Calendar.getInstance();
		c.setTime(Util.toDate(this.ymd));
		this.yobi = c.get(Calendar.DAY_OF_WEEK);
		this.day = c.get(Calendar.DAY_OF_MONTH);
		this.current = true;
	}
	public void clear() {
	}
	public String getHeader() {
		StringBuilder sb = new StringBuilder();
		sb.append("<td ");
		sb.append(" class=\"");
		sb.append("day_head");
		if(this.current) {
			sb.append(" cur_body");
		} else {
			sb.append(" dummy_body");
		}
		sb.append("\"");
		sb.append(">");
		if(this.current) {
			sb.append(this.day);
		}
		sb.append("</td>");
		return sb.toString();
	}
	public String getText() {
		StringBuilder sb = new StringBuilder();
		sb.append("<td ");
		sb.append(" class=\"");
		sb.append("day_body");
		if(this.current) {
			sb.append(" cur_body");
		} else {
			sb.append(" dummy_body");
		}
		sb.append("\"");
		sb.append(">");
		
		Target[] ts = this.getTargets();
		for(Target t:ts) {
			sb.append("<div class=\"target\">");
			sb.append("<a class=\"");
			sb.append("event" + t.getEvent_status());
			sb.append("\" ");
			sb.append(" title=\"");
			sb.append(t.getTarget_name());
			sb.append("\" ");
			sb.append(" href=\"");
			//http://localhost:8080/ondo/action/target_log.do?id=4&ymd=20170321
			sb.append("target_log.do?id=" + t.getTarget_id() + "&ymd=" + this.ymd);
			sb.append("\">");
			/*
			sb.append(t.getTarget_name());
			*/
			sb.append("</a>");
			sb.append("</div>\n");
		}
		
		sb.append("</td>");
		return sb.toString();
	}
	public Target findTarget(long target_id) {
		Target[] ts = this.getTargets();
		for(Target t:ts) {
			if(t.getTarget_id() == target_id) {
				return t;
			}
		}
		return null;
	}
	public void add(Event item) {
		if (this.events == null) {
			this.events = new Event[1];
			this.events[0] = item;
		} else {
			int len = this.events.length;
			Event[] arr = new Event[len + 1];
			System.arraycopy(this.events, 0, arr, 0, len);
			arr[len] = item;
			this.events = arr;
		}
		Target t = this.findTarget(item.getTarget_id());
		if(t != null) {
			t.add(item);
		}
	}
	public void add(Target item) {
		if (this.targets == null) {
			this.targets = new Target[1];
			this.targets[0] = item;
		} else {
			int len = this.targets.length;
			Target[] arr = new Target[len + 1];
			System.arraycopy(this.targets, 0, arr, 0, len);
			arr[len] = item;
			this.targets = arr;
		}
	}



	public String getYmd() {
		return ymd;
	}

	public void setYmd(String ymd) {
		this.ymd = ymd;
	}

	public int getYobi() {
		return yobi;
	}

	public void setYobi(int yobi) {
		this.yobi = yobi;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}

	public Event[] getEvents() {
		return events;
	}

	public void setEvents(Event[] events) {
		this.events = events;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public Target[] getTargets() {
		if(this.targets == null) return new Target[0];
		return targets;
	}
	public void setTargets(Target[] targets) {
		this.targets = targets;
	}
}
