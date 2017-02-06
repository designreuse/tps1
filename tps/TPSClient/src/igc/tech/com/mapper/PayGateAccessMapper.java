package igc.tech.com.mapper;

import igc.tech.com.model.PayGateAccessModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class PayGateAccessMapper {


    public List<PayGateAccessModel> mapList(List<Map> list) {

        List<PayGateAccessModel> resultList = new ArrayList<>();

        PayGateAccessModel payGateAccessModel;

        for (Map m : list) {
            payGateAccessModel = mapRow(m);
            resultList.add(payGateAccessModel);
        }



        return resultList;
    }

    public PayGateAccessModel mapRow(Map map) {

        System.out.println(map);
        PayGateAccessModel payGateAccessModel = new PayGateAccessModel();

        payGateAccessModel.setPayGateAccessId(map.get("pay_gate_access_id").toString());
        payGateAccessModel.setPayGateDesc(map.get("pay_gate_desc").toString());
        payGateAccessModel.setType(map.get("type").toString());
        payGateAccessModel.setActive(map.get("active").toString());
        payGateAccessModel.setImage(map.get("image")==null? null:map.get("image").toString());

        return payGateAccessModel;


    }


    public PayGateAccessModel mapRowSetNull(boolean payGateAccessId,
                                          boolean payGateDesc,
                                          boolean type,
                                          boolean active,
                                          PayGateAccessModel payGateAccessModel) {


        if (payGateAccessId == true) {

            payGateAccessModel.setPayGateAccessId(null);
        }
        if (payGateDesc == true) {

            payGateAccessModel.setPayGateDesc(null);
        }
        if (type == true) {

            payGateAccessModel.setType(null);
        }
        if (active == true) {

            payGateAccessModel.setActive(null);
        }


        return payGateAccessModel;
    }

    public List<PayGateAccessModel> mapListSetNull(boolean payGateAccessId,
                                                   boolean payGateDesc,
                                                   boolean type,
                                                   boolean active,
                                                 List<PayGateAccessModel> payGateAccessModels) {

        for (PayGateAccessModel payGateAccessModel: payGateAccessModels) {

            payGateAccessModel = mapRowSetNull(payGateAccessId, payGateDesc,type, active, payGateAccessModel);

        }



        return payGateAccessModels;
    }
}
