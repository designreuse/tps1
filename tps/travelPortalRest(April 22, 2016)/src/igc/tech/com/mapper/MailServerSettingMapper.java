package igc.tech.com.mapper;

import igc.tech.com.model.MailServerSettingModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MailServerSettingMapper {


    public List<MailServerSettingModel> mapList(List<Map> list) {

        List<MailServerSettingModel> resultList = new ArrayList<>();

        MailServerSettingModel mailServerSettingModel;

        for (Map m : list) {
            mailServerSettingModel = mapRow(m);
            resultList.add(mailServerSettingModel);
        }

        return resultList;
    }

    public MailServerSettingModel mapRow(Map map) {

        MailServerSettingModel mailServerSettingModel = new MailServerSettingModel();

        if (map.get("mail_server_setting_id") != null) {

            mailServerSettingModel.setMailServerSettingId(map.get("mail_server_setting_id").toString());
        }
        if (map.get("email_id") != null) {

            mailServerSettingModel.setEmailId(map.get("email_id").toString());
        }
        if (map.get("password") != null) {

            mailServerSettingModel.setPassword(map.get("password").toString());
        }
        if (map.get("host") != null) {

            mailServerSettingModel.setHost(map.get("host").toString());
        }
        if (map.get("port") != null) {

            mailServerSettingModel.setPort(map.get("port").toString());
        }
        if (map.get("active") != null) {

            mailServerSettingModel.setActive(map.get("active").toString());
        }

        if (map.get("user_name") != null) {

            mailServerSettingModel.setUserName(map.get("user_name").toString());
        }

        return mailServerSettingModel;
    }

    /*public HotelDetailModel mapRowSetNull(boolean hotelDetailId,
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
    }*/


}
