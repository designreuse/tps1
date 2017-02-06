package igc.tech.com.dao;

import igc.tech.com.model.PayGateAccessModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface PayGateAccessDao {

    public List procPayGateAccess(PayGateAccessModel payGateAccessModel,
                                  String user,
                                  String flag);

}
