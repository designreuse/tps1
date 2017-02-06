package igc.tech.com.controller;

import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.dao.HotelImageDao;
import igc.tech.com.dao.RoomImageDao;
import igc.tech.com.dao.RoomTypeDao;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.HotelImageMapper;
import igc.tech.com.mapper.RoomImageMapper;
import igc.tech.com.mapper.RoomTypeMapper;
import igc.tech.com.model.*;
import igc.tech.com.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/14/2016.
 */

@Controller
@RequestMapping(value = "/roomImage")
public class RoomImageController {
    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    RoomTypeDao roomTypeDao;

    @Autowired
    HotelImageDao hotelImageDao;


    @Autowired
    RoomImageDao roomImageDao;


    @Autowired
    ServletContext servletContext;
    @Autowired
    FileModel fileModel;
    @Autowired
    private HttpServletRequest request;


    static final String roomImageBaseUrl = System.getProperty("catalina.home") + "/webapps/TPSResources/RoomImages/";

    LinkedList<FileMeta> files = new LinkedList();
    FileMeta fileMeta = null;

    Utility utl = new Utility();


    @RequestMapping(
            value = {"/view"},
            method = {RequestMethod.GET}
    )
    public String getAll(Model model) {

        List list1 = new HotelImageMapper().mapList(hotelImageDao.procHotelImage(null, null, null, null, null,
                null, null, null, null, "a"));


        List list = (new HotelDetailMapper()).mapList(this.hotelDetailDao.procHotelDetail((String) null,
                (String) null, (String) null, (String) null, (String) null,
                (String) null, (String) null, (String) null, (String) null,
                (String) null, (String) null, (String) null, (String) null,
                (String) null, "a"));
        model.addAttribute("hotelDetailList", list);
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }

