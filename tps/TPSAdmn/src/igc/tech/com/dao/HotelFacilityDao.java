package igc.tech.com.dao;

import java.util.List;

public interface HotelFacilityDao {


    public List procHotelFacility(String hotelFacilityId, String facilityId, String hotelDetailId, String active,
                                  String user, String flag);

}
