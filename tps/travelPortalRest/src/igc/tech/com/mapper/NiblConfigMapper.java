package igc.tech.com.mapper;

import igc.tech.com.model.NiblConfigModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class NiblConfigMapper {


    public List<NiblConfigModel> mapList(List<Map> list) {

        List<NiblConfigModel> resultList = new ArrayList<>();

        NiblConfigModel niblConfigModel;

        for (Map m : list) {
            niblConfigModel = mapRow(m);
            resultList.add(niblConfigModel);
        }



        return resultList;
    }

    public NiblConfigModel mapRow(Map map) {

        NiblConfigModel niblConfigModel = new NiblConfigModel();


        niblConfigModel.setNiblConfigId(map.get("nibl_config_id").toString());
        niblConfigModel.setBandId(map.get("band_id").toString());
        niblConfigModel.setMode(map.get("mode").toString());
        niblConfigModel.setPayeeId(map.get("payee_id").toString());
        niblConfigModel.setCurrency(map.get("currency").toString());
        niblConfigModel.setReturnUrl(map.get("return_url").toString());
        niblConfigModel.setCg(map.get("cg").toString());
        niblConfigModel.setUserLangId(map.get("user_lang_id").toString());
        niblConfigModel.setUserType(map.get("user_type").toString());
        niblConfigModel.setAppType(map.get("app_type").toString());
        niblConfigModel.setType(map.get("type").toString());
        niblConfigModel.setActive(map.get("active").toString());



        return niblConfigModel;


    }
}
