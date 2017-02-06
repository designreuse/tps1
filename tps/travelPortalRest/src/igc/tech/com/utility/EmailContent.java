package igc.tech.com.utility;


import igc.tech.com.model.CustomerDetailModel;
import igc.tech.com.model.HotelBookingModel;
import igc.tech.com.model.HotelDetailModel;

public class EmailContent {




    public String confirmationEmail(HotelBookingModel hotelBookingModel){
        String emailContent= "\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\"/>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n" +
                "    <title>GO Nepal Travel Portal System</title>\n" +
                "   \n" +
                "</head>\n" +
                "<body class=\"inner-page\" id=\"home\" style=\" background-color: #F3F3F3; font-family: arial ;\">\n" +
                "<section class=\"inner-detail-container\">\n" +
                "    <div style=\" margin: 0 auto;\n" +
                "        width: 100%;\" class=\"container\">\n" +
                "        <div class=\"row\">\n" +
                "            <div style=\"margin: 0px auto; width: 100%;\" class=\"col-md-10\">\n" +
                "                <div style=\"background: rgb(255, 255, 255) none repeat scroll 0px 0px; border: 1px solid rgb(220, 220, 220); margin-bottom: 20px; padding: 15px; overflow: hidden;\" class=\"user-detail\">\n" +
                "                    <div class=\"row\">\n" +
                "                        <div style=\" float: left;\n" +
                "        overflow: hidden;\n" +
                "        width: 50%;\" class=\"col-md-6\">\n" +
                "\n" +
                "                            <h3>Booking Details</h3>\n" +
                "                            <span class=\"sectionborder\" style=\"display: block; height: 3px; margin: -7px 0px 8px; width: 61px; background: rgb(104, 25, 52) none repeat scroll 0px 0px;\"></span>\n" +
                "                        </div>\n" +
                "                        \n" +
                "                    </div>\n" +
                "                \n" +
                "                    <div class=\"row\">\n" +
                "                        <div style=\" float: left;\n" +
                "        overflow: hidden;\n" +
                "        width: 66.6667%;\" class=\"col-md-8\">\n" +
                "                            <div style=\"padding: 2px 0 10px;\" class=\"content-well\">\n" +
                "                                <div style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\" class=\"mybooking__headingLabel\">Booking ID</div>\n" +
                "                                <div style=\" color: rgba(0, 0, 0, 0.7);\n" +
                "        font-size: 16px; font-family: arial;\n" +
                "                font-weight: normal;\n" +
                "                letter-spacing: 0.3px;\n" +
                "                margin-bottom: 10px;\" class=\"mybooking__headingText\">"+hotelBookingModel.getInvoice()+"</div>\n" +
                "\n" +
                "                            </div>\n" +
                "                            <div class=\"content-well\" style=\"padding: 2px 0 10px;\">\n" +
                "\n" +
                "                                <div class=\"mybookingheaderhighlighted\" style=\" color: #681934;\n" +
                "        font-size: 17px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                letter-spacing: 0.3px;\n" +
                "                margin-bottom: 10px;\">"+hotelBookingModel.getRoomTypeDesc()+"</div>\n" +
                "                            </div>\n" +
                "                            <div class=\"content-well\" style=\"padding: 2px 0 10px;\">\n" +
                "                                <div class=\"mybooking__headingLabel\" style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\">Hotel Name</div>\n" +
                "                                <div class=\"mybooking__headingText\" style=\" color: rgba(0, 0, 0, 0.7);\n" +
                "        font-size: 16px; font-family: arial;\n" +
                "                font-weight: normal;\n" +
                "                letter-spacing: 0.3px;\n" +
                "                margin-bottom: 10px;\">"+hotelBookingModel.getHotelName()+"</div>\n" +
                "\n" +
                "                            </div>\n" +
                "                            <div class=\"content-well\" style=\"padding: 2px 0 10px;\">\n" +
                "                                <div class=\"mybooking__headingLabel\" style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\">Hotel Address</div>\n" +
                "                                <div class=\"mybooking__headingText\" style=\" color: rgba(0, 0, 0, 0.7);\n" +
                "        font-size: 16px; font-family: arial;\n" +
                "                font-weight: normal;\n" +
                "                letter-spacing: 0.3px;\n" +
                "                margin-bottom: 10px;\">Kantipath Marg, Lainchaur, Kathmandu Nepal</div>\n" +
                "                            </div>\n" +
                "                            <div class=\"content-well\" style=\"padding: 2px 0 10px;\">\n" +
                "                                <div class=\"mybooking__headingLabel\" style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\">Booked For</div>\n" +
                "                                <div class=\"mybookingheaderhighlighted\" style=\" color: #681934;\n" +
                "        font-size: 17px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                letter-spacing: 0.3px;\n" +
                "                margin-bottom: 10px;\">"+hotelBookingModel.getTotalDays()+" Nights, "+hotelBookingModel.getTotalGuest()+" Guest "+hotelBookingModel.getNoOfRooms()+" Rooms</div>\n" +
                "                            </div>\n" +
                "                            <div class=\"row\">\n" +
                "                                <div class=\"col-md-6\" style=\"width: 50%; float: left; display: block; overflow: hidden;\">\n" +
                "                                    <div style=\"padding: 2px 0 10px;\" class=\"content-well\">\n" +
                "                                        <div class=\"mybooking__headingLabel\" style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\">Check-In Date</div>\n" +
                "                                        <div class=\"mybooking__headingText\">09-Sept-2016 ("+hotelBookingModel.getCheckInTo()+")</div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                                <div style=\"width: 50%; float: left; display: block; overflow: hidden;\" class=\"col-md-6\">\n" +
                "                                    <div style=\"padding: 2px 0 10px;\" class=\"content-well\">\n" +
                "                                        <div style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\" class=\"mybooking__headingLabel\">Check-Out Date</div>\n" +
                "                                        <div class=\"mybooking__headingText\">14-Sept-2016 ("+hotelBookingModel.getCheckOutTo()+")</div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "\n" +
                "                            </div>\n" +
                "\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t <div class=\"content-well\" style=\"padding: 2px 0 10px;\">\n" +
                "                                <div class=\"mybooking__headingLabel\" style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\">Payment Status</div>\n" +
                "                                <div class=\"mybooking__headingText\" style=\" color: #681934; font-size: 17px;\n" +
                "\t\t\t\t\t\t\t\tfont-weight: normal; font-family: arial; \n" +
                "\t\t\t\t\t\t\t\tletter-spacing: 0.3px; margin-bottom: 10px;\">"+hotelBookingModel.getPaymentStatus()+"</div>\n" +
                "\n" +
                "                            </div>\n" +
                "\n" +
                "\n" +
                "                        </div>\n" +
                "                        <div style=\" overflow: hidden;\n" +
                "        width: 33.3333%;\" class=\"col-md-4\">\n" +
                "                            <img style=\"width: 100%; padding: 15px 0px 0px;\" class=\"img-responsive\" src=\" "+hotelBookingModel.getRoomImageUrl()+"\">\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"user-detail\" style=\"background: rgb(255, 255, 255) none repeat scroll 0px 0px; border: 1px solid rgb(220, 220, 220); margin-bottom: 20px; padding: 15px; overflow: hidden;\">\n" +
                "                    <div class=\"row\">\n" +
                "                        <div class=\"col-md-12\">\n" +
                "\n" +
                "                            <h3>Guest Details</h3>\n" +
                "                            <span style=\"display: block; height: 3px; margin: -7px 0px 8px; width: 61px; background: rgb(104, 25, 52) none repeat scroll 0px 0px;\" class=\"sectionborder\"></span>\n" +
                "                        </div>\n" +
                "\n" +
                "                    </div>\n" +
                "\n" +
                "                    <div class=\"row\">\n" +
                "                        <div class=\"col-md-12\">\n" +
                "\n" +
                "\n" +
                "                            <div class=\"row\">\n" +
                "                                <div class=\"col-md-4\">\n" +
                "                                    <div class=\"content-well\">\n" +
                "                                        <div class=\"mybooking__headingLabel\" style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\">Primary Guest</div>\n" +
                "                                        <div class=\"mybookingheaderhighlighted\" style=\" color: #681934;\n" +
                "        font-size: 17px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                letter-spacing: 0.3px;\n" +
                "                margin-bottom: 10px;\">"+hotelBookingModel.getGuestName()+"</div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                                <div class=\"col-md-3\">\n" +
                "                                    <div class=\"content-well\">\n" +
                "                                        <div class=\"mybooking__headingLabel\" style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\">Mobile Number</div>\n" +
                "                                        <div class=\"mybooking__headingText\" style=\" color: rgba(0, 0, 0, 0.7);\n" +
                "        font-size: 16px; font-family: arial;\n" +
                "                font-weight: normal;\n" +
                "                letter-spacing: 0.3px;\n" +
                "                margin-bottom: 10px;\">"+hotelBookingModel.getGuestPhNo()+"</div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                                <div class=\"col-md-5\">\n" +
                "                                    <div class=\"content-well\">\n" +
                "                                        <div class=\"mybooking__headingLabel\" style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\">Email ID</div>\n" +
                "                                        <div class=\"mybooking__headingText\" style=\" color: rgba(0, 0, 0, 0.7);\n" +
                "        font-size: 16px; font-family: arial;\n" +
                "                font-weight: normal;\n" +
                "                letter-spacing: 0.3px;\n" +
                "                margin-bottom: 10px;\">"+hotelBookingModel.getGuestEmailId()+"</div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "\n" +
                "                            </div>\n" +
                "\n" +
                "\n" +
                "                        </div>\n" +
                "\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "\n" +
                "\n" +
                "                <div class=\"user-detail\" style=\"background: rgb(255, 255, 255) none repeat scroll 0px 0px; border: 1px solid rgb(220, 220, 220); margin-bottom: 20px; padding: 15px; overflow: hidden;\">\n" +
                "                    <div class=\"row\">\n" +
                "                        <div class=\"col-md-12\">\n" +
                "                            <h3>Payment Summary </h3>\n" +
                "                            <span style=\"display: block; height: 3px; margin: -7px 0px 8px; width: 61px; background: rgb(104, 25, 52) none repeat scroll 0px 0px;\" class=\"sectionborder\"></span>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "\n" +
                "                    <div class=\"row\">\n" +
                "                        <div class=\"booking-details-container\">\n" +
                "                            <ul class=\"booking-details\" style=\"list-style: outside none none; padding: 0px; overflow: hidden;\">\n" +
                "                                <li style=\"margin-bottom: 6px; border-bottom: 1px solid #d1d1d1;color: #585855;padding: 10px 0;\">\n" +
                "            <span style=\"width: 400px; display: inline-block;\">\n" +
                "                 "+hotelBookingModel.getCurrencyDesc()+" "+hotelBookingModel.getPerRate()+" X "+hotelBookingModel.getTotalDays()+" Nights\n" +
                "            </span>\n" +
                "\n" +
                "                                    <span class=\"pull-right\" style=\"float: right;\">\n" +
                "                "+hotelBookingModel.getCurrencyDesc()+" "+hotelBookingModel.getFinalRate()+"\n" +
                "            </span>\n" +
                "                                </li>\n" +
                "                                <li style=\"margin-bottom: 6px; border-bottom: 1px solid #d1d1d1;color: #585855;padding: 10px 0;\">\n" +
                "            <span style=\"width: 400px; display: inline-block;\">\n" +
                "                <strong>Total</strong>\n" +
                "            </span>\n" +
                "\n" +
                "                                    <span class=\"pull-right\" style=\"float: right;\">\n" +
                "                <strong>"+hotelBookingModel.getCurrencyDesc()+" "+hotelBookingModel.getFinalRate()+"</strong>\n" +
                "            </span>\n" +
                "                                </li>\n" +
                "                            </ul>\n" +
                "\n" +
                "\n" +
                "                        </div>\n" +
                "\n" +
                "                    </div>\n" +
                "                  \n" +
                "                </div>\n" +
                "\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</section>\n" +
                "\n" +
                "</body>\n" +
                "</html>";



        return  emailContent;
    }


