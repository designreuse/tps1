package igc.tech.com.controller;

import com.google.gson.Gson;
import igc.tech.com.dao.*;
import igc.tech.com.mapper.MailServerSettingMapper;
import igc.tech.com.model.MailServerSettingModel;
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

@Controller
@RequestMapping(value = "/mailServerSetting")
class MailServerSettingController {

	@Autowired
	MailServerSettingDao mailServerSettingDao;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(HttpSession session, Model model) {

		List<MailServerSettingModel> list = new MailServerSettingMapper().mapList(mailServerSettingDao.procMailServerSetting(new MailServerSettingModel(),null, "a"));
		model.addAttribute("mailServerSettingList", list);
		model.addAttribute("base", "mailServerSetting");
		if (!model.containsAttribute("noView")) {
			model.addAttribute("mode", "view");
		}
		
		/*list = roleDao.procRole(null, null, null, "a");
		model.addAttribute("dataListRoleDet", list);*/
		return "mailServerSetting";

	}

	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String add(HttpSession session, Model model)
	{

		model.addAttribute("mode", "update");
		model.addAttribute("noView", "noView");
		return view(session,model);

	}

	@RequestMapping(value="/edit/{mailServerSettingId}",method = RequestMethod.GET)
	public String edit(@PathVariable(value="mailServerSettingId") String mailServerSettingId , HttpSession session, Model model)
	{

		MailServerSettingModel mailServerSettingModel = new MailServerSettingModel();
		mailServerSettingModel.setMailServerSettingId(mailServerSettingId);
		mailServerSettingModel =  new MailServerSettingMapper().mapRow((Map) mailServerSettingDao.procMailServerSetting(mailServerSettingModel,null, "s").get(0));

		model.addAttribute("mailServerSettingMap", mailServerSettingModel);
		model.addAttribute("noView", "noView");
		model.addAttribute("mode", "update");
		return view(session, model);

	}

	@RequestMapping(value="update",method = RequestMethod.POST)
	public String update(HttpSession session, RedirectAttributes redirectAttributes,MailServerSettingModel mailServerSettingModel)
	{
Map map = new HashMap();
		if(mailServerSettingModel.getMailServerSettingId().isEmpty()){
			mailServerSettingModel.setMailServerSettingId(null);
			map = (Map) mailServerSettingDao.procMailServerSetting(mailServerSettingModel,session.getAttribute("userName").toString(),"i").get(0);
		}else{
			map = (Map) mailServerSettingDao.procMailServerSetting(mailServerSettingModel,session.getAttribute("userName").toString(),"u").get(0);
		}
		redirectAttributes.addFlashAttribute("response",map);
		return "redirect:../mailServerSetting/view";

	}

	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public String delete(@RequestParam(value="deleteId") String id ,
						 HttpSession session,
						 Model model, RedirectAttributes redirectAttributes)
	{
		MailServerSettingModel mailServerSettingModel = new MailServerSettingModel();
		mailServerSettingModel.setMailServerSettingId(id);
		List<Map> list=mailServerSettingDao.procMailServerSetting(mailServerSettingModel, session.getAttribute("userName").toString(), "d");

		Map  map=(Map)list.get(0);

		redirectAttributes.addFlashAttribute("response", map);
		return "redirect:../mailServerSetting/view";

	}

	@RequestMapping(value = "/activate", method = RequestMethod.POST)
	@ResponseBody
	public String delete(HttpSession session, @RequestParam("mailServerSettingId") String mailServerSettingId, HttpServletResponse response) throws Exception{

		MailServerSettingModel mailServerSettingModel = new MailServerSettingModel();
		mailServerSettingModel.setActive("N");
		Map map = (Map) mailServerSettingDao.procMailServerSetting(mailServerSettingModel, session.getAttribute("userName").toString(), "u").get(0);

		mailServerSettingModel.setMailServerSettingId(mailServerSettingId);
		mailServerSettingModel.setActive("Y");
		map = (Map) mailServerSettingDao.procMailServerSetting(mailServerSettingModel, session.getAttribute("userName").toString(), "u").get(0);

		String json = new Gson().toJson(map);
		return json;
	}
	
}