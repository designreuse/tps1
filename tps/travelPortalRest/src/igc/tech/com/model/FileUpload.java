package igc.tech.com.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 2/18/2016.
 */
public class FileUpload {

    private  MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    private List<MultipartFile> files;

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
}

