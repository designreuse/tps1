package igc.tech.com.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/*<response>
        <response_code>
        Success
        </response_code>
        </response>*/

@XmlRootElement(name = "response")

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