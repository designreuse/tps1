package igc.tech.com.mapper;

import igc.tech.com.model.ActivityDetailModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActivityDetailMapper {


    @SuppressWarnings("rawtypes")
    public List<ActivityDetailModel> mapList(List<Map> list) {
        List<ActivityDetailModel> resultList = new ArrayList<>();

        ActivityDetailModel activityDetailModel;

        for (Map m : list) {
            activityDetailModel = mapRow(m);
            resultList.add(activityDetailModel);
        }

        return resultList;
    }

    @SuppressWarnings("rawtypes")
    public ActivityDetailModel mapRow(Map map) {

        ActivityDetailModel activityDetailModel = new ActivityDetailModel();

        activityDetailModel.setActivityDetailId(map.get("ACTIVITY_DETAIL_ID").toString());
        activityDetailModel.setDescription(map.get("DESCRIPTION").toString());

        return activityDetailModel;
    }


}
