package igc.tech.com.controller;


import com.google.gson.Gson;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.model.*;
import igc.tech.com.dao.*;
import igc.tech.com.mapper.*;
import igc.tech.com.model.*;
import igc.tech.com.utility.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import java.util.*;


@Controller
@RequestMapping(value = "/hotelDetail")
class HotelDetailController {

    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    RegionDao regionDao;

    @Autowired
    ClientDetailDao clientDetailDao;

    @Autowired
    TokenDao tokenDao;

    @Autowired
    AreaDao areaDao;

    @Autowired
    CountryDao countryDao;

    @Autowired
    AddressDao addressDao;

    @Autowired
    UserDetailDao userDetailDao;

    @Autowired
    ConfigModel configModel;

    @Autowired
    PushContentDataDao pushContentDataDao;

    @Autowired
    TempContentDataDao tempContentDataDao;

    HashMap<String, String[]> siteContent = new HashMap<String, String[]>();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String addHotel(Model model) {

        List<HotelDetailModel> hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(new HotelDetailModel(), null,"a"));
        model.addAttribute("hotelDetailList", hotelDetailModelList);
        model.addAttribute("base","hotelDetail");
        model.addAttribute("mode","view");
        return "hotelDetail";

    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model, HttpSession session) {
        session.setAttribute("hotelDetailId", null);
        session.setAttribute("pushContentDataId", null);
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        List<HotelDetailModel> hotelDetailModelList = new ArrayList<>();
        if(session.getAttribute("role")!=null){
            System.out.println("sesion Val: "+ session.getAttribute("role"));
        }

        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }

        if(session.getAttribute("role")==null){
            return "redirect:../";
        }

//        if(session.getAttribute("role").toString().equals("[ROLE_ADMIN]")){
        if(authorities.contains("ADMIN")){
            hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(new HotelDetailModel(), null,"s"));
            model.addAttribute("hotelDetailList", hotelDetailModelList);
        }else{
            UserDetailModel userDetailModel = new UserDetailModel();
            userDetailModel.setEmailId(session.getAttribute("userName").toString());
            userDetailModel= new UserDetailMapper().mapRow((Map) userDetailDao.procUserDetail(userDetailModel,null,"s").get(0));
//            System.out.println(userDetailModel);

            hotelDetailModel.setUserDetailId(userDetailModel.getUserDetailId());
//            System.out.println(hotelDetailModel);
            hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(hotelDetailModel, null,"s"));
