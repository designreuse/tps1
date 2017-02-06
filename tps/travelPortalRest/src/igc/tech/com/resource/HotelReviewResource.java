package igc.tech.com.resource;

import com.sun.jersey.multipart.BodyPartEntity;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataParam;
import igc.tech.com.dao.*;
import igc.tech.com.mapper.*;
import igc.tech.com.model.*;
import igc.tech.com.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@Path("/HotelReview")
public class HotelReviewResource {


    @Autowired
    HotelReviewDao hotelReviewDao;

    @Autowired
    HotelReviewCategoryDao hotelReviewCategoryDao;

    @Autowired
    HotelRatingDao hotelRatingDao;

    @Autowired
    EncodeResource encodeResource;

    @Autowired
    ConfigModel configModel;

    @Autowired
    HotelReviewImageDao hotelReviewImageDao;

    @Autowired
    HotelReviewReplyDao hotelReviewReplyDao;

    @Autowired
    HotelReviewTagAccessDao hotelReviewTagAccessDao;

    @Autowired
    HotelReviewSortingDao hotelReviewSortingDao;

    @Autowired
    HotelReviewTagDao hotelReviewTagDao;

    ErrorMessage errorMessage;

    ResponseModel responseModel;


    @Path("/hotelRating")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertRatingReview(HotelReviewModel hotelReviewModel) throws Exception {

    hotelReviewModel.setCustomerDetailId(encodeResource.decrypt(hotelReviewModel.getCustomerDetailId()));
    hotelReviewModel.setHotelDetailId(encodeResource.decrypt(hotelReviewModel.getHotelDetailId()));

        // hotel review insert
    HotelReviewModel hotelReviewModel1= (HotelReviewModel) new  HotelReviewMapper().mapList(hotelReviewDao.procHotelReview(hotelReviewModel,null,"i")).get(0);
        // *******
        if (hotelReviewModel1.getStatus().equals("SUCCESS")){

            List<HotelRatingModel> hotelRatingModels=hotelReviewModel.getHotelRatingList();

            if (hotelRatingModels.isEmpty()){

                responseModel=new ResponseModel();
                responseModel.setStatus("UNSUCCESS");
                responseModel.setMessage("Hotel Review Category is empty");
                return Response.status(Response.Status.OK).entity(responseModel)
                        .type(MediaType.APPLICATION_JSON).build();
            }

            // hotel rating insert
            for (HotelRatingModel hotelRatingModel:hotelRatingModels){

                hotelRatingModel.setHotelReviewId(hotelReviewModel1.getId());

                hotelRatingDao.procHotelRating(hotelRatingModel,null,"i");

            }
            //*******

            // hotel rating tag insert
            List<HotelReviewTagModel> hotelReviewTagModels=hotelReviewModel.getHotelReviewTagList();

            if (!hotelReviewTagModels.isEmpty()){

                for (HotelReviewTagModel hotelReviewTagModel:hotelReviewTagModels){

                    HotelReviewTagAccessModel hotelReviewTagAccessModel=new HotelReviewTagAccessModel();
                    hotelReviewTagAccessModel.setHotelReviewId(hotelReviewModel1.getId());
                    hotelReviewTagAccessModel.setHotelReviewTagId(hotelReviewTagModel.getHotelReviewTagId());

                    hotelReviewTagAccessDao.procHotelReviewTagAccess(hotelReviewTagAccessModel,null,"i");
                }
            }

            //*************

            HotelReviewModel hotelReviewModel2=new HotelReviewModel();
            hotelReviewModel2.setStatus("SUCCESS");
            hotelReviewModel2.setHotelReviewId(encodeResource.encrypt(hotelReviewModel1.getId()));
            return Response.status(Response.Status.OK).entity(hotelReviewModel2)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        else {
            responseModel=new ResponseModel();
            responseModel.setStatus("UNSUCCESS");
            return Response.status(Response.Status.OK).entity(responseModel)
                    .type(MediaType.APPLICATION_JSON).build();

        }

    }



    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@FormDataParam("file") List<FormDataBodyPart> bodyParts,
                               @FormDataParam("hotelReviewId") String hotelReviewId) throws Exception {

        String basePath=System.getProperty("catalina.home") + "/webapps/TPSResources/ReviewImages/";

        File f = new File(basePath);

        if (!f.exists()) {
            f.mkdir();
        }


        for (int i = 0; i < bodyParts.size(); i++) {
			/*
			 * Casting FormDataBodyPart to BodyPartEntity, which can give us
			 * InputStream for uploaded file
			 */
            BodyPartEntity bodyPartEntity = (BodyPartEntity) bodyParts.get(i).getEntity();
            String fileName = bodyParts.get(i).getContentDisposition().getFileName();

            List<String> list = Arrays.asList(fileName.split("\\."));

            Utility utility=new Utility();
            Random rand = new Random();
            int value = rand.nextInt(50);

           // fileName=value+utility.getDateAndTime()+i+"."+list.get(list.size()-1);
            String fileFormat=list.get(list.size()-1).toUpperCase();
          //  System.out.println(fileFormat);
            fileName=utility.getDateAndTime()+i+"."+list.get(list.size()-1);
             writeToFile1(bodyPartEntity.getInputStream(), basePath+fileName,fileFormat);
          //  writeToFile(bodyPartEntity.getInputStream(), "d://uploaded/"+fileName);

            hotelReviewImageDao.procHotelReviewImage(new HotelReviewImageModel(null,encodeResource.decrypt(hotelReviewId) ,fileName),null,"i");
        }

        responseModel=new ResponseModel();
        responseModel.setStatus("SUCCESS");
        responseModel.setMessage("Image Successfully Uploaded");

        return Response.status(200).entity(responseModel).build();

    }

