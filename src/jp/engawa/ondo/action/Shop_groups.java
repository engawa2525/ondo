package jp.engawa.ondo.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.IList;
import jp.engawa.ondo.action.shop_group.Item;
import jp.engawa.ondo.common.User;

public class Shop_groups extends jp.engawa.ondo.common.AppAction implements IList {

	protected List<Item> items = new ArrayList<>();
	
	@Override
	protected String execute(User user) throws IOException,SQLException {
		load();
		return null;
	}
	
	protected void load() throws SQLException {
		Db db = null;
		try {
			db = this.getDb();
			String sql = "SELECT T.* FROM OD_SHOP_GROUP T WHERE T.DEL_KBN=0 ORDER BY T.ID";
			db.setSql(sql);
			db.execute(jp.engawa.ondo.entity.OdShopGroupEntity.class);
			while(db.next()) {
				jp.engawa.ondo.entity.OdShopGroupEntity en = (jp.engawa.ondo.entity.OdShopGroupEntity)db.getEntity();
				this.items.add(new Item(en,db));
			}
		} finally {
			db.close();
		}
	}

	@Override
	public Iterator<Item> iterator() {
		return this.items.iterator();
	}

}