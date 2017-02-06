package igc.tech.com.controller;

import igc.tech.com.dao.CancellationDao;
import igc.tech.com.dao.PaymentTypeDao;
import igc.tech.com.mapper.CancellationMapper;
import igc.tech.com.mapper.PaymentTypeMapper;
import igc.tech.com.model.CancellationModel;
import igc.tech.com.model.PaymentTypeModel;
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
import java.util.List;
import java.util.Map;

/**
 * Created by Ganga on 5/20/2016.
 */
@Controller
@RequestMapping(value = "/cancellation")
public class CancellationController {

    @Autowired
    CancellationDao cancellationDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model, HttpSession session) {

        CancellationModel cancellationModel = new CancellationModel();
        cancellationModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());

        List<CancellationModel> cancellationModelList=new CancellationMapper().mapList(cancellationDao.procCancellation(cancellationModel,null,"s"));
        model.addAttribute("cancellationList",cancellationModelList);

        List list = new ArrayList();
        for(CancellationModel cancellationModel1: cancellationModelList){
            list.add(cancellationModel1.getFreeCancellationBefore());
        }
        model.addAttribute("cancellationBefore", list);
        model.addAttribute("base", "cancellation");
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }

        return "cancellation";

    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String add(HttpSession session, Model model){
        model.addAttribute("mode", "update");
        model.addAttribute("noView", "noView");

        return getAll(model,session);
    }

    @RequestMapping(value="/edit/{cancellationId}", method = RequestMethod.GET)
    public String edit(HttpSession session, Model model, @PathVariable("cancellationId") String cancellaitonId){
        CancellationModel cancellationModel = new CancellationModel();
//        cancellationModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());
        cancellationModel.setCancellationId(cancellaitonId);
//        List list = cancellationDao.procCancellation(cancellationModel,null,"s");
        cancellationModel=new CancellationMapper().mapRow((Map) cancellationDao.procCancellation(cancellationModel,null,"s").get(0));
        model.addAttribute("cancellationMap",cancellationModel);

        model.addAttribute("mode", "update");
        model.addAttribute("noView", "noView");

        return getAll(model,session);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(HttpSession session, CancellationModel cancellationModel, RedirectAttributes redirectAttributes) {

        if(cancellationModel.getCancellationId().isEmpty()){
            cancellationModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());
            cancellationModel.setCancellationId(null);
            Map map = (Map) cancellationDao.procCancellation(cancellationModel,session.getAttribute("userName").toString(),"i").get(0);
            redirectAttributes.addFlashAttribute("response", map);
        }else{
            cancellationModel.setHotelDetailId(null);
            Map map = (Map) cancellationDao.procCancellation(cancellationModel,session.getAttribute("userName").toString(),"u").get(0);
            redirectAttributes.addFlashAttribute("response", map);
        }



        return "redirect:view";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("deleteId") String deleteId,
                         HttpSession session,
                         final RedirectAttributes redirectAttributes)
    {

        CancellationModel cancellationModel = new CancellationModel();
        cancellationModel.setCancellationId(deleteId);

        Map map = (Map) cancellationDao.procCancellation(cancellationModel, session.getAttribute("userName").toString(), "d").get(0);
        redirectAttributes.addFlashAttribute("response", map);

        return "redirect:view";

    }
}
