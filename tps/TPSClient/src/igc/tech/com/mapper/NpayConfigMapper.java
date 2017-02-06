package igc.tech.com.mapper;

import igc.tech.com.model.NpayConfigModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class NpayConfigMapper {


    public List<NpayConfigModel> mapList(List<Map> list) {

        List<NpayConfigModel> resultList = new ArrayList<>();

        NpayConfigModel npayConfigModel;

        for (Map m : list) {
            npayConfigModel = mapRow(m);
            resultList.add(npayConfigModel);
        }



        return resultList;
    }

    public NpayConfigModel mapRow(Map map) {
        NpayConfigModel npayConfigModel = new NpayConfigModel();


        npayConfigModel.setNpayConfigId(map.get("npay_config_id").toString());
        npayConfigModel.setMerchantId(map.get("merchant_id").toString());
        npayConfigModel.setMerchantUserName(map.get("merchant_user_name").toString());
        npayConfigModel.setMerchantPassword(map.get("merchant_password").toString());
        npayConfigModel.setSignature(map.get("signature").toString());
        npayConfigModel.setType(map.get("type").toString());
        npayConfigModel.setActive(map.get("active").toString());
        npayConfigModel.setInterfaceUrl(map.get("interface_url").toString());
        npayConfigModel.setApiUrl(map.get("api_url").toString());



        return npayConfigModel;


    }
}