    // save uploaded file to new location
    private void writeToFile(InputStream uploadedInputStream,
                             String uploadedFileLocation) {

        try {
            OutputStream out = null;
            int read = 0;
            byte[] bytes = new byte[1024];

            // File file=new File(uploadedFileLocation);

            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }


    private void writeToFile1(InputStream uploadedInputStream,
                             String uploadedFileLocation,String fileFormat) {

        try {
            int size = 830;// size of the new image.
            //take the file as inputstream.
          //  InputStream imageStream = item.getInputStream();
            //read the image as a BufferedImage.
            BufferedImage image = javax.imageio.ImageIO.read(uploadedInputStream);
            //cal the sacleImage method.
            BufferedImage newImage = scaleImage(image, size);
            //String path = getServletContext().getRealPath("/image");
            //write file.
            File file = new File(uploadedFileLocation);
            ImageIO.write(newImage, fileFormat, file);

        } catch (IOException e) {

            e.printStackTrace();
        }

    }


    private BufferedImage scaleImage(BufferedImage bufferedImage, int size) {
        double boundSize = size;
        int origWidth = bufferedImage.getWidth();
        int origHeight = bufferedImage.getHeight();
        double scale;
        if (origHeight > origWidth)
            scale = boundSize / origHeight;
        else
            scale = boundSize / origWidth;
        //* Don't scale up small images.
        if (scale > 1.0)
            return (bufferedImage);
        int scaledWidth = (int) (scale * origWidth);
        int scaledHeight = (int) (scale * origHeight);

       // scaledWidth=830;
       // scaledHeight=530;

        Image scaledImage = bufferedImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        // new ImageIcon(image); // load image
        // scaledWidth = scaledImage.getWidth(null);
        // scaledHeight = scaledImage.getHeight(null);
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = scaledBI.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(scaledImage, 0, 0, null);
        g.dispose();
        return (scaledBI);
    }


    @Path("/hotelReviewTagSorting")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response hotelReviewTagSorting(HotelReviewModel hotelReviewModel) throws Exception {

        hotelReviewModel.setHotelDetailId(encodeResource.decrypt(hotelReviewModel.getHotelDetailId()));

        List<HotelReviewModel> hotelReviewModels=new HotelReviewMapper().mapList(hotelReviewSortingDao.procHotelReviewSorting(hotelReviewModel,"tag_sorting_by_hotel"));

        for (HotelReviewModel hotelReviewModel2:hotelReviewModels){

            // hotel review tag binding
            HotelReviewTagAccessModel hotelReviewTagAccessModel=new HotelReviewTagAccessModel();
            hotelReviewTagAccessModel.setHotelReviewId(hotelReviewModel2.getHotelReviewId());
            List<HotelReviewTagAccessModel> hotelReviewTagAccessModels=new HotelReviewTagAccessMapper().
                    mapList(hotelReviewTagAccessDao.procHotelReviewTagAccess(hotelReviewTagAccessModel,null,"by_hotel_review_id"));

            if (!hotelReviewTagAccessModels.isEmpty()){

                hotelReviewModel2.setHotelReviewTagAccessList(hotelReviewTagAccessModels);
            }

            // ************

            // hotel review category rating binding

            HotelRatingModel hotelRatingModel=new HotelRatingModel();
            hotelRatingModel.setHotelReviewId(hotelReviewModel2.getHotelReviewId());
            List<HotelRatingModel> hotelRatingModels1=new HotelRatingMapper().mapList(hotelRatingDao.procHotelRating(hotelRatingModel,null,"by_hotel_review_id"));
            hotelReviewModel2.setHotelRatingList(hotelRatingModels1);

            // *******

            // hotel review reply binding

            HotelReviewReplyModel hotelReviewReplyModel=new HotelReviewReplyModel();
            hotelReviewReplyModel.setHotelReviewId(hotelReviewModel2.getHotelReviewId());

            List<HotelReviewReplyModel> hotelReviewReplyModels=  new HotelReviewReplyMapper().mapList(hotelReviewReplyDao.procHotelReviewReply(hotelReviewReplyModel,null,"by_hotel_review_id"));

            if (!hotelReviewReplyModels.isEmpty()){
                hotelReviewModel2.setHotelReviewReplyList(hotelReviewReplyModels);
            }

            // ****************

            // hotel review image binding
            HotelReviewImageModel hotelReviewImageModel=new HotelReviewImageModel();
            hotelReviewImageModel.setHotelReviewId(hotelReviewModel2.getHotelReviewId());

            List<HotelReviewImageModel> hotelReviewImageModels=  new HotelReviewImageMapper().mapList(hotelReviewImageDao.procHotelReviewImage(hotelReviewImageModel,null,"s"));

            if (!hotelReviewImageModels.isEmpty()){

                for (HotelReviewImageModel hotelReviewImageModel1:hotelReviewImageModels){

                    hotelReviewImageModel1.setImage(configModel.getTpsResourceUrl()+"/ReviewImages/"+hotelReviewImageModel1.getImage());
                }

                hotelReviewModel2.setHotelReviewImageList(hotelReviewImageModels);

            }
            //**************


        }


        return Response.status(Response.Status.OK).entity(hotelReviewModels)
                .type(MediaType.APPLICATION_JSON).build();
    }




    @Path("/hotelReviewDetail")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response hotelReviewDetail(HotelReviewModel hotelReviewModel) throws Exception {

     /*  HotelReviewModel hotelReviewModel=new HotelReviewModel();
        hotelReviewModel.setHotelDetailId("1");*/

        hotelReviewModel.setHotelDetailId(encodeResource.decrypt(hotelReviewModel.getHotelDetailId()));

        hotelReviewModel.setApprove("Y");

        List<HotelReviewModel> hotelReviewModels= new HotelReviewMapper().mapList(hotelReviewDao.procHotelReview(hotelReviewModel,null,"get_by_hotel")) ;

        if (hotelReviewModels.isEmpty()){
            hotelReviewModel=new HotelReviewModel();
            hotelReviewModel.setStatus("UNSUCCESS");
            hotelReviewModel.setMessage("Review has not provided for this hotel");

            return Response.status(Response.Status.OK).entity(hotelReviewModel)
                    .type(MediaType.APPLICATION_JSON).build();
        }

         // average rating binding
        HotelReviewModel hotelReviewModel1= (HotelReviewModel) new HotelReviewMapper().mapList(hotelReviewDao.procHotelReview(hotelReviewModel,null,"get_avg_hotel_rating_by_hotel")).get(0);
        //*********

        // review grouping according to the hotel rating
        List<HotelRatingModel> hotelRatingModels=new HotelRatingMapper().mapList(hotelReviewDao.procHotelReview(hotelReviewModel,null,"get_rating_type_count_by_hotel"));
        hotelReviewModel1.setHotelRatingList(hotelRatingModels);
        // *******

        //average rating of hotel review category groupwise binding
        List<HotelReviewCategoryModel> hotelReviewCategoryModels=new HotelReviewCategoryMapper().mapList(hotelReviewDao.procHotelReview(hotelReviewModel,null,"get_avg_rating_review_category_by_hotel"));
        hotelReviewModel1.setHotelReviewCategoryList(hotelReviewCategoryModels);

        //*********

        // hotel review tag binding
        List<HotelReviewTagModel> hotelReviewTagModels=new HotelReviewTagMapper().mapList(hotelReviewTagDao.procHotelReviewTag(new HotelReviewTagModel(),null,"a"));
        hotelReviewModel1.setHotelReviewTagList(hotelReviewTagModels);


        //******

       ///////////////


        for (HotelReviewModel hotelReviewModel2:hotelReviewModels){

            // hotel review tag binding
            HotelReviewTagAccessModel hotelReviewTagAccessModel=new HotelReviewTagAccessModel();
            hotelReviewTagAccessModel.setHotelReviewId(hotelReviewModel2.getHotelReviewId());
            List<HotelReviewTagAccessModel> hotelReviewTagAccessModels=new HotelReviewTagAccessMapper().
                    mapList(hotelReviewTagAccessDao.procHotelReviewTagAccess(hotelReviewTagAccessModel,null,"by_hotel_review_id"));

            if (!hotelReviewTagAccessModels.isEmpty()){

                hotelReviewModel2.setHotelReviewTagAccessList(hotelReviewTagAccessModels);
            }

            // ************

            // hotel review category rating binding

            HotelRatingModel hotelRatingModel=new HotelRatingModel();
            hotelRatingModel.setHotelReviewId(hotelReviewModel2.getHotelReviewId());
            List<HotelRatingModel> hotelRatingModels1=new HotelRatingMapper().mapList(hotelRatingDao.procHotelRating(hotelRatingModel,null,"by_hotel_review_id"));
            hotelReviewModel2.setHotelRatingList(hotelRatingModels1);

            // *******

            // hotel review reply binding

            HotelReviewReplyModel hotelReviewReplyModel=new HotelReviewReplyModel();
            hotelReviewReplyModel.setHotelReviewId(hotelReviewModel2.getHotelReviewId());

            List<HotelReviewReplyModel> hotelReviewReplyModels=  new HotelReviewReplyMapper().mapList(hotelReviewReplyDao.procHotelReviewReply(hotelReviewReplyModel,null,"by_hotel_review_id"));

            if (!hotelReviewReplyModels.isEmpty()){
                hotelReviewModel2.setHotelReviewReplyList(hotelReviewReplyModels);
            }

            // ****************

            // hotel review image binding
            HotelReviewImageModel hotelReviewImageModel=new HotelReviewImageModel();
            hotelReviewImageModel.setHotelReviewId(hotelReviewModel2.getHotelReviewId());

            List<HotelReviewImageModel> hotelReviewImageModels=  new HotelReviewImageMapper().mapList(hotelReviewImageDao.procHotelReviewImage(hotelReviewImageModel,null,"s"));

            if (!hotelReviewImageModels.isEmpty()){

                for (HotelReviewImageModel hotelReviewImageModel1:hotelReviewImageModels){

                    hotelReviewImageModel1.setImage(configModel.getTpsResourceUrl()+"/ReviewImages/"+hotelReviewImageModel1.getImage());
                }

                hotelReviewModel2.setHotelReviewImageList(hotelReviewImageModels);

            }
            //**************

        }

        hotelReviewModel1.setHotelReviewList(hotelReviewModels);

        hotelReviewModel1.setStatus("SUCCESS");

        return Response.status(Response.Status.OK).entity(hotelReviewModel1)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/hotelReviewTotalandAvg")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response hotelReviewTotalandAvg(HotelReviewModel hotelReviewModel) throws Exception {

     /*  HotelReviewModel hotelReviewModel=new HotelReviewModel();
        hotelReviewModel.setHotelDetailId("1");*/

        hotelReviewModel.setApprove("Y");

        List<HotelReviewModel> hotelReviewModels= new HotelReviewMapper().mapList(hotelReviewDao.procHotelReview(hotelReviewModel,null,"get_by_hotel")) ;

        if (hotelReviewModels.isEmpty()){
            hotelReviewModel=new HotelReviewModel();
            hotelReviewModel.setStatus("UNSUCCESS");
            hotelReviewModel.setMessage("Review doesnot provided for this hotel");

            return Response.status(Response.Status.OK).entity(hotelReviewModel)
                    .type(MediaType.APPLICATION_JSON).build();
        }

        // average rating binding
        HotelReviewModel hotelReviewModel1= (HotelReviewModel) new HotelReviewMapper().mapList(hotelReviewDao.procHotelReview(hotelReviewModel,null,"get_avg_hotel_rating_by_hotel")).get(0);
        //*********

        // review grouping according to the hotel rating
        List<HotelRatingModel> hotelRatingModels=new HotelRatingMapper().mapList(hotelReviewDao.procHotelReview(hotelReviewModel,null,"get_rating_type_count_by_hotel"));
        hotelReviewModel1.setHotelRatingList(hotelRatingModels);
        // *******

        //average rating of hotel review category groupwise binding
        List<HotelReviewCategoryModel> hotelReviewCategoryModels=new HotelReviewCategoryMapper().mapList(hotelReviewDao.procHotelReview(hotelReviewModel,null,"get_avg_rating_review_category_by_hotel"));
        hotelReviewModel1.setHotelReviewCategoryList(hotelReviewCategoryModels);

        //*********


        hotelReviewModel1.setStatus("SUCCESS");

        return Response.status(Response.Status.OK).entity(hotelReviewModel1)
                .type(MediaType.APPLICATION_JSON).build();

    }


}
