package igc.tech.com.controller;

import igc.tech.com.dao.BedTypeDao;
import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.dao.HotelDetailImpl;
import igc.tech.com.dao.RoomFacilityDao;
import igc.tech.com.mapper.BedTypeMapper;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.RoomFacilityMapper;
import igc.tech.com.model.BedTypeModel;
import igc.tech.com.model.HotelDetailModel;
import igc.tech.com.model.RoomFacilityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/bedType")
public class BedTypeController {

    @Autowired
    BedTypeDao bedTypeDao;

    @Autowired
    private HotelDetailDao hotelDetailDao;


    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<BedTypeModel> list = new BedTypeMapper().mapList(bedTypeDao.procBedType(null, null, null, null, "a"));



        model.addAttribute("bedTypeList", list);
        if(!model.containsAttribute("noView")){model.addAttribute("mode","view");}

         return "bedType";

    }


    /*@RequestMapping(value = "/facilityList", method = RequestMethod.POST)
    public String getAllList(Model model, BedTypeModel bedTypeModel, HttpSession session) {



        List<BedTypeModel> list = new BedTypeMapper().
                mapList(bedTypeDao.procBedType(null,null,bedTypeModel.getHotelDetailId(),null,"s"));



        model.addAttribute("IndividualList", list);
        model.addAttribute("listView","listView");
        model.addAttribute("noView","noView");


        return getAll(model);

    }*/





    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {



        model.addAttribute("mode", "add");

        System.out.println("");
        model.addAttribute("noView","noView");

        return getAll(model);

    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model, BedTypeModel bedTypeModel,
                      HttpSession session, RedirectAttributes redirectAttributes) {


        Map map = (Map) bedTypeDao.
                procBedType(null, bedTypeModel.getBedTypeDesc(),bedTypeModel.getSize(),
                        session.getAttribute("userName").toString(), "i")
                .get(0);


        /*model.addAttribute("listView","listView");
        model.addAttribute("noView","noView");*/
//        redirectAttributes.addFlashAttribute("mode", "add");
        redirectAttributes.addFlashAttribute("dbResponse", map);
        return "redirect:add";

    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model,
                       @PathVariable("id") String bedTypeId) {



        BedTypeModel bedTypeModel = new BedTypeMapper().mapRow((Map) bedTypeDao.procBedType(bedTypeId, null, null,
                null, "s").get(0));


        model.addAttribute("bedMap", bedTypeModel);


        model.addAttribute("mode", "edit");
        model.addAttribute("noView","noView");

        return getAll(model);

    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, BedTypeModel bedTypeModel, HttpSession session, RedirectAttributes redirectAttributes) {
        System.out.println("bed type-------------------------------------=" + bedTypeModel.getBedTypeId());

        Map map = (Map) bedTypeDao.procBedType(bedTypeModel.getBedTypeId(),
                bedTypeModel.getBedTypeDesc(),bedTypeModel.getSize(),
                session.getAttribute("userName").toString(), "u")
                .get(0);



//        redirectAttributes.addFlashAttribute("listView","listView");
        redirectAttributes.addFlashAttribute("dbResponse", map);

        return "redirect:view";

    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model, @RequestParam("id") String bedTypeId,
                         HttpSession session, RedirectAttributes redirectAttributes) {


        Map map = (Map) bedTypeDao.procBedType(bedTypeId, null, null, session.getAttribute("userName").toString(), "d")
                .get(0);

        redirectAttributes.addFlashAttribute("dbResponse", map);




        return "redirect:view";
    }


}
