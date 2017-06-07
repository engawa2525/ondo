package jp.engawa.ondo.entity;

/** OD_EVENT **/
public class OdEventEntity implements jp.engawa.common.db.IDbEntity {
	private static final long serialVersionUID = 1L;

	/** ID **/
	protected long id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** EVENT_STATUS **/
	protected int event_status = jp.engawa.common.db.DbUtil.INT_NULL;
	/** DEVICE_ID **/
	protected long device_id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** SHOP_ID **/
	protected long shop_id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** TARGET_ID **/
	protected long target_id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** EVENT_DT **/
	protected java.util.Date event_dt = null;
	/** EVENT_CD **/
	protected String event_cd = null;
	/** EVENT_NAME **/
	protected String event_name = null;
	/** EVENT_INFO **/
	protected String event_info = null;
	/** ALERT_STATUS **/
	protected int alert_status = jp.engawa.common.db.DbUtil.INT_NULL;
	/** STATUS_DT **/
	protected java.util.Date status_dt = null;
	/** ALERT_DT **/
	protected java.util.Date alert_dt = null;
	/** MAIL_STATUS **/
	protected int mail_status = jp.engawa.common.db.DbUtil.INT_NULL;
	/** MAIL_DT **/
	protected java.util.Date mail_dt = null;
	/** YMD **/
	protected String ymd = null;
	/** REGIST_DT **/
	protected java.util.Date regist_dt = new java.util.Date();;
	/** DEL_KBN **/
	protected int del_kbn = 0;

	/** テーブル名 **/
	public String getTableName() {
		return "OD_EVENT";
	}
	/** ID **/
	public long getKeyIdAuto() { return this.id; }
	public void setKeyIdAuto(long id) {this.id = id; }

	/** EVENT_STATUS **/
	public int getColEventStatus() { return this.event_status; }
	public void setColEventStatus(int event_status) {this.event_status = event_status; }

	/** DEVICE_ID **/
	public long getColDeviceId() { return this.device_id; }
	public void setColDeviceId(long device_id) {this.device_id = device_id; }

	/** SHOP_ID **/
	public long getColShopId() { return this.shop_id; }
	public void setColShopId(long shop_id) {this.shop_id = shop_id; }

	/** TARGET_ID **/
	public long getColTargetId() { return this.target_id; }
	public void setColTargetId(long target_id) {this.target_id = target_id; }

	/** EVENT_DT **/
	public java.util.Date getColEventDt() { return this.event_dt; }
	public void setColEventDt(java.util.Date event_dt) {this.event_dt = event_dt; }

	/** EVENT_CD **/
	public String getColEventCd() { return this.event_cd; }
	public void setColEventCd(String event_cd) {this.event_cd = event_cd; }

	/** EVENT_NAME **/
	public String getColEventName() { return this.event_name; }
	public void setColEventName(String event_name) {this.event_name = event_name; }

	/** EVENT_INFO **/
	public String getColEventInfo() { return this.event_info; }
	public void setColEventInfo(String event_info) {this.event_info = event_info; }

	/** ALERT_STATUS **/
	public int getColAlertStatus() { return this.alert_status; }
	public void setColAlertStatus(int alert_status) {this.alert_status = alert_status; }

	/** STATUS_DT **/
	public java.util.Date getColStatusDt() { return this.status_dt; }
	public void setColStatusDt(java.util.Date status_dt) {this.status_dt = status_dt; }

	/** ALERT_DT **/
	public java.util.Date getColAlertDt() { return this.alert_dt; }
	public void setColAlertDt(java.util.Date alert_dt) {this.alert_dt = alert_dt; }

	/** MAIL_STATUS **/
	public int getColMailStatus() { return this.mail_status; }
	public void setColMailStatus(int mail_status) {this.mail_status = mail_status; }

	/** MAIL_DT **/
	public java.util.Date getColMailDt() { return this.mail_dt; }
	public void setColMailDt(java.util.Date mail_dt) {this.mail_dt = mail_dt; }

	/** YMD **/
	public String getColYmd() { return this.ymd; }
	public void setColYmd(String ymd) {this.ymd = ymd; }

	/** REGIST_DT **/
	public java.util.Date getColRegistDt() { return this.regist_dt; }
	public void setColRegistDt(java.util.Date regist_dt) {this.regist_dt = regist_dt; }

	/** DEL_KBN **/
	public int getColDelKbn() { return this.del_kbn; }
	public void setColDelKbn(int del_kbn) {this.del_kbn = del_kbn; }

}