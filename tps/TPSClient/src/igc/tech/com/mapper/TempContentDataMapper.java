package igc.tech.com.mapper;

import igc.tech.com.model.TempContentDataModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class TempContentDataMapper {


    public List<TempContentDataModel> mapList(List<Map> list) {

        List<TempContentDataModel> resultList = new ArrayList<>();

        TempContentDataModel tempContentDataModel;

        for (Map m : list) {
            tempContentDataModel = mapRow(m);
            resultList.add(tempContentDataModel);
        }



        return resultList;
    }

    public TempContentDataModel mapRow(Map map) {

        TempContentDataModel tempContentDataModel = new TempContentDataModel();

        tempContentDataModel.setTempContentDataId(map.get("temp_content_data_id").toString());
        tempContentDataModel.setPushContentDataId(map.get("push_content_data_id").toString());
        tempContentDataModel.setField(map.get("field").toString());
        tempContentDataModel.setContentData(map.get("content_data").toString());
        tempContentDataModel.setType(map.get("type").toString());
        tempContentDataModel.setRefId(map.get("ref_id").toString());

        return tempContentDataModel;


    }
}
