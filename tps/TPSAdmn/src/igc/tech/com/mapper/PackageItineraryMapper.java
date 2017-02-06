package igc.tech.com.mapper;

import igc.tech.com.model.PackageItineraryModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PackageItineraryMapper {

    @SuppressWarnings("rawtypes")
    public List<PackageItineraryModel> mapList(List<Map> list) {

        List<PackageItineraryModel> resultList = new ArrayList<>();

        PackageItineraryModel packageItineraryModel;

        for (Map m : list) {
            packageItineraryModel = mapRow(m);
            resultList.add(packageItineraryModel);
        }

        // System.out.println("ffasdf");

        return resultList;
    }

    @SuppressWarnings("rawtypes")
    public PackageItineraryModel mapRow(Map map) {


        System.out.println("test:" + map);

        PackageItineraryModel packageItineraryModel = new PackageItineraryModel();

        packageItineraryModel.setPackageItineraryId(map.get("PACKAGE_ITINERARY_ID").toString());
        packageItineraryModel.setPackageInfoId(map.get("PACKAGE_INFO_ID").toString());
        packageItineraryModel.setPackageName(map.get("PACKAGE_NAME").toString());
        packageItineraryModel.setDay(map.get("DAY").toString());
        packageItineraryModel.setDayDetails(map.get("DAY_DETAILS").toString());
        packageItineraryModel.setHotelDetailId(map.get("HOTEL_DETAIL_ID").toString());
        packageItineraryModel.setHotelName(map.get("HOTEL_NAME").toString());

        return packageItineraryModel;
    }

}
