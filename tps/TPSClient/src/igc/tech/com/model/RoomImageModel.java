package igc.tech.com.model;

/**
 * Created by IGC TECHNOLOGY on 3/14/2016.
 */
public class RoomImageModel {

    private String roomImageId, roomDetailId, caption, fileName,
            thumbnail, imageUrl,
            fileType, active;


    public String getRoomImageId() {
        return roomImageId;
    }

    public void setRoomImageId(String roomImageId) {
        this.roomImageId = roomImageId;
    }

    public String getRoomDetailId() {
        return roomDetailId;
    }

    public void setRoomDetailId(String roomDetailId) {
        this.roomDetailId = roomDetailId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
