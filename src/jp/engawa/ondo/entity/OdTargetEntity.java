package jp.engawa.ondo.entity;

/** OD_TARGET **/
public class OdTargetEntity implements jp.engawa.common.db.IDbEntity {
	private static final long serialVersionUID = 1L;

	/** ID **/
	protected long id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** TARGET_CD **/
	protected String target_cd = null;
	/** SHOP_ID **/
	protected long shop_id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** TARGET_NAME **/
	protected String target_name = null;
	/** TARGET_DESC **/
	protected String target_desc = null;
	/** TARGET_STATUS **/
	protected int target_status = jp.engawa.common.db.DbUtil.INT_NULL;
	/** STATUS_MSG **/
	protected String status_msg = null;
	/** MIN_TEMP **/
	protected double min_temp = jp.engawa.common.db.DbUtil.DOUBLE_NULL;
	/** MAX_TEMP **/
	protected double max_temp = jp.engawa.common.db.DbUtil.DOUBLE_NULL;
	/** ERR_CNT **/
	protected int err_cnt = jp.engawa.common.db.DbUtil.INT_NULL;
	/** LAST_REPORT **/
	protected java.util.Date last_report = null;
	/** CURRENT_TEMP **/
	protected double current_temp = jp.engawa.common.db.DbUtil.DOUBLE_NULL;
	/** LAST_LOG_ID **/
	protected long last_log_id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** ALERT_NUM **/
	protected int alert_num = jp.engawa.common.db.DbUtil.INT_NULL;
	/** TARGET_DEF_ID **/
	protected long target_def_id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** REGIST_DT **/
	protected java.util.Date regist_dt = new java.util.Date();;
	/** DEL_KBN **/
	protected int del_kbn = 0;

	/** テーブル名 **/
	public String getTableName() {
		return "OD_TARGET";
	}
	/** ID **/
	public long getKeyIdAuto() { return this.id; }
	public void setKeyIdAuto(long id) {this.id = id; }

	/** TARGET_CD **/
	public String getColTargetCd() { return this.target_cd; }
	public void setColTargetCd(String target_cd) {this.target_cd = target_cd; }

	/** SHOP_ID **/
	public long getColShopId() { return this.shop_id; }
	public void setColShopId(long shop_id) {this.shop_id = shop_id; }

	/** TARGET_NAME **/
	public String getColTargetName() { return this.target_name; }
	public void setColTargetName(String target_name) {this.target_name = target_name; }

	/** TARGET_DESC **/
	public String getColTargetDesc() { return this.target_desc; }
	public void setColTargetDesc(String target_desc) {this.target_desc = target_desc; }

	/** TARGET_STATUS **/
	public int getColTargetStatus() { return this.target_status; }
	public void setColTargetStatus(int target_status) {this.target_status = target_status; }

	/** STATUS_MSG **/
	public String getColStatusMsg() { return this.status_msg; }
	public void setColStatusMsg(String status_msg) {this.status_msg = status_msg; }

	/** MIN_TEMP **/
	public double getColMinTemp() { return this.min_temp; }
	public void setColMinTemp(double min_temp) {this.min_temp = min_temp; }

	/** MAX_TEMP **/
	public double getColMaxTemp() { return this.max_temp; }
	public void setColMaxTemp(double max_temp) {this.max_temp = max_temp; }

	/** ERR_CNT **/
	public int getColErrCnt() { return this.err_cnt; }
	public void setColErrCnt(int err_cnt) {this.err_cnt = err_cnt; }

	/** LAST_REPORT **/
	public java.util.Date getColLastReport() { return this.last_report; }
	public void setColLastReport(java.util.Date last_report) {this.last_report = last_report; }

	/** CURRENT_TEMP **/
	public double getColCurrentTemp() { return this.current_temp; }
	public void setColCurrentTemp(double current_temp) {this.current_temp = current_temp; }

	/** LAST_LOG_ID **/
	public long getColLastLogId() { return this.last_log_id; }
	public void setColLastLogId(long last_log_id) {this.last_log_id = last_log_id; }

	/** ALERT_NUM **/
	public int getColAlertNum() { return this.alert_num; }
	public void setColAlertNum(int alert_num) {this.alert_num = alert_num; }

	/** TARGET_DEF_ID **/
	public long getColTargetDefId() { return this.target_def_id; }
	public void setColTargetDefId(long target_def_id) {this.target_def_id = target_def_id; }

	/** REGIST_DT **/
	public java.util.Date getColRegistDt() { return this.regist_dt; }
	public void setColRegistDt(java.util.Date regist_dt) {this.regist_dt = regist_dt; }

	/** DEL_KBN **/
	public int getColDelKbn() { return this.del_kbn; }
	public void setColDelKbn(int del_kbn) {this.del_kbn = del_kbn; }

}