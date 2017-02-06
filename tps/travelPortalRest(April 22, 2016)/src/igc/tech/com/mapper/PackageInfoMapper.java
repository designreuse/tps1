package igc.tech.com.mapper;

import igc.tech.com.model.PackageInfoModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PackageInfoMapper {

    public List<PackageInfoModel> mapList(List<Map> list) {

        List<PackageInfoModel> resultList = new ArrayList<>();

        PackageInfoModel packageInfo;

        for (Map m : list) {
            packageInfo = mapRow(m);
            resultList.add(packageInfo);
        }

        return resultList;
    }

    public PackageInfoModel mapRow(Map map) {


        System.out.println(map);

        PackageInfoModel packageInfo = new PackageInfoModel();

        if (map.get("PACKAGE_INFO_ID") != null) {

            packageInfo.setPackageInfoId(map.get("PACKAGE_INFO_ID").toString());
        }

        if (map.get("DESCRIPTION") != null) {

            packageInfo.setDescription(map.get("DESCRIPTION").toString());
        }

        if (map.get("PACKAGE_NAME") != null) {

            packageInfo.setPackageName(map.get("PACKAGE_NAME").toString());
        }

        if (map.get("NO_OF_DAYS") != null) {

            packageInfo.setNoOfDays(map.get("NO_OF_DAYS").toString());
        }

        if (map.get("NO_OF_NIGHTS") != null) {

            packageInfo.setNoOfNights(map.get("NO_OF_NIGHTS").toString());
        }

        if (map.get("TOTAL_DAYS") != null) {

            packageInfo.setTotalDays(map.get("TOTAL_DAYS").toString());
        }

        if (map.get("PACKAGE_DETAILS") != null) {

            packageInfo.setPackageDetails(map.get("PACKAGE_DETAILS").toString());
        }

        if (map.get("CLIENT_DETAIL_ID") != null) {

            packageInfo.setClientDetailId(map.get("CLIENT_DETAIL_ID").toString());
        }

        if (map.get("CLIENT_NAME") != null) {

            packageInfo.setClientName(map.get("CLIENT_NAME").toString());
        }


        return packageInfo;
    }


    public PackageInfoModel mapRowSetNull(boolean packageInfoId,
                                          boolean description,
                                          boolean packageName,
                                          boolean noOfDays,
                                          boolean noOfNights,
                                          boolean totalDays,
                                          boolean packageDetails,
                                          boolean clientDetailId,
                                          boolean clientName,
                                          PackageInfoModel packageInfoModel) {


        if (packageInfoId == true) {

            packageInfoModel.setPackageInfoId(null);
        }

        if (description == true) {

            packageInfoModel.setDescription(null);
        }

        if (packageName == true) {

            packageInfoModel.setPackageName(null);
        }

        if (noOfDays == true) {

            packageInfoModel.setNoOfDays(null);
        }

        if (noOfNights == true) {

            packageInfoModel.setNoOfNights(null);
        }

        if (totalDays) {

            packageInfoModel.setTotalDays(null);
        }

        if (packageDetails == true) {

            packageInfoModel.setPackageDetails(null);
        }

        if (clientDetailId == true) {

            packageInfoModel.setClientDetailId(null);
        }

        if (clientName == true) {

            packageInfoModel.setClientName(null);
        }

        return packageInfoModel;
    }

    public List<PackageInfoModel> mapListSetNull(boolean packageInfoId,
                                                 boolean description,
                                                 boolean packageName,
                                                 boolean noOfDays,
                                                 boolean noOfNights,
                                                 boolean totalDays,
                                                 boolean packageDetails,
                                                 boolean clientDetailId,
                                                 boolean clientName,
                                                 List<PackageInfoModel> packageInfoModels) {

        for (PackageInfoModel packageInfoModel : packageInfoModels) {

            packageInfoModel = mapRowSetNull(packageInfoId, description, packageName, noOfDays,
                    noOfNights, totalDays, packageDetails, clientDetailId, clientName, packageInfoModel);

        }

        return packageInfoModels;
    }


}
