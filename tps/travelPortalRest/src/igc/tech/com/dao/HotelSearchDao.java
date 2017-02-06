package igc.tech.com.dao;

import igc.tech.com.model.HotelSearchModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface HotelSearchDao {

    public List procHotelSearch(HotelSearchModel hotelSearchModel, String user, String flag);

}
