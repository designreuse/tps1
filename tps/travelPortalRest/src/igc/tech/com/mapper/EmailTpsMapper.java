package igc.tech.com.mapper;

import igc.tech.com.model.EmailTpsModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 2/9/2016.
 */
public class EmailTpsMapper {

    @SuppressWarnings("rawtypes")
    public List<EmailTpsModel> mapList(List<Map> list) {
        List<EmailTpsModel> resultList = new ArrayList<>();

        EmailTpsModel emailTpsModel;

        for (Map m : list) {
            emailTpsModel = mapRow(m);
            resultList.add(emailTpsModel);
        }

        return resultList;
    }

    @SuppressWarnings("rawtypes")
    public EmailTpsModel mapRow(Map map) {

        EmailTpsModel emailTpsModel = new EmailTpsModel();

        /*
        * .region_id,
        a.region_name,
        b.country_id,
        b.country_name,
        c.emailTps_name,
        c.emailTps_id
        *
        * */

        emailTpsModel.setEmailTpsId(map.get("email_tps_id").toString());
        emailTpsModel.setEmailAddress(map.get("email_address").toString());
        emailTpsModel.setActive(map.get("active").toString());


        return emailTpsModel;
    }
}
