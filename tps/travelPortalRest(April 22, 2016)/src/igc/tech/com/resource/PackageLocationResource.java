package igc.tech.com.resource;

import igc.tech.com.dao.PackageInfoDao;
import igc.tech.com.dao.PackageItineraryDao;
import igc.tech.com.dao.PackageLocationDao;
import igc.tech.com.exception.NoContentException;
import igc.tech.com.mapper.PackageInfoMapper;
import igc.tech.com.mapper.PackageItineraryMapper;
import igc.tech.com.mapper.PackageLocationMappper;
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
@Path("/packageLocation")
public class PackageLocationResource {

    @Autowired
    PackageLocationDao packageLocationDao;

    @Autowired
    PackageInfoDao packageInfoDao;

    @Autowired
    PackageItineraryDao packageItineraryDao;

    ErrorMessage errorMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        List<PackageLocationModel> packageLocationModels = new PackageLocationMappper().
                mapList(packageLocationDao.procPackageLocation(null,null, null, null, "a"));

        return Response.status(Status.OK).entity(packageLocationModels)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/packageInfo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllByPackageInfo() {

        List<PackageInfoModel> packageInfoModels = new PackageInfoMapper().mapList(packageInfoDao.procPackageInfo(null, null, null,null, null, null, null, null, "e"));

        for (PackageInfoModel packageInfoModel : packageInfoModels) {
            List<PackageItineraryModel> packageItineraryModels = new PackageItineraryMapper().
                    mapList(packageItineraryDao.procPackageItinerary(null, packageInfoModel.getPackageInfoId(), null, null, null, null, "s"));
            packageInfoModel.setPackageItineraries(new PackageItineraryMapper().mapListSetNull(false, true, true, false, false, false, false, packageItineraryModels));

            for (PackageItineraryModel packageItineraryModel : packageItineraryModels) {
                List<PackageLocationModel> packageLocationModels = new PackageLocationMappper().
                        mapList(packageLocationDao.procPackageLocation(null, packageItineraryModel.getPackageItineraryId(), null, null, "s"));
                packageItineraryModel.setPackageLocations(new PackageLocationMappper().mapListSetNull(false, true, true, true, true, false, false, false, packageLocationModels));

            }

        }


        return Response.status(Status.OK).entity(packageInfoModels)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/packageInfo/{packageInfoId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByPackageInfo(@PathParam("packageInfoId") String packageInfoId) {

        List<PackageInfoModel> packageInfoModels=new PackageInfoMapper().mapList(packageInfoDao.procPackageInfo(packageInfoId,null,null,null,null,null,null,null,"s"));

        if (packageInfoModels.isEmpty()) {

            throw new NoContentException("No Data found!!!!: Package Info");

        }

        PackageInfoModel packageInfoModel=packageInfoModels.get(0);

        List<PackageItineraryModel> packageItineraryModels = new PackageItineraryMapper().
                mapList(packageItineraryDao.procPackageItinerary(null, packageInfoModel.getPackageInfoId(), null, null, null, null, "s"));
        packageInfoModel.setPackageItineraries(new PackageItineraryMapper().mapListSetNull(false, true, true, false, false, false, false, packageItineraryModels));

        for (PackageItineraryModel packageItineraryModel : packageItineraryModels) {
            List<PackageLocationModel> packageLocationModels = new PackageLocationMappper().
                    mapList(packageLocationDao.procPackageLocation(null, packageItineraryModel.getPackageItineraryId(), null, null, "s"));
            packageItineraryModel.setPackageLocations(new PackageLocationMappper().mapListSetNull(false, true, true, true, true, false, false, false, packageLocationModels));
        }


        return Response.status(Status.OK).entity(packageInfoModel)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/packageItinerary/{packageItineraryId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByPackageItinerary(@PathParam("packageItineraryId") String packageItineraryId) {


        List<PackageItineraryModel> packageItineraryModels = new PackageItineraryMapper().
                mapList(packageItineraryDao.procPackageItinerary(packageItineraryId, null, null, null, null, null, "s"));
        if (packageItineraryModels.isEmpty()) {

            throw new NoContentException("No Data found!!!!: Package Itinerary");

        }

        PackageItineraryModel packageItineraryModel=packageItineraryModels.get(0);

            List<PackageLocationModel> packageLocationModels = new PackageLocationMappper().
                    mapList(packageLocationDao.procPackageLocation(null, packageItineraryModel.getPackageItineraryId(), null, null, "s"));
            packageItineraryModel.setPackageLocations(new PackageLocationMappper().mapListSetNull(false, true, true, true, true, false, false, false, packageLocationModels));


        return Response.status(Status.OK).entity(packageItineraryModel)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/{packageLocationId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(
            @PathParam("packageLocationId") String packageLocationId) {

        @SuppressWarnings({"rawtypes", "unchecked"})
        List<Map> list = packageLocationDao.procPackageLocation(
                packageLocationId, null, null, null, "s");

        if (list.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        @SuppressWarnings("rawtypes")
        PackageLocationModel packageLocationModel = new PackageLocationMappper()
                .mapRow((Map) list.get(0));

        return Response.status(Status.OK).entity(packageLocationModel)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertData(PackageLocationModel packageLocationModel) {

        @SuppressWarnings("unchecked")
        Map databaseResponse = (Map) packageLocationDao
                .procPackageLocation(null,
                        packageLocationModel.getPackageItineraryId(),
                        packageLocationModel.getAreaId(),
                        packageLocationModel.getUser(), "i").get(0);

        return Response.status(Status.OK).entity(databaseResponse)
                .type(MediaType.APPLICATION_JSON).build();

    }

    //	@Path("/{packageLocationId}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateData(

//	@PathParam("packageLocationId") String packageLocationId,
            PackageLocationModel packageLocationModel) {

        Response rsp = getById(packageLocationModel.getPackageLocationId());

        if (rsp.getStatus() == 200) {

            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) packageLocationDao
                    .procPackageLocation(packageLocationModel.getPackageLocationId(),
                            packageLocationModel.getPackageItineraryId(),
                            packageLocationModel.getAreaId(),
                            packageLocationModel.getUser(), "u").get(0);
            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE else {

        return rsp;
    }

    //	@Path("/{packageLocationId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteData(
//			@PathParam("packageLocationId") String packageLocationId,
            PackageLocationModel packageLocationModel) {

        Response rsp = getById(packageLocationModel.getPackageLocationId());

        if (rsp.getStatus() == 200) {

            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) packageLocationDao
                    .procPackageLocation(packageLocationModel.getPackageLocationId(), null, null,
                            packageLocationModel.getUser(), "d").get(0);
            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE else {

        return rsp;
    }

}
