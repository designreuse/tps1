
package org.us.booking;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetFlightDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFlightDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="strUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strFlightId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFlightDetail", propOrder = {
    "strUserId",
    "strFlightId"
})
public class GetFlightDetail {

    protected String strUserId;
    protected String strFlightId;

    /**
     * Gets the value of the strUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrUserId() {
        return strUserId;
    }

    /**
     * Sets the value of the strUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrUserId(String value) {
        this.strUserId = value;
    }

    /**
     * Gets the value of the strFlightId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrFlightId() {
        return strFlightId;
    }

    /**
     * Sets the value of the strFlightId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrFlightId(String value) {
        this.strFlightId = value;
    }

}
