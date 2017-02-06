package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tilak on 8/17/2016.
 */

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigModel {

    private  String tpsResourceUrl;
    private  String tpsClientUrl;
    private  String tpsFrontEndUrl;

    public String getTpsFrontEndUrl() {
        return tpsFrontEndUrl;
    }

    public void setTpsFrontEndUrl(String tpsFrontEndUrl) {
        this.tpsFrontEndUrl = tpsFrontEndUrl;
    }

    public String getTpsClientUrl() {
        return tpsClientUrl;
    }

    public void setTpsClientUrl(String tpsClientUrl) {
        this.tpsClientUrl = tpsClientUrl;
    }

    public String getTpsResourceUrl() {
        return tpsResourceUrl;
    }

    public void setTpsResourceUrl(String tpsResourceUrl) {
        this.tpsResourceUrl = tpsResourceUrl;
    }
}
