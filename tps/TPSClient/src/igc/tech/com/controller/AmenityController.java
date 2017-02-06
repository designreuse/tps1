package igc.tech.com.controller;

import com.google.gson.Gson;
import igc.tech.com.dao.AmenityDao;
import igc.tech.com.mapper.AmenityMapper;
import igc.tech.com.mapper.EasyTreeMapper;
import igc.tech.com.model.AmenityModel;
import igc.tech.com.model.EasyTreeModel;
import igc.tech.com.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ganga on 6/14/2016.
 */

@Controller
@RequestMapping(value = "/amenity")
public class AmenityController {

    @Autowired
    AmenityDao amenityDao;

    HashMap<String, String[]> siteContent = new HashMap<String, String[]>();

    static final String imageBaseUrl = System.getProperty("catalina.home") + "/webapps/TPSResources/AmenityIcons/";

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(Model model, HttpSession session){

        List<EasyTreeModel> easyTreeModelList = new EasyTreeMapper().mapList(amenityDao.procAmenity(new AmenityModel(), null, "a"),"amenity");
        System.out.println("easy tree: "+easyTreeModelList);

        siteContent.put("css", new String[]{"fontawesome-iconpicker/fontawesome-iconpicker.min.css"});
        siteContent.put("js", new String[]{"jsTree/jstree.min.js", "fontawesome-iconpicker/fontawesome-iconpicker.min.js"});
        model.addAttribute("siteContent", siteContent);

        String json = new Gson().toJson(easyTreeModelList);
        System.out.println(json);

        model.addAttribute("level",2);
        model.addAttribute("tree", json);
        model.addAttribute("base", "amenity");

        return "amenity";
    }

    /*@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(HttpSession session, AmenityModel amenityModel, RedirectAttributes redirectAttributes){

        amenityModel.setAmenityId(null);
        if(amenityModel.getParentAmenityId().equals("0")){
            amenityModel.setParentAmenityId(null);
        }

        if(amenityModel.getWebPrior().isEmpty())
            amenityModel.setWebPrior(null);
        if(amenityModel.getMobPrior().isEmpty())
            amenityModel.setMobPrior(null);
        if(amenityModel.getIcon().isEmpty())
            amenityModel.setIcon(null);

        Map map = (Map) amenityDao.procAmenity(amenityModel,session.getAttribute("userName").toString(), "i").get(0);
        redirectAttributes.addFlashAttribute("response", map);

        return "redirect:../amenity/view";
    }*/

    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    @ResponseBody
    public String update(HttpSession session,
                         String amenityId, String parentAmenityId, String amenityDesc,
                         String icon, String type, RedirectAttributes redirectAttributes)throws Exception{


        AmenityModel amenityModel = new AmenityModel();
        if(amenityId.indexOf("x") == -1) {
            amenityModel.setAmenityId(amenityId);
            amenityModel = new AmenityMapper().mapRow((Map) amenityDao.procAmenity(amenityModel, null, "s").get(0));
        }

        amenityModel = new AmenityModel();
        amenityModel.setAmenityId(amenityId);
        amenityModel.setAmenityDesc(amenityDesc);
        if(parentAmenityId.equals("0")){
            amenityModel.setParentAmenityId(null);
        }else{
            amenityModel.setParentAmenityId(parentAmenityId);
        }

        if(icon.isEmpty()){
            amenityModel.setIcon(null);
        }else{
            amenityModel.setIcon(icon);
        }
        /*if(!icon.isEmpty())
            amenityModel.setIcon(icon);
        if(!newFileName.isEmpty())
            amenityModel.setImage(newFileName);*/
        Map map = new HashMap();
        if(amenityModel.getAmenityId().indexOf("x")>-1){
            amenityModel.setAmenityId(null);
            map = (Map) amenityDao.procAmenity(amenityModel,session.getAttribute("userName").toString(), "i").get(0);
        }else{
            map = (Map) amenityDao.procAmenity(amenityModel,session.getAttribute("userName").toString(), "u").get(0);
        }
        redirectAttributes.addFlashAttribute("id", map.get("amenity_id"));
redirectAttributes.addFlashAttribute("response",map);
        return "redirect:../amenity/view";
        /*String json = new Gson().toJson(map);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);*/
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(HttpSession session, @RequestParam("amenityId") String amenityId, HttpServletResponse response)throws Exception{

        File file = new File(imageBaseUrl );
        File file2 = new File(imageBaseUrl + "/deleted");

        if (!file.exists()) {
            file.mkdir();
        }

        if (!file2.exists()) {
            file2.mkdir();
        }

        AmenityModel amenityModel = new AmenityModel();
        amenityModel.setAmenityId(amenityId);
        amenityModel = new AmenityMapper().mapRow((Map) amenityDao.procAmenity(amenityModel, null, "s").get(0));
        if(amenityModel.getImage()!=null) {
            if (!amenityModel.getImage().isEmpty()) {
                String source = imageBaseUrl + amenityModel.getImage();
                String target = imageBaseUrl + "deleted/" + amenityModel.getImage();
                System.out.println("source: " + source);
                System.out.println("target: " + target);
                Path movefrom = FileSystems.getDefault().getPath(source);
                Path target1 = FileSystems.getDefault().getPath(target);

                try {
                    Files.move(movefrom, target1, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }

       amenityModel = new AmenityModel();
        amenityModel.setAmenityId(amenityId);
        Map map = (Map) amenityDao.procAmenity(amenityModel,session.getAttribute("userName").toString(), "d").get(0);
        String json = new Gson().toJson(map);

       return json;
    }



}
