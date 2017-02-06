package igc.tech.com.model;

/**
 * Created by Ganga on 7/17/2016.
 */
public class NpayConfigModel {
    private String npayConfigId, merchantId, merchantUserName, merchantPassword, signature, type, active;

    private  String interfaceUrl;
    private  String apiUrl;

     private  String merchantTxnId;
    private  String amount;
    private String purchaseDesc;
    private String gatewayRefNo;

    public NpayConfigModel() {
    }

    public NpayConfigModel(String npayConfigId, String merchantId, String merchantUserName, String merchantPassword, String signature, String type, String active) {
        this.npayConfigId = npayConfigId;
        this.merchantId = merchantId;
        this.merchantUserName = merchantUserName;
        this.merchantPassword = merchantPassword;
        this.signature = signature;
        this.type = type;
        this.active = active;
    }


    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getGatewayRefNo() {
        return gatewayRefNo;
    }

    public void setGatewayRefNo(String gatewayRefNo) {
        this.gatewayRefNo = gatewayRefNo;
    }

    public String getMerchantTxnId() {
        return merchantTxnId;
    }

    public void setMerchantTxnId(String merchantTxnId) {
        this.merchantTxnId = merchantTxnId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPurchaseDesc() {
        return purchaseDesc;
    }

    public void setPurchaseDesc(String purchaseDesc) {
        this.purchaseDesc = purchaseDesc;
    }

    public String getNpayConfigId() {
        return npayConfigId;
    }

    public void setNpayConfigId(String npayConfigId) {
        this.npayConfigId = npayConfigId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantUserName() {
        return merchantUserName;
    }

    public void setMerchantUserName(String merchantUserName) {
        this.merchantUserName = merchantUserName;
    }

    public String getMerchantPassword() {
        return merchantPassword;
    }

    public void setMerchantPassword(String merchantPassword) {
        this.merchantPassword = merchantPassword;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "NpayConfigModel{" +
                "npayConfigId='" + npayConfigId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", merchantUserName='" + merchantUserName + '\'' +
                ", merchantPassword='" + merchantPassword + '\'' +
                ", signature='" + signature + '\'' +
                ", type='" + type + '\'' +
                ", active='" + active + '\'' +
                ", merchantTxnId='" + merchantTxnId + '\'' +
                ", amount='" + amount + '\'' +
                ", purchaseDesc='" + purchaseDesc + '\'' +
                ", gatewayRefNo='" + gatewayRefNo + '\'' +
                '}';
    }
}
