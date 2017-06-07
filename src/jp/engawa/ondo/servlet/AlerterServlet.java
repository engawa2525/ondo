package jp.engawa.ondo.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.Util;
import jp.engawa.ondo.entity.OdDeviceEntity;
import jp.engawa.ondo.entity.OdEventEntity;
import jp.engawa.ondo.entity.OdTargetEntity;

public class AlerterServlet extends HttpServlet {
	private static final long serialVersionUID = -5593116147696606977L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ret = "false\n";
		
		Db db = null;
		Connection conn = null;
		try {
			conn = Db.getConnection();
			db = new Db(conn);
			String key = request.getParameter("key");
			
			if(!Util.isEmpty(key)) {
				String sql = "SELECT * FROM OD_DEVICE WHERE DEL_KBN=0 AND DEVICE_CD=[KEY] ORDER BY ID LIMIT 1";
				db.setSql(sql);
				db.add("KEY", key);
				OdDeviceEntity den = null;
				db.execute(OdDeviceEntity.class);
				while(db.next()) {
					den = (OdDeviceEntity)db.getEntity();
				}
				if(den != null) {
					String upd0 = "UPDATE OD_EVENT SET ALERT_STATUS=1 WHERE ALERT_STATUS=0 AND SHOP_ID=[SID]";
					db.setSql(upd0);
					db.add("SID", den.getColShopId());
					db.update();
					
					boolean find = false;
					String sql0 = "SELECT * FROM OD_EVENT WHERE EVENT_STATUS=0 AND SHOP_ID=[SID] ";
					List<OdEventEntity> events = new ArrayList<>();
					db.setSql(sql0);
					db.add("SID",den.getColShopId());
					db.execute(OdEventEntity.class);
					while(db.next()) {
						find = true;
						OdEventEntity en = (OdEventEntity)db.getEntity();
						events.add(en);
					}
					if(find) {
						List<Integer> alist = new ArrayList<>();
						List<String> blist = new ArrayList<>();
						for(OdEventEntity event:events) {
							long target_id = event.getColTargetId();
							if(target_id > 0) {
								OdTargetEntity ten = new OdTargetEntity();
								ten.setKeyIdAuto(target_id);
								if(db.load(ten)) {
									int anum = ten.getColAlertNum();
									if(!alist.contains(anum)) {
										alist.add(anum);
										blist.add(event.getColEventCd());
									}
								}
							}
							String upd1 = "UPDATE OD_EVENT SET ALERT_STATUS=2,ALERT_DT=NOW() WHERE ALERT_STATUS=1 AND ID=[ID]";
							db.setSql(upd1);
							db.add("ID",event.getKeyIdAuto());
							db.update();
						}
						Collections.sort(alist);
						StringBuilder sb = new StringBuilder();
						if(alist.size() > 0) {
							sb.append("efn=");
;						}
						int cnt = 0;
						for(Integer i:alist) {
							if(cnt>0) {
								sb.append(".");
							}
							sb.append(i);
							cnt++;
						}
						sb.append(" ");
						if(blist.size() > 0) {
							sb.append("en=");
;						}
						cnt = 0;
						for(String i:blist) {
							if(cnt>0) {
								sb.append(".");
							}
							sb.append(i);
							cnt++;
						}
						ret = " true " + sb.toString() +"";
						response.setHeader("ondo", ret);
					}
					
					String upd = "UPDATE OD_DEVICE SET LAST_ACCESS=NOW() WHERE DEVICE_CD=[CD] AND DEL_KBN=0 LIMIT 1";
					db.setSql(upd);
					db.add("CD", key);
					db.update();		
				}
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			try{conn.close();}catch(Exception ex){}
		}
		response.setContentType("text/plain");
		byte[] bytes = ret.getBytes();
		response.setContentLength(bytes.length);
		OutputStream out = response.getOutputStream();
		out.write(bytes);
		out.flush();
		response.flushBuffer();		
	}
}
