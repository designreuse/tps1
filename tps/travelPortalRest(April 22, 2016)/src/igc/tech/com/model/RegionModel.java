package igc.tech.com.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;


@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class RegionModel {

	private String countryID;
	private String countryName;
	private String regionId;
	private String regionName;
	private String user;

	private List<RegionModel> regions;


	public String getCountryID() {
		return countryID;
	}

	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<RegionModel> getRegions() {
		return regions;
	}

	public void setRegions(List<RegionModel> regions) {
		this.regions = regions;
	}

	@Override
	public String toString() {
		return "RegionModel{" +
				"countryID='" + countryID + '\'' +
				", countryName='" + countryName + '\'' +
				", regionId='" + regionId + '\'' +
				", regionName='" + regionName + '\'' +
				", user='" + user + '\'' +
				", regions=" + regions +
				'}';
	}
}
