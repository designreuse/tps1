package igc.tech.com.dao;

import igc.tech.com.model.ContentCommentModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface ContentCommentDao {

    public List procContentComment(ContentCommentModel contentCommentModel,
                             String user,
                             String flag);

}
