package igc.tech.com.dao;

import java.util.List;

public interface HotelDetailDao {


    public List procHotelDetail(String hotelDetailId, String hotelName, String hotelPhNo1, String hotelPhNo2,
                                String hotelPhNo3, String hotelAddress, String hotelEmailId, String personalDetail,
                                String personalPhNo, String personalEmailId,  String areaId, String
                                        clientDetailId, String url,
                                String user, String flag);

}
