package igc.tech.com.controller;

import igc.tech.com.dao.AreaDao;
import igc.tech.com.dao.CountryDao;
import igc.tech.com.dao.RegionDao;
import igc.tech.com.mapper.AreaMapper;
import igc.tech.com.mapper.AvailableDateRateMappper;
import igc.tech.com.mapper.CountryMappper;
import igc.tech.com.mapper.RegionMapper;
import igc.tech.com.model.AreaModel;
import igc.tech.com.model.AvailableDateRateModel;
import igc.tech.com.model.Country;
import igc.tech.com.model.RegionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 2/9/2016.
 */

@Controller
@RequestMapping(value = "/area")
public class AreaController {


    @Autowired
    AreaDao areaDao;

    @Autowired
    CountryDao countryDao;

    @Autowired
    RegionDao regionDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<Country> countryList = new CountryMappper().mapList(countryDao.procCountry(null, null, null, "a"));


        model.addAttribute(countryList);

        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }

        return "area";

    }


    @RequestMapping(value = "/viewArea", method = RequestMethod.POST)
    public String getArea(Model model, Country country) {

        List<AreaModel> list = new AreaMapper().mapList(areaDao.procArea(null, null, null, country.getCountryId(),
                null, "s"));

        model.addAttribute("AreaList", list);
        model.addAttribute("ListView", "ListView");
        model.addAttribute("noView", "noView");

        return getAll(model);

    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        List<Country> list = new CountryMappper().mapList(countryDao.procCountry(null, null, null, "a"));

        model.addAttribute("countryList", list);

        model.addAttribute("mode", "add");
        model.addAttribute("noView", "noView");
        return getAll(model);


    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model, @RequestParam("countryId") String countryId, AreaModel areaModel, HttpSession
            session) {


        if (areaModel.getAreaName() != null && !areaModel.getAreaName().isEmpty()) {


            Map map = (Map) areaDao.procArea(null, areaModel.getAreaName(), areaModel.getRegionId(), null, session
                    .getAttribute("userName").toString(), "i").get(0);


            List<AreaModel> list = new AreaMapper().mapList(areaDao.procArea(null, null, null, countryId, null, "s"));


            model.addAttribute("AreaList", list);
            model.addAttribute("ListView", "ListView");
            model.addAttribute("dbResponse", map);
            model.addAttribute("noView", "noView");
            return getAll(model);


        } else {

            List<RegionModel> list = new RegionMapper().mapList(regionDao.procRegion(null, null, countryId, null, "s"));

            List<Country> countryList = new CountryMappper().mapList(countryDao.procCountry(null, null, null, "a"));
            Country individualCountry = new CountryMappper().mapRow((Map) countryDao.procCountry(countryId, null, null,
                    "s").get(0));

            model.addAttribute("countryList", countryList);
            model.addAttribute("individualCountry", individualCountry);
            model.addAttribute("regionList", list);
            model.addAttribute("regionView", "regionView");
            model.addAttribute("mode", "add");
            model.addAttribute("noView", "noView");
            return getAll(model);
        }


    }


    @RequestMapping(value = "/edit/{areaId}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("areaId") String
            areaId, HttpSession session) {

        AreaModel amodal = new AreaMapper().mapRow((Map) areaDao.procArea(areaId, null, null, null,
                null, "s")
                .get(0));


        List<Country> list = new CountryMappper().mapList(countryDao.procCountry(null, null, null, "a"));

        Country individualCountry = new CountryMappper().mapRow((Map) countryDao.procCountry(amodal.getCountryId()
                , null, null,
                "s").get(0));


        model.addAttribute("countryName", individualCountry.getCountryName());
        model.addAttribute("countryId", individualCountry.getCountryId());
      /*  model.addAttribute("regionId", amodal.getRegionId());*/
        model.addAttribute("regionName", amodal.getRegionName());
        model.addAttribute("areaId", areaId);


        model.addAttribute("countryList", list);
        model.addAttribute("individualCountry", individualCountry);
        model.addAttribute("AreaModel", amodal);
        model.addAttribute("mode", "edit");
        model.addAttribute("noView", "noView");
        return getAll(model);


    }


    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, AreaModel areaModel, HttpSession session) {


        Map map = (Map) areaDao.procArea(areaModel.getAreaId(), areaModel.getAreaName(), null, null,
                session.getAttribute("userName").toString(), "u")
                .get(0);

        model.addAttribute("dbResponse", map);

        List<AreaModel> list = new AreaMapper().mapList(areaDao.procArea(null, null, null, areaModel.getCountryId(),
                null, "s"));


        model.addAttribute("AreaList", list);
        model.addAttribute("ListView", "ListView");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("areaId") String areaId, HttpSession session) {

/*do not alter the sequence*/
        AreaModel individualArea = new AreaMapper().mapRow((Map) areaDao.procArea(areaId, null, null, null, null,
                "s").get(0));

/*do not alter the sequence*/
        Map map = (Map) areaDao.procArea(areaId, null, null, null,
                session.getAttribute("userName").toString(), "d")
                .get(0);

/*do not alter the sequence*/
        List<AreaModel> list = new AreaMapper().mapList(areaDao.procArea(null, null, null, individualArea
                        .getCountryId(),
                null, "s"));


        model.addAttribute("dbResponse", map);
        model.addAttribute("AreaList", list);
        model.addAttribute("ListView", "ListView");
        model.addAttribute("noView", "noView");

        return getAll(model);
    }


}
