package igc.tech.com.dao;

import igc.tech.com.model.MailServerSettingModel;

import java.util.List;


public interface MailServerSettingDao {

	public List procMailServerSetting(MailServerSettingModel mailServerSettingModel, String user, String flag);
	
}
