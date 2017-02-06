package igc.tech.com.mapper;

import igc.tech.com.model.SelectedPaymentTypeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class SelectedPaymentTypeMapper {


    public List<SelectedPaymentTypeModel> mapList(List<Map> list) {

        List<SelectedPaymentTypeModel> resultList = new ArrayList<>();

        SelectedPaymentTypeModel selectedPaymentTypeModel;

        for (Map m : list) {
            selectedPaymentTypeModel = mapRow(m);
            resultList.add(selectedPaymentTypeModel);
        }



        return resultList;
    }

    public SelectedPaymentTypeModel mapRow(Map map) {

        SelectedPaymentTypeModel selectedPaymentTypeModel = new SelectedPaymentTypeModel();


        selectedPaymentTypeModel.setPaymentTypeId(map.get("payment_type_id").toString());
        selectedPaymentTypeModel.setHotelDetailId(map.get("hotel_detail_id").toString());
        selectedPaymentTypeModel.setActive(map.get("active").toString());

        return selectedPaymentTypeModel;


    }
}
