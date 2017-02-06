package igc.tech.com.model;

import java.util.List;

/**
 * Created by Ganga on 6/8/2016.
 */
public class AddressModel {

    private String addressId, addressName, parentAddressId, type, level;

    private List<AddressModel> addressModels;

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

    public List<AddressModel> getAddressModels() {
        return addressModels;
    }

    public void setAddressModels(List<AddressModel> addressModels) {
        this.addressModels = addressModels;
    }

    @Override
    public String toString() {
        return "AddressModel{" +
                "addressId='" + addressId + '\'' +
                ", addressName='" + addressName + '\'' +
                ", parentAddressId='" + parentAddressId + '\'' +
                ", type='" + type + '\'' +
                ", addressModels=" + addressModels +
                '}';
    }
}
