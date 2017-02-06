package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;


public class HotelReviewImageModel {


    private  String hotelReviewImageId;
    private  String hotelReviewId;
    private  String image;

    public HotelReviewImageModel() {
    }

    public HotelReviewImageModel(String hotelReviewImageId, String hotelReviewId, String image) {
        this.hotelReviewImageId = hotelReviewImageId;
        this.hotelReviewId = hotelReviewId;
        this.image = image;
    }

    public String getHotelReviewImageId() {
        return hotelReviewImageId;
    }

    public void setHotelReviewImageId(String hotelReviewImageId) {
        this.hotelReviewImageId = hotelReviewImageId;
    }

    public String getHotelReviewId() {
        return hotelReviewId;
    }

    public void setHotelReviewId(String hotelReviewId) {
        this.hotelReviewId = hotelReviewId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
