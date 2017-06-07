package jp.engawa.ondo.action.shop;

import jp.engawa.ondo.entity.OdTargetEntity;

public class Target {
	private long target_id;
	private String target_name;
	private int target_status;
	
	public Target(){}
	
	public Target(OdTargetEntity en) {
		this.target_id = en.getKeyIdAuto();
		this.target_name = en.getColTargetName();
		this.target_status = en.getColTargetStatus();
	}
	
	public long getTarget_id() {
		return target_id;
	}
	public void setTarget_id(long target_id) {
		this.target_id = target_id;
	}
	public String getTarget_name() {
		return target_name;
	}
	public void setTarget_name(String target_name) {
		this.target_name = target_name;
	}

	public int getTarget_status() {
		return target_status;
	}

	public void setTarget_status(int target_status) {
		this.target_status = target_status;
	}
}
