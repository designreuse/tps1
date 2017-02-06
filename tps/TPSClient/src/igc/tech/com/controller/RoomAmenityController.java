package igc.tech.com.controller;

import com.google.gson.Gson;
import igc.tech.com.dao.*;
import igc.tech.com.mapper.*;
import igc.tech.com.model.*;
import igc.tech.com.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
@Controller
@RequestMapping(value = "/roomAmenity")
public class RoomAmenityController {

    @Autowired
    ExtraBedDao extraBedDao;

    @Autowired
    RoomDetailDao roomDetailDao;

    @Autowired
    RoomAmenityDao roomAmenityDao;

    @Autowired
    HotelActivityDao hotelActivityDao;

    HashMap<String, String[]> siteContent = new HashMap<String, String[]>();



    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String viewRoom(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        String hotelDetailId= session.getAttribute("hotelDetailId").toString();

        /*HotelActivityModel hotelActivityModel = new HotelActivityModel();
        hotelActivityModel.setHotelDetailId(hotelDetailId);
        List<HotelActivityModel> hotelActivityModelList = new HotelActivityMapper().mapList(hotelActivityDao.procHotelActivity(hotelActivityModel, null, "b"));
        System.out.println(hotelActivityModelList);
        model.addAttribute("hotelActivityList", hotelActivityModelList);*/

        RoomAmenityModel roomAmenityModel = new RoomAmenityModel();
        roomAmenityModel.setHotelDetailId(hotelDetailId);
        List<RoomAmenityModel> roomAmenityModelList = new RoomAmenityMapper().mapList(roomAmenityDao.procRoomAmenity(roomAmenityModel, null, "b"));

        RoomDetailModel roomDetailModel = new RoomDetailModel();
        roomDetailModel.setHotelDetailId(hotelDetailId);
        List<RoomDetailModel> roomDetailModelList = new RoomDetailMapper().mapList(roomDetailDao.procRoomDetail(roomDetailModel, null, "s"));
        model.addAttribute("roomDetailList", roomDetailModelList);

        model.addAttribute("roomAmenityList", roomAmenityModelList);

        model.addAttribute("base", "roomAmenity");
        model.addAttribute("step",4);

        siteContent.put("css", new String[]{"bootstrap-multiselect.css"});
        siteContent.put("js", new String[]{"bootstrap-multiselect.js"});


        model.addAttribute("siteContent", siteContent);
        if(session.getAttribute("token")==null){
            return "adminTemplate";
        }else{

            return "joinTemplate";
        }


    }

