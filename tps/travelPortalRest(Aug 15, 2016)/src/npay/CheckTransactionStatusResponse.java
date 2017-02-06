
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
 *         &lt;element name="CheckTransactionStatusResult" type="{nPAY}TransactionStatus"/>
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
    "checkTransactionStatusResult"
})
@XmlRootElement(name = "CheckTransactionStatusResponse")
public class CheckTransactionStatusResponse {

    @XmlElement(name = "CheckTransactionStatusResult", required = true)
    protected TransactionStatus checkTransactionStatusResult;

    /**
     * Gets the value of the checkTransactionStatusResult property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionStatus }
     *     
     */
    public TransactionStatus getCheckTransactionStatusResult() {
        return checkTransactionStatusResult;
    }

    /**
     * Sets the value of the checkTransactionStatusResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionStatus }
     *     
     */
    public void setCheckTransactionStatusResult(TransactionStatus value) {
        this.checkTransactionStatusResult = value;
    }

}
