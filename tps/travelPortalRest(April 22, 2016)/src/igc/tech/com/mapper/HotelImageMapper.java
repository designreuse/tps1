package igc.tech.com.mapper;

import igc.tech.com.model.HotelImageModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 2/18/2016.
 */

import igc.tech.com.model.HotelImageModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        hotelImageModel.setCaption(map.get("caption").toString());
        hotelImageModel.setFileName(map.get("file_name").toString());
        hotelImageModel.setFileType(map.get("file_type").toString());
        hotelImageModel.setImageUrl(map.get("image_url").toString());
        hotelImageModel.setThumbnail(map.get("thumbnail").toString());
        hotelImageModel.setActive(map.get("active").toString());
        return hotelImageModel;
    }
}

