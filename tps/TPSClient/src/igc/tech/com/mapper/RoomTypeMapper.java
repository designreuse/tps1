package igc.tech.com.mapper;

import igc.tech.com.model.RoomTypeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class RoomTypeMapper {


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


        roomTypeModel.setRoomTypeId(map.get("room_type_id").toString());
        roomTypeModel.setParentRoomTypeId(map.get("parent_room_type_id")==null?null:map.get("parent_room_type_id").toString());
        roomTypeModel.setRoomTypeDesc(map.get("room_type_desc").toString());
        roomTypeModel.setActive(map.get("active")==null?null:map.get("active").toString());



        return roomTypeModel;


    }
}
