package igc.tech.com.dao;

import igc.tech.com.model.CancellationModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface CancellationDao {

    public List procCancellation(CancellationModel cancellationModel,
                             String user,
                             String flag);

}
