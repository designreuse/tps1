package igc.tech.com.dao;

import igc.tech.com.model.PaymentTypeModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface PaymentTypeDao {

    public List procPaymentType(PaymentTypeModel paymentTypeModel,
                            String user,
                            String flag);

}
