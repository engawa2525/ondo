package jp.engawa.ondo.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.IList;
import jp.engawa.gs.common.Util;
import jp.engawa.ondo.action.target.TargetLog;
import jp.engawa.ondo.common.User;
import jp.engawa.ondo.entity.OdTargetDefEntity;
import jp.engawa.ondo.entity.OdTargetEntity;
import jp.engawa.ondo.graph.Graph;
import jp.engawa.ondo.graph.GraphOption;
import net.arnx.jsonic.JSON;

public class Target_log extends Target implements IList {
	private String ymd;
	private Graph graph;
	
	private List<jp.engawa.ondo.action.target_log.Event> events = new ArrayList<>();
	
	private List<TargetLog> list = new ArrayList<>();
	
	@Override
	protected String execute(User user) throws IOException, SQLException {
		this.prepare(user);
		this.load();
		this.loadKbn();
		this.loadList();
		this.loadEvents();

		this.buildGraph();
		
		return null;		
	}
	@Override
	protected void prepare(User user) throws SQLException {
		super.prepare(user);
		
		if(this.isEmpty(this.ymd)) {
			this.ymd = Util.toYmd(new Date());
		}
	}

	private void buildGraph() throws SQLException {
		Graph g = new Graph();
		Db db = null;
		try {
			db = this.getDb();
			double min = -30;
			double max = 30;
			OdTargetEntity ten = new OdTargetEntity();
			ten.setKeyIdAuto(this.id);
			if(db.load(ten)) {
				long def_id = ten.getColTargetDefId();
				if(def_id > 0) {
					OdTargetDefEntity den = new OdTargetDefEntity();
					den.setKeyIdAuto(def_id);
					if(db.load(den)) {
						String option = den.getColGraphOption();
						GraphOption op = null;
						try {
							if(!this.isEmpty(option)) {
								op = JSON.decode(option, GraphOption.class);
								max = op.getRange_max();
								min = op.getRange_min();
							}
						} catch(Exception ex) {
						}
					}
				}
			}
			
			String sql = "SELECT T.* FROM OD_TARGET_LOG T WHERE T.DEL_KBN=0 AND T.YMD=[YMD] AND T.TARGET_ID=[TID] ORDER BY T.LOG_DT,T.ID";
			db.setSql(sql);
			db.add("YMD", this.ymd);
			db.add("TID", this.id);
			db.execute(jp.engawa.ondo.entity.OdTargetLogEntity.class);
			g.build(this.ymd, db, min, max);
		} finally {
			db.close();
		}
		this.graph = g;
	}
	
	private void loadEvents() throws SQLException {
		Db db = null;
		try {
			db = this.getDb();
			String sql = "SELECT * FROM OD_EVENT WHERE TARGET_ID=[TID] ORDER BY EVENT_DT DESC,ID DESC";
			db.setSql(sql);
			db.add("TID", this.id);
			db.execute(jp.engawa.ondo.entity.OdEventEntity.class);
			while(db.next()){
				jp.engawa.ondo.entity.OdEventEntity en = (jp.engawa.ondo.entity.OdEventEntity)db.getEntity();
				this.events.add(new jp.engawa.ondo.action.target_log.Event(en,db));
			}
		} finally {
			db.close();
		}
	}
	
	private void loadList() throws SQLException {
		Db db = null;
		try {
			db = this.getDb();
			String sql = "SELECT T.* FROM OD_TARGET_LOG T WHERE T.DEL_KBN=0 AND T.YMD=[YMD] AND T.TARGET_ID=[TID] ORDER BY T.LOG_DT DESC,T.ID";
			db.setSql(sql);
			db.add("YMD", this.ymd);
			db.add("TID", this.id);
			db.execute(jp.engawa.ondo.entity.OdTargetLogEntity.class);
			while(db.next()) {
				jp.engawa.ondo.entity.OdTargetLogEntity en = (jp.engawa.ondo.entity.OdTargetLogEntity)db.getEntity();
				this.list.add(new TargetLog(en,db));
			}
		} finally {
			db.close();
		}		
	}
	

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iterator() {
		return list.iterator();
	}
	public String getYmd() {
		return Util.toYmdHaihun(ymd);
	}
	public void setYmd(String ymd) {
		this.ymd = Util.toYmd(ymd,false);
	}
	
	public String getGraph() {
		if(this.graph == null) return "";
		return this.graph.getText();
	}
	public List<jp.engawa.ondo.action.target_log.Event> getEvents() {
		return events;
	}
	public void setEvents(List<jp.engawa.ondo.action.target_log.Event> events) {
		this.events = events;
	}
	
}
