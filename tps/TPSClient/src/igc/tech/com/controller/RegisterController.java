package igc.tech.com.controller;


import com.google.gson.Gson;
import igc.tech.com.dao.*;
import igc.tech.com.mapper.*;
import igc.tech.com.model.*;
import igc.tech.com.utility.EmailApi;
import igc.tech.com.utility.GenerateHash;
import igc.tech.com.utility.SendEmail;
import igc.tech.com.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/register")
class RegisterController {

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String signup(Model model) {

        model.addAttribute("title", "Sign Up");

        return "register";

    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String register(Model model, UserDetailModel userDetailModel, HotelDetailModel hotelDetailModel, HttpSession session, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {

//        model.addAttribute("title", "Register");

        List<Map> list = userDetailDao.procUserDetail(userDetailModel, null, "s");

        if (list.isEmpty() || hotelDetailModel.getTokenId() != null) {

            if (hotelDetailModel.getTokenId() == null) {
                Map map = (Map) userDetailDao.procUserDetail(userDetailModel, session.getAttribute("userName").toString(), "i").get(0);
                userDetailModel.setUserDetailId(map.get("user_detail_id").toString());
            } else {
                Map map = list.get(0);
                userDetailModel.setEmailId(map.get("email_id").toString());
            }

            Utility util = new Utility();
            String token = GenerateHash.generateHash(userDetailModel.getUserDetailId() + util.getTimeForSNo());
            TokenModel tokenModel = new TokenModel();
            tokenModel.setToken(token);
            tokenModel.setUserDetailId(userDetailModel.getUserDetailId());

            Map map = (Map) tokenDao.procToken(tokenModel, session.getAttribute("userName").toString(), "i").get(0);

            TokenModel tokenModel1 = new TokenMapper().mapRow((Map) tokenDao.procToken(tokenModel, null, "s").get(0));


            hotelDetailModel.setTokenId(tokenModel1.getTokenId());
            hotelDetailModel.setUserDetailId(userDetailModel.getUserDetailId());
            hotelDetailDao.procHotelDetail(hotelDetailModel, session.getAttribute("userName").toString(), "i");

            SendEmail sendEmail = new SendEmail();
            String emailContent = "Dear " + hotelDetailModel.getHotelName() + ",<br>" +
                    "Congratulations on starting the registration process with TPS.<br>" +
                    "Before you can appear online and bookable, we still need some details about your property.<br>" +
                    "<a href='http://" + request.getServerName() + ":8080/TPSClient/addHotel/" + tokenModel1.getToken() + "'>Complete your property registration now.</a><br>" +
                    "Registration is completely free. Plus, you can manage your property and bookings with our easy-to-use Extranet. Our dedicated support team is available around the clock – just in case.<br>" +
                    "The sooner you complete your registration, the sooner your property can work for you!<br>" +
                    "Kind regards,<br>" +
                    "The TPS Team";
            sendEmail.access("TPS", "mailbox.ganga@gmail.com", "onceAgain", "smtp.gmail.com", "587", userDetailModel.getEmailId(), "register your hotel", emailContent);
            redirectAttributes.addFlashAttribute("responseMsg", "Check Email and click link to register your hotel.");
        } else {
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

        }


        return "redirect:/register/";

    }

    @RequestMapping(value = "checkToken/{token}", method = RequestMethod.GET)
    public String addHotel(Model model, @PathVariable("token") String token, HttpSession session) {

//        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(session.getAttribute("role")==null){
            return "login";
        }
        TokenModel tokenModel = new TokenModel();
        tokenModel.setToken(token);

        List<Map> list = tokenDao.procToken(tokenModel, null, "s");
        System.out.println(list);
        if(!list.isEmpty()){
            session.setAttribute("token", token);
            Map map = list.get(0);
            if(map.get("step").equals(1)){
                return "redirect:/register/hotelDetail/"+token;
            }else if(map.get("step").equals(2)){
                return "redirect:/register/hotelFeature/"+token;
            }else if(map.get("step").equals(3)){
                return "redirect:/register/roomDetail/"+token;
            }else if(map.get("step").equals(4)){
                return "redirect:/register/roomAmenity/"+token;
            }else if(map.get("step").equals(5)){
                return "redirect:/register/image/"+token;
            }else{
                return "redirect:/signup";
            }
        }else{
            return "redirect:/signup";
        }
    }

    @RequestMapping(value = "/hotelDetail/{token}", method = RequestMethod.GET)
    public String hotelDetail(Model model, HttpSession session, @PathVariable("token") String token, RedirectAttributes redirectAttributes){

        session.setAttribute("token",token);
        String tokenId = tokenValidation(model,session, token);
        System.out.println("token: "+tokenId);
        model.addAttribute("step",1);
        if(tokenId==null){
            return "login";
        }else if(tokenId.equals("signup")){
//            session.invalidate();
            return "login";
        }else{
            HotelDetailModel hotelDetailModel = new HotelDetailModel();
            hotelDetailModel.setTokenId(tokenId);
            HotelDetailModel hotelDetailModel1 = new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailModel, null, "s").get(0));
            if(hotelDetailModel1.getActive().equals("Y")){
                redirectAttributes.addFlashAttribute("responseMsg", "Hotel has been Activated. Please login.");
                session.setAttribute("token",null);
                return "redirect:/logout";
            }
            session.setAttribute("hotelDetailId", hotelDetailModel1.getHotelDetailId());

            return "forward:/hotelDetail/edit/"+hotelDetailModel1.getHotelDetailId();
        }
    }

    @RequestMapping(value = "/hotelFeature/{token}", method = RequestMethod.GET)
    public String hotelFeature(Model model, HttpSession session, @PathVariable("token") String token, RedirectAttributes redirectAttributes){
        System.out.println(token);
        session.setAttribute("token",token);
        String tokenId = tokenValidation(model,session, token);
        System.out.println("token: "+tokenId);
        if(tokenId==null){
            return "login";
        }else if(tokenId.equals("signup")){
//            session.invalidate();
            return "login";
        }else{
            if(session.getAttribute("hotelDetailId")==null){
                HotelDetailModel hotelDetailModel = new HotelDetailModel();
                hotelDetailModel.setTokenId(tokenId);
                HotelDetailModel hotelDetailModel1 = new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailModel, null, "s").get(0));
                if(hotelDetailModel1.getActive().equals("Y")){
                    redirectAttributes.addFlashAttribute("responseMsg", "Hotel has been Activated. Please login.");
                    session.setAttribute("token",null);
                    return "redirect:/logout";
                }
                session.setAttribute("hotelDetailId", hotelDetailModel1.getHotelDetailId());
            }

            return "forward:/hotelFeature/view";
        }
    }

    @RequestMapping(value = "/roomDetail/{token}", method = RequestMethod.GET)
    public String roomDetail(Model model, HttpSession session, @PathVariable("token") String token, RedirectAttributes redirectAttributes){

        session.setAttribute("token",token);
        String tokenId = tokenValidation(model,session, token);
        System.out.println("token: "+tokenId);
        if(tokenId==null){
            return "login";
        }else if(tokenId.equals("signup")){
//            session.invalidate();
            return "login";
        }else{
            if(session.getAttribute("hotelDetailId")==null){
                HotelDetailModel hotelDetailModel = new HotelDetailModel();
                hotelDetailModel.setTokenId(tokenId);
                HotelDetailModel hotelDetailModel1 = new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailModel, null, "s").get(0));
                if(hotelDetailModel1.getActive().equals("Y")){
                    redirectAttributes.addFlashAttribute("responseMsg", "Hotel has been Activated. Please login.");
                    session.setAttribute("token",null);
                    return "redirect:/logout";
                }
                session.setAttribute("hotelDetailId", hotelDetailModel1.getHotelDetailId());
            }

            return "forward:/roomDetail/view";
        }
    }

    @RequestMapping(value = "/roomAmenity/{token}", method = RequestMethod.GET)
    public String roomAmenity(Model model, HttpSession session, @PathVariable("token") String token, RedirectAttributes redirectAttributes){

        session.setAttribute("token",token);
        String tokenId = tokenValidation(model,session, token);
        System.out.println("token: "+tokenId);
        if(tokenId==null){
            return "login";
        }else if(tokenId.equals("signup")){
//            session.invalidate();
            return "login";
        }else{
            if(session.getAttribute("hotelDetailId")==null){
                HotelDetailModel hotelDetailModel = new HotelDetailModel();
                hotelDetailModel.setTokenId(tokenId);
                HotelDetailModel hotelDetailModel1 = new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailModel, null, "s").get(0));
                if(hotelDetailModel1.getActive().equals("Y")){
                    redirectAttributes.addFlashAttribute("responseMsg", "Hotel has been Activated. Please login.");
                    session.setAttribute("token",null);
                    return "redirect:/logout";
                }
                session.setAttribute("hotelDetailId", hotelDetailModel1.getHotelDetailId());
            }

            return "forward:/roomAmenity/view";
        }
    }

    @RequestMapping(value = "/image/{token}", method = RequestMethod.GET)
    public String image(Model model, HttpSession session, @PathVariable("token") String token, RedirectAttributes redirectAttributes){

        session.setAttribute("token",token);
        String tokenId = tokenValidation(model,session, token);
        System.out.println("token: "+tokenId);
        if(tokenId==null){
            return "login";
        }else if(tokenId.equals("signup")){
//            session.invalidate();
            return "login";
        }else{
            if(session.getAttribute("hotelDetailId")==null){
                HotelDetailModel hotelDetailModel = new HotelDetailModel();
                hotelDetailModel.setTokenId(tokenId);
                HotelDetailModel hotelDetailModel1 = new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailModel, null, "s").get(0));
                if(hotelDetailModel1.getActive().equals("Y")){
                    redirectAttributes.addFlashAttribute("responseMsg", "Hotel has been Activated. Please login.");
                    session.setAttribute("token",null);
                    return "redirect:/logout";
                }
                session.setAttribute("hotelDetailId", hotelDetailModel1.getHotelDetailId());
            }

            return "forward:/image/view";
        }
    }

    @RequestMapping(value = "/agreement/{token}", method = RequestMethod.GET)
    public String agreement(Model model, HttpSession session, @PathVariable("token") String token, RedirectAttributes redirectAttributes){

        session.setAttribute("token",token);
        /*System.out.println( (String) model.asMap().get("response11"));
        System.out.println(response);*/
        String tokenId = tokenValidation(model,session, token);
        if(tokenId==null){
            return "login";
        }else if(tokenId.equals("signup")){
//            session.invalidate();
            return "login";
        }else{
            if(session.getAttribute("hotelDetailId")==null){
                HotelDetailModel hotelDetailModel = new HotelDetailModel();
                hotelDetailModel.setTokenId(tokenId);
                HotelDetailModel hotelDetailModel1 = new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailModel, null, "s").get(0));
                if(hotelDetailModel1.getActive().equals("Y")){
                    redirectAttributes.addFlashAttribute("responseMsg", "Hotel has been Activated. Please login.");
                    session.setAttribute("token",null);
                    return "redirect:/logout";
                }
                session.setAttribute("hotelDetailId", hotelDetailModel1.getHotelDetailId());
            }
            model.addAttribute("step",6);

            return "joinTemplate";
        }
    }

    @RequestMapping(value = "/agreement", method = RequestMethod.POST)
    public String agreement(Model model,
                            HttpSession session, final RedirectAttributes redirectAttributes) throws Exception {
        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());
        hotelDetailModel.setActive("P");
        Map map = (Map) hotelDetailDao.procHotelDetail(hotelDetailModel, session.getAttribute("userName").toString(), "u").get(0);

        hotelDetailModel = new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailModel,null,"s").get(0));

        UserDetailModel userDetailModel = new UserDetailModel();
        userDetailModel.setUserDetailId(hotelDetailModel.getUserDetailId());

        userDetailModel = new UserDetailMapper().mapRow((Map) userDetailDao.procUserDetail(userDetailModel,null,"s").get(0));

