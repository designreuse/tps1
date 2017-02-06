
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
 *         &lt;element name="ValidateMerchantResult" type="{nPAY}AuthenticateMerchant"/>
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
    "validateMerchantResult"
})
@XmlRootElement(name = "ValidateMerchantResponse")
public class ValidateMerchantResponse {

    @XmlElement(name = "ValidateMerchantResult", required = true)
    protected AuthenticateMerchant validateMerchantResult;

    /**
     * Gets the value of the validateMerchantResult property.
     * 
     * @return
     *     possible object is
     *     {@link AuthenticateMerchant }
     *     
     */
    public AuthenticateMerchant getValidateMerchantResult() {
        return validateMerchantResult;
    }

    /**
     * Sets the value of the validateMerchantResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthenticateMerchant }
     *     
     */
    public void setValidateMerchantResult(AuthenticateMerchant value) {
        this.validateMerchantResult = value;
    }

}
