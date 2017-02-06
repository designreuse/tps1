package igc.tech.com.dao;

import java.util.List;

public interface AvailableDateRateDao {


	@SuppressWarnings("rawtypes")
	public List procAvailableDateRate(String availableDateId, String availableDate,String packageInfoId,String rate,
			String user,  String flag);

}
