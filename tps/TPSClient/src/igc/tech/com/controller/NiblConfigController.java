package igc.tech.com.controller;


import com.google.gson.Gson;
import igc.tech.com.dao.NiblConfigDao;
import igc.tech.com.mapper.NiblConfigMapper;
import igc.tech.com.model.NiblConfigModel;
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
@RequestMapping(value = "/niblConfig")
public class NiblConfigController {

    @Autowired
    NiblConfigDao niblConfigDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<NiblConfigModel> list = new NiblConfigMapper().mapList(niblConfigDao.procNiblConfig(new NiblConfigModel(), null, "a"));


        model.addAttribute("niblConfigList", list);
        model.addAttribute("base", "niblConfig");
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }
        return "niblConfig";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("mode", "update");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }





    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String niblConfigID) {

        NiblConfigModel niblConfigModel1 = new NiblConfigModel();
        niblConfigModel1.setNiblConfigId(niblConfigID);
        NiblConfigModel niblConfigModel = new NiblConfigMapper().mapRow((Map) niblConfigDao.procNiblConfig(niblConfigModel1, null, "s").get(0));
        model.addAttribute("mode", "update");
        model.addAttribute("niblConfigMap", niblConfigModel);
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String edit(Model model, NiblConfigModel niblConfigModel, HttpSession session, RedirectAttributes redirectAttributes) {

        if(niblConfigModel.getActive()==null)
            niblConfigModel.setActive("N");

        if(niblConfigModel.getNiblConfigId().isEmpty()){
            niblConfigModel.setNiblConfigId(null);
            Map map = (Map) niblConfigDao.procNiblConfig(niblConfigModel,session.getAttribute("userName").toString(),"i").get(0);
            model.addAttribute("response",map);
        }else{
            Map map = (Map) niblConfigDao.procNiblConfig(niblConfigModel,session.getAttribute("userName").toString(),"u").get(0);
            model.addAttribute("response",map);
        }

        return "redirect:../niblConfig/view";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("deleteId") String deleteId, HttpSession session, RedirectAttributes redirectAttributes) {

        NiblConfigModel niblConfigModel = new NiblConfigModel();
        niblConfigModel.setNiblConfigId(deleteId);

        Map map = (Map) niblConfigDao.procNiblConfig(niblConfigModel, session.getAttribute("userName").toString(), "d")
                .get(0);

        redirectAttributes.addFlashAttribute("dbResponse", map);

        return "redirect:../niblConfig/view";
    }

    @RequestMapping(value = "/activate", method = RequestMethod.POST)
    @ResponseBody
    public String delete(HttpSession session, @RequestParam("configId") String configId, HttpServletResponse response) throws Exception{

        NiblConfigModel niblConfigModel = new NiblConfigModel();
        niblConfigModel.setActive("N");
        Map map = (Map) niblConfigDao.procNiblConfig(niblConfigModel, session.getAttribute("userName").toString(), "e").get(0);

        niblConfigModel.setNiblConfigId(configId);
        niblConfigModel.setActive("Y");
        map = (Map) niblConfigDao.procNiblConfig(niblConfigModel, session.getAttribute("userName").toString(), "e").get(0);

        String json = new Gson().toJson(map);
        return json;
    }



}
