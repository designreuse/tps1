package igc.tech.com.dao;

import igc.tech.com.model.HotelFilterModel;

import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface FilterMainHotelWiseDao {

    public Map<String, Object> procFilterMainHotelWise(HotelFilterModel hotelFilterModel);

}
