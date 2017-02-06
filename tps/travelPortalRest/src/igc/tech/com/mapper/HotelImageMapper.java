package igc.tech.com.mapper;

import igc.tech.com.model.HotelImageModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 2/18/2016.
 */

public class HotelImageMapper {
    public List<HotelImageModel> mapList(List<Map> list) {
        ArrayList<HotelImageModel> resultList = new ArrayList<HotelImageModel>();
        for (Map m : list) {
            HotelImageModel hotelImageModel = this.mapRow(m);
            resultList.add(hotelImageModel);
        }
        return resultList;
    }

    public HotelImageModel mapRow(Map map) {
       // System.out.println(map);
        HotelImageModel hotelImageModel = new HotelImageModel();
        hotelImageModel.setHotelImageId(map.get("hotel_image_id").toString());
        hotelImageModel.setHotelDetailId(map.get("hotel_detail_id").toString());
        hotelImageModel.setCaption(map.get("caption")==null?null:map.get("caption").toString());
        hotelImageModel.setFileName(map.get("file_name").toString());
        hotelImageModel.setFileType(map.get("file_type").toString());
        hotelImageModel.setImageUrl(map.get("image_url").toString());
        hotelImageModel.setThumbnail(map.get("thumbnail")==null?null:map.get("thumbnail").toString());
        hotelImageModel.setActive(map.get("active")==null?null:map.get("active").toString());
        hotelImageModel.setFullImageUrl(map.get("full_image_url")==null?null:map.get("full_image_url").toString());
        return hotelImageModel;
    }

    public HotelImageModel mapRowSetNull(boolean hotelImageId,
                                          boolean hotelDetailId,
                                          boolean caption,
                                          boolean fileName,
                                          boolean fileType,
                                          boolean imageUrl,
                                          boolean thumbnail,
                                         boolean active,
                                         boolean fullImageUrl,
                                          HotelImageModel hotelImageModel) {


        if (hotelImageId == true) {

            hotelImageModel.setHotelImageId(null);
        }
        if (hotelDetailId == true) {

            hotelImageModel.setHotelDetailId(null);
        }
        if (caption == true) {

            hotelImageModel.setCaption(null);
        }

        if (fileName == true) {

            hotelImageModel.setFileName(null);
        }
        if (fileType == true) {

            hotelImageModel.setFileType(null);
        }
        if (imageUrl == true) {

            hotelImageModel.setImageUrl(null);
        }

        if (thumbnail == true) {

            hotelImageModel.setThumbnail(null);
        }

        if (active == true) {

            hotelImageModel.setActive(null);
        }

        if (fullImageUrl == true) {

            hotelImageModel.setFullImageUrl(null);
        }


        return hotelImageModel;
    }

    public List<HotelImageModel> mapListSetNull(boolean hotelImageId,
                                                 boolean hotelDetailId,
                                                 boolean caption,
                                                 boolean fileName,
                                                 boolean fileType,
                                                 boolean imageUrl,
                                                 boolean thumbnail,
                                                 boolean active,
                                                 boolean fullImageUrl,
                                                 List<HotelImageModel> hotelImageModels) {

        for (HotelImageModel hotelImageModel: hotelImageModels) {

            hotelImageModel = mapRowSetNull(hotelImageId,hotelDetailId,caption,fileName,fileType,imageUrl,thumbnail,active,fullImageUrl, hotelImageModel);

        }


        return hotelImageModels;
    }
}
