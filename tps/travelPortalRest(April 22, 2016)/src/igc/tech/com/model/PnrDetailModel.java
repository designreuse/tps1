package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tilak on 3/18/2016.
 */
@XmlRootElement(name = "PNRDetail")
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class PnrDetailModel {

    private String airlineId;
    private String flightId;
    private String pnrNo;
    private String reservationStatus;
    private String ttlDate;
    private String ttlTime;

    public String getPnrNo() {
        return pnrNo;
    }

    @XmlElement(name ="PNRNO" )
    public void setPnrNo(String pnrNo) {
        this.pnrNo = pnrNo;
    }

    public String getTtlDate() {
        return ttlDate;
    }

    @XmlElement(name ="TTLDate" )
    public void setTtlDate(String ttlDate) {
        this.ttlDate = ttlDate;
    }

    public String getTtlTime() {
        return ttlTime;
    }

    @XmlElement(name ="TTLTime" )
    public void setTtlTime(String ttlTime) {
        this.ttlTime = ttlTime;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    @XmlElement(name ="ReservationStatus" )
    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public String getAirlineId() {
        return airlineId;
    }


    @XmlElement(name ="AirlineID" )
    public void setAirlineId(String airlineId) {
        this.airlineId = airlineId;
    }

    public String getFlightId() {
        return flightId;
    }

    @XmlElement(name ="FlightId" )
    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    @Override
    public String toString() {
        return "PnrDetailModel{" +
                "airlineId='" + airlineId + '\'' +
                ", flightId='" + flightId + '\'' +
                ", pnrNo='" + pnrNo + '\'' +
                ", reservationStatus='" + reservationStatus + '\'' +
                ", ttlDate='" + ttlDate + '\'' +
                ", ttlTime='" + ttlTime + '\'' +
                '}';
    }
}
