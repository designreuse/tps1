package igc.tech.com.dao;

import igc.tech.com.model.HotelReviewModel;

import java.util.List;

public interface HotelReviewDao {

    public List procHotelReview(HotelReviewModel hotelReviewModel, String user, String flag) ;

}
