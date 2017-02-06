package igc.tech.com.model;

/**
 * Created by Ganga on 4/12/2016.
 */
public class TokenModel {
    private String tokenId, token, status, userDetailId, step;

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(String userDetailId) {
        this.userDetailId = userDetailId;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return "TokenModel{" +
                "tokenId='" + tokenId + '\'' +
                ", token='" + token + '\'' +
                ", status='" + status + '\'' +
                ", userDetailId='" + userDetailId + '\'' +
                ", step='" + step + '\'' +
                '}';
    }
}
