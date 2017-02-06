package igc.tech.com.controller;

import igc.tech.com.dao.BedTypeDao;
import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.dao.RoomCategoryDao;
import igc.tech.com.dao.RoomTypeDao;
import igc.tech.com.mapper.BedTypeMapper;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.RoomCategoryMapper;
import igc.tech.com.mapper.RoomTypeMapper;
import igc.tech.com.model.BedTypeModel;
import igc.tech.com.model.HotelDetailModel;
import igc.tech.com.model.RoomCategoryModel;
import igc.tech.com.model.RoomTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/roomType")
public class RoomTypeController {

    @Autowired
    BedTypeDao bedTypeDao;

    @Autowired
    RoomTypeDao roomTypeDao;

    @Autowired
    private HotelDetailDao hotelDetailDao;

    @Autowired
    RoomCategoryDao roomCategory;




    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        /*List<RoomTypeModel> list = new RoomTypeMapper().mapList(roomTypeDao.procRoomType(null, null, null, null, null, null, null, null,
                null, null,
                null, "a"));*/


        List<HotelDetailModel> HotelList = new HotelDetailMapper().mapList(hotelDetailDao.
                procHotelDetail(null, null, null, null, null, null, null, null, null,
                        null, null,null,null, null, "a"));

        model.addAttribute("hotelDetailList", HotelList);
//        model.addAttribute("bedTypeList", list);
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }

        return "roomType";

    }


    @RequestMapping(value = "/roomList", method = RequestMethod.POST)
    public String getAllList(Model model, RoomTypeModel roomTypeModel, HttpSession session) {


        List<RoomTypeModel> list = new RoomTypeMapper().
                mapList(roomTypeDao.procRoomType(null, roomTypeModel.getHotelDetailId(),null, null, null, null, null, null, null, null,
                        null, "s"));

        model.addAttribute("hotelDetailId", roomTypeModel.getHotelDetailId());
        model.addAttribute("IndividualList", list);
        model.addAttribute("listView", "listView");
        model.addAttribute("noView", "noView");


        return getAll(model);

    }


    @RequestMapping(value = "/add/{hotelDetailId}", method = RequestMethod.GET)
    public String add(Model model,@PathVariable("hotelDetailId") String hotelDetailId) {


       /* List<HotelDetailModel> list = new HotelDetailMapper().
                mapList(hotelDetailDao.procHotelDetail(null, null, null, null, null, null, null, null, null,
                        null, null,null,null, null, "a"));

        System.out.println();
        model.addAttribute("hotelDetailList", list);*/

        List<BedTypeModel> bedTypeModelList = new BedTypeMapper().mapList(bedTypeDao.procBedType(null,null,null,null,"a"));
        model.addAttribute("bedTypeList", bedTypeModelList);

        List<RoomCategoryModel> roomCategoryModelList = new RoomCategoryMapper().mapList(roomCategory.procRoomCategory(null,null,null,"a"));
        model.addAttribute("roomCategoryList", roomCategoryModelList);

        model.addAttribute("mode", "add");
        RoomTypeModel roomTypeModel = new RoomTypeModel();
        roomTypeModel.setHotelDetailId(hotelDetailId);
        model.addAttribute("roomTypeMap", roomTypeModel);

        model.addAttribute("noView", "noView");

        return getAll(model);

    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model, RoomTypeModel roomTypeModel,
                      HttpSession session) {


        Map map = (Map) roomTypeDao.procRoomType(null, roomTypeModel.getHotelDetailId(), roomTypeModel.getRoomCategoryId(),
                roomTypeModel.getBedTypeId(), roomTypeModel.getRoomDesc(), roomTypeModel.getInitialRate(),roomTypeModel.getMaxAdult(),
                roomTypeModel.getMaxChild(), roomTypeModel.getExtraBedCharge(),roomTypeModel.getPush(),session.getAttribute("userName").toString(),"i")
                .get(0);

        /*Map map = (Map) roomTypeDao.procRoomType(null, roomTypeModel.getHotelDetailId(),null,null,roomTypeModel.getRoomDesc(),null, roomTypeModel
                        .getMaxAdult(), roomTypeModel.getMaxChild(),null,
                null, session.getAttribute("userName").toString(), "i")
                .get(0);
*/

        /*List<RoomTypeModel> list = new RoomTypeMapper().
                mapList(roomTypeDao.procRoomType(null, null, roomTypeModel.getHotelDetailId(), null, null, null, null, null, null, null,
                        null,
                        "s"));

        model.addAttribute("IndividualList", list);*/
//        model.addAttribute("listView", "listView");


        model.addAttribute("noView", "noView");
        model.addAttribute("mode", "add");
        model.addAttribute("dbResponse", map);
        return "redirect:add/"+roomTypeModel.getHotelDetailId();

    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model,
                       @PathVariable("id") String roomTypeId) {

        RoomTypeModel roomTypeModel = new RoomTypeMapper().mapRow((Map) roomTypeDao.procRoomType(roomTypeId, null,
                null, null, null, null,null, null, null, null,
                null, "s").get(0));

        model.addAttribute("roomTypeMap", roomTypeModel);

        List<BedTypeModel> bedTypeModelList = new BedTypeMapper().mapList(bedTypeDao.procBedType(null,null,null,null,"a"));
        model.addAttribute("bedTypeList", bedTypeModelList);

        List<RoomCategoryModel> roomCategoryModelList = new RoomCategoryMapper().mapList(roomCategory.procRoomCategory(null,null,null,"a"));
        model.addAttribute("roomCategoryList", roomCategoryModelList);


        /*List<HotelDetailModel> list = new HotelDetailMapper().
                mapList(hotelDetailDao.procHotelDetail(null, null, null, null, null, null, null, null, null,
                     null,null,null, null, null, "a"));

        model.addAttribute("hotelDetailList", list);*/
        model.addAttribute("mode", "edit");
        model.addAttribute("noView", "noView");

        return getAll(model);

    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, RoomTypeModel roomTypeModel, HttpSession session) {


       /* JOptionPane.showMessageDialog(null, roomTypeModel.getMaxAdult());
        JOptionPane.showMessageDialog(null, roomTypeModel.getMaxChild());
        System.out.println(roomTypeModel.toString());

        System.out.println("******************");


        System.out.println(roomTypeModel.getRoomTypeId());
//        System.out.println(roomTypeModel.getDescription().trim());
        System.out.println(roomTypeModel.getHotelDetailId());
        System.out.println(roomTypeModel.getMaxAdult());
        System.out.println(roomTypeModel.getMaxChild());*/
//        System.out.println(roomTypeModel.getRate());




       // System.out.println(roomTypeDao.procRoomType("10","test","1","55","44","33","tilak","u"));

        Map map= (Map)roomTypeDao.procRoomType(roomTypeModel.getRoomTypeId(),
                roomTypeModel.getHotelDetailId(), roomTypeModel.getRoomCategoryId(), roomTypeModel.getBedTypeId(),roomTypeModel.getRoomDesc(),
                roomTypeModel.getInitialRate(),roomTypeModel.getMaxAdult(),roomTypeModel.getMaxChild(), roomTypeModel.getExtraBedCharge(),
                roomTypeModel.getPush(),"tilak",
                "u").get(0);



        model.addAttribute("listView", "listView");
        model.addAttribute("noView", "noView");
//        model.addAttribute("dbResponse", map);

        return "redirect:view";

    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model, @RequestParam("id") String roomTypeId, @RequestParam("hotelDetailId") String
            hotelDetailId,
                         HttpSession session) {


        Map map = (Map) roomTypeDao.procRoomType(roomTypeId, null,
                hotelDetailId, null, null, null,null, null, null, null, session.getAttribute("userName").toString
                        (), "d").get(0);


        model.addAttribute("dbResponse", map);



        model.addAttribute("listView", "listView");
        model.addAttribute("noView", "noView");

        return "redirect:view";
    }


}
