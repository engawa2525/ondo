package jp.engawa.ondo.action;

import java.io.IOException;
import java.sql.SQLException;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.Entity;
import jp.engawa.gs.common.PropertyCopy;
import jp.engawa.ondo.common.AppAction;

@Entity("jp.engawa.ondo.entity.OdUserEntity")
public class User extends AppAction {
	protected Long id;
	protected String name;
	protected String account_key;
	protected String account_psw;
	protected int admin_kbn;
	protected int psw_kbn;
	protected java.util.Date psw_change_dt;
	protected long shop_id;
	protected long group_id;
	protected java.util.Date regist_dt;

	@Override
	protected String execute(jp.engawa.ondo.common.User user) throws IOException, SQLException {
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
				jp.engawa.ondo.entity.OdUserEntity en = new jp.engawa.ondo.entity.OdUserEntity();
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount_key() {
		return account_key;
	}
	public void setAccount_key(String account_key) {
		this.account_key = account_key;
	}
	public String getAccount_psw() {
		return account_psw;
	}
	public void setAccount_psw(String account_psw) {
		this.account_psw = account_psw;
	}
	public int getAdmin_kbn() {
		return admin_kbn;
	}
	public void setAdmin_kbn(int admin_kbn) {
		this.admin_kbn = admin_kbn;
	}
	public int getPsw_kbn() {
		return psw_kbn;
	}
	public void setPsw_kbn(int psw_kbn) {
		this.psw_kbn = psw_kbn;
	}
	public java.util.Date getPsw_change_dt() {
		return psw_change_dt;
	}
	public void setPsw_change_dt(java.util.Date psw_change_dt) {
		this.psw_change_dt = psw_change_dt;
	}
	public long getShop_id() {
		return shop_id;
	}
	public void setShop_id(long shop_id) {
		this.shop_id = shop_id;
	}
	public long getGroup_id() {
		return group_id;
	}
	public void setGroup_id(long group_id) {
		this.group_id = group_id;
	}
	public java.util.Date getRegist_dt() {
		return regist_dt;
	}
	public void setRegist_dt(java.util.Date regist_dt) {
		this.regist_dt = regist_dt;
	}

}