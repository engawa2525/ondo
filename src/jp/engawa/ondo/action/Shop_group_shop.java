package jp.engawa.ondo.action;

import java.io.IOException;
import java.sql.SQLException;

import jp.engawa.ondo.common.AdminLevel;
import jp.engawa.ondo.common.User;

@AdminLevel("developer")
public class Shop_group_shop extends Shop_group {
	@Override
	protected String execute(User user) throws IOException,SQLException {
		loadKbn();
		return null;
	}
}