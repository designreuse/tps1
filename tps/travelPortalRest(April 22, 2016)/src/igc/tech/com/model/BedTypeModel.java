package igc.tech.com.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BedTypeModel {

	private String bedTypeId;
	private String description;
	private String hotelDetailId;
	private String hotelName;
	private String areaName;
	private String regionName;
	private String countryName;
	private String user;

	private List<BedTypeModel> bedTypes;


	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getBedTypeId() {
		return bedTypeId;
	}

	public void setBedTypeId(String bedTypeId) {
		this.bedTypeId = bedTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<BedTypeModel> getBedTypes() {
		return bedTypes;
	}

	public void setBedTypes(List<BedTypeModel> bedTypes) {
		this.bedTypes = bedTypes;
	}

	@Override
	public String toString() {
		return "BedTypeModel{" +
				"bedTypeId='" + bedTypeId + '\'' +
				", description='" + description + '\'' +
				", hotelDetailId='" + hotelDetailId + '\'' +
				", hotelName='" + hotelName + '\'' +
				", regionName='" + regionName + '\'' +
				", countryName='" + countryName + '\'' +
				", user='" + user + '\'' +
				", bedTypes=" + bedTypes +
				'}';
	}
}
