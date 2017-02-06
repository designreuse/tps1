package igc.tech.com.controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import igc.tech.com.dao.*;
import igc.tech.com.mapper.HotelActivityMapper;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.HotelFeatureMapper;
import igc.tech.com.mapper.RoomDetailMapper;
import igc.tech.com.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
@RequestMapping(value = "/hotelFeature")
class HotelFeatureController {

    @Autowired
    HotelFeatureDao hotelFeatureDao;

    @Autowired
    HotelActivityDao hotelActivityDao;

    @Autowired
    TokenDao tokenDao;

    @Autowired
    HotelDetailDao hotelDetailDao;

    HashMap<String, String[]> siteContent = new HashMap<String, String[]>();

   /* @RequestMapping(value = "token/{token}", method = RequestMethod.GET)
    public String tokenUpdate(Model model, HttpSession session, @PathVariable("token") String token){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getName().equals("register")){

            TokenModel tokenModel = new TokenModel();
            tokenModel.setToken(session.getAttribute("token").toString());
            List<Map> list = tokenDao.procToken(tokenModel, null, "s");
            if(list.isEmpty()){
                Map map = list.get(0);
                String tokenId = map.get("token_id").toString();
                HotelDetailModel hotelDetailModel = new HotelDetailModel();
                hotelDetailModel.setTokenId(tokenId);
                HotelDetailModel hotelDetailModel1 = new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailModel, null, "s").get(0));
                session.setAttribute("hotelDetailId", hotelDetailModel1.getHotelDetailId());
                return "redirect:/register";
            }
            System.out.println(list);
            return view(model, session);
        }else{
            return "redirect:/test/addHotel/"+token;
        }
    }*/

    @RequestMapping(value ="/view", method = RequestMethod.GET)
    public String view(Model model, HttpSession session){
        String hotelDetailId = session.getAttribute("hotelDetailId").toString();
        HotelFeatureModel hotelFeatureModel = new HotelFeatureModel();
        hotelFeatureModel.setHotelDetailId(hotelDetailId);
        List list = hotelFeatureDao.procHotelFeature(hotelFeatureModel,null,"s");
        if(!list.isEmpty()){
            hotelFeatureModel= new HotelFeatureMapper().mapRow((Map) list.get(0));
        }

        HotelActivityModel hotelActivityModel = new HotelActivityModel();
        hotelActivityModel.setHotelDetailId(hotelDetailId);
        List<HotelActivityModel> hotelActivityModelList = new HotelActivityMapper().mapList(hotelActivityDao.procHotelActivity(hotelActivityModel, null, "b"));
        System.out.println(hotelActivityModelList);
        model.addAttribute("hotelActivityList", hotelActivityModelList);

        /*siteContent.put("css", new String[]{"bootstrap-multiselect.css","clockpicker/clockpicker.css"});
        siteContent.put("js", new String[]{"bootstrap-multiselect.js","clockpicker/clockpicker.js"});*/
        siteContent.put("css", new String[]{"dateTimePicker/bootstrap-datetimepicker.min.css"});
        siteContent.put("js", new String[]{"fullcalendar/moment.min.js", "dateTimePicker/bootstrap-datetimepicker.min.js"});
        model.addAttribute("siteContent", siteContent);

        model.addAttribute("hotelFeatureMap", hotelFeatureModel);
        model.addAttribute("base", "hotelFeature");
        model.addAttribute("step","2");

        if(session.getAttribute("token")!=null){

            return "joinTemplate";
        }

        return "adminTemplate";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model, HotelFeatureModel hotelFeatureModel, String[] activityId, String[] hotelActivityId, String[] type, String[] active, String step, HttpSession session, RedirectAttributes redirectAttributes) {

        System.out.println(hotelFeatureModel.toString());
        hotelFeatureModel.setActive(null);
        if(hotelFeatureModel.getHotelFeatureId().isEmpty()){
            hotelFeatureModel.setHotelFeatureId(null);
        }
        List<Map> list = hotelFeatureDao.procHotelFeature(hotelFeatureModel,null,"s");

        if(list.isEmpty()){

            Map map = (Map) hotelFeatureDao.procHotelFeature(hotelFeatureModel,
                    session.getAttribute("userName").toString(),
                    "i").get(0);
            redirectAttributes.addFlashAttribute("response", map);
        }else{
            Map map = (Map) hotelFeatureDao.procHotelFeature(hotelFeatureModel,
                    session.getAttribute("userName").toString(),
                    "u").get(0);


        }


        Map map = new HashMap();
        HotelActivityModel hotelActivityModel = new HotelActivityModel();
        if (Arrays.asList(hotelActivityId).contains("")) {
            for (int i = 0; i < hotelActivityId.length; i++) {
                /*check activity already inserted into hotel_activity table or not---- if not then insert into hotel_activity*/
                hotelActivityModel.setActivityId(activityId[i]);
                hotelActivityModel.setHotelDetailId(hotelFeatureModel.getHotelDetailId());
                list = hotelActivityDao.procHotelActivity(hotelActivityModel, null,"s");
//                        (hotelActivityModel, null, "s");

                if (list.isEmpty()) {
                    hotelActivityModel.setActivityId(activityId[i]);
                    hotelActivityModel.setHotelDetailId(hotelFeatureModel.getHotelDetailId());
                    map = (Map) hotelActivityDao.procHotelActivity(hotelActivityModel, session.getAttribute("userName").toString(), "i").get(0);
                }

            }
        }

        /*set active to 'N' in hotel_facility whose hotel_detail_id is hotelDetailId*/
        hotelActivityModel.setHotelDetailId(hotelFeatureModel.getHotelDetailId());
        hotelActivityModel.setActive("N");

        map = (Map) hotelActivityDao.procHotelActivity(hotelActivityModel, session.getAttribute("userName").toString(), "u").get(0);

        /*update active to 'Y' whose populare_place_id and hotel_detail_id as specified*/

        for (int i = 0; i < active.length; i++) {
            /*in active array the value is populare_place_id*/

            hotelActivityModel.setActivityId(active[i]);
            hotelActivityModel.setHotelDetailId(hotelFeatureModel.getHotelDetailId());
            hotelActivityModel.setActive("Y");
            if(!type[i].isEmpty()){
                hotelActivityModel.setType(type[i]);
            }else{
                hotelActivityModel.setType("N");
            }
            map = (Map) hotelActivityDao.procHotelActivity(hotelActivityModel, session.getAttribute("userName").toString(), "u").get(0);
            System.out.println(map);
        }

        redirectAttributes.addFlashAttribute("response", map);
        if(session.getAttribute("token")==null){

            return "redirect:../hotelFeature/view";
        }

        redirectAttributes.addFlashAttribute("step",Integer.parseInt(step)+1);

        return "redirect:../register/roomDetail/"+session.getAttribute("token");

    }