//            System.out.println(hotelDetailModelList);
            model.addAttribute("hotelDetailList", hotelDetailModelList);
            /*String mode = (String) model.asMap().get("mode");
            if(hotelDetailModelList.size()==1 && !mode.equals("update")){
                return "redirect:../hotelDetail/edit/"+hotelDetailModelList.get(0).getHotelDetailId();
            }*/
        }

        model.addAttribute("base","hotelDetail");



        return "hotelDetail";

    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String add(Model model,HttpSession session) throws Exception{
        AddressModel addressModel = new AddressModel();
        addressModel.setType("COUNTRY");
        List<AddressModel> addressModelList = new AddressMapper().mapList(addressDao.procAddress(addressModel,null,"s"));
        model.addAttribute("countryList", addressModelList);

        if(addressModelList.size()==1){

            String addressId =addressModelList.get(0).getAddressId();
            Map<String, List<AddressModel>> map = new HashMap<>();

            addressModel.setType(null);
            addressModel.setParentAddressId(addressId);

            List list = new ArrayList();
            List addressIdList = new ArrayList();

            addressModelList=new AddressMapper().mapList(addressDao.procAddress(addressModel, null,"l"));
            System.out.println(addressModelList);
            list.add(addressModelList.get(0).getType());
            map.put(addressModelList.get(0).getType(), addressModelList);
            addressId = addressModelList.get(0).getParentAddressId();
            addressIdList.add(addressId);



            model.addAttribute("addressList", map);
            model.addAttribute("addressIdList", addressIdList);
            model.addAttribute("keyList", list);
            System.out.println(list);
        }
        siteContent.put("css", new String[]{"summernote/summernote.css","summernote/summernote-bs3.css"});
        siteContent.put("js", new String[]{"summernote/summernote.min.js"});
        model.addAttribute("siteContent", siteContent);

        /*if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }*/
        model.addAttribute("mode","update");
        model.addAttribute("noView","noView");
        model.addAttribute("step",1);
        model.addAttribute("base","hotelDetail");
        return "adminTemplate";

//        return getAll(model, session);
    }


   @RequestMapping(value = "edit", method = RequestMethod.GET)
   public String edit1(Model model,HttpSession session){

       return edit(model,session,session.getAttribute("hotelDetailId").toString());
   }

    @RequestMapping(value = "edit/{hotelDetailId}", method = RequestMethod.GET)
    public String edit(Model model,HttpSession session, @PathVariable("hotelDetailId") String hotelDetailId){

        PushContentDataModel pushContentDataModel = new PushContentDataModel();
        pushContentDataModel.setHotelDetailId(hotelDetailId);
        List pushContentList = pushContentDataDao.procPushContentData(pushContentDataModel, null, "not_approved");
        if(pushContentList.isEmpty()){
            pushContentDataModel.setStatus("N");
            Map map = (Map) pushContentDataDao.procPushContentData(pushContentDataModel, null, "i").get(0);
            session.setAttribute("pushContentDataId", map.get("push_content_data_id"));
        }else{
            pushContentDataModel = new PushContentDataMapper().mapRow((Map) pushContentList.get(0));
            session.setAttribute("pushContentDataId", pushContentDataModel.getPushContentDataId());
        }

        if(session.getAttribute("token")==null){
            session.setAttribute("hotelDetailId", hotelDetailId);
        }


        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());

        hotelDetailModel = new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailModel, null, "s").get(0));
        session.setAttribute("hotelName", hotelDetailModel.getHotelName());
