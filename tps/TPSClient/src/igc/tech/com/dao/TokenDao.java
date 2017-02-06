package igc.tech.com.dao;

import igc.tech.com.model.TokenModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface TokenDao {

    public List procToken(TokenModel tokenModel,
                          String user,
                          String flag);

}
