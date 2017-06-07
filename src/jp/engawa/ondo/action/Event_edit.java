package jp.engawa.ondo.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import jp.engawa.common.db.Db;
import jp.engawa.ondo.common.AdminLevel;
import jp.engawa.ondo.common.User;

@AdminLevel("developer")
public class Event_edit extends Event {
	@Override
	protected String execute(User user) throws IOException,SQLException {
		prepare_edit(user);
		if(this.isPost()) {
			if("del".equals(this.getCmd())) {
				if(del()) {
					this.info("削除しました。");					
					this.setRedirect("./events.do");
					return null;
				}
			} else {
				if(upd()) {
					this.info("更新しました。");
					this.setRedirect("./event.do?id=" + this.id);
					return null;
				} else {
					invalidLoad();
				}
			}
		}
		if(this.isGet()) {
			if(this.id != null && this.id > 0) {
				this.load();
			} else {
				init_edit(user);
			}
		}
		this.loadKbn();
		return null;
	}
	
	public boolean isUpd() {
		if(this.id != null && this.id > 0) {
			return true;
		}
		return false;
	}
	protected void init_edit(User user) throws SQLException,IOException {
	}
	protected void prepare_edit(User user) throws SQLException,IOException {
	}
	
	protected void invalidLoad() throws SQLException {
		Db db = null;
		try {
			db = this.getDb();
			if(this.id != null && this.id > 0) {
				jp.engawa.ondo.entity.OdEventEntity en = new jp.engawa.ondo.entity.OdEventEntity();
				en.setKeyIdAuto(this.id);
				if(db.load(en)) {
					this.shop_id = en.getColShopId();
					this.target_id = en.getColTargetId();
					this.regist_dt = en.getColRegistDt();
				}
			}
		} finally {
			db.close();
		}
	}
	
	protected boolean upd() throws SQLException,IOException {
		Db db = null;
		try {
			db = this.getDb();
			if(!validate(db)) {
				return false;
			}
			if(this.isUpd()) {
				jp.engawa.ondo.entity.OdEventEntity en = new jp.engawa.ondo.entity.OdEventEntity();
				en.setKeyIdAuto(this.id);
				if(db.load(en)) {
					en.setColEventStatus(this.getEvent_status());
					en.setColAlertStatus(this.getAlert_status());
					en.setColMailStatus(this.getMail_status());
					db.update(en);
					return true;
				}
			}
		} finally {
			db.close();
		}
		return true;
	}
	protected boolean del() throws SQLException,IOException {
		Db db = null;
		try {
			db = this.getDb();
			if(this.id == null || this.id <= 0) {
				this.setErrmsg("データが特定できませんでした。");
				return false;
			}
			String sql = "UPDATE OD_EVENT SET DEL_KBN=1 WHERE ID=[ID]";
			db.setSql(sql);
			db.add("ID",this.id);
			db.update();
			return true;
		} finally {
			db.close();
		}
	}
	
	protected boolean validate(Db db) throws SQLException {
		return true;
	}
}