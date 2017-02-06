package igc.tech.com.controller;

import igc.tech.com.dao.MenuAccessDao;
import igc.tech.com.dao.MenuDao;
import igc.tech.com.dao.RoleDao;
import igc.tech.com.mapper.RoleMapper;
import igc.tech.com.model.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value="/role")
class RoleController
{
	
	@Autowired
	RoleDao roleDao;
	

	@RequestMapping(value="/view",method = RequestMethod.GET)
	public String view(HttpSession session, Model model)
	{	

		
		List<RoleModel> roleModelList = new RoleMapper().mapList(roleDao.procRole(new RoleModel(), null,  "a"));
		model.addAttribute("roleList", roleModelList);
		model.addAttribute("base","role");
		if (!model.containsAttribute("noView")) {
			model.addAttribute("mode", "view");
		}
		return "role";
		
	}
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String add(HttpSession session, Model model)
	{	
		
		model.addAttribute("mode", "update");
		model.addAttribute("noView", "noView");

		return view(session, model);
		
	}
	

	@RequestMapping(value="/edit/{roleId}",method = RequestMethod.GET)
	public String edit(@PathVariable(value="roleId") String roleId , HttpSession session, Model model)
	{	
		RoleModel roleModel = new RoleModel();
		roleModel.setRoleId(roleId);
		roleModel = new RoleMapper().mapRow((Map) roleDao.procRole(roleModel, null,  "s").get(0));

		model.addAttribute("roleMap", roleModel);
		model.addAttribute("mode", "update");
		model.addAttribute("noView", "noView");

		return view(session, model);
		
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String edit(RoleModel roleModel,
					   HttpSession session,
					   Model model, final RedirectAttributes redirectAttributes)
	{	
		String userName=session.getAttribute("userName").toString();
//		String userName="ganga";
		Map map = new HashMap();
		if(roleModel.getRoleId().isEmpty()){
			roleModel.setRoleId(null);
			map = (Map) roleDao.procRole(roleModel,session.getAttribute("userName").toString(),"i").get(0);
		}else{
			map = (Map) roleDao.procRole(roleModel,session.getAttribute("userName").toString(),"u").get(0);
		}

			redirectAttributes.addFlashAttribute("response", map);
			return "redirect:../role/view";

	}
	
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public String delete(@RequestParam("deleteId") String deleteId,
			             HttpSession session,
			             final RedirectAttributes redirectAttributes)
	{	
		String userName=session.getAttribute("userName").toString();

		RoleModel roleModel = new RoleModel();
		roleModel.setRoleId(deleteId);
		List<Map> list=roleDao.procRole(roleModel, userName,  "d");
		Map  map=(Map)list.get(0);
		redirectAttributes.addFlashAttribute("response", map);

		return "redirect:../role/view";
		
	}
	
}
