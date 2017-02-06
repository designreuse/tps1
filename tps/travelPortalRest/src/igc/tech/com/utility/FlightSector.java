package igc.tech.com.utility;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "FlightSector")
public class FlightSector {

    private  String sectorCode;
    private  String sectorName;

    private List<FlightSector> sector;


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

    public List<FlightSector> getSector() {
        return sector;
    }

    @XmlElement(name = "Sector")
    public void setSector(List<FlightSector> sector) {
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