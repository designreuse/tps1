package igc.tech.com.mapper;

import igc.tech.com.model.RoomCategoryModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2/1/2016.
 */
public class RoomCategoryMapper {

    public List<RoomCategoryModel> mapList(List<Map> list) {

        List<RoomCategoryModel> resultList = new ArrayList<>();

        RoomCategoryModel roomCategoryModel;

        for (Map m : list) {
            roomCategoryModel = mapRow(m);
            resultList.add(roomCategoryModel);
        }


        return resultList;
    }

    public RoomCategoryModel mapRow(Map map) {

        RoomCategoryModel roomCategoryModel = new RoomCategoryModel();
        roomCategoryModel.setRoomCategoryId(map.get("room_category_id").toString());
        roomCategoryModel.setRoomCategoryDesc(map.get("room_category_desc").toString());


        return roomCategoryModel;
    }


}
