package igc.tech.com.mapper;

import igc.tech.com.model.HotelBookingStatusModel;
import igc.tech.com.model.PackageBookingStatusModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HotelBookingStatusMapper {

    @SuppressWarnings("rawtypes")
    public List<HotelBookingStatusModel> mapList(List<Map> list) {

        List<HotelBookingStatusModel> resultList = new ArrayList<>();

        HotelBookingStatusModel hotelBookingStatusModel;

        for (Map m : list) {
            hotelBookingStatusModel = mapRow(m);
            resultList.add(hotelBookingStatusModel);
        }

        return resultList;
    }

    @SuppressWarnings("rawtypes")
    public HotelBookingStatusModel mapRow(Map map) {

        HotelBookingStatusModel hotelBookingStatusModel = new HotelBookingStatusModel();


        if (map.get("hotel_booking_status_id") != null) {
            hotelBookingStatusModel.setHotelBookingStatusId(map.get("hotel_booking_status_id").toString());
        }


        if (map.get("hotel_booking_id") != null) {
            hotelBookingStatusModel.setHotelBookingId(map.get("hotel_booking_id").toString());

        }


        if (map.get("hotel_status") != null) {
            hotelBookingStatusModel.setHotelStatus(map.get("hotel_status").toString());

        }

        if (map.get("active") != null) {
            hotelBookingStatusModel.setActive(map.get("active").toString());

        }
        if (map.get("hash_code") != null) {
            hotelBookingStatusModel.setHashCode(map.get("hash_code").toString());

        }

        return hotelBookingStatusModel;
    }


}
