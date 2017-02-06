package igc.tech.com.controller;

import com.google.gson.Gson;
import igc.tech.com.dao.ActivityDao;
import igc.tech.com.mapper.ActivityMapper;
import igc.tech.com.mapper.ActivityMapper;
import igc.tech.com.mapper.EasyTreeMapper;
import igc.tech.com.model.ActivityModel;
import igc.tech.com.model.ActivityModel;
import igc.tech.com.model.ActivityModel;
import igc.tech.com.model.EasyTreeModel;
import igc.tech.com.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Ganga on 6/14/2016.
 */

@Controller
@RequestMapping(value = "/activity")
public class ActivityController {

    @Autowired
    ActivityDao activityDao;

    HashMap<String, String[]> siteContent = new HashMap<String, String[]>();

    static final String imageBaseUrl = System.getProperty("catalina.home") + "/webapps/TPSResources/ActivityIcons/";

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(Model model, HttpSession session){

        List<EasyTreeModel> easyTreeModelList = new EasyTreeMapper().mapList(activityDao.procActivity(new ActivityModel(), null, "a"),"activity");
        System.out.println("easy tree: "+easyTreeModelList);

        String json = new Gson().toJson(easyTreeModelList);
        System.out.println(json);

        siteContent.put("css", new String[]{"fontawesome-iconpicker/fontawesome-iconpicker.min.css"});
        siteContent.put("js", new String[]{"jsTree/jstree.min.js", "fontawesome-iconpicker/fontawesome-iconpicker.min.js"});
        model.addAttribute("siteContent", siteContent);

        model.addAttribute("level", 2);
        model.addAttribute("tree", json);
        model.addAttribute("base", "activity");
//        model.addAttribute("title", "Activity");

        return "activity";
    }

   /* @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(HttpSession session, ActivityModel activityModel, RedirectAttributes redirectAttributes){

        activityModel.setActivityId(null);
        if(activityModel.getParentActivityId().equals("0")){
            activityModel.setParentActivityId(null);
        }
        System.out.println(activityModel);

        if(activityModel.getWebPrior().isEmpty())
            activityModel.setWebPrior(null);
        if(activityModel.getMobPrior().isEmpty())
            activityModel.setMobPrior(null);
        if(activityModel.getIcon().isEmpty())
            activityModel.setIcon(null);

        Map map = (Map) activityDao.procActivity(activityModel,session.getAttribute("userName").toString(), "i").get(0);
        redirectAttributes.addFlashAttribute("response", map);

        return "redirect:../activity/view";
    }*/

    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    @ResponseBody
    public String update(HttpSession session, String activityId, String parentActivityId, String activityDesc, String chargeOption,
                         String icon, RedirectAttributes redirectAttributes) throws Exception{


        ActivityModel activityModel = new ActivityModel();
        System.out.println(activityId.indexOf("x"));
        if(activityId.indexOf("x") == -1) {
            activityModel.setActivityId(activityId);
            activityModel = new ActivityMapper().mapRow((Map) activityDao.procActivity(activityModel, null, "s").get(0));
        }

        activityModel = new ActivityModel();
        activityModel.setActivityId(activityId);
        activityModel.setActivityDesc(activityDesc);
        if(parentActivityId.equals("0")){
            activityModel.setParentActivityId(null);
        }else{
            activityModel.setParentActivityId(parentActivityId);
        }
        System.out.println(activityModel);
        if(chargeOption.isEmpty())
            activityModel.setChargeOption(null);
        else
            activityModel.setChargeOption(chargeOption);

        if(icon.isEmpty()){
            activityModel.setIcon(null);
        }
        else{
            activityModel.setIcon(icon);
        }


        Map map = new HashMap();
        if(activityModel.getActivityId().indexOf("x")>-1){
            activityModel.setActivityId(null);
            map = (Map) activityDao.procActivity(activityModel,session.getAttribute("userName").toString(), "i").get(0);
        }else{
            map = (Map) activityDao.procActivity(activityModel,session.getAttribute("userName").toString(), "u").get(0);
        }
        redirectAttributes.addFlashAttribute("id", map.get("activity_id"));
        redirectAttributes.addFlashAttribute("response",map);


        return "redirect:../activity/view";
        /*String json = new Gson().toJson(map);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);*/
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(HttpSession session, @RequestParam("activityId") String activityId, HttpServletResponse response) throws Exception{

        File file = new File(imageBaseUrl );
        File file2 = new File(imageBaseUrl + "/deleted");

        if (!file.exists()) {
            file.mkdir();
        }

        if (!file2.exists()) {
            file2.mkdir();
        }

        ActivityModel activityModel = new ActivityModel();
        activityModel.setActivityId(activityId);
        activityModel = new ActivityMapper().mapRow((Map) activityDao.procActivity(activityModel, null, "s").get(0));

        if(activityModel.getImage() != null){
            if(!activityModel.getImage().isEmpty()){
                String source = imageBaseUrl + activityModel.getImage();
                String target = imageBaseUrl +  "deleted/" + activityModel.getImage();
                Path movefrom = FileSystems.getDefault().getPath(source);
                Path target1 = FileSystems.getDefault().getPath(target);

                try {
                    Files.move(movefrom, target1, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }


        activityModel = new ActivityModel();
        activityModel.setActivityId(activityId);
        Map map = (Map) activityDao.procActivity(activityModel,session.getAttribute("userName").toString(), "d").get(0);

        String json = new Gson().toJson(map);

        return json;
    }




}
