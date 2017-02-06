package igc.tech.com.controller;

import com.sun.deploy.panel.ITreeNode;
import com.sun.org.apache.bcel.internal.generic.DMUL;
import com.sun.org.apache.xpath.internal.SourceTree;
import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.dao.RoomFacilityAccessDao;
import igc.tech.com.dao.RoomFacilityDao;
import igc.tech.com.dao.RoomTypeDao;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.RoomFacilityAccessMapper;
import igc.tech.com.mapper.RoomFacilityMapper;
import igc.tech.com.mapper.RoomTypeMapper;
import igc.tech.com.model.HotelDetailModel;
import igc.tech.com.model.RoomFacilityAccessModel;
import igc.tech.com.model.RoomFacilityModel;
import igc.tech.com.model.RoomTypeModel;
import org.apache.taglibs.standard.tag.common.xml.ForEachTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.SourceExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.applet.Main;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/roomFacilityAccess")

public class RoomFacilityAccessController {


    @Autowired
    RoomFacilityDao roomDao;

    @Autowired
    RoomFacilityAccessDao roomFacilityAccessDao;

    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    RoomTypeDao roomTypeDao;


    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {


        List<HotelDetailModel> Hotellist = new HotelDetailMapper().mapList(hotelDetailDao.
                procHotelDetail(null,  null, null, null, null, null, null, null,
                        null, null, null,null,null, null, "a"));

        model.addAttribute("hotelDetailList", Hotellist);


        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }
        return "roomFacilityAccess";

    }


    @RequestMapping(value = "/facilityList", method = RequestMethod.POST)
    public String getAllList(Model model, RoomTypeModel roomTypeModel, HttpSession session) {


        List<RoomTypeModel> list = new RoomTypeMapper().
                mapList(roomTypeDao.procRoomType(null, null, roomTypeModel.getHotelDetailId(), null,null,null, null,null,null,null,null,
                        "s"));

        model.addAttribute("IndividualList", list);
        model.addAttribute("listView", "listView");
        model.addAttribute("noView", "noView");

        System.out.println();
        return getAll(model);

    }


    @RequestMapping(value = "accessList/{id}/{hid}", method = RequestMethod.GET)
    public String getAllList(Model model, @PathVariable("id") String roomTypeId, @PathVariable("hid") String
            hotelDetailId, HttpSession session) {


/*        List<RoomFacilityModel> list = new RoomFacilityMapper().
                mapList(roomDao.procRoomFacility(null, null, hotelDetailId, null, "s"));*/

        session.setAttribute("tempHotelDetailId", hotelDetailId);


        List<Map> listFacilityAccess = roomDao.procRoomFacility(null, null, hotelDetailId, null, null, "s");


        List<Map> Mainlist = new ArrayList<>();

        for (Map m : listFacilityAccess) {

            List<Map> lst = roomFacilityAccessDao.procRoomFacilityAccess(null, roomTypeId
                    .toString(), null, null, "s");


            if (!lst.isEmpty()) {
                for (Map map : lst) {

             /*       System.out.println
             ("==========================================================================*");*/
               /*     System.out.println(map);
                    System.out.println(map.get("room_facility_id").toString());
                    System.out.println(m.get("room_facility_id").toString());
*/


               /*     System.out.println
               ("==========================================================================*");*/


                    if (map.get("room_facility_id").toString().equals(m.get("room_facility_id").toString())) {
                        m.put("checked", true);
                        System.out.println("checked");

                    }

                    System.out.println("this is map" + m);
                }


            }

            Mainlist.add(m);
        }


        model.addAttribute("selectedList", Mainlist);
        model.addAttribute("roomTypeId", roomTypeId);
/*        model.addAttribute("accessList", list);*/
        model.addAttribute("accessListView", "accessListView");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveList(Model model, @RequestParam("roomTypeId") String roomTypeId,
                           @RequestParam("checkedRows") String[] checkedRows, HttpSession session) {
        Map dmap=null;
        boolean flag=false;

        for (int i = 0; i < checkedRows.length; i++) {

            if (!checkedRows[i].equals("off")) {

                List<Map> list1 = roomFacilityAccessDao.procRoomFacilityAccess(null, roomTypeId, checkedRows[i],
                        null, "s");

                if (list1.isEmpty()) {
                    dmap = (Map) roomFacilityAccessDao.procRoomFacilityAccess(null, roomTypeId, checkedRows[i],
                            session.getAttribute("userName").toString(), "i").get(0);
                }
            }


        }




        List<Map> listFacilityAccess =roomFacilityAccessDao.procRoomFacilityAccess(null, null, null,
                null, "a");

        for (Map m : listFacilityAccess) {

            for (int i = 0; i < checkedRows.length; i++) {

                if (!checkedRows[i].equals("off")) {

                    if (checkedRows[i].equals(m.get("room_facility_id").toString())) {

                        flag = true;
                        break;
                    }
                }

            }

            if (!flag) {

                // List<Map>
                // list1=payTypeMerchantAccessDao.procPayTypeMerchantAccess(null,
                // m.get("ID").toString(), merchantDetId, null, "s");

                dmap = (Map) roomFacilityAccessDao.procRoomFacilityAccess(m.get("room_facility_access_id").toString(),
                        null, null,
                        session.getAttribute("userName").toString(), "d").get(0);


            }

            flag = false;
        }




        model.addAttribute("dbResponse", dmap);

        String tempHotelDetailId = session.getAttribute("tempHotelDetailId").toString();
        session.removeAttribute("tempHotelDetailId");

        return getAllList(model, roomTypeId, tempHotelDetailId, session);

    }


}
