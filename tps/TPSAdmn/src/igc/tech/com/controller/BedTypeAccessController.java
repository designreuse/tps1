package igc.tech.com.controller;

import igc.tech.com.dao.*;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.RoomTypeMapper;
import igc.tech.com.model.HotelDetailModel;
import igc.tech.com.model.RoomTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/bedTypeAccess")

public class BedTypeAccessController {


    @Autowired
    RoomFacilityDao roomDao;

    @Autowired
    RoomFacilityAccessDao roomFacilityAccessDao;

    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    RoomTypeDao roomTypeDao;


    @Autowired
    BedTypeDao bedTypeDao;

    @Autowired
    BedTypeAccessDao bedTypeAccessDao;


    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {


        List<HotelDetailModel> Hotellist = new HotelDetailMapper().mapList(hotelDetailDao.
                procHotelDetail(null, null, null, null, null, null, null, null, null,
                        null,null, null,null,null, "a"));

        model.addAttribute("hotelDetailList", Hotellist);


        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }
        return "bedTypeAccess";

    }


    @RequestMapping(value = "/facilityList", method = RequestMethod.POST)
    public String getAllList(Model model, RoomTypeModel roomTypeModel, HttpSession session) {


        List<RoomTypeModel> list = new RoomTypeMapper().
                mapList(roomTypeDao.procRoomType(null, roomTypeModel.getHotelDetailId(), null,null,null, null, null, null, null, null, null,
                        "s"));

        model.addAttribute("IndividualList", list);
        model.addAttribute("listView", "listView");
        model.addAttribute("noView", "noView");

        System.out.println("");
        return getAll(model);

    }


    @RequestMapping(value = "accessList/{id}/{hid}", method = RequestMethod.GET)
    public String getAllList(Model model, @PathVariable("id") String roomTypeId, @PathVariable("hid") String
            hotelDetailId, HttpSession session) {

        System.out.println();

/*        List<RoomFacilityModel> list = new RoomFacilityMapper().
                mapList(roomDao.procRoomFacility(null, null, hotelDetailId, null, "s"));*/

        session.setAttribute("tempHotelDetailId", hotelDetailId);


        List<Map> listFacilityAccess = bedTypeDao.procBedType(null, null, hotelDetailId, null, "s");


        List<Map> Mainlist = new ArrayList<>();

        for (Map m : listFacilityAccess) {

            List<Map> lst = bedTypeAccessDao.procBedTypeAccess(null, roomTypeId.toString(), null, null, "s");


            if (!lst.isEmpty()) {
                for (Map map : lst) {


                    if (map.get("bed_type_id").toString().equals(m.get("bed_type_id").toString())) {
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
        Map dmap = null;
        boolean flag = false;

        for (int i = 0; i < checkedRows.length; i++) {

            if (!checkedRows[i].equals("off")) {

                List<Map> list1 = bedTypeAccessDao.procBedTypeAccess(null, roomTypeId, checkedRows[i], null, "s");

                if (list1.isEmpty()) {
                    dmap = (Map) bedTypeAccessDao.procBedTypeAccess(null, roomTypeId, checkedRows[i], session
                            .getAttribute("userName").toString(), "i").get(0);
                }
            }


        }


        List<Map> listFacilityAccess = bedTypeAccessDao.procBedTypeAccess(null, null, null, null, "a");

        for (Map m : listFacilityAccess) {

            for (int i = 0; i < checkedRows.length; i++) {

                if (!checkedRows[i].equals("off")) {

                    if (checkedRows[i].equals(m.get("bed_type_id").toString())) {

                        flag = true;
                        break;
                    }
                }

            }

            if (!flag) {

                // List<Map>
                // list1=payTypeMerchantAccessDao.procPayTypeMerchantAccess(null,
                // m.get("ID").toString(), merchantDetId, null, "s");

                dmap = (Map) bedTypeAccessDao.procBedTypeAccess(m.get("bed_type_access_id").toString(),
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
