package igc.tech.com.dao;

import igc.tech.com.model.HotelDetailModel;

import java.util.List;

public interface HotelDetailDao {


    public List procHotelDetail(HotelDetailModel hotelDetailModel,
                                String user, String flag);

}
