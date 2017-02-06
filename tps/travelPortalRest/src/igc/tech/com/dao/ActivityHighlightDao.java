package igc.tech.com.dao;

import igc.tech.com.model.ActivityHighlightModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface ActivityHighlightDao {

    public List procActivityHighlight(ActivityHighlightModel activityHighlightModel, String user, String flag) ;

}
