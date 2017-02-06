package igc.tech.com.controller;


import com.google.gson.Gson;
import igc.tech.com.dao.*;
import igc.tech.com.mapper.*;
import igc.tech.com.model.*;
import igc.tech.com.security.CaptchaServlet;
import igc.tech.com.utility.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/")
class IndexController {

//    private static final long serialVersionUID = -6506682026701304964L;

    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    TokenDao tokenDao;

    @Autowired
    UserDetailDao userDetailDao;

    @Autowired
    HotelFeatureDao hotelFeatureDao;

    @Autowired
    HotelActivityDao hotelActivityDao;

    @Autowired
    RoomDetailDao roomDetailDao;

    @Autowired
    RoomTypeDao roomTypeDao;

    @Autowired
    BedTypeDao bedTypeDao;

    @Autowired
    RoomAmenityDao roomAmenityDao;

    @Autowired
    HotelImageDao hotelImageDao;

    @Autowired
    ExtraBedDao extraBedDao;

    @Autowired
    CountryDao countryDao;

    @Autowired
    AddressDao areaDao;

    @Autowired
    RegionDao regionDao;

    @Autowired
    AddressDao addressDao;

    @Autowired
    ConfigModel configModel;

    @Autowired
    PushContentDataDao pushContentDataDao;

