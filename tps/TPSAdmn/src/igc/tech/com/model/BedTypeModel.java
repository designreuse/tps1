package igc.tech.com.model;

public class BedTypeModel {

    private String bedTypeId;
    private String bedTypeDesc;
    private String size;

    public String getBedTypeId() {
        return bedTypeId;
    }

    public void setBedTypeId(String bedTypeId) {
        this.bedTypeId = bedTypeId;
    }

    public String getBedTypeDesc() {
        return bedTypeDesc;
    }

    public void setBedTypeDesc(String bedTypeDesc) {
        this.bedTypeDesc = bedTypeDesc;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "BedTypeModel{" +
                "bedTypeId='" + bedTypeId + '\'' +
                ", bedTypeDesc='" + bedTypeDesc + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
