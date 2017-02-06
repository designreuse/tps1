package igc.tech.com.mapper;

import igc.tech.com.model.CurrencyModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class CurrencyMapper {


    public List<CurrencyModel> mapList(List<Map> list) {

        List<CurrencyModel> resultList = new ArrayList<>();

        CurrencyModel currencyModel;

        for (Map m : list) {
            currencyModel = mapRow(m);
            resultList.add(currencyModel);
        }



        return resultList;
    }

    public CurrencyModel mapRow(Map map) {

        CurrencyModel currencyModel= new CurrencyModel();


        currencyModel.setCurrencyId(map.get("currency_id")==null? null:map.get("currency_id").toString() );
        currencyModel.setCurrencyDesc(map.get("currency_desc")==null? null:map.get("currency_desc").toString());
        currencyModel.setActive(map.get("active")==null? null:map.get("active").toString());

        return currencyModel;


    }
}
