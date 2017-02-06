package igc.tech.com.dao;

import igc.tech.com.model.AreaModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 2/9/2016.
 */
public interface AreaDao {

    @SuppressWarnings("rawtypes")
    public List procArea(AreaModel areaModel, String user, String flag);
}
