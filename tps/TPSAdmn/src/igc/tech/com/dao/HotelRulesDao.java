package igc.tech.com.dao;

import java.util.List;

public interface HotelRulesDao {


    public List procHotelRules(String hotelRulesId, String fulesId, String hotelDetailId, String active,
                                  String user, String flag);

}
