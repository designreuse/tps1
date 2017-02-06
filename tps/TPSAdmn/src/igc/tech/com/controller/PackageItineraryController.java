package igc.tech.com.controller;


import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.dao.PackageInfoDao;
import igc.tech.com.dao.PackageItineraryDao;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.PackageInfoMapper;
import igc.tech.com.mapper.PackageItineraryMapper;
import igc.tech.com.model.HotelDetailModel;
import igc.tech.com.model.PackageInfoModel;
import igc.tech.com.model.PackageItineraryModel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/packageItinerary")
class PackageItineraryController {


    @Autowired
    PackageItineraryDao packageItineraryDao;


    @Autowired
    PackageInfoDao packageInfoDao;


    @Autowired
    HotelDetailDao hotelDetailDao;


    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<PackageItineraryModel> list = new PackageItineraryMapper().mapList(packageItineraryDao.procPackageItinerary(null, null, null, null, null, null, "a"));


        model.addAttribute("packageItineraryList", list);

        return "packageItinerary";

    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        List<PackageInfoModel> list = new PackageInfoMapper().mapList(packageInfoDao.procPackageInfo(null, null,null, null, null, null, null, null, "a"));

        model.addAttribute("packageInfoList", list);


        List<HotelDetailModel> list1 = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(null, null, null, null,
                null, null, null, null, null, null,
                null, null,null,null, "a"));
        model.addAttribute("hotelDetailList", list1);

        model.addAttribute("mode", "add");

        return getAll(model);

    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model, PackageItineraryModel packageItineraryModel, HttpSession session) {

        Map map = (Map) packageItineraryDao.procPackageItinerary(null, packageItineraryModel.getPackageInfoId(),
                packageItineraryModel.getDay(),
                packageItineraryModel.getDayDetails(),
                packageItineraryModel.getHotelDetailId(),
                session.getAttribute("userName").toString(),
                "i").get(0);


        model.addAttribute("dbResponse", map);

        return add(model);

    }


    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model,
                       @PathVariable("id") String packageItineraryId) {


        PackageItineraryModel packageItineraryModel = new PackageItineraryMapper().mapRow((Map) packageItineraryDao.procPackageItinerary(packageItineraryId, null, null, null, null, null, "s").get(0));

        model.addAttribute("packageItineraryMap", packageItineraryModel);

        List<PackageInfoModel> list = new PackageInfoMapper().mapList(packageInfoDao.procPackageInfo(null,null, null, null, null, null, null, null, "a"));

        model.addAttribute("packageInfoList", list);


        List<HotelDetailModel> list1 = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(null, null, null, null,
                null,  null, null, null, null,
                null, null,null,null, null, "a"));
        model.addAttribute("hotelDetailList", list1);

        model.addAttribute("mode", "edit");

        return getAll(model);

    }


    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, PackageItineraryModel packageItineraryModel, HttpSession session) {


        Map map = (Map) packageItineraryDao.procPackageItinerary(packageItineraryModel.getPackageItineraryId(),
                packageItineraryModel.getPackageInfoId(),
                packageItineraryModel.getDay(),
                packageItineraryModel.getDayDetails(),
                packageItineraryModel.getHotelDetailId(),
                session.getAttribute("userName").toString(),
                "u").get(0);


        model.addAttribute("dbResponse", map);

        return getAll(model);

    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("id") String packageItineraryId, HttpSession session) {

        Map map = (Map) packageItineraryDao.procPackageItinerary(packageItineraryId, null, null, null, null, session.getAttribute("userName").toString(), "d").get(0);


        model.addAttribute("dbResponse", map);

        return getAll(model);
    }


    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(Model model,
                         @PathVariable("id") String packageItineraryId) {

        PackageItineraryModel packageItineraryModel = new PackageItineraryMapper().mapRow((Map) packageItineraryDao.procPackageItinerary(packageItineraryId, null, null, null, null, null, "s").get(0));

        model.addAttribute("packageItineraryMap", packageItineraryModel);

        List<PackageInfoModel> list = new PackageInfoMapper().mapList(packageInfoDao.procPackageInfo(null,null, null, null, null, null, null, null, "a"));

        model.addAttribute("packageInfoList", list);


        List<HotelDetailModel> list1 = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(null, null, null, null,
                null, null, null, null, null,
                null, null, null,null,null, "a"));
        model.addAttribute("hotelDetailList", list1);

        model.addAttribute("mode", "detail");

        return getAll(model);

    }

}
