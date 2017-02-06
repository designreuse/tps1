package igc.tech.com.mapper;

import igc.tech.com.model.PushContentDataModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class PushContentDataMapper {


    public List<PushContentDataModel> mapList(List<Map> list) {

        List<PushContentDataModel> resultList = new ArrayList<>();

        PushContentDataModel pushContentDataModel;

        for (Map m : list) {
            pushContentDataModel = mapRow(m);
            resultList.add(pushContentDataModel);
        }



        return resultList;
    }

    public PushContentDataModel mapRow(Map map) {

        PushContentDataModel pushContentDataModel = new PushContentDataModel();

        pushContentDataModel.setPushContentDataId(map.get("push_content_data_id").toString());
        pushContentDataModel.setHotelDetailId(map.get("hotel_detail_id").toString());
        pushContentDataModel.setStatus(map.get("status").toString());

        return pushContentDataModel;


    }
}
