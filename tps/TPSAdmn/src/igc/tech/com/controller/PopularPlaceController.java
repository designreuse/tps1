package igc.tech.com.controller;


import igc.tech.com.dao.PopularPlaceDao;
import igc.tech.com.mapper.PopularPlaceMapper;
import igc.tech.com.model.PopularPlaceModel;
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
@RequestMapping(value = "/popularPlace")
public class PopularPlaceController {

    @Autowired
    PopularPlaceDao popularPlaceDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<PopularPlaceModel> list = new PopularPlaceMapper().mapList(popularPlaceDao.procPopularPlace(null, null, null, null, "a"));


        model.addAttribute("popularPlaceList", list);
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }
        return "popularPlace";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("mode", "add");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPopularPlace(Model model, PopularPlaceModel popularPlaceModel, HttpSession session, RedirectAttributes redirectAttributes) {

        Map map = (Map) popularPlaceDao.procPopularPlace(null, popularPlaceModel.getPlace(), popularPlaceModel.getType(), session.getAttribute("userName")
                .toString(), "i").get
                (0);

        redirectAttributes.addFlashAttribute("dbResponse", map);
        redirectAttributes.addFlashAttribute("mode", "add");

        return "redirect:../popularPlace/add";

    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String popularPlaceID) {

        PopularPlaceModel popularPlaceModel = new PopularPlaceMapper().mapRow((Map) popularPlaceDao.procPopularPlace(popularPlaceID, null, null, null, "s").get(0));
        model.addAttribute("mode", "edit");
        model.addAttribute("popularPlaceMap", popularPlaceModel);
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, PopularPlaceModel popularPlaceModel, HttpSession session, RedirectAttributes redirectAttributes) {

        System.out.println(popularPlaceModel.toString());

        Map map = (Map) popularPlaceDao.procPopularPlace(popularPlaceModel.getPopularPlaceId(),
                popularPlaceModel.getPlace(), popularPlaceModel.getType(), session.getAttribute
                        ("userName").toString(), "u").get(0);

        redirectAttributes.addFlashAttribute("dbResponse", map);

        return "redirect:../popularPlace/view";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("popularPlaceId") String popularPlaceId, HttpSession session, RedirectAttributes redirectAttributes) {


        Map map = (Map) popularPlaceDao.procPopularPlace(popularPlaceId, null, null,  session.getAttribute("userName").toString(), "d")
                .get(0);

        redirectAttributes.addFlashAttribute("dbResponse", map);

        return "redirect:../popularPlace/view";
    }


}
