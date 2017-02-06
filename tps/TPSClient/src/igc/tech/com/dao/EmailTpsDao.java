package igc.tech.com.dao;

import igc.tech.com.model.EmailTpsModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface EmailTpsDao {

    public List procEmailTps(EmailTpsModel emailTpsModel,
                             String user,
                             String flag);

}
