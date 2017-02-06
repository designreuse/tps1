package igc.tech.com.controller;


import com.google.gson.Gson;
import igc.tech.com.dao.EsewaConfigDao;
import igc.tech.com.mapper.EsewaConfigMapper;
import igc.tech.com.model.ActivityModel;
import igc.tech.com.model.EsewaConfigModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/esewaConfig")
public class EsewaConfigController {

    @Autowired
    EsewaConfigDao esewaConfigDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<EsewaConfigModel> list = new EsewaConfigMapper().mapList(esewaConfigDao.procEsewaConfig(new EsewaConfigModel(), null, "a"));


        model.addAttribute("esewaConfigList", list);
        model.addAttribute("base", "esewaConfig");
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }
        return "esewaConfig";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("mode", "update");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }





    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String esewaConfigID) {

        EsewaConfigModel esewaConfigModel1 = new EsewaConfigModel();
        esewaConfigModel1.setEsewaConfigId(esewaConfigID);
        EsewaConfigModel esewaConfigModel = new EsewaConfigMapper().mapRow((Map) esewaConfigDao.procEsewaConfig(esewaConfigModel1, null, "s").get(0));
        model.addAttribute("mode", "update");
        model.addAttribute("esewaConfigMap", esewaConfigModel);
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String edit(Model model, EsewaConfigModel esewaConfigModel, HttpSession session, RedirectAttributes redirectAttributes) {

        if(esewaConfigModel.getActive()==null)
            esewaConfigModel.setActive("N");

        if(esewaConfigModel.getEsewaConfigId().isEmpty()){
            esewaConfigModel.setEsewaConfigId(null);
            Map map = (Map) esewaConfigDao.procEsewaConfig(esewaConfigModel,session.getAttribute("userName").toString(),"i").get(0);
            model.addAttribute("response",map);
        }else{
            Map map = (Map) esewaConfigDao.procEsewaConfig(esewaConfigModel,session.getAttribute("userName").toString(),"u").get(0);
            model.addAttribute("response",map);
        }

        return "redirect:../esewaConfig/view";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("deleteId") String deleteId, HttpSession session, RedirectAttributes redirectAttributes) {

        EsewaConfigModel esewaConfigModel = new EsewaConfigModel();
        esewaConfigModel.setEsewaConfigId(deleteId);

        Map map = (Map) esewaConfigDao.procEsewaConfig(esewaConfigModel, session.getAttribute("userName").toString(), "d")
                .get(0);

        redirectAttributes.addFlashAttribute("dbResponse", map);

        return "redirect:../esewaConfig/view";
    }

    @RequestMapping(value = "/activate", method = RequestMethod.POST)
    @ResponseBody
    public String delete(HttpSession session, @RequestParam("configId") String configId, HttpServletResponse response) throws Exception{

        EsewaConfigModel esewaConfigModel = new EsewaConfigModel();
        esewaConfigModel.setActive("N");
        Map map = (Map) esewaConfigDao.procEsewaConfig(esewaConfigModel, session.getAttribute("userName").toString(), "e").get(0);

        esewaConfigModel.setEsewaConfigId(configId);
        esewaConfigModel.setActive("Y");
        map = (Map) esewaConfigDao.procEsewaConfig(esewaConfigModel, session.getAttribute("userName").toString(), "e").get(0);

        String json = new Gson().toJson(map);
        return json;
    }



}
