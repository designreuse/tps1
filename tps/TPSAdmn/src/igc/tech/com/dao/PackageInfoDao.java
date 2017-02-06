package igc.tech.com.dao;

import java.util.List;

public interface PackageInfoDao {

    public List procPackageInfo(String package_info_id,String clientDetailId, String description,
                                String no_of_days, String no_of_nights, String total_days,
                                String package_details, String user, String flag);

}