    /*@RequestMapping(value = "roomAmenity/update", method = RequestMethod.POST)
    public String edit(Model model, RoomAmenityModel roomAmenityModel1, ExtraBedModel extraBedModel, String hotelDetailId, String step, HttpSession session, RedirectAttributes redirectAttributes) {

        if(extraBedModel.getExtraBedId().isEmpty()){
            *//*insert data*//*
            extraBedModel.setExtraBedId(null);
            extraBedDao.procExtraBed(extraBedModel,session.getAttribute("userName").toString(),"i");
        }else{
            *//*update datta*//*
            extraBedDao.procExtraBed(extraBedModel,session.getAttribute("userName").toString(),"u");
        }


        RoomDetailModel roomDetailModel = new RoomDetailModel();
        roomDetailModel.setHotelDetailId(hotelDetailId);

        List<RoomDetailModel> roomDetailModelList = new RoomDetailMapper().mapList(roomDetailDao.procRoomDetail(roomDetailModel,null,"s"));

        for(RoomDetailModel roomDetailModel1: roomDetailModelList){
            RoomAmenityModel roomAmenityModel = new RoomAmenityModel();
            roomAmenityModel.setRoomDetailId(roomDetailModel1.getRoomDetailId());
            roomAmenityModel.setActive("N");
            roomAmenityDao.procRoomAmenity(roomAmenityModel,session.getAttribute("userName").toString(),"u");
        }

        List<RoomAmenityModel> roomAmenityModelList = roomAmenityModel1.getRoomAmenityModels();

        List list = new ArrayList();
        for(RoomAmenityModel roomAmenityModel: roomAmenityModelList){

            if(roomAmenityModel.getActive()==null)
                continue;

            roomAmenityModel.setRoomAmenityId(null);

            System.out.println("roomLenght "+ roomAmenityModel.getRoomDetailIds().length);
            for(int i=0 ; i< roomAmenityModel.getRoomDetailIds().length; i++){
//                RoomAmenityModel roomAmenityModel2 = new RoomAmenityModel();

                roomAmenityModel.setRoomDetailId(roomAmenityModel.getRoomDetailIds()[i]);
                roomAmenityModel.setActive(null);
                list = roomAmenityDao.procRoomAmenity(roomAmenityModel, null, "s");

                if(list.isEmpty()){
                    *//*insert into roomAmenity*//*
                    roomAmenityModel.setRoomAmenityId(null);
                    roomAmenityModel.setActive("Y");
                    Map map = (Map) roomAmenityDao.procRoomAmenity(roomAmenityModel,session.getAttribute("userName").toString(),"i").get(0);
                }else{
                    *//*update row*//*
                    roomAmenityModel.setActive("Y");

                    Map map = (Map) roomAmenityDao.procRoomAmenity(roomAmenityModel,session.getAttribute("userName").toString(),"u").get(0);
                }
            }


        }
        redirectAttributes.addFlashAttribute("step",Integer.parseInt(step)+1);

        return "redirect:/addHotel/"+ session.getAttribute("token");
    }*/


}
