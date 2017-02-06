package igc.tech.com.dao;

import java.util.List;

public interface ImageDao {

    public List procImage(String imageId, String imageCaption, String fileName, String albumId, String user,
                             String flag);

}
