package igc.tech.com.resource;

import igc.tech.com.dao.*;
import igc.tech.com.mapper.*;
import igc.tech.com.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Path("/packageSearch")
public class PackageSearchResource {

    @Autowired
    PackageSearchDao packageSearchDao;

    @Autowired
    AvailableDateRateDao availableDateRateDao;

    @Autowired
    PackageItineraryDao packageItineraryDao;

    @Autowired
    PackageLocationDao packageLocationDao;

    @Autowired
    DayDetailDao dayDetailDao;

    @Autowired
    PackageInfoDao packageInfoDao;
    ///


    ErrorMessage errorMessage;


    @Path("/location/{location}/availableMonth/{availableMonth}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByLocationAndAvailableMonth(@PathParam("location") String location,
                                                   @PathParam("availableMonth") String availableMonth) {

        /*packageinfo list*/

        List<PackageInfoModel> packageInfoModels = new PackageInfoMapper().mapList(packageSearchDao.procPackageSearch(location, availableMonth, "e"));

        for (PackageInfoModel packageInfoModel : packageInfoModels) {

            /*setting available date rate into packageInfo*/
            List<AvailableDateRateModel> availableDateRateModels = new AvailableDateRateMappper().
                    mapList(availableDateRateDao.procAvailableDateRate(null, null, packageInfoModel.getPackageInfoId(), null, null, "e"));


            packageInfoModel.setAvailableDateRates(new AvailableDateRateMappper().mapListSetNull(false,false,true,true,false,availableDateRateModels));

            /*end setting available date rate into packageInfo*/

            /*setting package Itinerary into packageInfo*/
            List<PackageItineraryModel> packageItineraryModels = new PackageItineraryMapper().
                    mapList(packageItineraryDao.procPackageItinerary(null, packageInfoModel.getPackageInfoId(), null, null, null, null, "s"));

            packageInfoModel.setPackageItineraries(new PackageItineraryMapper().mapListSetNull(false,true,true,false,false,false,false,packageItineraryModels));

            for (PackageItineraryModel packageItineraryModel : packageItineraryModels) {

              /* setting package location into PackageItineraryModel*/
                List<PackageLocationModel> packageLocationModels = new PackageLocationMappper().
                        mapList(packageLocationDao.procPackageLocation(null, packageItineraryModel.getPackageItineraryId(), null, null, "s"));

                packageLocationModels=new PackageLocationMappper().mapListSetNull(false,true,true,true,false,false,false,false,packageLocationModels);


                packageItineraryModel.setPackageLocations(packageLocationModels);

                /* end setting package location into PackageItineraryModel*/

                /* setting day detail into PackageItineraryModel*/

                List<DayDetailModel> dayDetailModels = new DayDetailMapper().
                        mapList(dayDetailDao.procDayDetail(null, packageItineraryModel.getPackageItineraryId(), null, null, "s"));

                packageItineraryModel.setDayDetailActivities(new DayDetailMapper().mapListSetNull(false,true,true,true,false,false,dayDetailModels));

                /*end setting day detail into PackageItineraryModel*/

            }

        }

        return Response.status(Status.OK).entity(packageInfoModels)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/packageInfo/{packageInfoId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByPackageInfo(@PathParam("packageInfoId") String packageInfoId) {

        PackageInfoModel packageInfoModel = new PackageInfoMapper().mapRow((Map) packageInfoDao.procPackageInfo(packageInfoId, null, null, null, null,null, null, null, "s").get(0));


       /* setting available date rate into PackageInfoModel*/
        List<AvailableDateRateModel> availableDateRateModels = new AvailableDateRateMappper().
                mapList(availableDateRateDao.procAvailableDateRate(null, null, packageInfoModel.getPackageInfoId(), null, null, "e"));

        packageInfoModel.setAvailableDateRates(new AvailableDateRateMappper().mapListSetNull(false,false,true,true,false,availableDateRateModels));

        /* end setting available date rate into PackageInfoModel*/

        /* setting PackageItinerary  into PackageInfoModel*/
        List<PackageItineraryModel> packageItineraryModels = new PackageItineraryMapper().
                mapList(packageItineraryDao.procPackageItinerary(null, packageInfoModel.getPackageInfoId(), null, null, null, null, "s"));

        packageInfoModel.setPackageItineraries(new PackageItineraryMapper().mapListSetNull(false,true,true,false,false,false,false,packageItineraryModels));

        for (PackageItineraryModel packageItineraryModel : packageItineraryModels) {

            /* setting Package Location into PackageInfoModel*/
            List<PackageLocationModel> packageLocationModels = new PackageLocationMappper().
                    mapList(packageLocationDao.procPackageLocation(null, packageItineraryModel.getPackageItineraryId(), null, null, "s"));

            packageItineraryModel.setPackageLocations(new PackageLocationMappper().mapListSetNull(false,true,true,true,false,false,false,false,packageLocationModels));

            /*end setting Package Location into PackageInfoModel*/

            /* setting Day Detail  into PackageInfoModel*/

            List<DayDetailModel> dayDetailModels = new DayDetailMapper().
                    mapList(dayDetailDao.procDayDetail(null, packageItineraryModel.getPackageItineraryId(), null, null, "s"));

            packageItineraryModel.setDayDetailActivities(new DayDetailMapper().mapListSetNull(false,true,true,true,false,false,dayDetailModels));

             /* end setting Day Detail  into PackageInfoModel*/

        }

        return Response.status(Status.OK).entity(packageInfoModel)
                .type(MediaType.APPLICATION_JSON).build();

    }


}
