package jp.engawa.ondo.calendar;

import java.sql.SQLException;

import jp.engawa.gs.common.PropertyCopy;

public class Event {
	protected Long id;
	protected int event_status;
	protected long device_id;
	protected long shop_id;
	protected long target_id;
	protected java.util.Date event_dt;
	protected String event_cd;
	protected String event_name;
	protected String event_info;
	protected int alert_status;
	protected java.util.Date status_dt;
	protected java.util.Date alert_dt;
	protected int mail_status;
	protected java.util.Date mail_dt;
	protected java.util.Date regist_dt;
	protected String ymd;

	public Event(jp.engawa.ondo.entity.OdEventEntity en) throws SQLException {
		PropertyCopy.copyDb(en, this);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getEvent_status() {
		return event_status;
	}

	public void setEvent_status(int event_status) {
		this.event_status = event_status;
	}

	public long getDevice_id() {
		return device_id;
	}

	public void setDevice_id(long device_id) {
		this.device_id = device_id;
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

	public java.util.Date getEvent_dt() {
		return event_dt;
	}

	public void setEvent_dt(java.util.Date event_dt) {
		this.event_dt = event_dt;
	}

	public String getEvent_cd() {
		return event_cd;
	}

	public void setEvent_cd(String event_cd) {
		this.event_cd = event_cd;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getEvent_info() {
		return event_info;
	}

	public void setEvent_info(String event_info) {
		this.event_info = event_info;
	}

	public int getAlert_status() {
		return alert_status;
	}

	public void setAlert_status(int alert_status) {
		this.alert_status = alert_status;
	}

	public java.util.Date getStatus_dt() {
		return status_dt;
	}

	public void setStatus_dt(java.util.Date status_dt) {
		this.status_dt = status_dt;
	}

	public java.util.Date getAlert_dt() {
		return alert_dt;
	}

	public void setAlert_dt(java.util.Date alert_dt) {
		this.alert_dt = alert_dt;
	}

	public int getMail_status() {
		return mail_status;
	}

	public void setMail_status(int mail_status) {
		this.mail_status = mail_status;
	}

	public java.util.Date getMail_dt() {
		return mail_dt;
	}

	public void setMail_dt(java.util.Date mail_dt) {
		this.mail_dt = mail_dt;
	}

	public java.util.Date getRegist_dt() {
		return regist_dt;
	}

	public void setRegist_dt(java.util.Date regist_dt) {
		this.regist_dt = regist_dt;
	}

	public String getYmd() {
		return ymd;
	}

	public void setYmd(String ymd) {
		this.ymd = ymd;
	}
}
