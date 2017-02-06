package igc.tech.com.dao;

import java.util.List;

public interface CountryDao {


	public List procCountryInfo(String country_id, String country_name,
			String user, String flag);

}
