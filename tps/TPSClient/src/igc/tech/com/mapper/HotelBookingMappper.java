package igc.tech.com.mapper;

import com.sun.org.apache.bcel.internal.generic.IFNULL;
import igc.tech.com.model.HotelBookingModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HotelBookingMappper {

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

        HotelBookingModel hotelBookingModel = new HotelBookingModel();
        System.out.println(hotelBookingModel);

        hotelBookingModel.setHotelBookingId(map.get("HOTEL_BOOKING_ID").toString());
        hotelBookingModel.setCheckInDate(map.get("CHECK_IN_DATE").toString());
        hotelBookingModel.setCheckOutDate(map.get("CHECK_OUT_DATE").toString());
        hotelBookingModel.setNoOfRooms(map.get("no_of_rooms").toString());
        hotelBookingModel.setNoOfAdults(map.get("no_of_adults").toString());
        hotelBookingModel.setNoOfChild(map.get("no_of_childs")==null?null:map.get("no_of_childs").toString());
        hotelBookingModel.setFinalRate(map.get("final_rate").toString());
        hotelBookingModel.setCustomerDetailId(map.get("customer_detail_id")==null?null:map.get("customer_detail_id").toString());
        hotelBookingModel.setRoomDetailId(map.get("room_detail_id").toString());
        hotelBookingModel.setReserveType(map.get("reserve_type")==null? null:map.get("reserve_type").toString());
        hotelBookingModel.setCancelStatus(map.get("cancel_status")==null?null:map.get("cancel_status").toString());
        hotelBookingModel.setCancelDate(map.get("cancel_date")==null?null:map.get("cancel_date").toString());
        hotelBookingModel.setGuestName(map.get("guest_name").toString());
        hotelBookingModel.setGuestPhNo(map.get("guest_ph_no").toString());
        hotelBookingModel.setGuestEmailId(map.get("guest_email_id").toString());
        if (map.get("HASH_CODE") != null) {
            hotelBookingModel.setHashCode(map.get("HASH_CODE").toString());
        }
        hotelBookingModel.setNoOfGuest(map.get("no_of_guest").toString());
        hotelBookingModel.setRate(map.get("RATE").toString());
        hotelBookingModel.setExtraAdult(map.get("extra_adult")==null?null:map.get("extra_adult").toString());
        hotelBookingModel.setExtraChild(map.get("extra_child")==null?null:map.get("extra_child").toString());
        hotelBookingModel.setActualRate(map.get("actual_rate")==null?null:map.get("actual_rate").toString());

        hotelBookingModel.setOfferId(map.get("offer_id")==null?null:map.get("offer_id").toString());
        hotelBookingModel.setOfferName(map.get("offer_name")==null?null:map.get("offer_name").toString());
        hotelBookingModel.setOfferAmount(map.get("offer_amount")==null?null:map.get("offer_amount").toString());
        hotelBookingModel.setPayAtHotel(map.get("pay_at_hotel").toString());
        hotelBookingModel.setPayAtHotelDate(map.get("pay_at_hotel_date")==null?null:map.get("pay_at_hotel_date").toString());
        hotelBookingModel.setInvoice(map.get("invoice").toString());

        hotelBookingModel.setAirportShuttle(map.get("airport_shuttle").toString());
        hotelBookingModel.setIdentificationNo(map.get("identification_no")==null?null:map.get("identification_no").toString());
        hotelBookingModel.setCountry(map.get("country")==null?null:map.get("country").toString());
        hotelBookingModel.setSpecialRequest(map.get("special_request")==null?null:map.get("special_request").toString());
        hotelBookingModel.setRoomDesc(map.get("room_type_desc")==null?null:map.get("room_type_desc").toString());
        hotelBookingModel.setHotelName(map.get("hotel_name")==null?null:map.get("hotel_name").toString());
        hotelBookingModel.setHotelArrival(map.get("hotel_arrival")==null?null:map.get("hotel_arrival").toString());
        hotelBookingModel.setHotelArrivalDate(map.get("hotel_arrival_date")==null?null:map.get("hotel_arrival_date").toString());

        return hotelBookingModel;
    }

}
