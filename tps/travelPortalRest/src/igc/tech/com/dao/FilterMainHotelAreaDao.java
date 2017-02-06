package igc.tech.com.dao;

import igc.tech.com.model.ExtraBedModel;
import igc.tech.com.model.HotelFilterModel;

import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface FilterMainHotelAreaDao {

    public Map<String, Object> procFilterMainHotelArea(HotelFilterModel hotelFilterModel);

}
