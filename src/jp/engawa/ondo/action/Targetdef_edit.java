package jp.engawa.ondo.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import jp.engawa.common.db.Db;
import jp.engawa.ondo.common.AdminLevel;
import jp.engawa.ondo.common.User;

@AdminLevel("developer")
public class Targetdef_edit extends Targetdef {
	@Override
	protected String execute(User user) throws IOException,SQLException {
		prepare_edit(user);
		if(this.isPost()) {
			if("del".equals(this.getCmd())) {
				if(del()) {
					this.info("削除しました。");					
					this.setRedirect("./targetdefs.do");
					return null;
				}
			} else {
				if(upd()) {
					this.info("更新しました。");
					this.setRedirect("./targetdef.do?id=" + this.id);
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
				jp.engawa.ondo.entity.OdTargetDefEntity en = new jp.engawa.ondo.entity.OdTargetDefEntity();
				en.setKeyIdAuto(this.id);
				if(db.load(en)) {
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
				jp.engawa.ondo.entity.OdTargetDefEntity en = new jp.engawa.ondo.entity.OdTargetDefEntity();
				en.setKeyIdAuto(this.id);
				if(db.load(en)) {
					en.setColTargetDefName(this.getTarget_def_name());
					en.setColAlertErrCnt(this.getAlert_err_cnt());
					en.setColNormalInterval(this.getNormal_interval());
					en.setColAlertInterval(this.getAlert_interval());
					en.setColGraphOption(this.getGraph_option());
					en.setColMinTemp(this.getMin_temp());
					en.setColMaxTemp(this.getMax_temp());
					db.update(en);
					return true;
				}
			} else {
				jp.engawa.ondo.entity.OdTargetDefEntity en = new jp.engawa.ondo.entity.OdTargetDefEntity();
				en.setColTargetDefName(this.getTarget_def_name());
				en.setColAlertErrCnt(this.getAlert_err_cnt());
				en.setColNormalInterval(this.getNormal_interval());
				en.setColAlertInterval(this.getAlert_interval());
				en.setColGraphOption(this.getGraph_option());
				en.setColMinTemp(this.getMin_temp());
				en.setColMaxTemp(this.getMax_temp());
				en.setColRegistDt(new Date());
				this.id = db.insert(en);
				return true;
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
			String sql = "UPDATE OD_TARGET_DEF SET DEL_KBN=1 WHERE ID=[ID]";
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