package igc.tech.com.dao;

import igc.tech.com.model.EsewaConfigModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface EsewaConfigDao {

    public List procEsewaConfig(EsewaConfigModel esewaConfigModel,
                                String user,
                                String flag);

}
