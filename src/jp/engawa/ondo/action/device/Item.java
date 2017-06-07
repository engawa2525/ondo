package jp.engawa.ondo.action.device;

import java.sql.SQLException;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.PropertyCopy;

public class Item {
	protected Long id;
	protected String device_cd;
	protected int device_type;
	protected long shop_id;
	protected long target_id;
	protected int device_status;
	protected java.util.Date start_dt;
	protected java.util.Date end_dt;
	protected java.util.Date last_access;
	protected java.util.Date regist_dt;

	public Item(jp.engawa.ondo.entity.OdDeviceEntity en, Db db) throws SQLException {
		PropertyCopy.copyDb(en, this);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDevice_cd() {
		return device_cd;
	}
	public void setDevice_cd(String device_cd) {
		this.device_cd = device_cd;
	}
	public int getDevice_type() {
		return device_type;
	}
	public void setDevice_type(int device_type) {
		this.device_type = device_type;
	}
	public long getShop_id() {
		return shop_id;
	}
	public void setShop_id(long shop_id) {
		this.shop_id = shop_id;
	}
	public long getTarget_id() {
		return target_id;
	}
	public void setTarget_id(long target_id) {
		this.target_id = target_id;
	}
	public int getDevice_status() {
		return device_status;
	}
	public void setDevice_status(int device_status) {
		this.device_status = device_status;
	}
	public java.util.Date getStart_dt() {
		return start_dt;
	}
	public void setStart_dt(java.util.Date start_dt) {
		this.start_dt = start_dt;
	}
	public java.util.Date getEnd_dt() {
		return end_dt;
	}
	public void setEnd_dt(java.util.Date end_dt) {
		this.end_dt = end_dt;
	}
	public java.util.Date getLast_access() {
		return last_access;
	}
	public void setLast_access(java.util.Date last_access) {
		this.last_access = last_access;
	}
	public java.util.Date getRegist_dt() {
		return regist_dt;
	}
	public void setRegist_dt(java.util.Date regist_dt) {
		this.regist_dt = regist_dt;
	}

}