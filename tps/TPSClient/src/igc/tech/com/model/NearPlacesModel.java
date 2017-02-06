package igc.tech.com.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ganga on 5/29/2016.
 */
public class NearPlacesModel {
    private String nearPlaceId, hotelDetailId, placeName, type, lat, lng, distance;

    private int checked;

    private List<NearPlacesModel> nearPlacesModels;

    private String[] types;

    public String getNearPlaceId() {
        return nearPlaceId;
    }

    public void setNearPlaceId(String nearPlaceId) {
        this.nearPlaceId = nearPlaceId;
    }

    public String getHotelDetailId() {
        return hotelDetailId;
    }

    public void setHotelDetailId(String hotelDetailId) {
        this.hotelDetailId = hotelDetailId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public List<NearPlacesModel> getNearPlacesModels() {
        return nearPlacesModels;
    }

    public void setNearPlacesModels(List<NearPlacesModel> nearPlacesModels) {
        this.nearPlacesModels = nearPlacesModels;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "NearPlacesModel{" +
                "nearPlaceId='" + nearPlaceId + '\'' +
                ", hotelDetailId='" + hotelDetailId + '\'' +
                ", placeName='" + placeName + '\'' +
                ", type='" + type + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", distance='" + distance + '\'' +
                ", checked=" + checked +
                ", nearPlacesModels=" + nearPlacesModels +
                ", types=" + Arrays.toString(types) +
                '}';
    }
}
