package jp.engawa.ondo.entity;

/** OD_TARGET_DEF **/
public class OdTargetDefEntity implements jp.engawa.common.db.IDbEntity {
	private static final long serialVersionUID = 1L;

	/** ID **/
	protected long id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** TARGET_DEF_NAME **/
	protected String target_def_name = null;
	/** MIN_TEMP **/
	protected double min_temp = jp.engawa.common.db.DbUtil.DOUBLE_NULL;
	/** MAX_TEMP **/
	protected double max_temp = jp.engawa.common.db.DbUtil.DOUBLE_NULL;
	/** ALERT_ERR_CNT **/
	protected int alert_err_cnt = jp.engawa.common.db.DbUtil.INT_NULL;
	/** NORMAL_INTERVAL **/
	protected int normal_interval = jp.engawa.common.db.DbUtil.INT_NULL;
	/** ALERT_INTERVAL **/
	protected int alert_interval = jp.engawa.common.db.DbUtil.INT_NULL;
	/** GRAPH_OPTION **/
	protected String graph_option = null;
	/** REGIST_DT **/
	protected java.util.Date regist_dt = new java.util.Date();;
	/** DEL_KBN **/
	protected int del_kbn = 0;

	/** テーブル名 **/
	public String getTableName() {
		return "OD_TARGET_DEF";
	}
	/** ID **/
	public long getKeyIdAuto() { return this.id; }
	public void setKeyIdAuto(long id) {this.id = id; }

	/** TARGET_DEF_NAME **/
	public String getColTargetDefName() { return this.target_def_name; }
	public void setColTargetDefName(String target_def_name) {this.target_def_name = target_def_name; }

	/** MIN_TEMP **/
	public double getColMinTemp() { return this.min_temp; }
	public void setColMinTemp(double min_temp) {this.min_temp = min_temp; }

	/** MAX_TEMP **/
	public double getColMaxTemp() { return this.max_temp; }
	public void setColMaxTemp(double max_temp) {this.max_temp = max_temp; }

	/** ALERT_ERR_CNT **/
	public int getColAlertErrCnt() { return this.alert_err_cnt; }
	public void setColAlertErrCnt(int alert_err_cnt) {this.alert_err_cnt = alert_err_cnt; }

	/** NORMAL_INTERVAL **/
	public int getColNormalInterval() { return this.normal_interval; }
	public void setColNormalInterval(int normal_interval) {this.normal_interval = normal_interval; }

	/** ALERT_INTERVAL **/
	public int getColAlertInterval() { return this.alert_interval; }
	public void setColAlertInterval(int alert_interval) {this.alert_interval = alert_interval; }

	/** GRAPH_OPTION **/
	public String getColGraphOption() { return this.graph_option; }
	public void setColGraphOption(String graph_option) {this.graph_option = graph_option; }

	/** REGIST_DT **/
	public java.util.Date getColRegistDt() { return this.regist_dt; }
	public void setColRegistDt(java.util.Date regist_dt) {this.regist_dt = regist_dt; }

	/** DEL_KBN **/
	public int getColDelKbn() { return this.del_kbn; }
	public void setColDelKbn(int del_kbn) {this.del_kbn = del_kbn; }

}