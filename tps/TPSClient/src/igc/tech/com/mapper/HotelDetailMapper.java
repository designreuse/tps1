package igc.tech.com.mapper;

import igc.tech.com.model.HotelDetailModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HotelDetailMapper {

    public List<HotelDetailModel> mapList(List<Map> list) {

        List<HotelDetailModel> resultList = new ArrayList<>();

        HotelDetailModel hotelDetailModel;

        for (Map m : list) {
            hotelDetailModel = mapRow(m);
            resultList.add(hotelDetailModel);
        }

        // System.out.println("ffasdf");

        return resultList;
    }

    public HotelDetailModel mapRow(Map map) {


      //  System.out.println("test:" + map);

        HotelDetailModel hotelDetailModel = new HotelDetailModel();


        hotelDetailModel.setHotelDetailId(map.get("HOTEL_DETAIL_ID")==null?null:map.get("HOTEL_DETAIL_ID").toString());
        hotelDetailModel.setHotelName(map.get("HOTEL_NAME")==null?null:map.get("HOTEL_NAME").toString());
        hotelDetailModel.setStarRating(map.get("star_rating")==null?null:map.get("star_rating").toString());
        hotelDetailModel.setHotelPhNo1(map.get("HOTEL_PH_NO_1")==null?null:map.get("HOTEL_PH_NO_1").toString());
        hotelDetailModel.setHotelPhNo2(map.get("HOTEL_PH_NO_2")==null?null:map.get("HOTEL_PH_NO_2").toString());
        hotelDetailModel.setHotelPhNo3(map.get("HOTEL_PH_NO_3")==null?null:map.get("HOTEL_PH_NO_3").toString());
        hotelDetailModel.setStreetAddress(map.get("street_address")==null?null:map.get("street_address").toString());
        hotelDetailModel.setZipCode(map.get("zip_code")==null?null:map.get("zip_code").toString());
        hotelDetailModel.setHotelEmailId(map.get("HOTEL_EMAIL_ID")==null?null:map.get("HOTEL_EMAIL_ID").toString());
        hotelDetailModel.setAddressId(map.get("address_id")==null?null:map.get("address_id").toString());
        hotelDetailModel.setUrl(map.get("URL")==null?null:map.get("URL").toString());
        hotelDetailModel.setTotalRoom(map.get("total_room")==null?null:map.get("total_room").toString());
        hotelDetailModel.setActive(map.get("active")==null?null:map.get("active").toString());
        hotelDetailModel.setTokenId(map.get("token_id")==null?null:map.get("token_id").toString());
        hotelDetailModel.setUserDetailId(map.get("user_detail_id")==null?null:map.get("user_detail_id").toString());
        hotelDetailModel.setLat(map.get("lat")==null?null:map.get("lat").toString());
        hotelDetailModel.setLng(map.get("lng")==null?null:map.get("lng").toString());
        hotelDetailModel.setDescription(map.get("description")==null?null:map.get("description").toString());
        hotelDetailModel.setUserName(map.get("name")==null?null:map.get("name").toString());
        hotelDetailModel.setEmailId(map.get("email_id")==null?null:map.get("email_id").toString());


        return hotelDetailModel;
    }

}
