package igc.tech.com.controller;


import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.dao.HotelFacilityDao;
import igc.tech.com.dao.PopularPlaceDao;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.HotelFacilityMapper;
import igc.tech.com.model.HotelDetailModel;
import igc.tech.com.model.HotelFacilityModel;
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
@RequestMapping(value = "/hotelFacility")
public class HotelFacilityController {

    @Autowired
    HotelFacilityDao hotelFacilityDao;

    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    PopularPlaceDao popularPlaceDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        /*List<HotelFacilityModel> list = new HotelFacilityMapper().mapList(hotelFacilityDao.procHotelFacility(null, null, null, null,null,null, "a"));
        model.addAttribute("hotelFacilityList", list);*/

        List<HotelDetailModel> hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(null, null, null, null, null, null, null, null, null, null, null, null, null, null, "a"));
        model.addAttribute("hotelList", hotelDetailModelList);

        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }
        return "hotelFacility";

    }

    @RequestMapping(value = "/viewHotelFacility", method = RequestMethod.POST)
    public String add(Model model, @RequestParam("hotelDetailId") String hotelId) {

        List<HotelFacilityModel> list = new HotelFacilityMapper().mapList(hotelFacilityDao.procHotelFacility(null, null, hotelId, "Y", null, "s"));
        model.addAttribute("hotelFacilityList", list);

        model.addAttribute("mode", "viewHotelFacility");
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("noView", "noView");
        return getAll(model);

    }

    @RequestMapping(value = "/add/{hotelId}", method = RequestMethod.GET)
    public String add1(Model model, @PathVariable("hotelId") String hotelId, HttpSession session) {

       /* List<HotelDetailModel> hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(null, null,null, null, null, null, null, null, null, null, null, null, null, null, "a"));
        model.addAttribute("hotelList", hotelDetailModelList);*/

        List<HotelFacilityModel> hotelFacilityModelList = new HotelFacilityMapper().mapList(hotelFacilityDao.procHotelFacility(null, null, hotelId, null, null, "b"));
        model.addAttribute("hotelFacilityList", hotelFacilityModelList);

        Map map = (Map) hotelDetailDao.procHotelDetail(hotelId,null,null,null,null,null,null,null,null,null,null,null,null,null,"s").get(0);
//        model.addAttribute("list", "popularPlace");
        model.addAttribute("hotelName",map.get("hotel_name"));
        model.addAttribute("hotelDetailId", hotelId);
        model.addAttribute("mode", "update");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String addHotelFacility(Model model, String[] facilityId, String[] hotelFacilityId, String[] active, String hotelDetailId, HttpSession session, RedirectAttributes redirectAttributes) {

        Map map = new HashMap();
        if (Arrays.asList(hotelFacilityId).contains("")) {
            for (int i = 0; i < hotelFacilityId.length; i++) {
                /*check facility already inserted into hotel_facility table or not---- if not then insert into hotel_facility*/
                List<Map> list = hotelFacilityDao.procHotelFacility(null, facilityId[i], hotelDetailId, null, null, "s");

                if (list.isEmpty()) {
                    System.out.println("insert popular place into nearest place");
                    map = (Map) hotelFacilityDao.procHotelFacility(null, facilityId[i], hotelDetailId, "N", session.getAttribute("userName").toString(), "i").get(0);
                }

            }
        }

        /*set active to 'N' in hotel_facility whose hotel_detail_id is hotelDetailId*/

        map = (Map) hotelFacilityDao.procHotelFacility(null, null, hotelDetailId, "N", session.getAttribute("userName").toString().toString(), "u").get(0);

        /*update active to 'Y' whose populare_place_id and hotel_detail_id as specified*/

        for (int i = 0; i < active.length; i++) {
            /*in active array the value is populare_place_id*/
           System.out.println(active.length);
            System.out.println(active[i]);


            System.out.println("hotelDetailId "+hotelDetailId+" facility id "+ facilityId[i]);
            map = (Map) hotelFacilityDao.procHotelFacility(null, active[i], hotelDetailId, "Y", session.getAttribute("userName").toString(), "u").get(0);
            System.out.println(map);
        }

        redirectAttributes.addFlashAttribute("dbResponse", map);

        return "redirect:add/" + hotelDetailId;

    }


   /* @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String hotelFacilityID) {

        List<HotelDetailModel> hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(null, null,null, null, null, null, null, null, null, null, null, null, null, null, "a"));
        model.addAttribute("hotelList", hotelDetailModelList);

        List<PopularPlaceModel> popularPlaceModelList = new PopularPlaceMapper().mapList(popularPlaceDao.procPopularPlace(null, null, null, null, "a"));
        model.addAttribute("popularPlaceList", popularPlaceModelList);

        HotelFacilityModel hotelFacilityModel = new HotelFacilityMapper().mapRow((Map) hotelFacilityDao.procHotelFacility(hotelFacilityID, null, null, null, null, "s").get(0));
        model.addAttribute("mode", "edit");
        model.addAttribute("hotelFacilityMap", hotelFacilityModel);
        model.addAttribute("noView", "noView");
        return getAll(model);

    }*/


    /*@RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, HotelFacilityModel hotelFacilityModel, HttpSession session) {

        System.out.println(hotelFacilityModel.toString());

        Map map = (Map) hotelFacilityDao.procHotelFacility(hotelFacilityModel.getHotelFacilityId(),
                hotelFacilityModel.getHotelDetailId(), hotelFacilityModel.getPopularPlaceId(), hotelFacilityModel.getDistance(), session.getAttribute
                        ("userName").toString(), "u").get(0);

        model.addAttribute("dbResponse", map);

        return "redirect:../hotelFacility/view";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("hotelFacilityId") String hotelFacilityId, HttpSession session) {


        Map map = (Map) hotelFacilityDao.procHotelFacility(hotelFacilityId, null, null, null, session.getAttribute("userName").toString(), "d")
                .get(0);

        model.addAttribute("dbResponse", map);

        return "redirect:../hotelFacility/view";
    }*/


}
