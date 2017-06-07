package jp.engawa.ondo.entity;

/** OD_SHOP **/
public class OdShopEntity implements jp.engawa.common.db.IDbEntity {
	private static final long serialVersionUID = 1L;

	/** ID **/
	protected long id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** SHOP_CD **/
	protected String shop_cd = null;
	/** SHOP_NAME **/
	protected String shop_name = null;
	/** MAIL_ADDR **/
	protected String mail_addr = null;
	/** OPEN_YMD **/
	protected String open_ymd = null;
	/** CLOSE_YMD **/
	protected String close_ymd = null;
	/** ALERT_STATUS **/
	protected int alert_status = jp.engawa.common.db.DbUtil.INT_NULL;
	/** REGIST_DT **/
	protected java.util.Date regist_dt = new java.util.Date();;
	/** DEL_KBN **/
	protected int del_kbn = 0;

	/** テーブル名 **/
	public String getTableName() {
		return "OD_SHOP";
	}
	/** ID **/
	public long getKeyIdAuto() { return this.id; }
	public void setKeyIdAuto(long id) {this.id = id; }

	/** SHOP_CD **/
	public String getColShopCd() { return this.shop_cd; }
	public void setColShopCd(String shop_cd) {this.shop_cd = shop_cd; }

	/** SHOP_NAME **/
	public String getColShopName() { return this.shop_name; }
	public void setColShopName(String shop_name) {this.shop_name = shop_name; }

	/** MAIL_ADDR **/
	public String getColMailAddr() { return this.mail_addr; }
	public void setColMailAddr(String mail_addr) {this.mail_addr = mail_addr; }

	/** OPEN_YMD **/
	public String getColOpenYmd() { return this.open_ymd; }
	public void setColOpenYmd(String open_ymd) {this.open_ymd = open_ymd; }

	/** CLOSE_YMD **/
	public String getColCloseYmd() { return this.close_ymd; }
	public void setColCloseYmd(String close_ymd) {this.close_ymd = close_ymd; }

	/** ALERT_STATUS **/
	public int getColAlertStatus() { return this.alert_status; }
	public void setColAlertStatus(int alert_status) {this.alert_status = alert_status; }

	/** REGIST_DT **/
	public java.util.Date getColRegistDt() { return this.regist_dt; }
	public void setColRegistDt(java.util.Date regist_dt) {this.regist_dt = regist_dt; }

	/** DEL_KBN **/
	public int getColDelKbn() { return this.del_kbn; }
	public void setColDelKbn(int del_kbn) {this.del_kbn = del_kbn; }

}