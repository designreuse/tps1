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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/packageLocation")
public class PackageLocationController {

    @Autowired
    PackageInfoDao packageInfoDao;

    @Autowired
    PackageItineraryDao packageItineraryDao;

    @Autowired
    RegionDao regionDao;


    @Autowired
    AreaDao areaDao;

    @Autowired
    PackageLocationDao packageLocationDao;


    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {


        List<PackageInfoModel> list = new PackageInfoMapper().mapList(packageInfoDao.
                procPackageInfo(null, null, null, null, null, null, null, null, "a"));

        model.addAttribute("packageInfoList", list);
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }


        return "packageLocation";

    }


    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/packageInfo", method = RequestMethod.POST)
    public String getPackItineraryByPackInfoId(Model model,
                                               @RequestParam("packageInfoId") String packageInfoId,
                                               HttpSession session) {
        System.out.println();

        List<PackageItineraryModel> list = new PackageItineraryMapper().mapList(packageItineraryDao.
                procPackageItinerary(null, packageInfoId, null, null, null, null, "s"));


        session.setAttribute("packageInfoId", packageInfoId);

//		model.addAttribute("packageInfoId",packageInfoId);

        model.addAttribute("packageItineraryList", list);

        model.addAttribute("itineraryView", true);

        model.addAttribute("listView", "listView");
        model.addAttribute("noView", "noView");

        return getAll(model);

    }


    @RequestMapping(value = "/add/{packageItineraryId}", method = RequestMethod.GET)
    public String add(Model model,
                      @PathVariable("packageItineraryId") String packageItineraryId,
                      HttpSession session) {

        model.addAttribute("locationView", true);

//		session.setAttribute("packageItineraryId",packageItineraryId);


        PackageItineraryModel packageItineraryModel = new PackageItineraryMapper().mapRow((Map) packageItineraryDao
                .procPackageItinerary(packageItineraryId, null, null, null, null, null, "s").get(0));

        model.addAttribute("packageItineraryMap", packageItineraryModel);


       // List<AreaModel> list = new AreaMapper().mapList(areaDao.procArea(null, null, null, null, null, "a"));



        List<AreaModel> list = new AreaMapper().mapList(packageLocationDao.procPackageLocation(null, null,
                packageItineraryId, null, null, "r"));

        model.addAttribute("regionList", list);

        return getPackItineraryByPackInfoId(model, session.getAttribute("packageInfoId").toString(), session);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model,
                      PackageLocationModel packageLocationModel,
                      HttpSession session) {


        System.out.println("-------------------------------------------------------");


        System.out.println(packageLocationModel.toString());

        System.out.println("-------------------------------------------------------");



        Map map = (Map) packageLocationDao.procPackageLocation(null, packageLocationModel.getAreaId(), packageLocationModel.getPackageItineraryId(),
                null, session.getAttribute("userName").toString(), "i").get(0);

        model.addAttribute("dbResponse", map);

        System.out.println(packageLocationModel.toString());


        return getPackItineraryByPackInfoId(model, session.getAttribute("packageInfoId").toString(), session);

    }


    @RequestMapping(value = "/detail/{packageItineraryId}", method = RequestMethod.GET)
    public String detail(Model model,
                         @PathVariable("packageItineraryId") String packageItineraryId,
                         HttpSession session) {

        model.addAttribute("detailView", true);

//		session.setAttribute("packageItineraryId",packageItineraryId);

        System.out.println();
        PackageItineraryModel packageItineraryModel = new PackageItineraryMapper().mapRow((Map) packageItineraryDao
                .procPackageItinerary(packageItineraryId, null, null, null, null, null, "s").get(0));

        model.addAttribute("packageItineraryMap", packageItineraryModel);


        List<PackageLocationModel> list = new PackageLocationMappper().mapList(packageLocationDao.procPackageLocation
                (null, null, packageItineraryId, null, null, "s"));


        model.addAttribute("packageLocationList", list);

        return getPackItineraryByPackInfoId(model, session.getAttribute("packageInfoId").toString(), session);

    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("id") String packageLocationId, HttpSession session) {

        Map map = (Map) packageLocationDao.procPackageLocation(packageLocationId, null, null, null, session.getAttribute
                ("userName").toString(), "d").get(0);

        model.addAttribute("dbResponse", map);

        return getPackItineraryByPackInfoId(model, session.getAttribute("packageInfoId").toString(), session);
    }


}