    public String cancelBooking(HotelBookingModel hotelBookingModel){
        String emailContent= "\n" +
                "Dear "+hotelBookingModel.getGuestName()+",<br>\n" +
                "\n" +
                "We can confirm that your reservation at "+hotelBookingModel.getHotelName()+" has been cancelled. <br> " +
                "Your cancelled Booking Detail is given below.<br><br>"+
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\"/>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n" +
                "    <title>GO Nepal Travel Portal System</title>\n" +
                "   \n" +
                "</head>\n" +
                "<body class=\"inner-page\" id=\"home\" style=\" background-color: #F3F3F3; font-family: arial ;\">\n" +
                "<section class=\"inner-detail-container\">\n" +
                "    <div style=\" margin: 0 auto;\n" +
                "        width: 100%;\" class=\"container\">\n" +
                "        <div class=\"row\">\n" +
                "            <div style=\"margin: 0px auto; width: 100%;\" class=\"col-md-10\">\n" +
                "                <div style=\"background: rgb(255, 255, 255) none repeat scroll 0px 0px; border: 1px solid rgb(220, 220, 220); margin-bottom: 20px; padding: 15px; overflow: hidden;\" class=\"user-detail\">\n" +
                "                    <div class=\"row\">\n" +
                "                        <div style=\" float: left;\n" +
                "        overflow: hidden;\n" +
                "        width: 50%;\" class=\"col-md-6\">\n" +
                "\n" +
                "                            <h3>Booking Details</h3>\n" +
                "                            <span class=\"sectionborder\" style=\"display: block; height: 3px; margin: -7px 0px 8px; width: 61px; background: rgb(104, 25, 52) none repeat scroll 0px 0px;\"></span>\n" +
                "                        </div>\n" +
                "                        \n" +
                "                    </div>\n" +
                "                \n" +
                "                    <div class=\"row\">\n" +
                "                        <div style=\" float: left;\n" +
                "        overflow: hidden;\n" +
                "        width: 66.6667%;\" class=\"col-md-8\">\n" +
                "                            <div style=\"padding: 2px 0 10px;\" class=\"content-well\">\n" +
                "                                <div style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\" class=\"mybooking__headingLabel\">Booking ID</div>\n" +
                "                                <div style=\" color: rgba(0, 0, 0, 0.7);\n" +
                "        font-size: 16px; font-family: arial;\n" +
                "                font-weight: normal;\n" +
                "                letter-spacing: 0.3px;\n" +
                "                margin-bottom: 10px;\" class=\"mybooking__headingText\">"+hotelBookingModel.getInvoice()+"</div>\n" +
                "\n" +
                "                            </div>\n" +
                "                            <div class=\"content-well\" style=\"padding: 2px 0 10px;\">\n" +
                "\n" +
                "                                <div class=\"mybookingheaderhighlighted\" style=\" color: #681934;\n" +
                "        font-size: 17px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                letter-spacing: 0.3px;\n" +
                "                margin-bottom: 10px;\">"+hotelBookingModel.getRoomTypeDesc()+"</div>\n" +
                "                            </div>\n" +
                "                            <div class=\"content-well\" style=\"padding: 2px 0 10px;\">\n" +
                "                                <div class=\"mybooking__headingLabel\" style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\">Hotel Name</div>\n" +
                "                                <div class=\"mybooking__headingText\" style=\" color: rgba(0, 0, 0, 0.7);\n" +
                "        font-size: 16px; font-family: arial;\n" +
                "                font-weight: normal;\n" +
                "                letter-spacing: 0.3px;\n" +
                "                margin-bottom: 10px;\">"+hotelBookingModel.getHotelName()+"</div>\n" +
                "\n" +
                "                            </div>\n" +
                "                            <div class=\"content-well\" style=\"padding: 2px 0 10px;\">\n" +
                "                                <div class=\"mybooking__headingLabel\" style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\">Hotel Address</div>\n" +
                "                                <div class=\"mybooking__headingText\" style=\" color: rgba(0, 0, 0, 0.7);\n" +
                "        font-size: 16px; font-family: arial;\n" +
                "                font-weight: normal;\n" +
                "                letter-spacing: 0.3px;\n" +
                "                margin-bottom: 10px;\">Kantipath Marg, Lainchaur, Kathmandu Nepal</div>\n" +
                "                            </div>\n" +
                "                            <div class=\"content-well\" style=\"padding: 2px 0 10px;\">\n" +
                "                                <div class=\"mybooking__headingLabel\" style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\">Booked For</div>\n" +
                "                                <div class=\"mybookingheaderhighlighted\" style=\" color: #681934;\n" +
                "        font-size: 17px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                letter-spacing: 0.3px;\n" +
                "                margin-bottom: 10px;\">"+hotelBookingModel.getTotalDays()+" Nights, "+hotelBookingModel.getTotalGuest()+" Guest "+hotelBookingModel.getNoOfRooms()+" Rooms</div>\n" +
                "                            </div>\n" +
                "                            <div class=\"row\">\n" +
                "                                <div class=\"col-md-6\" style=\"width: 50%; float: left; display: block; overflow: hidden;\">\n" +
                "                                    <div style=\"padding: 2px 0 10px;\" class=\"content-well\">\n" +
                "                                        <div class=\"mybooking__headingLabel\" style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\">Check-In Date</div>\n" +
                "                                        <div class=\"mybooking__headingText\">09-Sept-2016 ("+hotelBookingModel.getCheckInTo()+")</div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                                <div style=\"width: 50%; float: left; display: block; overflow: hidden;\" class=\"col-md-6\">\n" +
                "                                    <div style=\"padding: 2px 0 10px;\" class=\"content-well\">\n" +
                "                                        <div style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\" class=\"mybooking__headingLabel\">Check-Out Date</div>\n" +
                "                                        <div class=\"mybooking__headingText\">14-Sept-2016 ("+hotelBookingModel.getCheckOutTo()+")</div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "\n" +
                "                            </div>\n" +
                "\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t <div class=\"content-well\" style=\"padding: 2px 0 10px;\">\n" +
                "                                <div class=\"mybooking__headingLabel\" style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\">Payment Status</div>\n" +
                "                                <div class=\"mybooking__headingText\" style=\" color: #681934; font-size: 17px;\n" +
                "\t\t\t\t\t\t\t\tfont-weight: normal; font-family: arial; \n" +
                "\t\t\t\t\t\t\t\tletter-spacing: 0.3px; margin-bottom: 10px;\">"+hotelBookingModel.getPaymentStatus()+"</div>\n" +
                "\n" +
                "                            </div>\n" +
                "\n" +
                "\n" +
                "                        </div>\n" +
                "                        <div style=\" overflow: hidden;\n" +
                "        width: 33.3333%;\" class=\"col-md-4\">\n" +
                "                            <img style=\"width: 100%; padding: 15px 0px 0px;\" class=\"img-responsive\" src=\" "+hotelBookingModel.getRoomImageUrl()+"\">\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"user-detail\" style=\"background: rgb(255, 255, 255) none repeat scroll 0px 0px; border: 1px solid rgb(220, 220, 220); margin-bottom: 20px; padding: 15px; overflow: hidden;\">\n" +
                "                    <div class=\"row\">\n" +
                "                        <div class=\"col-md-12\">\n" +
                "\n" +
                "                            <h3>Guest Details</h3>\n" +
                "                            <span style=\"display: block; height: 3px; margin: -7px 0px 8px; width: 61px; background: rgb(104, 25, 52) none repeat scroll 0px 0px;\" class=\"sectionborder\"></span>\n" +
                "                        </div>\n" +
                "\n" +
                "                    </div>\n" +
                "\n" +
                "                    <div class=\"row\">\n" +
                "                        <div class=\"col-md-12\">\n" +
                "\n" +
                "\n" +
                "                            <div class=\"row\">\n" +
                "                                <div class=\"col-md-4\">\n" +
                "                                    <div class=\"content-well\">\n" +
                "                                        <div class=\"mybooking__headingLabel\" style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\">Primary Guest</div>\n" +
                "                                        <div class=\"mybookingheaderhighlighted\" style=\" color: #681934;\n" +
                "        font-size: 17px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                letter-spacing: 0.3px;\n" +
                "                margin-bottom: 10px;\">"+hotelBookingModel.getGuestName()+"</div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                                <div class=\"col-md-3\">\n" +
                "                                    <div class=\"content-well\">\n" +
                "                                        <div class=\"mybooking__headingLabel\" style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\">Mobile Number</div>\n" +
                "                                        <div class=\"mybooking__headingText\" style=\" color: rgba(0, 0, 0, 0.7);\n" +
                "        font-size: 16px; font-family: arial;\n" +
                "                font-weight: normal;\n" +
                "                letter-spacing: 0.3px;\n" +
                "                margin-bottom: 10px;\">"+hotelBookingModel.getGuestPhNo()+"</div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                                <div class=\"col-md-5\">\n" +
                "                                    <div class=\"content-well\">\n" +
                "                                        <div class=\"mybooking__headingLabel\" style=\"color: rgba(0, 0, 0, 0.5);\n" +
                "        font-size: 12px;\n" +
                "        font-weight: normal; font-family: arial;\n" +
                "                margin-bottom: 3px;\">Email ID</div>\n" +
                "                                        <div class=\"mybooking__headingText\" style=\" color: rgba(0, 0, 0, 0.7);\n" +
                "        font-size: 16px; font-family: arial;\n" +
                "                font-weight: normal;\n" +
                "                letter-spacing: 0.3px;\n" +
                "                margin-bottom: 10px;\">"+hotelBookingModel.getGuestEmailId()+"</div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "\n" +
                "                            </div>\n" +
                "\n" +
                "\n" +
                "                        </div>\n" +
                "\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "\n" +
                "\n" +
                "                <div class=\"user-detail\" style=\"background: rgb(255, 255, 255) none repeat scroll 0px 0px; border: 1px solid rgb(220, 220, 220); margin-bottom: 20px; padding: 15px; overflow: hidden;\">\n" +
                "                    <div class=\"row\">\n" +
                "                        <div class=\"col-md-12\">\n" +
                "                            <h3>Payment Summary </h3>\n" +
                "                            <span style=\"display: block; height: 3px; margin: -7px 0px 8px; width: 61px; background: rgb(104, 25, 52) none repeat scroll 0px 0px;\" class=\"sectionborder\"></span>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "\n" +
                "                    <div class=\"row\">\n" +
                "                        <div class=\"booking-details-container\">\n" +
                "                            <ul class=\"booking-details\" style=\"list-style: outside none none; padding: 0px; overflow: hidden;\">\n" +
                "                                <li style=\"margin-bottom: 6px; border-bottom: 1px solid #d1d1d1;color: #585855;padding: 10px 0;\">\n" +
                "            <span style=\"width: 400px; display: inline-block;\">\n" +
                "                 NRs."+hotelBookingModel.getPerRate()+" X "+hotelBookingModel.getTotalDays()+" Nights\n" +
                "            </span>\n" +
                "\n" +
                "                                    <span class=\"pull-right\" style=\"float: right;\">\n" +
                "                NRs."+hotelBookingModel.getFinalRate()+"\n" +
                "            </span>\n" +
                "                                </li>\n" +
                "                                <li style=\"margin-bottom: 6px; border-bottom: 1px solid #d1d1d1;color: #585855;padding: 10px 0;\">\n" +
                "            <span style=\"width: 400px; display: inline-block;\">\n" +
                "                <strong>Total</strong>\n" +
                "            </span>\n" +
                "\n" +
                "                                    <span class=\"pull-right\" style=\"float: right;\">\n" +
                "                <strong>NRs."+hotelBookingModel.getFinalRate()+"</strong>\n" +
                "            </span>\n" +
                "                                </li>\n" +
                "                            </ul>\n" +
                "\n" +
                "\n" +
                "                        </div>\n" +
                "\n" +
                "                    </div>\n" +
                "                  \n" +
                "                </div>\n" +
                "\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</section>\n" +
                "\n" +
                "</body>\n" +
                "</html>";



        return  emailContent;
    }