//        List<HotelDetailModel> list = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(hotelDetailModel, null, "s"));

        model.addAttribute("hotelDetailMap", hotelDetailModel);

        if(hotelDetailModel.getAddressId()!=null){
            Map<String, List<AddressModel>> map = new HashMap<>();

            List list = new ArrayList();
            List addressIdList = new ArrayList();
            String addressId =hotelDetailModel.getAddressId();
            addressIdList.add(addressId);
            List<AddressModel> addressModelList = getSibling(addressId,model, list);
            addressId = addressModelList.get(0).getParentAddressId();
            addressIdList.add(addressId);
            map.put(addressModelList.get(0).getType(), addressModelList);
//            model.addAttribute(addressModelList.get(0).getType(), addressModelList);

            while (!addressModelList.isEmpty()){
                addressModelList=getSibling(addressId, model, list);
                if (addressModelList.isEmpty()){
                    break;
                }
                map.put(addressModelList.get(0).getType(), addressModelList);
                addressId = addressModelList.get(0).getParentAddressId();
                addressIdList.add(addressId);
            }
            model.addAttribute("addressList", map);
            model.addAttribute("addressIdList", addressIdList);
            model.addAttribute("keyList", list);
        }

       /* List<CountryModel> countryModelList = new CountryMappper().mapList(countryDao.procCountry(new CountryModel(),null,"a"));
        model.addAttribute("countryList", countryModelList);*/
        AddressModel addressModel = new AddressModel();
        addressModel.setType("COUNTRY");
        List<AddressModel> addressModelList = new AddressMapper().mapList(addressDao.procAddress(addressModel,null,"s"));
        model.addAttribute("countryList", addressModelList);

        if(addressModelList.size()==1 && hotelDetailModel.getAddressId()==null){

            String addressId =addressModelList.get(0).getAddressId();
            Map<String, List<AddressModel>> map = new HashMap<>();

            addressModel.setType(null);
            addressModel.setParentAddressId(addressId);

            List list = new ArrayList();
            List addressIdList = new ArrayList();
            addressModelList=new AddressMapper().mapList(addressDao.procAddress(addressModel, null,"l"));
            System.out.println(addressModelList);
            list.add(addressModelList.get(0).getType());
            map.put(addressModelList.get(0).getType(), addressModelList);
            addressId = addressModelList.get(0).getParentAddressId();
            addressIdList.add(addressId);

            model.addAttribute("addressList", map);
            model.addAttribute("addressIdList", addressIdList);
            model.addAttribute("keyList", list);
            System.out.println(list);
        }

        model.addAttribute("mode","update");
        model.addAttribute("base","hotelDetail");
        siteContent.put("css", new String[]{"summernote/summernote.css","summernote/summernote-bs3.css"});
        siteContent.put("js", new String[]{"summernote/summernote.min.js"});
        model.addAttribute("siteContent", siteContent);
        if(session.getAttribute("token")==null){
            return "adminTemplate";
        }else{
//            model.addAttribute("includeFile", "properDetailForm");
            return "joinTemplate";
        }

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String edit(Model model, HotelDetailModel hotelDetailModel,String step, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {


        if(hotelDetailModel.getHotelPhNo2()==null)
            System.out.println("phone2 null");
        if(hotelDetailModel.getHotelPhNo3()==null)
            System.out.println("phone3 null");
        /*if(hotelDetailModel.getActive()==null){
            hotelDetailModel.setActive("N");
        }*/
        String hotelName = hotelDetailModel.getHotelName();
        String description = hotelDetailModel.getDescription();
        hotelDetailModel.setHotelName(null);
        hotelDetailModel.setDescription(null);

        Map map = new HashMap();
        TempContentDataModel tempContentDataModel = new TempContentDataModel();
        tempContentDataModel.setType("hotel_detail");

        if(hotelDetailModel.getHotelDetailId().isEmpty()){

            Utility util = new Utility();
            String token = GenerateHash.generateHash(session.getAttribute("userDetailId") + util.getTimeForSNo());
            TokenModel tokenModel = new TokenModel();
            tokenModel.setToken(token);
            tokenModel.setUserDetailId(session.getAttribute("userDetailId").toString());

            map = (Map) tokenDao.procToken(tokenModel, session.getAttribute("userName").toString(), "i").get(0);

            hotelDetailModel.setHotelDetailId(null);

            hotelDetailModel.setTokenId(map.get("token_id").toString());
            hotelDetailModel.setUserDetailId(session.getAttribute("userDetailId").toString());
            hotelDetailModel.setActive("N");
            map = (Map) hotelDetailDao.procHotelDetail(hotelDetailModel,
                    session.getAttribute("userName").toString(),
                    "i").get(0);
            session.setAttribute("hotelDetailId", map.get("hotel_detail_id"));

            PushContentDataModel pushContentDataModel = new PushContentDataModel();
            pushContentDataModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());
            pushContentDataModel.setStatus("N");
            map = (Map) pushContentDataDao.procPushContentData(pushContentDataModel, null, "i").get(0);
            session.setAttribute("pushContentDataId", map.get("push_content_data_id"));

        }else{


            map = (Map) hotelDetailDao.procHotelDetail(hotelDetailModel,
                    session.getAttribute("userName").toString(),
                    "u").get(0);
        }
        tempContentDataModel.setPushContentDataId(session.getAttribute("pushContentDataId").toString());
        tempContentDataModel.setRefId(session.getAttribute("hotelDetailId").toString());
        tempContentDataModel.setField("hotel_name");
        tempContentDataModel.setContentData(hotelName);
        tempContentDataDao.procTempContentData(tempContentDataModel, session.getAttribute("userName").toString(), "u");

        tempContentDataModel.setField("description");
        tempContentDataModel.setContentData(description);
        tempContentDataDao.procTempContentData(tempContentDataModel, session.getAttribute("userName").toString(), "u");


        redirectAttributes.addFlashAttribute("response", map);

        if(session.getAttribute("token")==null){

            return "redirect:../hotelDetail/edit/"+session.getAttribute("hotelDetailId");
        }else{
            TokenModel tokenModel = new TokenModel();
            tokenModel.setTokenId(hotelDetailModel.getTokenId());
            step = String.valueOf(Integer.parseInt(step)+1) ;
            tokenModel.setStep(step);
//            map = (Map) tokenDao.procToken(tokenModel,null,"s").get(0);
            map = (Map) tokenDao.procToken(tokenModel,null,"u").get(0);
            map = (Map) tokenDao.procToken(tokenModel,null,"s").get(0);
            redirectAttributes.addFlashAttribute("step",Integer.parseInt(step)+1);
        }


        return "redirect:../register/hotelFeature/"+map.get("token");

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("deleteId") String hotelDetailId, HttpSession session, RedirectAttributes redirectAttributes) {
        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setHotelDetailId(hotelDetailId);

        Map map = (Map) hotelDetailDao.procHotelDetail(hotelDetailModel, session.getAttribute("userName").toString(), "d").get(0);


        redirectAttributes.addFlashAttribute("response", map);

        return "redirect:../hotelDetail/view";
    }

    @RequestMapping(value = "/getChild", method = RequestMethod.POST)
    @ResponseBody
    public String getChild(Model model,
                         @RequestParam("parentAddressId") String parentAddressId, HttpSession session, HttpServletResponse response) throws Exception{
        AddressModel addressModel = new AddressModel();
        addressModel.setParentAddressId(parentAddressId);
        List<AddressModel> addressModelList = new AddressMapper().mapList(addressDao.procAddress(addressModel, null,"l"));
        System.out.println(addressModelList.size()+" "+ addressModelList);
        String json = new Gson().toJson(addressModelList);
        return json;
    }

    public List<AddressModel> getSibling(String addressId, Model model, List list){
        AddressModel addressModel = new AddressModel();
        addressModel.setAddressId(addressId);
        List<AddressModel> addressModelList = new AddressMapper().mapList(addressDao.procAddress(addressModel, null,"b"));
        if(!addressModelList.isEmpty()){

            list.add(addressModelList.get(0).getType());
        }
        System.out.println(list);

        return  addressModelList;
    }

    @RequestMapping(value = "/activate", method = RequestMethod.POST)
    @ResponseBody
    public String activate(Model model,
                         @RequestParam("hotelDetailId") String hotelDetailId, @RequestParam("active") String active, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception{

        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setHotelDetailId(hotelDetailId);
        hotelDetailModel.setActive(active);

        Map map = new HashMap();
        if(active.equals("Y")){
            map = (Map) hotelDetailDao.procHotelDetail(hotelDetailModel, session.getAttribute("userName").toString(), "v").get(0);
        }else{
            map = (Map) hotelDetailDao.procHotelDetail(hotelDetailModel, session.getAttribute("userName").toString(), "u").get(0);
        }


        if(active.equals("Y") && map.get("status").equals("SUCCESS")){


            hotelDetailModel = new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailModel, null, "s").get(0));
            UserDetailModel userDetailModel = new UserDetailModel();
            userDetailModel.setUserDetailId(hotelDetailModel.getUserDetailId());
            userDetailModel = new UserDetailMapper().mapRow((Map) userDetailDao.procUserDetail(userDetailModel,null,"s").get(0));
            if(userDetailModel.getActive().equals("0")){
                userDetailModel.setPassword("12345");
//            userDetailModel.setRoleId("2");
                userDetailModel.setActive("1");

                map = (Map) userDetailDao.procUserDetail(userDetailModel, session.getAttribute("userName").toString(), "u").get(0);

                //  EmailApi.sendActivationEmail(configModel.getTpsEmailUrl(),hotelDetailModel.getHotelName(),map.get("email_id").toString(),map.get("email_id").toString());


                final    String hotelName=hotelDetailModel.getHotelName();
                final   String emailId=map.get("email_id").toString();

                // thread handling
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            EmailApi.sendActivationEmail(configModel.getTpsEmailUrl(),hotelName,emailId,emailId);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }).start();
            }



            // ** ending of thread handling

            /*SendEmail sendEmail = new SendEmail();
            String emailContent = "Dear " + hotelDetailModel.getHotelName() + ",<br>" +
                    "Your Property has been listed on the Go Nepal Travel Portal System.<br>" +
                    "Your username and password is:<br>" +
                    "UserName: " +map.get("email_id").toString()+
                    "Password: 12345" +
                    "<a href='http://" + request.getServerName() + ":8080/TPSClient/userDetail/changePassword'>click to Proceed</a><br>" +
                    "Kind regards,<br>" +
                    "The TPS Team";*/
