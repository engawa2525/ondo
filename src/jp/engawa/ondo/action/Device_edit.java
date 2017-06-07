package jp.engawa.ondo.action;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.DefaultOption;
import jp.engawa.gs.common.IOption;
import jp.engawa.gs.common.Util;
import jp.engawa.ondo.common.AdminLevel;
import jp.engawa.ondo.common.User;

@AdminLevel("developer")
public class Device_edit extends Device {
	private String start_dt_ymd;
	private String start_dt_hm;
	private String end_dt_ymd;
	private String end_dt_hm;
	
	private List<IOption> hms;
	
	@Override
	protected String execute(User user) throws IOException,SQLException {
		prepare_edit(user);
		loadKbn();
		if(this.isPost()) {
			if("del".equals(this.getCmd())) {
				if(del()) {
					this.info("削除しました。");					
					this.setRedirect("./devices.do");
					return null;
				}
			} else {
				if(upd()) {
					this.info("更新しました。");
					this.setRedirect("./device.do?id=" + this.id);
					return null;
				} else {
					invalidLoad();
				}
			}
		}
		if(this.isGet()) {
			if(this.id != null && this.id > 0) {
				this.load();
				this.after_load();
			} else {
				init_edit(user);
			}
		}
		return null;
	}
	protected void after_load() throws SQLException {
		if(this.start_dt != null) {
			String[] d0 = buildYmdHm(this.start_dt);
			this.start_dt_ymd = d0[0];
			this.start_dt_hm = d0[1];
		}
		if(this.end_dt != null) {
			String[] d0 = buildYmdHm(this.end_dt);
			this.end_dt_ymd = d0[0];
			this.end_dt_hm = d0[1];
		}
	}
	
	protected String[] buildYmdHm(Date dt) {
		if(dt == null) {
			return new String[]{"",""};
		}
		String ymd = Util.toYmd(dt);
		String hm = new SimpleDateFormat("HH:mm").format(dt);
		String hm0 = null;
		for(IOption o:this.hms) {
			if(o.getValue().equals(hm)) {
				hm0 = o.getValue();
			}
		}
		if(hm0 == null) {
			IOption o0 = this.hms.get(0);
			for(IOption o:this.hms) {
				if(o.getValue().compareTo(hm) <= 0) {
					break;
				} else {
					o0 = o;
				}
			}
			hm0 = o0.getValue();
		}
		if(hm0 != null) {
			return new String[]{ymd,hm0};
		}
		return new String[]{"",""};
	}
	
	protected void loadKbn() throws SQLException {
		super.loadKbn();
		
		Db db = null;
		try {
			db = this.getDb();
			this.hms = buildTimeOptions();
		} finally {
			db.close();
		}
	}
	
	protected List<IOption> buildTimeOptions() {
		List<IOption> list = new ArrayList<>();
		DecimalFormat dformat = new DecimalFormat("00");
		for(int ii=0;ii<24;ii++) {
			String hh = dformat.format(ii);
			list.add(new DefaultOption(hh+":00"));
			list.add(new DefaultOption(hh+":30"));
		}
		return list;
	}
	
	public boolean isUpd() {
		if(this.id != null && this.id > 0) {
			return true;
		}
		return false;
	}
	protected void init_edit(User user) throws SQLException,IOException {
	}
	protected void prepare_edit(User user) throws SQLException,IOException {
		this.start_dt = toDate(this.start_dt_ymd,this.start_dt_hm);
		this.end_dt = toDate(this.end_dt_ymd,this.end_dt_hm);
	}
	
	protected Date toDate(String ymd,String hm) {
		String ymd0 = Util.toYmd(ymd,false);
		if(ymd0 != null && ymd0.length() > 0) {
			SimpleDateFormat dformat = new SimpleDateFormat("yyyyMMdd HH:mm");
			try {
				Date dt = dformat.parse(ymd0 + " " + hm);
				return dt;
			} catch(Exception ex) {
				return null;
			}
		} else {
			return null;
		}
	}
	
	protected void invalidLoad() throws SQLException {
		Db db = null;
		try {
			db = this.getDb();
			if(this.id != null && this.id > 0) {
				jp.engawa.ondo.entity.OdDeviceEntity en = new jp.engawa.ondo.entity.OdDeviceEntity();
				en.setKeyIdAuto(this.id);
				if(db.load(en)) {
					this.last_access = en.getColLastAccess();
					this.regist_dt = en.getColRegistDt();
				}
			}
		} finally {
			db.close();
		}
	}
	
	protected boolean upd() throws SQLException,IOException {
		Db db = null;
		try {
			db = this.getDb();
			if(!validate(db)) {
				return false;
			}
			if(this.isUpd()) {
				jp.engawa.ondo.entity.OdDeviceEntity en = new jp.engawa.ondo.entity.OdDeviceEntity();
				en.setKeyIdAuto(this.id);
				if(db.load(en)) {
					en.setColTargetId(this.getTarget_id());
					en.setColDeviceStatus(this.getDevice_status());
					en.setColDeviceCd(this.getDevice_cd());
					en.setColDeviceType(this.getDevice_type());
					en.setColShopId(this.getShop_id());
					//en.setColLastAccess(this.getLast_access());
					en.setColStartDt(this.getStart_dt());
					en.setColEndDt(this.getEnd_dt());
					db.update(en);
					return true;
				}
			} else {
				jp.engawa.ondo.entity.OdDeviceEntity en = new jp.engawa.ondo.entity.OdDeviceEntity();
				en.setColTargetId(this.getTarget_id());
				en.setColDeviceStatus(this.getDevice_status());
				en.setColDeviceCd(this.getDevice_cd());
				en.setColDeviceType(this.getDevice_type());
				en.setColShopId(this.getShop_id());
				//en.setColLastAccess(this.getLast_access());
				en.setColStartDt(this.getStart_dt());
				en.setColEndDt(this.getEnd_dt());
				en.setColRegistDt(new Date());
				this.id = db.insert(en);
				return true;
			}
		} finally {
			db.close();
		}
		return true;
	}
	protected boolean del() throws SQLException,IOException {
		Db db = null;
		try {
			db = this.getDb();
			if(this.id == null || this.id <= 0) {
				this.setErrmsg("データが特定できませんでした。");
				return false;
			}
			String sql = "UPDATE OD_DEVICE SET DEL_KBN=1 WHERE ID=[ID]";
			db.setSql(sql);
			db.add("ID",this.id);
			db.update();
			return true;
		} finally {
			db.close();
		}
	}
	
	protected boolean validate(Db db) throws SQLException {
		return true;
	}

	public String getStart_dt_ymd() {
		return Util.toYmdHaihun(start_dt_ymd);
	}

	public void setStart_dt_ymd(String start_dt_ymd) {
		this.start_dt_ymd = Util.toYmd(start_dt_ymd,false);
	}

	public String getStart_dt_hm() {
		return start_dt_hm;
	}

	public void setStart_dt_hm(String start_dt_hm) {
		this.start_dt_hm = start_dt_hm;
	}

	public String getEnd_dt_ymd() {
		return Util.toYmdHaihun(end_dt_ymd);
	}

	public void setEnd_dt_ymd(String end_dt_ymd) {
		this.end_dt_ymd = Util.toYmd(end_dt_ymd,false);
	}

	public String getEnd_dt_hm() {
		return end_dt_hm;
	}

	public void setEnd_dt_hm(String end_dt_hm) {
		this.end_dt_hm = end_dt_hm;
	}

	public List<IOption> getHms() {
		return hms;
	}

	public void setHms(List<IOption> hms) {
		this.hms = hms;
	}
}