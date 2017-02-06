
package npay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="STATUS_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MESSAGE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MERCHANT_TRANSACTIONID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GTWREFNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROCESS_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TRANSACTION_STATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REMARKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CARDNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MERCHANT_DECS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TXN_DATE_TIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONCERNED_BANK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionStatus", propOrder = {
    "statuscode",
    "message",
    "merchanttransactionid",
    "gtwrefno",
    "processid",
    "transactionstatus",
    "remarks",
    "cardno",
    "amount",
    "merchantdecs",
    "txndatetime",
    "concernedbank"
})
public class TransactionStatus {

    @XmlElement(name = "STATUS_CODE")
    protected String statuscode;
    @XmlElement(name = "MESSAGE")
    protected String message;
    @XmlElement(name = "MERCHANT_TRANSACTIONID")
    protected String merchanttransactionid;
    @XmlElement(name = "GTWREFNO")
    protected String gtwrefno;
    @XmlElement(name = "PROCESS_ID")
    protected String processid;
    @XmlElement(name = "TRANSACTION_STATUS")
    protected String transactionstatus;
    @XmlElement(name = "REMARKS")
    protected String remarks;
    @XmlElement(name = "CARDNO")
    protected String cardno;
    @XmlElement(name = "AMOUNT")
    protected String amount;
    @XmlElement(name = "MERCHANT_DECS")
    protected String merchantdecs;
    @XmlElement(name = "TXN_DATE_TIME")
    protected String txndatetime;
    @XmlElement(name = "CONCERNED_BANK")
    protected String concernedbank;

    /**
     * Gets the value of the statuscode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTATUSCODE() {
        return statuscode;
    }

    /**
     * Sets the value of the statuscode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTATUSCODE(String value) {
        this.statuscode = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMESSAGE() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMESSAGE(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the merchanttransactionid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMERCHANTTRANSACTIONID() {
        return merchanttransactionid;
    }

    /**
     * Sets the value of the merchanttransactionid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMERCHANTTRANSACTIONID(String value) {
        this.merchanttransactionid = value;
    }

    /**
     * Gets the value of the gtwrefno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGTWREFNO() {
        return gtwrefno;
    }

    /**
     * Sets the value of the gtwrefno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGTWREFNO(String value) {
        this.gtwrefno = value;
    }

    /**
     * Gets the value of the processid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROCESSID() {
        return processid;
    }

    /**
     * Sets the value of the processid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROCESSID(String value) {
        this.processid = value;
    }

    /**
     * Gets the value of the transactionstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSACTIONSTATUS() {
        return transactionstatus;
    }

    /**
     * Sets the value of the transactionstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSACTIONSTATUS(String value) {
        this.transactionstatus = value;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREMARKS() {
        return remarks;
    }

    /**
     * Sets the value of the remarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREMARKS(String value) {
        this.remarks = value;
    }

    /**
     * Gets the value of the cardno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCARDNO() {
        return cardno;
    }

    /**
     * Sets the value of the cardno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCARDNO(String value) {
        this.cardno = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAMOUNT() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAMOUNT(String value) {
        this.amount = value;
    }

    /**
     * Gets the value of the merchantdecs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMERCHANTDECS() {
        return merchantdecs;
    }

    /**
     * Sets the value of the merchantdecs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMERCHANTDECS(String value) {
        this.merchantdecs = value;
    }

    /**
     * Gets the value of the txndatetime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTXNDATETIME() {
        return txndatetime;
    }

    /**
     * Sets the value of the txndatetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTXNDATETIME(String value) {
        this.txndatetime = value;
    }

    /**
     * Gets the value of the concernedbank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONCERNEDBANK() {
        return concernedbank;
    }

    /**
     * Sets the value of the concernedbank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONCERNEDBANK(String value) {
        this.concernedbank = value;
    }


    @Override
    public String toString() {
        return "TransactionStatus{" +
                "statuscode='" + statuscode + '\'' +
                ", message='" + message + '\'' +
                ", merchanttransactionid='" + merchanttransactionid + '\'' +
                ", gtwrefno='" + gtwrefno + '\'' +
                ", processid='" + processid + '\'' +
                ", transactionstatus='" + transactionstatus + '\'' +
                ", remarks='" + remarks + '\'' +
                ", cardno='" + cardno + '\'' +
                ", amount='" + amount + '\'' +
                ", merchantdecs='" + merchantdecs + '\'' +
                ", txndatetime='" + txndatetime + '\'' +
                ", concernedbank='" + concernedbank + '\'' +
                '}';
    }
}
