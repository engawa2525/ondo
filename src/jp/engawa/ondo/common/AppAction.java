package jp.engawa.ondo.common;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.AbstractAppAction;
import jp.engawa.gs.common.DefaultOption;
import jp.engawa.gs.common.IOption;
import jp.engawa.gs.common.NoLogin;
import jp.engawa.gs.common.NoNext;
import jp.engawa.ondo.entity.OdUserEntity;

public abstract class AppAction extends AbstractAppAction implements IConst {
	protected static final Locale DEFAULT_LOCALE = new Locale("JP");
	
	@Override
	public String execute() throws IOException,SQLException {
		this.request.setAttribute("Locale", DEFAULT_LOCALE);		
		User u = (User)this.getSession().getAttribute(IConst.SESSION_KEY_USER);
		if(u == null) {
			u = (User)this.getRequest().getAttribute(IConst.SESSION_KEY_USER);
		}
		
		if(!this.isNoLogin()) {
			if(u == null) {
				String next = this.getContextParameter(IConst.ACTION_LOGIN);
				if(this.isGet()) {
					if(!this.isNoNext()) {
						String url = nexturl(this.getRequest());;
						this.getSession().setAttribute(IConst.SESSION_KEY_NEXT_URL, url);
					}
				}
				this.setRedirect(next);
				return null;
			}
			if(u.getPsw_kbn() == IConst.PASSWORD_CHANGE_MUST) {
				String next = this.getContextParameter(IConst.ACTION_CHANGE_PSW);
				this.setRedirect(next);
				return null;				
			}			
		}
		String err = (String)this.getSession().getAttribute(jp.engawa.gs.common.IConst.SESSION_KEY_ERRMSG);
		if(err != null) {
			this.setErrmsg(err);
			this.getSession().removeAttribute(jp.engawa.gs.common.IConst.SESSION_KEY_ERRMSG);
		}
		String info = (String)this.getSession().getAttribute(jp.engawa.gs.common.IConst.SESSION_KEY_INFO);
		if(info != null) {
			this.setInfo(info);
			this.getSession().removeAttribute(jp.engawa.gs.common.IConst.SESSION_KEY_INFO);
		}
		if(kengenLevel()) {
			String ret = this.execute(u);
			if(ret == null) {
				if("info.jsp.code".equals(this.getCmd())) {
					request.setAttribute("req_uri", request.getRequestURI());
					request.setAttribute("cls", this.getClass());
					ret = "/info.jsp.code";
				} else if("edit.jsp.code".equals(this.getCmd())) {
					request.setAttribute("req_uri", request.getRequestURI());
					request.setAttribute("cls", this.getClass());
					ret = "/edit.jsp.code";
				} else if("entity.set.code".equals(this.getCmd())) {
					request.setAttribute("req_uri", request.getRequestURI());
					request.setAttribute("cls", this.getClass());
					ret = "/entity.set.code";
				} else if("edit.class.code".equals(this.getCmd())) {
					request.setAttribute("req_uri", request.getRequestURI());
					request.setAttribute("cls", this.getClass());
					ret = "/edit.class.code";
				} else if("item.class.code".equals(this.getCmd())) {
					request.setAttribute("req_uri", request.getRequestURI());
					request.setAttribute("cls", this.getClass());
					ret = "/item.class.code";
				} else if("info.class.code".equals(this.getCmd())) {
					request.setAttribute("req_uri", request.getRequestURI());
					request.setAttribute("cls", this.getClass());
					ret = "/info.class.code";
				} else if("table.class.code".equals(this.getCmd())) {
					request.setAttribute("req_uri", request.getRequestURI());
					request.setAttribute("cls", this.getClass());
					ret = "/table.class.code";
				} else if("table.jsp.code".equals(this.getCmd())) {
					request.setAttribute("req_uri", request.getRequestURI());
					request.setAttribute("cls", this.getClass());
					ret = "/table.jsp.code";						
				}			
			}
			return ret;
		}  else {
			this.setRedirect(this.getContextParameter(IConst.ACTION_TOP));
			return null;
		}
	}
	protected Db getDb() throws SQLException {
		return Db.getInstance(this);
	}	
	
	protected abstract String execute(User user) throws IOException, SQLException;
	
	protected boolean kengenLevel() {
		AdminLevel an = (AdminLevel)this.getClass().getAnnotation(AdminLevel.class);
		if(an != null) {
			User user = (User)this.getSession().getAttribute(IConst.SESSION_KEY_USER);		
			if(user == null) return false;
			String val = an.value();
			int level = User.admin_level(val);
			if(user.getAdmin_kbn() >= level) {
				return true;
			}
			return false;
		} else {
			return true;
		}
	}
	
	protected static List<IOption> buildList(Db db,String sql) throws SQLException {
		List<IOption> ret = new ArrayList<IOption>();
		db.setSql(sql);
		db.execute();
		while(db.next()) {
			String value = db.get(1);
			String label = db.get(2);
			ret.add(new DefaultOption(value, label));
		}
		return ret;
	}	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected boolean isNoLogin() {
		Class cls = this.getClass();
		Annotation an = cls.getAnnotation(NoLogin.class);
		if(an != null) {
			return true;
		}
		return false;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected boolean isNoNext() {
		Class cls = this.getClass();
		Annotation an = cls.getAnnotation(NoNext.class);
		if(an != null) {
			return true;
		}
		return false;
	}	
	
	public boolean isLogin() {
		if(this.getUser() == null) {
			return false;
		}
		return true;
	}
	
	public User getUser() {
		User u = (User)this.getSession().getAttribute(IConst.SESSION_KEY_USER);
		if(u == null) {
			u = (User)this.getRequest().getAttribute(IConst.SESSION_KEY_USER);
		}
		return u;
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public String getContextParameter(String key) {
		HashMap<String, String> map = (HashMap<String, String>)this.getContext().getAttribute(AppListener.APPLICATION_KEY_CONFIG);
		if(map != null) {
			String obj = map.get(key);
			if(obj != null) {
				return obj;
			}
		}
		return super.getContextParameter(key);
	}
	protected String nexturl(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		sb.append(request.getRequestURI());
		String qs = request.getQueryString();
		if(qs != null && qs.length() > 0) {
			sb.append("?");
			sb.append(qs);
		}
		return sb.toString();
	}
	
	protected User login(Db db,OdUserEntity en) throws SQLException {
		User user = new User(db,en);
		this.session.setAttribute(IConst.SESSION_KEY_USER, user);
		return user;
	}	
}
