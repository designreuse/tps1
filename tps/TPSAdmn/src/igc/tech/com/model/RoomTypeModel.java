package igc.tech.com.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class RoomTypeModel {
	
	private String roomTypeId, hotelDetailId, roomCategoryId, bedTypeId, roomDesc, initialRate, maxAdult, maxChild, extraBedCharge, push;

	private String hotelName, bedTypeDesc, roomCategoryDesc;

	public String getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(String roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getHotelDetailId() {
		return hotelDetailId;
	}

	public void setHotelDetailId(String hotelDetailId) {
		this.hotelDetailId = hotelDetailId;
	}

	public String getRoomCategoryId() {
		return roomCategoryId;
	}

	public void setRoomCategoryId(String roomCategoryId) {
		this.roomCategoryId = roomCategoryId;
	}

	public String getBedTypeId() {
		return bedTypeId;
	}

	public void setBedTypeId(String bedTypeId) {
		this.bedTypeId = bedTypeId;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	public String getInitialRate() {
		return initialRate;
	}

	public void setInitialRate(String initialRate) {
		this.initialRate = initialRate;
	}

	public String getMaxAdult() {
		return maxAdult;
	}

	public void setMaxAdult(String maxAdult) {
		this.maxAdult = maxAdult;
	}

	public String getMaxChild() {
		return maxChild;
	}

	public void setMaxChild(String maxChild) {
		this.maxChild = maxChild;
	}

	public String getExtraBedCharge() {
		return extraBedCharge;
	}

	public void setExtraBedCharge(String extraBedCharge) {
		this.extraBedCharge = extraBedCharge;
	}

	public String getPush() {
		return push;
	}

	public void setPush(String push) {
		this.push = push;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getBedTypeDesc() {
		return bedTypeDesc;
	}

	public void setBedTypeDesc(String bedTypeDesc) {
		this.bedTypeDesc = bedTypeDesc;
	}

	public String getRoomCategoryDesc() {
		return roomCategoryDesc;
	}

	public void setRoomCategoryDesc(String roomCategoryDesc) {
		this.roomCategoryDesc = roomCategoryDesc;
	}

	@Override
	public String toString() {
		return "RoomTypeModel{" +
				"roomTypeId='" + roomTypeId + '\'' +
				", hotelDetailId='" + hotelDetailId + '\'' +
				", roomCategoryId='" + roomCategoryId + '\'' +
				", bedTypeId='" + bedTypeId + '\'' +
				", roomDesc='" + roomDesc + '\'' +
				", initialRate='" + initialRate + '\'' +
				", maxAdult='" + maxAdult + '\'' +
				", maxChild='" + maxChild + '\'' +
				", extraBedCharge='" + extraBedCharge + '\'' +
				", push='" + push + '\'' +
				", hotelName='" + hotelName + '\'' +
				", bedTypeDesc='" + bedTypeDesc + '\'' +
				", roomCategoryDesc='" + roomCategoryDesc + '\'' +
				'}';
	}
}
