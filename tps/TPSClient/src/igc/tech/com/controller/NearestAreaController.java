package igc.tech.com.controller;


import com.google.appengine.repackaged.com.google.common.base.Flag;
import com.google.maps.model.*;
import igc.tech.com.dao.*;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.NearPlacesMapper;
import igc.tech.com.mapper.NearestAreaMapper;
import igc.tech.com.model.HotelDetailModel;
import igc.tech.com.model.NearPlacesModel;
import igc.tech.com.model.NearestAreaModel;
import igc.tech.com.model.TokenModel;
import igc.tech.com.utility.GeoCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
@RequestMapping(value = "/nearestArea")
class NearestAreaController {

    @Autowired
    NearestAreaDao nearestAreaDao;

    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    NearPlacesDao nearPlacesDao;

    /*@RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getAll(Model model, HttpSession session) {

        NearestAreaModel nearestAreaModel= new NearestAreaModel();
        nearestAreaModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());

        List<NearestAreaModel> nearestAreaModelList = new NearestAreaMapper().mapList(nearestAreaDao.procNearestArea(nearestAreaModel,null,"b"));
        model.addAttribute("nearestPlaceList", nearestAreaModelList);

        model.addAttribute("base", "nearestArea");

        *//*Map map = (Map) hotelDetailDao.procHotelDetail(hotelId,null,null,null,null,null,null,null,null,null,null,null,null,null,"s").get(0);
        model.addAttribute("hotelName",map.get("hotel_name"));*//*


        return "nearestArea";

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String addNearestArea(Model model, String[] distance, String[] nearestPlaceId, String[] popularPlaceId, String[] active,String hotelDetailId, HttpSession session, RedirectAttributes redirectAttributes) {

        Map map = new HashMap();
        NearestAreaModel nearestAreaModel = new NearestAreaModel();
        if(Arrays.asList(nearestPlaceId).contains("")){
            for(int i=0;i<nearestPlaceId.length;i++){
                nearestAreaModel.setHotelDetailId(hotelDetailId);
                nearestAreaModel.setPopularPlaceId(popularPlaceId[i]);
                List<Map> list=  nearestAreaDao.procNearestArea(nearestAreaModel,null,"s");
                if(list.isEmpty()) {
                    nearestAreaModel.setActive("N");
                    map = (Map) nearestAreaDao.procNearestArea(nearestAreaModel, session.getAttribute("userName").toString(), "i").get(0);
                }

            }
        }else if(nearestPlaceId.length>popularPlaceId.length){
            System.out.println("error");
        }

        *//*set active to 'N' in nearest_area whose hotel_detail_id is hotelDetailId*//*
        nearestAreaModel.setPopularPlaceId(null);

        map= (Map) nearestAreaDao.procNearestArea(nearestAreaModel, session.getAttribute("userName").toString(),"u").get(0);

        *//*update active to 'Y' whose populare_place_id and hotel_detail_id as specified*//*

        for(int i=0;i<active.length;i++){
            *//*in active array the value is populare_place_id*//*
            nearestAreaModel.setPopularPlaceId(active[i]);
            nearestAreaModel.setDistance(distance[i]);
            nearestAreaModel.setActive("Y");
            map = (Map) nearestAreaDao.procNearestArea(nearestAreaModel, session.getAttribute("userName").toString(),"u").get(0);
        }

        redirectAttributes.addFlashAttribute("dbResponse", map);

        return "redirect:view/";

    }
*/
    @RequestMapping(value = "/viewNearPlaces", method = RequestMethod.GET)
    public String viewNearPlaces(Model model, HttpSession session) throws Exception {

        NearPlacesModel nearPlacesModel3 = new NearPlacesModel();
        nearPlacesModel3.setHotelDetailId(session.getAttribute("hotelDetailId").toString());
        List<NearPlacesModel> nearPlacesModelList1 = new NearPlacesMapper().mapList(nearPlacesDao.procNearPlaces(nearPlacesModel3,null,"s"));

        HotelDetailModel hotelDetailModel = new HotelDetailModel();
        hotelDetailModel.setHotelDetailId(session.getAttribute("hotelDetailId").toString());

        List lst = hotelDetailDao.procHotelDetail(hotelDetailModel, null, "s");
        if(lst.isEmpty()){
            return "nearPlaces";
        }
        hotelDetailModel = new HotelDetailMapper().mapRow((Map) lst.get(0));

        String lat = hotelDetailModel.getLat();
        String lng = hotelDetailModel.getLng();
        GeoCode geoCode = new GeoCode();
        Map<String, PlacesSearchResponse> map = geoCode.getNearPlace(lat, lng);


        Map<String, List<NearPlacesModel>> map1 = new HashMap<String, List<NearPlacesModel>>();

        Object[] keySet = map.keySet().toArray();
        model.addAttribute("keySet", keySet);
        for(int j=0; j<keySet.length;j++) {
            int i=0;
String abc = keySet[j].toString();
            PlacesSearchResponse placesSearchResponse = map.get(keySet[j]);
            System.out.println(placesSearchResponse.results.length);
            List<NearPlacesModel> nearPlacesModelList = new ArrayList<NearPlacesModel>();

//        PlacesSearchResponse placesSearchResponse = map.get("food");
            List<LatLng> list = new ArrayList();
            if(placesSearchResponse.results.length>0){
                for (PlacesSearchResult placesSearchResult : placesSearchResponse.results) {
                    int checked = 0;
                    NearPlacesModel nearPlacesModel = new NearPlacesModel();
                    nearPlacesModel.setPlaceName(placesSearchResult.name);
                    nearPlacesModel.setTypes(placesSearchResult.types);
                    nearPlacesModel.setLat(Double.toString(placesSearchResult.geometry.location.lat));
                    nearPlacesModel.setLng(Double.toString(placesSearchResult.geometry.location.lng));

                    for(NearPlacesModel nearPlacesModel1: nearPlacesModelList1){
                        System.out.println(nearPlacesModel1.getLat());
                        System.out.println(placesSearchResult.geometry.location.lat);
                        if(Double.parseDouble(nearPlacesModel1.getLat())== placesSearchResult.geometry.location.lat &&
                                Double.parseDouble(nearPlacesModel1.getLng())==(placesSearchResult.geometry.location.lng) && keySet[j].toString().equals(nearPlacesModel1.getType())){

                                checked=1;
                                break;

                        }

                    }
                    nearPlacesModel.setChecked(checked);

                    nearPlacesModelList.add(nearPlacesModel);
                    list.add(placesSearchResult.geometry.location);

                }
                model.addAttribute("nearPlaceSearch", nearPlacesModelList);

                System.out.println(("list"+list));

                DistanceMatrix distanceMatrix = geoCode.getDistance(lat, lng, list);
                model.addAttribute("distance", distanceMatrix);


                for (DistanceMatrixRow distanceMatrixRow : distanceMatrix.rows) {

                    for (DistanceMatrixElement distanceMatrixElement : distanceMatrixRow.elements) {
                        NearPlacesModel nearPlacesModel = nearPlacesModelList.get(i);
//                Distance distance = distanceMatrixElement.distance;
                        nearPlacesModel.setDistance(distanceMatrixElement.distance.humanReadable);
                        i++;
                    }
                }
                System.out.println("list size: "+nearPlacesModelList.size());
                map1.put(keySet[j].toString(),nearPlacesModelList);
            }else{
                map.remove(keySet[j]);
            }


        }
        System.out.println("nearPlaceSearch "+map1);
        System.out.println(map1.get("store"));
        model.addAttribute("nearPlaceSearch", map1);
        model.addAttribute("base", "nearestArea");




        return "nearPlaces";

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNearPlaces(NearPlacesModel nearPlacesModel,String[] checked, HttpSession session,  RedirectAttributes redirectAttributes ){
        String hotelDetailId = nearPlacesModel.getHotelDetailId();
        System.out.println(nearPlacesModel);
        nearPlacesDao.procNearPlaces(nearPlacesModel,session.getAttribute("userName").toString(),"d");
        List<NearPlacesModel> nearPlacesModelList = nearPlacesModel.getNearPlacesModels();
        Map map = new HashMap();
        if(checked!=null){
            for(int i = 0; i< checked.length; i++){
                System.out.println(checked[i]);

                NearPlacesModel nearPlacesModel1 = nearPlacesModelList.get(Integer.parseInt(checked[i]));
                nearPlacesModel1.setHotelDetailId(hotelDetailId);
                map = (Map) nearPlacesDao.procNearPlaces(nearPlacesModel1,"ganga","i").get(0);

            }
        }

        redirectAttributes.addFlashAttribute("response", map);
        return "redirect:/nearestArea/viewNearPlaces";
    }


}
