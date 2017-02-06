package igc.tech.com.model;


public class EsewaDataModel extends ResponseModel {
    private  String invoice;
    private  String hashCode;

    private String customerDetailId;
    private String guestName;
    private String guestPhNo;
    private  String guestEmailId;
    private  String amount;
    private  String taxAmount;
    private  String serviceCharge;
    private  String deliveryCharge;
    private  String totalAmount;
    private  String productId;
    private  String refId;

    private EsewaConfigModel esewaConfig;

    private  String esewaTxnId;


    public String getEsewaTxnId() {
        return esewaTxnId;
    }

    public void setEsewaTxnId(String esewaTxnId) {
        this.esewaTxnId = esewaTxnId;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }




    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(String serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(String deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public EsewaConfigModel getEsewaConfig() {
        return esewaConfig;
    }

    public void setEsewaConfig(EsewaConfigModel esewaConfig) {
        this.esewaConfig = esewaConfig;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public String getCustomerDetailId() {
        return customerDetailId;
    }

    public void setCustomerDetailId(String customerDetailId) {
        this.customerDetailId = customerDetailId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestPhNo() {
        return guestPhNo;
    }

    public void setGuestPhNo(String guestPhNo) {
        this.guestPhNo = guestPhNo;
    }

    public String getGuestEmailId() {
        return guestEmailId;
    }

    public void setGuestEmailId(String guestEmailId) {
        this.guestEmailId = guestEmailId;
    }


    @Override
    public String toString() {
        return "EsewaDataModel{" +
                "invoice='" + invoice + '\'' +
                ", hashCode='" + hashCode + '\'' +
                ", customerDetailId='" + customerDetailId + '\'' +
                ", guestName='" + guestName + '\'' +
                ", guestPhNo='" + guestPhNo + '\'' +
                ", guestEmailId='" + guestEmailId + '\'' +
                '}';
    }
}
