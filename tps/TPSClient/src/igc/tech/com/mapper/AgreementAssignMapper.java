package igc.tech.com.mapper;

import igc.tech.com.model.AgreementAssignModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class AgreementAssignMapper {


    public List<AgreementAssignModel> mapList(List<Map> list) {

        List<AgreementAssignModel> resultList = new ArrayList<>();

        AgreementAssignModel agreementAssignModel;

        for (Map m : list) {
            agreementAssignModel = mapRow(m);
            resultList.add(agreementAssignModel);
        }



        return resultList;
    }

    public AgreementAssignModel mapRow(Map map) {

        AgreementAssignModel agreementAssignModel = new AgreementAssignModel();


        agreementAssignModel.setAgreementAssignId(map.get("agreement_assign_id").toString());
        agreementAssignModel.setAgreementId(map.get("agreeement_id")==null?null:map.get("agreeement_id").toString());
        agreementAssignModel.setType(map.get("type").toString());



        return agreementAssignModel;


    }
}
