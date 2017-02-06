package igc.tech.com.controller;

import com.google.gson.Gson;
import igc.tech.com.dao.ContentCommentDao;
import igc.tech.com.mapper.ContentCommentMapper;
import igc.tech.com.model.ContentCommentModel;
import igc.tech.com.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ganga on 6/14/2016.
 */

@Controller
@RequestMapping(value = "/contentComment")
public class ContentCommentController {

    @Autowired
    ContentCommentDao contentCommentDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(Model model, HttpSession session){

        List<ContentCommentModel> contentCommentModelList = new ContentCommentMapper().mapList(contentCommentDao.procContentComment(new ContentCommentModel(),null,"a"));
        model.addAttribute("contentCommentList", contentCommentModelList);
        model.addAttribute("base", "contentComment");


        return "contentComment";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(HttpSession session, ContentCommentModel contentCommentModel, HttpServletResponse response) throws Exception{


        Map map = (Map) contentCommentDao.procContentComment(contentCommentModel,session.getAttribute("userName").toString(), "u").get(0);

        String json = new Gson().toJson(map);
        return json;
    }


}
