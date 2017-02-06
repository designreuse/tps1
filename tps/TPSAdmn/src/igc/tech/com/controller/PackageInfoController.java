package igc.tech.com.controller;


import igc.tech.com.dao.ClientDetailDao;
import igc.tech.com.dao.PackageInfoDao;
import igc.tech.com.mapper.ClientDetailMapper;
import igc.tech.com.mapper.PackageInfoMapper;
import igc.tech.com.model.ClientDetailModel;
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
@RequestMapping(value = "/packageInfo")
class PackageInfoController {

    @Autowired
    PackageInfoDao packageInfoDao;

    @Autowired
    ClientDetailDao clientDetailDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<PackageInfoModel> list = new PackageInfoMapper().mapList(packageInfoDao.procPackageInfo
                (null, null, null, null, null, null, null, null, "a"));

        model.addAttribute("packageInfoList", list);

        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }


        return "packageInfo";

    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        List<ClientDetailModel> list = new
                ClientDetailMapper().
                mapList(clientDetailDao.procClientDetail(null,
                        null, null, null, null,
                        null, null, null, null, null, null, "a"));

        model.addAttribute("clientDetailList", list);
        model.addAttribute("mode", "add");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model, PackageInfoModel packageInfo, HttpSession session) {


        Map map = (Map) packageInfoDao.procPackageInfo(null, packageInfo.getClientDetailId().trim(), packageInfo.getDescription(),
                packageInfo.getNoOfDays(), packageInfo.getNoOfNights(), packageInfo.getTotalDays(),
                packageInfo.getPackageDetails(), "tilak", "i").get(0);


        model.addAttribute("mode", "add");
        model.addAttribute("noView", "noView");
        model.addAttribute("dbResponse", map);

        return getAll(model);

    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model,
                       @PathVariable("id") String packageInfoId) {

        PackageInfoModel packageInfo = new PackageInfoMapper().mapRow((Map) packageInfoDao.procPackageInfo(packageInfoId, null,
                null, null, null, null, null, null, "s").get(0));


        List<ClientDetailModel> list = new
                ClientDetailMapper().
                mapList(clientDetailDao.procClientDetail(null,
                        null, null, null, null,
                        null, null, null, null, null, null, "a"));

        model.addAttribute("clientDetailList", list);
        model.addAttribute("packageInfoMap", packageInfo);
        model.addAttribute("mode", "edit");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, PackageInfoModel packageInfo, HttpSession session) {




        Map map = (Map) packageInfoDao.procPackageInfo(packageInfo.getPackageInfoId(), packageInfo.getClientDetailId(), packageInfo.getDescription(),
                packageInfo.getNoOfDays(), packageInfo.getNoOfNights(), packageInfo.getTotalDays(),
                packageInfo.getPackageDetails(), "tilak", "u").get(0);



        model.addAttribute("dbResponse", map);

        return getAll(model);

    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("id") String packageInfoId) {

        Map map = (Map) packageInfoDao.procPackageInfo(packageInfoId, null, null, null,
                null, null, null, "tilak", "d").get(0);


        model.addAttribute("dbResponse", map);

        return getAll(model);

    }


    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(Model model,
                         @PathVariable("id") String packageInfoId) {

        PackageInfoModel packageInfo = new PackageInfoMapper().mapRow((Map) packageInfoDao.procPackageInfo(packageInfoId, null,
                null, null, null, null, null, null, "s").get(0));


        List<ClientDetailModel> list = new
                ClientDetailMapper().
                mapList(clientDetailDao.procClientDetail(null,
                        null, null, null, null,
                        null, null, null, null, null, null, "a"));

        model.addAttribute("clientDetailList", list);
        model.addAttribute("packageInfoMap", packageInfo);
        model.addAttribute("noView", "noView");
        model.addAttribute("mode", "detail");

        return getAll(model);

    }


}
