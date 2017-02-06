package igc.tech.com.controller;


import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.dao.HotelRulesDao;
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



    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model, HttpSession session) {

        String hotelId = session.getAttribute("hotelDetailId").toString();
        HotelRulesModel hotelRulesModel = new HotelRulesModel();
        hotelRulesModel.setHotelDetailId(hotelId);
        List<HotelRulesModel> hotelRulesModelList = new HotelRulesMapper().mapList(hotelRulesDao.procHotelRules(hotelRulesModel, null, "b"));
        model.addAttribute("hotelRulesList", hotelRulesModelList);

        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setHotelDetailId(hotelId);
        Map map = (Map) hotelDetailDao.procHotelDetail(hotelDetailModel,null,"s").get(0);
//        model.addAttribute("list", "popularPlace");
        model.addAttribute("hotelName",map.get("hotel_name"));
        model.addAttribute("hotelDetailId", hotelId);
        model.addAttribute("mode", "update");
        model.addAttribute("base", "hotelRules");
        return "hotelRules";

    }


   /* @RequestMapping(value = "/add/{hotelId}", method = RequestMethod.GET)
    public String add1(Model model, @PathVariable("hotelId") String hotelId, HttpSession session) {

       *//* List<HotelDetailModel> hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(null, null,null, null, null, null, null, null, null, null, null, null, null, null, "a"));
        model.addAttribute("hotelList", hotelDetailModelList);*//*

        HotelRulesModel hotelRulesModel = new HotelRulesModel();
        hotelRulesModel.setHotelDetailId(hotelId);
        List<HotelRulesModel> hotelRulesModelList = new HotelRulesMapper().mapList(hotelRulesDao.procHotelRules(hotelRulesModel, null, "b"));
        model.addAttribute("hotelRulesList", hotelRulesModelList);

        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setHotelDetailId(hotelId);
        Map map = (Map) hotelDetailDao.procHotelDetail(hotelDetailModel,null,"s").get(0);
//        model.addAttribute("list", "popularPlace");
        model.addAttribute("hotelName",map.get("hotel_name"));
        model.addAttribute("hotelDetailId", hotelId);
        model.addAttribute("mode", "update");
        model.addAttribute("noView", "noView");
        return getAll(model, session);

    }*/

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String addHotelRules(Model model, String[] rulesId, String[] hotelRulesId, String[] active, String hotelDetailId, HttpSession session, RedirectAttributes redirectAttributes) {

        Map map = new HashMap();
        if (Arrays.asList(hotelRulesId).contains("")) {
            for (int i = 0; i < hotelRulesId.length; i++) {
                HotelRulesModel hotelRulesModel = new HotelRulesModel();
                hotelRulesModel.setRulesId(rulesId[i]);
                hotelRulesModel.setHotelDetailId(hotelDetailId);
                /*check rules already inserted into hotel_rules table or not---- if not then insert into hotel_rules*/
                List<Map> list = hotelRulesDao.procHotelRules(hotelRulesModel, null, "s");

                if (list.isEmpty()) {
                    hotelRulesModel.setActive("N");
                    System.out.println("insert popular place into nearest place");
                    map = (Map) hotelRulesDao.procHotelRules(hotelRulesModel, session.getAttribute("userName").toString(), "i").get(0);
                }

            }
        }

        /*set active to 'N' in hotel_rules whose hotel_detail_id is hotelDetailId*/
        HotelRulesModel hotelRulesModel = new HotelRulesModel();
        hotelRulesModel.setHotelDetailId(hotelDetailId);
        hotelRulesModel.setActive("N");
        map = (Map) hotelRulesDao.procHotelRules(hotelRulesModel, session.getAttribute("userName").toString(), "u").get(0);

        /*update active to 'Y' whose populare_place_id and hotel_detail_id as specified*/
        System.out.println(active);
        if(active!=null){
            for (int i = 0; i < active.length; i++) {
            /*in active array the value is populare_place_id*/
                hotelRulesModel.setRulesId(active[i]);
                hotelRulesModel.setActive("Y");

                map = (Map) hotelRulesDao.procHotelRules(hotelRulesModel, session.getAttribute("userName").toString(), "u").get(0);
                System.out.println(map);
            }
        }


        redirectAttributes.addFlashAttribute("dbResponse", map);

        return "redirect:view";

    }





}
