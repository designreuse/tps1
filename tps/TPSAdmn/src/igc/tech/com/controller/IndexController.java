package igc.tech.com.controller;

import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.model.ErrorMessage;

import igc.tech.com.model.HotelDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping(value = "/")
class IndexController {

    @Autowired
    HotelDetailDao hotelDetailDao;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {

        List<HotelDetailModel> list = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, "a"));


        model.addAttribute("hotelDetailList", list);
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }


        return "hotelDetail";


    }


    @RequestMapping(value = "/submenu1", method = RequestMethod.GET)
    public String home1(Model model) {


        return "submenu";

    }


    @RequestMapping(value = "/submenu2", method = RequestMethod.GET)
    public String home2(Model model) {


        return "submenu2";

    }

    @RequestMapping(value = "/submenu3", method = RequestMethod.GET)
    public String home3(Model model) {


        return "submenu3";

    }


    @RequestMapping(value = "/getCheck", method = RequestMethod.GET)
    public String home4(Model model) {


        return "test";

    }

    @RequestMapping(value = "/postCheck", method = RequestMethod.POST)
    public String home5(Model model, /*@ModelAttribute*/ ErrorMessage errorMessage) {
        System.out.println(errorMessage.toString());
        return "test";

    }


}
