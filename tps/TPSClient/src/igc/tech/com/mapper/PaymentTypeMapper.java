package igc.tech.com.mapper;

import igc.tech.com.model.PaymentTypeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class PaymentTypeMapper {


    public List<PaymentTypeModel> mapList(List<Map> list) {

        List<PaymentTypeModel> resultList = new ArrayList<>();

        PaymentTypeModel paymentTypeModel;

        for (Map m : list) {
            paymentTypeModel = mapRow(m);
            resultList.add(paymentTypeModel);
        }



        return resultList;
    }

    public PaymentTypeModel mapRow(Map map) {

        PaymentTypeModel paymentTypeModel = new PaymentTypeModel();


        paymentTypeModel.setPaymentTypeId(map.get("payment_type_id").toString());
        paymentTypeModel.setPaymentTypeDesc(map.get("payment_type_desc").toString());

        return paymentTypeModel;


    }
}
