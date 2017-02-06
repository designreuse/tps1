package igc.tech.com.mapper;

import igc.tech.com.model.ContentCommentModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class ContentCommentMapper {


    public List<ContentCommentModel> mapList(List<Map> list) {

        List<ContentCommentModel> resultList = new ArrayList<>();

        ContentCommentModel contentCommentModel;

        for (Map m : list) {
            contentCommentModel = mapRow(m);
            resultList.add(contentCommentModel);
        }



        return resultList;
    }

    public ContentCommentModel mapRow(Map map) {

        ContentCommentModel contentCommentModel = new ContentCommentModel();


        contentCommentModel.setContentCommentId(map.get("content_comment_id").toString());
        contentCommentModel.setContentId(map.get("content_id").toString());
        contentCommentModel.setSenderName(map.get("sender_name").toString());
        contentCommentModel.setSenderEmail(map.get("sender_email").toString());
        contentCommentModel.setMessage(map.get("message").toString());
        contentCommentModel.setCommentDate(map.get("comment_date").toString());
        contentCommentModel.setApprove(map.get("approve").toString());



        return contentCommentModel;


    }
}
