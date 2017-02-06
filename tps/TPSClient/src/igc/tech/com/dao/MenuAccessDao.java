package igc.tech.com.dao;

import igc.tech.com.model.MenuAccessModel;

import java.util.List;


public interface MenuAccessDao {

	public List procMenuAccess(MenuAccessModel menuAccessModel, String user, String flag);
	
}
