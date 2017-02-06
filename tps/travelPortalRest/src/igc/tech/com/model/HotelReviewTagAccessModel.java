package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Ganga on 4/15/2016.
 */

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelReviewTagAccessModel {

   private String hotelReviewTagAccessId;
   private String hotelReviewId;
   private String hotelReviewTagId;
   private String tagDesc;

    public String getHotelReviewTagAccessId() {
        return hotelReviewTagAccessId;
    }

    public void setHotelReviewTagAccessId(String hotelReviewTagAccessId) {
        this.hotelReviewTagAccessId = hotelReviewTagAccessId;
    }

    public String getHotelReviewId() {
        return hotelReviewId;
    }

    public void setHotelReviewId(String hotelReviewId) {
        this.hotelReviewId = hotelReviewId;
    }

    public String getHotelReviewTagId() {
        return hotelReviewTagId;
    }

    public void setHotelReviewTagId(String hotelReviewTagId) {
        this.hotelReviewTagId = hotelReviewTagId;
    }

    public String getTagDesc() {
        return tagDesc;
    }

    public void setTagDesc(String tagDesc) {
        this.tagDesc = tagDesc;
    }
}
