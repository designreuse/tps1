package igc.tech.com.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class RoomTypeModel {
	
	private String roomTypeId;
	private String hotelDetailId;
	private String hotelName;
	private String hotelAddress;
	private String roomDesc;
	private String roomCategoryId;

	private String roomCategoryDesc;
	private String bedTypeId;
	private String bedTypeDesc;
	private String initialRate;


	private String maxAdult;
	private String maxChild;

	private String extraBedCharge;
	private String push;
	private String user;

	private  String thumbnailImage;

	private  List<RoomFacilityModel> roomFacilityModels;

	private  List<RoomImageModel> roomImageModels;

	private  List<HotelFacilityModel> hotelFacilityModels;

	private  List<HotelRulesModel> hotelRulesModels;

	private  List<RoomImportanceModel> roomImportanceModels;

	public List<RoomImportanceModel> getRoomImportanceModels() {
		return roomImportanceModels;
	}

	public void setRoomImportanceModels(List<RoomImportanceModel> roomImportanceModels) {
		this.roomImportanceModels = roomImportanceModels;
	}

	public List<HotelRulesModel> getHotelRulesModels() {
		return hotelRulesModels;
	}

	public void setHotelRulesModels(List<HotelRulesModel> hotelRulesModels) {
		this.hotelRulesModels = hotelRulesModels;
	}

	public List<HotelFacilityModel> getHotelFacilityModels() {
		return hotelFacilityModels;
	}

	public void setHotelFacilityModels(List<HotelFacilityModel> hotelFacilityModels) {
		this.hotelFacilityModels = hotelFacilityModels;
	}

	public List<RoomImageModel> getRoomImageModels() {
		return roomImageModels;
	}

	public void setRoomImageModels(List<RoomImageModel> roomImageModels) {
		this.roomImageModels = roomImageModels;
	}

	public List<RoomFacilityModel> getRoomFacilityModels() {
		return roomFacilityModels;
	}

	public void setRoomFacilityModels(List<RoomFacilityModel> roomFacilityModels) {
		this.roomFacilityModels = roomFacilityModels;
	}

	public String getThumbnailImage() {
		return thumbnailImage;
	}

	public void setThumbnailImage(String thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}

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

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	public String getRoomCategoryId() {
		return roomCategoryId;
	}

	public void setRoomCategoryId(String roomCategoryId) {
		this.roomCategoryId = roomCategoryId;
	}

	public String getRoomCategoryDesc() {
		return roomCategoryDesc;
	}

	public void setRoomCategoryDesc(String roomCategoryDesc) {
		this.roomCategoryDesc = roomCategoryDesc;
	}

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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "RoomTypeModel{" +
				"roomTypeId='" + roomTypeId + '\'' +
				", hotelDetailId='" + hotelDetailId + '\'' +
				", hotelName='" + hotelName + '\'' +
				", hotelAddress='" + hotelAddress + '\'' +
				", roomDesc='" + roomDesc + '\'' +
				", roomCategoryId='" + roomCategoryId + '\'' +
				", roomCategoryDesc='" + roomCategoryDesc + '\'' +
				", bedTypeId='" + bedTypeId + '\'' +
				", bedTypeDesc='" + bedTypeDesc + '\'' +
				", initialRate='" + initialRate + '\'' +
				", maxAdult='" + maxAdult + '\'' +
				", maxChild='" + maxChild + '\'' +
				", extraBedCharge='" + extraBedCharge + '\'' +
				", push='" + push + '\'' +
				", user='" + user + '\'' +
				'}';
	}
}
