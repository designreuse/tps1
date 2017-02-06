package igc.tech.com.dao;

import igc.tech.com.model.RoleModel;

import java.util.List;


public interface RoleDao {

	public List procRole(RoleModel roleModel, String user, String flag);
	
}
