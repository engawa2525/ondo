package jp.engawa.ondo.action;

import java.io.IOException;
import java.sql.SQLException;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.Entity;
import jp.engawa.gs.common.PropertyCopy;
import jp.engawa.ondo.common.AppAction;
import jp.engawa.ondo.common.User;

@Entity("jp.engawa.ondo.entity.OdTargetDefEntity")
public class Targetdef extends AppAction {
	protected Long id;
	protected String target_def_name;
	protected double min_temp;
	protected double max_temp;
	protected int alert_err_cnt;
	protected int normal_interval;
	protected int alert_interval;
	protected String graph_option;
	protected java.util.Date regist_dt;


	@Override
	protected String execute(User user) throws IOException, SQLException {
		this.prepare(user);
		this.load();
		return null;
	}

	protected void prepare(jp.engawa.ondo.common.User user) throws SQLException {
	}

	protected boolean load() throws SQLException {
		Db db = null;
		try {
			db = this.getDb();
			if (this.id != null && this.id > 0) {
				jp.engawa.ondo.entity.OdTargetDefEntity en = new jp.engawa.ondo.entity.OdTargetDefEntity();
				en.setKeyIdAuto(this.id);
				if (db.load(en)) {
					PropertyCopy.copyDb(en, this);
					return true;
				} else {
					this.setErrmsg("対象が存在しません。");
					return false;
				}
			} else {
				return false;
			}
		} finally {
			db.close();
		}
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTarget_def_name() {
		return target_def_name;
	}
	public void setTarget_def_name(String target_def_name) {
		this.target_def_name = target_def_name;
	}
	public double getMin_temp() {
		return min_temp;
	}
	public void setMin_temp(double min_temp) {
		this.min_temp = min_temp;
	}
	public double getMax_temp() {
		return max_temp;
	}
	public void setMax_temp(double max_temp) {
		this.max_temp = max_temp;
	}
	public int getAlert_err_cnt() {
		return alert_err_cnt;
	}
	public void setAlert_err_cnt(int alert_err_cnt) {
		this.alert_err_cnt = alert_err_cnt;
	}
	public int getNormal_interval() {
		return normal_interval;
	}
	public void setNormal_interval(int normal_interval) {
		this.normal_interval = normal_interval;
	}
	public int getAlert_interval() {
		return alert_interval;
	}
	public void setAlert_interval(int alert_interval) {
		this.alert_interval = alert_interval;
	}
	public String getGraph_option() {
		return graph_option;
	}
	public void setGraph_option(String graph_option) {
		this.graph_option = graph_option;
	}
	public java.util.Date getRegist_dt() {
		return regist_dt;
	}
	public void setRegist_dt(java.util.Date regist_dt) {
		this.regist_dt = regist_dt;
	}

}