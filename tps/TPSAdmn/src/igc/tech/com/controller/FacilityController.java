package igc.tech.com.controller;


import igc.tech.com.dao.FacilityDao;
import igc.tech.com.mapper.FacilityMapper;
import igc.tech.com.model.FacilityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/facility")
public class FacilityController {

    @Autowired
    FacilityDao facilityDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<FacilityModel> list = new FacilityMapper().mapList(facilityDao.procFacility(null, null, null, null,null, null, "a"));


        model.addAttribute("facilityList", list);
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }
        return "facility";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("mode", "add");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addFacility(Model model, FacilityModel facilityModel, HttpSession session, RedirectAttributes redirectAttributes) {

        if(facilityModel.getIcon().isEmpty()){
            facilityModel.setIcon(null);
        }
        if(facilityModel.getImage().isEmpty()){
            facilityModel.setImage(null);
        }

        Map map = (Map) facilityDao.procFacility(null, facilityModel.getFacilityDesc(), facilityModel.getType(), facilityModel.getIcon(), facilityModel.getImage(), session.getAttribute("userName")
                .toString(), "i").get
                (0);

        redirectAttributes.addFlashAttribute("dbResponse", map);
        redirectAttributes.addFlashAttribute("mode", "add");

        return "redirect:../facility/view";

    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String facilityID) {

        FacilityModel facilityModel = new FacilityMapper().mapRow((Map) facilityDao.procFacility(facilityID, null, null, null, null, null, "s").get(0));
        model.addAttribute("mode", "edit");
        model.addAttribute("facilityMap", facilityModel);
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, FacilityModel facilityModel, HttpSession session, RedirectAttributes redirectAttributes) {

        System.out.println(facilityModel.toString());
String icon = null; String image = null;
        if(!facilityModel.getIcon().isEmpty()){
            icon = facilityModel.getIcon();
        }
        if(facilityModel.getImage().isEmpty()){
            image = facilityModel.getImage();
        }

        Map map = (Map) facilityDao.procFacility(facilityModel.getFacilityId(),
                facilityModel.getFacilityDesc(), facilityModel.getType(), icon, image, session.getAttribute
                        ("userName").toString(), "u").get(0);

        redirectAttributes.addFlashAttribute("dbResponse", map);

        return "redirect:../facility/view";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("facilityId") String facilityId, HttpSession session, RedirectAttributes redirectAttributes) {


        Map map = (Map) facilityDao.procFacility(facilityId, null, null,null, null, session.getAttribute("userName").toString(), "d")
                .get(0);

        redirectAttributes.addFlashAttribute("dbResponse", map);

        return "redirect:../facility/view";
    }


}