    @Autowired
    TempContentDataDao tempContentDataDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {

        System.out.println("gamga");
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("authentication", authentication);

        if(authentication.getName().equals("register")){
//            System.out.println(session.getAttribute("token"));
            session.setAttribute("token",null);
            return "redirect:/logout";
        }
       /* System.out.println("ganga");
        System.out.println("test"+authentication.getName());*/
        session.setAttribute("login", true);
//regionDao.procRegion(new RegionModel(),null,"a");
        return "dashboard";


    }

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String signup(Model model, HttpSession session) {

        session.removeAttribute("login");
        session.removeAttribute("token");

        model.addAttribute("title", "Sign Up");

        return "register";

    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model, HttpSession session) {

       /* Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getName().equals("register")){
            return "login";
        }*/

        System.out.println("login"+model.asMap().get("responseMsg"));
        if (session.getAttribute("login") != null) {
            return "dashboard";
        }
        model.addAttribute("title", "Login");


        return "login";


    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpSession session,RedirectAttributes redirectAttributes) {

//        System.out.println("logout"+model.asMap().get("responseMsg"));
        session.removeAttribute("login");
        session.removeAttribute("token");

        if(model.asMap().get("responseMsg")!=null){
            redirectAttributes.addFlashAttribute("responseMsg",model.asMap().get("responseMsg"));
            return "redirect:/login";
        }


        return "redirect:/j_spring_security_logout";


    }


    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(Model model) {

        regionDao.procRegion(new RegionModel(), null, "a");
        return "test";


    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String register(Model model, UserDetailModel userDetailModel, HotelDetailModel hotelDetailModel, HttpSession session, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        System.out.println("ganga");




        String gRecaptchaResponse = request
                .getParameter("g-recaptcha-response");
        System.out.println(gRecaptchaResponse);
        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);

        if(verify){
            List<Map> list = userDetailDao.procUserDetail(userDetailModel, null, "s");
            System.out.println(list);

//            if (list.isEmpty() || hotelDetailModel.getTokenId() != null) {

                if (hotelDetailModel.getTokenId() == null) {
                    if(list.isEmpty()){
                        userDetailModel.setActive("0");
                        userDetailModel.setRoleId("2");
                        Map map = (Map) userDetailDao.procUserDetail(userDetailModel, "register", "i").get(0);
                        userDetailModel.setUserDetailId(map.get("user_detail_id").toString());
                    }else{
                        userDetailModel = new UserDetailMapper().mapRow((Map) userDetailDao.procUserDetail(userDetailModel,null,"s").get(0));
                    }

                } else {
                    Map map = list.get(0);
                    userDetailModel.setEmailId(map.get("email_id").toString());
                }

                Utility util = new Utility();
                String token = GenerateHash.generateHash(userDetailModel.getUserDetailId() + util.getTimeForSNo());
                TokenModel tokenModel = new TokenModel();
                tokenModel.setToken(token);
                tokenModel.setStep("1");
                tokenModel.setUserDetailId(userDetailModel.getUserDetailId());

                Map map = (Map) tokenDao.procToken(tokenModel, "register", "i").get(0);

                TokenModel tokenModel1 = new TokenMapper().mapRow((Map) tokenDao.procToken(tokenModel, null, "s").get(0));

            String modelHotelName = hotelDetailModel.getHotelName();
            hotelDetailModel.setHotelName(null);

                hotelDetailModel.setTokenId(tokenModel1.getTokenId());
                hotelDetailModel.setUserDetailId(userDetailModel.getUserDetailId());
                hotelDetailModel.setActive("I");
                map = (Map) hotelDetailDao.procHotelDetail(hotelDetailModel, "register", "i").get(0);
            String hotelDetailId = map.get("hotel_detail_id").toString();

            PushContentDataModel pushContentDataModel = new PushContentDataModel();
            pushContentDataModel.setHotelDetailId(hotelDetailId);
            pushContentDataModel.setStatus("N");
            map = (Map) pushContentDataDao.procPushContentData(pushContentDataModel, "register", "i").get(0);
//            session.setAttribute("pushContentDataId", map.get("push_content_data_id"));
            TempContentDataModel tempContentDataModel = new TempContentDataModel();
            tempContentDataModel.setType("hotel_detail");
            tempContentDataModel.setPushContentDataId(map.get("push_content_data_id").toString());
            tempContentDataModel.setRefId(hotelDetailId);
            tempContentDataModel.setField("hotel_name");
            tempContentDataModel.setContentData(modelHotelName);
            tempContentDataDao.procTempContentData(tempContentDataModel, "register", "u");

                String status = EmailApi.sendRegistraionEmail(configModel.getTpsEmailUrl(),hotelDetailModel.getHotelName(),tokenModel1.getToken(),userDetailModel.getEmailId());

            final    String hotelName=modelHotelName;
            final   String emailId=userDetailModel.getEmailId();
            final String tokenNo = tokenModel1.getToken();
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        EmailApi.sendRegistraionEmail(configModel.getTpsEmailUrl(),hotelName,tokenNo,emailId);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }).start();
                /*SendEmail sendEmail = new SendEmail();
                String emailContent = "Dear " + hotelDetailModel.getHotelName() + ",<br>" +
                        "Congratulations on starting the registration process with TPS.<br>" +
                        "Before you can appear online and bookable, we still need some details about your property.<br>" +
                        "<a href='http://" + request.getServerName() + ":8080/TPSClient/register/hotelDetail/" + tokenModel1.getToken() + "'>Complete your property registration now.</a><br>" +
                        "Registration is completely free. Plus, you can manage your property and bookings with our easy-to-use Extranet. Our dedicated support team is available around the clock – just in case.<br>" +
                        "The sooner you complete your registration, the sooner your property can work for you!<br>" +
                        "Kind regards,<br>" +
                        "The TPS Team";
                sendEmail.access("TPS", "mailbox.ganga@gmail.com", "onceAgain", "smtp.gmail.com", "587", userDetailModel.getEmailId(), "register your hotel", emailContent);*/
                redirectAttributes.addFlashAttribute("responseMsg", "Check Email and click link to register your hotel.");
            /*} else {
                Map map = list.get(0);
                String userDetailId = map.get("user_detail_id").toString();
                userDetailModel.setUserDetailId(userDetailId);

                hotelDetailModel.setUserDetailId(userDetailId);

                TokenModel tokenModel = new TokenModel();
                tokenModel.setUserDetailId(userDetailId);
                map = (Map) tokenDao.procToken(tokenModel, null, "s").get(0);

//            hotelDetailModel.setHotelName(null);

                List<HotelDetailModel> hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(hotelDetailModel, null, "s"));
                hotelDetailModel.setTokenId(map.get("token_id").toString());
                redirectAttributes.addFlashAttribute("hotelDetailList", hotelDetailModelList);
                redirectAttributes.addFlashAttribute("hotelDetailMap", hotelDetailModel);
                redirectAttributes.addFlashAttribute("userDetailMap", userDetailModel);

            }*/
        }else{

            redirectAttributes.addFlashAttribute("responseMsg", "You missed the Captcha.");
            redirectAttributes.addFlashAttribute("status", "Error");
        }




        return "redirect:/signup";

    }

    @RequestMapping(value = "getToken/{tokenId}", method = RequestMethod.GET)
    public String getToken(RedirectAttributes redirectAttributes, @PathVariable("tokenId") String tokenId, HttpServletRequest request) throws Exception {

        TokenModel tokenModel = new TokenModel();
        tokenModel.setTokenId(tokenId);
        tokenModel = new TokenMapper().mapRow((Map) tokenDao.procToken(tokenModel, null, "s").get(0));

        UserDetailModel userDetailModel = new UserDetailModel();
        userDetailModel.setUserDetailId(tokenModel.getUserDetailId());
        userDetailModel = new UserDetailMapper().mapRow((Map) userDetailDao.procUserDetail(userDetailModel,null,"s").get(0));

        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setTokenId(tokenId);
        hotelDetailModel = new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailModel, null, "s").get(0));
        System.out.println(hotelDetailModel);
        SendEmail sendEmail = new SendEmail();
        /*String emailContent = "Dear " + hotelDetailModel.getHotelName() + ",<br>" +
                "Congratulations on starting the registration process with TPS.<br>" +
                "Before you can appear online and bookable, we still need some details about your property.<br>" +
                "<a href='http://" + request.getServerName() + ":8080/TPSClient/addHotel/" + tokenModel.getToken() + "'>Complete your property registration now.</a><br>" +
                "Registration is completely free. Plus, you can manage your property and bookings with our easy-to-use Extranet. Our dedicated support team is available around the clock – just in case.<br>" +
                "The sooner you complete your registration, the sooner your property can work for you!<br>" +
                "Kind regards,<br>" +
                "The TPS Team";
        sendEmail.access("TPS", "mailbox.ganga@gmail.com", "onceAgain", "smtp.gmail.com", "587", userDetailModel.getEmailId(), "register your hotel", emailContent);*/

        String status = EmailApi.sendRegistraionEmail(configModel.getTpsEmailUrl(),hotelDetailModel.getHotelName(),tokenModel.getToken(),userDetailModel.getEmailId());
        System.out.println(status);

        redirectAttributes.addFlashAttribute("responseMsg", "Check Email and click link to register your hotel.");
        return "redirect:/signup";

    }

    @RequestMapping(value="changePassword", method = RequestMethod.GET)
    public String changePassword(Model model, HttpSession session){
        model.addAttribute("base","changePassword");

        return "changePassword";
    }

    @RequestMapping(value = "changePassword", method = RequestMethod.POST)
    public String changePassword(RedirectAttributes redirectAttributes, HttpSession session, @RequestParam("currentPassword") String currentPassword,
                                 @RequestParam("newPassword") String newPassword){

        UserDetailModel userDetailModel = new UserDetailModel();
        userDetailModel.setEmailId(session.getAttribute("userName").toString());
        userDetailModel.setPassword(currentPassword);
        List list = userDetailDao.procUserDetail(userDetailModel,null,"s");

        if(!list.isEmpty()){
            Map map = (Map) list.get(0);
            userDetailModel.setPassword(newPassword);
            userDetailModel.setUserDetailId(map.get("user_detail_id").toString());

            map = (Map) userDetailDao.procUserDetail(userDetailModel, session.getAttribute("userName").toString(),"u").get(0);
            redirectAttributes.addFlashAttribute("response", map);
        }else{
            Map map = new HashMap();
            map.put("status","UNSUCCESS");
            map.put("msg", "Incorrect Password ");
            redirectAttributes.addFlashAttribute("response", map);
        }



        return "redirect:/changePassword";
    }

    @RequestMapping(value = "completeUserDetail", method = RequestMethod.GET)
    public String completeInformation(Model model, HttpSession session){
        model.addAttribute("base","completeUserDetail");
        return "completeUserDetail";
    }

    @RequestMapping(value = "completeUserDetail", method = RequestMethod.POST)
    public String completeInformation(RedirectAttributes redirectAttributes, HttpSession session, UserDetailModel userDetailModel){
        Map map = (Map) userDetailDao.procUserDetail(userDetailModel, session.getAttribute("userName").toString(), "u").get(0);
        redirectAttributes.addFlashAttribute("response", map);
//        model.addAttribute("base","completeUserDetail");
        return "redirect:/";
    }

    @RequestMapping(value = "joinedHotel", method = RequestMethod.GET)
    public String joinedHotel(Model model, HttpSession session) {
        session.setAttribute("hotelDetailId", null);
        session.setAttribute("pushContentDataId", null);

        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }

        if(session.getAttribute("role")==null){
            return "redirect:../";
        }

        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setActive("P");
        List<HotelDetailModel> hotelDetailModelList = new ArrayList<>();
        hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(hotelDetailModel, null,"s"));
        model.addAttribute("hotelDetailList", hotelDetailModelList);
        model.addAttribute("base","joinedHotel");
        model.addAttribute("action","accept");

        return "hotelList";

    }

    @RequestMapping(value = "pushedHotel", method = RequestMethod.GET)
    public String pushed(Model model, HttpSession session) {
        session.setAttribute("hotelDetailId", null);
        session.setAttribute("pushContentDataId", null);

        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }

        if(session.getAttribute("role")==null){
            return "redirect:../";
        }
        System.out.println(model.asMap().get("response"));

        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setActive("P");
        List<HotelDetailModel> hotelDetailModelList = new ArrayList<>();
        hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(hotelDetailModel, null,"pushed_hotel"));
        model.addAttribute("hotelDetailList", hotelDetailModelList);
        model.addAttribute("base","pushedHotel");
        model.addAttribute("action","approved");

        return "hotelList";

    }


}
