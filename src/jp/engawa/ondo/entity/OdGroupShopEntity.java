package jp.engawa.ondo.entity;

/** OD_GROUP_SHOP **/
public class OdGroupShopEntity implements jp.engawa.common.db.IDbEntity {
	private static final long serialVersionUID = 1L;

	/** GROUP_ID **/
	protected long group_id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** SHOP_ID **/
	protected long shop_id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** REGIST_DT **/
	protected java.util.Date regist_dt = new java.util.Date();;

	/** テーブル名 **/
	public String getTableName() {
		return "OD_GROUP_SHOP";
	}
	/** GROUP_ID **/
	public long getKeyGroupId() { return this.group_id; }
	public void setKeyGroupId(long group_id) {this.group_id = group_id; }

	/** SHOP_ID **/
	public long getKeyShopId() { return this.shop_id; }
	public void setKeyShopId(long shop_id) {this.shop_id = shop_id; }

	/** REGIST_DT **/
	public java.util.Date getColRegistDt() { return this.regist_dt; }
	public void setColRegistDt(java.util.Date regist_dt) {this.regist_dt = regist_dt; }

}