package igc.tech.com.controller;

import com.google.gson.Gson;
import igc.tech.com.dao.RoomTypeDao;
import igc.tech.com.mapper.EasyTreeMapper;
import igc.tech.com.model.RoomTypeModel;
import igc.tech.com.model.RoomTypeModel;
import igc.tech.com.model.EasyTreeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ganga on 6/14/2016.
 */

@Controller
@RequestMapping(value = "/roomType")
public class RoomTypeController {

    @Autowired
    RoomTypeDao roomTypeDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(Model model, HttpSession session){

        List<EasyTreeModel> easyTreeModelList = new EasyTreeMapper().mapList(roomTypeDao.procRoomType(new RoomTypeModel(), null, "a"),"roomType");
        System.out.println("easy tree: "+easyTreeModelList);

        String json = new Gson().toJson(easyTreeModelList);
        System.out.println(json);

        model.addAttribute("level",2);
        model.addAttribute("tree", json);
        model.addAttribute("base", "roomType");

        return "roomType";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(HttpSession session, RoomTypeModel roomTypeModel, RedirectAttributes redirectAttributes){

        roomTypeModel.setRoomTypeId(null);
        System.out.println(roomTypeModel);

        Map map = (Map) roomTypeDao.procRoomType(roomTypeModel,session.getAttribute("userName").toString(), "i").get(0);
        redirectAttributes.addFlashAttribute("response", map);

        return "redirect:../roomType/view";
    }

   /* @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(HttpSession session, RoomTypeModel roomTypeModel, RedirectAttributes redirectAttributes){

        System.out.println(roomTypeModel);
        Map map = (Map) roomTypeDao.procRoomType(roomTypeModel,session.getAttribute("userName").toString(), "u").get(0);
        redirectAttributes.addFlashAttribute("response", map);

        return "redirect:../roomType/view";
    }*/

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(HttpSession session, RoomTypeModel roomTypeModel, HttpServletResponse response) throws Exception{
        if(roomTypeModel.getParentRoomTypeId().equals("0")){
            roomTypeModel.setParentRoomTypeId(null);
        }
        System.out.println(roomTypeModel);

        Map map = new HashMap();
        if(roomTypeModel.getRoomTypeId().indexOf("x")>-1){
            roomTypeModel.setRoomTypeId(null);
            map = (Map) roomTypeDao.procRoomType(roomTypeModel, session.getAttribute("userName").toString(),"i").get(0);
        }else{
            map = (Map) roomTypeDao.procRoomType(roomTypeModel, session.getAttribute("userName").toString(),"u").get(0);
        }
        String json = new Gson().toJson(map);
        return json;
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(HttpSession session, @RequestParam("roomTypeId") String roomTypeId, HttpServletResponse response) throws Exception{

        RoomTypeModel roomTypeModel = new RoomTypeModel();
        roomTypeModel.setRoomTypeId(roomTypeId);
        Map map = (Map) roomTypeDao.procRoomType(roomTypeModel,session.getAttribute("userName").toString(), "d").get(0);

        String json = new Gson().toJson(map);
        return json;
    }
    /*@RequestMapping(value = "/delete/{roomTypeId}", method = RequestMethod.GET)
    public String delete(HttpSession session, @PathVariable("roomTypeId") String roomTypeId, RedirectAttributes redirectAttributes){

        RoomTypeModel roomTypeModel = new RoomTypeModel();
        roomTypeModel.setRoomTypeId(roomTypeId);
        Map map = (Map) roomTypeDao.procRoomType(roomTypeModel,session.getAttribute("userName").toString(), "d").get(0);
        redirectAttributes.addFlashAttribute("response", map);

        return "redirect:../view";
    }*/



}
