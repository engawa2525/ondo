package jp.engawa.ondo.action.target;

import java.sql.SQLException;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.PropertyCopy;

public class Item {
	protected Long id;
	protected String target_cd;
	protected long shop_id;
	protected String target_name;
	protected String target_desc;
	protected int target_status;
	protected String status_msg;
	protected double min_temp;
	protected double max_temp;
	protected int err_cnt;
	protected java.util.Date last_report;
	protected double current_temp;
	protected long last_log_id;
	protected int alert_num;
	protected long target_def_id;	
	protected java.util.Date regist_dt;

	public Item(jp.engawa.ondo.entity.OdTargetEntity en, Db db) throws SQLException {
		PropertyCopy.copyDb(en, this);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTarget_cd() {
		return target_cd;
	}
	public void setTarget_cd(String target_cd) {
		this.target_cd = target_cd;
	}
	public long getShop_id() {
		return shop_id;
	}
	public void setShop_id(long shop_id) {
		this.shop_id = shop_id;
	}
	public String getTarget_name() {
		return target_name;
	}
	public void setTarget_name(String target_name) {
		this.target_name = target_name;
	}
	public String getTarget_desc() {
		return target_desc;
	}
	public void setTarget_desc(String target_desc) {
		this.target_desc = target_desc;
	}
	public int getTarget_status() {
		return target_status;
	}
	public void setTarget_status(int target_status) {
		this.target_status = target_status;
	}
	public String getStatus_msg() {
		return status_msg;
	}
	public void setStatus_msg(String status_msg) {
		this.status_msg = status_msg;
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
	public int getErr_cnt() {
		return err_cnt;
	}
	public void setErr_cnt(int err_cnt) {
		this.err_cnt = err_cnt;
	}
	public java.util.Date getLast_report() {
		return last_report;
	}
	public void setLast_report(java.util.Date last_report) {
		this.last_report = last_report;
	}
	public double getCurrent_temp() {
		return current_temp;
	}
	public void setCurrent_temp(double current_temp) {
		this.current_temp = current_temp;
	}
	public long getLast_log_id() {
		return last_log_id;
	}
	public void setLast_log_id(long last_log_id) {
		this.last_log_id = last_log_id;
	}
	public int getAlert_num() {
		return alert_num;
	}
	public void setAlert_num(int alert_num) {
		this.alert_num = alert_num;
	}
	public java.util.Date getRegist_dt() {
		return regist_dt;
	}
	public void setRegist_dt(java.util.Date regist_dt) {
		this.regist_dt = regist_dt;
	}
	public long getTarget_def_id() {
		return target_def_id;
	}
	public void setTarget_def_id(long target_def_id) {
		this.target_def_id = target_def_id;
	}

}