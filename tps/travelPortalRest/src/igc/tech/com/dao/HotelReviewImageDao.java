package igc.tech.com.dao;

import igc.tech.com.model.HotelReviewImageModel;

import java.util.List;

public interface HotelReviewImageDao {

	public List procHotelReviewImage(HotelReviewImageModel hotelReviewImageModel, String user, String flag);
}
