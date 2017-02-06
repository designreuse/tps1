package igc.tech.com.controller;

import igc.tech.com.dao.OfferDao;
import igc.tech.com.dao.RoomDetailDao;
import igc.tech.com.dao.TempContentDataDao;
import igc.tech.com.mapper.OfferMapper;
import igc.tech.com.mapper.RoomDetailMapper;
import igc.tech.com.model.OfferModel;
import igc.tech.com.model.RoomDetailModel;
import igc.tech.com.model.TempContentDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ganga on 5/20/2016.
 */
@Controller
@RequestMapping(value = "/offer")
public class OfferController {

    @Autowired
    OfferDao offerDao;

    @Autowired
    RoomDetailDao roomDetailDao;

    @Autowired
    TempContentDataDao tempContentDataDao;

    HashMap<String, String[]> siteContent = new HashMap<String, String[]>();

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model, HttpSession session) {

        OfferModel offerModel = new OfferModel();
        offerModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());

        List<OfferModel> offerModelList = new OfferMapper().mapList(offerDao.procOffer(offerModel, null,"h"));
        model.addAttribute("offerList", offerModelList);
        System.out.println(offerModelList);

        model.addAttribute("base", "offer");

       /* siteContent.put("css", new String[]{"datapicker/datepicker3.css"});
//        siteContent.put("css", new String[]{"daterangepicker/daterangepicker-bs3.css"});
//        siteContent.put("css", new String[]{"dateTimePicker/bootstrap-datetimepicker.min.css"});
        siteContent.put("js", new String[]{"fullcalendar/moment.min.js", "datapicker/bootstrap-datepicker.js"});*/
        siteContent.put("css", new String[]{"dateTimePicker/bootstrap-datetimepicker.min.css"});
        siteContent.put("js", new String[]{"fullcalendar/moment.min.js", "dateTimePicker/bootstrap-datetimepicker.min.js"});
//        System.out.println(siteContent);

        /*siteContent.put("css", new String[]{"dateTimePicker/bootstrap-datetimepicker.min.css"});
        siteContent.put("js", new String[]{"dateTimePicker/bootstrap-datetimepicker.min.js"});*/


        model.addAttribute("siteContent", siteContent);

        return "offer";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model, HttpSession session) {

        RoomDetailModel roomDetailModel = new RoomDetailModel();
        roomDetailModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());
        List<RoomDetailModel> roomDetailModelList = new RoomDetailMapper().mapList(roomDetailDao.procRoomDetail(roomDetailModel,null,"s"));
        model.addAttribute("roomDetailList", roomDetailModelList);

        model.addAttribute("base", "offer");
        model.addAttribute("mode", "update");

        return getAll(model,session);
    }

    @RequestMapping(value = "/edit/{offerId}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("offerId") String offerId, HttpSession session) {

        OfferModel offerModel = new OfferModel();
        offerModel.setOfferId(offerId);

        offerModel= new OfferMapper().mapRow((Map) offerDao.procOffer(offerModel, null, "s").get(0));
        model.addAttribute("offerMap", offerModel);
        System.out.println(offerModel);

        RoomDetailModel roomDetailModel = new RoomDetailModel();
        roomDetailModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());
        List<RoomDetailModel> roomDetailModelList = new RoomDetailMapper().mapList(roomDetailDao.procRoomDetail(roomDetailModel,null,"s"));
        model.addAttribute("roomDetailList", roomDetailModelList);

        model.addAttribute("base", "offer");
        model.addAttribute("mode", "update");

        return getAll(model, session);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(HttpSession session, OfferModel offerModel, String type, RedirectAttributes redirectAttributes) {

        System.out.println(type);
        String offerName = offerModel.getOfferName();
        offerModel.setOfferName(null);
        if(type.equals("deal")){

            String dateTime = offerModel.getBookingFrom();
            String date = dateTime.substring(0, dateTime.indexOf(' '));
            offerModel.setBookingTo(date + " "+ offerModel.getBookingTo());
            offerModel.setOfferName(offerName);
        }


        if(offerModel.getOfferId().isEmpty()){
            offerModel.setOfferId(null);
            Map map = (Map) offerDao.procOffer(offerModel,session.getAttribute("userName").toString(), "i").get(0);
            redirectAttributes.addFlashAttribute("response", map);
            offerModel.setOfferId(map.get("offer_id").toString());
        }else{
            Map map = (Map) offerDao.procOffer(offerModel,session.getAttribute("userName").toString(), "u").get(0);
            redirectAttributes.addFlashAttribute("response", map);
        }
        if(!offerName.equals("Last Minute Deal")){
            TempContentDataModel tempContentDataModel = new TempContentDataModel();
            tempContentDataModel.setType("offer");
            tempContentDataModel.setPushContentDataId(session.getAttribute("pushContentDataId").toString());
            tempContentDataModel.setRefId(offerModel.getOfferId());
            tempContentDataModel.setField("offer_name");
            tempContentDataModel.setContentData(offerName);
            tempContentDataDao.procTempContentData(tempContentDataModel, session.getAttribute("userName").toString(), "u");
        }


        return "redirect:view";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(HttpSession session, @RequestParam("deleteId") String deleteId, RedirectAttributes redirectAttributes) {

        OfferModel offerModel = new OfferModel();
        offerModel.setOfferId(deleteId);

        Map map = (Map) offerDao.procOffer(offerModel,session.getAttribute("userName").toString(),"d").get(0);
        redirectAttributes.addFlashAttribute("response", map);

        return "redirect:view";

    }
}
