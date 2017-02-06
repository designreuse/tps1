package igc.tech.com.controller;


import igc.tech.com.dao.ActivityDetailDao;
import igc.tech.com.dao.CountryDao;
import igc.tech.com.dao.RegionDao;
import igc.tech.com.mapper.ActivityDetailMapper;
import igc.tech.com.model.ActivityDetailModel;

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
@RequestMapping(value = "/activityDetail")
class ActivityDetailController {

    @Autowired
    ActivityDetailDao activityDetailDao;


    @Autowired
    CountryDao countryDao;

    @Autowired
    RegionDao regionDao;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<ActivityDetailModel> list = new ActivityDetailMapper().mapList(activityDetailDao.procActivityDetail(null, null, null, "a"));


        model.addAttribute("activityDetailList", list);

        return "activityDetail";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {


        model.addAttribute("mode", "add");


        return getAll(model);

    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model, ActivityDetailModel activityDetailModel, HttpSession session) {

        Map map = (Map) activityDetailDao.procActivityDetail(null, activityDetailModel.getDescription(), session.getAttribute("userName").toString(), "i").get(0);


        model.addAttribute("dbResponse", map);

        return add(model);

    }


    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model,
                       @PathVariable("id") String activityDetailId) {

        ActivityDetailModel activityDetailModel = new ActivityDetailMapper().mapRow((Map) activityDetailDao.procActivityDetail(activityDetailId, null, null, "s").get(0));

        model.addAttribute("activityDetailMap", activityDetailModel);


        model.addAttribute("mode", "edit");

        return getAll(model);

    }


    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, ActivityDetailModel activityDetailModel, HttpSession session) {


        Map map = (Map) activityDetailDao.procActivityDetail(activityDetailModel.getActivityDetailId(), activityDetailModel.getDescription(), session.getAttribute("userName").toString(), "u").get(0);

        model.addAttribute("dbResponse", map);

        return getAll(model);

    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("id") String activityDetailId, HttpSession session) {

        Map map = (Map) activityDetailDao.procActivityDetail(activityDetailId, null, session.getAttribute("userName").toString(), "d").get(0);

        model.addAttribute("dbResponse", map);

        return getAll(model);
    }

}
