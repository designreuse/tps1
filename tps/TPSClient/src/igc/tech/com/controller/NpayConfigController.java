package igc.tech.com.controller;


import com.google.gson.Gson;
import igc.tech.com.dao.NpayConfigDao;
import igc.tech.com.mapper.NpayConfigMapper;
import igc.tech.com.model.NpayConfigModel;
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
@RequestMapping(value = "/npayConfig")
public class NpayConfigController {

    @Autowired
    NpayConfigDao npayConfigDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<NpayConfigModel> list = new NpayConfigMapper().mapList(npayConfigDao.procNpayConfig(new NpayConfigModel(), null, "a"));


        model.addAttribute("npayConfigList", list);
        model.addAttribute("base", "npayConfig");
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }
        return "npayConfig";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("mode", "update");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }





    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String npayConfigID) {

        NpayConfigModel npayConfigModel1 = new NpayConfigModel();
        npayConfigModel1.setNpayConfigId(npayConfigID);
        NpayConfigModel npayConfigModel = new NpayConfigMapper().mapRow((Map) npayConfigDao.procNpayConfig(npayConfigModel1, null, "s").get(0));
        model.addAttribute("mode", "update");
        model.addAttribute("npayConfigMap", npayConfigModel);
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String edit(Model model, NpayConfigModel npayConfigModel, HttpSession session, RedirectAttributes redirectAttributes) {

        if(npayConfigModel.getActive()==null){
            npayConfigModel.setActive("N");
        }


        if(npayConfigModel.getNpayConfigId().isEmpty()){
            npayConfigModel.setNpayConfigId(null);
            Map map = (Map) npayConfigDao.procNpayConfig(npayConfigModel,session.getAttribute("userName").toString(),"i").get(0);
            model.addAttribute("response",map);
        }else{
            Map map = (Map) npayConfigDao.procNpayConfig(npayConfigModel,session.getAttribute("userName").toString(),"u").get(0);
            model.addAttribute("response",map);
        }

        return "redirect:../npayConfig/view";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("deleteId") String deleteId, HttpSession session, RedirectAttributes redirectAttributes) {

        NpayConfigModel npayConfigModel = new NpayConfigModel();
        npayConfigModel.setNpayConfigId(deleteId);

        Map map = (Map) npayConfigDao.procNpayConfig(npayConfigModel, session.getAttribute("userName").toString(), "d")
                .get(0);

        redirectAttributes.addFlashAttribute("dbResponse", map);

        return "redirect:../npayConfig/view";
    }

    @RequestMapping(value = "/activate", method = RequestMethod.POST)
    @ResponseBody
    public String delete(HttpSession session, @RequestParam("configId") String configId, HttpServletResponse response) throws Exception{

        NpayConfigModel npayConfigModel = new NpayConfigModel();
        npayConfigModel.setActive("N");
        Map map = (Map) npayConfigDao.procNpayConfig(npayConfigModel, session.getAttribute("userName").toString(), "e").get(0);

        npayConfigModel.setNpayConfigId(configId);
        npayConfigModel.setActive("Y");
        map = (Map) npayConfigDao.procNpayConfig(npayConfigModel, session.getAttribute("userName").toString(), "e").get(0);

        String json = new Gson().toJson(map);
        return json;
    }



}
