package jp.engawa.ondo.entity;

/** OD_USER **/
public class OdUserEntity implements jp.engawa.common.db.IDbEntity {
	private static final long serialVersionUID = 1L;

	/** ID **/
	protected long id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** NAME **/
	protected String name = null;
	/** ACCOUNT_KEY **/
	protected String account_key = null;
	/** ACCOUNT_PSW **/
	protected String account_psw = null;
	/** ADMIN_KBN **/
	protected int admin_kbn = jp.engawa.common.db.DbUtil.INT_NULL;
	/** PSW_KBN **/
	protected int psw_kbn = jp.engawa.common.db.DbUtil.INT_NULL;
	/** PSW_CHANGE_DT **/
	protected java.util.Date psw_change_dt = null;
	/** SHOP_ID **/
	protected long shop_id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** GROUP_ID **/
	protected long group_id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** REGIST_DT **/
	protected java.util.Date regist_dt = new java.util.Date();;
	/** DEL_KBN **/
	protected int del_kbn = 0;

	/** テーブル名 **/
	public String getTableName() {
		return "OD_USER";
	}
	/** ID **/
	public long getKeyIdAuto() { return this.id; }
	public void setKeyIdAuto(long id) {this.id = id; }

	/** NAME **/
	public String getColName() { return this.name; }
	public void setColName(String name) {this.name = name; }

	/** ACCOUNT_KEY **/
	public String getColAccountKey() { return this.account_key; }
	public void setColAccountKey(String account_key) {this.account_key = account_key; }

	/** ACCOUNT_PSW **/
	public String getColAccountPsw() { return this.account_psw; }
	public void setColAccountPsw(String account_psw) {this.account_psw = account_psw; }

	/** ADMIN_KBN **/
	public int getColAdminKbn() { return this.admin_kbn; }
	public void setColAdminKbn(int admin_kbn) {this.admin_kbn = admin_kbn; }

	/** PSW_KBN **/
	public int getColPswKbn() { return this.psw_kbn; }
	public void setColPswKbn(int psw_kbn) {this.psw_kbn = psw_kbn; }

	/** PSW_CHANGE_DT **/
	public java.util.Date getColPswChangeDt() { return this.psw_change_dt; }
	public void setColPswChangeDt(java.util.Date psw_change_dt) {this.psw_change_dt = psw_change_dt; }

	/** SHOP_ID **/
	public long getColShopId() { return this.shop_id; }
	public void setColShopId(long shop_id) {this.shop_id = shop_id; }

	/** GROUP_ID **/
	public long getColGroupId() { return this.group_id; }
	public void setColGroupId(long group_id) {this.group_id = group_id; }

	/** REGIST_DT **/
	public java.util.Date getColRegistDt() { return this.regist_dt; }
	public void setColRegistDt(java.util.Date regist_dt) {this.regist_dt = regist_dt; }

	/** DEL_KBN **/
	public int getColDelKbn() { return this.del_kbn; }
	public void setColDelKbn(int del_kbn) {this.del_kbn = del_kbn; }

}