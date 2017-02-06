package igc.tech.com.controller;


import igc.tech.com.dao.CountryDao;
import igc.tech.com.mapper.CountryMappper;
import igc.tech.com.model.Country;

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
@RequestMapping(value = "/country")
class CountryController {

    @Autowired
    CountryDao countryDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<Country> list = new CountryMappper().mapList(countryDao.procCountry(null, null, null, "a"));

        model.addAttribute("countryList", list);

        return "country";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("mode", "add");

        return getAll(model);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model, Country country, HttpSession session) {


        Map map = (Map) countryDao.procCountry(null, country.getCountryName(), session.getAttribute("userName").toString(), "i").get(0);

        model.addAttribute("mode", "add");

        model.addAttribute("dbResponse", map);

        return getAll(model);

    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model,
                       @PathVariable("id") String countryId) {

        Country country = new CountryMappper().mapRow((Map) countryDao.procCountry(countryId, null, null, "s").get(0));

        model.addAttribute("countryMap", country);

        model.addAttribute("mode", "edit");

        return getAll(model);

    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, Country country, HttpSession session) {
        Map map = (Map) countryDao.procCountry(country.getCountryId(), country.getCountryName(), session.getAttribute("userName").toString(), "u").get(0);


        model.addAttribute("dbResponse", map);

        return getAll(model);

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("id") String countryId, HttpSession session) {

        Map map = (Map) countryDao.procCountry(countryId, null, session.getAttribute("userName").toString(), "d").get(0);

        model.addAttribute("dbResponse", map);

        return getAll(model);
    }

}
