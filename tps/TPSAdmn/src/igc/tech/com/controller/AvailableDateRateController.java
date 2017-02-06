package igc.tech.com.controller;


import igc.tech.com.dao.AvailableDateRateDao;
import igc.tech.com.dao.PackageInfoDao;
import igc.tech.com.mapper.AvailableDateRateMappper;
import igc.tech.com.mapper.PackageInfoMapper;
import igc.tech.com.model.AvailableDateRateModel;
import igc.tech.com.model.PackageInfoModel;

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
@RequestMapping(value = "/availableDateRate")
class AvailableDateRateController {


    @Autowired
    AvailableDateRateDao availableDateRateDao;


    @Autowired
    PackageInfoDao packageInfoDao;


    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<AvailableDateRateModel> list = new AvailableDateRateMappper().mapList(availableDateRateDao.
                procAvailableDateRate(null, null, null, null, null, "a"));

        model.addAttribute("availableDateRateList", list);

        return "availableDateRate";

    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        List<PackageInfoModel> list = new PackageInfoMapper().mapList(packageInfoDao.procPackageInfo(null, null,
                null, null, null, null, null, null, "a"));

        model.addAttribute("packageInfoList", list);

        model.addAttribute("mode", "add");

        return getAll(model);

    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model, AvailableDateRateModel availableDateRateModel, HttpSession session) {

        Map map = (Map) availableDateRateDao.procAvailableDateRate(null, availableDateRateModel.getAvailableDate(), availableDateRateModel.getPackageInfoId(), availableDateRateModel.getRate(), session.getAttribute("userName").toString(), "i").get(0);

        model.addAttribute("dbResponse", map);

        return add(model);

    }


    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model,
                       @PathVariable("id") String availableDateRateId) {


        AvailableDateRateModel availableDateModel = new AvailableDateRateMappper().mapRow((Map) availableDateRateDao.procAvailableDateRate(availableDateRateId, null, null, null, null, "s").get(0));

        model.addAttribute("availableDateRateMap", availableDateModel);

        List<PackageInfoModel> list = new PackageInfoMapper().mapList(packageInfoDao.procPackageInfo(null,null, null, null, null, null, null, null, "a"));

        model.addAttribute("packageInfoList", list);

        model.addAttribute("mode", "edit");

        return getAll(model);

    }


    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, AvailableDateRateModel availableDateRateModel, HttpSession session) {


        Map map = (Map) availableDateRateDao.procAvailableDateRate(availableDateRateModel.getAvailableDateRateId(), availableDateRateModel.getAvailableDate(), availableDateRateModel.getPackageInfoId(), availableDateRateModel.getRate(), session.getAttribute("userName").toString(), "u").get(0);

        model.addAttribute("dbResponse", map);

        return getAll(model);

    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("id") String availableDateRateId, HttpSession session) {

        Map map = (Map) availableDateRateDao.procAvailableDateRate(availableDateRateId, null, null, null, session.getAttribute("userName").toString(), "d").get(0);


        model.addAttribute("dbResponse", map);

        return getAll(model);
    }

	
	/*@RequestMapping (value="/detail/{id}",method = RequestMethod.GET)
    public String detail(Model model,
					@PathVariable("id") String packageItineraryId)
	{	
		
		PackageItineraryModel packageItineraryModel= new PackageItineraryMapper().mapRow((Map) packageItineraryDao.procPackageItinerary(packageItineraryId, null, null, null, null, null, "s").get(0)) ;
		
		model.addAttribute("packageItineraryMap", packageItineraryModel);
		
		List<PackageInfoModel> list= new PackageInfoMapper().mapList( packageInfoDao.procPackageInfo(null, null, null, null, null, null, null, "a"));
		
		model.addAttribute("packageInfoList", list);
		
		
		List<HotelDetailModel> list1= new HotelDetailMapper().mapList( hotelDetailDao.procHotelDetail(null, null, null, null,
															null, null, null, null, null, null,
															null, null, null, "a"));
		model.addAttribute("hotelDetailList", list1);
		
		model.addAttribute("mode", "detail");
		
		return getAll(model);
		
	}*/

}
