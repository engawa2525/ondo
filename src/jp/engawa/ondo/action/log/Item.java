package jp.engawa.ondo.action.log;

import java.sql.SQLException;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.PropertyCopy;

public class Item {
	protected Long id;
	protected String device_cd;
	protected long target_id;
	protected String field1;
	protected String field2;
	protected String field3;
	protected int status_kbn;
	protected String ymd;
	protected java.util.Date regist_dt;

	public Item(jp.engawa.ondo.entity.OdLogEntity en, Db db) throws SQLException {
		PropertyCopy.copyDb(en, this);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLog_key() {
		return device_cd;
	}
	public void setLog_key(String device_cd) {
		this.device_cd = device_cd;
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
	public long getTarget_id() {
		return target_id;
	}
	public void setTarget_id(long target_id) {
		this.target_id = target_id;
	}

}