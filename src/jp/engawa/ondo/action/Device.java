package jp.engawa.ondo.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.IO;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.Entity;
import jp.engawa.gs.common.IOption;
import jp.engawa.gs.common.PropertyCopy;
import jp.engawa.ondo.common.AppAction;
import jp.engawa.ondo.common.User;

@Entity("jp.engawa.ondo.entity.OdDeviceEntity")
public class Device extends AppAction {
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
	
	protected List<IOption> shops;
	protected List<IOption> targets;


	@Override
	protected String execute(User user) throws IOException, SQLException {
		this.prepare(user);
		this.load();
		this.loadKbn();
		return null;
	}

	protected void prepare(jp.engawa.ondo.common.User user) throws SQLException {
		if(!this.isEmpty(this.device_cd)) {
			Db db = null;
			try {
				db = this.getDb();
				String sql = "SELECT ID FROM OD_DEVICE T WHERE T.DEVICE_CD=[CD] AND T.DEL_KBN=0 ORDER BY T.ID LIMIT 1";
				db.setSql(sql);
				db.add("CD", this.device_cd);
				db.execute();
				while(db.next()) {
					this.id = db.getLong(1);
				}
			} finally {
				db.close();
			}
			
		}
	}
	
	protected void loadKbn() throws SQLException {
		Db db = null;
		try {
			db = this.getDb();
			this.shops = AppAction.buildList(db, "SELECT ID,SHOP_NAME FROM OD_SHOP WHERE DEL_KBN=0 ORDER BY SHOP_CD");
			this.targets = AppAction.buildList(db, "SELECT ID,CONCAT(ALERT_NUM,' ',TARGET_NAME) FROM OD_TARGET WHERE DEL_KBN=0 ORDER BY ALERT_NUM");
		} finally {
			db.close();
		}
	}

	protected boolean load() throws SQLException {
		Db db = null;
		try {
			db = this.getDb();
			if (this.id != null && this.id > 0) {
				jp.engawa.ondo.entity.OdDeviceEntity en = new jp.engawa.ondo.entity.OdDeviceEntity();
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

	public List<IOption> getShops() {
		return shops;
	}

	public void setShops(List<IOption> shops) {
		this.shops = shops;
	}

	public List<IOption> getTargets() {
		return targets;
	}

	public void setTargets(List<IOption> targets) {
		this.targets = targets;
	}

}