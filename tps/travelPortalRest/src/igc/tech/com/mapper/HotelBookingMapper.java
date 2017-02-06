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
        hotelBookingModel.setPayAtHotel(map.get("pay_at_hotel")==null? null:map.get("pay_at_hotel").toString());

        //////
        hotelBookingModel.setNoOfRooms(map.get("no_of_rooms")==null? null:map.get("no_of_rooms").toString());
        hotelBookingModel.setNoOfAdult(map.get("no_of_adults")==null? null:map.get("no_of_adults").toString());
        hotelBookingModel.setNoOfChild(map.get("no_of_child")==null? null:map.get("no_of_child").toString());
        hotelBookingModel.setReserveType(map.get("reserve_type")==null? null:map.get("reserve_type").toString());
        hotelBookingModel.setCancelStatus(map.get("cancel_status")==null? null:map.get("cancel_status").toString());
        hotelBookingModel.setCustomerDetailId(map.get("customer_detail_id")==null? null:map.get("customer_detail_id").toString());
        hotelBookingModel.setRoomDetailId(map.get("room_detail_id")==null? null:map.get("room_detail_id").toString());
        hotelBookingModel.setGuestName(map.get("guest_name")==null? null:map.get("guest_name").toString());
        hotelBookingModel.setGuestPhNo(map.get("guest_ph_no")==null? null:map.get("guest_ph_no").toString());
        hotelBookingModel.setGuestEmailId(map.get("guest_email_id")==null? null:map.get("guest_email_id").toString());
        hotelBookingModel.setEffAdult(map.get("eff_adult")==null? null:map.get("eff_adult").toString());
        hotelBookingModel.setEffChild(map.get("eff_child")==null? null:map.get("eff_child").toString());
        hotelBookingModel.setNoOfGuest(map.get("no_of_guest")==null? null:map.get("no_of_guest").toString());
        hotelBookingModel.setRate(map.get("rate")==null? null:map.get("rate").toString());
        hotelBookingModel.setExtraChild(map.get("extra_child")==null? null:map.get("extra_child").toString());
        hotelBookingModel.setExtraAdult(map.get("extra_adult")==null? null:map.get("extra_adult").toString());
        hotelBookingModel.setActualRate(map.get("actual_rate")==null? null:map.get("actual_rate").toString());
        hotelBookingModel.setOfferId(map.get("offer_id")==null? null:map.get("offer_id").toString());
        hotelBookingModel.setOfferName(map.get("offer_name")==null? null:map.get("offer_name").toString());
        hotelBookingModel.setOfferType(map.get("offer_type")==null? null:map.get("offer_type").toString());
        hotelBookingModel.setOfferAmount(map.get("offer_amount")==null? null:map.get("offer_amount").toString());
        hotelBookingModel.setPaid(map.get("paid")==null? null:map.get("paid").toString());
        hotelBookingModel.setPayType(map.get("pay_type")==null? null:map.get("pay_type").toString());
        hotelBookingModel.setActualAdult(map.get("actual_adult")==null? null:map.get("actual_adult").toString());
        hotelBookingModel.setActualChild(map.get("actual_child")==null? null:map.get("actual_child").toString());
        hotelBookingModel.setTotalGuest(map.get("total_guest")==null? null:map.get("total_guest").toString());
        hotelBookingModel.setTotalDays(map.get("total_days")==null? null:map.get("total_days").toString());

        hotelBookingModel.setHotelName(map.get("hotel_name")==null? null:map.get("hotel_name").toString());
        hotelBookingModel.setRoomTypeDesc(map.get("room_type_desc")==null? null:map.get("room_type_desc").toString());


        hotelBookingModel.setHotelPhNo1(map.get("hotel_ph_no_1")==null? null:map.get("hotel_ph_no_1").toString());
        hotelBookingModel.setHotelPhNo2(map.get("hotel_ph_no_2")==null? null:map.get("hotel_ph_no_2").toString());
        hotelBookingModel.setHotelPhNo3(map.get("hotel_ph_no_3")==null? null:map.get("hotel_ph_no_3").toString());
        hotelBookingModel.setAddressId(map.get("address_id")==null? null:map.get("address_id").toString());
        hotelBookingModel.setAirportShuttle(map.get("airport_shuttle")==null? null:map.get("airport_shuttle").toString());
        hotelBookingModel.setIdentificationNo(map.get("identification_no")==null? null:map.get("identification_no").toString());
        hotelBookingModel.setArrivalDateTime(map.get("arrival_date_time")==null? null:map.get("arrival_date_time").toString());
        hotelBookingModel.setCountry(map.get("country")==null? null:map.get("country").toString());
        hotelBookingModel.setCheckInTo(map.get("check_in_to")==null? null:map.get("check_in_to").toString());
        hotelBookingModel.setCheckOutTo(map.get("check_out_to")==null? null:map.get("check_out_to").toString());
        hotelBookingModel.setSpecialRequest(map.get("special_request")==null? null:map.get("special_request").toString());
        hotelBookingModel.setCheckInDate(map.get("check_in_date")==null? null:map.get("check_in_date").toString());
        hotelBookingModel.setCheckOutDate(map.get("check_out_date")==null? null:map.get("check_out_date").toString());
        hotelBookingModel.setMedium(map.get("medium")==null? null:map.get("medium").toString());
        hotelBookingModel.setHotelDetailId(map.get("hotel_detail_id")==null? null:map.get("hotel_detail_id").toString());
        hotelBookingModel.setPayAtHotelDate(map.get("pay_at_hotel_date")==null? null:map.get("pay_at_hotel_date").toString());
        hotelBookingModel.setPaidDate(map.get("paid_date")==null? null:map.get("paid_date").toString());
        hotelBookingModel.setChildAges(map.get("child_ages")==null? null:map.get("child_ages").toString());
        hotelBookingModel.setTotalBooked(map.get("total_booked")==null? null:map.get("total_booked").toString());
        hotelBookingModel.setCancelFlag(map.get("cancel_flag")==null? null:map.get("cancel_flag").toString());
        hotelBookingModel.setPayOptionFlag(map.get("pay_option_flag")==null? null:map.get("pay_option_flag").toString());
        hotelBookingModel.setCurrencyDesc(map.get("currency_desc")==null? null:map.get("currency_desc").toString());


        ///////////////////

        return hotelBookingModel;
    }
}
