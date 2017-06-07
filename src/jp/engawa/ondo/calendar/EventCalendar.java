package jp.engawa.ondo.calendar;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.Util;
import jp.engawa.ondo.entity.OdEventEntity;

public class EventCalendar {
	protected String ym;
	
	protected Week[] weeks;
	
	public void build(Db db) throws SQLException {
		String ymd0 = Util.toYmd(this.ym + "01", false);
		Date dt0 = Util.toDate(ymd0);
		Calendar c = Calendar.getInstance();
		c.setTime(dt0);
		int m0 = c.get(Calendar.MONTH);
		int m = m0;
		while(m == m0) {
			String ymd = Util.toYmd(c.getTime());
			this.add(ymd);
			c.add(Calendar.DATE, +1);
			m = c.get(Calendar.MONTH);
		}
		if(weeks != null) {
			for(Week w:weeks) {
				w.adjust();
			}
		}
		this.clear();
		loadTarget(db);
		loadEvent(db);
	}
	public void loadEvent(Db db) throws SQLException {
		String sql = "SELECT * FROM OD_EVENT WHERE DEL_KBN=0 AND YMD LIKE [YM] ORDER BY EVENT_STATUS,YMD,ID";
		db.setSql(sql);
		db.add("YM", this.ym + "%");
		db.execute(OdEventEntity.class);
		while(db.next()) {
			OdEventEntity en = (OdEventEntity)db.getEntity();
			Day d = this.find(en.getColYmd());
			if(d != null) {
				Event e = new Event(en);
				d.add(e);
			}
		}
	}
	public void loadTarget(Db db) throws SQLException {
		String sql = "SELECT L.YMD,L.TARGET_ID,MAX(L.CUR_TMP) MAX_TMP,MIN(L.CUR_TMP) MIN_TMP,AVG(L.CUR_TMP) AVG_TMP,TARGET_NAME FROM OD_TARGET_LOG L LEFT OUTER JOIN OD_TARGET T ON L.TARGET_ID=T.ID WHERE L.YMD LIKE [YM] GROUP BY L.YMD,L.TARGET_ID";
		db.setSql(sql);
		db.add("YM", this.ym + "%");
		db.execute(OdEventEntity.class);
		while(db.next()) {
			String ymd = db.get("YMD");
			Day d = this.find(ymd);
			if(d != null) {
				d.add(new Target(db));
			}
		}
	}
	public String getText() {
		StringBuilder sb = new StringBuilder();
		sb.append("<table class=\"event_calendar\">\n");
		sb.append("<tr>");
		sb.append("<th class=\"date1\">日</th>");
		sb.append("<th class=\"date2\">月</th>");
		sb.append("<th class=\"date3\">火</th>");
		sb.append("<th class=\"date4\">水</th>");
		sb.append("<th class=\"date5\">木</th>");
		sb.append("<th class=\"date6\">金</th>");
		sb.append("<th class=\"date7\">土</th>");
		sb.append("</tr>\n");
		Week[] weeks = this.getWeeks();
		for(Week w:weeks) {
			sb.append(w.getText());
		}
		sb.append("</table>\n");
		return sb.toString();
	}
	
	public Day find(String ymd) {
		if(this.weeks == null) return null;
		for(Week w:this.weeks) {
			Day d = w.find(ymd);
			if(d != null) {
				return d;
			}
		}
		return  null;
	}
	public Week findWeek(int week) {
		if(this.weeks == null) return null;
		for(Week w:this.weeks) {
			if(w.getWeek_of_year() == week) {
				return w;
			}
		}
		return  null;
	}
	public void add(String ymd) {
		Date dt = Util.toDate(ymd);
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		int week = c.get(Calendar.WEEK_OF_YEAR);
		Week w = this.findWeek(week);
		if(w == null) {
			w = new Week(week);
			this.add(w);
		}
		w.add(ymd);
	}
	public void clear() {
		Week[] weeks = this.getWeeks();
		for(Week w:weeks) {
			w.clear();
		}
	}
	protected void add(Week item) {
		if (this.weeks == null) {
			this.weeks = new Week[1];
			this.weeks[0] = item;
		} else {
			int len = this.weeks.length;
			Week[] arr = new Week[len + 1];
			System.arraycopy(this.weeks, 0, arr, 0, len);
			arr[len] = item;
			this.weeks = arr;
		}
	}

	
	public String getYm() {
		return ym;
	}

	public void setYm(String ym) {
		this.ym = ym;
	}

	public Week[] getWeeks() {
		if(this.weeks == null) return new Week[0];
		return weeks;
	}

	public void setWeeks(Week[] weeks) {
		this.weeks = weeks;
	}
}
