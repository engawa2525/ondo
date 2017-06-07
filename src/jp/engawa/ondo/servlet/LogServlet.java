package jp.engawa.ondo.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.Util;
import jp.engawa.ondo.entity.OdDeviceEntity;
import jp.engawa.ondo.entity.OdLogEntity;
import jp.engawa.ondo.entity.OdTargetDefEntity;
import jp.engawa.ondo.entity.OdTargetEntity;

public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 8270348781961757102L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Db db = null;
		Connection conn = null;
		Date dt = null;
		String status = null;
		try {
			conn = Db.getConnection();
			db = new Db(conn);
			String key = request.getParameter("key");
			String field1 = request.getParameter("field1");
			String field2 = request.getParameter("field2");
			String field3 = request.getParameter("field3");
			status = request.getParameter("status");
			
			if(!Util.isEmpty(key)) {
				OdLogEntity en = new OdLogEntity();
				en.setColField1(field1);
				en.setColField2(field2);
				en.setColField3(field3);
				en.setColLogKey(key);
				en.setColRegistDt(new Date());
				en.setColStatusKbn(0);
				en.setColYmd(new SimpleDateFormat("yyyyMMdd").format(new Date()));
				db.insert(en);
				
				String upd = "UPDATE OD_DEVICE SET LAST_ACCESS=NOW() WHERE DEVICE_CD=[CD] AND DEL_KBN=0 LIMIT 1";
				db.setSql(upd);
				db.add("CD", key);
				db.update();
			}
			if(Util.isEmpty(status)) {
				status = status(db,key,field1);
			}
			
			String sql = "SELECT NOW()";
			db.setSql(sql);
			db.execute();
			dt = null;
			while(db.next()) {
				dt = db.getDate(1);
			}
			db.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			try{conn.close();}catch(Exception ex){}
		}
		//response.setContentType("text/html");
		response.setContentType("text/plain");
		String param = "";
		if(!Util.isEmpty(status)) {
			param = status;
		}
		SimpleDateFormat dformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//String ret = "<html><body>LOG " +dformat.format(dt) +"<div class=\"status\">"+param+"</div></body></html>";
		String ret = param;
		response.setHeader("ondo", ret);
		System.out.println(dformat.format(new Date()) + "\t" + ret);
		byte[] bytes = ret.getBytes();
		response.setContentLength(bytes.length);
		OutputStream out = response.getOutputStream();
		out.write(bytes);
		out.flush();
		response.flushBuffer();
	}
	
	private String status(Db db,String key,String field1) throws SQLException {
		int t_time = 180;
		int f_time = 600;
		if(!Util.isEmpty(key) && !Util.isEmpty(field1)) {
			double tmp = Util.toDbl(field1);
			String sql0 = "SELECT * FROM OD_DEVICE WHERE DEVICE_TYPE=0 AND TARGET_ID>0 AND DEVICE_CD=[KEY] AND DEVICE_STATUS=0 AND (START_DT IS NULL OR START_DT<=NOW()) AND (END_DT IS NULL OR END_DT>=NOW()) ORDER BY ID LIMIT 1";
			db.setSql(sql0);
			db.add("KEY", key);
			OdDeviceEntity device = null;
			db.execute(OdDeviceEntity.class);
			while(db.next()) {
				device = (OdDeviceEntity)db.getEntity();
			}
			if(device != null) {
				long target_id = device.getColTargetId();
				OdTargetEntity ten = new OdTargetEntity();
				ten.setKeyIdAuto(target_id);
				if(db.load(ten) && ten.getColDelKbn() == 0 && ten.getColTargetStatus() == 0) {
					double max = ten.getColMaxTemp();
					double min = ten.getColMinTemp();
					long def_id = ten.getColTargetDefId();
					if(def_id > 0) {
						OdTargetDefEntity den = new OdTargetDefEntity();
						den.setKeyIdAuto(def_id);
						if(db.load(den) && den.getColDelKbn() == 0) {
							max = den.getColMaxTemp();
							min = den.getColMinTemp();
							t_time = den.getColNormalInterval() * 60;
							f_time = den.getColAlertInterval() * 60;
						}
					}
					DecimalFormat deci = new DecimalFormat("0.00");
					if(tmp > max) {
						return "true"+t_time+" high CUR:" + deci.format(tmp) + " MAX:" + deci.format(max) + " vol_1=1 vol_2=0"; 
					}
					if(tmp < min) {
						return "true"+t_time+" low CUR:" + deci.format(tmp) + " MIN:" + deci.format(min) + " vol_1=1 vol_2=0"; 
					}
					return "false"+f_time+" CUR:" + deci.format(tmp) + " MAX:" + deci.format(max) + " MIN:" + deci.format(min) + " vol_1=0 vol_2=5";
				}
			}
		}
		return "false"+f_time;
	}
}
