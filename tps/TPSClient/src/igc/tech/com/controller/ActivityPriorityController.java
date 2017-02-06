package igc.tech.com.controller;

import com.google.gson.Gson;
import igc.tech.com.dao.ActivityDao;
import igc.tech.com.mapper.EasyTreeMapper;
import igc.tech.com.model.ActivityModel;
import igc.tech.com.model.EasyTreeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ganga on 6/14/2016.
 */

@Controller
@RequestMapping(value = "/activityPriority")
public class ActivityPriorityController {

    @Autowired
    ActivityDao activityDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(Model model, HttpSession session){

        List<EasyTreeModel> easyTreeModelList = new EasyTreeMapper().mapList(activityDao.procActivity(new ActivityModel(), null, "a"),"activity");
        System.out.println("easy tree: "+easyTreeModelList);

        String json = new Gson().toJson(easyTreeModelList);
        System.out.println(json);

        model.addAttribute("level", 2);
        model.addAttribute("tree", json);
        model.addAttribute("base", "activity");
//        model.addAttribute("title", "Activity");

        return "activity";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(HttpSession session, ActivityModel activityModel, HttpServletResponse response) throws Exception{
        if(activityModel.getParentActivityId().equals("0")){
            activityModel.setParentActivityId(null);
        }
        System.out.println(activityModel);
        if(activityModel.getChargeOption().isEmpty())
            activityModel.setChargeOption(null);
        if(activityModel.getIcon().isEmpty())
            activityModel.setIcon(null);


        Map map = new HashMap();
        if(activityModel.getActivityId().indexOf("x")>-1){
            activityModel.setActivityId(null);
            map = (Map) activityDao.procActivity(activityModel,session.getAttribute("userName").toString(), "i").get(0);
        }else{
            map = (Map) activityDao.procActivity(activityModel,session.getAttribute("userName").toString(), "u").get(0);
        }
        String json = new Gson().toJson(map);
        return json;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(HttpSession session, @RequestParam("activityId") String activityId, HttpServletResponse response) throws Exception{

        ActivityModel activityModel = new ActivityModel();
        activityModel.setActivityId(activityId);
        Map map = (Map) activityDao.procActivity(activityModel,session.getAttribute("userName").toString(), "d").get(0);

        String json = new Gson().toJson(map);
       return json;
    }




}
