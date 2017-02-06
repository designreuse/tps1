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
        roomFacilityAccessModel.setRoomFacilityAccessId(map.get("ROOM_FACILITY_ACCESS_ID").toString());
        roomFacilityAccessModel.setRoomTypeId(map.get("ROOM_TYPE_ID").toString());
        roomFacilityAccessModel.setRoomTypeDesc(map.get("ROOM_TYPE_DESC").toString());
        roomFacilityAccessModel.setRoomFacilityId(map.get("ROOM_FACILITY_ID").toString());
        roomFacilityAccessModel.setRoomFacilityDesc(map.get("ROOM_FACILITY_DESC").toString());
        roomFacilityAccessModel.setHotelName(map.get("HOTEL_NAME").toString());
        roomFacilityAccessModel.setRegionName(map.get("REGION_NAME").toString());
        roomFacilityAccessModel.setCountryName(map.get("COUNTRY_NAME").toString());


        return roomFacilityAccessModel;
    }

}
