package igc.tech.com.dao;

import igc.tech.com.model.PushContentDataModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface PushContentDataDao {

    public List procPushContentData(PushContentDataModel pushContentDataModel,
                             String user,
                             String flag);

}
