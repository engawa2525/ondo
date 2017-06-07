package jp.engawa.ondo.entity;

/** OD_TARGET_LOG **/
public class OdTargetLogEntity implements jp.engawa.common.db.IDbEntity {
	private static final long serialVersionUID = 1L;

	/** ID **/
	protected long id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** TARGET_ID **/
	protected long target_id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** SHOP_ID **/
	protected long shop_id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** DEVICE_ID **/
	protected long device_id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** LOG_KEY **/
	protected String log_key = null;
	/** CUR_TMP **/
	protected double cur_tmp = jp.engawa.common.db.DbUtil.DOUBLE_NULL;
	/** LOG_DT **/
	protected java.util.Date log_dt = null;
	/** EVENT_ID **/
	protected long event_id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** EVENT_STATUS **/
	protected int event_status = jp.engawa.common.db.DbUtil.INT_NULL;
	/** LOG_ID **/
	protected long log_id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** REGIST_DT **/
	protected java.util.Date regist_dt = new java.util.Date();;
	/** DEL_KBN **/
	protected int del_kbn = 0;

	/** テーブル名 **/
	public String getTableName() {
		return "OD_TARGET_LOG";
	}
	/** ID **/
	public long getKeyIdAuto() { return this.id; }
	public void setKeyIdAuto(long id) {this.id = id; }

	/** TARGET_ID **/
	public long getColTargetId() { return this.target_id; }
	public void setColTargetId(long target_id) {this.target_id = target_id; }

	/** SHOP_ID **/
	public long getColShopId() { return this.shop_id; }
	public void setColShopId(long shop_id) {this.shop_id = shop_id; }

	/** DEVICE_ID **/
	public long getColDeviceId() { return this.device_id; }
	public void setColDeviceId(long device_id) {this.device_id = device_id; }

	/** LOG_KEY **/
	public String getColLogKey() { return this.log_key; }
	public void setColLogKey(String log_key) {this.log_key = log_key; }

	/** CUR_TMP **/
	public double getColCurTmp() { return this.cur_tmp; }
	public void setColCurTmp(double cur_tmp) {this.cur_tmp = cur_tmp; }

	/** LOG_DT **/
	public java.util.Date getColLogDt() { return this.log_dt; }
	public void setColLogDt(java.util.Date log_dt) {this.log_dt = log_dt; }

	/** EVENT_ID **/
	public long getColEventId() { return this.event_id; }
	public void setColEventId(long event_id) {this.event_id = event_id; }

	/** EVENT_STATUS **/
	public int getColEventStatus() { return this.event_status; }
	public void setColEventStatus(int event_status) {this.event_status = event_status; }

	/** LOG_ID **/
	public long getColLogId() { return this.log_id; }
	public void setColLogId(long log_id) {this.log_id = log_id; }

	/** REGIST_DT **/
	public java.util.Date getColRegistDt() { return this.regist_dt; }
	public void setColRegistDt(java.util.Date regist_dt) {this.regist_dt = regist_dt; }

	/** DEL_KBN **/
	public int getColDelKbn() { return this.del_kbn; }
	public void setColDelKbn(int del_kbn) {this.del_kbn = del_kbn; }

}