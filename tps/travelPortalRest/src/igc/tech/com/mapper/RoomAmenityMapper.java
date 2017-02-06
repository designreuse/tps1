package igc.tech.com.mapper;

import igc.tech.com.model.RoomAmenityModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class RoomAmenityMapper {


    public List<RoomAmenityModel> mapList(List<Map> list) {

        List<RoomAmenityModel> resultList = new ArrayList<>();

        if (list.isEmpty()) {
            return resultList;
        }

        RoomAmenityModel roomAmenityModel;

        for (Map m : list) {
            roomAmenityModel = mapRow(m);
            resultList.add(roomAmenityModel);
        }


        return resultList;
    }

    public RoomAmenityModel mapRow(Map map) {

        RoomAmenityModel roomAmenityModel = new RoomAmenityModel();


        roomAmenityModel.setRoomAmenityId(map.get("room_amenity_id") == null ? null : map.get("room_amenity_id").toString());
        roomAmenityModel.setRoomDetailId(map.get("room_detail_id") == null ? null : map.get("room_detail_id").toString());
        roomAmenityModel.setAmenityId(map.get("amenity_id") == null ? null : map.get("amenity_id").toString());
        roomAmenityModel.setActive(map.get("active") == null ? null : map.get("active").toString());
        roomAmenityModel.setParentAmenityId(map.get("parent_amenity_id") == null ? null : map.get("parent_amenity_id").toString());
        roomAmenityModel.setParentAmenityDesc(map.get("parent_amenity_desc") == null ? null : map.get("parent_amenity_desc").toString());
        roomAmenityModel.setAmenityDesc(map.get("amenity_desc") == null ? null : map.get("amenity_desc").toString());
//        roomAmenityModel.setRoomDesc(map.get("type")==null? null : map.get("type").toString());

        return roomAmenityModel;
    }

    public RoomAmenityModel mapRowSetNull(boolean roomAmenityId,
                                          boolean roomDetailId,
                                          boolean amenityId,
                                          boolean active,
                                          boolean parentAmenityId,
                                          boolean parentAmenityDesc,
                                          boolean amenityDesc,
                                          RoomAmenityModel roomAmenityModel) {


        if (roomAmenityId == true) {

            roomAmenityModel.setRoomAmenityId(null);
        }
        if (roomDetailId == true) {

            roomAmenityModel.setRoomDetailId(null);
        }
        if (amenityId == true) {

            roomAmenityModel.setAmenityId(null);
        }

        if (active == true) {

            roomAmenityModel.setActive(null);
        }
        if (parentAmenityId == true) {

            roomAmenityModel.setParentAmenityId(null);
        }
        if (parentAmenityDesc == true) {

            roomAmenityModel.setParentAmenityDesc(null);
        }

        if (amenityDesc == true) {

            roomAmenityModel.setAmenityDesc(null);
        }


        return roomAmenityModel;
    }

    public List<RoomAmenityModel> mapListSetNull(boolean roomAmenityId,
                                                 boolean roomDetailId,
                                                 boolean amenityId,
                                                 boolean active,
                                                 boolean parentAmenityId,
                                                 boolean parentAmenityDesc,
                                                 boolean amenityDesc,
                                                 List<RoomAmenityModel> roomAmenityModels) {

        for (RoomAmenityModel roomAmenityModel : roomAmenityModels) {

            roomAmenityModel = mapRowSetNull(roomAmenityId, roomDetailId, amenityId, active, parentAmenityId, parentAmenityDesc, amenityDesc, roomAmenityModel);

        }


        return roomAmenityModels;
    }
}

