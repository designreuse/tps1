package igc.tech.com.mapper;

import igc.tech.com.model.HotelDetailModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HotelDetailMapper {


    public List<HotelDetailModel> mapList(List<Map> list) {

        List<HotelDetailModel> resultList = new ArrayList<>();

        HotelDetailModel hotelDetail;

        for (Map m : list) {
            hotelDetail = mapRow(m);
            resultList.add(hotelDetail);
        }

        // System.out.println("ffasdf");

        return resultList;
    }

    public HotelDetailModel mapRow(Map map) {


        HotelDetailModel hotelDetail = new HotelDetailModel();


        if (map.get("hotel_detail_id") != null) {

            hotelDetail.setHotelDetailId(map.get("hotel_detail_id").toString());
        }
        if (map.get("hotel_name") != null) {

            hotelDetail.setHotelName(map.get("hotel_name").toString());
        }
        if (map.get("hotel_ph_no_1") != null) {

            hotelDetail.setHotelPhNo1(map.get("hotel_ph_no_1").toString());
        }
        if (map.get("hotel_ph_no_2") != null) {

            hotelDetail.setHotelPhNo2(map.get("hotel_ph_no_2").toString());
        }
        if (map.get("hotel_ph_no_3") != null) {

            hotelDetail.setHotelPhNo3(map.get("hotel_ph_no_3").toString());
        }
        if (map.get("hotel_address") != null) {

            hotelDetail.setHotelAddress(map.get("hotel_address").toString());
        }
        if (map.get("hotel_email_id") != null) {

            hotelDetail.setHotelEmailId(map.get("hotel_email_id").toString());
        }

        if (map.get("client_detail_id") != null) {

            hotelDetail.setClientDetailId(map.get("client_detail_id").toString());
        }
        if (map.get("client_name") != null) {

            hotelDetail.setClientName(map.get("client_name").toString());
        }
        if (map.get("area_id") != null) {

            hotelDetail.setAreaId(map.get("area_id").toString());
        }

        if (map.get("area_name") != null) {

            hotelDetail.setAreaName(map.get("area_name").toString());
        }

        if (map.get("region_name") != null) {

            hotelDetail.setRegionName(map.get("region_name").toString());
        }


        if (map.get("country_name") != null) {

            hotelDetail.setCountryName(map.get("country_name").toString());
        }


        if (map.get("url") != null) {

            hotelDetail.setUrl(map.get("url").toString());
        }

        return hotelDetail;
    }

    public HotelDetailModel mapRowSetNull(boolean hotelDetailId,
                                          boolean hotelName,
                                          boolean hotelPhNo1,
                                          boolean hotelPhNo2,
                                          boolean hotelPhNo3,
                                          boolean hotelAddress,
                                          boolean hotelEmailId,
                                          boolean areaId,
                                          boolean areaName,
                                          boolean regionName,
                                          boolean countryName,
                                          boolean url,
                                          boolean clietDetailId,
                                          boolean clientName,
                                          HotelDetailModel hotelDetailModel) {


        if (hotelDetailId == true) {

            hotelDetailModel.setHotelDetailId(null);
        }
        if (hotelName == true) {

            hotelDetailModel.setHotelName(null);
        }
        if (hotelPhNo1 == true) {

            hotelDetailModel.setHotelPhNo1(null);
        }
        if (hotelPhNo2 == true) {

            hotelDetailModel.setHotelPhNo2(null);
        }
        if (hotelPhNo3 == true) {

            hotelDetailModel.setHotelPhNo3(null);
        }
        if (hotelAddress == true) {

            hotelDetailModel.setHotelAddress(null);
        }
        if (hotelEmailId == true) {

            hotelDetailModel.setHotelEmailId(null);
        }

        if (clietDetailId == true) {

            hotelDetailModel.setClientDetailId(null);
        }
        if (clientName == true) {

            hotelDetailModel.setClientName(null);
        }
        if (areaId == true) {

            hotelDetailModel.setAreaId(null);
        }

        if (areaName == true) {

            hotelDetailModel.setAreaName(null);
        }

        if (regionName == true) {

            hotelDetailModel.setRegionName(null);
        }


        if (countryName == true) {

            hotelDetailModel.setCountryName(null);
        }


        if (url == true) {

            hotelDetailModel.setUrl(null);
        }


        return hotelDetailModel;
    }

    public List<HotelDetailModel> mapListSetNull(boolean hotelDetailId,
                                                 boolean hotelName,
                                                 boolean hotelPhNo1,
                                                 boolean hotelPhNo2,
                                                 boolean hotelPhNo3,
                                                 boolean hotelAddress,
                                                 boolean hotelEmailId,
                                                 boolean areaId,
                                                 boolean areaName,
                                                 boolean regionName,
                                                 boolean countryName,
                                                 boolean url,
                                                 boolean clietDetailId,
                                                 boolean clientName,
                                                 List<HotelDetailModel> hotelDetailModels) {

        for (HotelDetailModel hotelDetailModel : hotelDetailModels) {

            hotelDetailModel = mapRowSetNull(hotelDetailId, hotelName, hotelPhNo1, hotelPhNo2, hotelPhNo3, hotelAddress, hotelEmailId, areaId, areaName, regionName, countryName, url, clietDetailId, clientName, hotelDetailModel);

        }

        return hotelDetailModels;
    }


}
