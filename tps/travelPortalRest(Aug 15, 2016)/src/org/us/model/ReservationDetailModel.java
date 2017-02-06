package org.us.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by tilak on 3/18/2016.
 */
@XmlRootElement(name = "ReservationDetail")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class ReservationDetailModel {

    private List<PnrDetailModel> pnrDetail;

    public List<PnrDetailModel> getPnrDetail() {
        return pnrDetail;
    }

    @XmlElement(name = "PNRDetail")
    public void setPnrDetail(List<PnrDetailModel> pnrDetail) {
        this.pnrDetail = pnrDetail;
    }

    @Override
    public String toString() {
        return "ReservationDetail{" +
                "pnrDetail=" + pnrDetail +
                '}';
    }
}
