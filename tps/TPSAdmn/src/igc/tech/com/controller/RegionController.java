package igc.tech.com.controller;


import igc.tech.com.dao.CountryDao;
import igc.tech.com.dao.RegionDao;
import igc.tech.com.mapper.CountryMappper;
import igc.tech.com.mapper.RegionMapper;
import igc.tech.com.model.Country;
import igc.tech.com.model.RegionModel;

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
@RequestMapping(value = "/region")
class RegionController {

    @Autowired
    CountryDao countryDao;

    @Autowired
    RegionDao regionDao;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<RegionModel> list = new RegionMapper().mapList(regionDao.procRegion(null, null, null, null, "a"));


        model.addAttribute("regionList", list);

        return "region";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        List<Country> list = new CountryMappper().mapList(countryDao.procCountry(null, null, null, "a"));

        model.addAttribute("countryList", list);

        model.addAttribute("mode", "add");


        return getAll(model);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model, RegionModel regionModel, HttpSession session) {

        Map map = (Map) regionDao.procRegion(null, regionModel.getRegionName(), regionModel.getCountryId(), session
                .getAttribute("userName").toString(), "i").get(0);

        model.addAttribute("dbResponse", map);

        return add(model);

    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model,
                       @PathVariable("id") String regionId) {

        RegionModel regionModel = new RegionMapper().mapRow((Map) regionDao.procRegion(regionId, null, null, null,
                "s").get(0));

        model.addAttribute("regionMap", regionModel);

        List<Country> list = new CountryMappper().mapList(countryDao.procCountry(null, null, null, "a"));

        model.addAttribute("countryList", list);

        model.addAttribute("mode", "edit");

        return getAll(model);

    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, RegionModel regionModel, HttpSession session) {

        System.out.println(regionModel.toString());

        Map map = (Map) regionDao.procRegion(regionModel.getRegionId(), regionModel.getRegionName(), regionModel
                .getCountryId(), session.getAttribute("userName").toString(), "u").get(0);

        model.addAttribute("dbResponse", map);

        return getAll(model);

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("id") String regionId, HttpSession session) {

        Map map = (Map) regionDao.procRegion(regionId, null, null, session.getAttribute("userName").toString(), "d")
                .get(0);

        model.addAttribute("dbResponse", map);

        return getAll(model);
    }

}
