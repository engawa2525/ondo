package jp.engawa.ondo.common;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.DefaultOption;
import jp.engawa.gs.common.IOption;
import jp.engawa.gs.common.Util;
import jp.engawa.ondo.entity.OdUserEntity;

public class User implements Serializable {
	private static final long serialVersionUID = 8843484968400336989L;

	public static int admin_level(String str) {
		if (str == null)
			return 0;
		String s = str.toLowerCase();
		if ("developer".equals(s)) {
			return IConst.KENGEN_DEVELOPER;
		}
		if ("admin".equals(s)) {
			return IConst.KENGEN_ADMIN;
		}
		if ("shop_owner".equals(s)) {
			return IConst.KENGEN_SHOP_OWNER;
		}
		if ("member".equals(s)) {
			return IConst.KENGEN_MEMBER;
		}
		return Util.toInt(str);
	}
	public static String admin_str(int level) {
		if (level == IConst.KENGEN_MEMBER) {
			return "member";
		}
		if (level == IConst.KENGEN_SHOP_OWNER) {
			return "shop_owner";
		}
		if (level == IConst.KENGEN_ADMIN) {
			return "admin";
		}
		if (level == IConst.KENGEN_DEVELOPER) {
			return "developer";
		}
		return "" + level;
	}	
	
	public static List<IOption> admin_level_list(int maxlevel) {
		List<IOption> list = new ArrayList<>();
		if (IConst.KENGEN_MEMBER <= maxlevel) {
			list.add(new DefaultOption("" + IConst.KENGEN_MEMBER, "member"));
		}
		if (IConst.KENGEN_SHOP_OWNER <= maxlevel) {
			list.add(new DefaultOption("" + IConst.KENGEN_SHOP_OWNER,
					"shop_owner"));
		}
		if (IConst.KENGEN_ADMIN <= maxlevel) {
			list.add(new DefaultOption("" + IConst.KENGEN_ADMIN, "admin"));
		}
		if (IConst.KENGEN_DEVELOPER <= maxlevel) {
			list.add(new DefaultOption("" + IConst.KENGEN_DEVELOPER,
					"developer"));
		}
		return list;
	}	
	
	protected long id;
	protected String name;
	protected int admin_kbn;
	protected int psw_kbn;
	
	public User(){}
	public User(Db db,OdUserEntity en) throws SQLException {
		this.id = en.getKeyIdAuto();
		this.name = en.getColName();
		this.admin_kbn = en.getColAdminKbn();
		this.psw_kbn = en.getColPswKbn();
	}	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
}
