package igc.tech.com.dao;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 2/9/2016.
 */
public interface AreaDao {

    @SuppressWarnings("rawtypes")
    public List procArea(String areaId,
                                   String areaName,String regionId,String countryId, String user, String flag);
}
