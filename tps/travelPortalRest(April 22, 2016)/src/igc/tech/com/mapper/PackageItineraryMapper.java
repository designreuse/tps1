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


    public PackageItineraryModel mapRowSetNull(boolean packageItineraryId,
                                               boolean packageInfoId,
                                               boolean packageName,
                                               boolean day,
                                               boolean dayDetails,
                                               boolean hotelDetailId,
                                               boolean hotelName,
                                               PackageItineraryModel packageItineraryModel) {


        if (packageItineraryId == true) {
            packageItineraryModel.setPackageItineraryId(null);

        }
        if (packageInfoId == true) {
            packageItineraryModel.setPackageInfoId(null);

        }
        if (packageName == true) {

            packageItineraryModel.setPackageName(null);
        }
        if (day == true) {

            packageItineraryModel.setDay(null);
        }
        if (dayDetails == true) {

            packageItineraryModel.setDayDetails(null);
        }

        if (hotelDetailId == true) {

            packageItineraryModel.setHotelDetailId(null);
        }

        if (hotelName == true) {

            packageItineraryModel.setHotelName(null);
        }

        return packageItineraryModel;
    }

    public List<PackageItineraryModel> mapListSetNull(boolean packageItineraryId,
                                                      boolean packageInfoId,
                                                      boolean packageName,
                                                      boolean day,
                                                      boolean dayDetails,
                                                      boolean hotelDetailId,
                                                      boolean hotelName,
                                                      List<PackageItineraryModel> packageItineraryModels) {

        for (PackageItineraryModel packageItineraryModel : packageItineraryModels) {

            packageItineraryModel = mapRowSetNull(packageItineraryId, packageInfoId, packageName, day, dayDetails, hotelDetailId, hotelName, packageItineraryModel);

        }

        return packageItineraryModels;
    }


}
