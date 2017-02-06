package igc.tech.com.mapper;

import igc.tech.com.model.PackageLocationModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PackageLocationMappper {

    @SuppressWarnings("rawtypes")
    public List<PackageLocationModel> mapList(List<Map> list) {

        List<PackageLocationModel> resultList = new ArrayList<>();

        PackageLocationModel packageLocationModel;

        for (Map m : list) {
            packageLocationModel = mapRow(m);
            resultList.add(packageLocationModel);
        }

        return resultList;
    }

    @SuppressWarnings("rawtypes")
    public PackageLocationModel mapRow(Map map) {

        PackageLocationModel packageLocationModel = new PackageLocationModel();

        packageLocationModel.setPackageLocationId(map.get("PACKAGE_LOCATION_ID").toString());
        packageLocationModel.setPackageName(map.get("PACKAGE_NAME").toString());
        packageLocationModel.setPackageItineraryId(map.get("PACKAGE_ITINERARY_ID").toString());
        packageLocationModel.setDay(map.get("DAY").toString());
        packageLocationModel.setRegionId(map.get("REGION_ID").toString());
        packageLocationModel.setRegionName(map.get("REGION_NAME").toString());
        packageLocationModel.setCountryName(map.get("COUNTRY_NAME").toString());
        packageLocationModel.setAreaId(map.get("AREA_ID").toString());
        packageLocationModel.setAreaName(map.get("AREA_NAME").toString());


        return packageLocationModel;
    }

}
