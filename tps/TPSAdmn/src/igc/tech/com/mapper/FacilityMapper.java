package igc.tech.com.mapper;

import igc.tech.com.model.FacilityModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2/1/2016.
 */
public class FacilityMapper {

    public List<FacilityModel> mapList(List<Map> list) {

        List<FacilityModel> resultList = new ArrayList<>();

        FacilityModel facilityModel;

        for (Map m : list) {
            facilityModel = mapRow(m);
            resultList.add(facilityModel);
        }


        return resultList;
    }

    public FacilityModel mapRow(Map map) {

        FacilityModel facilityModel = new FacilityModel();
        facilityModel.setFacilityId(map.get("facility_id").toString());
        facilityModel.setFacilityDesc(map.get("facility_desc").toString());
        facilityModel.setType(map.get("type").toString());
        facilityModel.setIcon(map.get("icon")==null?null:map.get("icon").toString());
        facilityModel.setImage(map.get("image")==null?null:map.get("image").toString());


        return facilityModel;
    }


}
