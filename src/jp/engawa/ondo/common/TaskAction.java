package jp.engawa.ondo.common;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import jp.engawa.common.db.Db;
import jp.engawa.gs.common.AbstractAppAction;

public abstract class TaskAction extends AbstractAppAction implements IConst {

	@Override
	public String execute() throws IOException,SQLException {
		String ret = this.exec();
		return ret;
	}
	protected Db getDb() throws SQLException {
		return Db.getInstance(this);
	}	
	
	protected abstract String exec() throws IOException, SQLException;
	
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
}
