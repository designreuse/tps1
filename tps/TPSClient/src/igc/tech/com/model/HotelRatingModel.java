package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;


public class HotelRatingModel {

    private  String hotelRatingId;
    private  String hotelReviewId;
    private  String hotelReviewCategoryId;
    private  String hotelRatingCategoryId;
    private  String categoryDesc;
    private  String rating;
    private  String ratingType;
    private  String totalCount;

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRatingType() {
        return ratingType;
    }

    public void setRatingType(String ratingType) {
        this.ratingType = ratingType;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public String getHotelRatingId() {
        return hotelRatingId;
    }

    public void setHotelRatingId(String hotelRatingId) {
        this.hotelRatingId = hotelRatingId;
    }

    public String getHotelReviewId() {
        return hotelReviewId;
    }

    public void setHotelReviewId(String hotelReviewId) {
        this.hotelReviewId = hotelReviewId;
    }

    public String getHotelReviewCategoryId() {
        return hotelReviewCategoryId;
    }

    public void setHotelReviewCategoryId(String hotelReviewCategoryId) {
        this.hotelReviewCategoryId = hotelReviewCategoryId;
    }

    public String getHotelRatingCategoryId() {
        return hotelRatingCategoryId;
    }

    public void setHotelRatingCategoryId(String hotelRatingCategoryId) {
        this.hotelRatingCategoryId = hotelRatingCategoryId;
    }
}
