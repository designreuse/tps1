package igc.tech.com.controller;

import com.google.gson.Gson;
import com.sun.deploy.net.HttpResponse;
import igc.tech.com.dao.MenuAccessDao;
import igc.tech.com.dao.MenuDao;
import igc.tech.com.dao.RoleDao;
import igc.tech.com.mapper.MenuAccessMapper;
import igc.tech.com.mapper.RoleMapper;
import igc.tech.com.model.MenuAccessModel;
import igc.tech.com.model.MenuModel;
import igc.tech.com.model.RoleModel;
import igc.tech.com.model.MenuAccessModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.*;
import java.util.List;

@Controller
@RequestMapping(value = "/menuAccess")
class MenuAccessController {

	@Autowired
	MenuDao menuDao;

	@Autowired
	RoleDao roleDao;

	@Autowired
	MenuAccessDao menuAccessDao;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(HttpSession session, Model model) {

		List<RoleModel> list = new RoleMapper().mapList(roleDao.procRole(new RoleModel(), null, "a"));
		model.addAttribute("base", "menuAccess");
		model.addAttribute("roleList", list);
		return "menuAccess";

	}

	@RequestMapping(value = "/menuList", method = RequestMethod.POST)
	@ResponseBody
	public String menuList(HttpSession session, String roleId, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception{
		MenuAccessModel menuAccessModel = new MenuAccessModel();
		menuAccessModel.setRoleId(roleId);
		List<MenuAccessModel> menuAccessList = new MenuAccessMapper().mapList(menuAccessDao.procMenuAccess(menuAccessModel, null, "b"));

		System.out.println(menuAccessList);
//		model.addAttribute("menuAccessList", menuAccessList);
		String json = new Gson().toJson(menuAccessList);

		redirectAttributes.addFlashAttribute("menuList",json);
		return json;


//		return "redirect:../menuAccess/view";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	@ResponseBody
	public String menuList(HttpSession session, String roleId, String[] menuId, String[] menuAccessId, String[] active, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception{


		Map map = new HashMap();
		if (Arrays.asList(menuAccessId).contains("")) {
			for (int i = 0; i < menuAccessId.length; i++) {

				MenuAccessModel menuAccessModel = new MenuAccessModel();
				menuAccessModel.setMenuId(menuId[i]);
				menuAccessModel.setRoleId(roleId);
                /*check rules already inserted into hotel_rules table or not---- if not then insert into hotel_rules*/
				List<Map> list = menuAccessDao.procMenuAccess(menuAccessModel, null,"s");

				if (list.isEmpty()) {
//					menuAccessModel.setActive("N");

					map = (Map) menuAccessDao.procMenuAccess(menuAccessModel, session.getAttribute("userName").toString(), "i").get(0);
					MenuAccessModel menuModel1 = new MenuAccessModel();
					menuModel1.setMenuId(menuId[i]);
					List menuList = menuAccessDao.procMenuAccess(menuModel1,null,"c");
					System.out.println(menuList);
					if(!menuList.isEmpty()){
						for(int j =0; j<menuList.size(); j++){
							map = (Map) menuList.get(j);
							menuAccessModel.setMenuId(map.get("menu_id").toString());
							map = (Map) menuAccessDao.procMenuAccess(menuAccessModel, session.getAttribute("userName").toString(), "i").get(0);
						}
					}
				}



			}
		}

        /*set active to 'N' in hotel_rules whose hotel_detail_id is hotelDetailId*/
		MenuAccessModel menuAccessModel = new MenuAccessModel();
		menuAccessModel.setRoleId(roleId);
//		menuAccessModel.setActive("N");

		map = (Map) menuAccessDao.procMenuAccess(menuAccessModel , session.getAttribute("userName").toString().toString(), "d").get(0);

        /*update active to 'Y' whose populare_place_id and hotel_detail_id as specified*/

		if(active!=null){
			for (int i = 0; i < active.length; i++) {
            /*in active array the value is populare_place_id*/
				menuAccessModel.setMenuId(active[i]);
//			menuAccessModel.setActive("Y");


				map = (Map) menuAccessDao.procMenuAccess(menuAccessModel, session.getAttribute("userName").toString(), "u").get(0);

				MenuAccessModel menuModel1 = new MenuAccessModel();
				menuModel1.setMenuId(active[i]);
				List menuList = menuAccessDao.procMenuAccess(menuModel1,null,"c");
				if(!menuList.isEmpty()){
					for(int j =0; j<menuList.size(); j++){
						map = (Map) menuList.get(j);
						menuAccessModel.setMenuId(map.get("menu_id").toString());
						map = (Map) menuAccessDao.procMenuAccess(menuAccessModel, session.getAttribute("userName").toString(), "u").get(0);
					}
				}
//			System.out.println(map);
			}
		}



		redirectAttributes.addFlashAttribute("response", map);
		redirectAttributes.addFlashAttribute("roleId", roleId);
		menuList(session, roleId, response, redirectAttributes);
		return "redirect:../menuAccess/view";
		/*MenuAccessModel menuAccessModel = new MenuAccessModel();
		menuAccessModel.setRoleId(roleId);
		menuAccessModel.setMenuId(menuId);

		Map map = new HashMap();

			List list = menuAccessDao.procMenuAccess(menuAccessModel,null,"s");
			if(list.isEmpty() && active.equals("Y")){
				map = (Map) menuAccessDao.procMenuAccess(menuAccessModel,session.getAttribute("userName").toString(),"i").get(0);
			}else if(!list.isEmpty() && active.equals("Y")){
//				map = (Map) list.get(0);
				map = (Map) menuAccessDao.procMenuAccess(menuAccessModel,session.getAttribute("userName").toString(),"u").get(0);
			}else{
				map = (Map) menuAccessDao.procMenuAccess(menuAccessModel,session.getAttribute("userName").toString(),"d").get(0);
			}


		String json = new Gson().toJson(map);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);*/
	}
	


}