//            sendEmail.access("TPS", "mailbox.ganga@gmail.com", "onceAgain", "smtp.gmail.com", "587", map.get("email_id").toString(), "login detail", emailContent);

        }
        String json = new Gson().toJson(map);
        return json;
    }

    @RequestMapping(value = "/acceptHotel", method = RequestMethod.POST)
    public String accept(RedirectAttributes redirectAttributes,
                           @RequestParam("hotelDetailId") String hotelDetailId, HttpSession session, HttpServletRequest request) throws Exception{

        PushContentDataModel pushContentDataModel=  new PushContentDataModel();
        pushContentDataModel.setHotelDetailId(hotelDetailId);
        pushContentDataModel.setStatus("N");

        Map map = (Map) pushContentDataDao.procPushContentData(pushContentDataModel, session.getAttribute("userName").toString(), "s").get(0);

        String pushContentDataId = map.get("push_content_data_id").toString();

        pushContentDataDao.procPushContentData(pushContentDataModel, session.getAttribute("userName").toString(), "approved");

        TempContentDataModel tempContentDataModel = new TempContentDataModel();
        tempContentDataModel.setPushContentDataId(pushContentDataId);
        String[] updateField = {"hotelDetailId", "description", "customName"};
        tempContentDataModel.setUpdateField(updateField);

        map = (Map) tempContentDataDao.procTempContentData(tempContentDataModel, session.getAttribute("userName").toString(), "p").get(0);

        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setHotelDetailId(hotelDetailId);
        hotelDetailModel.setActive("N");


            map = (Map) hotelDetailDao.procHotelDetail(hotelDetailModel, session.getAttribute("userName").toString(), "v").get(0);



        if(map.get("status").equals("SUCCESS")){


            hotelDetailModel = new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailModel, null, "s").get(0));
            UserDetailModel userDetailModel = new UserDetailModel();
            userDetailModel.setUserDetailId(hotelDetailModel.getUserDetailId());
            userDetailModel = new UserDetailMapper().mapRow((Map) userDetailDao.procUserDetail(userDetailModel,null,"b").get(0));
             if(userDetailModel.getActive().equals("0") || userDetailModel.getActive()==null){
                userDetailModel.setPassword("12345");
//            userDetailModel.setRoleId("2");
                userDetailModel.setActive("1");

                map = (Map) userDetailDao.procUserDetail(userDetailModel, session.getAttribute("userName").toString(), "u").get(0);

                final    String hotelName=hotelDetailModel.getHotelName();
                final   String emailId=map.get("email_id").toString();

                // thread handling
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            EmailApi.sendActivationEmail(configModel.getTpsEmailUrl(),hotelName,emailId,emailId);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }).start();
            }
        }
        redirectAttributes.addFlashAttribute("response", map);
