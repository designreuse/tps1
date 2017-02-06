package igc.tech.com.controller;


import igc.tech.com.dao.*;
import igc.tech.com.mapper.*;
import igc.tech.com.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
@RequestMapping(value = "/roomDetail")
class RoomDetailController {

    @Autowired
    RoomDetailDao roomDetailDao;

    @Autowired
    RoomTypeDao roomTypeDao;

    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    BedTypeDao bedTypeDao;

    @Autowired
    PushContentDataDao pushContentDataDao;

    @Autowired
    TempContentDataDao tempContentDataDao;

    @Autowired
    CurrencyDao currencyDao;

    @Autowired
    RoomRateDao roomRateDao;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String addHotelActivity(Model model, RoomDetailModel roomDetailModel,String step,String[] currencyId, String[] rate, String[] adultRate, String[] childRate, HttpSession session, RedirectAttributes redirectAttributes) {

        roomDetailModel.setRate(null);
        roomDetailModel.setAdultRate(null);
        roomDetailModel.setChildRate(null);
        Map map = new HashMap();
        if(roomDetailModel.getCustomName().isEmpty()){
            roomDetailModel.setCustomName(null);
        }


        System.out.println(roomDetailModel);
        TempContentDataModel tempContentDataModel = new TempContentDataModel();
        tempContentDataModel.setType("room_detail");
        tempContentDataModel.setPushContentDataId(session.getAttribute("pushContentDataId").toString());
        String customName = roomDetailModel.getCustomName();
        roomDetailModel.setCustomName(null);

        if(roomDetailModel.getRoomDetailId().isEmpty()){
            /*insert*/
            roomDetailModel.setRoomDetailId(null);
            map=(Map) roomDetailDao.procRoomDetail(roomDetailModel,session.getAttribute("userName").toString(),"i").get(0);
            roomDetailModel.setRoomDetailId(map.get("room_detail_id").toString());

        }else{
            /*update*/
            map=(Map) roomDetailDao.procRoomDetail(roomDetailModel,session.getAttribute("userName").toString(),"u").get(0);

        }
        RoomRateModel roomRateModel = new RoomRateModel();
        roomRateModel.setRoomDetailId(roomDetailModel.getRoomDetailId());
        for(int i=0;i<rate.length;i++){
           roomRateModel.setCurrencyId(currencyId[i]);
           roomRateModel.setRate(rate[i]);
           roomRateModel.setChildRate(childRate[i]);
           roomRateModel.setAdultRate(adultRate[i]);
            roomRateDao.procRoomRate(roomRateModel, session.getAttribute("userName").toString(), "u");
        }
        if(!customName.isEmpty()){
            tempContentDataModel.setRefId(roomDetailModel.getRoomDetailId());
            tempContentDataModel.setField("custom_name");
            tempContentDataModel.setContentData(customName);
            tempContentDataDao.procTempContentData(tempContentDataModel, session.getAttribute("userName").toString(), "u");
        }

        redirectAttributes.addFlashAttribute("step",Integer.parseInt(step)+1);
        redirectAttributes.addFlashAttribute("response", map);
        if(session.getAttribute("token")==null){
            return "redirect:/roomDetail/view";
        }

        return "redirect:../register/roomAmenity/" + session.getAttribute("token");

    }

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String viewRoom(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        String hotelDetailId = session.getAttribute("hotelDetailId").toString();
        RoomDetailModel roomDetailModel = new RoomDetailModel();
        roomDetailModel.setHotelDetailId(hotelDetailId);
        List<RoomDetailModel> roomDetailModelList = new RoomDetailMapper().mapList(roomDetailDao.procRoomDetail(roomDetailModel,null,"s"));
        model.addAttribute("roomDetailList", roomDetailModelList);

        int allocateRoom=0;
        for(RoomDetailModel roomDetailModel1: roomDetailModelList){
            allocateRoom=allocateRoom+Integer.parseInt(roomDetailModel1.getRoomsProvided());
        }

        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setHotelDetailId(hotelDetailId);

        hotelDetailModel = new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailModel,null,"s").get(0));
        int totalRooms = Integer.parseInt(hotelDetailModel.getTotalRoom());

        if(totalRooms-allocateRoom>0){
            model.addAttribute("availRoom",totalRooms-allocateRoom);
        }else if(totalRooms-allocateRoom==0){
            model.addAttribute("availRoom", 0);
        }else{
            System.out.println("error");
        }

        List<BedTypeModel> bedTypeModelList = new BedTypeMapper().mapList(bedTypeDao.procBedType(new BedTypeModel(),null,"a"));
        model.addAttribute("bedTypeList", bedTypeModelList);
        model.addAttribute("step",3);
       model.addAttribute("base", "roomDetail");
        if(session.getAttribute("token")==null){
            return "adminTemplate";
        }else{

            return "joinTemplate";
        }


    }

    @RequestMapping(value = "addRoom", method = RequestMethod.GET)
    public String addNew(Model model, HttpSession session, String step, RedirectAttributes redirectAttributes) {

        RoomDetailModel roomDetailModel = new RoomDetailModel();
        redirectAttributes.addFlashAttribute("roomDetailMap", roomDetailModel);
        List<RoomTypeModel> roomTypeModelList = new RoomTypeMapper().mapList(roomTypeDao.procRoomType(new RoomTypeModel(), null, "p"));
        redirectAttributes.addFlashAttribute("parentRoomTypeList", roomTypeModelList);

        roomTypeModelList = new RoomTypeMapper().mapList(roomTypeDao.procRoomType(new RoomTypeModel(), null, "c"));
        redirectAttributes.addFlashAttribute("roomTypeList", roomTypeModelList);
        if(session.getAttribute("token")==null){
            return "redirect:/roomDetail/view";
        }
        redirectAttributes.addFlashAttribute("step",3);


        return "redirect:/register/roomDetail/"+ session.getAttribute("token");
    }

    @RequestMapping(value = "edit/{roomDetailId}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("roomDetailId") String roomDetailId,
                         HttpSession session, RedirectAttributes redirectAttributes) {

        RoomDetailModel roomDetailModel = new RoomDetailModel();
        roomDetailModel.setRoomDetailId(roomDetailId);
        roomDetailModel = new RoomDetailMapper().mapRow((Map) roomDetailDao.procRoomDetail(roomDetailModel,null,"s").get(0)) ;
        System.out.println("roomDetial"+roomDetailModel);
        redirectAttributes.addFlashAttribute("roomDetailMap", roomDetailModel);

        List<CurrencyModel> currencyModelList = new CurrencyMapper().mapList(currencyDao.procCurrency(new CurrencyModel(), null, "get_active_currency"));
        redirectAttributes.addFlashAttribute("currencyList", currencyModelList);

        RoomRateModel roomRateModel = new RoomRateModel();
        roomRateModel.setRoomDetailId(roomDetailId);
        List<RoomRateModel> roomRateModelList = new RoomRateMapper().mapList(roomRateDao.procRoomRate(roomRateModel,null,"s"));
        redirectAttributes.addFlashAttribute("roomRateList", roomRateModelList);

            List<RoomTypeModel> roomTypeModelList = new RoomTypeMapper().mapList(roomTypeDao.procRoomType(new RoomTypeModel(), null, "p"));
            redirectAttributes.addFlashAttribute("parentRoomTypeList", roomTypeModelList);

            roomTypeModelList = new RoomTypeMapper().mapList(roomTypeDao.procRoomType(new RoomTypeModel(), null, "c"));
            redirectAttributes.addFlashAttribute("roomTypeList", roomTypeModelList);
        if(session.getAttribute("token")==null){
            return "redirect:/roomDetail/view";
        }
        redirectAttributes.addFlashAttribute("step",3);
        return "redirect:/register/roomDetail/"+ session.getAttribute("token");
    }

    @RequestMapping(value = "delete/{roomDetailId}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable("roomDetailId") String roomDetailId, String step,
                       HttpSession session, RedirectAttributes redirectAttributes) {

        RoomDetailModel roomDetailModel = new RoomDetailModel();
        roomDetailModel.setRoomDetailId(roomDetailId);
        Map map = (Map) roomDetailDao.procRoomDetail(roomDetailModel,null,"d").get(0) ;

        redirectAttributes.addFlashAttribute("response", map);
        if(session.getAttribute("token")==null){

            return "redirect:/roomDetail/view";
        }
        redirectAttributes.addFlashAttribute("step",3);
        return "redirect:../register/roomDetail/"+ session.getAttribute("token");
    }

    @RequestMapping(value = "roomRates/{hotelDetailId}", method = RequestMethod.GET)
    public String roomRateView(Model model,@PathVariable("hotelDetailId") String hotelDetailId, HttpSession session, RedirectAttributes redirectAttributes) {
        RoomDetailModel roomDetailModel = new RoomDetailModel();
        roomDetailModel.setHotelDetailId(hotelDetailId);
        List<RoomDetailModel> roomDetailModelList = new RoomDetailMapper().mapList(roomDetailDao.procRoomDetail(roomDetailModel,null,"s"));
        model.addAttribute("roomDetailList", roomDetailModelList);

        model.addAttribute("base", "roomDetail");
        return "roomRates";

    }



}
