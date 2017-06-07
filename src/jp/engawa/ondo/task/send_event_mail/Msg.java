package jp.engawa.ondo.task.send_event_mail;

import jp.engawa.gs.mail.IMsg;

public class Msg implements IMsg {
	private String from = "ondo@engawa2525.com";
	private String[] to = new String[]{"okuyama@engawa.jp"};
	private String[] cc = new String[]{};
	private String body = "TEST";
	private String subject = "TEST";


	public String[] getTo() {
		return to;
	}

	public void setTo(String to) {
		if(to == null || to.equals("")) {
			this.to = new String[0];
		} else {
			this.to= to.split(",");
		}
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String cc) {
		if(cc == null || cc.equals("")) {
			this.cc = new String[0];
		} else {
			String[] split = cc.split(",");
			this.cc = split;
		}
	}

}