//        String json = new Gson().toJson(map);
        return "redirect:joinedHotel";
    }

    @RequestMapping(value = "/pushUpdate", method = RequestMethod.POST)
    public String pushUpdate(RedirectAttributes redirectAttributes,
                         @RequestParam("hotelDetailId") String hotelDetailId, HttpSession session, HttpServletRequest request) throws Exception{

        PushContentDataModel pushContentDataModel=  new PushContentDataModel();
        pushContentDataModel.setHotelDetailId(hotelDetailId);
        pushContentDataModel.setStatus("N");

        Map map = (Map) pushContentDataDao.procPushContentData(pushContentDataModel, session.getAttribute("userName").toString(), "p").get(0);

        redirectAttributes.addFlashAttribute("response", map);
//        String json = new Gson().toJson(map);
        return "redirect:view";
    }

    @RequestMapping(value = "/approveContent", method = RequestMethod.POST)
    public String approveContent(RedirectAttributes redirectAttributes,
                         @RequestParam("hotelDetailId") String hotelDetailId, @RequestParam("remarks") String remarks, HttpSession session, HttpServletRequest request) throws Exception{

        PushContentDataModel pushContentDataModel=  new PushContentDataModel();
        pushContentDataModel.setHotelDetailId(hotelDetailId);
        pushContentDataModel.setStatus("P");

        Map map = (Map) pushContentDataDao.procPushContentData(pushContentDataModel, session.getAttribute("userName").toString(), "s").get(0);

        String pushContentDataId = map.get("push_content_data_id").toString();

        pushContentDataDao.procPushContentData(pushContentDataModel, session.getAttribute("userName").toString(), "approved");

        TempContentDataModel tempContentDataModel = new TempContentDataModel();
        tempContentDataModel.setPushContentDataId(pushContentDataId);
//        String[] updateField = {"hotelDetailId", "description", "customName"};
//        tempContentDataModel.setUpdateField(updateField);

        map = (Map) tempContentDataDao.procTempContentData(tempContentDataModel, session.getAttribute("userName").toString(), "p").get(0);
        System.out.println(map);
        /*HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setHotelDetailId(hotelDetailId);
        hotelDetailModel = new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailModel, null, "s").get(0));
        UserDetailModel userDetailModel = new UserDetailModel();
        userDetailModel.setUserDetailId(hotelDetailModel.getUserDetailId());
        userDetailModel = new UserDetailMapper().mapRow((Map) userDetailDao.procUserDetail(userDetailModel,null,"b").get(0));
        final    String hotelName=hotelDetailModel.getHotelName();
        final   String emailId=userDetailModel.getEmailId();*/

        // thread handling
        /*new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    EmailApi.sendActivationEmail(configModel.getTpsEmailUrl(),hotelName,emailId,emailId);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();*/
        /*hotelDetailModel.setActive("Y");


        map = (Map) hotelDetailDao.procHotelDetail(hotelDetailModel, session.getAttribute("userName").toString(), "v").get(0);*/


        redirectAttributes.addFlashAttribute("response", map);
//        String json = new Gson().toJson(map);
        return "redirect:pushedHotel";
    }

    @RequestMapping(value = "/rejectContent", method = RequestMethod.POST)
    public String rejectContent(RedirectAttributes redirectAttributes,
                                 @RequestParam("hotelDetailId") String hotelDetailId, @RequestParam("remarks") String remarks, HttpSession session, HttpServletRequest request) throws Exception{

        PushContentDataModel pushContentDataModel=  new PushContentDataModel();
        pushContentDataModel.setHotelDetailId(hotelDetailId);
        pushContentDataModel.setStatus("P");
        Map map = (Map) pushContentDataDao.procPushContentData(pushContentDataModel, session.getAttribute("userName").toString(), "s").get(0);

        String pushContentDataId = map.get("push_content_data_id").toString();
        pushContentDataModel.setPushContentDataId(pushContentDataId);
        pushContentDataModel.setRemarks(remarks);
        pushContentDataModel.setStatus("N");

        pushContentDataDao.procPushContentData(pushContentDataModel, session.getAttribute("userName").toString(), "reject");

        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setHotelDetailId(hotelDetailId);
        hotelDetailModel = new HotelDetailMapper().mapRow((Map) hotelDetailDao.procHotelDetail(hotelDetailModel, null, "s").get(0));
        UserDetailModel userDetailModel = new UserDetailModel();
        userDetailModel.setUserDetailId(hotelDetailModel.getUserDetailId());
        userDetailModel = new UserDetailMapper().mapRow((Map) userDetailDao.procUserDetail(userDetailModel,null,"b").get(0));
        final    String hotelName=hotelDetailModel.getHotelName();
        final   String emailId=userDetailModel.getEmailId();

        // thread handling
        /*new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    EmailApi.sendActivationEmail(configModel.getTpsEmailUrl(),hotelName,emailId,emailId);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();*/
        /*hotelDetailModel.setActive("Y");


        map = (Map) hotelDetailDao.procHotelDetail(hotelDetailModel, session.getAttribute("userName").toString(), "v").get(0);*/


//        String json = new Gson().toJson(map);
        return "redirect:/pushedHotel";
    }



    @RequestMapping(value = "/previewPushedHotel", method = RequestMethod.POST)
    public String previewPushedHotel(Model model,
                           @RequestParam("hotelDetailId") String hotelDetailId, @RequestParam("page") String page,  HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception{

        preview(model,hotelDetailId, page );


        return "preview";
    }

    @RequestMapping(value = "/preview", method = RequestMethod.POST)
//    @ResponseBody
    public String preview(Model model,
                          @RequestParam("hotelDetailId") String hotelDetailId, @RequestParam("page") String page) throws Exception{

        System.out.println(hotelDetailId);
        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setHotelDetailId(hotelDetailId);

        HotelFeatureModel hotelFeatureModel = new HotelFeatureModel();
        List<HotelActivityModel> hotelActivityModelList = new ArrayList<HotelActivityModel>();
        List<RoomDetailModel> roomDetailModelList = new ArrayList<RoomDetailModel>();
        List<RoomAmenityModel> roomAmenityModelList = new ArrayList<RoomAmenityModel>();
        List<HotelImageModel> hotelImageModelList = new ArrayList<HotelImageModel>();
        List<RoomImageModel> roomImageModelList = new ArrayList<RoomImageModel>();
        List<TempContentDataModel> tempContentDataModelList = new ArrayList<TempContentDataModel>();
        List<OfferModel> offerModelList = new ArrayList<OfferModel>();
        List<HotelRulesModel> hotelRulesModelList = new ArrayList<HotelRulesModel>();
        List<RoomImportanceModel> roomImportanceModelList = new ArrayList<RoomImportanceModel>();

       /* Map map = (Map) hotelDetailDao.procHotelDetail(hotelDetailModel, null,"p").get(0);
        System.out.println(map);*/
        Map map = (Map) hotelDetailDao.procHotelDetail(hotelDetailModel, null,"p").get(0);
        System.out.println(map);
        Map map1 = (Map) map.get("customKey");


        /*str1.toLowerCase().contains(str2.toLowerCase())


        map1.remove("#update")*/
        Set keySet = map1.keySet();

        System.out.println(keySet);

        for(int i =0;i<keySet.size(); i++){
            if(keySet.toArray()[i].toString().toLowerCase().contains("update")){
                continue;
            }
            List list = (ArrayList<Map>) map1.get(keySet.toArray()[i]);
            System.out.println(list);
            if(!list.isEmpty()){
                Map resultMap = (Map) list.get(0);
                if(resultMap.get("ref_table").equals("hotelDetail")){
                    hotelDetailModel = new HotelDetailMapper().mapRow(resultMap);
                    hotelFeatureModel = new HotelFeatureMapper().mapRow(resultMap);
                }else if(resultMap.get("ref_table").equals("hotelActivity")){
                    hotelActivityModelList= new HotelActivityMapper().mapList(list);
                }else if(resultMap.get("ref_table").equals("roomDetail")){
                    roomDetailModelList = new RoomDetailMapper().mapList(list);
                }else if(resultMap.get("ref_table").equals("roomAmenity")){
                    roomAmenityModelList = new RoomAmenityMapper().mapList(list);
                }else if(resultMap.get("ref_table").equals("hotelImage")){
                    hotelImageModelList = new HotelImageMapper().mapList(list);
                }else if(resultMap.get("ref_table").equals("roomImage")){
                    roomImageModelList = new RoomImageMapper().mapList(list);
                }else if(resultMap.get("ref_table").equals("tempContentData")){
                    tempContentDataModelList = new TempContentDataMapper().mapList(list);
                }else if(resultMap.get("ref_table").equals("offer")){
                    offerModelList = new OfferMapper().mapList(list);
                }else if(resultMap.get("ref_table").equals("roomImportance")){
                    roomImportanceModelList = new RoomImportanceMapper().mapList(list);
                }else if(resultMap.get("ref_table").equals("hotelRules")){
                    hotelRulesModelList = new HotelRulesMapper().mapList(list);
                }
            }
        }
        map = new HashMap();
        /*List list = new ArrayList();
        Map nestedMap = new HashMap();*/
        for(TempContentDataModel tempContentDataModel: tempContentDataModelList){
            /*System.out.println(map.get(tempContentDataModel.getField()));
            if(map.get(tempContentDataModel.getField()) == null){
                nestedMap.put("contentData",tempContentDataModel.getContentData());
                nestedMap.put("id", tempContentDataModel.getRefId());
                list.add(nestedMap);
                map.put(tempContentDataModel.getField(),list);
            }else{
                list = new ArrayList<>(map.get(tempContentDataModel.getField()));

                nestedMap.put("contentData",tempContentDataModel.getContentData());
                nestedMap.put("id", tempContentDataModel.getRefId());
            }*/
            map.put(tempContentDataModel.getField()+tempContentDataModel.getRefId()+tempContentDataModel.getType(), tempContentDataModel.getContentData());
//            map.put("id", tempContentDataModel.getRefId());
        }
        System.out.println("size: "+hotelActivityModelList.size());
        model.addAttribute("hotelDetailMap", hotelDetailModel);
        model.addAttribute("hotelFeatureMap", hotelFeatureModel);
        model.addAttribute("hotelActivityList", hotelActivityModelList);
        model.addAttribute("roomDetailList", roomDetailModelList);
        model.addAttribute("roomAmentityList", roomAmenityModelList);
        model.addAttribute("hotelImageList", hotelImageModelList);
        model.addAttribute("roomImageList", roomImageModelList);
        model.addAttribute("offerList", offerModelList);
        model.addAttribute("hotelRulesList", hotelRulesModelList);
        model.addAttribute("roomImportanceList", roomImportanceModelList);
        model.addAttribute("tempContentData", map);
        model.addAttribute("action",page);
        model.addAttribute("base", "hotelDetail");

//        String keyName = map.keySet().toArray()[0].toString();
       /* model.addAttribute("keySet123", keySet);
        model.addAttribute("valueSet", map);*/


        return "preview";
    }


    /*@RequestMapping(value = "/assignProperty", method = RequestMethod.GET)
    public String assignProperty(Model model) throws Exception {

        List<UserDetailModel> userDetailModelList = new UserDetailMapper().mapList(userDetailDao.procUserDetail(new UserDetailModel(),null,"h"));
        model.addAttribute("userDetaiList", userDetailModelList);

        *//*List<HotelDetailModel> hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(new HotelDetailModel(), null, "n"));
        model.addAttribute("unassignHotelDetailList", hotelDetailModelList);

        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setUserDetailId(session.getAttribute("userDetailId").toString());
        hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(hotelDetailModel,null,"s"));
        model.addAttribute("assignHotelDetailList", hotelDetailModelList);*//*

        return "assignHotel";
    }

    @RequestMapping(value = "/assignPropertyList", method = RequestMethod.POST)
    public String assignPropertyList(HttpSession session, RedirectAttributes redirectAttributes, String userDetailId) throws Exception {

       *//* List<UserDetailModel> userDetailModelList = new UserDetailMapper().mapList(userDetailDao.procUserDetail(new UserDetailModel(),null,"h"));
        model.addAttribute("userDetaiList", userDetailModelList);*//*

        List<HotelDetailModel> hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(new HotelDetailModel(), null, "n"));
        redirectAttributes.addFlashAttribute("unassignHotelDetailList", hotelDetailModelList);

        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setUserDetailId(session.getAttribute("userDetailId").toString());
        hotelDetailModelList = new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(hotelDetailModel,null,"s"));
        redirectAttributes.addFlashAttribute("assignHotelDetailList", hotelDetailModelList);

        redirectAttributes.addFlashAttribute("userDetailId", userDetailId);

        return "redirect:../hotelDetail/assignHotel";
    }

    @RequestMapping(value = "/assignProperty", method = RequestMethod.POST)
    public void assignProperty(HttpSession session, RedirectAttributes redirectAttributes, String userDetailId, String[] hotelDetailList) throws Exception {

        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setUserDetailId(userDetailId);

        Map map = new HashMap();

        for(int i = 0;i<hotelDetailList.length;i++){
            hotelDetailModel.setHotelDetailId(hotelDetailList[i]);
            map = (Map) hotelDetailDao.procHotelDetail(hotelDetailModel, session.getAttribute("userName").toString(), "u").get(0);
        }

        redirectAttributes.addFlashAttribute("response", map);
        assignPropertyList(session, redirectAttributes, userDetailId);
    }*/
}
