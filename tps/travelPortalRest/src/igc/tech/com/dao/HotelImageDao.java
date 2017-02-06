package igc.tech.com.dao;

import igc.tech.com.model.HotelImageModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 2/14/2016.
 */
public interface HotelImageDao {

    public List procHotelImage(HotelImageModel hotelImageModel,
                               String user, String flag);

}



