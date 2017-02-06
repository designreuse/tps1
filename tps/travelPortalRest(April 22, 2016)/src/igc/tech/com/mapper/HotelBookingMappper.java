package igc.tech.com.mapper;

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

        hotelBookingModel.setHotelBookingId(map.get("HOTEL_BOOKING_ID").toString());
        hotelBookingModel.setRoomTypeId(map.get("ROOM_TYPE_ID").toString());
        hotelBookingModel.setRoomDesc(map.get("ROOM_DESC").toString());
        hotelBookingModel.setRate(map.get("RATE").toString());
        hotelBookingModel.setAdult(map.get("ADULT").toString());
        hotelBookingModel.setChild(map.get("CHILD").toString());
        hotelBookingModel.setCustomerTitle(map.get("CUSTOMER_TITLE").toString());
        hotelBookingModel.setFirstName(map.get("FIRST_NAME").toString());
        if (map.get("MIDDLE_NAME") != null) {
            hotelBookingModel.setMiddleName(map.get("MIDDLE_NAME").toString());
        }
        hotelBookingModel.setLastName(map.get("LAST_NAME").toString());
        hotelBookingModel.setEmail(map.get("EMAIL").toString());
        hotelBookingModel.setContactNo(map.get("CONTACT_NO").toString());
        hotelBookingModel.setPassportNo(map.get("PASSPORT_NO").toString());
        hotelBookingModel.setCustomerType(map.get("CUSTOMER_TYPE").toString());
        hotelBookingModel.setCheckInDate(map.get("CHECK_IN_DATE").toString());
        hotelBookingModel.setCheckOutDate(map.get("CHECK_OUT_DATE").toString());
        hotelBookingModel.setCountryId(map.get("COUNTRY_ID").toString());
        hotelBookingModel.setCountryName(map.get("COUNTRY_NAME").toString());
        if (map.get("COMPANY") != null) {

            hotelBookingModel.setCompany(map.get("COMPANY").toString());
        }
        hotelBookingModel.setCity(map.get("CITY").toString());
        hotelBookingModel.setPostalCode(map.get("POSTAL_CODE").toString());
        if (map.get("LICENSE_NO") != null) {
            hotelBookingModel.setLicenseNo(map.get("LICENSE_NO").toString());
        }
        hotelBookingModel.setAirportPickUp(map.get("AIRPORT_PICK_UP").toString());
        hotelBookingModel.setHotelName(map.get("HOTEL_NAME").toString());
        hotelBookingModel.setHotelPhNo1(map.get("HOTEL_PH_NO_1").toString());
        hotelBookingModel.setHotelPhNo2(map.get("HOTEL_PH_NO_2").toString());
        hotelBookingModel.setHotelPhNo3(map.get("HOTEL_PH_NO_3").toString());
        hotelBookingModel.setHotelAddress(map.get("HOTEL_ADDRESS").toString());
        hotelBookingModel.setHotelEmailId(map.get("HOTEL_EMAIL_ID").toString());
    //    hotelBookingModel.setBookingStatus(map.get("BOOKING_STATUS").toString());
        if (map.get("HASH_CODE") != null) {
            hotelBookingModel.setHashCode(map.get("HASH_CODE").toString());
        }
        hotelBookingModel.setCustomerDetailId(map.get("CUSTOMER_DETAIL_ID").toString());
        hotelBookingModel.setAmount(map.get("AMOUNT").toString());
        hotelBookingModel.setDiscountAmount(map.get("DISCOUNT_AMOUNT").toString());
        hotelBookingModel.setTotalAmount(map.get("TOTAL_AMOUNT").toString());
        hotelBookingModel.setReferenceNo(map.get("REFERENCE_NO").toString());


        return hotelBookingModel;
    }

}
