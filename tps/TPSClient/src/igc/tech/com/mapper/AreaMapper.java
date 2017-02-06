package igc.tech.com.mapper;

import igc.tech.com.model.AreaModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 2/9/2016.
 */
public class AreaMapper {

    @SuppressWarnings("rawtypes")
    public List<AreaModel> mapList(List<Map> list) {
        List<AreaModel> resultList = new ArrayList<>();

        AreaModel areaModel;

        for (Map m : list) {
            areaModel = mapRow(m);
            resultList.add(areaModel);
        }

        return resultList;
    }

    @SuppressWarnings("rawtypes")
    public AreaModel mapRow(Map map) {

        AreaModel areaModel = new AreaModel();

        /*
        * .region_id,
        a.region_name,
        b.country_id,
        b.country_name,
        c.area_name,
        c.area_id
        *
        * */

        areaModel.setAreaId(map.get("area_id").toString());
        areaModel.setRegionId(map.get("region_id").toString());
        areaModel.setAreaName(map.get("area_name").toString());
        areaModel.setRegionName(map.get("region_name").toString());


        return areaModel;
    }
}
