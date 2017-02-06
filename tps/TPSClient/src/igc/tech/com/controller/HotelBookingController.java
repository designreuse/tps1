package igc.tech.com.controller;

import com.google.gson.Gson;
import igc.tech.com.dao.HotelBookingDao;
import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.mapper.EasyTreeMapper;
import igc.tech.com.mapper.HotelBookingMappper;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.model.HotelBookingModel;
import igc.tech.com.model.EasyTreeModel;
import igc.tech.com.model.HotelDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ganga on 6/14/2016.
 */

@Controller
@RequestMapping(value = "/hotelBooking")
public class HotelBookingController {

    @Autowired
    HotelBookingDao hotelBookingDao;

    @Autowired
    HotelDetailDao hotelDetailDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(Model model, HttpSession session){
        HotelDetailModel hotelDetailModel = new HotelDetailModel();

        System.out.println(session.getAttribute("roleId"));

        if(session.getAttribute("roleId").toString().equals("2")){
            hotelDetailModel.setUserDetailId(session.getAttribute("userDetailId").toString());
        }


       /* List<HotelDetailModel> hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(hotelDetailModel,null,"s"));
        model.addAttribute("hotelDetailList", hotelDetailModelList);*/

//        hotelDetailModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());
        List<HotelBookingModel> hotelBookingModelList = new HotelBookingMappper().mapList(hotelDetailDao.procHotelDetail(hotelDetailModel,null,"b"));
        model.addAttribute("hotelBookingList", hotelBookingModelList);
        model.addAttribute("base", "hotelBooking");

        return "hotelBooking";
    }

    @RequestMapping(value = "/arrived", method = RequestMethod.POST)
    public String arrived(String invoiceNo, String transactionType, RedirectAttributes redirectAttributes){

        HotelBookingModel hotelBookingModel = new HotelBookingModel();
        hotelBookingModel.setInvoice(invoiceNo);

        if(transactionType.equals("C")){
            Map map = (Map) hotelBookingDao.procHotelBooking(hotelBookingModel,null,"cancel").get(0);

            redirectAttributes.addFlashAttribute("response", map);
        }else if(transactionType.equals("A")){
            Map map = (Map) hotelBookingDao.procHotelBooking(hotelBookingModel,null,"arrive").get(0);

            redirectAttributes.addFlashAttribute("response", map);
        }else if(transactionType.equals("P")){
            Map map = (Map) hotelBookingDao.procHotelBooking(hotelBookingModel,null,"paid_at_hotel").get(0);

            redirectAttributes.addFlashAttribute("response", map);
        }



        return "redirect:../hotelBooking/view";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public String detail(String invoiceNo, RedirectAttributes redirectAttributes){

        HotelBookingModel hotelBookingModel = new HotelBookingModel();
        hotelBookingModel.setInvoice(invoiceNo);
        hotelBookingModel = new HotelBookingMappper().mapRow((Map) hotelBookingDao.procHotelBooking(hotelBookingModel,null,"search_by_invoice").get(0));

        redirectAttributes.addFlashAttribute("hotelBookingMap", hotelBookingModel);
        redirectAttributes.addFlashAttribute("mode","view");


        return "redirect:../hotelBooking/view";
    }

}
