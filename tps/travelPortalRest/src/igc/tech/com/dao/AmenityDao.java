package igc.tech.com.dao;

import igc.tech.com.model.AmenityModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface AmenityDao {

    public List procAmenity(AmenityModel tokenModel,
                            String user,
                            String flag);

}
