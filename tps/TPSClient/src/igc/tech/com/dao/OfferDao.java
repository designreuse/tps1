package igc.tech.com.dao;

import igc.tech.com.model.OfferModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface OfferDao {

    public List procOffer(OfferModel offerModel,
                             String user,
                             String flag);

}
