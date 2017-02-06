package igc.tech.com.mapper;

import igc.tech.com.model.EasyTreeModel;
import igc.tech.com.model.EasyTreeModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ganga on 6/17/2016.
 */
public class EasyTreeMapper {

    public List<EasyTreeModel> mapList(List<Map> list, String type) {

        List<EasyTreeModel> resultList = new ArrayList<>();
        Map map = new HashMap();
        map.put("opened", true);
        EasyTreeModel easyTreeModel1 = new EasyTreeModel();
        easyTreeModel1.setId("0");
        easyTreeModel1.setText(type);
        easyTreeModel1.setParent("#");
        easyTreeModel1.setState(map);
        resultList.add(easyTreeModel1);
        
        if(type.equals("address")){
            EasyTreeModel easyTreeModel;

            for (Map m : list) {
                easyTreeModel = mapAddressRow(m);
                resultList.add(easyTreeModel);
            }
        }

        if(type.equals("activity")){
            EasyTreeModel easyTreeModel;

            for (Map m : list) {
                easyTreeModel = mapActivityRow(m);
                resultList.add(easyTreeModel);
            }
        }

        if(type.equals("amenity")){
            EasyTreeModel easyTreeModel;

            for (Map m : list) {
                easyTreeModel = mapAmenityRow(m);
                resultList.add(easyTreeModel);
            }
        }

        if(type.equals("roomType")){
            EasyTreeModel easyTreeModel;

            for (Map m : list) {
                easyTreeModel = mapRoomTypeRow(m);
                resultList.add(easyTreeModel);
            }
        }

        return resultList;
    }

    public EasyTreeModel mapAddressRow(Map map) {

        EasyTreeModel easyTreeModel = new EasyTreeModel();

        easyTreeModel.setId(map.get("address_id").toString());
        easyTreeModel.setText(map.get("address_name").toString());
        easyTreeModel.setParent(map.get("parent_address_id")==null?"0":map.get("parent_address_id").toString());
        easyTreeModel.setType(map.get("type").toString());
        easyTreeModel.setLevel(map.get("level").toString());

        return easyTreeModel;
    }

    public EasyTreeModel mapActivityRow(Map map) {

        EasyTreeModel easyTreeModel = new EasyTreeModel();

        String text = map.get("activity_desc").toString();
        /*if(map.get("web_prior")!=null && map.get("mob_prior")!=null)
            text = text+"(web"+map.get("web_prior").toString()+"-mob"+map.get("mob_prior").toString()+")";
        else if(map.get("web_prior")!=null && map.get("mob_prior")==null)
            text = text+"(web"+map.get("web_prior").toString()+"-)";
        else if(map.get("web_prior")==null && map.get("mob_prior")!=null)
            text = text+"(mob"+map.get("mob_prior").toString()+")";*/

        easyTreeModel.setId(map.get("activity_id").toString());
//        easyTreeModel.setText(map.get("web_prior")==null?map.get("activity_desc").toString():map.get("activity_desc").toString()+" (web"+map.get("web_prior").toString());
//        easyTreeModel.setText(map.get("mob_prior")==null?easyTreeModel.getText():easyTreeModel.getText()+"-mob"+map.get("mob_prior").toString()+")");
        easyTreeModel.setText(text);
        easyTreeModel.setParent(map.get("parent_activity_id")==null?"0":map.get("parent_activity_id").toString());
        easyTreeModel.setChargeOption(map.get("charge_option")==null?null:map.get("charge_option").toString());
        easyTreeModel.setActive(map.get("active")==null?null:map.get("active").toString());
        easyTreeModel.setIcons(map.get("icon")==null?null:map.get("icon").toString());
        easyTreeModel.setImage(map.get("image")==null?null:map.get("image").toString());
        easyTreeModel.setDeletedFlag(map.get("deleted_flag")==null?null:map.get("deleted_flag").toString());

        return easyTreeModel;
    }

    public EasyTreeModel mapAmenityRow(Map map) {

        EasyTreeModel easyTreeModel = new EasyTreeModel();

        String text = map.get("amenity_desc").toString();
        /*if(map.get("web_prior")!=null && map.get("mob_prior")!=null)
            text = text+"(web"+map.get("web_prior").toString()+"-mob"+map.get("mob_prior").toString()+")";
        else if(map.get("web_prior")!=null && map.get("mob_prior")==null)
            text = text+"(web"+map.get("web_prior").toString()+"-)";
        else if(map.get("web_prior")==null && map.get("mob_prior")!=null)
            text = text+"(mob"+map.get("mob_prior").toString()+")";*/

        easyTreeModel.setId(map.get("amenity_id").toString());
        easyTreeModel.setText(text);
        easyTreeModel.setParent(map.get("parent_amenity_id")==null?"0":map.get("parent_amenity_id").toString());
        easyTreeModel.setActive(map.get("active")==null?null:map.get("active").toString());
        easyTreeModel.setIcons(map.get("icon")==null?null:map.get("icon").toString());
        easyTreeModel.setImage(map.get("image")==null?null:map.get("image").toString());
        easyTreeModel.setDeletedFlag(map.get("deleted_flag")==null?null:map.get("deleted_flag").toString());

        return easyTreeModel;
    }

    public EasyTreeModel mapRoomTypeRow(Map map) {

        EasyTreeModel easyTreeModel = new EasyTreeModel();

        easyTreeModel.setId(map.get("room_type_id").toString());
        easyTreeModel.setText(map.get("room_type_desc").toString());
        easyTreeModel.setParent(map.get("parent_room_type_id")==null?"0":map.get("parent_room_type_id").toString());
        easyTreeModel.setActive(map.get("active")==null?null:map.get("active").toString());

        return easyTreeModel;
    }
}
