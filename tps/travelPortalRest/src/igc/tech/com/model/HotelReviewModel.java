package igc.tech.com.model;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelReviewModel extends DatabaseResponseModel {

    private  String hotelReviewId;
    private  String customerDetailId;
    private  String hotelDetailId;
    private  String travelMonth;
    private  String expensive;
    private  String image;
    private  String approve;
    private  String title;
    private  String review;
    private  String positiveReview;
    private  String negativeReview;
    private  String visitPurpose;
    private  String hotelRatingCategoryId;
    private  String rating;
    private  String ratingType;
    private  String averageRating;
    private  String totalReview;
    private  String createdDate;
    private  String name;
    private  String tagSorting;
    private String pageNo;
    private String offSet;
    private List<HotelReviewCategoryModel> hotelReviewCategoryList;
    private List<HotelRatingModel> hotelRatingList;
    private List<HotelReviewReplyModel> hotelReviewReplyList;
    private List<HotelReviewModel> hotelReviewList;
    private List<HotelReviewImageModel> hotelReviewImageList;
    private List<HotelReviewTagAccessModel> hotelReviewTagAccessList;
    private List<HotelReviewTagModel> hotelReviewTagList;

    public List<HotelReviewTagModel> getHotelReviewTagList() {
        return hotelReviewTagList;
    }

    public void setHotelReviewTagList(List<HotelReviewTagModel> hotelReviewTagList) {
        this.hotelReviewTagList = hotelReviewTagList;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getOffSet() {
        return offSet;
    }

    public void setOffSet(String offSet) {
        this.offSet = offSet;
    }

    public String getTagSorting() {
        return tagSorting;
    }

    public void setTagSorting(String tagSorting) {
        this.tagSorting = tagSorting;
    }

    public List<HotelReviewTagAccessModel> getHotelReviewTagAccessList() {
        return hotelReviewTagAccessList;
    }

    public void setHotelReviewTagAccessList(List<HotelReviewTagAccessModel> hotelReviewTagAccessList) {
        this.hotelReviewTagAccessList = hotelReviewTagAccessList;
    }

    public String getVisitPurpose() {
        return visitPurpose;
    }

    public void setVisitPurpose(String visitPurpose) {
        this.visitPurpose = visitPurpose;
    }

    public String getPositiveReview() {
        return positiveReview;
    }

    public void setPositiveReview(String positiveReview) {
        this.positiveReview = positiveReview;
    }

    public String getNegativeReview() {
        return negativeReview;
    }

    public void setNegativeReview(String negativeReview) {
        this.negativeReview = negativeReview;
    }

    public List<HotelReviewImageModel> getHotelReviewImageList() {
        return hotelReviewImageList;
    }

    public void setHotelReviewImageList(List<HotelReviewImageModel> hotelReviewImageList) {
        this.hotelReviewImageList = hotelReviewImageList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public List<HotelReviewModel> getHotelReviewList() {
        return hotelReviewList;
    }

    public void setHotelReviewList(List<HotelReviewModel> hotelReviewList) {
        this.hotelReviewList = hotelReviewList;
    }

    public String getTotalReview() {
        return totalReview;
    }

    public void setTotalReview(String totalReview) {
        this.totalReview = totalReview;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
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

    public String getHotelRatingCategoryId() {
        return hotelRatingCategoryId;
    }

    public void setHotelRatingCategoryId(String hotelRatingCategoryId) {
        this.hotelRatingCategoryId = hotelRatingCategoryId;
    }

    public List<HotelReviewReplyModel> getHotelReviewReplyList() {
        return hotelReviewReplyList;
    }

    public void setHotelReviewReplyList(List<HotelReviewReplyModel> hotelReviewReplyList) {
        this.hotelReviewReplyList = hotelReviewReplyList;
    }

    public String getApprove() {
        return approve;
    }

    public void setApprove(String approve) {
        this.approve = approve;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public List<HotelRatingModel> getHotelRatingList() {
        return hotelRatingList;
    }

    public void setHotelRatingList(List<HotelRatingModel> hotelRatingList) {
        this.hotelRatingList = hotelRatingList;
    }

    public List<HotelReviewCategoryModel> getHotelReviewCategoryList() {
        return hotelReviewCategoryList;
    }

    public void setHotelReviewCategoryList(List<HotelReviewCategoryModel> hotelReviewCategoryList) {
        this.hotelReviewCategoryList = hotelReviewCategoryList;
    }

    public String getHotelReviewId() {
        return hotelReviewId;
    }

    public void setHotelReviewId(String hotelReviewId) {
        this.hotelReviewId = hotelReviewId;
    }

    public String getCustomerDetailId() {
        return customerDetailId;
    }

    public void setCustomerDetailId(String customerDetailId) {
        this.customerDetailId = customerDetailId;
    }

    public String getHotelDetailId() {
        return hotelDetailId;
    }

    public void setHotelDetailId(String hotelDetailId) {
        this.hotelDetailId = hotelDetailId;
    }


    public String getTravelMonth() {
        return travelMonth;
    }

    public void setTravelMonth(String travelMonth) {
        this.travelMonth = travelMonth;
    }

    public String getExpensive() {
        return expensive;
    }

    public void setExpensive(String expensive) {
        this.expensive = expensive;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "HotelReviewModel{" +
                "hotelReviewId='" + hotelReviewId + '\'' +
                ", customerDetailId='" + customerDetailId + '\'' +
                ", hotelDetailId='" + hotelDetailId + '\'' +
                ", travelMonth='" + travelMonth + '\'' +
                ", expensive='" + expensive + '\'' +
                ", image='" + image + '\'' +
                ", approve='" + approve + '\'' +
                ", title='" + title + '\'' +
                ", review='" + review + '\'' +
                ", positiveReview='" + positiveReview + '\'' +
                ", negativeReview='" + negativeReview + '\'' +
                ", visitPurpose='" + visitPurpose + '\'' +
                ", hotelRatingCategoryId='" + hotelRatingCategoryId + '\'' +
                ", rating='" + rating + '\'' +
                ", ratingType='" + ratingType + '\'' +
                ", averageRating='" + averageRating + '\'' +
                ", totalReview='" + totalReview + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", name='" + name + '\'' +
                ", tagSorting='" + tagSorting + '\'' +
                ", pageNo='" + pageNo + '\'' +
                ", offSet='" + offSet + '\'' +
                ", hotelReviewCategoryList=" + hotelReviewCategoryList +
                ", hotelRatingList=" + hotelRatingList +
                ", hotelReviewReplyList=" + hotelReviewReplyList +
                ", hotelReviewList=" + hotelReviewList +
                ", hotelReviewImageList=" + hotelReviewImageList +
                ", hotelReviewTagAccessList=" + hotelReviewTagAccessList +
                ", hotelReviewTagList=" + hotelReviewTagList +
                '}';
    }
}
