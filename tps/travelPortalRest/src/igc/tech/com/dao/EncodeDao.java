package igc.tech.com.dao;

import igc.tech.com.model.EncodeModel;

import java.util.List;


public interface EncodeDao {

    public List procEncode(EncodeModel encodeModel, String flag);

}
