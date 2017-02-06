package igc.tech.com.model;


import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "FlightSector")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class FlightSectorModel {

    private  String sectorCode;
    private  String sectorName;

    private List<FlightSectorModel> sector;


    public String getSectorCode() {
        return sectorCode;
    }

    @XmlElement(name = "SectorCode")
    public void setSectorCode(String sectorCode) {
        this.sectorCode = sectorCode;
    }

    public String getSectorName() {
        return sectorName;
    }

    @XmlElement(name = "SectorName")
    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public List<FlightSectorModel> getSector() {
        return sector;
    }

    @XmlElement(name = "Sector")
    public void setSector(List<FlightSectorModel> sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "FlightSector{" +
                "sectorCode='" + sectorCode + '\'' +
                ", sectorName='" + sectorName + '\'' +
                ", sector=" + sector +
                '}';
    }
}