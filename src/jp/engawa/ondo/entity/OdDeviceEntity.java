package jp.engawa.ondo.entity;

/** OD_DEVICE **/
public class OdDeviceEntity implements jp.engawa.common.db.IDbEntity {
	private static final long serialVersionUID = 1L;

	/** ID **/
	protected long id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** DEVICE_CD **/
	protected String device_cd = null;
	/** DEVICE_TYPE **/
	protected int device_type = jp.engawa.common.db.DbUtil.INT_NULL;
	/** SHOP_ID **/
	protected long shop_id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** TARGET_ID **/
	protected long target_id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** DEVICE_STATUS **/
	protected int device_status = jp.engawa.common.db.DbUtil.INT_NULL;
	/** START_DT **/
	protected java.util.Date start_dt = null;
	/** END_DT **/
	protected java.util.Date end_dt = null;
	/** LAST_ACCESS **/
	protected java.util.Date last_access = null;
	/** REGIST_DT **/
	protected java.util.Date regist_dt = new java.util.Date();;
	/** DEL_KBN **/
	protected int del_kbn = 0;

	/** テーブル名 **/
	public String getTableName() {
		return "OD_DEVICE";
	}
	/** ID **/
	public long getKeyIdAuto() { return this.id; }
	public void setKeyIdAuto(long id) {this.id = id; }

	/** DEVICE_CD **/
	public String getColDeviceCd() { return this.device_cd; }
	public void setColDeviceCd(String device_cd) {this.device_cd = device_cd; }

	/** DEVICE_TYPE **/
	public int getColDeviceType() { return this.device_type; }
	public void setColDeviceType(int device_type) {this.device_type = device_type; }

	/** SHOP_ID **/
	public long getColShopId() { return this.shop_id; }
	public void setColShopId(long shop_id) {this.shop_id = shop_id; }

	/** TARGET_ID **/
	public long getColTargetId() { return this.target_id; }
	public void setColTargetId(long target_id) {this.target_id = target_id; }

	/** DEVICE_STATUS **/
	public int getColDeviceStatus() { return this.device_status; }
	public void setColDeviceStatus(int device_status) {this.device_status = device_status; }

	/** START_DT **/
	public java.util.Date getColStartDt() { return this.start_dt; }
	public void setColStartDt(java.util.Date start_dt) {this.start_dt = start_dt; }

	/** END_DT **/
	public java.util.Date getColEndDt() { return this.end_dt; }
	public void setColEndDt(java.util.Date end_dt) {this.end_dt = end_dt; }

	/** LAST_ACCESS **/
	public java.util.Date getColLastAccess() { return this.last_access; }
	public void setColLastAccess(java.util.Date last_access) {this.last_access = last_access; }

	/** REGIST_DT **/
	public java.util.Date getColRegistDt() { return this.regist_dt; }
	public void setColRegistDt(java.util.Date regist_dt) {this.regist_dt = regist_dt; }

	/** DEL_KBN **/
	public int getColDelKbn() { return this.del_kbn; }
	public void setColDelKbn(int del_kbn) {this.del_kbn = del_kbn; }

}