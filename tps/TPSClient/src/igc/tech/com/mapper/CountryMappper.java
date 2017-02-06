package igc.tech.com.mapper;

import igc.tech.com.model.CountryModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CountryMappper {

    public List<CountryModel> mapList(List<Map> list) {

        List<CountryModel> resultList = new ArrayList<>();

        CountryModel countryModel;

        for (Map m : list) {
            countryModel = mapRow(m);
            resultList.add(countryModel);
        }

        return resultList;
    }

    public CountryModel mapRow(Map map) {

        CountryModel countryModel = new CountryModel();

        countryModel.setCountryId(map.get("COUNTRY_ID").toString());
        countryModel.setCountryName(map.get("COUNTRY_NAME").toString());

        return countryModel;
    }

}
