package igc.tech.com.mapper;

import igc.tech.com.model.RoomTypeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoomTypeMapper {


    @SuppressWarnings("rawtypes")
    public List<RoomTypeModel> mapList(List<Map> list) {
        List<RoomTypeModel> resultList = new ArrayList<>();

        RoomTypeModel roomTypeModel;

        for (Map m : list) {
            roomTypeModel = mapRow(m);
            resultList.add(roomTypeModel);
        }

        return resultList;
    }

    public RoomTypeModel mapRow(Map map) {

        RoomTypeModel roomTypeModel = new RoomTypeModel();

        if (map.get("ROOM_TYPE_ID") != null) {
            roomTypeModel.setRoomTypeId(map.get("ROOM_TYPE_ID").toString());

        }

        if (map.get("HOTEL_DETAIL_ID") != null) {
            roomTypeModel.setHotelDetailId(map.get("HOTEL_DETAIL_ID").toString());

        }


        if (map.get("HOTEL_NAME") != null) {
            roomTypeModel.setHotelName(map.get("HOTEL_NAME").toString());

        }

        /*if (map.get("HOTEL_ADDRESS") != null) {
            roomTypeModel.setHotelAddress(map.get("HOTEL_ADDRESS").toString());

        }*/
        if (map.get("ROOM_DESC") != null) {
            roomTypeModel.setRoomDesc(map.get("ROOM_DESC").toString());

        }
        if (map.get("ROOM_CATEGORY_ID") != null) {
            roomTypeModel.setRoomCategoryId(map.get("ROOM_CATEGORY_ID").toString());

        }

        if (map.get("ROOM_CATEGORY_DESC") != null) {
            roomTypeModel.setRoomCategoryDesc(map.get("ROOM_CATEGORY_DESC").toString());

        }
        if (map.get("BED_TYPE_ID") != null) {
            roomTypeModel.setBedTypeId(map.get("BED_TYPE_ID").toString());

        }

        if (map.get("BED_TYPE_DESC") != null) {
            roomTypeModel.setBedTypeDesc(map.get("BED_TYPE_DESC").toString());

        }
        if (map.get("INITIAL_RATE") != null) {
            roomTypeModel.setInitialRate(map.get("INITIAL_RATE").toString());

        }



        if (map.get("MAX_ADULT") != null) {
            roomTypeModel.setMaxAdult(map.get("MAX_ADULT").toString());

        }

        if (map.get("MAX_CHILD") != null) {
            roomTypeModel.setMaxChild(map.get("MAX_CHILD").toString());

        }

        if (map.get("EXTRA_BED_CHARGE") != null) {
            roomTypeModel.setExtraBedCharge(map.get("EXTRA_BED_CHARGE").toString());

        }

        if (map.get("PUSH") != null) {
            roomTypeModel.setPush(map.get("PUSH").toString());

        }

        return roomTypeModel;
    }

  /*  public RoomTypeModel mapRowSetNull(boolean roomTypeId,
                                       boolean description,
                                       boolean hotelDetailId,
                                       boolean hotelName,
                                       boolean areaName,
                                       boolean regionName,
                                       boolean countryName,
                                       boolean maxAdult,
                                       boolean maxChild,
                                       boolean rate,
                                       RoomTypeModel roomTypeModel) {

        if (roomTypeId == true) {
            roomTypeModel.setRoomTypeId(null);

        }
        if (description == true) {
            roomTypeModel.setDescription(null);

        }
        if (hotelDetailId == true) {
            roomTypeModel.setHotelDetailId(null);

        }
        if (hotelName == true) {
            roomTypeModel.setHotelName(null);

        }

        if (areaName == true) {
            roomTypeModel.setAreaName(null);

        }

        if (regionName == true) {
            roomTypeModel.setRegionName(null);

        }
        if (countryName == true) {
            roomTypeModel.setCountryName(null);

        }

        if (maxAdult == true) {
            roomTypeModel.setMaxAdult(null);

        }

        if (maxChild == true) {
            roomTypeModel.setMaxChild(null);

        }

        if (rate == true) {
            roomTypeModel.setRate(null);

        }

        return roomTypeModel;
    }
*/
   /* public List<RoomTypeModel> mapListSetNull(boolean roomTypeId,
                                              boolean description,
                                              boolean hotelDetailId,
                                              boolean hotelName,
                                              boolean areaName,
                                              boolean regionName,
                                              boolean countryName,
                                              boolean maxAdult,
                                              boolean maxChild,
                                              boolean rate,
                                              List<RoomTypeModel> roomTypeModels) {

        for (RoomTypeModel roomTypeModel: roomTypeModels) {

            roomTypeModel = mapRowSetNull(roomTypeId,description,hotelDetailId,hotelName,areaName,regionName,countryName,maxAdult,maxChild,rate,roomTypeModel);

        }

        return roomTypeModels;
    }
*/

}
