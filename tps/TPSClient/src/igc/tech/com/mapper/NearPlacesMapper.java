package igc.tech.com.mapper;

import igc.tech.com.model.NearPlacesModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2/1/2016.
 */
public class NearPlacesMapper {

    public List<NearPlacesModel> mapList(List<Map> list) {

        List<NearPlacesModel> resultList = new ArrayList<>();

        NearPlacesModel nearPlacesModel;

        for (Map m : list) {
            nearPlacesModel = mapRow(m);
            resultList.add(nearPlacesModel);
        }


        return resultList;
    }

    public NearPlacesModel mapRow(Map map) {

        NearPlacesModel nearPlacesModel = new NearPlacesModel();
        nearPlacesModel.setNearPlaceId(map.get("near_places_id")==null?null:map.get("near_places_id").toString());
        nearPlacesModel.setHotelDetailId(map.get("hotel_detail_id")==null?null:map.get("hotel_detail_id").toString());
        nearPlacesModel.setPlaceName(map.get("place_name")==null?null:map.get("place_name").toString());
        nearPlacesModel.setType(map.get("type")==null? null:map.get("type").toString());
        nearPlacesModel.setLat(map.get("lat")==null? null:map.get("lat").toString());
        nearPlacesModel.setLng(map.get("lng")==null? null:map.get("lng").toString());
        nearPlacesModel.setDistance(map.get("distance")==null? null:map.get("distance").toString());

        return nearPlacesModel;
    }


}
