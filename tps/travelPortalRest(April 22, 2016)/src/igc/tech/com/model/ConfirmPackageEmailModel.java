package igc.tech.com.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConfirmPackageEmailModel {

    private PackageBookingModel packageBookingModel;
    private String bookingStatus;
    private String paymentType;
    private String paymentStatus;
    private String redirectLink;

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getRedirectLink() {
        return redirectLink;
    }

    public void setRedirectLink(String redirectLink) {
        this.redirectLink = redirectLink;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public PackageBookingModel getPackageBookingModel() {
        return packageBookingModel;
    }

    public void setPackageBookingModel(PackageBookingModel packageBookingModel) {
        this.packageBookingModel = packageBookingModel;
    }

    public String getEmailBody() {

        String html =
                "<html>"
                        + "<head>"
                        + "<meta charset=\"utf-8\">"
                        + "<title>IGC Companies and Groups</title>"
                        + "</head>"
                        + "<body>"
                        + "<div style=\"width: 580px; margin: 0 auto; font: 12px Arial, Helvetica, sans-serif; background: #fff\">"
                        + "<div style=\"margin: 0 0 10px\">"
                        + "</div>"


                        + "<div style=\"width:580px;margin:0 auto;font:12px Arial,Helvetica,sans-serif;background:#fff\">"
                        + "<div style=\"margin:0 0 10px\"> <img alt=\"SansuiTrek\" src=\"http://sansuitrek.com/img/logo.png\"> </div>"
                        + "<p>Dear " + packageBookingModel.getFirstName() +",</p>"
                        + "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"5\" border=\"0\">"
                        + "<tbody>"
                        + "<tr>"
                        + "<td style=\"border-bottom:1px solid #eee\">Reference Number:</td>"
                        + "<td style=\"border-bottom:1px solid #eee\"> "+packageBookingModel.getReferenceNo()+"</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<p> Your Request for Package booking ("+ packageBookingModel.getPackageName() +") has been accepted."
                        + " In order to confirm your booking please click the payment Link. <a href=\" "+this.redirectLink+"  \">"+this.redirectLink+"</a>'.'</p>"
                        + "</tr>"
                        + "</tbody>"
                        + "</table>"
                        + "</div>"


                        + "<h3 align=\"center\">Package Booking Details</h3><br>"
                        + "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"5\" border=\"0\">"

                        + "<tbody>"


                        + "<tr>"
                        + "<th style=\"background: #eee\" colspan=\"2\">Customer Details</th>"
                        + "</tr>"

                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Title</td>"
                        + "<td style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getCustomerTitle() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">First Name</td>"
                        + "<td style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getFirstName() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Middle Name</td>"
                        + "<td style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getMiddleName() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Last Name</td>"
                        + "<td style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getLastName() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Email Id</td>"
                        + "<td style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getEmail() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Contact No</td>"
                        + "<td style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getContactNo() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Passport Number</td>"
                        + "<td style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getPassportNo() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Customer Type</td>"
                        + "<td style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getCustomerType() + "</td>"
                        + "</tr>"

                        + "<tr>"
                        + "<th style=\"background: #eee\" colspan=\"2\">Package Details</th>"
                        + "</tr>"

                        + "<tr>"
                        + "<td width=\"28%\" style=\"border-bottom: 1px solid #eee\">Reference No</td>"
                        + "<td width=\"72%\" style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getReferenceNo() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td width=\"28%\" style=\"border-bottom: 1px solid #eee\">Package Name</td>"
                        + "<td width=\"72%\" style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getPackageName() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td width=\"28%\" style=\"border-bottom: 1px solid #eee\">Available Date</td>"
                        + "<td width=\"72%\" style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getAvailableDate() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td width=\"28%\" style=\"border-bottom: 1px solid #eee\">Total Days</td>"
                        + "<td width=\"72%\" style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getTotalDays() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Arrival Date</td>"
                        + "<td style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getArrivalDate() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Depart Date</td>"
                        + "<td style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getDepartDate() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">No of Person</td>"
                        + "<td style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getNoOfPerson() + "</td>"
                        + "</tr>"

                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Adult</td>"
                        + "<td style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getAdult() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Child</td>"
                        + "<td style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getChild() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Additional Info</td>"
                        + "<td style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getAdditionalInfo() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Referred By</td>"
                        + "<td style=\"border-bottom: 1px solid #eee\">" + packageBookingModel.getReferedBy() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Booking Status</td>"
                        + "<td style=\"border-bottom: 1px solid #eee\">" + this.bookingStatus + "</td>"
                        + "</tr>"


                        + "<tr>"
                        + "<th style=\"background: #eee\" colspan=\"2\">Payment Detail</th>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Package Cost</td>"
                        + "<td style=\"border-bottom: 1px solid #eee; color: #46216f; font-size: 14px\">  $" + new BigDecimal(packageBookingModel.getAmount()).setScale(2, RoundingMode.HALF_EVEN) + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Discount</td>"
                        + "<td style=\"border-bottom: 1px solid #eee; color: #46216f; font-size: 14px\">  <strong>$" + new BigDecimal(packageBookingModel.getDiscountAmount()).setScale(2, RoundingMode.HALF_EVEN) + "</strong></td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Amount to pay</td>"
                        + "<td style=\"border-bottom: 1px solid #eee; color: #46216f; font-size: 14px\"><strong>$" + new BigDecimal(packageBookingModel.getTotalAmount()).setScale(2, RoundingMode.HALF_EVEN) + "</strong></td>"
                        + "</tr>"

                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Payment Status</td>"
                        + "<td style=\"border-bottom: 1px solid #eee; color: #46216f; font-size: 14px\"><strong>" + this.paymentStatus + "</strong></td>"
                        + "</tr>"

                        + "<tr>"
                        + "<td style=\"border-bottom: 1px solid #eee\">Payment type</td>"
                        + "<td	style=\"border-bottom: 1px solid #eee; color: #46216f; font-size: 14px\"><strong>" + this.paymentType + "</strong></td>"
                        + "</tr>"
                        + "<tr><td colspan=\"2\">&nbsp;</td></tr>"
                        + "<tr>"
                        + "<td colspan=\"2\" style=\"background: #EEE; text-align: left;\">"
                        + "Regards,<br />"
                        + "TPS<br />"
                        + "IGC Pay Accounts Team<br /> "
                        + "</td>"
                        + "</tr>"

                        + "</tbody>"
                        + "</table>"
                        + "</div>"
                        + "</body>"
                        + "</html>";
        return html;
    }

}
