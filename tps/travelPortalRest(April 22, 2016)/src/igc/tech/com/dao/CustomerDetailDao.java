package igc.tech.com.dao;

import java.util.List;

public interface CustomerDetailDao {

	public List procCustomerDetail(String customerDetailId, String email, String password, String customerTitle, String firstName,
								   String middleName, String lastName, String contactNo, String customerType, String appVersion, String deviceEmail,
								   String deviceId, String regKey, String platform, String activationCode,String otpCode, String active,
								   String user, String flag);
}
