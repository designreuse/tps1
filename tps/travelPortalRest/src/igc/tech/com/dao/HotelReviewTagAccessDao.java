package igc.tech.com.dao;

import igc.tech.com.model.HotelReviewTagAccessModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface HotelReviewTagAccessDao {

    public List procHotelReviewTagAccess(HotelReviewTagAccessModel hotelReviewTagAccessModel, String user, String flag);

}
