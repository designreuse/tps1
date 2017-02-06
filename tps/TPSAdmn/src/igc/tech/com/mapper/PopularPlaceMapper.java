package igc.tech.com.mapper;

import igc.tech.com.model.PopularPlaceModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2/1/2016.
 */
public class PopularPlaceMapper {

    public List<PopularPlaceModel> mapList(List<Map> list) {

        List<PopularPlaceModel> resultList = new ArrayList<>();

        PopularPlaceModel popularPlaceModel;

        for (Map m : list) {
            popularPlaceModel = mapRow(m);
            resultList.add(popularPlaceModel);
        }


        return resultList;
    }

    public PopularPlaceModel mapRow(Map map) {

        PopularPlaceModel popularPlaceModel = new PopularPlaceModel();
        popularPlaceModel.setPopularPlaceId(map.get("popular_place_id").toString());
        popularPlaceModel.setPlace(map.get("place").toString());
        popularPlaceModel.setType(map.get("type").toString());


        return popularPlaceModel;
    }


}
