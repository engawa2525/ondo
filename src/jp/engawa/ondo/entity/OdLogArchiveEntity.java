package jp.engawa.ondo.entity;

/** OD_LOG_ARCHIVE **/
public class OdLogArchiveEntity implements jp.engawa.common.db.IDbEntity {
	private static final long serialVersionUID = 1L;

	/** ID **/
	protected long id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** LOG_KEY **/
	protected String log_key = null;
	/** FIELD1 **/
	protected String field1 = null;
	/** FIELD2 **/
	protected String field2 = null;
	/** FIELD3 **/
	protected String field3 = null;
	/** STATUS_KBN **/
	protected int status_kbn = jp.engawa.common.db.DbUtil.INT_NULL;
	/** YMD **/
	protected String ymd = null;
	/** REGIST_DT **/
	protected java.util.Date regist_dt = new java.util.Date();;
	/** DEL_KBN **/
	protected int del_kbn = 0;

	/** テーブル名 **/
	public String getTableName() {
		return "OD_LOG_ARCHIVE";
	}
	/** ID **/
	public long getKeyIdAuto() { return this.id; }
	public void setKeyIdAuto(long id) {this.id = id; }

	/** LOG_KEY **/
	public String getColLogKey() { return this.log_key; }
	public void setColLogKey(String log_key) {this.log_key = log_key; }

	/** FIELD1 **/
	public String getColField1() { return this.field1; }
	public void setColField1(String field1) {this.field1 = field1; }

	/** FIELD2 **/
	public String getColField2() { return this.field2; }
	public void setColField2(String field2) {this.field2 = field2; }

	/** FIELD3 **/
	public String getColField3() { return this.field3; }
	public void setColField3(String field3) {this.field3 = field3; }

	/** STATUS_KBN **/
	public int getColStatusKbn() { return this.status_kbn; }
	public void setColStatusKbn(int status_kbn) {this.status_kbn = status_kbn; }

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