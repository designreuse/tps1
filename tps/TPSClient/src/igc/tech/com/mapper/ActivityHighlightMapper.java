package igc.tech.com.mapper;

import igc.tech.com.model.ActivityHighlightModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class ActivityHighlightMapper {


    public List<ActivityHighlightModel> mapList(List<Map> list) {

        List<ActivityHighlightModel> resultList = new ArrayList<>();

        ActivityHighlightModel activityHighlightModel;

        for (Map m : list) {
            activityHighlightModel = mapRow(m);
            resultList.add(activityHighlightModel);
        }



        return resultList;
    }

    public ActivityHighlightModel mapRow(Map map) {

        ActivityHighlightModel activityHighlightModel = new ActivityHighlightModel();


        activityHighlightModel.setActivityHighlightId(map.get("activity_highlight_id")==null?null:map.get("activity_highlight_id").toString());
        activityHighlightModel.setActivityId(map.get("activity_id").toString());
        activityHighlightModel.setPriority(map.get("priority")==null?"0":map.get("priority").toString());
        activityHighlightModel.setActivityDesc(map.get("activity_desc")==null?null:map.get("activity_desc").toString());

        return activityHighlightModel;


    }
}
