package igc.tech.com.resource;

import igc.tech.com.dao.PackageInfoDao;
import igc.tech.com.dao.PackageItineraryDao;
import igc.tech.com.exception.NoContentException;
import igc.tech.com.mapper.PackageInfoMapper;
import igc.tech.com.mapper.PackageItineraryMapper;
import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.PackageInfoModel;
import igc.tech.com.model.PackageItineraryModel;

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
@Path("/packageItinerary")
public class PackageItineraryResource {
    @Autowired
    PackageItineraryDao packageItineraryDao;

    @Autowired
    PackageInfoDao packageInfoDao;

    ErrorMessage errorMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        List<PackageItineraryModel> packageItineraryModels = new PackageItineraryMapper().mapList(packageItineraryDao.
                procPackageItinerary(null, null, null, null, null, null, "a"));

        if (packageItineraryModels.isEmpty()) {

            throw new NoContentException("No Data found!!!!:");

        }

        return Response.status(Status.OK).entity(packageItineraryModels)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/packageInfo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllByPackageInfo() {

        List<PackageInfoModel> packageInfoModels = new PackageInfoMapper().mapList(packageInfoDao.procPackageInfo(null, null, null, null, null, null, null, null, "b"));

        if (packageInfoModels.isEmpty()) {

            throw new NoContentException("No Data found!!!!:");

        }

        for (PackageInfoModel packageInfoModel : packageInfoModels) {
            List<PackageItineraryModel> packageItineraryModels = new PackageItineraryMapper().mapList(packageItineraryDao.procPackageItinerary(null, packageInfoModel.getPackageInfoId(),
                    null, null, null, null, "s"));

            packageInfoModel.setPackageItineraries(new PackageItineraryMapper().mapListSetNull(false, true, true, false, false, false, false, packageItineraryModels));

        }

        return Response.status(Status.OK).entity(packageInfoModels)
                .type(MediaType.APPLICATION_JSON).build();
    }


    @Path("/packageInfo/{packageInfo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByPackageInfo(@PathParam("packageInfo") String packageInfoId) {

        List<PackageInfoModel> packageInfoModels = new PackageInfoMapper().mapList(packageInfoDao.procPackageInfo(packageInfoId, null, null, null, null, null, null, null, "s"));

        if (packageInfoModels.isEmpty()) {

            throw new NoContentException("No Data found!!!!: Package Info");

        }

        PackageInfoModel packageInfoModel = packageInfoModels.get(0);

        List<PackageItineraryModel> packageItineraryModels = new PackageItineraryMapper().mapList(packageItineraryDao.procPackageItinerary(null, packageInfoModel.getPackageInfoId(),
                null, null, null, null, "s"));

        packageInfoModel.setPackageItineraries(new PackageItineraryMapper().mapListSetNull(false, true, true, false, false, false, false, packageItineraryModels));


        return Response.status(Status.OK).entity(packageInfoModel)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/{packageItineraryId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(
            @PathParam("packageItineraryId") String packageItineraryId) {

        // System.out.println(hotelFacilityID + " this is hotel facility ID");

        @SuppressWarnings({"rawtypes", "unchecked"})
        List<Map> list = packageItineraryDao.procPackageItinerary(
                packageItineraryId, null, null, null, null, null, "s");
        if (list.isEmpty()) {

            throw new NoContentException("No Data found!!!!");

        }

        @SuppressWarnings("rawtypes")
        PackageItineraryModel packageItinerary = new PackageItineraryMapper()
                .mapRow((Map) list.get(0));

        return Response.status(Status.OK).entity(packageItinerary)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertData(PackageItineraryModel packageItinerary) {

        @SuppressWarnings("unchecked")
        Map databaseResponse = (Map) packageItineraryDao
                .procPackageItinerary(null,
                        packageItinerary.getPackageInfoId(),
                        packageItinerary.getDay(),
                        packageItinerary.getDayDetails(),
                        packageItinerary.getHotelDetailId(),
                        packageItinerary.getUser(), "i").get(0);

        return Response.status(Status.OK).entity(databaseResponse)
                .type(MediaType.APPLICATION_JSON).build();

    }

    //	@Path("/{packageItineraryId}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateData(
//			@PathParam("packageItineraryId") String packageItineraryId,
            PackageItineraryModel packageItineraryModel) {
        /*
		 * GETTING DATA FROM GETBYID METHOD TO CHECK THE EMPTY CONTENT FOR
		 * PROVIDED UPDATE ID
		 */
        // System.out.println("this is the first cid "+countryId);

        Response rsp = getById(packageItineraryModel.getPackageItineraryId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) packageItineraryDao
                    .procPackageItinerary(packageItineraryModel.getPackageItineraryId(),
                            packageItineraryModel.getPackageInfoId(),
                            packageItineraryModel.getDay(),
                            packageItineraryModel.getDayDetails(),
                            packageItineraryModel.getHotelDetailId(),
                            packageItineraryModel.getUser(), "u").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE
        else {

            return rsp;
        }

    }

    //	@Path("/{packageItineraryId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteData(
//			@PathParam("packageItineraryId") String packageItineraryId,
            PackageItineraryModel packageItineraryModel) {
		/*
		 * GETTING DATA FROM GETBYID METHOD TO CHECK THE EMPTY CONTENT FOR
		 * PROVIDED UPDATE ID
		 */

        Response rsp = getById(packageItineraryModel.getPackageItineraryId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) packageItineraryDao
                    .procPackageItinerary(packageItineraryModel.getPackageItineraryId(), null, null, null,
                            null, packageItineraryModel.getUser(), "d").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE
        else {

            return rsp;
        }
    }

}
