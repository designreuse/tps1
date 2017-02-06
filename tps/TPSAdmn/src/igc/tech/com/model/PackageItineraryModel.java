package igc.tech.com.model;


public class PackageItineraryModel {

    private String packageItineraryId;
    private String packageInfoId;
    private String packageName;
    private String day;
    private String dayDetails;
    private String hotelDetailId;
    private String hotelName;

    private String user;

    public String getPackageItineraryId() {
        return packageItineraryId;
    }

    public void setPackageItineraryId(String packageItineraryId) {
        this.packageItineraryId = packageItineraryId;
    }

    public String getPackageInfoId() {
        return packageInfoId;
    }

    public void setPackageInfoId(String packageInfoId) {
        this.packageInfoId = packageInfoId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDayDetails() {
        return dayDetails;
    }

    public void setDayDetails(String dayDetails) {
        this.dayDetails = dayDetails;
    }

    public String getHotelDetailId() {
        return hotelDetailId;
    }

    public void setHotelDetailId(String hotelDetailId) {
        this.hotelDetailId = hotelDetailId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


}
