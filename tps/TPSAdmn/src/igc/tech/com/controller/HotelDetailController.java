package igc.tech.com.controller;


import igc.tech.com.dao.AreaDao;
import igc.tech.com.dao.ClientDetailDao;
import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.dao.RegionDao;
import igc.tech.com.mapper.*;
import igc.tech.com.model.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/hotelDetail")
class HotelDetailController {

    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    RegionDao regionDao;

    @Autowired
    ClientDetailDao clientDetailDao;

    @Autowired
    AreaDao areaDao;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<HotelDetailModel> list = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, "a"));


        model.addAttribute("hotelDetailList", list);
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }


        return "hotelDetail";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        List<RegionModel> list = new RegionMapper().mapList(regionDao.procRegion(null, null, null, null, "a"));


        List<ClientDetailModel> listclient = new
                ClientDetailMapper().
                mapList(clientDetailDao.procClientDetail(null,
                        null, null, null, null,
                        null, null, null, null, null, null, "a"));

        List<AreaModel> areaList = new AreaMapper().mapList(areaDao.procArea(null, null, null, null,
                null, "a"));

        model.addAttribute("AreaList", areaList);
        model.addAttribute("clientDetailList", listclient);
        model.addAttribute("regionList", list);
        model.addAttribute("noView", "noView");
        model.addAttribute("mode", "add");

        return getAll(model);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model, HotelDetailModel hotelDetailModel, HttpSession session) {

             Map map = (Map) hotelDetailDao.procHotelDetail(null,
                hotelDetailModel.getHotelName(),
                hotelDetailModel.getHotelPhNo1(),
                hotelDetailModel.getHotelPhNo2(),
                hotelDetailModel.getHotelPhNo3(),
                hotelDetailModel.getHotelAddress(),
                hotelDetailModel.getHotelEmailId(),
                hotelDetailModel.getPersonalDetail(),
                hotelDetailModel.getPersonalPhNo(),
                hotelDetailModel.getPersonalEmailId(),
                hotelDetailModel.getAreaId(),
                hotelDetailModel.getClientDetailId(),
                hotelDetailModel.getUrl(),
                session.getAttribute("userName").toString(),
                "i").get(0);

        model.addAttribute("dbResponse", map);

        return add(model);

    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model,
                       @PathVariable("id") String hotelDetailId) {

        HotelDetailModel hotelDetailModel = new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailId, null, null, null, null, null, null, null, null,
                null, null, null, null, null, "s").get(0));

        model.addAttribute("hotelDetailMap", hotelDetailModel);

        List<RegionModel> list = new RegionMapper().mapList(regionDao.procRegion(null, null, null, null, "a"));

        List<ClientDetailModel> listclient = new
                ClientDetailMapper().
                mapList(clientDetailDao.procClientDetail(null,
                        null, null, null, null,
                        null, null, null, null, null, null, "a"));

        List<AreaModel> areaList = new AreaMapper().mapList(areaDao.procArea(null, null, null, null,
                null, "a"));

        model.addAttribute("AreaList", areaList);

        model.addAttribute("clientDetailList", listclient);
        model.addAttribute("regionList", list);
        model.addAttribute("mode", "edit");
        model.addAttribute("noView", "noView");

        return getAll(model);

    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, HotelDetailModel hotelDetailModel, HttpSession session) {

        System.out.println("=================================");

        System.out.println(hotelDetailModel.toString());
        System.out.println(session.getAttribute("userName").toString());

        System.out.println("=================================");
        Map map = (Map) hotelDetailDao.procHotelDetail(hotelDetailModel.getHotelDetailId(),
                hotelDetailModel.getHotelName(),
                hotelDetailModel.getHotelPhNo1(),
                hotelDetailModel.getHotelPhNo2(),
                hotelDetailModel.getHotelPhNo3(),
                hotelDetailModel.getHotelAddress(),
                hotelDetailModel.getHotelEmailId(),
                hotelDetailModel.getPersonalDetail(),
                hotelDetailModel.getPersonalPhNo(),
                hotelDetailModel.getPersonalEmailId(),
                hotelDetailModel.getAreaId(),
                hotelDetailModel.getClientDetailId(),
                hotelDetailModel.getUrl(),
                session.getAttribute("userName").toString(),
                "u").get(0);

        model.addAttribute("dbResponse", map);

        return getAll(model);

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("id") String hotelDetailId, HttpSession session) {

        Map map = (Map) hotelDetailDao.procHotelDetail(hotelDetailId, null, null, null, null, null, null, null, null,
                null, null, null, null, session.getAttribute("userName").toString(), "d").get(0);


        model.addAttribute("dbResponse", map);

        return getAll(model);
    }


    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(Model model,
                         @PathVariable("id") String hotelDetailId) {

        HotelDetailModel hotelDetailModel = new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailId, null, null, null, null, null, null, null, null,
                null, null, null, null, null, "s").get(0));

        model.addAttribute("hotelDetailMap", hotelDetailModel);

        List<RegionModel> list = new RegionMapper().mapList(regionDao.procRegion(null, null, null, null, "a"));

        List<ClientDetailModel> listclient = new
                ClientDetailMapper().
                mapList(clientDetailDao.procClientDetail(null,
                        null, null, null, null,
                        null, null, null, null, null, null, "a"));


        List<AreaModel> areaList = new AreaMapper().mapList(areaDao.procArea(null, null, null, null,
                null, "a"));

        model.addAttribute("AreaList", areaList);
        model.addAttribute("clientDetailList", listclient);
        model.addAttribute("regionList", list);
        model.addAttribute("mode", "detail");
        model.addAttribute("noView", "noView");

        return getAll(model);

    }

}
