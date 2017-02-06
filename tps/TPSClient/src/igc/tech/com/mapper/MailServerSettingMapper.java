package igc.tech.com.mapper;

import igc.tech.com.model.MailServerSettingModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class MailServerSettingMapper {


    public List<MailServerSettingModel> mapList(List<Map> list) {

        List<MailServerSettingModel> resultList = new ArrayList<>();
        if(list.isEmpty()){
            return resultList;
        }

        MailServerSettingModel mailServerSettingModel;

        for (Map m : list) {
            mailServerSettingModel = mapRow(m);
            resultList.add(mailServerSettingModel);
        }



        return resultList;
    }

    public MailServerSettingModel mapRow(Map map) {

        MailServerSettingModel mailServerSettingModel = new MailServerSettingModel();

        mailServerSettingModel.setMailServerSettingId(map.get("mail_server_setting_id").toString());
        mailServerSettingModel.setDisplayName(map.get("display_name").toString());
        mailServerSettingModel.setEmailId(map.get("email_id").toString());
        mailServerSettingModel.setPassword(map.get("password").toString());
        mailServerSettingModel.setHost(map.get("host").toString());
        mailServerSettingModel.setPort(map.get("port").toString());
        mailServerSettingModel.setActive(map.get("active").toString());

        return mailServerSettingModel;


    }
}
