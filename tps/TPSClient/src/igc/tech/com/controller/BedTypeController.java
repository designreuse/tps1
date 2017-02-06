package igc.tech.com.controller;


import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.dao.BedTypeDao;
import igc.tech.com.mapper.BedTypeMapper;
import igc.tech.com.model.BedTypeModel;
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
@RequestMapping(value = "/bedType")
public class BedTypeController {

    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    BedTypeDao bedTypeDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model, HttpSession session) {

        /*BedTypeModel bedTypeModel = new BedTypeModel();
        bedTypeModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());*/

        List<BedTypeModel> bedTypeModelList = new BedTypeMapper().mapList(bedTypeDao.procBedType(new BedTypeModel(), null, "a"));
//        System.out.println(bedTypeModelList);
        model.addAttribute("bedTypeList", bedTypeModelList);

        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }
        model.addAttribute("base", "bedType");
        return "bedType";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model, HttpSession session){
        model.addAttribute("mode", "update");
        model.addAttribute("noView", "noView");
        return  getAll(model, session);
    }

    @RequestMapping(value = "/edit/{bedTypeId}", method = RequestMethod.GET)
    public String add(Model model,@PathVariable("bedTypeId") String bedTypeId, HttpSession session){
        BedTypeModel bedTypeModel = new BedTypeModel();
        bedTypeModel.setBedTypeId(bedTypeId);
        bedTypeModel = new BedTypeMapper().mapRow((Map) bedTypeDao.procBedType(bedTypeModel,null,"s").get(0));
        model.addAttribute("bedTypeMap", bedTypeModel);
        model.addAttribute("mode", "update");
        model.addAttribute("noView", "noView");
        return  getAll(model, session);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model, HttpSession session, BedTypeModel bedTypeModel){
        if(bedTypeModel.getActive()==null){
            bedTypeModel.setActive("N");
        }
        if(bedTypeModel.getBedTypeId().isEmpty()){
            bedTypeModel.setBedTypeId(null);
            Map map = (Map) bedTypeDao.procBedType(bedTypeModel,session.getAttribute("userName").toString(),"i").get(0);
            model.addAttribute("response",map);
        }else{
            Map map = (Map) bedTypeDao.procBedType(bedTypeModel,session.getAttribute("userName").toString(),"u").get(0);
            model.addAttribute("response",map);
        }

        return  "redirect:../bedType/view";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model, HttpSession session, @RequestParam("deleteId") String deleteId){

        BedTypeModel bedTypeModel = new BedTypeModel();
        bedTypeModel.setBedTypeId(deleteId);

        Map map = (Map) bedTypeDao.procBedType(bedTypeModel,session.getAttribute("userName").toString(),"d").get(0);
        model.addAttribute("response",map);

        return  "redirect:../bedType/view";
    }

}
