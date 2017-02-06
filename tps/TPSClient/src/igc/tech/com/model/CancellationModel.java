package igc.tech.com.model;

/**
 * Created by Ganga on 5/15/2016.
 */
public class CancellationModel {
    private String cancellationId, hotelDetailId, freeCancellationBefore, chargeType, chargeAmount;

    public String getCancellationId() {
        return cancellationId;
    }

    public void setCancellationId(String cancellationId) {
        this.cancellationId = cancellationId;
    }

    public String getHotelDetailId() {
        return hotelDetailId;
    }

    public void setHotelDetailId(String hotelDetailId) {
        this.hotelDetailId = hotelDetailId;
    }

    public String getFreeCancellationBefore() {
        return freeCancellationBefore;
    }

    public void setFreeCancellationBefore(String freeCancellationBefore) {
        this.freeCancellationBefore = freeCancellationBefore;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(String chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    @Override
    public String toString() {
        return "CancellationModel{" +
                "cancellationId='" + cancellationId + '\'' +
                ", hotelDetailId='" + hotelDetailId + '\'' +
                ", freeCancellationBefore='" + freeCancellationBefore + '\'' +
                ", chargeType='" + chargeType + '\'' +
                ", chargeAmount='" + chargeAmount + '\'' +
                '}';
    }
}
