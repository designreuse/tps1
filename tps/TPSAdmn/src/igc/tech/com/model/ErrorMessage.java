package igc.tech.com.model;

import javax.xml.bind.annotation.XmlRootElement;


//@XmlRootElement
public class ErrorMessage {


    private String errormessage;
    private int errorCode;
    private String documentation;


    public ErrorMessage() {
        super();
        // TODO Auto-generated constructor stub
    }


    public ErrorMessage(String errormessage, int errorCode, String documentation) {
        this.errormessage = errormessage;
        this.errorCode = errorCode;
        this.documentation = documentation;
    }


    public String getErrormessage() {
        return errormessage;
    }


    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }


    public int getErrorCode() {
        return errorCode;
    }


    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }


    public String getDocumentation() {
        return documentation;
    }


    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }


    @Override
    public String toString() {
        return "ErrorMessage [errormessage=" + errormessage + ", errorCode="
                + errorCode + ", documentation=" + documentation + "]";
    }


}
