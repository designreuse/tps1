package igc.tech.com.model;

/**
 * Created by Ganga on 11/7/2016.
 */
public class RoomRateModel {
    private String roomRateId, roomDetailId, currencyId, rate, childRate, adultRate;

    public String getRoomRateId() {
        return roomRateId;
    }

    public void setRoomRateId(String roomRateId) {
        this.roomRateId = roomRateId;
    }

    public String getRoomDetailId() {
        return roomDetailId;
    }

    public void setRoomDetailId(String roomDetailId) {
        this.roomDetailId = roomDetailId;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getChildRate() {
        return childRate;
    }

    public void setChildRate(String childRate) {
        this.childRate = childRate;
    }

    public String getAdultRate() {
        return adultRate;
    }

    public void setAdultRate(String adultRate) {
        this.adultRate = adultRate;
    }
}
