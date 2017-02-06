package igc.tech.com.dao;

import java.util.List;

public interface PackageInfoDao {

	public List procPackageInfo(String packageInfoId, String description,
								String noOfDays, String noOfNights, String totalDays,
								String packageDetails,String clientDetailId, String user,
								String flag) ;

}
