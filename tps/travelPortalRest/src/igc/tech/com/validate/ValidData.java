package igc.tech.com.validate;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tilak on 7/29/2016.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ValidData {

private String detail;
private String value;
private ValidType  validType;

private List<String> errorMessageList=new ArrayList<>();

    public List<String> getErrorMessageList() {
        return errorMessageList;
    }

    public void setErrorMessageList(List<String> errorMessageList) {
        this.errorMessageList = errorMessageList;
    }

    public ValidData() {
    }

    public ValidData(String detail, String value, ValidType validType) {
        this.detail = detail;
        this.value = value;
        this.validType = validType;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ValidType getValidType() {
        return validType;
    }

    public void setValidType(ValidType validType) {
        this.validType = validType;
    }

    @Override
    public String toString() {
        return "ValidData{" +
                "detail='" + detail + '\'' +
                ", value='" + value + '\'' +
                ", validType=" + validType +
                ", errorMessageList=" + errorMessageList +
                '}';
    }
}
