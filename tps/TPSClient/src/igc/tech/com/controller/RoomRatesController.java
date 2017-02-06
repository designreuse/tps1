package igc.tech.com.controller;


import igc.tech.com.dao.RoomDetailDao;
import igc.tech.com.mapper.RoomDetailMapper;
import igc.tech.com.model.RoomDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/roomRate")
class RoomRatesController {

    @Autowired
    RoomDetailDao roomDetailDao;



    @RequestMapping(value = "view/{hotelDetailId}", method = RequestMethod.GET)
    public String viewRoom(Model model, @PathVariable("hotelDetailId") String hotelDetailId, HttpSession session, RedirectAttributes redirectAttributes) {
        RoomDetailModel roomDetailModel = new RoomDetailModel();
        roomDetailModel.setHotelDetailId(hotelDetailId);
        List<RoomDetailModel> roomDetailModelList = new RoomDetailMapper().mapList(roomDetailDao.procRoomDetail(roomDetailModel,null,"s"));
        model.addAttribute("roomDetailList", roomDetailModelList);

       model.addAttribute("base", "roomDetail");
        return "roomDetail";

    }






}
