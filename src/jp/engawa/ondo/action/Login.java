package jp.engawa.ondo.action;

import java.io.IOException;
import java.sql.SQLException;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.NoLogin;
import jp.engawa.ondo.common.AppAction;
import jp.engawa.ondo.common.IConst;
import jp.engawa.ondo.common.User;
import jp.engawa.ondo.entity.OdUserEntity;

@NoLogin
public class Login extends AppAction {
	protected String userid;
	protected String psw;
	protected User us;
	
	@Override
	protected String execute(User user) throws IOException, SQLException {
		prepare();
		if(this.isPost()) {
			if(this.isLogin()) {
				this.us = user;
				if(us != null) {
					if(us.getPsw_kbn() == IConst.PASSWORD_CHANGE_RECOMMEND || us.getPsw_kbn() == IConst.PASSWORD_CHANGE_MUST) {
						this.setRedirect(this.getContextParameter(IConst.ACTION_CHANGE_PSW));
						return null;
					}
				}
				String next = (String)this.getSession().getAttribute(IConst.SESSION_KEY_NEXT_URL);
				if(next != null) {
					this.getSession().removeAttribute(IConst.SESSION_KEY_NEXT_URL);
					this.setRedirect(next);
					System.out.println("LOGIN NEXT:" + next);
				} else {
					this.setRedirect(this.getContextParameter(IConst.ACTION_TOP));
					System.out.println("LOGIN TOP");
				}
				return null;
			}
			if(this.login()){
				if(us != null) {
					if(us.getPsw_kbn() == IConst.PASSWORD_CHANGE_RECOMMEND || us.getPsw_kbn() == IConst.PASSWORD_CHANGE_MUST) {
						this.setRedirect(this.getContextParameter(IConst.ACTION_CHANGE_PSW));
						return null;
					}
				}
				String next = (String)this.getSession().getAttribute(IConst.SESSION_KEY_NEXT_URL);
				if(next != null) {
					this.getSession().removeAttribute(IConst.SESSION_KEY_NEXT_URL);
					this.setRedirect(next);
					System.out.println("LOGIN NEXT2:" + next);
				} else {
					this.setRedirect(this.getContextParameter(IConst.ACTION_TOP));
					System.out.println("LOGIN TOP2");
				}
			}
		} else {
			if(this.isLogin()) {
				this.setRedirect(this.getContextParameter(IConst.ACTION_TOP));
			}
		}
		return null;
	}
	
	protected void prepare() throws SQLException {
	}	

	protected boolean login() throws SQLException{
		if(this.isEmpty(this.userid)){
			this.setErrmsg("User IDを入力してください。");
			return false;
		}
		if(this.isEmpty(this.psw)){
			this.setErrmsg("パスワードを入力してください。");
			return false;
		}
		Db db = null;
		try {
			db = this.getDb();
			String sql = "SELECT * FROM OD_USER WHERE DEL_KBN=0 AND ACCOUNT_KEY=[KEY] AND ACCOUNT_PSW=PASSWORD([PSW]) ORDER BY ID LIMIT 1";
			db.add("KEY", this.userid);
			db.add("PSW",  this.psw);
			db.setSql(sql);
			db.execute(OdUserEntity.class);
			OdUserEntity en = null;
			while(db.next()){
				en = (OdUserEntity)db.getEntity();
			}
			if(en == null) {
				this.setErrmsg("ユーザーIDまたはパスワードが一致しません。");
				return false;
			}
			this.us =  login(db,en);
			return true;
		} finally {
			db.close();
		}
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public User getUs() {
		return us;
	}

	public void setUs(User us) {
		this.us = us;
	}
}
