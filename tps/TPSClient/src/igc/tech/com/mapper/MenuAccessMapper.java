package igc.tech.com.mapper;


import igc.tech.com.model.MenuAccessModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class MenuAccessMapper {

    public List<MenuAccessModel> mapList(List<Map> list) {

        List<MenuAccessModel> resultList = new ArrayList<>();

        MenuAccessModel menuAccessModel;

        for (Map m : list) {
            menuAccessModel = mapRow(m);
            resultList.add(menuAccessModel);
        }



        return resultList;
    }

    public MenuAccessModel mapRow(Map map) {

        MenuAccessModel menuAccessModel = new MenuAccessModel();

        menuAccessModel.setMenuAccessId(map.get("menu_access_id")==null?null:map.get("menu_access_id").toString());
        menuAccessModel.setRoleId(map.get("role_id")==null?null:map.get("role_id").toString());
        menuAccessModel.setMenuId(map.get("menu_id").toString());
        menuAccessModel.setMenuDesc(map.get("menu_desc")==null?null:map.get("menu_desc").toString());
        menuAccessModel.setMenuUrl(map.get("menu_url")==null?null:map.get("menu_url").toString());
        menuAccessModel.setParentMenuId(map.get("parent_menu_id")==null?null:map.get("parent_menu_id").toString());
        menuAccessModel.setParentMenuDesc(map.get("parent_menu_desc")==null?null:map.get("parent_menu_desc").toString());
        menuAccessModel.setLevel(map.get("level")==null?null:map.get("level").toString());

        return menuAccessModel;


    }
}
