package igc.tech.com.resource;

import igc.tech.com.dao.DayDetailDao;
import igc.tech.com.dao.PackageInfoDao;
import igc.tech.com.dao.PackageItineraryDao;
import igc.tech.com.exception.NoContentException;
import igc.tech.com.mapper.DayDetailMapper;
import igc.tech.com.mapper.PackageInfoMapper;
import igc.tech.com.mapper.PackageItineraryMapper;
import igc.tech.com.model.*;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/dayDetail")
public class DayDetailResource {

    @Autowired
    DayDetailDao dayDetailDao;

    @Autowired
    PackageInfoDao packageInfoDao;

    @Autowired
    PackageItineraryDao packageItineraryDao;

    ErrorMessage errorMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        List<DayDetailModel> dayDetailModels = new DayDetailMapper().mapList(dayDetailDao.
                procDayDetail(null, null, null, null, "a"));

        if (dayDetailModels.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        return Response.status(Status.OK).entity(dayDetailModels)
                .type(MediaType.APPLICATION_JSON).build();
    }

    @Path("/packageInfo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByPackageInfo() {

        List<PackageInfoModel> packageInfoModels = new PackageInfoMapper().mapList(packageInfoDao.
                procPackageInfo(null, null, null, null, null, null, null,null, "f"));

        if (packageInfoModels.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        for (PackageInfoModel packageInfoModel : packageInfoModels) {
            List<PackageItineraryModel> packageItineraryModels = new PackageItineraryMapper().mapList(packageItineraryDao.
                    procPackageItinerary(null, packageInfoModel.getPackageInfoId(), null, null, null, null, "b"));
            packageInfoModel.setPackageItineraries(new PackageItineraryMapper().mapListSetNull(false, true, true, false, false, false, false, packageItineraryModels));

            for (PackageItineraryModel packageItineraryModel : packageItineraryModels) {
                List<DayDetailModel> dayDetailModels = new DayDetailMapper().mapList(dayDetailDao.
                        procDayDetail(null, packageItineraryModel.getPackageItineraryId(), null, null, "s"));
                packageItineraryModel.setDayDetailActivities(new DayDetailMapper().mapListSetNull(false, true, true, true, false, false, dayDetailModels));

            }

        }

        return Response.status(Status.OK).entity(packageInfoModels)
                .type(MediaType.APPLICATION_JSON).build();
    }




    @Path("/packageInfo/{packageInfoId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByPackageInfo(@PathParam("packageInfoId") String packageInfoId) {

        List<PackageInfoModel> packageInfoModels = new PackageInfoMapper().mapList(packageInfoDao.
                procPackageInfo(packageInfoId, null, null, null, null, null,null, null, "s"));

        if (packageInfoModels.isEmpty()) {

            throw new NoContentException("data not found!!!!: Package Info");

        }

        PackageInfoModel packageInfoModel = packageInfoModels.get(0);

        List<PackageItineraryModel> packageItineraryModels = new PackageItineraryMapper().mapList(packageItineraryDao.
                procPackageItinerary(null, packageInfoModel.getPackageInfoId(), null, null, null, null, "b"));
        packageInfoModel.setPackageItineraries(new PackageItineraryMapper().mapListSetNull(false, true, true, false, false, false, false, packageItineraryModels));

        for (PackageItineraryModel packageItineraryModel : packageItineraryModels) {
            List<DayDetailModel> dayDetailModels = new DayDetailMapper().mapList(dayDetailDao.
                    procDayDetail(null, packageItineraryModel.getPackageItineraryId(), null, null, "s"));
            packageItineraryModel.setDayDetailActivities(new DayDetailMapper().mapListSetNull(false, true, true, true, false, false, dayDetailModels));

        }


        return Response.status(Status.OK).entity(packageInfoModel)
                .type(MediaType.APPLICATION_JSON).build();
    }

    @Path("/packageItinerary/{packageItineraryId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByPackageItinerary(@PathParam("packageItineraryId") String packageItineraryId) {


        List<PackageItineraryModel> packageItineraryModels = new PackageItineraryMapper().mapList(packageItineraryDao.
                procPackageItinerary(packageItineraryId, null, null, null, null, null, "b"));

        if (packageItineraryModels.isEmpty()) {

            throw new NoContentException("data not found!!!!: Package Itinerary");

        }

        for (PackageItineraryModel packageItineraryModel : packageItineraryModels) {
            List<DayDetailModel> dayDetailModels = new DayDetailMapper().mapList(dayDetailDao.
                    procDayDetail(null, packageItineraryModel.getPackageItineraryId(), null, null, "s"));
            packageItineraryModel.setDayDetailActivities(new DayDetailMapper().mapListSetNull(false, true, true, true, false, false, dayDetailModels));

        }

        return Response.status(Status.OK).entity(packageItineraryModels)
                .type(MediaType.APPLICATION_JSON).build();
    }

    @Path("/{dayDetailId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(
            @PathParam("dayDetailId") String activityDetailId) {

        @SuppressWarnings({"rawtypes", "unchecked"})
        List<Map> list = dayDetailDao.procDayDetail(null, null, null, null, "s");


        if (list.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        @SuppressWarnings("rawtypes")
        DayDetailModel dayDetailModel = new DayDetailMapper()
                .mapRow((Map) list.get(0));

        return Response.status(Status.OK).entity(dayDetailModel)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertData(DayDetailModel dayDetailModel) {

        @SuppressWarnings("unchecked")
        Map databaseResponse = (Map) dayDetailDao.procDayDetail(null, dayDetailModel.getPackageItineraryId(),
                dayDetailModel.getActivityDetailId(), dayDetailModel.getUser(), "i").get(0);


        return Response.status(Status.OK).entity(databaseResponse)
                .type(MediaType.APPLICATION_JSON).build();

    }

    //	@Path("/{dayDetailId}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateData(

//	@PathParam("dayDetailId") String dayDetailId,
            DayDetailModel dayDetailModel) {

        Response rsp = getById(dayDetailModel.getDayDetailId());

        if (rsp.getStatus() == 200) {

            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) dayDetailDao.procDayDetail(dayDetailModel.getDayDetailId(), dayDetailModel.getPackageItineraryId(),
                    dayDetailModel.getActivityDetailId(), dayDetailModel.getUser(), "u").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE else {

        return rsp;
    }

    //	@Path("/{dayDetailId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteData(
//			@PathParam("dayDetailId") String dayDetailId,
            DayDetailModel dayDetailModel) {

        Response rsp = getById(dayDetailModel.getDayDetailId());

        if (rsp.getStatus() == 200) {

            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) dayDetailDao.procDayDetail(dayDetailModel.getDayDetailId(), null,
                    null, dayDetailModel.getUser(), "d").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE else {

        return rsp;
    }

}
