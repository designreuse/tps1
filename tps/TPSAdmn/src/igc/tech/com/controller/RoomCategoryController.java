package igc.tech.com.controller;


import igc.tech.com.dao.RoomCategoryDao;
import igc.tech.com.mapper.RoomCategoryMapper;
import igc.tech.com.model.RoomCategoryModel;
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
@RequestMapping(value = "/roomCategory")
public class RoomCategoryController {

    @Autowired
    RoomCategoryDao roomCategoryDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<RoomCategoryModel> list = new RoomCategoryMapper().mapList(roomCategoryDao.procRoomCategory(null, null, null, "a"));


        model.addAttribute("roomCategoryList", list);
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }
        return "roomCategory";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("mode", "add");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addRoomCategory(Model model, RoomCategoryModel roomCategoryModel, HttpSession session) {

        Map map = (Map) roomCategoryDao.procRoomCategory(null, roomCategoryModel.getRoomCategoryDesc(), session.getAttribute("userName")
                .toString(), "i").get
                (0);

        model.addAttribute("dbResponse", map);
        model.addAttribute("mode", "add");

        return "redirect:add";

    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String roomCategoryID) {

        RoomCategoryModel roomCategoryModel = new RoomCategoryMapper().mapRow((Map) roomCategoryDao.procRoomCategory(roomCategoryID, null, null, "s").get(0));
        model.addAttribute("mode", "edit");
        model.addAttribute("roomCategoryMap", roomCategoryModel);
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, RoomCategoryModel roomCategoryModel, HttpSession session) {

        System.out.println(roomCategoryModel.toString());

        Map map = (Map) roomCategoryDao.procRoomCategory(roomCategoryModel.getRoomCategoryId(),
                roomCategoryModel.getRoomCategoryDesc(), session.getAttribute
                        ("userName").toString(), "u").get(0);

        model.addAttribute("dbResponse", map);

        return "redirect:view";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("roomCategoryId") String roomCategoryId, HttpSession session) {


        Map map = (Map) roomCategoryDao.procRoomCategory(roomCategoryId,null,  session.getAttribute("userName").toString(), "d")
                .get(0);

        model.addAttribute("dbResponse", map);

        return "redirect:view";
    }


}
