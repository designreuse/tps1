package igc.tech.com.controller;


import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.dao.HotelImageDao;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.HotelImageMapper;
import igc.tech.com.model.FileMeta;
import igc.tech.com.model.FileModel;
import igc.tech.com.model.FileUpload;
import igc.tech.com.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;
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


@Controller
@RequestMapping(value = "/hotelImage")
public class HotelImageController extends HttpServlet {
    @Autowired
    HotelDetailDao hotelDetailDao;
    @Autowired
    HotelImageDao hotelImageDao;
    @Autowired
    ServletContext servletContext;
    @Autowired
    FileModel fileModel;
    @Autowired
    private HttpServletRequest request;


    static final String hotelImageBaseUrl = System.getProperty("catalina.home") + "/webapps/TPSResources/HotelImages/";




    LinkedList<FileMeta> files = new LinkedList();
    FileMeta fileMeta = null;

    Utility utl = new Utility();


    @RequestMapping(
            value = {"/view"},
            method = {RequestMethod.GET}
    )
    public String getAll(Model model) {

        System.out.println("=================================");

        System.out.println("catlina base"+ System.getProperty("catalina.home"));
        System.out.println("=================================");



        List list = (new HotelDetailMapper()).mapList(this.hotelDetailDao.procHotelDetail((String) null,
                (String) null, (String) null, (String) null, (String) null,
                (String) null, (String) null, (String) null, (String) null,
                (String) null, (String) null, (String) null, (String) null
                , (String) null, "a"));
        model.addAttribute("hotelDetailList", list);
        if (!model.containsAttribute("noView")) {
            model.addAttribute("mode", "view");
        }

        return "hotelImage";
    }

    @RequestMapping(
            value = {"/viewImages"},
            method = {RequestMethod.POST}
    )
    public String viewImage(Model model, @RequestParam("hotelDetailId") String hotelDetailId, HttpSession session) {



        List hotelImageModelList = (new HotelImageMapper()).mapList(this.hotelImageDao.procHotelImage((String) null,
                hotelDetailId.trim(), (String) null,
                (String) null, (String) null,
                (String) null, (String) null,
                (String) null, (String) null, "s"));




        System.out.println(hotelImageModelList);

        model.addAttribute("hotelImageModelList", hotelImageModelList);
        model.addAttribute("noView", "noView");
        model.addAttribute("ImageView", "ImageView");
        session.setAttribute("HotelDetailIDForImage", hotelDetailId);
        return this.getAll(model);
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

        return "hotelImage";
    }


    @RequestMapping(
            value = {"/upload"},
            method = {RequestMethod.POST}
    )

    public
    @ResponseBody
    String upload(MultipartHttpServletRequest request, HttpSession session, Model model) {


        String saveDirectory =
                hotelImageBaseUrl +
                        session.getAttribute("HotelDetailIDForImage") + "/";

        File file = new File(hotelImageBaseUrl +
                session.getAttribute("HotelDetailIDForImage"));


        File file2 = new File(hotelImageBaseUrl +
                session.getAttribute("HotelDetailIDForImage") + "/deleted");


        if (!file.exists()) {
            file.mkdir();
        }

        if (!file2.exists()) {
            file2.mkdir();
        }


        Iterator itr = request.getFileNames();


        for (MultipartFile mpf = null; itr.hasNext(); this.files.add(this.fileMeta)) {
            mpf = request.getFile((String) itr.next());

            this.fileMeta = new FileMeta();
            this.fileMeta.setFileName(mpf.getOriginalFilename());
            this.fileMeta.setFileSize(mpf.getSize() / 1024L + " Kb");
            this.fileMeta.setFileType(mpf.getContentType());

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
                    String HotelDetailId = session.getAttribute("HotelDetailIDForImage").toString();


                    Map map = (Map) hotelImageDao.procHotelImage(null, HotelDetailId,
                            newFileName, title, HotelDetailId + "/" + newFileName, tempType, null, null,
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
                         @RequestParam("id") String hotelImageId, HttpSession session) {

        if (!utl.checkSession(session, "HotelDetailIDForImage")) {

            session.invalidate();
            model.addAttribute("mode", "sessionExpired");
            return "error";

        }

        Map image = (Map) hotelImageDao.procHotelImage(hotelImageId,
                null, null, null, null, null, null,
                null, null, "s").get(0);

        Map map = (Map) hotelImageDao.procHotelImage(hotelImageId,
                null, null, null, null, null, null, null,
                session.getAttribute("userName").toString(), "d").get(0);


        if (map.get("status").equals("SUCCESS")) {

            String source = hotelImageBaseUrl + image.get("image_url");

            String target = hotelImageBaseUrl + image.get("hotel_detail_id") + "/deleted/" + image.get("file_name");


            Path movefrom = FileSystems.getDefault().getPath(source);
            Path target1 = FileSystems.getDefault().getPath(target);

            try {
                Files.move(movefrom, target1, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.err.println(e);
            }


        }


        model.addAttribute("dbResponse", map);
        List hotelImageModelList = (new HotelImageMapper()).mapList(this.hotelImageDao.procHotelImage((String) null,
                session.getAttribute("HotelDetailIDForImage").toString(), (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "s"));
        model.addAttribute("hotelImageModelList", hotelImageModelList);
        model.addAttribute("noView", "noView");
        model.addAttribute("ImageView", "ImageView");
        return getAll(model);
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, @RequestParam("hotelImageId[]") String hotelImageId[],
                       @RequestParam("caption[]") String caption[], @RequestParam("thumbnail") String thumbnail, @RequestParam("active[]") String active[],

                       HttpSession session) {

        Map map = null;
        String imageCaption, imageActive = null;
        boolean activeFlag = false;



        for (int i = 0; i < hotelImageId.length; i++) {
            String imageID = hotelImageId[i];

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
            map = (Map) hotelImageDao.procHotelImage(imageID,
                    null, null, imageCaption, null, null, imageThumbnail, "N", null, "u").get(0);

            /*check for active on site*/

            for (int j = 0; j < active.length; j++) {

                if (imageID.equals(active[j])) {

                    map = (Map) hotelImageDao.procHotelImage(imageID,
                            null, null, imageCaption, null, null, imageThumbnail, "Y", null, "u").get(0);
                }


            }


        }


        model.addAttribute("dbResponse", map);
        List hotelImageModelList = (new HotelImageMapper()).mapList(this.hotelImageDao.procHotelImage((String) null,
                session.getAttribute("HotelDetailIDForImage").toString(), (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "s"));
        model.addAttribute("hotelImageModelList", hotelImageModelList);
        model.addAttribute("noView", "noView");
        model.addAttribute("ImageView", "ImageView");

        return getAll(model);

    }


}