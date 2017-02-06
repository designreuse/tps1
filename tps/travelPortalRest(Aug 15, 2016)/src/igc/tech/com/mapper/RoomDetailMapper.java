package igc.tech.com.mapper;

import igc.tech.com.model.RoomDetailModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class RoomDetailMapper {


    public List<RoomDetailModel> mapList(List<Map> list) {


        List<RoomDetailModel> resultList = new ArrayList<>();

        RoomDetailModel roomDetailModel;

        if(list.isEmpty()){
            return resultList;
        }

        for (Map m : list) {
            roomDetailModel = mapRow(m);
            resultList.add(roomDetailModel);
        }



        return resultList;
    }

    public RoomDetailModel mapRow(Map map) {

        RoomDetailModel roomDetailModel = new RoomDetailModel();


        roomDetailModel.setRoomDetailId(map.get("room_detail_id")==null? null:map.get("room_detail_id").toString());
        roomDetailModel.setRoomTypeId(map.get("room_type_id")==null? null:map.get("room_type_id").toString());
        roomDetailModel.setRoomTypeDesc(map.get("room_type_desc")==null? null:map.get("room_type_desc").toString());
        roomDetailModel.setBedTypeId(map.get("bed_type_id")==null? null:map.get("bed_type_id").toString());
        roomDetailModel.setHotelDetailId(map.get("hotel_detail_id")==null? null:map.get("hotel_detail_id").toString());
        roomDetailModel.setHotelName(map.get("hotel_name")==null? null:map.get("hotel_name").toString());
        roomDetailModel.setStarRating(map.get("star_rating")==null? null:map.get("star_rating").toString());
        roomDetailModel.setRegionName(map.get("region_name")==null? null:map.get("region_name").toString());
        roomDetailModel.setCountryName(map.get("country_name")==null? null:map.get("country_name").toString());
        roomDetailModel.setCustomName(map.get("custom_name")==null? null:map.get("custom_name").toString());
        roomDetailModel.setRoomsProvided(map.get("rooms_provided")==null? null:map.get("rooms_provided").toString());
        roomDetailModel.setRemRoom(map.get("rem_room")==null? null:map.get("rem_room").toString());
        roomDetailModel.setNoOfBed(map.get("no_of_bed")==null? null:map.get("no_of_bed").toString());
        roomDetailModel.setNoOfGuest(map.get("no_of_guest")==null? null:map.get("no_of_guest").toString());
        roomDetailModel.setRate(map.get("rate")==null? null:map.get("rate").toString());
        roomDetailModel.setMinNoOfGuest(map.get("min_no_of_guest")==null? null:map.get("min_no_of_guest").toString());
        roomDetailModel.setDiscount(map.get("discount")==null? null:map.get("discount").toString());
        roomDetailModel.setDiscountType(map.get("discount_type")==null?null:map.get("discount_type").toString());
        roomDetailModel.setRoomDimension(map.get("room_dimension")==null? null:map.get("room_dimension").toString());
        roomDetailModel.setActive(map.get("active")==null?null:map.get("active").toString());
        roomDetailModel.setParentRoomTypeId(map.get("parent_room_type_id")==null?null:map.get("parent_room_type_id").toString());
        roomDetailModel.setExtraAdult(map.get("extra_adult")==null? null:map.get("extra_adult").toString());
        roomDetailModel.setExtraChild(map.get("extra_child")==null? null:map.get("extra_child").toString());



        roomDetailModel.setChildAgeMax(map.get("child_age_max")==null? null:map.get("child_age_max").toString());
        roomDetailModel.setChildRate(map.get("child_rate")==null? null:map.get("child_rate").toString());
        roomDetailModel.setAdultRate(map.get("adult_rate")==null? null:map.get("adult_rate").toString());
        roomDetailModel.setActualAdult(map.get("actual_adult")==null? null:map.get("actual_adult").toString());
        roomDetailModel.setActualChild(map.get("actual_child")==null? null:map.get("actual_child").toString());
        roomDetailModel.setTotalGuest(map.get("total_guest")==null? null:map.get("total_guest").toString());
        roomDetailModel.setEffChild(map.get("eff_child")==null? null:map.get("eff_child").toString());
        roomDetailModel.setEffAdult(map.get("eff_adult")==null? null:map.get("eff_adult").toString());

        roomDetailModel.setOfferId(map.get("offer_id")==null? null:map.get("offer_id").toString());
        roomDetailModel.setActualRate(map.get("actual_rate")==null? null:map.get("actual_rate").toString());
        roomDetailModel.setFinalRate(map.get("final_rate")==null? null:map.get("final_rate").toString());
        roomDetailModel.setAddressId(map.get("address_id")==null? null:map.get("address_id").toString());
        roomDetailModel.setLat(map.get("lat")==null? null:map.get("lat").toString());
        roomDetailModel.setLng(map.get("lng")==null? null:map.get("lng").toString());
        roomDetailModel.setTotalDays(map.get("total_days")==null? null:map.get("total_days").toString());
        roomDetailModel.setTest(map.get("test")==null? null:map.get("test").toString());


        return roomDetailModel;


    }
}
