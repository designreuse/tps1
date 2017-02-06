package igc.tech.com.model;

/**
 * Created by Ganga on 10/24/2016.
 */
public class ContentModel {
    private String contentId, contentTitle, contentUrl, contentPageTitle, contentBody, metaDescription, metaKeywords,
    metaTitle, active;

    private String[] contentTags;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getContentPageTitle() {
        return contentPageTitle;
    }

    public void setContentPageTitle(String contentPageTitle) {
        this.contentPageTitle = contentPageTitle;
    }

    public String getContentBody() {
        return contentBody;
    }

    public void setContentBody(String contentBody) {
        this.contentBody = contentBody;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String[] getContentTags() {
        return contentTags;
    }

    public void setContentTags(String[] contentTags) {
        this.contentTags = contentTags;
    }
}
