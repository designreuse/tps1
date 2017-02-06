package igc.tech.com.dao;

import igc.tech.com.model.MenuModel;

import java.util.List;


public interface MenuDao {

	public List procMenu(MenuModel menuModel, String user, String flag);
	
}
