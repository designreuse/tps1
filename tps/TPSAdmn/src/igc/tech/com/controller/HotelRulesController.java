package igc.tech.com.controller;


import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.dao.HotelRulesDao;
import igc.tech.com.dao.PopularPlaceDao;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.HotelRulesMapper;
import igc.tech.com.model.HotelDetailModel;
import igc.tech.com.model.HotelRulesModel;
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
@RequestMapping(value = "/hotelRules")
public class HotelRulesController {

    @Autowired
    HotelRulesDao hotelRulesDao;

    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    PopularPlaceDao popularPlaceDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        /*List<HotelRulesModel> list = new HotelRulesMapper().mapList(hotelRulesDao.procHotelRules(null, null, null, null,null,null, "a"));
        model.addAttribute("hotelRulesList", list);*/

        List<HotelDetailModel> hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(null, null, null, null, null, null, null, null, null, null, null, null, null, null, "a"));
        model.addAttribute("hotelList", hotelDetailModelList);

        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }
        return "hotelRules";

    }


    @RequestMapping(value = "/add/{hotelId}", method = RequestMethod.GET)
    public String add1(Model model, @PathVariable("hotelId") String hotelId, HttpSession session) {

       /* List<HotelDetailModel> hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(null, null,null, null, null, null, null, null, null, null, null, null, null, null, "a"));
        model.addAttribute("hotelList", hotelDetailModelList);*/

        List<HotelRulesModel> hotelRulesModelList = new HotelRulesMapper().mapList(hotelRulesDao.procHotelRules(null, null, hotelId, null, null, "b"));
        model.addAttribute("hotelRulesList", hotelRulesModelList);

        Map map = (Map) hotelDetailDao.procHotelDetail(hotelId,null,null,null,null,null,null,null,null,null,null,null,null,null,"s").get(0);
//        model.addAttribute("list", "popularPlace");
        model.addAttribute("hotelName",map.get("hotel_name"));
        model.addAttribute("hotelDetailId", hotelId);
        model.addAttribute("mode", "update");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String addHotelRules(Model model, String[] rulesId, String[] hotelRulesId, String[] active, String hotelDetailId, HttpSession session, RedirectAttributes redirectAttributes) {

        Map map = new HashMap();
        if (Arrays.asList(hotelRulesId).contains("")) {
            for (int i = 0; i < hotelRulesId.length; i++) {
                /*check rules already inserted into hotel_rules table or not---- if not then insert into hotel_rules*/
                List<Map> list = hotelRulesDao.procHotelRules(null, rulesId[i], hotelDetailId, null, null, "s");

                if (list.isEmpty()) {
                    System.out.println("insert popular place into nearest place");
                    map = (Map) hotelRulesDao.procHotelRules(null, rulesId[i], hotelDetailId, "N", session.getAttribute("userName").toString(), "i").get(0);
                }

            }
        }

        /*set active to 'N' in hotel_rules whose hotel_detail_id is hotelDetailId*/

        map = (Map) hotelRulesDao.procHotelRules(null, null, hotelDetailId, "N", session.getAttribute("userName").toString().toString(), "u").get(0);

        /*update active to 'Y' whose populare_place_id and hotel_detail_id as specified*/

        for (int i = 0; i < active.length; i++) {
            /*in active array the value is populare_place_id*/

            map = (Map) hotelRulesDao.procHotelRules(null, active[i], hotelDetailId, "Y", session.getAttribute("userName").toString(), "u").get(0);
            System.out.println(map);
        }

        redirectAttributes.addFlashAttribute("dbResponse", map);

        return "redirect:add/" + hotelDetailId;

    }


   /* @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String hotelRulesID) {

        List<HotelDetailModel> hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(null, null,null, null, null, null, null, null, null, null, null, null, null, null, "a"));
        model.addAttribute("hotelList", hotelDetailModelList);

        List<PopularPlaceModel> popularPlaceModelList = new PopularPlaceMapper().mapList(popularPlaceDao.procPopularPlace(null, null, null, null, "a"));
        model.addAttribute("popularPlaceList", popularPlaceModelList);

        HotelRulesModel hotelRulesModel = new HotelRulesMapper().mapRow((Map) hotelRulesDao.procHotelRules(hotelRulesID, null, null, null, null, "s").get(0));
        model.addAttribute("mode", "edit");
        model.addAttribute("hotelRulesMap", hotelRulesModel);
        model.addAttribute("noView", "noView");
        return getAll(model);

    }*/


    /*@RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, HotelRulesModel hotelRulesModel, HttpSession session) {

        System.out.println(hotelRulesModel.toString());

        Map map = (Map) hotelRulesDao.procHotelRules(hotelRulesModel.getHotelRulesId(),
                hotelRulesModel.getHotelDetailId(), hotelRulesModel.getPopularPlaceId(), hotelRulesModel.getDistance(), session.getAttribute
                        ("userName").toString(), "u").get(0);

        model.addAttribute("dbResponse", map);

        return "redirect:../hotelRules/view";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("hotelRulesId") String hotelRulesId, HttpSession session) {


        Map map = (Map) hotelRulesDao.procHotelRules(hotelRulesId, null, null, null, session.getAttribute("userName").toString(), "d")
                .get(0);

        model.addAttribute("dbResponse", map);

        return "redirect:../hotelRules/view";
    }*/


}
