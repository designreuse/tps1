package igc.tech.com.controller;

import igc.tech.com.dao.TagDao;
import igc.tech.com.mapper.TagMapper;
import igc.tech.com.model.TagModel;
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
@RequestMapping(value="/tag")
class TagController
{
	
	@Autowired
	TagDao tagDao;
	

	@RequestMapping(value="/view",method = RequestMethod.GET)
	public String view(HttpSession session, Model model)
	{	

		
		List<TagModel> tagModelList = new TagMapper().mapList(tagDao.procTag(new TagModel(), null,  "a"));
		model.addAttribute("tagList", tagModelList);
		model.addAttribute("base","tag");
		if (!model.containsAttribute("noView")) {
			model.addAttribute("mode", "view");
		}
		return "tag";
		
	}
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String add(HttpSession session, Model model)
	{	
		
		model.addAttribute("mode", "update");
		model.addAttribute("noView", "noView");

		return view(session, model);
		
	}
	

	@RequestMapping(value="/edit/{tagId}",method = RequestMethod.GET)
	public String edit(@PathVariable(value="tagId") String tagId , HttpSession session, Model model)
	{	
		TagModel tagModel = new TagModel();
		tagModel.setTagId(tagId);
		tagModel = new TagMapper().mapRow((Map) tagDao.procTag(tagModel, null,  "s").get(0));

		model.addAttribute("tagMap", tagModel);
		model.addAttribute("mode", "update");
		model.addAttribute("noView", "noView");

		return view(session, model);
		
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String edit(TagModel tagModel,
					   HttpSession session,
					   Model model, final RedirectAttributes redirectAttributes)
	{	
		if(tagModel.getActive().isEmpty()){
			tagModel.setActive(null);
		}
		Map map = new HashMap();
		if(tagModel.getTagId().isEmpty()){
			tagModel.setTagId(null);
			map = (Map) tagDao.procTag(tagModel,session.getAttribute("userName").toString(),"i").get(0);
		}else{
			map = (Map) tagDao.procTag(tagModel,session.getAttribute("userName").toString(),"u").get(0);
		}

			redirectAttributes.addFlashAttribute("response", map);
			return "redirect:../tag/view";

	}
	
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public String delete(@RequestParam("deleteId") String deleteId,
			             HttpSession session,
			             final RedirectAttributes redirectAttributes)
	{	
		String userName=session.getAttribute("userName").toString();

		TagModel tagModel = new TagModel();
		tagModel.setTagId(deleteId);
		List<Map> list=tagDao.procTag(tagModel, userName,  "d");
		Map  map=(Map)list.get(0);
		redirectAttributes.addFlashAttribute("response", map);

		return "redirect:../tag/view";
		
	}
	
}
