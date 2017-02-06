package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

public class HotelReviewTagModel {

    private String hotelReviewTagId;
    private String tagDesc;

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
