package igc.tech.com.controller;


import igc.tech.com.dao.RoleDao;
import igc.tech.com.mapper.RegionMapper;
import igc.tech.com.mapper.RoleMapper;
import igc.tech.com.model.RegionModel;
import igc.tech.com.model.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.ls.LSInput;

import javax.management.relation.Role;
import javax.management.relation.RoleNotFoundException;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    RoleDao roleDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<RoleModel> list = new RoleMapper().mapList(roleDao.procRole(null, null, null, "a"));


        model.addAttribute("roleList", list);
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }
        return "role";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("mode", "add");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addRole(Model model, RoleModel roleModel, HttpSession session) {

        Map map = (Map) roleDao.procRole(null, roleModel.getRoleDescription(), session.getAttribute("userName")
                .toString(), "i").get
                (0);

        model.addAttribute("dbResponse", map);
        model.addAttribute("mode", "add");

        return getAll(model);

    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String roleID) {

        RoleModel roleModel = new RoleMapper().mapRow((Map) roleDao.procRole(roleID, null, null, "s").get(0));
        model.addAttribute("mode", "edit");
        model.addAttribute("roleMap", roleModel);
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, RoleModel roleModel, HttpSession session) {

        System.out.println(roleModel.toString());

        Map map = (Map) roleDao.procRole(roleModel.getRoleId(),
                roleModel.getRoleDescription(), session.getAttribute
                        ("userName").toString(), "u").get(0);

        model.addAttribute("dbResponse", map);

        return getAll(model);

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("roleId") String roleId, HttpSession session) {


        Map map = (Map) roleDao.procRole(roleId,null,  session.getAttribute("userName").toString(), "d")
                .get(0);

        model.addAttribute("dbResponse", map);

        return getAll(model);
    }


}
