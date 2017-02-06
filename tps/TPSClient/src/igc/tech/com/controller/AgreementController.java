package igc.tech.com.controller;

import igc.tech.com.dao.AgreementAssignDao;
import igc.tech.com.dao.AgreementDao;
import igc.tech.com.mapper.AgreementAssignMapper;
import igc.tech.com.mapper.AgreementMapper;
import igc.tech.com.model.AgreementAssignModel;
import igc.tech.com.model.AgreementModel;
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
@RequestMapping(value="/agreement")
class AgreementController
{
	
	@Autowired
	AgreementDao agreementDao;

	@Autowired
	AgreementAssignDao agreementAssignDao;

	HashMap<String, String[]> siteContent = new HashMap<String, String[]>();

	@RequestMapping(value="/view",method = RequestMethod.GET)
	public String view(HttpSession session, Model model)
	{	

		
		List<AgreementModel> agreementModelList = new AgreementMapper().mapList(agreementDao.procAgreement(new AgreementModel(), null,  "a"));
		model.addAttribute("agreementList", agreementModelList);
		model.addAttribute("base","agreement");

		siteContent.put("css", new String[]{"summernote/summernote.css","summernote/summernote-bs3.css"});
		siteContent.put("js", new String[]{"summernote/summernote.min.js"});
		model.addAttribute("siteContent", siteContent);

		if (!model.containsAttribute("noView")) {
			model.addAttribute("mode", "view");
		}
		return "agreements";
		
	}
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String add(HttpSession session, Model model)
	{	
		
		model.addAttribute("mode", "update");
		model.addAttribute("noView", "noView");

		List<AgreementAssignModel> agreementAssignModelList = new AgreementAssignMapper().mapList(agreementAssignDao.procAgreementAssign(new AgreementAssignModel(), null, "b"));
		model.addAttribute("agreementAssignList", agreementAssignModelList);

		return view(session, model);
		
	}
	

	@RequestMapping(value="/edit/{agreementId}",method = RequestMethod.GET)
	public String edit(@PathVariable(value="agreementId") String agreementId , HttpSession session, Model model)
	{	
		AgreementModel agreementModel = new AgreementModel();
		agreementModel.setAgreementId(agreementId);
		agreementModel = new AgreementMapper().mapRow((Map) agreementDao.procAgreement(agreementModel, null,  "s").get(0));
		model.addAttribute("agreementMap", agreementModel);

		AgreementAssignModel agreementAssignModel = new AgreementAssignModel();
		agreementAssignModel.setAgreementId(agreementId);
		List<AgreementAssignModel> agreementAssignModelList = new AgreementAssignMapper().mapList(agreementAssignDao.procAgreementAssign(agreementAssignModel, null, "b"));
		model.addAttribute("agreementAssignList", agreementAssignModelList);

		model.addAttribute("mode", "update");
		model.addAttribute("noView", "noView");

		return view(session, model);
		
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String edit(AgreementModel agreementModel, AgreementAssignModel agreementAssignModel,
					   HttpSession session,
					   Model model, final RedirectAttributes redirectAttributes)
	{	
		String userName=session.getAttribute("userName").toString();
//		String userName="ganga";
		Map map = new HashMap();
		if(agreementModel.getAgreementId().isEmpty()){
			agreementModel.setAgreementId(null);
			map = (Map) agreementDao.procAgreement(agreementModel,session.getAttribute("userName").toString(),"i").get(0);
			agreementAssignModel.setAgreementId(map.get("agreement_id").toString());
		}else{
			map = (Map) agreementDao.procAgreement(agreementModel,session.getAttribute("userName").toString(),"u").get(0);
		}

		if(!agreementAssignModel.getAgreementAssignId().isEmpty()){
			map =(Map) agreementAssignDao.procAgreementAssign(agreementAssignModel,session.getAttribute("userName").toString(),"u").get(0);
		}



			redirectAttributes.addFlashAttribute("response", map);
			return "redirect:../agreement/view";

	}
	
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public String delete(@RequestParam("deleteId") String deleteId,
			             HttpSession session,
			             final RedirectAttributes redirectAttributes)
	{	
		String userName=session.getAttribute("userName").toString();

		AgreementModel agreementModel = new AgreementModel();
		agreementModel.setAgreementId(deleteId);
		List<Map> list=agreementDao.procAgreement(agreementModel, userName,  "d");
		Map  map=(Map)list.get(0);
		redirectAttributes.addFlashAttribute("response", map);

		return "redirect:../agreement/view";
		
	}
	
}
