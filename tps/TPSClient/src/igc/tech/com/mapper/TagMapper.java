package igc.tech.com.mapper;

import igc.tech.com.model.TagModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class TagMapper {


    public List<TagModel> mapList(List<Map> list) {

        List<TagModel> resultList = new ArrayList<>();

        TagModel tagModel;

        for (Map m : list) {
            tagModel = mapRow(m);
            resultList.add(tagModel);
        }



        return resultList;
    }

    public TagModel mapRow(Map map) {

        TagModel tagModel = new TagModel();

        tagModel.setTagId(map.get("tag_id").toString());
        tagModel.setDescription(map.get("description").toString());
        tagModel.setActive(map.get("active").toString());

        return tagModel;


    }
}
