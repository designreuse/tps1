package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
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
