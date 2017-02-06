package igc.tech.com.controller;

import igc.tech.com.dao.HotelReviewCategoryDao;
import igc.tech.com.mapper.HotelReviewCategoryMapper;
import igc.tech.com.model.HotelReviewCategoryModel;
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
@RequestMapping(value="/hotelReviewCategory")
class HotelReviewCategoryController
{
	
	@Autowired
	HotelReviewCategoryDao hotelReviewCategoryDao;
	

	@RequestMapping(value="/view",method = RequestMethod.GET)
	public String view(HttpSession session, Model model)
	{

		List<HotelReviewCategoryModel> hotelReviewCategoryModelList = new HotelReviewCategoryMapper().mapList(hotelReviewCategoryDao.procHotelReviewCategory(new HotelReviewCategoryModel(), null,  "a"));
		model.addAttribute("hotelReviewCategoryList", hotelReviewCategoryModelList);
		model.addAttribute("base","hotelReviewCategory");
		if (!model.containsAttribute("noView")) {
			model.addAttribute("mode", "view");
		}
		return "hotelReviewCategory";
		
	}
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String add(HttpSession session, Model model)
	{	
		
		model.addAttribute("mode", "update");
		model.addAttribute("noView", "noView");

		return view(session, model);
		
	}
	

	@RequestMapping(value="/edit/{hotelReviewCategoryId}",method = RequestMethod.GET)
	public String edit(@PathVariable(value="hotelReviewCategoryId") String hotelReviewCategoryId , HttpSession session, Model model)
	{	
		HotelReviewCategoryModel hotelReviewCategoryModel = new HotelReviewCategoryModel();
		hotelReviewCategoryModel.setHotelReviewCategoryId(hotelReviewCategoryId);
		hotelReviewCategoryModel = new HotelReviewCategoryMapper().mapRow((Map) hotelReviewCategoryDao.procHotelReviewCategory(hotelReviewCategoryModel, null,  "s").get(0));

		model.addAttribute("hotelReviewCategoryMap", hotelReviewCategoryModel);
		model.addAttribute("mode", "update");
		model.addAttribute("noView", "noView");

		return view(session, model);
		
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String edit(HotelReviewCategoryModel hotelReviewCategoryModel,
					   HttpSession session,
					   Model model, final RedirectAttributes redirectAttributes)
	{	
		if(hotelReviewCategoryModel.getActive().isEmpty()){
			hotelReviewCategoryModel.setActive(null);
		}
		Map map = new HashMap();
		if(hotelReviewCategoryModel.getHotelReviewCategoryId().isEmpty()){
			hotelReviewCategoryModel.setHotelReviewCategoryId(null);
			map = (Map) hotelReviewCategoryDao.procHotelReviewCategory(hotelReviewCategoryModel,session.getAttribute("userName").toString(),"i").get(0);
		}else{
			map = (Map) hotelReviewCategoryDao.procHotelReviewCategory(hotelReviewCategoryModel,session.getAttribute("userName").toString(),"u").get(0);
		}

			redirectAttributes.addFlashAttribute("response", map);
			return "redirect:../hotelReviewCategory/view";

	}
	
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public String delete(@RequestParam("deleteId") String deleteId,
			             HttpSession session,
			             final RedirectAttributes redirectAttributes)
	{	
		String userName=session.getAttribute("userName").toString();

		HotelReviewCategoryModel hotelReviewCategoryModel = new HotelReviewCategoryModel();
		hotelReviewCategoryModel.setHotelReviewCategoryId(deleteId);
		List<Map> list=hotelReviewCategoryDao.procHotelReviewCategory(hotelReviewCategoryModel, userName,  "d");
		Map  map=(Map)list.get(0);
		redirectAttributes.addFlashAttribute("response", map);

		return "redirect:../hotelReviewCategory/view";
		
	}
	
}
