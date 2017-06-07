package jp.engawa.ondo.task;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.engawa.common.db.Db;
import jp.engawa.gs.mail.Sender;
import jp.engawa.ondo.common.TaskAction;
import jp.engawa.ondo.entity.OdEventEntity;
import jp.engawa.ondo.entity.OdShopEntity;
import jp.engawa.ondo.entity.OdTargetEntity;
import jp.engawa.ondo.task.send_event_mail.Msg;
/*
 */
public class Send_event_mail extends TaskAction {
	private String mail_to;
	
	@Override
	protected String exec() throws IOException, SQLException {
		load();
		return JSON_FORWARD;
	}
	private void load() throws SQLException,IOException {
		Db db = null;
		try {
			db = this.getDb();
			List<OdEventEntity> list = this.buidlList(db);
			for(OdEventEntity en:list) {
				this.sendAndUpdate(db, en);
			}
		} finally {
			db.close();
		}
	}
	
	private List<OdEventEntity> buidlList(Db db) throws SQLException {
		List<OdEventEntity> list = new ArrayList<>();
		String sql = "SELECT * FROM OD_EVENT WHERE DEL_KBN=0 AND MAIL_STATUS=0";
		db.setSql(sql);
		db.execute(OdEventEntity.class);
		while(db.next()) {
			OdEventEntity en = (OdEventEntity)db.getEntity();
			list.add(en);
		}
		return list;
	}
	
	private void sendAndUpdate(Db db,OdEventEntity en) throws SQLException,IOException {
		long shop_id = en.getColShopId();
		long target_id = en.getColTargetId();
		String to = "okuyama@engawa.jp";
		String shop_name = "";
		String target_name = "";
		if(shop_id > 0) {
			OdShopEntity sen = new OdShopEntity();
			sen.setKeyIdAuto(shop_id);
			if(db.load(sen) && sen.getColDelKbn() == 0) {
				to = sen.getColMailAddr();
				shop_name = sen.getColShopName();
			}
		}
		if(target_id > 0){
			OdTargetEntity ten = new OdTargetEntity();
			ten.setKeyIdAuto(target_id);
			if(db.load(ten)) {
				target_name = ten.getColTargetName();
			}
		}
		
		String from = this.getContextParameter(INIT_KEY_ALERT_MAIL_FROM);
		String cc = this.getContextParameter(INIT_KEY_ALERT_MAIL_CC);
		Msg msg = new Msg();
		String app_title = this.getContextParameter(INIT_KEY_APPLICATION_TITLE);
		String subject = "["+app_title+"]" + en.getColEventName();
		String body = en.getColEventInfo() + "\n" + shop_name + "\n" + target_name;
		msg.setFrom(from);
		msg.setTo(to);
		msg.setCc(cc);
		msg.setSubject(subject);
		msg.setBody(body);
		Sender.send(msg);
		
		String sql = "UPDATE OD_EVENT SET MAIL_STATUS=1,MAIL_DT=NOW() WHERE ID=[ID]";
		db.setSql(sql);
		db.add("ID", en.getKeyIdAuto());
		db.update();
	}

	public String getMail_to() {
		return mail_to;
	}

	public void setMail_to(String mail_to) {
		this.mail_to = mail_to;
	}

}
