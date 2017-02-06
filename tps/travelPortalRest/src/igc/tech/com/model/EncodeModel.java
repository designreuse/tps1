package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Ganga on 4/15/2016.
 */

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EncodeModel {


    private  String encodeId;
    private  String id;
    private  String encodedHash;

    public EncodeModel() {
    }

    public EncodeModel(String encodeId, String id, String encodedHash) {
        this.encodeId = encodeId;
        this.id = id;
        this.encodedHash = encodedHash;
    }

    public String getEncodeId() {
        return encodeId;
    }

    public void setEncodeId(String encodeId) {
        this.encodeId = encodeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEncodedHash() {
        return encodedHash;
    }

    public void setEncodedHash(String encodedHash) {
        this.encodedHash = encodedHash;
    }

    @Override
    public String toString() {
        return "EncodeModel{" +
                "encodeId='" + encodeId + '\'' +
                ", id='" + id + '\'' +
                ", encodedHash='" + encodedHash + '\'' +
                '}';
    }
}
