package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Ganga on 4/15/2016.
 */


public class HotelReviewReplyModel {


    private  String hotelReviewReplyId;
    private  String hotelReviewId;
    private  String reply;
    private  String replyBy;
    private  String replyDate;

    public String getHotelReviewReplyId() {
        return hotelReviewReplyId;
    }

    public void setHotelReviewReplyId(String hotelReviewReplyId) {
        this.hotelReviewReplyId = hotelReviewReplyId;
    }

    public String getHotelReviewId() {
        return hotelReviewId;
    }

    public void setHotelReviewId(String hotelReviewId) {
        this.hotelReviewId = hotelReviewId;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getReplyBy() {
        return replyBy;
    }

    public void setReplyBy(String replyBy) {
        this.replyBy = replyBy;
    }

    public String getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(String replyDate) {
        this.replyDate = replyDate;
    }

    @Override
    public String toString() {
        return "HotelReviewReplyModel{" +
                "hotelReviewReplyId='" + hotelReviewReplyId + '\'' +
                ", hotelReviewId='" + hotelReviewId + '\'' +
                ", reply='" + reply + '\'' +
                ", replyBy='" + replyBy + '\'' +
                ", replyDate='" + replyDate + '\'' +
                '}';
    }
}
