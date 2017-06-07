package jp.engawa.ondo.common;

public interface IConst {
	public static final String INIT_KEY_APPLICATION_TITLE = "application.title";
	public static final String INIT_KEY_ALERT_MAIL_FROM = "alert.mail.from";
	public static final String INIT_KEY_ALERT_MAIL_CC = "alert.mail.cc";
	
	public static final String ACTION_TOP = "action.top";
	public static final String ACTION_LOGIN = "action.login";
	public static final String ACTION_CHANGE_PSW = "action.change.psw";
	
	
	public static final String SESSION_KEY_USER = "ondo.user";	
	public static final String SESSION_KEY_NEXT_URL = "ondo.next.url";
	public static final String SESSION_KEY_LINE_LOGIN = "ondo.line.login.num";
	
	public static final int PASSWORD_NONE = 0;
	public static final int PASSWORD_CHANGE_MUST = 1;
	public static final int PASSWORD_CHANGE_RECOMMEND = 2;
	public static final int PASSWORD_LOCKOUT = 3;
	
	public static final int KENGEN_DEVELOPER = 10000;
	public static final int KENGEN_ADMIN = 9000;
	public static final int KENGEN_SHOP_OWNER = 8000;
	public static final int KENGEN_MEMBER = 0;	
}
