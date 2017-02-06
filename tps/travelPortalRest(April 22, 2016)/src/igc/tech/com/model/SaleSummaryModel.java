package igc.tech.com.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by tilak on 3/27/2016.
 */

@XmlRootElement(name = "SalesSummary")
public class SaleSummaryModel {

    private List<TicketDetailModel> ticketDetailModels;

    public List<TicketDetailModel> getTicketDetailModels() {
        return ticketDetailModels;
    }

    @XmlElement(name = "TicketDetail")
    public void setTicketDetailModels(List<TicketDetailModel> ticketDetailModels) {
        this.ticketDetailModels = ticketDetailModels;
    }

    @Override
    public String toString() {
        return "SaleSummaryModel{" +
                "ticketDetailModels=" + ticketDetailModels +
                '}';
    }
}
