package igc.tech.com.model;

import java.util.List;

/**
 * Created by Ganga on 3/29/2016.
 */
public class NearestAreaModel {
    private String nearestAreaId;
    private String hotelDetailId;
    private String popularPlaceId;
    private String distance;
    private String hotelName;
    private String place;
    private String type;
    private String active;

    private List<NearestAreaModel> nearestAreaModels;

    public String getNearestAreaId() {
        return nearestAreaId;
    }

    public void setNearestAreaId(String nearestAreaId) {
        this.nearestAreaId = nearestAreaId;
    }

    public String getHotelDetailId() {
        return hotelDetailId;
    }

    public void setHotelDetailId(String hotelDetailId) {
        this.hotelDetailId = hotelDetailId;
    }

    public String getPopularPlaceId() {
        return popularPlaceId;
    }

    public void setPopularPlaceId(String popularPlaceId) {
        this.popularPlaceId = popularPlaceId;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<NearestAreaModel> getNearestAreaModels() {
        return nearestAreaModels;
    }

    public void setNearestAreaModels(List<NearestAreaModel> nearestAreaModels) {
        this.nearestAreaModels = nearestAreaModels;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "NearestAreaModel{" +
                "nearestAreaId='" + nearestAreaId + '\'' +
                ", hotelDetailId='" + hotelDetailId + '\'' +
                ", popularPlaceId='" + popularPlaceId + '\'' +
                ", distance='" + distance + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", place='" + place + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
