package igc.tech.com.dao;

import igc.tech.com.model.HotelReviewReplyModel;

import java.util.List;

public interface HotelReviewReplyDao {

	public List procHotelReviewReply(HotelReviewReplyModel hotelReviewReplyModel, String user, String flag);
}
