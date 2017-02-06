package igc.tech.com.controller;

import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.dao.RoomDetailDao;
import igc.tech.com.dao.RoomImportanceDao;
import igc.tech.com.dao.RoomTypeDao;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.RoomDetailMapper;
import igc.tech.com.mapper.RoomImportanceMapper;
import igc.tech.com.mapper.RoomTypeMapper;
import igc.tech.com.model.HotelDetailModel;
import igc.tech.com.model.RoomDetailModel;
import igc.tech.com.model.RoomImportanceModel;
import igc.tech.com.model.RoomTypeModel;
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
@RequestMapping(value = "/roomImportance")

public class RoomImportanceController {


    @Autowired
    RoomImportanceDao roomImportanceDao;

    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    RoomDetailDao roomDetailDao;


    @RequestMapping(value = "/view", method = {RequestMethod.GET, RequestMethod.POST})
    public String getAll(Model model, @RequestParam(value = "roomDetailId", defaultValue = "1")String roomDetailId, HttpSession session) {

        /*List<RoomImportanceModel> list = new RoomImportanceMapper().mapList(roomImportanceDao.procRoomImportance(null, null, null, null,null,null, "a"));
        model.addAttribute("roomImportanceList", list);*/

        if (session.getAttribute("hotelDetailId")==null) {

            return "error";
        }


        RoomDetailModel roomDetailModel = new RoomDetailModel();
        roomDetailModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());
        List<RoomDetailModel> roomDetailModelList = new RoomDetailMapper().mapList(roomDetailDao.procRoomDetail(roomDetailModel,null,"s"));
        model.addAttribute("roomDetailList", roomDetailModelList);

        String mapRoomDetailId = (String) model.asMap().get("roomDetailId");
        if(mapRoomDetailId!=null)
            roomDetailId=mapRoomDetailId;
        model.addAttribute("roomDetailId", roomDetailId);
        model.addAttribute("base", "roomImportance");


        RoomImportanceModel roomImportanceModel = new RoomImportanceModel();
        roomImportanceModel.setRoomDetailId(roomDetailId);
        roomImportanceModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());
        List<RoomImportanceModel> roomImportanceModelList = new RoomImportanceMapper().mapList(roomImportanceDao.procRoomImportance(roomImportanceModel,null,"b"));

        model.addAttribute("roomImportanceList", roomImportanceModelList);

        return "roomImportance";

    }

    @RequestMapping(value = "/customRules", method = {RequestMethod.GET})
    public String addCustomRules(Model model, HttpSession session) {

        /*List<RoomImportanceModel> list = new RoomImportanceMapper().mapList(roomImportanceDao.procRoomImportance(null, null, null, null,null,null, "a"));
        model.addAttribute("roomImportanceList", list);*/

        if (session.getAttribute("hotelDetailId")==null) {

            return "error";
        }


        return "rules";

    }



    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String addRoomImportance(Model model, String[] rulesId, String[] roomImportanceId, String[] active, String roomDetailId, HttpSession session, RedirectAttributes redirectAttributes) {

        Map map = new HashMap();
        if (Arrays.asList(roomImportanceId).contains("")) {
            for (int i = 0; i < roomImportanceId.length; i++) {
                RoomImportanceModel roomImportanceModel = new RoomImportanceModel();
                roomImportanceModel.setRulesId(rulesId[i]);
                roomImportanceModel.setRoomDetailId(roomDetailId);
                /*check rules already inserted into hotel_rules table or not---- if not then insert into hotel_rules*/
                List<Map> list = roomImportanceDao.procRoomImportance(roomImportanceModel, null,"s");

                if (list.isEmpty()) {
                    roomImportanceModel.setActive("N");
                    map = (Map) roomImportanceDao.procRoomImportance(roomImportanceModel, session.getAttribute("userName").toString(), "i").get(0);
                }

            }
        }

        /*set active to 'N' in hotel_rules whose hotel_detail_id is hotelDetailId*/
        RoomImportanceModel roomImportanceModel = new RoomImportanceModel();
        roomImportanceModel.setRoomDetailId(roomDetailId);
        roomImportanceModel.setActive("N");

        map = (Map) roomImportanceDao.procRoomImportance(roomImportanceModel , session.getAttribute("userName").toString().toString(), "u").get(0);

        /*update active to 'Y' whose populare_place_id and hotel_detail_id as specified*/

        if(active!=null){
            for (int i = 0; i < active.length; i++) {
            /*in active array the value is populare_place_id*/
                roomImportanceModel.setRulesId(active[i]);
                roomImportanceModel.setActive("Y");


                map = (Map) roomImportanceDao.procRoomImportance(roomImportanceModel, session.getAttribute("userName").toString(), "u").get(0);
                System.out.println(map);
            }
        }


        redirectAttributes.addFlashAttribute("response", map);
        redirectAttributes.addFlashAttribute("roomDetailId", roomDetailId);

        return "redirect:view";

    }


}
