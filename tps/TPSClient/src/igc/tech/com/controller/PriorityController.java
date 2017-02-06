package igc.tech.com.controller;

import com.google.gson.Gson;
import igc.tech.com.dao.ActivityDao;
import igc.tech.com.dao.AmenityDao;
import igc.tech.com.mapper.ActivityMapper;
import igc.tech.com.mapper.AmenityMapper;
import igc.tech.com.mapper.EasyTreeMapper;
import igc.tech.com.model.ActivityModel;
import igc.tech.com.model.AmenityModel;
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
@RequestMapping(value = "/priority")
public class PriorityController {

    @Autowired
    ActivityDao activityDao;

    @Autowired
    AmenityDao amenityDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(Model model, HttpSession session){

//        ActivityModel activityModel = new ActivityModel();
        int size = 5;
        List<ActivityModel> activityModelList = new ActivityMapper().mapList(activityDao.procActivity(new ActivityModel(), null, "b"));
        model.addAttribute("selectedActivityList",new Gson().toJson(activityModelList));
        if(size<activityModelList.size())
            size= activityModelList.size();

        activityModelList = new ActivityMapper().mapList(activityDao.procActivity(new ActivityModel(), null,"w"));
        model.addAttribute("webActivityList", new Gson().toJson(activityModelList));

        activityModelList = new ActivityMapper().mapList(activityDao.procActivity(new ActivityModel(), null,"m"));
        model.addAttribute("mobActivityList", new Gson().toJson(activityModelList));


        List<AmenityModel> amenityModelList = new AmenityMapper().mapList(amenityDao.procAmenity(new AmenityModel(), null,"b"));
        model.addAttribute("selectedAmenityList", new Gson().toJson(amenityModelList));
        if(size<amenityModelList.size())
            size = amenityModelList.size();

        amenityModelList = new AmenityMapper().mapList(amenityDao.procAmenity(new AmenityModel(), null,"w"));
        model.addAttribute("webAmenityList", new Gson().toJson(amenityModelList));

        amenityModelList = new AmenityMapper().mapList(amenityDao.procAmenity(new AmenityModel(), null,"m"));
        model.addAttribute("mobAmenityList", new Gson().toJson(amenityModelList));

        model.addAttribute("size", size);

        model.addAttribute("base", "priority");
//        model.addAttribute("title", "Activity");

        return "priority";
    }



    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(HttpSession session, String activityId, String priority, String type, HttpServletResponse response) throws Exception{
        ActivityModel activityModel = new ActivityModel();
        if(type.equals("web"))
            activityModel.setWebPrior(priority);
        else if(type.equals("mob"))
            activityModel.setMobPrior(priority);
        Map map = new HashMap();
        if(!activityId.isEmpty()){
            activityModel.setActivityId(activityId);
        }
        map = (Map) activityDao.procActivity(activityModel,null,"u").get(0);
        /*if(activityModel.getParentActivityId().equals("0")){
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
        }*/
        String json = new Gson().toJson(map);
        return json;
    }

    @RequestMapping(value = "/updateAmenity", method = RequestMethod.POST)
    @ResponseBody
    public String updateAmenityPriority(HttpSession session, String amenityId, String priority, String type, HttpServletResponse response) throws Exception{
        AmenityModel amenityModel = new AmenityModel();
        if(type.equals("web"))
            amenityModel.setWebPrior(priority);
        else if(type.equals("mob"))
            amenityModel.setMobPrior(priority);
        Map map = new HashMap();
        if(!amenityId.isEmpty()){
            amenityModel.setAmenityId(amenityId);
        }
        map = (Map) amenityDao.procAmenity(amenityModel,null,"u").get(0);

        String json = new Gson().toJson(map);
        return json;
    }

   /* @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public void delete(HttpSession session, @RequestParam("activityId") String activityId, HttpServletResponse response) throws Exception{

        ActivityModel activityModel = new ActivityModel();
        activityModel.setActivityId(activityId);
        Map map = (Map) activityDao.procActivity(activityModel,session.getAttribute("userName").toString(), "d").get(0);

        String json = new Gson().toJson(map);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
*/



}
