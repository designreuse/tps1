package igc.tech.com.dao;

import igc.tech.com.model.TagModel;

import java.util.List;


public interface TagDao {

	public List procTag(TagModel tagModel, String user, String flag);
	
}
