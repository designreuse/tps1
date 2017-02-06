package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tilak on 5/12/2016.
 */
@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelRoomLog {

    private String hotelRoomLogId;
    private String checkInDate;
    private String checkOutDate;
    private int noOfRooms;
    private int noOfAdults;
    private  int noOfChild;

    private String finalRate;
    private String customerDetailId;
    private String roomDetailId;
    private String reserveType;
    private String cancelStatus;
    private String cancelDate;
    private String guestName;
    private String guestPhNo;
    private String guestEmailId;



}
