package jp.engawa.ondo.action.shop_group;

import java.sql.SQLException;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.PropertyCopy;

public class Item {
	protected Long id;
	protected String group_cd;
	protected String group_name;
	protected String group_desc;
	protected int group_level;
	protected long super_group_id;
	protected java.util.Date regist_dt;

	public Item(jp.engawa.ondo.entity.OdShopGroupEntity en, Db db) throws SQLException {
		PropertyCopy.copyDb(en, this);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGroup_cd() {
		return group_cd;
	}
	public void setGroup_cd(String group_cd) {
		this.group_cd = group_cd;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getGroup_desc() {
		return group_desc;
	}
	public void setGroup_desc(String group_desc) {
		this.group_desc = group_desc;
	}
	public int getGroup_level() {
		return group_level;
	}
	public void setGroup_level(int group_level) {
		this.group_level = group_level;
	}
	public long getSuper_group_id() {
		return super_group_id;
	}
	public void setSuper_group_id(long super_group_id) {
		this.super_group_id = super_group_id;
	}
	public java.util.Date getRegist_dt() {
		return regist_dt;
	}
	public void setRegist_dt(java.util.Date regist_dt) {
		this.regist_dt = regist_dt;
	}

}