package jp.engawa.ondo.action.tlog;

import java.sql.SQLException;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.PropertyCopy;

public class Item {
	protected Long id;
	protected long target_id;
	protected long shop_id;
	protected long device_id;
	protected String log_key;
	protected double cur_tmp;
	protected java.util.Date log_dt;
	protected long event_id;
	protected int event_status;
	protected long log_id;
	protected java.util.Date regist_dt;

	public Item(jp.engawa.ondo.entity.OdTargetLogEntity en, Db db) throws SQLException {
		PropertyCopy.copyDb(en, this);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getTarget_id() {
		return target_id;
	}
	public void setTarget_id(long target_id) {
		this.target_id = target_id;
	}
	public long getShop_id() {
		return shop_id;
	}
	public void setShop_id(long shop_id) {
		this.shop_id = shop_id;
	}
	public long getDevice_id() {
		return device_id;
	}
	public void setDevice_id(long device_id) {
		this.device_id = device_id;
	}
	public String getLog_key() {
		return log_key;
	}
	public void setLog_key(String log_key) {
		this.log_key = log_key;
	}
	public double getCur_tmp() {
		return cur_tmp;
	}
	public void setCur_tmp(double cur_tmp) {
		this.cur_tmp = cur_tmp;
	}
	public java.util.Date getLog_dt() {
		return log_dt;
	}
	public void setLog_dt(java.util.Date log_dt) {
		this.log_dt = log_dt;
	}
	public long getEvent_id() {
		return event_id;
	}
	public void setEvent_id(long event_id) {
		this.event_id = event_id;
	}
	public int getEvent_status() {
		return event_status;
	}
	public void setEvent_status(int event_status) {
		this.event_status = event_status;
	}
	public long getLog_id() {
		return log_id;
	}
	public void setLog_id(long log_id) {
		this.log_id = log_id;
	}
	public java.util.Date getRegist_dt() {
		return regist_dt;
	}
	public void setRegist_dt(java.util.Date regist_dt) {
		this.regist_dt = regist_dt;
	}

}