package igc.tech.com.dao;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 2/14/2016.
 */
public interface HotelRulesDao {

    public List procHotelRules(String hotelRulesId, String rulesId,
                                String hotelDetailId,String user, String flag);

}



