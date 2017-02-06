package igc.tech.com.dao;

import igc.tech.com.model.ContentTagModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface ContentTagDao {

    public List procContentTag(ContentTagModel contentTagModel,
                             String user,
                             String flag);

}
