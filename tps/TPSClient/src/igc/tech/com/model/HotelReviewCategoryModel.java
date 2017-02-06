package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

public class HotelReviewCategoryModel {

    private  String hotelReviewCategoryId;
    private  String categoryDesc;
    private  String active;
    private  String avgRating;
    private  String ratingType;

    public String getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(String avgRating) {
        this.avgRating = avgRating;
    }

    public String getRatingType() {
        return ratingType;
    }

    public void setRatingType(String ratingType) {
        this.ratingType = ratingType;
    }

    public String getHotelReviewCategoryId() {
        return hotelReviewCategoryId;
    }

    public void setHotelReviewCategoryId(String hotelReviewCategoryId) {
        this.hotelReviewCategoryId = hotelReviewCategoryId;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
