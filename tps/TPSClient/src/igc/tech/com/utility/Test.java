package igc.tech.com.utility;

import com.google.maps.*;
import com.google.maps.model.*;


import com.sun.org.apache.xpath.internal.functions.Function;
import igc.tech.com.model.AddressModel;
import igc.tech.com.model.GeoNearPlaces;
import igc.tech.com.model.NearestAreaModel;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ganga on 5/24/2016.
 */
public class Test {

   /* public void geoCode() throws Exception{
        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyDo4OJXWwrEDZ4d7HsasdfHL_rb_ttpTKc");
        GeocodingResult[] results =  GeocodingApi.geocode(context,"kathmandu").await();
        System.out.println(results[0].addressComponents.length);
        Geometry geometry= results[0].geometry;

        LatLng location = new LatLng(geometry.location.lat,geometry.location.lng);

        System.out.println("latidute"+geometry.location.lat);
        System.out.println("longitue"+geometry.location.lng);


//        context = new GeoApiContext().setApiKey("AIzaSyDo4OJXWwrEDZ4d7HsasdfHL_rb_ttpTKc");
        NearbySearchRequest nearbySearchRequest = PlacesApi.nearbySearchQuery(context,location);
        nearbySearchRequest.type(PlaceType.FOOD);
        nearbySearchRequest.radius(500);

        PlacesSearchResponse placesSearchResponse = PlacesApi.nearbySearchQuery(context,location).type(PlaceType.FOOD).radius(500).await();



        System.out.println("test"+placesSearchResponse.results[0].name);



       *//* GooglePlaces client = new GooglePlaces("AIzaSyDo4OJXWwrEDZ4d7HsasdfHL_rb_ttpTKc");
        List<Place> places = client.getPlacesByQuery("kathmandu mall", GooglePlaces.MAXIMUM_RESULTS, Param.name("type").value("food"));

        System.out.println("places"+places);*//*




    }*/

    public static void main(String[] args) {
        Test test = new Test();

       /* List<AddressModel> nodes;
        Map<int,List<AddressModel>> tree  = new HashMap<AddressModel,ArrayList<AddressModel>>();
        List<AddressModel>           roots = new ArrayList<AddressModel>();
        for(AddressModel n : nodes) {
            if(n.getParentAddressId() == null)
                roots.add(n);
            else {
                if(!tree.containsKey(n.getParentAddressId()))
                    tree.put(n.getParentAddressId(), new ArrayList<AddressModel>());
                tree.get(n.getParentAddressId()).add(n);
            }
        }*/

        /*List<AddressModel> addressModelList=new ArrayList<>();

        AddressModel addressModel = new AddressModel();
        List<AddressModel> root = new ArrayList<AddressModel>();
        List<AddressModel> leafNode = new ArrayList<AddressModel>();

        for (AddressModel addressModel1:addressModelList) {
            if(addressModel1.getParentAddressId()==null){
                root.add(addressModel1);
            }else{
                if(!leafNode.contains(addressModel1.getParentAddressId()) ){

                }
            }
        }*/
        String str = "/hotelDetail/view";
        System.out.println(str.indexOf("/", str.indexOf("/") + 1));
        System.out.println(str.substring(str.indexOf("/"),str.indexOf("/", str.indexOf("/") + 1)+1));


    }
}
