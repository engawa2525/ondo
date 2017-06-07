package jp.engawa.ondo.entity;

/** OD_CONFIG **/
public class OdConfigEntity implements jp.engawa.common.db.IDbEntity {
	private static final long serialVersionUID = 1L;

	/** CONFIG_KEY **/
	protected String config_key = null;
	/** CONFIG_VALUE **/
	protected String config_value = null;
	/** REGIST_DT **/
	protected java.util.Date regist_dt = new java.util.Date();;
	/** UPD_DT **/
	protected java.util.Date upd_dt = null;

	/** テーブル名 **/
	public String getTableName() {
		return "OD_CONFIG";
	}
	/** CONFIG_KEY **/
	public String getKeyConfigKey() { return this.config_key; }
	public void setKeyConfigKey(String config_key) {this.config_key = config_key; }

	/** CONFIG_VALUE **/
	public String getColConfigValue() { return this.config_value; }
	public void setColConfigValue(String config_value) {this.config_value = config_value; }

	/** REGIST_DT **/
	public java.util.Date getColRegistDt() { return this.regist_dt; }
	public void setColRegistDt(java.util.Date regist_dt) {this.regist_dt = regist_dt; }

	/** UPD_DT **/
	public java.util.Date getColUpdDt() { return this.upd_dt; }
	public void setColUpdDt(java.util.Date upd_dt) {this.upd_dt = upd_dt; }

}