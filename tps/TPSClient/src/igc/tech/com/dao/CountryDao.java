package igc.tech.com.dao;

import igc.tech.com.model.CountryModel;

import java.util.List;

public interface CountryDao {


    public List procCountry(CountryModel countryModel,
                            String user, String flag);

}
