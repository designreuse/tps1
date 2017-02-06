package igc.tech.com.controller;


import com.sun.org.apache.xpath.internal.SourceTree;
import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.dao.NearestAreaDao;
import igc.tech.com.dao.PopularPlaceDao;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.NearestAreaMapper;
import igc.tech.com.mapper.PopularPlaceMapper;
import igc.tech.com.model.HotelDetailModel;
import igc.tech.com.model.NearestAreaModel;
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
import javax.ws.rs.PathParam;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/nearestArea")
public class NearestAreaController {

    @Autowired
    NearestAreaDao nearestAreaDao;

    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    PopularPlaceDao popularPlaceDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        /*List<NearestAreaModel> list = new NearestAreaMapper().mapList(nearestAreaDao.procNearestArea(null, null, null, null,null,null, "a"));
        model.addAttribute("nearestAreaList", list);*/

        List<HotelDetailModel> hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(null, null,null, null, null, null, null, null, null, null, null, null, null, null, "a"));
        model.addAttribute("hotelList", hotelDetailModelList);

        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }
        return "nearestArea";

    }

    @RequestMapping(value = "/viewNearestArea", method = RequestMethod.POST)
    public String add(Model model, @RequestParam("hotelDetailId") String hotelId) {

        List<NearestAreaModel> list = new NearestAreaMapper().mapList(nearestAreaDao.procNearestArea(null, hotelId, null, null,"Y",null, "s"));
        model.addAttribute("nearestAreaList", list);

        model.addAttribute("mode", "viewNearestArea");
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("noView", "noView");
        return getAll(model);

    }

    @RequestMapping(value = "/add/{hotelId}", method = RequestMethod.GET)
    public String add1(Model model, @PathVariable("hotelId") String hotelId, HttpSession session) {

       /* List<HotelDetailModel> hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(null, null,null, null, null, null, null, null, null, null, null, null, null, null, "a"));
        model.addAttribute("hotelList", hotelDetailModelList);*/

        List<NearestAreaModel> nearestAreaModelList = new NearestAreaMapper().mapList(nearestAreaDao.procNearestArea(null, hotelId, null, null,null,null, "b"));
        model.addAttribute("nearestPlaceList", nearestAreaModelList);
        System.out.println("near "+ nearestAreaModelList);

//        model.addAttribute("list", "popularPlace");
        model.addAttribute("hotelDetailId", hotelId);
        model.addAttribute("mode", "update");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String addNearestArea(Model model, String[] distance, String[] nearestPlaceId, String[] popularPlaceId, String[] active,String hotelDetailId, HttpSession session, RedirectAttributes redirectAttributes) {


        Map map = new HashMap();
        if(Arrays.asList(nearestPlaceId).contains("")){
            for(int i=0;i<nearestPlaceId.length;i++){
                List<Map> list=  nearestAreaDao.procNearestArea(null,hotelDetailId,popularPlaceId[i],null,null,null,"s");
                if(list.isEmpty()) {
                    System.out.println("insert popular place into nearest place");
                    map = (Map) nearestAreaDao.procNearestArea(null, hotelDetailId, popularPlaceId[i], null, "N", session.getAttribute("userName").toString(), "i").get(0);
                }

            }
        }else if(nearestPlaceId.length>popularPlaceId.length){
            System.out.println("error");
        }

        /*set active to 'N' in nearest_area whose hotel_detail_id is hotelDetailId*/

        map= (Map) nearestAreaDao.procNearestArea(null,hotelDetailId,null,null,"N", session.getAttribute("userName").toString().toString(),"u").get(0);

        /*update active to 'Y' whose populare_place_id and hotel_detail_id as specified*/

        for(int i=0;i<active.length;i++){
            /*in active array the value is populare_place_id*/
           map = (Map) nearestAreaDao.procNearestArea(null,hotelDetailId,active[i], null,"Y", session.getAttribute("userName").toString(),"u").get(0);
        }

        redirectAttributes.addFlashAttribute("dbResponse", map);

return "redirect:add/"+hotelDetailId;

    }





}
