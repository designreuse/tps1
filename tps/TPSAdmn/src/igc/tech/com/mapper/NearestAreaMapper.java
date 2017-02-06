package igc.tech.com.mapper;

import igc.tech.com.model.NearestAreaModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2/1/2016.
 */
public class NearestAreaMapper {

    public List<NearestAreaModel> mapList(List<Map> list) {

        List<NearestAreaModel> resultList = new ArrayList<>();

        NearestAreaModel nearestAreaModel;

        for (Map m : list) {
            nearestAreaModel = mapRow(m);
            resultList.add(nearestAreaModel);
        }


        return resultList;
    }

    public NearestAreaModel mapRow(Map map) {

        NearestAreaModel nearestAreaModel = new NearestAreaModel();
        nearestAreaModel.setNearestAreaId(map.get("nearest_area_id")==null?null:map.get("nearest_area_id").toString());
        nearestAreaModel.setHotelDetailId(map.get("hotel_detail_id")==null?null:map.get("hotel_detail_id").toString());
        nearestAreaModel.setPopularPlaceId(map.get("popular_place_id")==null?null:map.get("popular_place_id").toString());
        nearestAreaModel.setDistance(map.get("distance")==null?null:map.get("distance").toString());
        nearestAreaModel.setHotelName(map.get("hotel_name")==null? null:map.get("hotel_name").toString());
        nearestAreaModel.setPlace(map.get("place")==null? null:map.get("place").toString());
        nearestAreaModel.setType(map.get("type")==null? null:map.get("type").toString());
        nearestAreaModel.setActive(map.get("active")==null? null:map.get("active").toString());

        return nearestAreaModel;
    }


}
