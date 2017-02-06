package igc.tech.com.dao;

import igc.tech.com.model.SelectedPaymentTypeModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface SelectedPaymentTypeDao {

    public List procSelectedPaymentType(SelectedPaymentTypeModel selectedPaymentTypeModel,
                                String user,
                                String flag);

}
