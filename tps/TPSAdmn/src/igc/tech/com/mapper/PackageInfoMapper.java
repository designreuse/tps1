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

        //	System.out.println("ffasdf");

        return resultList;
    }

    public PackageInfoModel mapRow(Map map) {

        PackageInfoModel packageInfo = new PackageInfoModel();

        packageInfo.setPackageInfoId(map.get("PACKAGE_INFO_ID").toString());
        packageInfo.setDescription(map.get("DESCRIPTION").toString());
        packageInfo.setClientDetailId(map.get("CLIENT_DETAIL_ID").toString());
        packageInfo.setNoOfDays(map.get("NO_OF_DAYS").toString());
        packageInfo.setNoOfNights(map.get("NO_OF_NIGHTS").toString());
        packageInfo.setTotalDays(map.get("TOTAL_DAYS").toString());
        packageInfo.setPackageDetails(map.get("PACKAGE_DETAILS").toString());
        packageInfo.setClientName(map.get("CLIENT_NAME").toString());
        packageInfo.setCompanyName(map.get("COMPANY_NAME").toString());

        return packageInfo;

        //xiaomi
    }

}
