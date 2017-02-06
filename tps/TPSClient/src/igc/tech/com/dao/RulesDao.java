package igc.tech.com.dao;

import igc.tech.com.model.RulesModel;

import java.util.List;


public interface RulesDao {

	public List procRules(RulesModel rulesModel, String user, String flag);
	
}
