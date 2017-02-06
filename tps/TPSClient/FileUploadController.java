package np.com.mshrestha.dropzonetest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

//import np.com.mshrestha.dropzonetest.model.UploadedFile;

@Controller
public class FileUploadController {

  @RequestMapping("/")
  public String home() {

    return "fileUploader";
  }

  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  public @ResponseBody void upload(MultipartHttpServletRequest request,
      HttpServletResponse response) throws IOException {

    // Getting uploaded files from the request object
    Map<String, MultipartFile> fileMap = request.getFileMap();

    System.out.println("fileMap "+fileMap.size());

   /* // Maintain a list to send back the files info. to the client side
    List<HotelImageModel> uploadedFiles = new ArrayList<HotelImageModel>();

    // Iterate through the map
    for (MultipartFile multipartFile : fileMap.values()) {

      System.out.println("multipart file "+multipartFile);
      // Save the file to local disk
      saveFileToLocalDisk(multipartFile);

      HotelImageModel fileInfo = getUploadedFileInfo(multipartFile);

      System.out.println(fileInfo);
      // Save the file info to database
//      fileInfo = saveFileToDatabase(fileInfo);

      hotelImageDao.procHotelImage(null,"1",multipartFile.getOriginalFilename(), "caption",getDestinationLocation(),"jpg","Y",null,"ganga","i");

      // adding the file info to the list
      uploadedFiles.add(fileInfo);
    }
*/

  }


 /* @RequestMapping(value = {"/list"})
  public String listBooks(Map<String, Object> map) {
    List<HotelImageModel> hotelImageModelList = new HotelImageMapper().mapList(hotelImageDao.procHotelImage(null,null,null, null,getDestinationLocation(),"jpg","Y",null,"ganga","a"));
    System.out.println("hotelImageModel"+hotelImageModelList);
    map.put("fileList", hotelImageModelList);

    return "/listFiles";
  }

  @RequestMapping(value = "/get/{fileId}", method = RequestMethod.GET)
  public void getFile(HttpServletResponse response, @PathVariable Long fileId) {

    HotelImageModel dataFile = uploadService.getFile(fileId);

    File file = new File(dataFile.getImageUrl(), dataFile.getFileName());

    try {
      response.setContentType(dataFile.getFileType());
      response.setHeader("Content-disposition", "attachment; filename=\"" + dataFile.getFileName()
          + "\"");

      FileCopyUtils.copy(FileUtils.readFileToByteArray(file), response.getOutputStream());

    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  private void saveFileToLocalDisk(MultipartFile multipartFile) throws IOException,
      FileNotFoundException {

    String outputFileName = getOutputFilename(multipartFile);

    FileCopyUtils.copy(multipartFile.getBytes(), new FileOutputStream(outputFileName));
  }

  private HotelImageModel saveFileToDatabase(HotelImageModel uploadedFile) {

    return uploadService.saveFile(uploadedFile);

  }

  private String getOutputFilename(MultipartFile multipartFile) {

    return getDestinationLocation() + multipartFile.getOriginalFilename();
  }

  private HotelImageModel getUploadedFileInfo(MultipartFile multipartFile) throws IOException {

    HotelImageModel fileInfo = new HotelImageModel();
    fileInfo.setFileName(multipartFile.getOriginalFilename());
//    fileInfo.setSize(multipartFile.getSize());
    fileInfo.setFileType(multipartFile.getContentType());
    fileInfo.setImageUrl(getDestinationLocation());

    return fileInfo;
  }

  private String getDestinationLocation() {
    return "D:/uploaded-files/";
  }*/
}
