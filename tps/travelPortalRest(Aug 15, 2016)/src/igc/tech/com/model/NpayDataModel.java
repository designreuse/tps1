package igc.tech.com.model;

/**
 * Created by Ganga on 7/17/2016.
 */
public class NpayDataModel extends ResponseModel {
    private String processId;
    private  String invoice;
    private  String amount;
    private  String description;
    private  String gatewayRefNo;
    private  String npayConfigId;
    private  String hotelBookingId;
    private  String npayTxnId;
    private  String hashCode;
    private  String merchantId;
    private  String merchantTxnId;
    private  String merchantUserName;

    private String customerDetailId;
    private String guestName;
    private String guestPhNo;
    private  String guestEmailId;

    private  String interfaceUrl;

    private NpayConfigModel npayConfig;

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }

    public NpayConfigModel getNpayConfig() {
        return npayConfig;
    }

    public void setNpayConfig(NpayConfigModel npayConfig) {
        this.npayConfig = npayConfig;
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

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantTxnId() {
        return merchantTxnId;
    }

    public void setMerchantTxnId(String merchantTxnId) {
        this.merchantTxnId = merchantTxnId;
    }

    public String getMerchantUserName() {
        return merchantUserName;
    }

    public void setMerchantUserName(String merchantUserName) {
        this.merchantUserName = merchantUserName;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public String getNpayTxnId() {
        return npayTxnId;
    }

    public void setNpayTxnId(String npayTxnId) {
        this.npayTxnId = npayTxnId;
    }

    public String getNpayConfigId() {
        return npayConfigId;
    }

    public void setNpayConfigId(String npayConfigId) {
        this.npayConfigId = npayConfigId;
    }

    public String getHotelBookingId() {
        return hotelBookingId;
    }

    public void setHotelBookingId(String hotelBookingId) {
        this.hotelBookingId = hotelBookingId;
    }

    public String getGatewayRefNo() {
        return gatewayRefNo;
    }

    public void setGatewayRefNo(String gatewayRefNo) {
        this.gatewayRefNo = gatewayRefNo;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    @Override
    public String toString() {
        return "NpayDataModel{" +
                "processId='" + processId + '\'' +
                ", invoice='" + invoice + '\'' +
                ", amount='" + amount + '\'' +
                ", description='" + description + '\'' +
                ", gatewayRefNo='" + gatewayRefNo + '\'' +
                ", npayConfigId='" + npayConfigId + '\'' +
                ", hotelBookingId='" + hotelBookingId + '\'' +
                ", npayTxnId='" + npayTxnId + '\'' +
                ", hashCode='" + hashCode + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", merchantTxnId='" + merchantTxnId + '\'' +
                ", merchantUserName='" + merchantUserName + '\'' +
                ", customerDetailId='" + customerDetailId + '\'' +
                ", guestName='" + guestName + '\'' +
                ", guestPhNo='" + guestPhNo + '\'' +
                ", guestEmailId='" + guestEmailId + '\'' +
                '}';
    }
}
