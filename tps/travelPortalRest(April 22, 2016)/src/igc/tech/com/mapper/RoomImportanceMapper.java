package igc.tech.com.mapper;

import igc.tech.com.model.RoomImportanceModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoomImportanceMapper {

    public List<RoomImportanceModel> mapList(List<Map> list) {

        List<RoomImportanceModel> resultList = new ArrayList<>();

        RoomImportanceModel roomImportance;

        for (Map m : list) {
            roomImportance = mapRow(m);
            resultList.add(roomImportance);
        }

        return resultList;
    }

    public RoomImportanceModel mapRow(Map map) {

        RoomImportanceModel roomImportanceModel = new RoomImportanceModel();
        roomImportanceModel.setRoomImportanceId(map.get("ROOM_FACILITY_ID")==null?null:map.get("ROOM_FACILITY_ID").toString());
        roomImportanceModel.setRoomTypeId(map.get("room_type_id")==null?null:map.get("room_type_id").toString());
        roomImportanceModel.setRulesId(map.get("rules_id")==null?null:map.get("rules_id").toString());
        roomImportanceModel.setRulesDesc(map.get("rules_desc")==null?null:map.get("rules_desc").toString());
        roomImportanceModel.setRoomDesc(map.get("room_desc")==null?null:map.get("room_desc").toString());
        return roomImportanceModel;
    }

}
