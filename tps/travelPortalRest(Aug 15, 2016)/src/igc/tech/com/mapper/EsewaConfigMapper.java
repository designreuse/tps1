package igc.tech.com.mapper;

import igc.tech.com.model.EsewaConfigModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class EsewaConfigMapper {


    public List<EsewaConfigModel> mapList(List<Map> list) {

        List<EsewaConfigModel> resultList = new ArrayList<>();

        EsewaConfigModel esewaConfigModel;

        for (Map m : list) {
            esewaConfigModel = mapRow(m);
            resultList.add(esewaConfigModel);
        }



        return resultList;
    }

    public EsewaConfigModel mapRow(Map map) {

        EsewaConfigModel esewaConfigModel = new EsewaConfigModel();


        esewaConfigModel.setEsewaConfigId(map.get("esewa_config_id").toString());
        esewaConfigModel.setServiceCode(map.get("service_code").toString());
        esewaConfigModel.setSuccessUrl(map.get("success_url").toString());
        esewaConfigModel.setFailUrl(map.get("fail_url").toString());
        esewaConfigModel.setInterfaceUrl(map.get("interface_url").toString());
        esewaConfigModel.setVerifyApiUrl(map.get("verify_api_url").toString());
        esewaConfigModel.setType(map.get("type").toString());
        esewaConfigModel.setActive(map.get("active").toString());



        return esewaConfigModel;


    }
}
