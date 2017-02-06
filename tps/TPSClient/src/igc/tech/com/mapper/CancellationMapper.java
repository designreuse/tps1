package igc.tech.com.mapper;

import igc.tech.com.model.CancellationModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class CancellationMapper {


    public List<CancellationModel> mapList(List<Map> list) {

        List<CancellationModel> resultList = new ArrayList<>();

        CancellationModel cancellationModel;

        for (Map m : list) {
            cancellationModel = mapRow(m);
            resultList.add(cancellationModel);
        }



        return resultList;
    }

    public CancellationModel mapRow(Map map) {

        CancellationModel cancellationModel = new CancellationModel();

        if(map.isEmpty()){
            return cancellationModel;
        }

        cancellationModel.setCancellationId(map.get("cancellation_id").toString());
        cancellationModel.setHotelDetailId(map.get("hotel_detail_id").toString());
        cancellationModel.setFreeCancellationBefore(map.get("free_cancellation_before").toString());
        cancellationModel.setChargeType(map.get("charge_type").toString());
        cancellationModel.setChargeAmount(map.get("charge_amount").toString());



        return cancellationModel;


    }
}
