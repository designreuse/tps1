package igc.tech.com.mapper;

import igc.tech.com.model.ActivityModel;
import igc.tech.com.model.HotelBookingModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class HotelBookingMapper {


    public List<HotelBookingModel> mapList(List<Map> list) {

        List<HotelBookingModel> resultList = new ArrayList<>();

        HotelBookingModel hotelBookingModel;

        for (Map m : list) {
            hotelBookingModel = mapRow(m);
            resultList.add(hotelBookingModel);
        }

        return resultList;
    }

    public HotelBookingModel mapRow(Map map) {

        HotelBookingModel hotelBookingModel= new HotelBookingModel();

        hotelBookingModel.setHashCode(map.get("hash_code")==null? null:map.get("hash_code").toString() );
        hotelBookingModel.setHotelBookingId(map.get("hotel_booking_id")==null? null:map.get("hotel_booking_id").toString() );
        hotelBookingModel.setInvoice(map.get("invoice")==null? null:map.get("invoice").toString() );
        hotelBookingModel.setFinalRate(map.get("final_rate")==null? null:map.get("final_rate").toString() );
        hotelBookingModel.setStatus(map.get("status")==null? null:map.get("status").toString());
        hotelBookingModel.setMessage(map.get("msg")==null? null:map.get("msg").toString());

        return hotelBookingModel;
    }
}
