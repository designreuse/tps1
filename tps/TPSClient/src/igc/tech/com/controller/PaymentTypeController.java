package igc.tech.com.controller;

import igc.tech.com.dao.PaymentTypeDao;
import igc.tech.com.mapper.NearestAreaMapper;
import igc.tech.com.mapper.PaymentTypeMapper;
import igc.tech.com.model.NearestAreaModel;
import igc.tech.com.model.PaymentTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Ganga on 5/20/2016.
 */
@Controller
@RequestMapping(value = "/paymentType")
public class PaymentTypeController {

    @Autowired
    PaymentTypeDao paymentTypeDao;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model, HttpSession session) {

        List<PaymentTypeModel> paymentTypeModelList = new PaymentTypeMapper().mapList(paymentTypeDao.procPaymentType(new PaymentTypeModel(), null, "a"));
        model.addAttribute("paymentTypeList", paymentTypeModelList);

        model.addAttribute("base", "paymentType");

        return "paymentType";

    }
}
