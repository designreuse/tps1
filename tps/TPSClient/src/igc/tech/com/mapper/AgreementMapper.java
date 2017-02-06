package igc.tech.com.mapper;

import igc.tech.com.model.AgreementModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class AgreementMapper {


    public List<AgreementModel> mapList(List<Map> list) {

        List<AgreementModel> resultList = new ArrayList<>();

        AgreementModel agreementModel;

        for (Map m : list) {
            agreementModel = mapRow(m);
            resultList.add(agreementModel);
        }



        return resultList;
    }

    public AgreementModel mapRow(Map map) {

        AgreementModel agreementModel = new AgreementModel();


        agreementModel.setAgreementId(map.get("agreement_id").toString());
        agreementModel.setTitle(map.get("title").toString());
        agreementModel.setContent(map.get("content").toString());
        agreementModel.setActive(map.get("active")==null?null:map.get("active").toString());
        agreementModel.setType(map.get("type")==null?null:map.get("type").toString());



        return agreementModel;


    }
}
