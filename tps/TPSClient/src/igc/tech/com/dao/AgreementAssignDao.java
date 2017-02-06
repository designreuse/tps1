package igc.tech.com.dao;

import igc.tech.com.model.AgreementAssignModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface AgreementAssignDao {

    public List procAgreementAssign(AgreementAssignModel agreementAssignModel,
                             String user,
                             String flag);

}
