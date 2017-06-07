package jp.engawa.ondo.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import jp.engawa.common.db.Db;
import jp.engawa.ondo.common.AdminLevel;
import jp.engawa.ondo.common.User;
import jp.engawa.ondo.entity.OdShopGroupEntity;

@AdminLevel("developer")
public class Shop_group_edit extends Shop_group {
	@Override
	protected String execute(User user) throws IOException,SQLException {
		prepare_edit(user);
		loadKbn();
		if(this.isPost()) {
			if("del".equals(this.getCmd())) {
				if(del()) {
					this.info("削除しました。");					
					this.setRedirect("./shop_groups.do");
					return null;
				}
			} else {
				if(upd()) {
					this.info("更新しました。");
					this.setRedirect("./shop_group.do?id=" + this.id);
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
				jp.engawa.ondo.entity.OdShopGroupEntity en = new jp.engawa.ondo.entity.OdShopGroupEntity();
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
			if(this.super_group_id <= 0) {
				this.group_level = 0;
				this.super_group_id = 0;
			} else {
				OdShopGroupEntity sen = new OdShopGroupEntity();
				sen.setKeyIdAuto(this.super_group_id);
				if(db.load(sen)) {
					this.group_level = sen.getColGroupLevel() + 1;
				}
			}
			if(this.isUpd()) {
				jp.engawa.ondo.entity.OdShopGroupEntity en = new jp.engawa.ondo.entity.OdShopGroupEntity();
				en.setKeyIdAuto(this.id);
				if(db.load(en)) {
					en.setColGroupCd(this.getGroup_cd());
					en.setColGroupLevel(this.getGroup_level());
					en.setColGroupName(this.getGroup_name());
					en.setColSuperGroupId(this.getSuper_group_id());
					en.setColGroupDesc(this.getGroup_desc());
					en.setColShopAdd(this.getShop_add());
					db.update(en);
					return true;
				}
			} else {
				jp.engawa.ondo.entity.OdShopGroupEntity en = new jp.engawa.ondo.entity.OdShopGroupEntity();
				en.setColGroupCd(this.getGroup_cd());
				en.setColGroupLevel(this.getGroup_level());
				en.setColGroupName(this.getGroup_name());
				en.setColSuperGroupId(this.getSuper_group_id());
				en.setColGroupDesc(this.getGroup_desc());
				en.setColShopAdd(this.getShop_add());
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
			String sql = "UPDATE OD_SHOP_GROUP SET DEL_KBN=1 WHERE ID=[ID]";
			db.setSql(sql);
			db.add("ID",this.id);
			db.update();
			return true;
		} finally {
			db.close();
		}
	}
	
	protected boolean validate(Db db) throws SQLException {
		if(this.isEmpty(this.group_cd)) {
			this.setErrmsg("グループコードを入力してください。");
			return false;
		}
		if(this.isEmpty(this.group_name)) {
			this.setErrmsg("グループ名を入力してください。");
			return false;
		}
		if(this.isUpd()) {
			String sql = "SELECT * FROM OD_SHOP_GROUP WHERE GROUP_CD=[CD] AND ID<>[ID] LIMIT 1";
			db.setSql(sql);
			db.add("CD", this.group_cd);
			db.add("ID", this.id);
			db.execute();
			boolean find = false;
			while(db.next()) {
				find = true;
			}
			if(find) {
				this.setErrmsg("グループコードが重複しています。");
				return false;
			}
		} else {
			String sql = "SELECT * FROM OD_SHOP_GROUP WHERE GROUP_CD=[CD] LIMIT 1";
			db.setSql(sql);
			db.add("CD", this.group_cd);
			db.execute();
			boolean find = false;
			while(db.next()) {
				find = true;
			}
			if(find) {
				this.setErrmsg("グループコードが重複しています。");
				return false;
			}
		}
		return true;
	}
}