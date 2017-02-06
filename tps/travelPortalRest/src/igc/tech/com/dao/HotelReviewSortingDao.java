package igc.tech.com.dao;

import igc.tech.com.model.HotelReviewModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface HotelReviewSortingDao {

    public List procHotelReviewSorting(HotelReviewModel hotelReviewModel, String flag);

}
