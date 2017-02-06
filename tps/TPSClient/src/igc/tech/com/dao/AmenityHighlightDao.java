package igc.tech.com.dao;

import igc.tech.com.model.AmenityHighlightModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface AmenityHighlightDao {

    public List procAmenityHighlight(AmenityHighlightModel amenityHighlightModel,
                                      String user,
                                      String flag);

}
