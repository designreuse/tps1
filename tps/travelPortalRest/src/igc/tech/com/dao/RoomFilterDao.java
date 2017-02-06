package igc.tech.com.dao;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface RoomFilterDao {

    public List procRoomFilter(String hotelDetailId, String checkInDate, String checkOutDate,
                               String noOfRooms, String noOfAdult,
                               String noOfChild, String childAges, String amenities,String currencyDesc)  ;

}
