package igc.tech.com.controller;


import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.dao.HotelFacilityDao;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.HotelFacilityMapper;
import igc.tech.com.model.HotelDetailModel;
import igc.tech.com.model.HotelFacilityModel;

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
@RequestMapping(value = "/hotelFacility1")
class HotelFacilityControllerOld {

    @Autowired
    HotelFacilityDao hotelFacilityDao;


    @Autowired
    HotelDetailDao hotelDetailDao;


    /*@SuppressWarnings("unchecked")
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<HotelFacilityModel> list = new HotelFacilityMapper().mapList(hotelFacilityDao.procHotelFacility(null, null, null, null, "a"));

        model.addAttribute("hotelFacilityList", list);
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }

        return "hotelFacility";

    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        List<HotelDetailModel> list = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(null, null, null, null,
                null, null,  null, null, null,
                null, null,null,null, null, "a"));


        model.addAttribute("hotelDetailList", list);
        model.addAttribute("noView", "noView");
        model.addAttribute("mode", "add");

        return getAll(model);

    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model, HotelFacilityModel hotelFacilityModel, HttpSession session) {

        Map map = (Map) hotelFacilityDao.procHotelFacility(null, hotelFacilityModel.getDescription(), hotelFacilityModel.getHotelDetailId(), session.getAttribute("userName").toString(), "i").get(0);

        model.addAttribute("dbResponse", map);

        return add(model);

    }


    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model,
                       @PathVariable("id") String hotelFacilityId) {

        HotelFacilityModel hotelFacilityModel = new HotelFacilityMapper().mapRow((Map) hotelFacilityDao.procHotelFacility(hotelFacilityId, null, null, null, "s").get(0));

        model.addAttribute("hotelFacilityMap", hotelFacilityModel);

        List<HotelDetailModel> list = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(null, null, null, null,
                null, null, null, null, null,
                null, null,null,null, null, "a"));


        model.addAttribute("hotelDetailList", list);
        model.addAttribute("noView", "noView");
        model.addAttribute("mode", "edit");

        return getAll(model);

    }


    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, HotelFacilityModel hotelFacilityModel, HttpSession session) {


        Map map = (Map) hotelFacilityDao.procHotelFacility(hotelFacilityModel.getHotelFacilityId(),
                hotelFacilityModel.getDescription(),
                hotelFacilityModel.getHotelDetailId(),
                session.getAttribute("userName").toString(),
                "u").get(0);


        model.addAttribute("dbResponse", map);

        return getAll(model);

    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("id") String hotelFacilityId, HttpSession session) {

        Map map = (Map) hotelFacilityDao.procHotelFacility(hotelFacilityId, null, null, session.getAttribute("userName").toString(), "d").get(0);

        model.addAttribute("dbResponse", map);

        return getAll(model);
    }*/

	
	/*@RequestMapping (value="/detail/{id}",method = RequestMethod.GET)
	public String detail(Model model, 
					@PathVariable("id") String hotelFacilityId)
	{	
		
		HotelDetailModel hotelDetailModel= new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailId, null, null, null,null, null, null, null, null,
				null, null, null, null, "s").get(0)) ;
		
		model.addAttribute("hotelDetailMap", hotelDetailModel);
		
		List<RegionModel> list= new RegionMapper().mapList( regionDao.procRegion(null, null, null, null, "a") );
		
		model.addAttribute("regionList", list);
		
		model.addAttribute("mode", "detail");
		
		return getAll(model);
		
	}*/

}
