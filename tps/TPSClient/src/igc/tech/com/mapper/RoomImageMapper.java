package igc.tech.com.mapper;

import igc.tech.com.model.RoomImageModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/14/2016.
 */
public class RoomImageMapper {


    public List<RoomImageModel> mapList(List<Map> list) {
        ArrayList<RoomImageModel> resultList = new ArrayList<RoomImageModel>();
        for (Map m : list) {
            RoomImageModel roomImageModel = this.mapRow(m);
            resultList.add(roomImageModel);
        }
        return resultList;
    }

    public RoomImageModel mapRow(Map map) {
        // System.out.println(map);
        RoomImageModel roomImageModel = new RoomImageModel();
        roomImageModel.setRoomImageId(map.get("room_image_id").toString());
        roomImageModel.setRoomDetailId(map.get("room_detail_id").toString());
        roomImageModel.setCaption(map.get("caption")==null?null:map.get("caption").toString());
        roomImageModel.setFileName(map.get("file_name").toString());
        roomImageModel.setFileType(map.get("file_type").toString());
        roomImageModel.setImageUrl(map.get("image_url")==null?null:map.get("image_url").toString());
        roomImageModel.setThumbnail(map.get("thumbnail").toString());
        roomImageModel.setActive(map.get("active")==null?null:map.get("active").toString());
        return roomImageModel;
    }
}
