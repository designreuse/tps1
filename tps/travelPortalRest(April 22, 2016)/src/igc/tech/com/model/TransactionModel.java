package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class TransactionModel {

	private  CustomerDetailModel customerDetail;
	private  PackageBookingModel packageBooking;

	private  HotelBookingModel hotelBooking;

	public PackageBookingModel getPackageBooking() {
		return packageBooking;
	}

	public void setPackageBooking(PackageBookingModel packageBooking) {
		this.packageBooking = packageBooking;
	}

	public CustomerDetailModel getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(CustomerDetailModel customerDetail) {
		this.customerDetail = customerDetail;
	}

	public HotelBookingModel getHotelBooking() {
		return hotelBooking;
	}

	public void setHotelBooking(HotelBookingModel hotelBooking) {
		this.hotelBooking = hotelBooking;
	}
}
