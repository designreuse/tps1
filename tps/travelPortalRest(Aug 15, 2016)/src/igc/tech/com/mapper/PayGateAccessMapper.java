package igc.tech.com.mapper;

import igc.tech.com.model.PayGateAccessModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
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

        PayGateAccessModel payGateAccessModel = new PayGateAccessModel();


        payGateAccessModel.setPayGateAccessId(map.get("pay_gate_access_id").toString());
        payGateAccessModel.setPayGateDesc(map.get("pay_gate_desc").toString());
        payGateAccessModel.setType(map.get("type").toString());
        payGateAccessModel.setActive(map.get("active").toString());


        return payGateAccessModel;


    }
}
