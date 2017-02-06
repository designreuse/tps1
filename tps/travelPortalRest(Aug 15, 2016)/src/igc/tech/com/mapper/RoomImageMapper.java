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
        roomImageModel.setImageUrl(map.get("image_url").toString());
        roomImageModel.setThumbnail(map.get("thumbnail").toString());
        roomImageModel.setActive(map.get("active").toString());
        roomImageModel.setFullImageUrl(map.get("full_image_url").toString());
        return roomImageModel;
    }

    public RoomImageModel mapRowSetNull(boolean roomImageId,
                                         boolean roomDetailId,
                                         boolean caption,
                                         boolean fileName,
                                         boolean fileType,
                                         boolean imageUrl,
                                         boolean thumbnail,
                                         boolean active,
                                         boolean fullImageUrl,
                                        RoomImageModel roomImageModel) {


        if (roomImageId == true) {

            roomImageModel.setRoomImageId(null);
        }
        if (roomDetailId == true) {

            roomImageModel.setRoomDetailId(null);
        }
        if (caption == true) {

            roomImageModel.setCaption(null);
        }

        if (fileName == true) {

            roomImageModel.setFileName(null);
        }
        if (fileType == true) {

            roomImageModel.setFileType(null);
        }
        if (imageUrl == true) {

            roomImageModel.setImageUrl(null);
        }

        if (thumbnail == true) {

            roomImageModel.setThumbnail(null);
        }

        if (active == true) {

            roomImageModel.setActive(null);
        }

        if (fullImageUrl == true) {

            roomImageModel.setFullImageUrl(null);
        }


        return roomImageModel;
    }

    public List<RoomImageModel> mapListSetNull(boolean roomImageId,
                                                boolean roomDetailId,
                                                boolean caption,
                                                boolean fileName,
                                                boolean fileType,
                                                boolean imageUrl,
                                                boolean thumbnail,
                                                boolean active,
                                                boolean fullImageUrl,
                                                List<RoomImageModel> roomImageModels) {

        for (RoomImageModel roomImageModel: roomImageModels) {

            roomImageModel = mapRowSetNull(roomImageId,roomDetailId,caption,fileName,fileType,imageUrl,thumbnail,active,fullImageUrl, roomImageModel);

        }


        return roomImageModels;
    }
}