    // tps front end

    public String customerRegistration(CustomerDetailModel customerDetailModel){
        String emailContent = "Dear " + customerDetailModel.getName() + ",<br>" +
                "Welcome to  TPS.<br>" +
                "To continue signup, please click the below url.<br>" +
                "<a href='"+customerDetailModel.getTpsFrontEndUrl()+"/Register/verify-email?token=" + customerDetailModel.getActivationCode() + "&email="+customerDetailModel.getEmail()+"'>Complete Sign up process.</a><br>" +
                "Registration is completely free. Plus, you can manage your property and bookings with our easy-to-use Extranet. Our dedicated support team is available around the clock – just in case.<br>" +
                "The sooner you complete your registration, the sooner your property can work for you!<br>" +
                "Kind regards,<br>" +
                "The TPS Team";

        return  emailContent;
    }

    // *******  tps front end

    // tps client
    public String registrationStartUp(HotelDetailModel hotelDetailModel){
        String emailContent = "Dear " + hotelDetailModel.getHotelName() + ",<br>" +
                "Congratulations on starting the registration process with TPS.<br>" +
                "Before you can appear online and bookable, we still need some details about your property.<br>" +
                "<a href='"+hotelDetailModel.getTpsClientUrl()+"/register/hotelDetail/" + hotelDetailModel.getToken() + "'>Complete your property registration now.</a><br>" +
                "Registration is completely free. Plus, you can manage your property and bookings with our easy-to-use Extranet. Our dedicated support team is available around the clock – just in case.<br>" +
                "The sooner you complete your registration, the sooner your property can work for you!<br>" +
                "Kind regards,<br>" +
                "The TPS Team";

        return  emailContent;
    }

