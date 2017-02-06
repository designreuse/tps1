package igc.tech.com.controller;

import igc.tech.com.dao.EmailTpsDao;
import igc.tech.com.mapper.EmailTpsMapper;
import igc.tech.com.model.EmailTpsModel;
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
@RequestMapping(value="/emailTps")
class EmailTpsController
{
	
	@Autowired
	EmailTpsDao emailTpsDao;
	

	@RequestMapping(value="/view",method = RequestMethod.GET)
	public String view(HttpSession session, Model model)
	{	

		
		List<EmailTpsModel> emailTpsModelList = new EmailTpsMapper().mapList(emailTpsDao.procEmailTps(new EmailTpsModel(), null,  "a"));
		model.addAttribute("emailTpsList", emailTpsModelList);
		model.addAttribute("base","emailTps");
		if (!model.containsAttribute("noView")) {
			model.addAttribute("mode", "view");
		}
		return "emailTps";
		
	}
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String add(HttpSession session, Model model)
	{	
		
		model.addAttribute("mode", "update");
		model.addAttribute("noView", "noView");

		return view(session, model);
		
	}
	

	@RequestMapping(value="/edit/{emailTpsId}",method = RequestMethod.GET)
	public String edit(@PathVariable(value="emailTpsId") String emailTpsId , HttpSession session, Model model)
	{	
		EmailTpsModel emailTpsModel = new EmailTpsModel();
		emailTpsModel.setEmailTpsId(emailTpsId);
		emailTpsModel = new EmailTpsMapper().mapRow((Map) emailTpsDao.procEmailTps(emailTpsModel, null,  "s").get(0));

		model.addAttribute("emailTpsMap", emailTpsModel);
		model.addAttribute("mode", "update");
		model.addAttribute("noView", "noView");

		return view(session, model);
		
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String edit(EmailTpsModel emailTpsModel,
					   HttpSession session,
					   Model model, final RedirectAttributes redirectAttributes)
	{	
//		String userName="ganga";
		Map map = new HashMap();
		if(emailTpsModel.getActive()==null){
			emailTpsModel.setActive("N");
		}
		if(emailTpsModel.getEmailTpsId().isEmpty()){
			emailTpsModel.setEmailTpsId(null);
			map = (Map) emailTpsDao.procEmailTps(emailTpsModel,session.getAttribute("userName").toString(),"i").get(0);
		}else{
			map = (Map) emailTpsDao.procEmailTps(emailTpsModel,session.getAttribute("userName").toString(),"u").get(0);
		}

			redirectAttributes.addFlashAttribute("response", map);
			return "redirect:../emailTps/view";

	}
	
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public String delete(@RequestParam("deleteId") String deleteId,
			             HttpSession session,
			             final RedirectAttributes redirectAttributes)
	{	
		String userName=session.getAttribute("userName").toString();

		EmailTpsModel emailTpsModel = new EmailTpsModel();
		emailTpsModel.setEmailTpsId(deleteId);
		List<Map> list=emailTpsDao.procEmailTps(emailTpsModel, userName,  "d");
		Map  map=(Map)list.get(0);
		redirectAttributes.addFlashAttribute("response", map);

		return "redirect:../emailTps/view";
		
	}
	
}
