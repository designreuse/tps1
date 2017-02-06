package igc.tech.com.controller;

import igc.tech.com.dao.RoleDao;
import igc.tech.com.dao.UserDetailDao;
import igc.tech.com.mapper.RoleMapper;
import igc.tech.com.mapper.UserDetailMapper;
import igc.tech.com.model.RoleModel;
import igc.tech.com.model.UserDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value="/userDetail")
class UserDetailController
{
	
	@Autowired
	UserDetailDao userDetailDao;

	@Autowired
	RoleDao roleDao;
	

	@RequestMapping(value="/view",method = RequestMethod.GET)
	public String view(HttpSession session, Model model)
	{	

		
		List<UserDetailModel> userDetailModelList = new UserDetailMapper().mapList(userDetailDao.procUserDetail(new UserDetailModel(), null,  "a"));
		model.addAttribute("userDetailList", userDetailModelList);
		model.addAttribute("base","userDetail");
		if (!model.containsAttribute("noView")) {
			model.addAttribute("mode", "view");
		}
		return "userDetail";
		
	}
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String add(HttpSession session, Model model)
	{	
		List<RoleModel> roleModelList = new RoleMapper().mapList(roleDao.procRole(new RoleModel(),null,"a"));
		model.addAttribute("roleList", roleModelList);
		model.addAttribute("mode", "update");
		model.addAttribute("noView", "noView");

		return view(session, model);
		
	}
	

	@RequestMapping(value="/edit/{userDetailId}",method = RequestMethod.GET)
	public String edit(@PathVariable(value="userDetailId") String userDetailId , HttpSession session, Model model)
	{	
		UserDetailModel userDetailModel = new UserDetailModel();
		userDetailModel.setUserDetailId(userDetailId);
		userDetailModel = new UserDetailMapper().mapRow((Map) userDetailDao.procUserDetail(userDetailModel, null,  "s").get(0));
		model.addAttribute("userDetailMap", userDetailModel);

		List<RoleModel> roleModelList = new RoleMapper().mapList(roleDao.procRole(new RoleModel(),null,"a"));
		model.addAttribute("roleList", roleModelList);

		model.addAttribute("mode", "update");
		model.addAttribute("noView", "noView");

		return view(session, model);
		
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String edit(UserDetailModel userDetailModel,
					   HttpSession session,
					   Model model, final RedirectAttributes redirectAttributes)
	{
		if(userDetailModel.getActive()==null||userDetailModel.getActive().isEmpty()){
			userDetailModel.setActive("0");
		}
		Map map = new HashMap();
		if(userDetailModel.getUserDetailId().isEmpty()){
			userDetailModel.setUserDetailId(null);
			map = (Map) userDetailDao.procUserDetail(userDetailModel,session.getAttribute("userName").toString(),"i").get(0);
		}else{
			map = (Map) userDetailDao.procUserDetail(userDetailModel,session.getAttribute("userName").toString(),"u").get(0);
		}

			redirectAttributes.addFlashAttribute("response", map);
			return "redirect:../userDetail/view";

	}
	
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public String delete(@RequestParam("deleteId") String deleteId,
			             HttpSession session,
			             final RedirectAttributes redirectAttributes)
	{	
		String userName=session.getAttribute("userName").toString();

		UserDetailModel userDetailModel = new UserDetailModel();
		userDetailModel.setUserDetailId(deleteId);
		List<Map> list=userDetailDao.procUserDetail(userDetailModel, userName,  "d");
		Map  map=(Map)list.get(0);
		redirectAttributes.addFlashAttribute("response", map);
		
		return "redirect:../userDetail/view";
		
	}


}
