package jp.engawa.ondo.action;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.IOption;
import jp.engawa.ondo.calendar.EventCalendar;
import jp.engawa.ondo.common.AppAction;
import jp.engawa.ondo.common.User;

public class Top extends AppAction {
	private EventCalendar calendar;
	private String ym;
	private List<jp.engawa.ondo.action.top.Event> events = new ArrayList<>();
	private List<IOption> shops;
	private List<IOption> targets;
	
	@Override
	protected String execute(User user) throws IOException, SQLException {
		prepare();
		load();
		this.loadEvents();
		return null;
	}
	
	protected void prepare() throws IOException,SQLException {
		if(this.isEmpty(this.ym)) {
			this.ym = new SimpleDateFormat("yyyyMM").format(new Date());
		}
	}
	
	private void load() throws SQLException {
		Db db = null;
		try {
			db = this.getDb();
			EventCalendar g = new EventCalendar();
			g.setYm(this.ym);
			g.build(db);
			this.calendar = g;
			
			loadKbn(db);
		} finally {
			db.close();
		}
	}
	
	private void loadKbn(Db db) throws SQLException {
		this.shops = AppAction.buildList(db, "SELECT ID,SHOP_NAME FROM OD_SHOP WHERE DEL_KBN=0 ORDER BY SHOP_CD");
		this.targets = AppAction.buildList(db, "SELECT ID,TARGET_NAME FROM OD_TARGET WHERE DEL_KBN=0 ORDER BY TARGET_CD");
	}
	
	private void loadEvents() throws SQLException {
		Db db = null;
		try {
			db = this.getDb();
			String sql = "SELECT * FROM OD_EVENT WHERE DEL_KBN=0 AND EVENT_STATUS=0 ORDER BY EVENT_DT DESC,ID DESC";
			db.setSql(sql);
			db.execute(jp.engawa.ondo.entity.OdEventEntity.class);
			while(db.next()){
				jp.engawa.ondo.entity.OdEventEntity en = (jp.engawa.ondo.entity.OdEventEntity)db.getEntity();
				this.events.add(new jp.engawa.ondo.action.top.Event(en,db));
			}
		} finally {
			db.close();
		}
	}
	
	
	public String getNext_ym() {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(new SimpleDateFormat("yyyyMMdd").parse(this.ym + "01"));
			cal.add(Calendar.MONTH, +1);
			return new SimpleDateFormat("yyyyMM").format(cal.getTime());
		} catch(Exception ex) {
			return "";
		}
	}
	
	public String getPrev_ym() {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(new SimpleDateFormat("yyyyMMdd").parse(this.ym + "01"));
			cal.add(Calendar.MONTH, -1);
			return new SimpleDateFormat("yyyyMM").format(cal.getTime());
		} catch(Exception ex) {
			return "";
		}
	}

	public String getCalendar() {
		return calendar.getText();
	}

	public String getYmStr() {
		return this.ym.substring(0, 4) + "/" + this.ym.substring(4, 6);
	}
	
	public String getYm() {
		return ym;
	}

	public void setYm(String ym) {
		this.ym = ym;
	}

	public List<jp.engawa.ondo.action.top.Event> getEvents() {
		return events;
	}

	public void setEvents(List<jp.engawa.ondo.action.top.Event> events) {
		this.events = events;
	}

	public List<IOption> getShops() {
		return shops;
	}

	public void setShops(List<IOption> shops) {
		this.shops = shops;
	}

	public List<IOption> getTargets() {
		return targets;
	}

	public void setTargets(List<IOption> targets) {
		this.targets = targets;
	}
}
