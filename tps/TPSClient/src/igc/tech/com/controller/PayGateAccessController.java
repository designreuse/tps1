package igc.tech.com.controller;

import com.google.gson.Gson;
import igc.tech.com.dao.PayGateAccessDao;
import igc.tech.com.mapper.PayGateAccessMapper;
import igc.tech.com.mapper.EasyTreeMapper;
import igc.tech.com.mapper.PayGateAccessMapper;
import igc.tech.com.model.PayGateAccessModel;
import igc.tech.com.model.PayGateAccessModel;
import igc.tech.com.model.EasyTreeModel;
import igc.tech.com.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Ganga on 6/14/2016.
 */

@Controller
@RequestMapping(value = "/payGateAccess")
public class PayGateAccessController {

    @Autowired
    PayGateAccessDao payGateAccessDao;

    static final String imageBaseUrl = System.getProperty("catalina.home") + "/webapps/TPSResources/icons/";

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(Model model, HttpSession session){

        List<PayGateAccessModel> payGateAccessModelList = new PayGateAccessMapper().mapList(payGateAccessDao.procPayGateAccess(new PayGateAccessModel(),null,"a"));
        model.addAttribute("payGateAccessList", payGateAccessModelList);
        model.addAttribute("base", "payGateAccess");


        return "payGateAccess";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(HttpSession session, PayGateAccessModel payGateAccessModel, HttpServletResponse response) throws Exception{

       /* PayGateAccessModel payGateAccessModel = new PayGateAccessModel();
        payGateAccessModel.setActive("N");*/

        Map map = (Map) payGateAccessDao.procPayGateAccess(payGateAccessModel,session.getAttribute("userName").toString(), "u").get(0);

      /*  for(int i=0;i<active.length;i++){
            payGateAccessModel.setActive("Y");
            payGateAccessModel.setPayGateAccessId(active[i]);
            Map map = (Map) payGateAccessDao.procPayGateAccess(payGateAccessModel,session.getAttribute("userName").toString(), "u").get(0);
        }*/
        String json = new Gson().toJson(map);
        return json;
        /*response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

        return view(model,session);*/
    }

    @RequestMapping(value = "/iconUpload", method = RequestMethod.POST)
    public String iconUpload(HttpSession session, PayGateAccessModel payGateAccessModel,MultipartHttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception{

        Map<String, MultipartFile> fileMap = request.getFileMap();

        Utility util = new Utility();
        String saveDirectory = imageBaseUrl;
        File file = new File(imageBaseUrl );
        String newFileName ="";

        if (!file.exists()) {
            file.mkdir();
        }

        for (MultipartFile multipartFile : fileMap.values()) {
                double random = Math.random() * 50 + 1;

                String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Calendar.getInstance().getTime());
//                System.out.println("content type: "+multipartFile.getContentType());

                newFileName = util.generateFileName(multipartFile, payGateAccessModel.getType());
//                String imageType = multipartFile.getContentType().substring(multipartFile.getContentType().lastIndexOf("/")+1);
//                System.out.println("type"+ imageType);

                multipartFile.transferTo(new File(saveDirectory + newFileName));
           


        }

        payGateAccessModel.setImage(newFileName);
        Map map = new HashMap();
        map = (Map) payGateAccessDao.procPayGateAccess(payGateAccessModel,session.getAttribute("userName").toString(), "u").get(0);


        redirectAttributes.addFlashAttribute("id", map.get("pay_gate_access_id"));
        redirectAttributes.addFlashAttribute("response",map);
       /* String json = new Gson().toJson("ganga");
        return json;*/
        return "redirect:../payGateAccess/view";
    }

}
