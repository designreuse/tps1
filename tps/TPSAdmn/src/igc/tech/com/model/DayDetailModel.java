package igc.tech.com.model;


public class DayDetailModel {

    private String dayDetailId;
    private String packageName;
    private String packageItineraryId;
    private String day;
    private String activityDetailId;
    private String activityName;
    private String user;


    public String getDayDetailId() {
        return dayDetailId;
    }

    public void setDayDetailId(String dayDetailId) {
        this.dayDetailId = dayDetailId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageItineraryId() {
        return packageItineraryId;
    }

    public void setPackageItineraryId(String packageItineraryId) {
        this.packageItineraryId = packageItineraryId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getActivityDetailId() {
        return activityDetailId;
    }

    public void setActivityDetailId(String activityDetailId) {
        this.activityDetailId = activityDetailId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


}
