package igc.tech.com.controller;


import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.dao.HotelRulesDao;
import igc.tech.com.dao.RulesDao;
import igc.tech.com.dao.TempContentDataDao;
import igc.tech.com.mapper.HotelRulesMapper;
import igc.tech.com.mapper.RulesMapper;
import igc.tech.com.model.HotelDetailModel;
import igc.tech.com.model.HotelRulesModel;
import igc.tech.com.model.RulesModel;
import igc.tech.com.model.TempContentDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/customRules")
public class CustomRulesController {

    @Autowired
    HotelRulesDao hotelRulesDao;

    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    RulesDao rulesDao;

    @Autowired
    TempContentDataDao tempContentDataDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model, HttpSession session) {

        RulesModel rulesModel = new RulesModel();
        rulesModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());

        List<RulesModel> rulesModelList = new RulesMapper().mapList(rulesDao.procRules(rulesModel, null, "h"));
        model.addAttribute("rulesList", rulesModelList);

        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }
        model.addAttribute("base", "customRules");
        return "customRules";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model, HttpSession session){
        model.addAttribute("mode", "update");
        model.addAttribute("noView", "noView");
        return  getAll(model, session);
    }

    @RequestMapping(value = "/edit/{rulesId}", method = RequestMethod.GET)
    public String add(Model model,@PathVariable("rulesId") String rulesId, HttpSession session){
        RulesModel rulesModel = new RulesModel();
        rulesModel.setRulesId(rulesId);
        rulesModel = new RulesMapper().mapRow((Map) rulesDao.procRules(rulesModel,null,"h").get(0));
        model.addAttribute("rulesMap", rulesModel);
        model.addAttribute("mode", "update");
        model.addAttribute("noView", "noView");
        return  getAll(model, session);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model, HttpSession session, RulesModel rulesModel){
        rulesModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());
        String rulesDesc = rulesModel.getRulesDesc();
        rulesModel.setRulesDesc(null);


        Map map = new HashMap();
        if(rulesModel.getRulesId().isEmpty()){
            rulesModel.setRulesId(null);
            map = (Map) rulesDao.procRules(rulesModel,session.getAttribute("userName").toString(),"i").get(0);
            model.addAttribute("response",map);
        }else{
            map = (Map) rulesDao.procRules(rulesModel,session.getAttribute("userName").toString(),"u").get(0);
            model.addAttribute("response",map);
        }

        TempContentDataModel tempContentDataModel = new TempContentDataModel();
        tempContentDataModel.setType("rules");
        tempContentDataModel.setPushContentDataId(session.getAttribute("pushContentDataId").toString());
        tempContentDataModel.setRefId(map.get("rules_id").toString());
        tempContentDataModel.setField("rules_desc");
        tempContentDataModel.setContentData(rulesDesc);
        tempContentDataDao.procTempContentData(tempContentDataModel, session.getAttribute("userName").toString(), "u");


        return  "redirect:view";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model, HttpSession session, @RequestParam("deleteId") String deleteId){

        RulesModel rulesModel = new RulesModel();
        rulesModel.setRulesId(deleteId);

        Map map = (Map) rulesDao.procRules(rulesModel,session.getAttribute("userName").toString(),"d").get(0);
        model.addAttribute("response",map);

        return  getAll(model, session);
    }

}
