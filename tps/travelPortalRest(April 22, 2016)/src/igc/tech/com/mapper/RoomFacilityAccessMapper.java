package igc.tech.com.mapper;

import igc.tech.com.model.RoomFacilityAccessModel;
import igc.tech.com.model.RoomFacilityModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoomFacilityAccessMapper {

    @SuppressWarnings("rawtypes")
    public List<RoomFacilityAccessModel> mapList(List<Map> list) {

        List<RoomFacilityAccessModel> resultList = new ArrayList<>();

        RoomFacilityAccessModel roomFacilityAccessModel;

        for (Map m : list) {
            roomFacilityAccessModel = mapRow(m);
            resultList.add(roomFacilityAccessModel);
        }

        return resultList;
    }

    @SuppressWarnings("rawtypes")
    public RoomFacilityAccessModel mapRow(Map map) {


        RoomFacilityAccessModel roomFacilityAccessModel = new RoomFacilityAccessModel();

        if (map.get("ROOM_FACILITY_ACCESS_ID") != null) {
            roomFacilityAccessModel.setRoomFacilityAccessId(map.get("ROOM_FACILITY_ACCESS_ID").toString());

        }

        if (map.get("ROOM_TYPE_ID") != null) {
            roomFacilityAccessModel.setRoomTypeId(map.get("ROOM_TYPE_ID").toString());

        }
        if (map.get("ROOM_TYPE_DESC") != null) {
            roomFacilityAccessModel.setRoomTypeDesc(map.get("ROOM_TYPE_DESC").toString());

        }
        if (map.get("ROOM_FACILITY_ID") != null) {
            roomFacilityAccessModel.setRoomFacilityId(map.get("ROOM_FACILITY_ID").toString());

        }
        if (map.get("ROOM_FACILITY_DESC") != null) {
            roomFacilityAccessModel.setRoomFacilityDesc(map.get("ROOM_FACILITY_DESC").toString());

        }
        if (map.get("HOTEL_NAME") != null) {
            roomFacilityAccessModel.setHotelName(map.get("HOTEL_NAME").toString());

        }

        if (map.get("AREA_NAME") != null) {
            roomFacilityAccessModel.setAreaName(map.get("AREA_NAME").toString());

        }
        if (map.get("REGION_NAME") != null) {
            roomFacilityAccessModel.setRegionName(map.get("REGION_NAME").toString());

        }
        if (map.get("COUNTRY_NAME") != null) {
            roomFacilityAccessModel.setCountryName(map.get("COUNTRY_NAME").toString());

        }

        return roomFacilityAccessModel;
    }

    public RoomFacilityAccessModel mapRowSetNull(boolean roomFacilityAccessId,
                                                 boolean roomTypeId,
                                                 boolean roomTypeDesc,
                                                 boolean roomFacilityId,
                                                 boolean roomFacilityDesc,
                                                 boolean hotelName,
                                                 boolean areaName,
                                                 boolean regionName,
                                                 boolean countryName,
                                                 RoomFacilityAccessModel roomFacilityAccessModel) {

        if (roomFacilityAccessId == true) {
            roomFacilityAccessModel.setRoomFacilityAccessId(null);

        }

        if (roomTypeId == true) {
            roomFacilityAccessModel.setRoomTypeId(null);

        }
        if (roomTypeDesc == true) {
            roomFacilityAccessModel.setRoomTypeDesc(null);

        }
        if (roomFacilityId == true) {
            roomFacilityAccessModel.setRoomFacilityId(null);

        }
        if (roomFacilityDesc == true) {
            roomFacilityAccessModel.setRoomFacilityDesc(null);

        }
        if (hotelName == true) {
            roomFacilityAccessModel.setHotelName(null);

        }

        if (areaName == true) {
            roomFacilityAccessModel.setAreaName(null);

        }
        if (regionName == true) {
            roomFacilityAccessModel.setRegionName(null);

        }
        if (countryName == true) {
            roomFacilityAccessModel.setCountryName(null);

        }

        return roomFacilityAccessModel;
    }

    public List<RoomFacilityAccessModel> mapListSetNull(boolean roomFacilityAccessId,
                                                        boolean roomTypeId,
                                                        boolean roomTypeDesc,
                                                        boolean roomFacilityId,
                                                        boolean roomFacilityDesc,
                                                        boolean hotelName,
                                                        boolean areaName,
                                                        boolean regionName,
                                                        boolean countryName,
                                                        List<RoomFacilityAccessModel> roomFacilityAccessModels) {

        for (RoomFacilityAccessModel roomFacilityAccessModel : roomFacilityAccessModels) {

            roomFacilityAccessModel = mapRowSetNull(roomFacilityAccessId, roomTypeId, roomTypeDesc, roomFacilityId, roomFacilityDesc, hotelName, areaName, regionName, countryName, roomFacilityAccessModel);

        }

        return roomFacilityAccessModels;
    }

}
