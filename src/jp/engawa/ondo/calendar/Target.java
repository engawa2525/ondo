package jp.engawa.ondo.calendar;

import java.sql.SQLException;

import jp.engawa.common.db.Db;

public class Target {
	//L.YMD,L.TARGET_ID,MAX(L.CUR_TMP) MAX_TMP,MIN(L.CUR_TMP) MIN_TMP,AVG(L.CUR_TMP) AVG_TMP,TARGET_NAME
	private String ymd;
	private long target_id;
	private double max_tmp;
	private double min_tmp;
	private double avg_tmp;
	private String target_name;
	
	private Event[] events;
	
	public Target(Db db) throws SQLException {
		this.ymd = db.get("YMD");
		this.target_id = db.getLong("TARGET_ID");
		this.max_tmp = db.getDouble("MAX_TMP");
		this.min_tmp = db.getDouble("MIN_TMP");
		this.avg_tmp = db.getDouble("AVG_TMP");
		this.target_name = db.get("TARGET_NAME");
	}
	
	public boolean isHas_event() {
		if(this.events == null) return false;
		if(this.events.length == 0) return false;
		return true;
	}
	public int getEvent_status() {
		if(!this.isHas_event()) {
			return 0;
		}
		Event[] events = this.getEvents();
		for(Event e:events) {
			if(e.getEvent_status() == 0) {
				return 1;
			}
		}
		return 2;
	}
	
	
	protected void add(Event item) {
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
	}


	public String getYmd() {
		return ymd;
	}

	public void setYmd(String ymd) {
		this.ymd = ymd;
	}

	public long getTarget_id() {
		return target_id;
	}

	public void setTarget_id(long target_id) {
		this.target_id = target_id;
	}

	public double getMax_tmp() {
		return max_tmp;
	}

	public void setMax_tmp(double max_tmp) {
		this.max_tmp = max_tmp;
	}

	public double getMin_tmp() {
		return min_tmp;
	}

	public void setMin_tmp(double min_tmp) {
		this.min_tmp = min_tmp;
	}

	public double getAvg_tmp() {
		return avg_tmp;
	}

	public void setAvg_tmp(double avg_tmp) {
		this.avg_tmp = avg_tmp;
	}

	public Event[] getEvents() {
		return events;
	}

	public void setEvents(Event[] events) {
		this.events = events;
	}

	public String getTarget_name() {
		return target_name;
	}

	public void setTarget_name(String target_name) {
		this.target_name = target_name;
	}
}
