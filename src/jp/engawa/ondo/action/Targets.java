package jp.engawa.ondo.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.IList;
import jp.engawa.gs.common.IOption;
import jp.engawa.ondo.action.target.Item;
import jp.engawa.ondo.common.AppAction;
import jp.engawa.ondo.common.User;

public class Targets extends jp.engawa.ondo.common.AppAction implements IList {

	protected List<Item> items = new ArrayList<>();
	
	protected List<IOption> shops;
	protected List<IOption> defs;
	
	@Override
	protected String execute(User user) throws IOException,SQLException {
		load();
		loadKbn();
		return null;
	}
	
	protected void load() throws SQLException {
		Db db = null;
		try {
			db = this.getDb();
			String sql = "SELECT T.* FROM OD_TARGET T WHERE T.DEL_KBN=0 ORDER BY T.ID";
			db.setSql(sql);
			db.execute(jp.engawa.ondo.entity.OdTargetEntity.class);
			while(db.next()) {
				jp.engawa.ondo.entity.OdTargetEntity en = (jp.engawa.ondo.entity.OdTargetEntity)db.getEntity();
				this.items.add(new Item(en,db));
			}
		} finally {
			db.close();
		}
	}
	
	protected void loadKbn() throws SQLException {
		Db db = null;
		try {
			db = this.getDb();
			this.shops = AppAction.buildList(db, "SELECT ID,SHOP_NAME FROM OD_SHOP WHERE DEL_KBN=0 ORDER BY SHOP_CD");
			this.defs = AppAction.buildList(db, "SELECT ID,TARGET_DEF_NAME FROM OD_TARGET_DEF WHERE DEL_KBN=0 ORDER BY ID");
		} finally {
			db.close();
		}
	}	

	@Override
	public Iterator<Item> iterator() {
		return this.items.iterator();
	}

	public List<IOption> getShops() {
		return shops;
	}

	public void setShops(List<IOption> shops) {
		this.shops = shops;
	}

	public List<IOption> getDefs() {
		return defs;
	}

	public void setDefs(List<IOption> defs) {
		this.defs = defs;
	}

}