    public String clientAccess(HotelDetailModel hotelDetailModel){
        String emailContent = "Dear " + hotelDetailModel.getHotelName() + ",<br>" +
                "Congratulations, your information is validated.<br>" +
                "Your Login Detail is:<br>" +
                "username:"+hotelDetailModel.getUserName()+"<br>" +
                "password:"+12345+
                "<br><a href='"+hotelDetailModel.getTpsClientUrl() + "'>View Account.</a><br>" +

                "Kind regards,<br>" +
                "The TPS Team";

        return  emailContent;
    }


    public String registrationComplete(HotelDetailModel hotelDetailModel){
        String emailContent = "Dear " + hotelDetailModel.getHotelName() + ",<br>" +
                "Congratulations, your registration for Hotel is Completed.<br>" +
                "We will let you inform after verification of your Property" +

                "Kind regards,<br>" +
                "The TPS Team";

        return  emailContent;
    }

    public String pushDisapprove(HotelDetailModel hotelDetailModel){
        String emailContent = "Dear " + hotelDetailModel.getHotelName() + ",<br>" +
                "Update for the Hotel Inventory cann't be performed due to following reason  .<br>" +
                "Remarks  <br>" +

                "Kind regards,<br>" +
                "The TPS Team";

        return  emailContent;
    }


    public String pushApprove(HotelDetailModel hotelDetailModel){
        String emailContent = "Dear " + hotelDetailModel.getHotelName() + ",<br>" +
                "Congratulations, Update for your Hotel Inventory has approved.<br>" +
                "Please check the main site to confirm updated information.<br>" +


                "Kind regards,<br>" +
                "The TPS Team";

        return  emailContent;
    }



    // ****** tps client

    public static void main(String[] args) {

        System.out.println(new EmailContent().confirmationEmail(new HotelBookingModel()));
    }




}
