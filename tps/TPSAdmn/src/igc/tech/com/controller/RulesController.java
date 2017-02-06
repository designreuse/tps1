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

        List<RulesModel> list = new RulesMapper().mapList(rulesDao.procRules(null, null, null, null, "a"));


        model.addAttribute("rulesList", list);
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }
        return "rules";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("mode", "add");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addRules(Model model, RulesModel rulesModel, HttpSession session, RedirectAttributes redirectAttributes) {


        Map map = (Map) rulesDao.procRules(null, rulesModel.getRulesDesc(), rulesModel.getType(), session.getAttribute("userName")
                .toString(), "i").get
                (0);

        redirectAttributes.addFlashAttribute("dbResponse", map);
        redirectAttributes.addFlashAttribute("mode", "add");

        return "redirect:../rules/view";

    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String rulesID) {

        RulesModel rulesModel = new RulesMapper().mapRow((Map) rulesDao.procRules(rulesID, null, null, null, "s").get(0));
        model.addAttribute("mode", "edit");
        model.addAttribute("rulesMap", rulesModel);
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, RulesModel rulesModel, HttpSession session, RedirectAttributes redirectAttributes) {


        Map map = (Map) rulesDao.procRules(rulesModel.getRulesId(),
                rulesModel.getRulesDesc(), rulesModel.getType(), session.getAttribute
                        ("userName").toString(), "u").get(0);

        redirectAttributes.addFlashAttribute("dbResponse", map);

        return "redirect:../rules/view";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("rulesId") String rulesId, HttpSession session, RedirectAttributes redirectAttributes) {


        Map map = (Map) rulesDao.procRules(rulesId, null, null, session.getAttribute("userName").toString(), "d")
                .get(0);

        redirectAttributes.addFlashAttribute("dbResponse", map);

        return "redirect:../rules/view";
    }


}
