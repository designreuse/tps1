package igc.tech.com.dao;

import igc.tech.com.model.HotelActivityModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface HotelActivityDao {

    public List procHotelActivity(HotelActivityModel hotelActivityModel,
                                  String user,
                                  String flag);

}
