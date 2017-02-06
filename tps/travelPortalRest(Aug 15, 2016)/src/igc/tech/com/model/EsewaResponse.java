package igc.tech.com.model;


import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/*<response>
        <response_code>
        Success
        </response_code>
        </response>*/

@XmlRootElement(name = "response")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class EsewaResponse {

    private  String responseCode;


    public String getResponseCode() {
        return responseCode;
    }

    @XmlElement(name = "response_code")
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public String toString() {
        return "EsewaResponse{" +
                "responseCode='" + responseCode + '\'' +
                '}';
    }
}