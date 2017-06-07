package jp.engawa.ondo.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.Entity;
import jp.engawa.gs.common.IOption;
import jp.engawa.gs.common.PropertyCopy;
import jp.engawa.ondo.common.AppAction;
import jp.engawa.ondo.common.User;

@Entity("jp.engawa.ondo.entity.OdShopGroupEntity")
public class Shop_group extends AppAction {
	protected Long id;
	protected String group_cd;
	protected String group_name;
	protected String group_desc;
	protected int group_level;
	protected long super_group_id;
	protected int shop_add;
	protected java.util.Date regist_dt;

	protected List<IOption> groups = new ArrayList<>();

	@Override
	protected String execute(User user) throws IOException, SQLException {
		this.prepare(user);
		this.load();
		this.loadKbn();
		return null;
	}

	protected void prepare(jp.engawa.ondo.common.User user) throws SQLException {
	}
	
	protected void loadKbn() throws SQLException {
		Db db = null;
		try {
			db = this.getDb();
			this.groups = AppAction.buildList(db, "SELECT ID,CONCAT(GROUP_CD,' ',GROUP_NAME) FROM OD_SHOP_GROUP WHERE DEL_KBN=0 ORDER BY GROUP_CD");
		} finally {
			db.close();
		}
	}

	protected boolean load() throws SQLException {
		Db db = null;
		try {
			db = this.getDb();
			if (this.id != null && this.id > 0) {
				jp.engawa.ondo.entity.OdShopGroupEntity en = new jp.engawa.ondo.entity.OdShopGroupEntity();
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

	public List<IOption> getGroups() {
		return groups;
	}

	public void setGroups(List<IOption> groups) {
		this.groups = groups;
	}

	public int getShop_add() {
		return shop_add;
	}

	public void setShop_add(int shop_add) {
		this.shop_add = shop_add;
	}

}