package igc.tech.com.dao;

import igc.tech.com.model.ActivityModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface ActivityDao {

    public List procActivity(ActivityModel tokenModel,
                             String user,
                             String flag);

}
