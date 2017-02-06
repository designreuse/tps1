package igc.tech.com.model;

/**
 * Created by Ganga on 6/2/2016.
 */
public class OfferModel {
    private String offerId, offerName, roomDetailId, effectiveFrom, effectiveTo, offerType, offerAmount, bookingFrom, bookingTo;
    private String hotelDetailId;
    private String roomName;

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getRoomDetailId() {
        return roomDetailId;
    }

    public void setRoomDetailId(String roomDetailId) {
        this.roomDetailId = roomDetailId;
    }

    public String getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(String effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public String getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(String effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public String getOfferAmount() {
        return offerAmount;
    }

    public void setOfferAmount(String offerAmount) {
        this.offerAmount = offerAmount;
    }

    public String getHotelDetailId() {
        return hotelDetailId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setHotelDetailId(String hotelDetailId) {
        this.hotelDetailId = hotelDetailId;
    }

    public String getBookingFrom() {
        return bookingFrom;
    }

    public void setBookingFrom(String bookingFrom) {
        this.bookingFrom = bookingFrom;
    }

    public String getBookingTo() {
        return bookingTo;
    }

    public void setBookingTo(String bookingTo) {
        this.bookingTo = bookingTo;
    }

    @Override
    public String toString() {
        return "OfferModel{" +
                "offerId='" + offerId + '\'' +
                ", offerName='" + offerName + '\'' +
                ", roomDetailId='" + roomDetailId + '\'' +
                ", effectiveFrom='" + effectiveFrom + '\'' +
                ", effectiveTo='" + effectiveTo + '\'' +
                ", offerType='" + offerType + '\'' +
                ", offerAmount='" + offerAmount + '\'' +
                ", hotelDetailId='" + hotelDetailId + '\'' +
                ", roomName='" + roomName + '\'' +
                '}';
    }
}
