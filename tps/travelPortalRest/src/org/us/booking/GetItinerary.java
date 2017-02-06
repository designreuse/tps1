
package org.us.booking;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetItinerary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetItinerary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="strPnoNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strTicketNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strAgencyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetItinerary", propOrder = {
    "strPnoNo",
    "strTicketNo",
    "strAgencyId"
})
public class GetItinerary {

    protected String strPnoNo;
    protected String strTicketNo;
    protected String strAgencyId;

    /**
     * Gets the value of the strPnoNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrPnoNo() {
        return strPnoNo;
    }

    /**
     * Sets the value of the strPnoNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrPnoNo(String value) {
        this.strPnoNo = value;
    }

    /**
     * Gets the value of the strTicketNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrTicketNo() {
        return strTicketNo;
    }

    /**
     * Sets the value of the strTicketNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrTicketNo(String value) {
        this.strTicketNo = value;
    }

    /**
     * Gets the value of the strAgencyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrAgencyId() {
        return strAgencyId;
    }

    /**
     * Sets the value of the strAgencyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrAgencyId(String value) {
        this.strAgencyId = value;
    }

}