//        String status = EmailApi.sendAgreementEmail(configModel.getTpsEmailUrl(),hotelDetailModel.getHotelName(),session.getAttribute("token").toString(),userDetailModel.getEmailId());

        final    String hotelName=hotelDetailModel.getHotelName();
        final   String emailId=userDetailModel.getEmailId();
//        final String token = session.getAttribute("token").toString();
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    EmailApi.sendAgreementEmail(configModel.getTpsEmailUrl(),hotelName,emailId,emailId);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();
        Map responseMsg = new HashMap();
        responseMsg.put("msg", "Registration Completed. Your information will be Reviewed.");
        responseMsg.put("status","SUCCESS");
        redirectAttributes.addFlashAttribute("response", responseMsg);
//        redirectAttributes.addFlashAttribute("stpe",6);

        return "redirect:/register/agreement/"+session.getAttribute("token");
    }

    public String tokenValidation(Model model, HttpSession session, String token){
        if(session.getAttribute("role")==null){
            return null;
        }
        System.out.println(session.getAttribute("userName"));
        if(session.getAttribute("userName").equals("register")){
            TokenModel tokenModel = new TokenModel();
            tokenModel.setToken(token);

            List<Map> list = tokenDao.procToken(tokenModel, null, "s");

            System.out.println(list);
            if(!list.isEmpty()){
                session.setAttribute("token", token);
                Map map = list.get(0);

                return map.get("token_id").toString();
            }else{
//                session.removeAttribute("token");
                return "signup";
            }
        }else{
            return "signup";
        }
    }

   /* @RequestMapping(value = "/preview", method = RequestMethod.POST)
    @ResponseBody
    public String getChild(Model model,HttpSession session, HttpServletResponse response) throws Exception{

        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());

        hotelDetailModel = new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailModel,null,"s").get(0));

        *//*HotelFeatureModel hotelFeatureModel = new HotelFeatureModel();
        hotelFeatureModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());*//*

        HotelActivityModel hotelActivityModel = new HotelActivityModel();
        hotelActivityModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());
        List<HotelActivityModel> hotelActivityModelList = new HotelActivityMapper().mapList(hotelActivityDao.procHotelActivity(hotelActivityModel, null,"s"));

        RoomDetailModel roomDetailModel = new RoomDetailModel();
        List<RoomDetailModel> roomDetailModelList = new RoomDetailMapper().mapList(roomDetailDao.procRoomDetail(roomDetailModel,null,"s"));

        Map previewMap = new HashMap();
        previewMap.put("hotelDetail", hotelDetailModel);
        previewMap.put("activityList", hotelActivityModelList);
        previewMap.put("roomDetailList", roomDetailModelList);

        String json = new Gson().toJson(previewMap);
        return json;
    }*/




}
