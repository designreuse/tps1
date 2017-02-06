package igc.tech.com.model;

import igc.tech.com.validate.ValidData;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ErrorMessage  {

	
	private String errormessage;
	private String errorCode;
	private String status;
	private String documentation;
	private List<ValidData> validDataList;

	
	


	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ErrorMessage(String errormessage, String errorCode, String documentation) {
		this.errormessage = errormessage;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}

	public List<ValidData> getValidDataList() {
		return validDataList;
	}

	public void setValidDataList(List<ValidData> validDataList) {
		this.validDataList = validDataList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrormessage() {
		return errormessage;
	}


	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getDocumentation() {
		return documentation;
	}


	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
	
	

}
