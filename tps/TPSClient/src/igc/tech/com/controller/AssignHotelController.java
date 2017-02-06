package igc.tech.com.controller;


import com.google.gson.Gson;
import igc.tech.com.dao.*;
import igc.tech.com.mapper.AddressMapper;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.UserDetailMapper;
import igc.tech.com.model.*;
import igc.tech.com.utility.EmailApi;
import igc.tech.com.utility.GenerateHash;
import igc.tech.com.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
@RequestMapping(value = "/assignHotel")
class AssignHotelController {

    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    UserDetailDao userDetailDao;

    HashMap<String, String[]> siteContent = new HashMap<String, String[]>();

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String assignProperty(Model model) throws Exception {

        List<UserDetailModel> userDetailModelList = new UserDetailMapper().mapList(userDetailDao.procUserDetail(new UserDetailModel(),null,"h"));
        model.addAttribute("userDetaiList", userDetailModelList);

        model.addAttribute("base", "assignHotel");

        siteContent.put("css", new String[]{"select2/select2.min.css"});
        siteContent.put("js", new String[]{"select2/select2.full.min.js"});
        model.addAttribute("siteContent", siteContent);

        /*List<HotelDetailModel> hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(new HotelDetailModel(), null, "n"));
        model.addAttribute("unassignHotelDetailList", hotelDetailModelList);

        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setUserDetailId(session.getAttribute("userDetailId").toString());
        hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(hotelDetailModel,null,"s"));
        model.addAttribute("assignHotelDetailList", hotelDetailModelList);*/

        return "assignHotel";
    }

    @RequestMapping(value = "/assignPropertyList", method = RequestMethod.POST)
    public String assignPropertyList(HttpSession session, RedirectAttributes redirectAttributes, String userDetailId) throws Exception {

       /* List<UserDetailModel> userDetailModelList = new UserDetailMapper().mapList(userDetailDao.procUserDetail(new UserDetailModel(),null,"h"));
        model.addAttribute("userDetaiList", userDetailModelList);*/

        List<HotelDetailModel> hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(new HotelDetailModel(), null, "n"));
        redirectAttributes.addFlashAttribute("unassignHotelDetailList", hotelDetailModelList);

        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setUserDetailId(userDetailId);
        hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(hotelDetailModel,null,"s"));
        redirectAttributes.addFlashAttribute("assignHotelDetailList", hotelDetailModelList);

        redirectAttributes.addFlashAttribute("userDetailId", userDetailId);

        return "redirect:../assignHotel/view";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String assignProperty(HttpSession session, RedirectAttributes redirectAttributes, String userDetailId, String[] hotelDetailList) throws Exception {

        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setUserDetailId(userDetailId);

        Map map = new HashMap();

        for(int i = 0;i<hotelDetailList.length;i++){
            hotelDetailModel.setHotelDetailId(hotelDetailList[i]);
            map = (Map) hotelDetailDao.procHotelDetail(hotelDetailModel, session.getAttribute("userName").toString(), "u").get(0);
        }

        redirectAttributes.addFlashAttribute("response", map);
        assignPropertyList(session, redirectAttributes, userDetailId);
        return "redirect:../assignHotel/view";
    }
}
