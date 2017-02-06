package igc.tech.com.mapper;

import igc.tech.com.model.PackageBookingModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PackageBookingMapper {

    @SuppressWarnings("rawtypes")
    public List<PackageBookingModel> mapList(List<Map> list) {

        List<PackageBookingModel> resultList = new ArrayList<>();

        PackageBookingModel packageCustModel;

        for (Map m : list) {
            packageCustModel = mapRow(m);
            resultList.add(packageCustModel);
        }

        // System.out.println("ffasdf");

        return resultList;
    }

    public PackageBookingModel mapRow(Map map) {

        PackageBookingModel packageCustModel = new PackageBookingModel();

        packageCustModel.setPackageBookingId(map.get("package_booking_id").toString());
        packageCustModel.setReferenceNo(map.get("reference_no").toString());
        packageCustModel.setAmount(map.get("amount").toString());
        packageCustModel.setDiscountAmount(map.get("discount_amount").toString());
        packageCustModel.setTotalAmount(map.get("total_amount").toString());
        packageCustModel.setArrivalDate(map.get("arrival_date").toString());
        packageCustModel.setDepartDate(map.get("depart_date").toString());
        packageCustModel.setNoOfPerson(map.get("no_of_person").toString());
        packageCustModel.setAdult(map.get("adult").toString());
        packageCustModel.setChild(map.get("child").toString());

        if (map.get("additional_info") != null) {
            packageCustModel.setAdditionalInfo(map.get("additional_info").toString());
        }

        packageCustModel.setReferedBy(map.get("refered_by").toString());
        if (map.get("hash_code") != null) {
            packageCustModel.setHashCode(map.get("hash_code").toString());
        }

        packageCustModel.setEmail(map.get("email").toString());
        packageCustModel.setCustomerTitle(map.get("customer_title").toString());
        packageCustModel.setFirstName(map.get("first_name").toString());

        if (map.get("middle_name") != null) {
            packageCustModel.setMiddleName(map.get("middle_name").toString());
        }

        packageCustModel.setLastName(map.get("last_name").toString());
        packageCustModel.setContactNo(map.get("contact_no").toString());
        packageCustModel.setPassportNo(map.get("passport_no").toString());
        packageCustModel.setCustomerType(map.get("customer_type").toString());
        packageCustModel.setAvailableDateRateId(map.get("available_date_rate_id").toString());
        packageCustModel.setCustomerDetailId(map.get("customer_detail_id").toString());
        packageCustModel.setAvailableDate(map.get("available_date").toString());
        packageCustModel.setRate(map.get("rate").toString());
        packageCustModel.setPackageName(map.get("package_name").toString());
        packageCustModel.setTotalDays(map.get("total_days").toString());


        return packageCustModel;
    }

/*
    public DayDetailModel mapRowSetNull(boolean dayDetailId,
                                        boolean packageName,
                                        boolean packageItineraryId,
                                        boolean day,
                                        boolean activityDetailId,
                                        boolean activityName,
                                        DayDetailModel dayDetailModel) {

        if (dayDetailId == true) {
            dayDetailModel.setDayDetailId(null);

        }
        if (packageName == true) {
            dayDetailModel.setPackageName(null);

        }
        if (packageItineraryId == true) {

            dayDetailModel.setPackageItineraryId(null);
        }
        if (day == true) {

            dayDetailModel.setDay(null);
        }
        if (activityDetailId == true) {

            dayDetailModel.setActivityDetailId(null);
        }

        if (activityName == true) {

            dayDetailModel.setActivityName(null);
        }


        return dayDetailModel;
    }*/
/*

    public List<DayDetailModel> mapListSetNull(boolean dayDetailId,
                                               boolean packageName,
                                               boolean packageItineraryId,
                                               boolean day,
                                               boolean activityDetailId,
                                               boolean activityName,
                                               List<DayDetailModel> dayDetailModels) {

        for (DayDetailModel dayDetailModel : dayDetailModels) {

            dayDetailModel = mapRowSetNull(dayDetailId, packageName, packageItineraryId, day, activityDetailId, activityName, dayDetailModel);

        }

        return dayDetailModels;
    }
*/

}
