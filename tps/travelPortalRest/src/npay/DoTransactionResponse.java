
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
 *         &lt;element name="DoTransactionResult" type="{nPAY}TxnResponse"/>
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
    "doTransactionResult"
})
@XmlRootElement(name = "DoTransactionResponse")
public class DoTransactionResponse {

    @XmlElement(name = "DoTransactionResult", required = true)
    protected TxnResponse doTransactionResult;

    /**
     * Gets the value of the doTransactionResult property.
     * 
     * @return
     *     possible object is
     *     {@link TxnResponse }
     *     
     */
    public TxnResponse getDoTransactionResult() {
        return doTransactionResult;
    }

    /**
     * Sets the value of the doTransactionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TxnResponse }
     *     
     */
    public void setDoTransactionResult(TxnResponse value) {
        this.doTransactionResult = value;
    }

}
