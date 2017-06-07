package jp.engawa.ondo.common;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class KengenTag extends TagSupport {
	private String level;
	private String not;

	@Override
	public int doStartTag() throws JspException {
		User u = (User) this.pageContext.getSession().getAttribute(
				IConst.SESSION_KEY_USER);
		if (u == null) {
			return TagSupport.SKIP_BODY;
		}
		int lvl = User.admin_level(this.level);
		int ulevel = u.getAdmin_kbn();
		if (lvl <= ulevel) {
			if("true".equals(this.not)) {
				return TagSupport.SKIP_BODY;
			} else {
				return TagSupport.EVAL_PAGE;
			}
		} else {
			if("true".equals(this.not)) {
				return TagSupport.EVAL_PAGE;
			} else {
				return TagSupport.SKIP_BODY;
			}
		}
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getNot() {
		return not;
	}

	public void setNot(String not) {
		this.not = not;
	}
}
