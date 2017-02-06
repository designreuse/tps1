package igc.tech.com.dao;

import igc.tech.com.model.HotelSearchModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface OutOfRoomFilterDao {

    public List procOoutOfRoomFilter(String roomDetailId, String checkInDate, String checkOutDate,
                                String noOfRooms, String noOfAdult,
                                String noOfChild, String childAges, String amenities,
                                String fromPrice, String toPrice);

}
