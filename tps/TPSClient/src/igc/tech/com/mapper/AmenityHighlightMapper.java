package igc.tech.com.mapper;

import igc.tech.com.model.AmenityHighlightModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class AmenityHighlightMapper {


    public List<AmenityHighlightModel> mapList(List<Map> list) {

        List<AmenityHighlightModel> resultList = new ArrayList<>();

        AmenityHighlightModel amenityHighlightModel;

        for (Map m : list) {
            amenityHighlightModel = mapRow(m);
            resultList.add(amenityHighlightModel);
        }



        return resultList;
    }

    public AmenityHighlightModel mapRow(Map map) {

        AmenityHighlightModel amenityHighlightModel = new AmenityHighlightModel();


        amenityHighlightModel.setAmenityHighlightId(map.get("amenity_highlight_id")==null?null:map.get("amenity_highlight_id").toString());
        amenityHighlightModel.setAmenityId(map.get("amenity_id").toString());
        amenityHighlightModel.setPriority(map.get("priority")==null?"0":map.get("priority").toString());
        amenityHighlightModel.setAmenityDesc(map.get("amenity_desc")==null?null:map.get("amenity_desc").toString());

        return amenityHighlightModel;


    }
}
