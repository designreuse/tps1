package igc.tech.com.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;


@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class ActivityDetailModel {

	private String activityDetailId, description,  user;

	public String getActivityDetailId() {
		return activityDetailId;
	}

	public void setActivityDetailId(String activityDetailId) {
		this.activityDetailId = activityDetailId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
