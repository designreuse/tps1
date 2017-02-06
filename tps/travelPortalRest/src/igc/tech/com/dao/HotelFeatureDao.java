package igc.tech.com.dao;

import igc.tech.com.model.HotelFeatureModel;

import java.util.List;

public interface HotelFeatureDao {


    public List procHotelFeature(HotelFeatureModel hotelFeatureModel,
                                 String user, String flag);

}