    /*@RequestMapping(value = "hotel/update", method = RequestMethod.POST)
    public String hotelUpdate(String hotelDetailId, String[] activityId, String[] hotelActivityId, String[] type, String[] active, String step, HttpSession session, RedirectAttributes redirectAttributes) {

        Map map = new HashMap();
        List<Map> list = new ArrayList<>();
        HotelActivityModel hotelActivityModel = new HotelActivityModel();
        if (Arrays.asList(hotelActivityId).contains("")) {
            for (int i = 0; i < hotelActivityId.length; i++) {
                *//*check activity already inserted into hotel_activity table or not---- if not then insert into hotel_activity*//*
                hotelActivityModel.setActivityId(activityId[i]);
                hotelActivityModel.setHotelDetailId(hotelDetailId);
                list = hotelActivityDao.procHotelActivity(hotelActivityModel, null,"s");
//                        (hotelActivityModel, null, "s");

                if (list.isEmpty()) {
                    hotelActivityModel.setActivityId(activityId[i]);
                    hotelActivityModel.setHotelDetailId(hotelDetailId);
                    map = (Map) hotelActivityDao.procHotelActivity(hotelActivityModel, session.getAttribute("userName").toString(), "i").get(0);
                }

            }
        }

        *//*set active to 'N' in hotel_facility whose hotel_detail_id is hotelDetailId*//*
        hotelActivityModel.setHotelDetailId(hotelDetailId);
        hotelActivityModel.setActive("N");

        map = (Map) hotelActivityDao.procHotelActivity(hotelActivityModel, session.getAttribute("userName").toString(), "u").get(0);

        *//*update active to 'Y' whose populare_place_id and hotel_detail_id as specified*//*

        for (int i = 0; i < active.length; i++) {
            *//*in active array the value is populare_place_id*//*

            hotelActivityModel.setActivityId(active[i]);
            hotelActivityModel.setHotelDetailId(hotelDetailId);
            hotelActivityModel.setActive("Y");
            if(!type[i].isEmpty()){
                hotelActivityModel.setType(type[i]);
            }else{
                hotelActivityModel.setType("N");
            }
            map = (Map) hotelActivityDao.procHotelActivity(hotelActivityModel, session.getAttribute("userName").toString(), "u").get(0);
            System.out.println(map);
        }

            return "redirect:/amenity/view/" + session.getAttribute("hotelDetailId");

    }
*/
    @RequestMapping(value = "room/update", method = RequestMethod.POST)
    public String edit(Model model, RoomAmenityModel roomAmenityModel1, ExtraBedModel extraBedModel, String hotelDetailId, String step, HttpSession session, RedirectAttributes redirectAttributes) {
        if (extraBedModel.getExtraBedId() != null) {
            if (extraBedModel.getExtraBedId().isEmpty()) {
            /*insert data*/
                System.out.println("extra bed" + extraBedModel);
                extraBedModel.setExtraBedId(null);
                extraBedDao.procExtraBed(extraBedModel, session.getAttribute("userName").toString(), "i");
            } else {
            /*update datta*/
                extraBedDao.procExtraBed(extraBedModel, session.getAttribute("userName").toString(), "u");
            }
        }

        RoomDetailModel roomDetailModel = new RoomDetailModel();
        roomDetailModel.setHotelDetailId(hotelDetailId);

        List<RoomDetailModel> roomDetailModelList = new RoomDetailMapper().mapList(roomDetailDao.procRoomDetail(roomDetailModel, null, "s"));

        for (RoomDetailModel roomDetailModel1 : roomDetailModelList) {
            RoomAmenityModel roomAmenityModel = new RoomAmenityModel();
            roomAmenityModel.setRoomDetailId(roomDetailModel1.getRoomDetailId());
            roomAmenityModel.setActive("N");
            roomAmenityDao.procRoomAmenity(roomAmenityModel, session.getAttribute("userName").toString(), "u");
        }

        List<RoomAmenityModel> roomAmenityModelList = roomAmenityModel1.getRoomAmenityModels();

        List list = new ArrayList();
        for (RoomAmenityModel roomAmenityModel : roomAmenityModelList) {

            if (roomAmenityModel.getActive() == null)
                continue;

            roomAmenityModel.setRoomAmenityId(null);

            System.out.println("roomLenght " + roomAmenityModel.getRoomDetailIds().length);
            Map map = new HashMap();
            for (int i = 0; i < roomAmenityModel.getRoomDetailIds().length; i++) {
//                RoomAmenityModel roomAmenityModel2 = new RoomAmenityModel();

                roomAmenityModel.setRoomDetailId(roomAmenityModel.getRoomDetailIds()[i]);
                roomAmenityModel.setActive(null);
                list = roomAmenityDao.procRoomAmenity(roomAmenityModel, null, "s");

                if (list.isEmpty()) {
                    /*insert into roomAmenity*/
                    roomAmenityModel.setRoomAmenityId(null);
                    roomAmenityModel.setActive("Y");
                    map = (Map) roomAmenityDao.procRoomAmenity(roomAmenityModel, session.getAttribute("userName").toString(), "i").get(0);
                } else {
                    /*update row*/
                    roomAmenityModel.setActive("Y");

                    map = (Map) roomAmenityDao.procRoomAmenity(roomAmenityModel, session.getAttribute("userName").toString(), "u").get(0);
                }

                redirectAttributes.addFlashAttribute("response", map);
            }


        }
        if (session.getAttribute("token") == null) {
            redirectAttributes.addFlashAttribute("room", true);
            return "redirect:/roomAmenity/view";
        }
        redirectAttributes.addFlashAttribute("step", Integer.parseInt(step) + 1);

        return "redirect:/register/image/" + session.getAttribute("token");
    }


}
