package jp.engawa.ondo.action;

import java.io.IOException;
import java.sql.SQLException;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.Entity;
import jp.engawa.gs.common.NoLogin;
import jp.engawa.gs.common.PropertyCopy;
import jp.engawa.ondo.common.AppAction;
import jp.engawa.ondo.common.User;

@Entity("jp.engawa.ondo.entity.OdLogEntity")
@NoLogin
public class Log extends AppAction {
	protected Long id;
	protected String log_key;
	protected String field1;
	protected String field2;
	protected String field3;
	protected int status_kbn;
	protected String ymd;
	protected java.util.Date regist_dt;

	@Override
	protected String execute(User user) throws IOException, SQLException {
		this.prepare();
		this.load();
		return null;
	}

	protected void prepare() throws SQLException {
	}

	protected boolean load() throws SQLException {
		Db db = null;
		try {
			db = this.getDb();
			if (this.id != null && this.id > 0) {
				jp.engawa.ondo.entity.OdLogEntity en = new jp.engawa.ondo.entity.OdLogEntity();
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
	public String getLog_key() {
		return log_key;
	}
	public void setLog_key(String log_key) {
		this.log_key = log_key;
	}
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public String getField3() {
		return field3;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	}
	public int getStatus_kbn() {
		return status_kbn;
	}
	public void setStatus_kbn(int status_kbn) {
		this.status_kbn = status_kbn;
	}
	public String getYmd() {
		return ymd;
	}
	public void setYmd(String ymd) {
		this.ymd = ymd;
	}
	public java.util.Date getRegist_dt() {
		return regist_dt;
	}
	public void setRegist_dt(java.util.Date regist_dt) {
		this.regist_dt = regist_dt;
	}

}