
package npay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProcessId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantTxnId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DescriptionMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CardDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "processId",
    "merchantId",
    "merchantTxnId",
    "merchantUserName",
    "payAmt",
    "descriptionMsg",
    "cardDetails"
})
@XmlRootElement(name = "DoTransaction")
public class DoTransaction {

    @XmlElement(name = "ProcessId")
    protected String processId;
    @XmlElement(name = "MerchantId")
    protected String merchantId;
    @XmlElement(name = "MerchantTxnId")
    protected String merchantTxnId;
    @XmlElement(name = "MerchantUserName")
    protected String merchantUserName;
    @XmlElement(name = "PayAmt")
    protected String payAmt;
    @XmlElement(name = "DescriptionMsg")
    protected String descriptionMsg;
    @XmlElement(name = "CardDetails")
    protected String cardDetails;

    /**
     * Gets the value of the processId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessId() {
        return processId;
    }

    /**
     * Sets the value of the processId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessId(String value) {
        this.processId = value;
    }

    /**
     * Gets the value of the merchantId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Sets the value of the merchantId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantId(String value) {
        this.merchantId = value;
    }

    /**
     * Gets the value of the merchantTxnId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantTxnId() {
        return merchantTxnId;
    }

    /**
     * Sets the value of the merchantTxnId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantTxnId(String value) {
        this.merchantTxnId = value;
    }

    /**
     * Gets the value of the merchantUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantUserName() {
        return merchantUserName;
    }

    /**
     * Sets the value of the merchantUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantUserName(String value) {
        this.merchantUserName = value;
    }

    /**
     * Gets the value of the payAmt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayAmt() {
        return payAmt;
    }

    /**
     * Sets the value of the payAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayAmt(String value) {
        this.payAmt = value;
    }

    /**
     * Gets the value of the descriptionMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescriptionMsg() {
        return descriptionMsg;
    }

    /**
     * Sets the value of the descriptionMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescriptionMsg(String value) {
        this.descriptionMsg = value;
    }

    /**
     * Gets the value of the cardDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardDetails() {
        return cardDetails;
    }

    /**
     * Sets the value of the cardDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardDetails(String value) {
        this.cardDetails = value;
    }

}
