package igc.tech.com.dao;

import igc.tech.com.model.TempContentDataModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface TempContentDataDao {

    public List procTempContentData(TempContentDataModel tempContentDataModel,
                                    String user,
                                    String flag);

}
