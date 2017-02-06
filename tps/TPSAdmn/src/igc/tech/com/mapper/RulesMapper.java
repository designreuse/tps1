package igc.tech.com.mapper;

import igc.tech.com.model.RulesModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2/1/2016.
 */
public class RulesMapper {

    public List<RulesModel> mapList(List<Map> list) {

        List<RulesModel> resultList = new ArrayList<>();

        /*if(resultList.isEmpty()){
            return resultList;
        }*/

        RulesModel rulesModel;

        for (Map m : list) {
            rulesModel = mapRow(m);
            resultList.add(rulesModel);
        }


        return resultList;
    }

    public RulesModel mapRow(Map map) {

        RulesModel rulesModel = new RulesModel();
        rulesModel.setRulesId(map.get("rules_id").toString());
        rulesModel.setRulesDesc(map.get("rules_desc").toString());
        rulesModel.setType(map.get("type").toString());

        return rulesModel;
    }


}
