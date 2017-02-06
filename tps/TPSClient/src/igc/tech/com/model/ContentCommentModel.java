package igc.tech.com.model;

/**
 * Created by Ganga on 10/25/2016.
 */
public class ContentCommentModel {
    private String contentCommentId, contentId, senderName, senderEmail, message, commentDate, approve;

    public String getContentCommentId() {
        return contentCommentId;
    }

    public void setContentCommentId(String contentCommentId) {
        this.contentCommentId = contentCommentId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getApprove() {
        return approve;
    }

    public void setApprove(String approve) {
        this.approve = approve;
    }
}
