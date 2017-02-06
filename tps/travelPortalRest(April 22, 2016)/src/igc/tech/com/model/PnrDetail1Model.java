package igc.tech.com.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tilak on 3/18/2016.
 */
@XmlRootElement(name = "PnrDetail")
public class PnrDetail1Model {


    private  String accessURL;


    public String getAccessURL() {
        return accessURL;
    }

    @XmlElement(name ="AccessURL" )
    public void setAccessURL(String accessURL) {
        this.accessURL = accessURL;
    }

    @Override
    public String toString() {
        return "PnrDetail1Model{" +
                "accessURL='" + accessURL + '\'' +
                '}';
    }
}
