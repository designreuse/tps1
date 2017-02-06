package igc.tech.com.dao;

import igc.tech.com.model.HotelFilterModel;

import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface FilterAdvanceDao {

    public Map<String, Object> procFilterAdvance(HotelFilterModel hotelFilterModel) ;

}
