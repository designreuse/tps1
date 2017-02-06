package igc.tech.com.dao;

import java.util.List;


public interface RulesDao {

	public List procRules(String rulesId, String rulesDesc, String type, String user, String flag);
	
}
