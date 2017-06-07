package jp.engawa.ondo.entity;

/** OD_SHOP_GROUP **/
public class OdShopGroupEntity implements jp.engawa.common.db.IDbEntity {
	private static final long serialVersionUID = 1L;

	/** ID **/
	protected long id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** GROUP_CD **/
	protected String group_cd = null;
	/** GROUP_NAME **/
	protected String group_name = null;
	/** GROUP_DESC **/
	protected String group_desc = null;
	/** GROUP_LEVEL **/
	protected int group_level = jp.engawa.common.db.DbUtil.INT_NULL;
	/** SUPER_GROUP_ID **/
	protected long super_group_id = jp.engawa.common.db.DbUtil.LONG_NULL;
	/** SHOP_ADD **/
	protected int shop_add = jp.engawa.common.db.DbUtil.INT_NULL;
	/** REGIST_DT **/
	protected java.util.Date regist_dt = new java.util.Date();;
	/** DEL_KBN **/
	protected int del_kbn = 0;

	/** テーブル名 **/
	public String getTableName() {
		return "OD_SHOP_GROUP";
	}
	/** ID **/
	public long getKeyIdAuto() { return this.id; }
	public void setKeyIdAuto(long id) {this.id = id; }

	/** GROUP_CD **/
	public String getColGroupCd() { return this.group_cd; }
	public void setColGroupCd(String group_cd) {this.group_cd = group_cd; }

	/** GROUP_NAME **/
	public String getColGroupName() { return this.group_name; }
	public void setColGroupName(String group_name) {this.group_name = group_name; }

	/** GROUP_DESC **/
	public String getColGroupDesc() { return this.group_desc; }
	public void setColGroupDesc(String group_desc) {this.group_desc = group_desc; }

	/** GROUP_LEVEL **/
	public int getColGroupLevel() { return this.group_level; }
	public void setColGroupLevel(int group_level) {this.group_level = group_level; }

	/** SUPER_GROUP_ID **/
	public long getColSuperGroupId() { return this.super_group_id; }
	public void setColSuperGroupId(long super_group_id) {this.super_group_id = super_group_id; }

	/** SHOP_ADD **/
	public int getColShopAdd() { return this.shop_add; }
	public void setColShopAdd(int shop_add) {this.shop_add = shop_add; }

	/** REGIST_DT **/
	public java.util.Date getColRegistDt() { return this.regist_dt; }
	public void setColRegistDt(java.util.Date regist_dt) {this.regist_dt = regist_dt; }

	/** DEL_KBN **/
	public int getColDelKbn() { return this.del_kbn; }
	public void setColDelKbn(int del_kbn) {this.del_kbn = del_kbn; }

}