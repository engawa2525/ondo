package jp.engawa.ondo.common;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import jp.engawa.common.db.Db;
import jp.engawa.common.db.DbListener;
import jp.engawa.common.db.ResultSetter;
import jp.engawa.gs.common.MailTransfer;
import jp.engawa.ondo.entity.OdConfigEntity;

public class AppListener extends DbListener {
	public static final String APPLICATION_KEY_CONFIG = "ondo.config";
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		InitialContext ic;
		initdb(event);
		
		loadConfig(event.getServletContext());
		
		try {
			ic = new InitialContext();
			MailTransfer.init(ic);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 設定の読み込み
	 * @param context
	 * @return
	 */
	public static Map<String, String> loadConfig(ServletContext context) {
		Map<String, String> map = new HashMap<String, String>();
		Connection conn = null;
		Db db = null;
		try {
			conn = Db.getConnection();
			db = new Db(conn);
			
			String sql = "SELECT * FROM OD_CONFIG";
			db.setSql(sql);
			ResultSetter r = new ResultSetter(OdConfigEntity.class);
			db.execute();
			while(db.next()) {
				OdConfigEntity en = (OdConfigEntity)r.build(db);
				map.put(en.getKeyConfigKey(), en.getColConfigValue());
			}
			context.setAttribute(APPLICATION_KEY_CONFIG, map);
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			if(db != null) db.close();
			if(conn != null) try{conn.close();} catch(SQLException ex) {}
		}
		return map;
	}	
	
}
