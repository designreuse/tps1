package igc.tech.com.mapper;

import igc.tech.com.model.PackageBookingStatusModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PackageBookingStatusMapper {

    @SuppressWarnings("rawtypes")
    public List<PackageBookingStatusModel> mapList(List<Map> list) {

        List<PackageBookingStatusModel> resultList = new ArrayList<>();

        PackageBookingStatusModel packageBookingStatusModel;

        for (Map m : list) {
            packageBookingStatusModel = mapRow(m);
            resultList.add(packageBookingStatusModel);
        }

        return resultList;
    }

    @SuppressWarnings("rawtypes")
    public PackageBookingStatusModel mapRow(Map map) {

        PackageBookingStatusModel packageBookingStatusModel = new PackageBookingStatusModel();


        if (map.get("package_booking_status_id") != null) {
            packageBookingStatusModel.setPackageBookingStatusId(map.get("package_booking_status_id").toString());
        }


        if (map.get("package_booking_id") != null) {
            packageBookingStatusModel.setPackageBookingId(map.get("package_booking_id").toString());

        }


        if (map.get("package_status") != null) {
            packageBookingStatusModel.setPackageStatus(map.get("package_status").toString());

        }

        if (map.get("active") != null) {
            packageBookingStatusModel.setActive(map.get("active").toString());

        }
        if (map.get("hash_code") != null) {
            packageBookingStatusModel.setHashCode(map.get("hash_code").toString());

        }

        return packageBookingStatusModel;
    }


}
