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
        hotelDetailModel.setAreaId(map.get("AREA_ID")==null?null:map.get("AREA_ID").toString());
        hotelDetailModel.setUrl(map.get("URL")==null?null:map.get("URL").toString());
        hotelDetailModel.setTotalRoom(map.get("total_room")==null?null:map.get("total_room").toString());
        hotelDetailModel.setActive(map.get("active")==null?null:map.get("active").toString());
        hotelDetailModel.setTokenId(map.get("token_id")==null?null:map.get("token_id").toString());
       // hotelDetailModel.setHotelDetailId(map.get("hotel_detail_id")==null?null:map.get("hotel_detail_id").toString());
        hotelDetailModel.setAddressId(map.get("address_id")==null?null:map.get("address_id").toString());

        hotelDetailModel.setLat(map.get("lat")==null?null:map.get("lat").toString());
        hotelDetailModel.setLng(map.get("lng")==null?null:map.get("lng").toString());
        hotelDetailModel.setTotal(map.get("total")==null?null:map.get("total").toString());
        hotelDetailModel.setDescription(map.get("description")==null?null:map.get("description").toString());


        return hotelDetailModel;
    }


    public HotelDetailModel mapRowSetNull(boolean hotelDetailId,
                                        boolean hotelName,
                                        boolean starRating,
                                        boolean hotelPhNo1,
                                        boolean hotelPhNo2,
                                        boolean hotelPhNo3,
                                        boolean streetAddress,
                                        boolean zipCode,
                                        boolean hotelEmailId,
                                        boolean url,
                                        boolean totalRoom,
                                        boolean active,
                                        boolean tokenId,
                                        boolean addressId,
                                        HotelDetailModel hotelDetailModel) {


        if (hotelDetailId == true) {

            hotelDetailModel.setHotelDetailId(null);
        }
        if (hotelName == true) {

            hotelDetailModel.setHotelName(null);
        }
        if (starRating == true) {

            hotelDetailModel.setStarRating(null);
        }
        if (hotelPhNo1 == true) {

            hotelDetailModel.setHotelPhNo1(null);
        }
        if (hotelPhNo2 == true) {

            hotelDetailModel.setHotelPhNo2(null);
        }
        if (hotelPhNo3 == true) {

            hotelDetailModel.setHotelPhNo3(null);
        }
        if (streetAddress == true) {

            hotelDetailModel.setStreetAddress(null);
        }


        if (zipCode == true) {

            hotelDetailModel.setZipCode(null);
        }
        if (hotelEmailId == true) {

            hotelDetailModel.setHotelEmailId(null);
        }
        if (url == true) {

            hotelDetailModel.setUrl(null);
        }


        if (totalRoom == true) {

            hotelDetailModel.setTotalRoom(null);
        }
        if (active == true) {

            hotelDetailModel.setActive(null);
        }
        if (tokenId == true) {

            hotelDetailModel.setTokenId(null);
        }
        if (addressId == true) {

            hotelDetailModel.setAddressId(null);
        }

        return hotelDetailModel;
    }

    public List<HotelDetailModel> mapListSetNull(boolean hotelDetailId,
                                           boolean hotelName,
                                           boolean starRating,
                                           boolean hotelPhNo1,
                                           boolean hotelPhNo2,
                                           boolean hotelPhNo3,
                                           boolean streetAddress,
                                           boolean zipCode,
                                           boolean hotelEmailId,
                                           boolean url,
                                           boolean totalRoom,
                                           boolean active,
                                           boolean tokenId,
                                           boolean addressId,
                                           List<HotelDetailModel> hotelDetailModels) {

        for (HotelDetailModel hotelDetailModel: hotelDetailModels) {

            hotelDetailModel = mapRowSetNull(hotelDetailId,hotelName,starRating,hotelPhNo1,hotelPhNo2, hotelPhNo3,streetAddress, zipCode,hotelEmailId, url,totalRoom, active,tokenId, addressId, hotelDetailModel);

        }



        return hotelDetailModels;
    }

}
