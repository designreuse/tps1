package igc.tech.com.resource;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.BodyPartEntity;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

@Path("/filetest")
public class FileUploadResource {
    @POST
    @Path("/uploadtest")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile( @FormDataParam("file") List<FormDataBodyPart> bodyParts) {

        for (int i = 0; i < bodyParts.size(); i++) {
			/*
			 * Casting FormDataBodyPart to BodyPartEntity, which can give us
			 * InputStream for uploaded file
			 */
            BodyPartEntity bodyPartEntity = (BodyPartEntity) bodyParts.get(i).getEntity();
            String fileName = bodyParts.get(i).getContentDisposition().getFileName();

            writeToFile(bodyPartEntity.getInputStream(), "d://uploaded/"+fileName);
        }

        return Response.status(200).entity("success").build();

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


    /*@Path("/files2")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFiles(final FormDataMultiPart multiPart) {

        List<FormDataBodyPart> bodyParts = multiPart.getFields("file");

        StringBuffer fileDetails = new StringBuffer("");

		*//* Save multiple files *//*
        for (int i = 0; i < bodyParts.size(); i++) {
            BodyPartEntity bodyPartEntity = (BodyPartEntity) bodyParts.get(i).getEntity();
            String fileName = bodyParts.get(i).getContentDisposition().getFileName();
            saveFile(bodyPartEntity.getInputStream(), fileName);
            fileDetails.append(" File saved at /Volumes/Drive2/temp/file/" + fileName);
        }

		*//* Save File 2 *//*



        return Response.ok("success").build();
    }

    private void saveFile(InputStream file, String name) {
        try {
			*//* Change directory path *//*
            java.nio.file.Path path = FileSystems.getDefault().getPath("d://uploaded/" + name);
			*//* Save InputStream as file *//*
            Files.copy(file, path);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }*/

}