package igc.tech.com.dao;

import igc.tech.com.model.RegionModel;

import java.util.List;

public interface RegionDao {

    public List procRegion(RegionModel regionModel, String user, String flag);

}
