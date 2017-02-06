package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ganga on 6/8/2016.
 */

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)


public class AddressModel {

    private String addressId, addressName, parentAddressId, type,level  ;

    private AddressModel address;

    private List<AddressModel> addressList;

    public AddressModel() {
    }

    public AddressModel(String addressId) {
        this.addressId = addressId;
    }

    public AddressModel(String addressId, String addressName, String parentAddressId, String type, String level) {
        this.addressId = addressId;
        this.addressName = addressName;
        this.parentAddressId = parentAddressId;
        this.type = type;
        this.level = level;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getParentAddressId() {
        return parentAddressId;
    }

    public void setParentAddressId(String parentAddressId) {
        this.parentAddressId = parentAddressId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<AddressModel> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressModel> addressList) {
        this.addressList = addressList;
    }

    public String  getAddressNameEdited(){

        List<String> addressList = Arrays.asList(this.addressName.split(","));

        if (addressList.size()>1){

            return addressList.get(0)+", "+addressList.get(1);
        }

        else
            return  null;

    }


    @Override
    public String toString() {
        return "AddressModel{" +
                "addressId='" + addressId + '\'' +
                ", addressName='" + addressName + '\'' +
                ", parentAddressId='" + parentAddressId + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", address=" + address +
                ", addressList=" + addressList +
                '}';
    }
}
