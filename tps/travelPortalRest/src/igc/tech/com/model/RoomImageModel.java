package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IGC TECHNOLOGY on 3/14/2016.
 */

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomImageModel {

    private String roomImageId, roomDetailId, caption, fileName,
            thumbnail, imageUrl,
            fileType, active ,fullImageUrl;

    public RoomImageModel() {
    }

    public RoomImageModel(String roomImageId, String roomDetailId, String caption, String fileName, String thumbnail, String imageUrl, String fileType, String active) {
        this.roomImageId = roomImageId;
        this.roomDetailId = roomDetailId;
        this.caption = caption;
        this.fileName = fileName;
        this.thumbnail = thumbnail;
        this.imageUrl = imageUrl;
        this.fileType = fileType;
        this.active = active;
    }

    public String getFullImageUrl() {
        return fullImageUrl;
    }

    public void setFullImageUrl(String fullImageUrl) {
        this.fullImageUrl = fullImageUrl;
    }

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

    @Override
    public String toString() {
        return "RoomImageModel{" +
                "roomImageId='" + roomImageId + '\'' +
                ", roomDetailId='" + roomDetailId + '\'' +
                ", caption='" + caption + '\'' +
                ", fileName='" + fileName + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", fileType='" + fileType + '\'' +
                ", active='" + active + '\'' +
                ", fullImageUrl='" + fullImageUrl + '\'' +
                '}';
    }
}
