package jp.engawa.ondo.action;

import java.io.IOException;

import jp.engawa.gs.common.NoLogin;
import jp.engawa.ondo.common.AppAction;
import jp.engawa.ondo.common.IConst;
import jp.engawa.ondo.common.User;

@NoLogin
public class Logout extends AppAction {

	@Override
	protected String execute(User user) throws IOException {
		logout();
		this.setRedirect(this.getContextParameter(IConst.ACTION_LOGIN));		
		return null;
	}
	
	protected void logout() throws IOException {
		this.getSession().removeAttribute(IConst.SESSION_KEY_USER);		
	}
}
