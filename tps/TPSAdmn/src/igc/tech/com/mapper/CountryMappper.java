package igc.tech.com.mapper;

import igc.tech.com.model.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CountryMappper {

    public List<Country> mapList(List<Map> list) {

        List<Country> resultList = new ArrayList<>();

        Country country;

        for (Map m : list) {
            country = mapRow(m);
            resultList.add(country);
        }

        return resultList;
    }

    public Country mapRow(Map map) {

        Country country = new Country();

        country.setCountryId(map.get("COUNTRY_ID").toString());
        country.setCountryName(map.get("COUNTRY_NAME").toString());

        return country;
    }

}
