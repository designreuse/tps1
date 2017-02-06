package igc.tech.com.dao;

import java.util.List;

public interface RegionDao {

    public List procRegion(String regionId, String regionName,
                           String countryId, String user, String flag);

}
