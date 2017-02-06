package igc.tech.com.dao;

import java.util.List;

public interface MailServerSettingDao {

	public List procMailServerSetting(String mailServerSettingId, String emailId, String password, String host, String port, String active, String userName,
									  String user, String flag);
}
