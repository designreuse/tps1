package igc.tech.com.utility;

import com.google.appengine.repackaged.com.google.common.base.Flag;
import com.google.maps.*;
import com.google.maps.model.*;
import igc.tech.com.model.GeoNearPlaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ganga on 5/25/2016.
 */
public class GeoCode {
    GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyDo4OJXWwrEDZ4d7HsasdfHL_rb_ttpTKc");
    public Map getNearPlace(String lat, String lng) throws Exception{

        PlaceType[] type = {PlaceType.FOOD,PlaceType.STORE,PlaceType.BUS_STATION,PlaceType.TAXI_STAND};
//        List<Map> placesSearchResponseList = new ArrayList<Map>();

        LatLng location = new LatLng(Double.parseDouble(lat) ,Double.parseDouble(lng));

        Map<String, PlacesSearchResponse> map = new HashMap<String, PlacesSearchResponse>();
        for(int i= 0 ;i<type.length;i++){


            PlacesSearchResponse placesSearchResponse = PlacesApi.nearbySearchQuery(context,location).type(type[i]).radius(500).await();
            map.put(type[i].toString(),placesSearchResponse);
            System.out.println("result length "+placesSearchResponse.results.length);
//            placesSearchResponseList.add(map);
        }

        /*for(int i=0; i<placesSearchResponse.results.length;i++){
            PlacesSearchResult placesSearchResult= placesSearchResponse.results[i];
            GeoNearPlaces geoNearPlaces = new GeoNearPlaces();
            geoNearPlaces.setIcon(placesSearchResult.icon.toString());
            geoNearPlaces.setPlaceId(placesSearchResult.placeId);
            geoNearPlaces.setLat(Double.toString(placesSearchResult.geometry.location.lat));
            geoNearPlaces.setLng(Double.toString(placesSearchResult.geometry.location.lng));
            geoNearPlaces.setName(placesSearchResult.name);
            geoNearPlaces.setTypes(placesSearchResult.types);
        }*/

        return map;

    }

    public DistanceMatrix getDistance(String lat, String lng, List<LatLng> list) throws Exception{

//        LatLng location = new LatLng(Double.parseDouble(lat) ,Double.parseDouble(lng));

        String[] origin = {lat+","+lng};

        String[] destination = new String[list.size()];

        System.out.println(destination.length);

        for(int i=0;i<list.size();i++){
            destination[i] = list.get(i).lat+","+list.get(i).lng;
        }

        DistanceMatrix distanceMatrix = DistanceMatrixApi.getDistanceMatrix(context, origin, destination).await();

        return distanceMatrix;

    }
}
