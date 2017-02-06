package igc.tech.com.dao;

import java.util.List;

public interface ClientDetailDao {


	public List procClientDetail(String clientDetailId, String clientName, String address, String phoneNumber, String emailId, String companyName, String companyAddress,
								 String companyPhoneNumber, String companyEmailId, String active,
								 String user, String flag);

}
