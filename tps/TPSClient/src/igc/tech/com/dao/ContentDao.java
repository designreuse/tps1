package igc.tech.com.dao;

import igc.tech.com.model.ContentModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface ContentDao {

    public List procContent(ContentModel contentModel,
                             String user,
                             String flag);

}
