package igc.tech.com.dao;

import java.util.List;

public interface PackageLocationDao {

    @SuppressWarnings("rawtypes")
    public List procPackageLocation(String packageLocationId, String areaId, String packageItineraryId, String regionId,
                                    String user, String flag);

}
