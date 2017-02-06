
package org.us.booking;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Refund complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Refund">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="strTicketNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strAirlineId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Refund", propOrder = {
    "strTicketNo",
    "strAirlineId"
})
public class Refund {

    protected String strTicketNo;
    protected String strAirlineId;

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
     * Gets the value of the strAirlineId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrAirlineId() {
        return strAirlineId;
    }

    /**
     * Sets the value of the strAirlineId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrAirlineId(String value) {
        this.strAirlineId = value;
    }

}
