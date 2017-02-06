package igc.tech.com.controller;


import com.google.gson.Gson;
import igc.tech.com.dao.*;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.HotelImageMapper;
import igc.tech.com.mapper.RoomDetailMapper;
import igc.tech.com.mapper.RoomImageMapper;
import igc.tech.com.model.*;
import igc.tech.com.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
@RequestMapping(value = "/image")
class ImageController {

    @Autowired
    HotelFeatureDao hotelFeatureDao;

    @Autowired
    HotelActivityDao hotelActivityDao;

    @Autowired
    RoomDetailDao roomDetailDao;

    @Autowired
    RoomAmenityDao roomAmenityDao;

    @Autowired
    HotelImageDao hotelImageDao;

    @Autowired
    RoomImageDao roomImageDao;

    @Autowired
    TempContentDataDao tempContentDataDao;

    HashMap<String, String[]> siteContent = new HashMap<String, String[]>();

    static final String hotelImageBaseUrl = System.getProperty("catalina.home") + "/webapps/TPSResources/HotelImages/";

    static final String roomImageBaseUrl = System.getProperty("catalina.home") + "/webapps/TPSResources/RoomImages/";

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model, HttpSession session) {

        String hotelDetailId = session.getAttribute("hotelDetailId").toString();

        RoomDetailModel roomDetailModel = new RoomDetailModel();
        roomDetailModel.setHotelDetailId(hotelDetailId);
        List<RoomDetailModel> roomDetailModelList = new RoomDetailMapper().mapList(roomDetailDao.procRoomDetail(roomDetailModel,null,"s"));
        model.addAttribute("roomDetailList", roomDetailModelList);
        model.addAttribute("hotelDetailId", hotelDetailId);
        model.addAttribute("base", "image");
        siteContent.put("css", new String[]{"dropzone/dropzone.css","blueimp/css/blueimp-gallery.min.css"});
        siteContent.put("js", new String[]{"dropzone/dropzone.js","blueimp/jquery.blueimp-gallery.min.js"});


        model.addAttribute("siteContent", siteContent);
        model.addAttribute("step",5);
        if(session.getAttribute("token")==null){
            return "adminTemplate";
        }else{

            return "joinTemplate";
        }


    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public
    @ResponseBody
    String upload(MultipartHttpServletRequest request,
                HttpServletResponse response, HttpSession session) throws IOException, Exception {

        // Getting uploaded files from the request object
        Map<String, MultipartFile> fileMap = request.getFileMap();

        System.out.println("fileMap " + fileMap.size());

        Utility util = new Utility();


        String saveDirectory =
                hotelImageBaseUrl +
                        request.getParameter("hotelDetailId") + "/";

        File file = new File(hotelImageBaseUrl +
                request.getParameter("hotelDetailId"));


        File file2 = new File(hotelImageBaseUrl +
                request.getParameter("hotelDetailId") + "/deleted");

        File file3 = new File(hotelImageBaseUrl +
                request.getParameter("hotelDetailId") + "/small");

        File file4 = new File(hotelImageBaseUrl +
                request.getParameter("hotelDetailId") + "/deleted/small");

        if (!file.exists()) {
            file.mkdir();
        }

        if (!file2.exists()) {
            file2.mkdir();
        }

        if (!file3.exists()) {
            file3.mkdir();
        }

        if (!file4.exists()) {
            file4.mkdir();
        }

        TempContentDataModel tempContentDataModel = new TempContentDataModel();
        tempContentDataModel.setType("hotel_image");
        tempContentDataModel.setPushContentDataId(session.getAttribute("pushContentDataId").toString());

        List<Map> list = new ArrayList<>();
        // Iterate through the map
        int i=0;
        for (MultipartFile multipartFile : fileMap.values()) {

            System.out.println("multipart file " + multipartFile);

            String caption = "";

            if (request.getParameter("caption") == null) {
                caption = "caption";
            } else {
                caption = request.getParameter("caption");
            }



            double random = Math.random() * 50 + 1;

            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Calendar.getInstance().getTime());
            System.out.println("content type: "+multipartFile.getContentType());

            String newFileName = util.generateFileName(multipartFile, util.md5(timeStamp) + random);
            String imageType = multipartFile.getContentType().substring(multipartFile.getContentType().lastIndexOf("/")+1);
            System.out.println("type"+ imageType);

            BufferedImage image = ImageIO.read(multipartFile.getInputStream());

            BufferedImage smallImage = resizeImage(image, image.getType());
            ImageIO.write(smallImage, imageType, new File(saveDirectory +"/small/"+newFileName));  // ignore returned boolean



            ImageIO.write(smallImage, imageType, new File(saveDirectory +newFileName));
//            multipartFile.transferTo(new File(saveDirectory + newFileName));

            HotelImageModel hotelImageModel = new HotelImageModel();
            hotelImageModel.setHotelDetailId(request.getParameter("hotelDetailId"));
            hotelImageModel.setThumbnail("Y");
            if(i==0){
                List l = hotelImageDao.procHotelImage(hotelImageModel, session.getAttribute("userName").toString(),"s");
                if(!l.isEmpty()){
                    hotelImageModel.setThumbnail("N");
                }
                i++;
            }
//            hotelImageModel.setCaption(caption);
            hotelImageModel.setFileName(newFileName);
//            hotelImageModel.setImageUrl(request.getParameter("hotelDetailId") + "/" + newFileName);
            hotelImageModel.setFileType(multipartFile.getContentType());



            Map map = (Map) hotelImageDao.procHotelImage(hotelImageModel, session.getAttribute("userName").toString(), "i").get(0);
            list.add(map);

            tempContentDataModel.setRefId(map.get("hotel_image_id").toString());
            tempContentDataModel.setField("image_url");
            tempContentDataModel.setContentData(request.getParameter("hotelDetailId") + "/" + newFileName);
            tempContentDataDao.procTempContentData(tempContentDataModel, session.getAttribute("userName").toString(), "u");


        }

        System.out.println(list);
        String json = new Gson().toJson(list);
        return json;

    }

        private BufferedImage resizeImage(BufferedImage originalImage, int type){
            /* aspect ration (width / height) = (new_width / new_height)*/
            double ratio = (double) originalImage.getWidth() / originalImage.getHeight();
            double height = 830/ratio;
            int newHeight = (int) height;


//            new_height * (width / height) = new_width
            originalImage.getHeight();
            BufferedImage resizedImage = new BufferedImage(830, newHeight, type);
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(originalImage, 0, 0, 830, newHeight, null);
            g.dispose();

            return resizedImage;
        }

    @RequestMapping(value = "/deleteImage", method = RequestMethod.POST)
    public
    @ResponseBody
    String deleteImage(HttpServletRequest request,
                     HttpServletResponse response, HttpSession session, String hotelDetailId) throws IOException, Exception {


        String json = new Gson().toJson(request.getParameterMap().get("file_to_be_deleted"));
        String imageId = "";

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(json);
        while (m.find()) {
            imageId = m.group(1);
            System.out.println(m.group(1));
        }

        HotelImageModel hotelImageModel = new HotelImageModel();
        hotelImageModel.setHotelImageId(imageId);

        Map image = (Map) hotelImageDao.procHotelImage(hotelImageModel, null, "s").get(0);

        hotelImageModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());
        Map map = (Map) hotelImageDao.procHotelImage(hotelImageModel,
                session.getAttribute("userName").toString(), "d").get(0);

        System.out.println(map);

       /* hotelImageModel = new HotelImageModel();
        hotelImageModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());
        hotelImageModel.setThumbnail("N");
        List l = hotelImageDao.procHotelImage(hotelImageModel, null,"s");
        if(l.isEmpty()){
            hotelImageModel.setThumbnail("Y");
        }*/


        if (map.get("status").equals("SUCCESS")) {

            String source = hotelImageBaseUrl + image.get("image_url");


            StringBuilder str = new StringBuilder(image.get("image_url").toString());
            str.insert(str.indexOf("/")+1,"small/");
            /*String imageUrl = image.get("image_url").toString();
            imageUrl.inse*/
            System.out.println(str);
            String source1 = hotelImageBaseUrl +str;

            String target = hotelImageBaseUrl + image.get("hotel_detail_id") + "/deleted/" + image.get("file_name");
            String targetSmall = hotelImageBaseUrl + image.get("hotel_detail_id") + "/deleted/small/" + image.get("file_name");
            System.out.println(targetSmall);


            Path movefrom = FileSystems.getDefault().getPath(source);
            Path moveSmall = FileSystems.getDefault().getPath(source1);
            Path target1 = FileSystems.getDefault().getPath(target);
            Path targetSmall1 = FileSystems.getDefault().getPath(targetSmall);
            System.out.println("moveFrom"+movefrom+"target"+target1);

            try {
                Files.move(movefrom, target1, StandardCopyOption.REPLACE_EXISTING);
                Files.move(moveSmall, targetSmall1, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.err.println(e);
            }


        }

        json = new Gson().toJson(map);
        return json;

        /*while (request.getParameterNames().hasMoreElements()){
            request.getParameter(request.getParameterMap())
        }
*/



        /*String json = new Gson().toJson(list );
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);*/

    }

    @RequestMapping(value = "getImage/{hotelId}", method = RequestMethod.GET)
    public
    @ResponseBody
    String
    getHotelImage(@PathVariable("hotelId") String hotelDetailId, HttpServletResponse response) throws Exception {
        //Get the images list from repository
        HotelImageModel hotelImageModel = new HotelImageModel();
        hotelImageModel.setHotelDetailId(hotelDetailId);
        List<HotelImageModel> hotelImageModelList = new HotelImageMapper().mapList(hotelImageDao.procHotelImage(hotelImageModel, null, "s"));
        System.out.println(hotelImageModelList);
       /* List<HotelImageModel> attachmentsList =  new List<HotelImageModel>();
        {
            new AttachmentsModel {AttachmentID = 1, FileName = "/images/wallimages/dropzonelayout.png", Path = "/images/wallimages/dropzonelayout.png"},
            new AttachmentsModel {AttachmentID = 1, FileName = "/images/wallimages/imageslider-3.png", Path = "/images/wallimages/imageslider-3.png"}
        }.ToList();
*/
        String json = new Gson().toJson(hotelImageModelList);
        System.out.println(json);

       return json;
    }

    @RequestMapping(value = "/uploadRoomImage", method = RequestMethod.POST)
    public
    @ResponseBody
    String uploadRoomImage(MultipartHttpServletRequest request,
                         HttpServletResponse response, HttpSession session, String roomDetailId) throws IOException, Exception {

        Utility util = new Utility();


        String saveDirectory =
                roomImageBaseUrl +
                        roomDetailId + "/";

        File file = new File(roomImageBaseUrl +
                roomDetailId);


        File file2 = new File(roomImageBaseUrl +
                roomDetailId + "/deleted");

        if (!file.exists()) {
            file.mkdir();
        }

        if (!file2.exists()) {
            file2.mkdir();
        }

        // Getting uploaded files from the request object
        Map<String, MultipartFile> fileMap = request.getFileMap();

        System.out.println("fileMap " + fileMap.toString());

        // Maintain a list to send back the files info. to the client side
//        List<HotelImageModel> uploadedFiles = new ArrayList<HotelImageModel>();
        TempContentDataModel tempContentDataModel = new TempContentDataModel();
        tempContentDataModel.setType("room_image");
        tempContentDataModel.setPushContentDataId(session.getAttribute("pushContentDataId").toString());
int i =0;
        List<Map> list = new ArrayList<>();
        // Iterate through the map
        for (MultipartFile multipartFile : fileMap.values()) {

            System.out.println("multipart file " + multipartFile);
            // Save the file to local disk
//            saveDirectory + multipartFile.getOriginalFilename();
//            FileCopyUtils.copy(multipartFile.getBytes(), new FileOutputStream(outputFileName));
            String caption = "";

            if (request.getParameter("caption") == null) {
                caption = "caption";
            } else {
                caption = request.getParameter("caption");
            }

            double random = Math.random() * 50 + 1;

            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Calendar.getInstance().getTime());


            String newFileName = util.generateFileName(multipartFile, util.md5(timeStamp) + random);
            BufferedImage image = ImageIO.read(multipartFile.getInputStream());
            BufferedImage smallImage = resizeImage(image, image.getType());

            String imageType = multipartFile.getContentType().substring(multipartFile.getContentType().lastIndexOf("/")+1);
            ImageIO.write(smallImage, imageType, new File(saveDirectory +newFileName));
            /*double bytes = multipartFile.getSize();
            double fileInKb = bytes/1024;*/
            /*float quality = 0.7f;

           *//* System.out.println(fileInKb);
            System.out.println("File Size: " + String.format("%.2f", bytes/1024) + "kb");

            if(fileInKb>102400)
                quality=0.05f;*//*

            JPEGImageWriteParam jpegParams = new JPEGImageWriteParam(null);
            jpegParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            jpegParams.setCompressionQuality(quality);

            final ImageWriter writer = ImageIO.getImageWritersByFormatName(imageType).next();
// specifies where the jpg image has to be written
            writer.setOutput(new FileImageOutputStream(
                    new File(saveDirectory + newFileName)));

// writes the file with given compression level
// from your JPEGImageWriteParam instance
            writer.write(null, new IIOImage(smallImage, null, null), jpegParams);*/
//            multipartFile.transferTo(new File(saveDirectory + newFileName));

            RoomImageModel roomImageModel = new RoomImageModel();
            roomImageModel.setRoomDetailId(roomDetailId);
            roomImageModel.setThumbnail("Y");
            if(i==0){
                List l = roomImageDao.procRoomImage(roomImageModel, session.getAttribute("userName").toString(),"s");
                if(!l.isEmpty()){
                    roomImageModel.setThumbnail("N");
                }
                i++;
            }
//            hotelImageModel.setCaption(caption);
            roomImageModel.setFileName(newFileName);
//            roomImageModel.setImageUrl(roomDetailId + "/" + newFileName);
            roomImageModel.setFileType(multipartFile.getContentType());

            System.out.println(roomImageModel);
            // Save the file info to database
//      fileInfo = saveFileToDatabase(fileInfo);

            Map map = (Map) roomImageDao.procRoomImage(roomImageModel, session.getAttribute("userName").toString(), "i").get(0);
            list.add(map);

            tempContentDataModel.setRefId(map.get("room_image_id").toString());
            tempContentDataModel.setField("image_url");
            tempContentDataModel.setContentData(roomDetailId + "/" + newFileName);
            tempContentDataDao.procTempContentData(tempContentDataModel, session.getAttribute("userName").toString(), "u");


            // adding the file info to the list
//            uploadedFiles.add(hotelImageModel);
        }

        String json = new Gson().toJson(list);
        return json;

    }


    @RequestMapping(value = "/deleteRoomImage", method = RequestMethod.POST)
    public
    @ResponseBody
    String deleteRoomImage(HttpServletRequest request,
                         HttpServletResponse response, HttpSession session, String id) throws IOException, Exception {

        System.out.println("id"+ id);


        String json = new Gson().toJson(request.getParameterMap().get("file_to_be_deleted"));
        String imageId = "";

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(json);
        while (m.find()) {
            imageId = m.group(1);
            System.out.println(m.group(1));
        }

        RoomImageModel roomImageModel = new RoomImageModel();
        roomImageModel.setRoomImageId(imageId);

        Map image = (Map) roomImageDao.procRoomImage(roomImageModel, null, "s").get(0);

        roomImageModel.setRoomDetailId(id);
        Map map = (Map) roomImageDao.procRoomImage(roomImageModel,
                session.getAttribute("userName").toString(), "d").get(0);


        if (map.get("status").equals("SUCCESS")) {

            String source = roomImageBaseUrl + image.get("image_url");

            String target = roomImageBaseUrl + image.get("room_detail_id") + "/deleted/" + image.get("file_name");


            Path movefrom = FileSystems.getDefault().getPath(source);
            Path target1 = FileSystems.getDefault().getPath(target);

            try {
                Files.move(movefrom, target1, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.err.println(e);
            }


        }

        json = new Gson().toJson(map);
        return json;

        /*while (request.getParameterNames().hasMoreElements()){
            request.getParameter(request.getParameterMap())
        }
*/



        /*String json = new Gson().toJson(list );
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);*/

    }

    @RequestMapping(value = "getRoomImage/{roomId}", method = RequestMethod.GET)
    public
    @ResponseBody
    String
    getRoomImage(@PathVariable("roomId") String roomDetailId, HttpServletResponse response) throws Exception {
        //Get the images list from repository
        RoomImageModel roomImageModel = new RoomImageModel();
        roomImageModel.setRoomDetailId(roomDetailId);
        List<RoomImageModel> roomImageModelList = new RoomImageMapper().mapList(roomImageDao.procRoomImage(roomImageModel, null, "s"));
        System.out.println(roomImageModelList);
       /* List<HotelImageModel> attachmentsList =  new List<HotelImageModel>();
        {
            new AttachmentsModel {AttachmentID = 1, FileName = "/images/wallimages/dropzonelayout.png", Path = "/images/wallimages/dropzonelayout.png"},
            new AttachmentsModel {AttachmentID = 1, FileName = "/images/wallimages/imageslider-3.png", Path = "/images/wallimages/imageslider-3.png"}
        }.ToList();
*/
        String json = new Gson().toJson(roomImageModelList);
        System.out.println(json);

        return json;
    }

    @RequestMapping(value = "hotelCaption", method = RequestMethod.POST)
    public
    @ResponseBody
    void
    updateHotelImageCaption(String caption, String imageId, HttpServletResponse response, HttpSession session) throws Exception {
        //Get the images list from repository
        HotelImageModel hotelImageModel = new HotelImageModel();
        hotelImageModel.setCaption(caption);
        hotelImageModel.setHotelImageId(imageId);

        System.out.println(hotelImageModel);

        Map map = (Map) hotelImageDao.procHotelImage(hotelImageModel,session.getAttribute("userName").toString(),"u").get(0);

    }

    @RequestMapping(value = "hotelThumbnail", method = RequestMethod.POST)
    public
    @ResponseBody
    void
    updateHotelImageThumbnail(String id, String imageId, HttpServletResponse response, HttpSession session) throws Exception {
        //Get the images list from repository
        HotelImageModel hotelImageModel = new HotelImageModel();
        hotelImageModel.setThumbnail("N");
        hotelImageModel.setHotelDetailId(id);
        hotelImageDao.procHotelImage(hotelImageModel,session.getAttribute("userName").toString(),"u");

        hotelImageModel.setHotelImageId(imageId);
        hotelImageModel.setThumbnail("Y");
        hotelImageDao.procHotelImage(hotelImageModel,session.getAttribute("userName").toString(),"u");

    }

    @RequestMapping(value = "roomCaption", method = RequestMethod.POST)
    public
    @ResponseBody
    void
    updateRoomImageCaption(String caption, String imageId, HttpServletResponse response, HttpSession session) throws Exception {
        //Get the images list from repository
        RoomImageModel roomImageModel = new RoomImageModel();
        roomImageModel.setCaption(caption);
        roomImageModel.setRoomImageId(imageId);

        Map map = (Map) roomImageDao.procRoomImage(roomImageModel,session.getAttribute("userName").toString(),"u").get(0);

    }

    @RequestMapping(value = "roomThumbnail", method = RequestMethod.POST)
    public
    @ResponseBody
    void
    updateRoomImageThumbnail(String id, String imageId, HttpServletResponse response, HttpSession session) throws Exception {
        //Get the images list from repository
        RoomImageModel roomImageModel = new RoomImageModel();
        roomImageModel.setThumbnail("N");
        roomImageModel.setRoomDetailId(id);
        roomImageDao.procRoomImage(roomImageModel,session.getAttribute("userName").toString(),"u");

        roomImageModel.setRoomImageId(imageId);
        roomImageModel.setRoomDetailId(id);
        roomImageModel.setThumbnail("Y");
        roomImageDao.procRoomImage(roomImageModel,session.getAttribute("userName").toString(),"u");

    }


}
