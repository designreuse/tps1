package igc.tech.com.controller;


import igc.tech.com.dao.ActivityDetailDao;
import igc.tech.com.dao.DayDetailDao;
import igc.tech.com.dao.PackageInfoDao;
import igc.tech.com.dao.PackageItineraryDao;
import igc.tech.com.dao.PackageLocationDao;
import igc.tech.com.dao.RegionDao;
import igc.tech.com.mapper.ActivityDetailMapper;
import igc.tech.com.mapper.DayDetailMapper;
import igc.tech.com.mapper.PackageInfoMapper;
import igc.tech.com.mapper.PackageItineraryMapper;
import igc.tech.com.model.ActivityDetailModel;
import igc.tech.com.model.DayDetailModel;
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
@RequestMapping(value = "/dayDetail")
class DayDetailController {


    @Autowired
    ActivityDetailDao activityDetailDao;

    @Autowired
    DayDetailDao dayDetailDao;

    @Autowired
    PackageInfoDao packageInfoDao;

    @Autowired
    PackageItineraryDao packageItineraryDao;

    @Autowired
    RegionDao regionDao;

    @Autowired
    PackageLocationDao packageLocationDao;


    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {


        List<PackageInfoModel> list = new PackageInfoMapper().mapList(packageInfoDao.procPackageInfo(null,null, null, null, null, null, null, null, "a"));

        model.addAttribute("packageInfoList", list);

        return "dayDetail";

    }


    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/packageInfo", method = RequestMethod.POST)
    public String getPackItineraryByPackInfoId(Model model,
                                               @RequestParam("packageInfoId") String packageInfoId,
                                               HttpSession session) {

        List<PackageItineraryModel> list = new PackageItineraryMapper().mapList(packageItineraryDao.procPackageItinerary(null, packageInfoId, null, null, null, null, "s"));


        session.setAttribute("packageInfoId", packageInfoId);

//		model.addAttribute("packageInfoId",packageInfoId); 

        model.addAttribute("packageItineraryList", list);

        model.addAttribute("itineraryView", true);

        return getAll(model);

    }


    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/add/{packageItineraryId}", method = RequestMethod.GET)
    public String add(Model model,
                      @PathVariable("packageItineraryId") String packageItineraryId,
                      HttpSession session) {

        model.addAttribute("dayDetailView", true);

//		session.setAttribute("packageItineraryId",packageItineraryId); 


        PackageItineraryModel packageItineraryModel = new PackageItineraryMapper().mapRow((Map) packageItineraryDao.procPackageItinerary(packageItineraryId, null, null, null, null, null, "s").get(0));

        model.addAttribute("packageItineraryMap", packageItineraryModel);


        List<ActivityDetailModel> list = new ActivityDetailMapper().mapList(dayDetailDao.procDayDetail(null, packageItineraryId, null, null, "r"));

        model.addAttribute("activityDetailList", list);

        return getPackItineraryByPackInfoId(model, session.getAttribute("packageInfoId").toString(), session);

    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model,
                      DayDetailModel dayDetailModel,
                      HttpSession session) {


        Map map = (Map) dayDetailDao.procDayDetail(null, dayDetailModel.getPackageItineraryId(), dayDetailModel.getActivityDetailId(), session.getAttribute("userName").toString(), "i").get(0);

        model.addAttribute("dbResponse", map);

        return getPackItineraryByPackInfoId(model, session.getAttribute("packageInfoId").toString(), session);

    }


    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/detail/{packageItineraryId}", method = RequestMethod.GET)
    public String detail(Model model,
                         @PathVariable("packageItineraryId") String packageItineraryId,
                         HttpSession session) {

        model.addAttribute("detailView", true);

//		session.setAttribute("packageItineraryId",packageItineraryId); 


        PackageItineraryModel packageItineraryModel = new PackageItineraryMapper().mapRow((Map) packageItineraryDao.procPackageItinerary(packageItineraryId, null, null, null, null, null, "s").get(0));

        model.addAttribute("packageItineraryMap", packageItineraryModel);


        List<DayDetailModel> list = new DayDetailMapper().mapList(dayDetailDao.procDayDetail(null, packageItineraryId, null, null, "s"));

        model.addAttribute("dayDetailList", list);

        return getPackItineraryByPackInfoId(model, session.getAttribute("packageInfoId").toString(), session);

    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("id") String dayDetailId, HttpSession session) {

        Map map = (Map) dayDetailDao.procDayDetail(dayDetailId, null, null, session.getAttribute("userName").toString(), "d").get(0);

        model.addAttribute("dbResponse", map);

        return getPackItineraryByPackInfoId(model, session.getAttribute("packageInfoId").toString(), session);
    }


}
