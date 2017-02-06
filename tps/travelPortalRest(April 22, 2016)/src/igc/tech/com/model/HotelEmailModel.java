package igc.tech.com.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HotelEmailModel {

    private HotelBookingModel hotelBookingModel;
    private String bookingStatus;
    private String paymentType;
    private String paymentStatus;
    private  String redirectLink;

    private boolean bookingReq;
    private boolean bookingReqConf;

    private boolean paytReq;
    private boolean payReqConf;

    public String getRedirectLink() {
        return redirectLink;
    }

    public void setRedirectLink(String redirectLink) {
        this.redirectLink = redirectLink;
    }

    public boolean isBookingReq() {
        return bookingReq;
    }

    public void setBookingReq(boolean bookingReq) {
        this.bookingReq = bookingReq;
    }

    public boolean isPayReqConf() {
        return payReqConf;
    }

    public void setPayReqConf(boolean payReqConf) {
        this.payReqConf = payReqConf;
    }

    public boolean isPaytReq() {
        return paytReq;
    }

    public void setPaytReq(boolean paytReq) {
        this.paytReq = paytReq;
    }

    public boolean isBookingReqConf() {
        return bookingReqConf;
    }

    public void setBookingReqConf(boolean bookingReqConf) {
        this.bookingReqConf = bookingReqConf;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
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

    public HotelBookingModel getHotelBookingModel() {
        return hotelBookingModel;
    }

    public void setHotelBookingModel(HotelBookingModel hotelBookingModel) {
        this.hotelBookingModel = hotelBookingModel;
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
                        + "<div style=\"margin: 0 0 10px\">";

        if (bookingReq == true) {
            html = html + "<div style=\"width:580px;margin:0 auto;font:12px Arial,Helvetica,sans-serif;background:#fff\">"
                    + "<div style=\"margin:0 0 10px\"> <img alt=\"SansuiTrek\" src=\"http://sansuitrek.com/img/logo.png\"> </div>"
                    + "<p>Dear " + hotelBookingModel.getFirstName() + ",</p>"
                    + "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"5\" border=\"0\">"
                    + "<tbody>"
                    + "<tr>"
                    + "<td style=\"border-bottom:1px solid #eee\">Reference Number:</td>"
                    + "<td style=\"border-bottom:1px solid #eee\"> " + hotelBookingModel.getReferenceNo() + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<p> Your Request for Room booking (" + hotelBookingModel.getRoomDesc() + ") in Hotel ("+hotelBookingModel.getHotelName()+") has been accepted."
                    + " In order to confirm your booking please click the payment Link. <a href=\" " + this.redirectLink + "  \">" + this.redirectLink + "</a></p>"
                    + "</tr>"
                    + "</tbody>"
                    + "</table>"
                    + "</div>";
        }

        if (bookingReqConf == true) {
            html = html + "<div style=\"width:580px;margin:0 auto;font:12px Arial,Helvetica,sans-serif;background:#fff\">"
                    + "<div style=\"margin:0 0 10px\"> <img alt=\"SansuiTrek\" src=\"http://sansuitrek.com/img/logo.png\"> </div>"
                    + "<p>Dear " + hotelBookingModel.getFirstName() + ",</p>"
                    + "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"5\" border=\"0\">"
                    + "<tbody>"
                    + "<tr>"
                    + "<td style=\"border-bottom:1px solid #eee\">Reference Number:</td>"
                    + "<td style=\"border-bottom:1px solid #eee\"> " + hotelBookingModel.getReferenceNo() + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<p>Congratulation!!!  Your Request for Room booking (" + hotelBookingModel.getRoomDesc() + ") in Hotel ("+hotelBookingModel.getHotelName()+") has been Confirmed."
                    + " In order to proceed payment for  your booking please click the payment Link. <a href=\" "+this.redirectLink+"  \">"+this.redirectLink+"</a></p>"
                    + "</tr>"
                    + "</tbody>"
                    + "</table>"
                    + "</div>";
        }


        html = html + "</div>"
                + "<h3 align=\"center\">Hotel Booking Details</h3><br>"
                + "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"5\" border=\"0\">"

                + "<tbody>"

                + "<tr>"
                + "<th style=\"background: #eee\" colspan=\"2\">Customer Details</th>"
                + "</tr>"
                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">Title</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getCustomerTitle() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">First Name</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getFirstName() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">Middle Name</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getMiddleName() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">Last Name</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getLastName() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">Email Id</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getEmail() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">Contact No</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getContactNo() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">Passport Number</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getPassportNo() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">Country</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getCountryName() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">City</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getCity() + "</td>"
                + "</tr>"

                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">Postal Code</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getPostalCode() + "</td>"
                + "</tr>"

                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">Company</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getCompany() + "</td>"
                + "</tr>"

                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">License No</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getLicenseNo() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<th style=\"background: #eee\" colspan=\"2\">Hotel  Details</th>"
                + "</tr>"

                + "<tr>"
                + "<td width=\"28%\" style=\"border-bottom: 1px solid #eee\">Reference No</td>"
                + "<td width=\"72%\" style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getReferenceNo() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td width=\"28%\" style=\"border-bottom: 1px solid #eee\">Hotel Name</td>"
                + "<td width=\"72%\" style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getHotelName() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td width=\"28%\" style=\"border-bottom: 1px solid #eee\">Hotel Ph. No</td>"
                + "<td width=\"72%\" style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getHotelPhNo1() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td width=\"28%\" style=\"border-bottom: 1px solid #eee\">Hotel Address</td>"
                + "<td width=\"72%\" style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getHotelAddress() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">Hotel Email Id</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getHotelEmailId() + "</td>"
                + "</tr>"


                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">Room Type</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getRoomDesc() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">Adult</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getAdult() + "</td>"
                + "</tr>"

                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">Child</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getChild() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">Check In Date</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getCheckInDate() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">Check Out date</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getCheckOutDate() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">Airport Pick Up</td>"
                + "<td style=\"border-bottom: 1px solid #eee\">" + hotelBookingModel.getAirportPickUp() + "</td>"
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
                + "<td style=\"border-bottom: 1px solid #eee; color: #46216f; font-size: 14px\">  $" + new BigDecimal(hotelBookingModel.getAmount()).setScale(2, RoundingMode.HALF_EVEN) + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">Discount</td>"
                + "<td style=\"border-bottom: 1px solid #eee; color: #46216f; font-size: 14px\">  <strong>$" + new BigDecimal(hotelBookingModel.getDiscountAmount()).setScale(2, RoundingMode.HALF_EVEN) + "</strong></td>"
                + "</tr>"
                + "<tr>"
                + "<td style=\"border-bottom: 1px solid #eee\">Amount to pay</td>"
                + "<td style=\"border-bottom: 1px solid #eee; color: #46216f; font-size: 14px\"><strong>$" + new BigDecimal(hotelBookingModel.getTotalAmount()).setScale(2, RoundingMode.HALF_EVEN) + "</strong></td>"
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
