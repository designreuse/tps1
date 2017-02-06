package igc.tech.com.dao;

import igc.tech.com.model.HotelRatingModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 2/14/2016.
 */
public interface HotelRatingDao {

    public List procHotelRating(HotelRatingModel hotelRatingModel, String user, String flag);

}



