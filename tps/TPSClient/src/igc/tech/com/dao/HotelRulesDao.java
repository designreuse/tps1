package igc.tech.com.dao;

import igc.tech.com.model.HotelRulesModel;

import java.util.List;

public interface HotelRulesDao {


    public List procHotelRules(HotelRulesModel hotelRulesModel,
                               String user, String flag);

}
