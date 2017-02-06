
package org.us.booking;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CheckBalance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckBalance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="strUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "CheckBalance", propOrder = {
    "strUserId",
    "strAirlineId"
})
public class CheckBalance {

    protected String strUserId;
    protected String strAirlineId;

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
