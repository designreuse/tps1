package igc.tech.com.mapper;

import igc.tech.com.model.RegionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RegionMapper {

    public List<RegionModel> mapList(List<Map> list) {

        List<RegionModel> resultList = new ArrayList<>();

        RegionModel regionModel;

        for (Map m : list) {
            regionModel = mapRow(m);
            resultList.add(regionModel);
        }

        // System.out.println("ffasdf");

        return resultList;
    }

    public RegionModel mapRow(Map map) {

        RegionModel regionModel = new RegionModel();
        regionModel.setCountryId(map.get("COUNTRY_ID").toString());
        regionModel.setCountryName(map.get("COUNTRY_NAME").toString());
        regionModel.setRegionId(map.get("REGION_ID").toString());
        regionModel.setRegionName(map.get("REGION_NAME").toString());

        return regionModel;
    }

}