        return "roomImage";
    }


    @RequestMapping(value = "/roomList", method = RequestMethod.POST)
    public String getAllList(Model model, RoomTypeModel roomTypeModel, HttpSession session) {

        if (roomTypeModel.getHotelDetailId().equals("") || roomTypeModel.getHotelDetailId().equals(null)) {

            return "error";
        }

        List<RoomTypeModel> list = new RoomTypeMapper().
                mapList(roomTypeDao.procRoomType(null, roomTypeModel.getHotelDetailId(), null, null, null, null, null, null, null, null,
                        null, "s"));
        session.setAttribute("hotelIdForRoom", roomTypeModel.getHotelDetailId());
        model.addAttribute("IndividualList", list);
        model.addAttribute("listView", "listView");
        model.addAttribute("noView", "noView");


        return getAll(model);

    }


    @RequestMapping(
            value = {"/viewImages/{id}"},
            method = {RequestMethod.GET}
    )
    public String viewImage(Model model, @PathVariable("id") String roomTypeId, HttpSession session) {


        List<RoomImageModel> roomImageModelList = new RoomImageMapper().mapList(roomImageDao.procRoomImage(null,
                roomTypeId.trim(), null, null, null, null, null, null, null, "s"
        ));


        model.addAttribute("roomImageModelList", roomImageModelList);
        model.addAttribute("noView", "noView");
        model.addAttribute("ImageView", "ImageView");
        session.setAttribute("roomTypeIdForImage", roomTypeId);

        return "roomImage";
    }

    @RequestMapping(
            value = {"/uploadFile"},
            method = {RequestMethod.GET}
    )
    public String handleFileUpload(Model model) {


        model.addAttribute("UploadView", "UploadView");
        model.addAttribute("noView", "noView");
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }

        return getAll(model);
    }


    @RequestMapping(
            value = {"/upload"},
            method = {RequestMethod.POST}
    )

    public
    @ResponseBody
    String upload(MultipartHttpServletRequest request, HttpSession session, Model model) {


        String saveDirectory =
                roomImageBaseUrl +
                        session.getAttribute("roomTypeIdForImage") + "/";

        File file = new File(roomImageBaseUrl +
                session.getAttribute("roomTypeIdForImage"));


        File file2 = new File(roomImageBaseUrl +
                session.getAttribute("roomTypeIdForImage") + "/deleted");


        if (!file.exists()) {
            file.mkdir();
        }

        if (!file2.exists()) {
            file2.mkdir();
        }


        Iterator itr = request.getFileNames();


        for (MultipartFile mpf = null; itr.hasNext(); this.files.add(this.fileMeta)) {
            mpf = request.getFile((String) itr.next());




            String contentType = mpf.getContentType();
            Long fileSizeInBytes = mpf.getSize();

            if ((contentType.equalsIgnoreCase("image/jpg") || contentType.equalsIgnoreCase("image/png") ||
                    contentType.equalsIgnoreCase("image/jpeg")) && (fileSizeInBytes < 5000000)) {

                try {


                    double random = Math.random() * 50 + 1;

                    String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Calendar.getInstance().getTime());


                    String newFileName = utl.generateFileName(mpf, utl.md5(timeStamp) + random);
                    String tempType = utl.getContentType(mpf);
                    String title = request.getParameter("title[]");
                    mpf.transferTo(new File(saveDirectory + newFileName));
                    String roomTypeId = session.getAttribute("roomTypeIdForImage").toString();


                    Map map = (Map) roomImageDao.procRoomImage(null, roomTypeId,
                            newFileName, title, roomTypeId + "/" + newFileName, tempType, null, null,
                            session.getAttribute("userName").toString(), "i").get(0);

                    //  System.out.println(map);


                } catch (Exception e) {
                    e.printStackTrace();
                }


            } else {
                return "file:error";
            }


        }
        return null;
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model,
                         @RequestParam("id") String roomImageId, HttpSession session) {

        if (!utl.checkSession(session, "roomTypeIdForImage")) {

            session.invalidate();
            model.addAttribute("mode", "sessionExpired");
            return "error";

        }

        /*search existing Image to take info*/
        Map image = (Map) roomImageDao.procRoomImage(roomImageId,
                null, null, null, null, null, null,
                null, null, "s").get(0);

        /*perform delete*/
        Map map = (Map) roomImageDao.procRoomImage(roomImageId,
                null, null, null, null, null, null, null,
                session.getAttribute("userName").toString(), "d").get(0);


        if (map.get("status").equals("SUCCESS")) {

            String source = roomImageBaseUrl + image.get("image_url");

            String target = roomImageBaseUrl + image.get("room_type_id") + "/deleted/" + image.get("file_name");


            Path movefrom = FileSystems.getDefault().getPath(source);
            Path target1 =  FileSystems.getDefault().getPath(target);

            try {
                Files.move(movefrom, target1, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.err.println(e);
            }


        }


        model.addAttribute("dbResponse", map);
        List roomImageModelList = new RoomImageMapper().mapList(roomImageDao.procRoomImage(null,
                session.getAttribute("roomTypeIdForImage").toString(), null, null,
                null, null, null, null, null, "s" ));
        model.addAttribute("roomImageModelList", roomImageModelList);
        model.addAttribute("noView", "noView");
        model.addAttribute("ImageView", "ImageView");
        return getAll(model);
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, @RequestParam("roomImageId[]") String roomImageId[],
                       @RequestParam("caption[]") String caption[], @RequestParam("thumbnail") String thumbnail, @RequestParam("active[]") String active[],

                       HttpSession session) {

        Map map = null;
        String imageCaption, imageActive = null;
        boolean activeFlag = false;


        for (int i = 0; i < roomImageId.length; i++) {
            String imageID = roomImageId[i];

            if (caption.length < 1) {
                imageCaption = "";
            } else {
                imageCaption = caption[i];
            }

            String imageThumbnail = null;
            //  System.out.println(thumbnail);

            if (imageID.equals(thumbnail)) {

                imageThumbnail = "Y";
            } else {
                imageThumbnail = "N";
            }

            /*perform update*/



            map = (Map) roomImageDao.procRoomImage(imageID,
                    null, null, imageCaption, null, null, imageThumbnail, "N", null, "u").get(0);

            /*check for active on site*/

            for (int j = 0; j < active.length; j++) {

                if (imageID.equals(active[j])) {

                    map = (Map)roomImageDao.procRoomImage(imageID,
                            null, null, imageCaption, null, null, imageThumbnail, "Y", null, "u").get(0);
                }


            }


        }


        model.addAttribute("dbResponse", map);

        List roomImageModelList = new RoomImageMapper().mapList(roomImageDao.procRoomImage(null,
                session.getAttribute("roomTypeIdForImage").toString(), null, null,
                null, null, null, null, null, "s" ));

        model.addAttribute("roomImageModelList", roomImageModelList);
        model.addAttribute("noView", "noView");
        model.addAttribute("ImageView", "ImageView");

        return getAll(model);

    }


}
