package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tilak on 3/17/2016.
 */

@XmlRootElement(name = "Balance")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class BalanceModel {


   private String balance;


    private AirlineModel airline;

    public String getBalance() {
        return balance;
    }

    @XmlElement(name = "Balance")
    public void setBalance(String balance) {
        this.balance = balance;
    }



    public AirlineModel getAirline() {
        return airline;
    }

    @XmlElement(name = "Airline")
    public void setAirline(AirlineModel airline) {
        this.airline = airline;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "balance='" + balance + '\'' +
                ", airline=" + airline +
                '}';
    }
}
