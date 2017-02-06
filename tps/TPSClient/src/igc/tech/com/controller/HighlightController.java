package igc.tech.com.controller;

import com.google.gson.Gson;
import igc.tech.com.dao.*;
import igc.tech.com.mapper.ActivityHighlightMapper;
import igc.tech.com.mapper.ActivityMapper;
import igc.tech.com.mapper.AmenityHighlightMapper;
import igc.tech.com.mapper.AmenityMapper;
import igc.tech.com.model.ActivityHighlightModel;
import igc.tech.com.model.ActivityModel;
import igc.tech.com.model.AmenityHighlightModel;
import igc.tech.com.model.AmenityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ganga on 6/14/2016.
 */

@Controller
@RequestMapping(value = "/highlight")
public class HighlightController {

    @Autowired
    ActivityHighlightDao activityHighlightDao;

    @Autowired
    AmenityHighlightDao amenityHighlightDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(Model model, HttpSession session){

//        ActivityModel activityModel = new ActivityModel();
        int size = 10;

        List<ActivityHighlightModel> activityHighlightModelList = new ActivityHighlightMapper().mapList(activityHighlightDao.procActivityHighlight(new ActivityHighlightModel(),null,"hightlighted_list"));
        model.addAttribute("activityHighlightList", activityHighlightModelList);

        activityHighlightModelList = new ActivityHighlightMapper().mapList(activityHighlightDao.procActivityHighlight(new ActivityHighlightModel(),null,"unhightlighted_list"));
        model.addAttribute("activityUnhighlightList", activityHighlightModelList);

        List<AmenityHighlightModel> amenityHighlightModelList = new AmenityHighlightMapper().mapList(amenityHighlightDao.procAmenityHighlight(new AmenityHighlightModel(),null,"hightlighted_list"));
        model.addAttribute("amenityHighlightList", amenityHighlightModelList);

        amenityHighlightModelList = new AmenityHighlightMapper().mapList(amenityHighlightDao.procAmenityHighlight(new AmenityHighlightModel(),null,"unhightlighted_list"));
        model.addAttribute("amenityUnhighlightList", amenityHighlightModelList);

        model.addAttribute("size", size);

        model.addAttribute("base", "highlight");
//        model.addAttribute("title", "Activity");

        return "highlight";
    }



    @RequestMapping(value = "/updateActivityHighLight", method = RequestMethod.POST)
    public String update(HttpSession session, String id, String priority, RedirectAttributes redirectAttributes) throws Exception{

        ActivityHighlightModel activityHighlightModel = new ActivityHighlightModel();
        activityHighlightModel.setPriority(priority);

        List<ActivityHighlightModel> activityHighlightModelList = new ActivityHighlightMapper().mapList(activityHighlightDao.procActivityHighlight(activityHighlightModel,null,"s"));
        if(activityHighlightModelList.isEmpty()){
            if(id.isEmpty()){
                activityHighlightModel.setActivityId(null);
            }else{
                activityHighlightModel.setActivityId(id);
            }

            Map map = (Map) activityHighlightDao.procActivityHighlight(activityHighlightModel, session.getAttribute("userName").toString(), "i").get(0);
            redirectAttributes.addFlashAttribute("response", map);
        }else{
            if(id.isEmpty()){
                activityHighlightModel.setActivityId(null);
            }else{
                activityHighlightModel.setActivityId(id);
            }

            Map map = (Map) activityHighlightDao.procActivityHighlight(activityHighlightModel, session.getAttribute("userName").toString(), "u").get(0);
            redirectAttributes.addFlashAttribute("response", map);
        }



        return "redirect:view";
    }

    @RequestMapping(value = "/updateAmenityHighLight", method = RequestMethod.POST)
    public String updateAmenity(HttpSession session, String id, String priority, RedirectAttributes redirectAttributes) throws Exception{

        AmenityHighlightModel amenityHighlightModel = new AmenityHighlightModel();
        amenityHighlightModel.setPriority(priority);

        List<AmenityHighlightModel> amenityHighlightModelList = new AmenityHighlightMapper().mapList(amenityHighlightDao.procAmenityHighlight(amenityHighlightModel,null,"s"));
        if(amenityHighlightModelList.isEmpty()){
            if(id.isEmpty()){
                amenityHighlightModel.setAmenityId(null);
            }else{
                amenityHighlightModel.setAmenityId(id);
            }

            Map map = (Map) amenityHighlightDao.procAmenityHighlight(amenityHighlightModel, session.getAttribute("userName").toString(), "i").get(0);
            redirectAttributes.addFlashAttribute("response", map);
        }else{
            if(id.isEmpty()){
                amenityHighlightModel.setAmenityId(null);
            }else{
                amenityHighlightModel.setAmenityId(id);
            }

            Map map = (Map) amenityHighlightDao.procAmenityHighlight(amenityHighlightModel, session.getAttribute("userName").toString(), "u").get(0);
            redirectAttributes.addFlashAttribute("response", map);
        }



        return "redirect:view";
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
