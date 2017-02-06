package igc.tech.com.mapper;

import igc.tech.com.model.AmenityModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class AmenityMapper {


    public List<AmenityModel> mapList(List<Map> list) {

        List<AmenityModel> resultList = new ArrayList<>();

        AmenityModel amenityModel;

        for (Map m : list) {
            amenityModel = mapRow(m);
            resultList.add(amenityModel);
        }



        return resultList;
    }

    public AmenityModel mapRow(Map map) {

        AmenityModel amenityModel = new AmenityModel();


        amenityModel.setAmenityId(map.get("amenity_id")==null? null:map.get("amenity_id").toString());
        amenityModel.setParentAmenityId(map.get("parent_amenity_id")==null? null:map.get("parent_amenity_id").toString());
        amenityModel.setAmenityDesc(map.get("amenity_desc")==null? null:map.get("amenity_desc").toString());
        amenityModel.setActive(map.get("active")==null? null:map.get("active").toString());

        amenityModel.setWebPrior(map.get("web_prior")==null? null:map.get("web_prior").toString());
        amenityModel.setMobPrior(map.get("mob_prior")==null? null:map.get("mob_prior").toString());
        amenityModel.setIcon(map.get("icon")==null? null:map.get("icon").toString());
        amenityModel.setTotal(map.get("total")==null? null:map.get("total").toString());



        return amenityModel;


    }
}
