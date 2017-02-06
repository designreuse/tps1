package igc.tech.com.controller;

import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.dao.RoomFacilityDao;
import igc.tech.com.dao.RoomTypeDao;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.RoomFacilityMapper;
import igc.tech.com.mapper.RoomFacilityMapper;
import igc.tech.com.mapper.RoomTypeMapper;
import igc.tech.com.model.HotelDetailModel;
import igc.tech.com.model.RoomFacilityModel;
import igc.tech.com.model.RoomFacilityModel;
import igc.tech.com.model.RoomTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.w3c.dom.ls.LSInput;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/roomFacility")

public class RoomFacilityController {


    @Autowired
    RoomFacilityDao roomFacilityDao;

    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    RoomTypeDao roomTypeDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        /*List<RoomFacilityModel> list = new RoomFacilityMapper().mapList(roomFacilityDao.procRoomFacility(null, null, null, null,null,null, "a"));
        model.addAttribute("roomFacilityList", list);*/

        List<HotelDetailModel> hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(null, null, null, null, null, null, null, null, null, null, null, null, null, null, "a"));
        model.addAttribute("hotelDetailList", hotelDetailModelList);

        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }
        return "roomFacility";

    }


    @RequestMapping(value = "/roomList", method = RequestMethod.POST)
    public String getAllList(Model model, RoomTypeModel roomTypeModel, HttpSession session) {

        if (roomTypeModel.getHotelDetailId().equals("") || roomTypeModel.getHotelDetailId().equals(null)) {

            return "error";
        }

        List<RoomTypeModel> list = new RoomTypeMapper().
                mapList(roomTypeDao.procRoomType(null, roomTypeModel.getHotelDetailId(), null, null, null, null, null, null, null, null,
                        null, "s"));
        session.setAttribute("hotelIdForRoom", roomTypeModel.getHotelDetailId());
        model.addAttribute("IndividualList", list);
        model.addAttribute("listView", "listView");
        model.addAttribute("noView", "noView");


        return getAll(model);

    }

    @RequestMapping(value = "/add/{roomTypeId}", method = RequestMethod.GET)
    public String add1(Model model, @PathVariable("roomTypeId") String roomTypeId, HttpSession session) {

       /* List<HotelDetailModel> hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(null, null,null, null, null, null, null, null, null, null, null, null, null, null, "a"));
        model.addAttribute("hotelList", hotelDetailModelList);*/

        List<RoomFacilityModel> roomFacilityModelList = new RoomFacilityMapper().mapList(roomFacilityDao.procRoomFacility(null,roomTypeId,null,null,null,"b"));
        model.addAttribute("roomFacilityList", roomFacilityModelList);

        Map map = (Map) roomTypeDao.procRoomType(roomTypeId,null,null,null,null,null,null,null,null,null,null,"s").get(0);

        model.addAttribute("hotelName",map.get("hotel_name"));
        model.addAttribute("hotelDetailId", map.get("hotel_detail_id"));
        model.addAttribute("roomDesc", map.get("room_desc"));
//        model.addAttribute("list", "popularPlace");
        model.addAttribute("roomTypeId", roomTypeId);
        model.addAttribute("mode", "update");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String addRoomFacility(Model model, String[] facilityId, String[] roomFacilityId, String[] active, String roomTypeId, HttpSession session, RedirectAttributes redirectAttributes) {

        Map map = new HashMap();
        if (Arrays.asList(roomFacilityId).contains("")) {
            for (int i = 0; i < roomFacilityId.length; i++) {
                /*check facility already inserted into hotel_facility table or not---- if not then insert into hotel_facility*/
                List<Map> list = roomFacilityDao.procRoomFacility(null, roomTypeId, facilityId[i],null,null,"s");

                if (list.isEmpty()) {
                    System.out.println("insert popular place into nearest place");
                    map = (Map) roomFacilityDao.procRoomFacility(null, roomTypeId, facilityId[i], "N", session.getAttribute("userName").toString(), "i").get(0);
                }

            }
        }

        /*set active to 'N' in hotel_facility whose hotel_detail_id is hotelDetailId*/

        map = (Map) roomFacilityDao.procRoomFacility(null, roomTypeId, null, "N", session.getAttribute("userName").toString().toString(), "u").get(0);

        /*update active to 'Y' whose populare_place_id and hotel_detail_id as specified*/

        for (int i = 0; i < active.length; i++) {
            /*in active array the value is populare_place_id*/
            System.out.println(active.length);
            System.out.println(active[i]);


            map = (Map) roomFacilityDao.procRoomFacility(null, roomTypeId, active[i], "Y", session.getAttribute("userName").toString(), "u").get(0);
            System.out.println(map);
        }

        redirectAttributes.addFlashAttribute("dbResponse", map);

        return "redirect:add/" + roomTypeId;

    }


}
