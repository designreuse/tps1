package igc.tech.com.mapper;

import igc.tech.com.model.CountryModel;
import igc.tech.com.model.PackageInfoModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CountryMappper {

	public List<CountryModel> mapList(List<Map> list) {

		List<CountryModel> resultList = new ArrayList<>();

		CountryModel country;

		for (Map m : list) {
			country = mapRow(m);
			resultList.add(country);
		}

		// System.out.println("ffasdf");

		return resultList;
	}

	public CountryModel mapRow(Map map) {

		CountryModel country = new CountryModel();

		country.setCountryID(map.get("COUNTRY_ID").toString());
		country.setCountryName(map.get("COUNTRY_NAME").toString());
		

		return country;
	}

}
