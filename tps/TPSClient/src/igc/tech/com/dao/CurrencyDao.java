package igc.tech.com.dao;

import igc.tech.com.model.CurrencyModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface CurrencyDao {

    public List procCurrency(CurrencyModel currencyModel, String user, String flag);

}
