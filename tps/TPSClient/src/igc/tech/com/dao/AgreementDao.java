package igc.tech.com.dao;

import igc.tech.com.model.AgreementModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface AgreementDao {

    public List procAgreement(AgreementModel agreementModel,
                             String user,
                             String flag);

}
