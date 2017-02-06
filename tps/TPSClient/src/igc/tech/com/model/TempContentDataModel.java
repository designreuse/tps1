package igc.tech.com.model;

/**
 * Created by Ganga on 9/27/2016.
 */
public class TempContentDataModel {
    private String tempContentDataId, pushContentDataId, field, contentData, type, refId;
    private String[] updateField;

    public String getTempContentDataId() {
        return tempContentDataId;
    }

    public void setTempContentDataId(String tempContentDataId) {
        this.tempContentDataId = tempContentDataId;
    }

    public String getPushContentDataId() {
        return pushContentDataId;
    }

    public void setPushContentDataId(String pushContentDataId) {
        this.pushContentDataId = pushContentDataId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getContentData() {
        return contentData;
    }

    public void setContentData(String contentData) {
        this.contentData = contentData;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String[] getUpdateField() {
        return updateField;
    }

    public void setUpdateField(String[] updateField) {
        this.updateField = updateField;
    }
}
