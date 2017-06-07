package jp.engawa.ondo.action.shop;

import java.sql.SQLException;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.PropertyCopy;
import jp.engawa.gs.common.Util;

public class Item {
	protected Long id;
	protected String shop_cd;
	protected String shop_name;
	protected String mail_addr;
	protected String open_ymd;
	protected String close_ymd;
	protected int alert_status;
	protected java.util.Date regist_dt;

	public Item(jp.engawa.ondo.entity.OdShopEntity en, Db db) throws SQLException {
		PropertyCopy.copyDb(en, this);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getShop_cd() {
		return shop_cd;
	}
	public void setShop_cd(String shop_cd) {
		this.shop_cd = shop_cd;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getMail_addr() {
		return mail_addr;
	}
	public void setMail_addr(String mail_addr) {
		this.mail_addr = mail_addr;
	}
	public String getOpen_ymd() {
		return Util.toYmdHaihun(open_ymd);
	}
	public void setOpen_ymd(String open_ymd) {
		this.open_ymd = open_ymd;
	}
	public String getClose_ymd() {
		return Util.toYmdHaihun(close_ymd);
	}
	public void setClose_ymd(String close_ymd) {
		this.close_ymd = close_ymd;
	}
	public int getAlert_status() {
		return alert_status;
	}
	public void setAlert_status(int alert_status) {
		this.alert_status = alert_status;
	}
	public java.util.Date getRegist_dt() {
		return regist_dt;
	}
	public void setRegist_dt(java.util.Date regist_dt) {
		this.regist_dt = regist_dt;
	}

}