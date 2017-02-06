package igc.tech.com.controller;

import igc.tech.com.dao.ClientDetailDao;
import igc.tech.com.mapper.ClientDetailMapper;
import igc.tech.com.model.ClientDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
@Controller
@RequestMapping(value = "/clientDetail")
public class ClientDetailController {

    @Autowired
    ClientDetailDao clientDetailDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<ClientDetailModel> list = new
                ClientDetailMapper().
                mapList(clientDetailDao.procClientDetail(null,
                        null, null, null, null,
                        null, null, null, null, null, null, "a"));

        model.addAttribute("clientDetailList", list);
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }

        return "clientDetail";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("mode", "add");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model, ClientDetailModel clientDetailModel, HttpSession session) {


        Map map = (Map) clientDetailDao.procClientDetail(
                null, clientDetailModel.getClientName(),
                clientDetailModel.getAddress(),
                clientDetailModel.getPhoneNumber(),
                clientDetailModel.getCompanyEmail(),
                clientDetailModel.getCompanyName(),
                clientDetailModel.getCompanyAddress(),
                clientDetailModel.getCompanyPhone(),
                clientDetailModel.getCompanyEmail(),
                clientDetailModel.getActive(),
                session.getAttribute("userName").toString(), "i").get(0);

        model.addAttribute("dbResponse", map);

        model.addAttribute("mode", "add");
        model.addAttribute("noView", "noView");
        return add(model);

    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model,
                       @PathVariable("id") String clientDetailId) {

        ClientDetailModel clientDetailModel = new ClientDetailMapper().mapRow(

                (Map) clientDetailDao.procClientDetail(clientDetailId, null, null, null
                        , null, null, null, null, null, null, null, "s").get(0));


        model.addAttribute("clientDetailMap", clientDetailModel);
        model.addAttribute("mode", "edit");
        model.addAttribute("noView", "noView");
        return getAll(model);

    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, ClientDetailModel clientDetailModel, HttpSession session) {


        Map map = (Map) clientDetailDao.procClientDetail(
                clientDetailModel.getClientDetailId(), clientDetailModel.getClientName(),
                clientDetailModel.getAddress(),
                clientDetailModel.getPhoneNumber(),
                clientDetailModel.getCompanyEmail(),
                clientDetailModel.getCompanyName(),
                clientDetailModel.getCompanyAddress(),
                clientDetailModel.getCompanyPhone(),
                clientDetailModel.getCompanyEmail(),
                clientDetailModel.getActive(),
                session.getAttribute("userName").toString(), "u").get(0);


        clientDetailModel = new ClientDetailMapper().mapRow(

                (Map) clientDetailDao.procClientDetail(clientDetailModel.getClientDetailId(), null, null, null
                        , null, null, null, null, null, null, null, "s").get(0));


        model.addAttribute("dbResponse", map);
        model.addAttribute("clientDetailMap", clientDetailModel);
        model.addAttribute("mode", "edit");
        model.addAttribute("noView", "noView");

        return getAll(model);

    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(Model model,
                         @PathVariable("id") String clientDetailId) {

        ClientDetailModel clientDetailModel = new ClientDetailMapper().mapRow(

                (Map) clientDetailDao.procClientDetail(clientDetailId, null, null, null
                        , null, null, null, null, null, null, null, "s").get(0));


        model.addAttribute("clientDetailMap", clientDetailModel);
        model.addAttribute("mode", "detail");
        model.addAttribute("noView", "noView");

        return getAll(model);

    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("id") String clientDetailId, HttpSession session) {

        Map map =
                (Map) clientDetailDao.procClientDetail(clientDetailId, null, null, null
                        , null, null, null, null, null, null, null, "d").get(0);


        model.addAttribute("dbResponse", map);

        return getAll(model);
    }


}
