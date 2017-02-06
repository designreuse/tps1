package igc.tech.com.mapper;

import igc.tech.com.model.RoomFacilityModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoomFacilityMapper {

    @SuppressWarnings("rawtypes")
    public List<RoomFacilityModel> mapList(List<Map> list) {

        List<RoomFacilityModel> resultList = new ArrayList<>();

        RoomFacilityModel roomFacility;

        for (Map m : list) {
            roomFacility = mapRow(m);
            resultList.add(roomFacility);
        }

        return resultList;
    }

    @SuppressWarnings("rawtypes")
    public RoomFacilityModel mapRow(Map map) {

        RoomFacilityModel roomFacilityModel = new RoomFacilityModel();
        roomFacilityModel.setRoomFacilityId(map.get("ROOM_FACILITY_ID")==null?null:map.get("ROOM_FACILITY_ID").toString());
        roomFacilityModel.setRoomTypeId(map.get("room_type_id")==null?null:map.get("room_type_id").toString());
        roomFacilityModel.setFacilityId(map.get("facility_id")==null?null:map.get("facility_id").toString());
        roomFacilityModel.setActive(map.get("active")==null?null:map.get("active").toString());
        roomFacilityModel.setFacilityDesc(map.get("facility_desc")==null?null:map.get("facility_desc").toString());
        roomFacilityModel.setRoomDesc(map.get("room_desc")==null?null:map.get("room_desc").toString());
        return roomFacilityModel;
    }

}
