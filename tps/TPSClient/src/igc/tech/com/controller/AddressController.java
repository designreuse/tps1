package igc.tech.com.controller;

import com.google.gson.Gson;
import igc.tech.com.dao.AddressDao;
import igc.tech.com.mapper.AddressMapper;
import igc.tech.com.mapper.EasyTreeMapper;
import igc.tech.com.model.AddressModel;
import igc.tech.com.model.EasyTreeModel;
import igc.tech.com.utility.EmployeeNode;
import igc.tech.com.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ganga on 6/14/2016.
 */

@Controller
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    AddressDao addressDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(Model model, HttpSession session){

        /*EasyTreeModel easyTreeModel = new EasyTreeMapper().mapAddressRow((Map) addressDao.procAddress(new AddressModel(), null, "r").get(0));

        List<EasyTreeModel> easyTreeModelList = new EasyTreeMapper().mapList(addressDao.procAddress(new AddressModel(), null, "c"),"address");
        new Utility().check(easyTreeModel, easyTreeModelList);

        easyTreeModelList.add(easyTreeModel);*/

        List<EasyTreeModel> easyTreeModelList = new EasyTreeMapper().mapList(addressDao.procAddress(new AddressModel(), null, "a"),"address");

        String json = new Gson().toJson(easyTreeModelList);
        System.out.println(json);

        model.addAttribute("tree", json);
        model.addAttribute("base", "address");
//        model.addAttribute("title", "Address");
        model.addAttribute("level", 6);

        return "address";
    }



   /* @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(HttpSession session, AddressModel addressModel, RedirectAttributes redirectAttributes){

        addressModel.setAddressId(null);
        if(addressModel.getParentAddressId().equals("0")){
            addressModel.setParentAddressId(null);
        }
        System.out.println(addressModel);

        Map map = (Map) addressDao.procAddress(addressModel,session.getAttribute("userName").toString(), "i").get(0);
        redirectAttributes.addFlashAttribute("response", map);

        return "redirect:../address/view";
    }*/

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(HttpSession session, @RequestParam("addressId") String addressId, @RequestParam("parentAddressId") String parentAddressId,
                       @RequestParam("level") String level, @RequestParam("addressName") String addressName, HttpServletResponse response) throws Exception{

        AddressModel addressModel = new AddressModel();
//        addressModel.setAddressId(addressId);
        addressModel.setParentAddressId(parentAddressId);
        addressModel.setAddressName(addressName);
        addressModel.setLevel(level);
        System.out.println(addressModel);
        if(addressModel.getParentAddressId().equals("0")){
            addressModel.setParentAddressId(null);
        }
        Map map = new HashMap();
        if(addressId.indexOf("x")>-1){
            map = (Map) addressDao.procAddress(addressModel,session.getAttribute("userName").toString(), "i").get(0);
        }else{
            addressModel.setAddressId(addressId);
            map = (Map) addressDao.procAddress(addressModel,session.getAttribute("userName").toString(), "u").get(0);
        }

        String json = new Gson().toJson(map);
        return json;

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(HttpSession session, @RequestParam("addressId") String addressId, HttpServletResponse response) throws Exception{

        AddressModel addressModel = new AddressModel();
        addressModel.setAddressId(addressId);
        Map map = (Map) addressDao.procAddress(addressModel,session.getAttribute("userName").toString(), "d").get(0);

        String json = new Gson().toJson(map);
       return json;
    }

}
