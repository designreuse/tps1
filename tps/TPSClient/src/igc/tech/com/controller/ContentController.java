package igc.tech.com.controller;

import com.google.gson.Gson;
import igc.tech.com.dao.ContentDao;
import igc.tech.com.dao.ContentTagDao;
import igc.tech.com.dao.TagDao;
import igc.tech.com.mapper.ContentMapper;
import igc.tech.com.mapper.ContentTagMapper;
import igc.tech.com.mapper.EasyTreeMapper;
import igc.tech.com.mapper.TagMapper;
import igc.tech.com.model.ContentModel;
import igc.tech.com.model.ContentTagModel;
import igc.tech.com.model.EasyTreeModel;
import igc.tech.com.model.TagModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;

/**
 * Created by Ganga on 6/14/2016.
 */

@Controller
@RequestMapping(value = "/content")
public class ContentController {

    @Autowired
    ContentDao contentDao;

    @Autowired
    TagDao tagDao;

    @Autowired
    ContentTagDao contentTagDao;

    HashMap<String, String[]> siteContent = new HashMap<String, String[]>();

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(Model model, HttpSession session){

       List<ContentModel> contentModelList = new ContentMapper().mapList(contentDao.procContent(new ContentModel(), null,"a"));
        model.addAttribute("contentList", contentModelList);

        List<TagModel> tagModelList = new TagMapper().mapList(tagDao.procTag(new TagModel(), null, "a"));
        model.addAttribute("tagList", tagModelList);
        siteContent.put("css", new String[]{"summernote/summernote.css","summernote/summernote-bs3.css","select2/select2.min.css"});
        siteContent.put("js", new String[]{"summernote/summernote.min.js", "select2/select2.full.min.js"});
        model.addAttribute("siteContent", siteContent);

        model.addAttribute("base", "content");
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }
        return "content";
    }

    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(Model model, HttpSession session)
    {

        model.addAttribute("mode", "update");
        model.addAttribute("noView", "noView");

        return view(model, session);

    }

    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)
    public String edit(Model model, HttpSession session, @PathVariable("id") String contentId)
    {

        ContentModel contentModel = new ContentModel();
        contentModel.setContentId(contentId);
        contentModel = new ContentMapper().mapRow((Map) contentDao.procContent(contentModel, null, "s").get(0));
        model.addAttribute("contentMap", contentModel);

        ContentTagModel contentTagModel = new ContentTagModel();
        contentTagModel.setContentId(contentId);
        List<ContentTagModel> contentTagModelList = new ContentTagMapper().mapList(contentTagDao.procContentTag(contentTagModel, null, "s"));
        /*List<String> selectedContentTag = new ArrayList<>();
        for(ContentTagModel contentTagModel1: contentTagModelList){
            selectedContentTag.add(contentTagModel1.getTagId());
        }*/
        model.addAttribute("selectedContentTag",contentTagModelList);

        model.addAttribute("mode", "update");
        model.addAttribute("noView", "noView");

        return view(model, session);

    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String edit(ContentModel contentModel, String[] tagList, String newTags,
                       HttpSession session,
                       final RedirectAttributes redirectAttributes)
    {

        Map map = new HashMap();
        if(contentModel.getContentId().isEmpty()){
            contentModel.setContentId(null);
            map = (Map) contentDao.procContent(contentModel,session.getAttribute("userName").toString(),"i").get(0);
            contentModel.setContentId(map.get("content_id").toString());
        }else{
            map = (Map) contentDao.procContent(contentModel,session.getAttribute("userName").toString(),"u").get(0);
        }

        List list = new ArrayList<>(Arrays.asList(tagList));

        List<String> newTagList = Arrays.asList(newTags.split(","));
        if(!newTags.isEmpty()){
            TagModel tagModel = new TagModel();
            for(String tagName: newTagList){
                tagModel.setActive("Y");
                tagModel.setDescription(tagName.trim());
                map = (Map) tagDao.procTag(tagModel,session.getAttribute("userName").toString(),"i").get(0);
                list.add(map.get("tag_id").toString());
            }
        }


        ContentTagModel contentTagModel = new ContentTagModel();
        contentTagModel.setContentId(contentModel.getContentId());


        Collection list1 = new ArrayList();
        List<ContentTagModel> contentTagModelList = new ContentTagMapper().mapList(contentTagDao.procContentTag(contentTagModel, null, "s"));
        for(ContentTagModel contentTagModel1: contentTagModelList){
            list1.add(contentTagModel1.getTagId());
           if(!list.contains(contentTagModel1.getTagId())){
               contentTagModel.setTagId(contentTagModel1.getTagId());
               contentTagDao.procContentTag(contentTagModel, null, "d");
           }
        }

        list.removeAll(list1);
        for(int i=0;i<list.size();i++){
            contentTagModel.setTagId(list.get(i).toString());
            contentTagDao.procContentTag(contentTagModel, null, "i");
        }

        redirectAttributes.addFlashAttribute("response", map);
        return "redirect:../content/view";

    }

    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public String delete(@RequestParam("deleteId") String deleteId,
                         HttpSession session,
                         final RedirectAttributes redirectAttributes)
    {
        String userName=session.getAttribute("userName").toString();

        ContentModel contentModel = new ContentModel();
        contentModel.setContentId(deleteId);
        List<Map> list=contentDao.procContent(contentModel, userName,  "d");
        Map  map=(Map)list.get(0);
        redirectAttributes.addFlashAttribute("response", map);

        return "redirect:../content/view";

    }

}
