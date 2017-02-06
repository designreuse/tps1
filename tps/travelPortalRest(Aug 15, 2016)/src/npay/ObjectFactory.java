
package npay;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the npay package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TransactionStatus_QNAME = new QName("nPAY", "TransactionStatus");
    private final static QName _TxnResponse_QNAME = new QName("nPAY", "TxnResponse");
    private final static QName _AuthenticateMerchant_QNAME = new QName("nPAY", "AuthenticateMerchant");
    private final static QName _String_QNAME = new QName("nPAY", "string");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: npay
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckTransactionStatusResponse }
     * 
     */
    public CheckTransactionStatusResponse createCheckTransactionStatusResponse() {
        return new CheckTransactionStatusResponse();
    }

    /**
     * Create an instance of {@link TransactionStatus }
     * 
     */
    public TransactionStatus createTransactionStatus() {
        return new TransactionStatus();
    }

    /**
     * Create an instance of {@link QueryReportResponse }
     * 
     */
    public QueryReportResponse createQueryReportResponse() {
        return new QueryReportResponse();
    }

    /**
     * Create an instance of {@link QueryReport }
     * 
     */
    public QueryReport createQueryReport() {
        return new QueryReport();
    }

    /**
     * Create an instance of {@link TxnResponse }
     * 
     */
    public TxnResponse createTxnResponse() {
        return new TxnResponse();
    }

    /**
     * Create an instance of {@link ValidateMerchant }
     * 
     */
    public ValidateMerchant createValidateMerchant() {
        return new ValidateMerchant();
    }

    /**
     * Create an instance of {@link ValidateMerchantResponse }
     * 
     */
    public ValidateMerchantResponse createValidateMerchantResponse() {
        return new ValidateMerchantResponse();
    }

    /**
     * Create an instance of {@link AuthenticateMerchant }
     * 
     */
    public AuthenticateMerchant createAuthenticateMerchant() {
        return new AuthenticateMerchant();
    }

    /**
     * Create an instance of {@link CheckTransactionStatus }
     * 
     */
    public CheckTransactionStatus createCheckTransactionStatus() {
        return new CheckTransactionStatus();
    }

    /**
     * Create an instance of {@link DoTransaction }
     * 
     */
    public DoTransaction createDoTransaction() {
        return new DoTransaction();
    }

    /**
     * Create an instance of {@link DoTransactionResponse }
     * 
     */
    public DoTransactionResponse createDoTransactionResponse() {
        return new DoTransactionResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "nPAY", name = "TransactionStatus")
    public JAXBElement<TransactionStatus> createTransactionStatus(TransactionStatus value) {
        return new JAXBElement<TransactionStatus>(_TransactionStatus_QNAME, TransactionStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TxnResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "nPAY", name = "TxnResponse")
    public JAXBElement<TxnResponse> createTxnResponse(TxnResponse value) {
        return new JAXBElement<TxnResponse>(_TxnResponse_QNAME, TxnResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticateMerchant }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "nPAY", name = "AuthenticateMerchant")
    public JAXBElement<AuthenticateMerchant> createAuthenticateMerchant(AuthenticateMerchant value) {
        return new JAXBElement<AuthenticateMerchant>(_AuthenticateMerchant_QNAME, AuthenticateMerchant.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "nPAY", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

}
