package igc.tech.com.mapper;

import igc.tech.com.model.ActivityModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class ActivityMapper {


    public List<ActivityModel> mapList(List<Map> list) {

        List<ActivityModel> resultList = new ArrayList<>();

        ActivityModel activityModel;

        for (Map m : list) {
            activityModel = mapRow(m);
            resultList.add(activityModel);
        }



        return resultList;
    }

    public ActivityModel mapRow(Map map) {

        ActivityModel activityModel = new ActivityModel();


        activityModel.setActivityId(map.get("activity_id").toString());
        activityModel.setParentActivityId(map.get("parent_activity_id")==null?"0":map.get("parent_activity_id").toString());
        activityModel.setActivityDesc(map.get("activity_desc").toString());
        activityModel.setChargeOption(map.get("charge_option")==null?null:map.get("charge_option").toString());
        activityModel.setActive(map.get("active")==null?null:map.get("active").toString());
        activityModel.setWebPrior(map.get("web_prior")==null?null:map.get("web_prior").toString());
        activityModel.setMobPrior(map.get("mob_prior")==null?null:map.get("mob_prior").toString());
        activityModel.setIcon(map.get("icon")==null?null:map.get("icon").toString());
        activityModel.setImage(map.get("image")==null?null:map.get("image").toString());
        activityModel.setDeletedFlag(map.get("deleted_flag")==null?null:map.get("deleted_flag").toString());

        System.out.println(activityModel);



        return activityModel;


    }
}
