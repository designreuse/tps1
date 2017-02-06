package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmenityHighlightModel {

    private String amenityHighlightId;
    private String amenityId;
    private String priority;
    private String roomDetailId;
    private String amenityDesc;
    private String image;
    private String icon;

    public String getAmenityHighlightId() {
        return amenityHighlightId;
    }

    public void setAmenityHighlightId(String amenityHighlightId) {
        this.amenityHighlightId = amenityHighlightId;
    }

    public String getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(String amenityId) {
        this.amenityId = amenityId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRoomDetailId() {
        return roomDetailId;
    }

    public void setRoomDetailId(String roomDetailId) {
        this.roomDetailId = roomDetailId;
    }

    public String getAmenityDesc() {
        return amenityDesc;
    }

    public void setAmenityDesc(String amenityDesc) {
        this.amenityDesc = amenityDesc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "AmenityHighlightModel{" +
                "amenityHighlightId='" + amenityHighlightId + '\'' +
                ", amenityId='" + amenityId + '\'' +
                ", priority='" + priority + '\'' +
                ", roomDetailId='" + roomDetailId + '\'' +
                ", amenityDesc='" + amenityDesc + '\'' +
                ", image='" + image + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
