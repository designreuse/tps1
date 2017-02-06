package igc.tech.com.controller;


import igc.tech.com.dao.RulesDao;
import igc.tech.com.mapper.RulesMapper;
import igc.tech.com.model.RulesModel;
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
@RequestMapping(value = "/rules")
public class RulesController {

    @Autowired
    RulesDao rulesDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<RulesModel> list = new RulesMapper().mapList(rulesDao.procRules(new RulesModel(), null, "a"));


        model.addAttribute("rulesList", list);
        model.addAttribute("base", "rules");
        model.addAttribute("title", "Rules");
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }
        return "rules";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("mode", "update");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }





    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String rulesID) {

        RulesModel rulesModel1 = new RulesModel();
        rulesModel1.setRulesId(rulesID);
        RulesModel rulesModel = new RulesMapper().mapRow((Map) rulesDao.procRules(rulesModel1, null, "s").get(0));
        model.addAttribute("mode", "update");
        model.addAttribute("rulesMap", rulesModel);
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String edit(Model model, RulesModel rulesModel, HttpSession session, RedirectAttributes redirectAttributes) {

        if(rulesModel.getRulesId().isEmpty()){
            rulesModel.setRulesId(null);
            Map map = (Map) rulesDao.procRules(rulesModel,session.getAttribute("userName").toString(),"i").get(0);
            model.addAttribute("response",map);
        }else{
            Map map = (Map) rulesDao.procRules(rulesModel,session.getAttribute("userName").toString(),"u").get(0);
            model.addAttribute("response",map);
        }

        return "redirect:../rules/view";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("deleteId") String deleteId, HttpSession session, RedirectAttributes redirectAttributes) {

        RulesModel rulesModel = new RulesModel();
        rulesModel.setRulesId(deleteId);

        Map map = (Map) rulesDao.procRules(rulesModel, session.getAttribute("userName").toString(), "d")
                .get(0);

        redirectAttributes.addFlashAttribute("dbResponse", map);

        return "redirect:../rules/view";
    }


}
