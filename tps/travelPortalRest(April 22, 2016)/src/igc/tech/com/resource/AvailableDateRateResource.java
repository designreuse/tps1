package igc.tech.com.resource;

import igc.tech.com.dao.AvailableDateRateDao;
import igc.tech.com.dao.PackageInfoDao;
import igc.tech.com.exception.NoContentException;
import igc.tech.com.mapper.AvailableDateRateMappper;
import igc.tech.com.mapper.PackageInfoMapper;
import igc.tech.com.model.AvailableDateRateModel;
import igc.tech.com.model.ErrorMessage;

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

import igc.tech.com.model.PackageInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/availableDateRate")
public class AvailableDateRateResource {

    @Autowired
    AvailableDateRateDao availableDateRateDao;

    @Autowired
    PackageInfoDao packageInfoDao;

    ErrorMessage errorMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        List<AvailableDateRateModel> availableDateRateModels = new AvailableDateRateMappper().
                mapList(availableDateRateDao.procAvailableDateRate(null, null, null, null, null, "a"));

        if (availableDateRateModels.isEmpty()) {

            throw new NoContentException("No Data found!!!!:");

        }

        return Response.status(Status.OK).entity(availableDateRateModels)
                .type(MediaType.APPLICATION_JSON).build();
    }

    @Path("/packageInfo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllByPackageInfo() {

        List<PackageInfoModel> packageInfoModels = new PackageInfoMapper().mapList(packageInfoDao.procPackageInfo(null, null,null, null, null, null, null, null, "c"));


        System.out.println(packageInfoModels);
        if (packageInfoModels.isEmpty()) {

            throw new NoContentException("No Data found!!!!:");

        }

        for (PackageInfoModel packageInfoModel : packageInfoModels) {
            List<AvailableDateRateModel> availableDateRateModels = new AvailableDateRateMappper().mapList(availableDateRateDao.procAvailableDateRate(null, null, packageInfoModel.getPackageInfoId(), null, null, "s"));

            packageInfoModel.setAvailableDateRates(new AvailableDateRateMappper().mapListSetNull(false, false, true, true, false, availableDateRateModels));

        }
        return Response.status(Status.OK).entity(packageInfoModels)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/packageInfo/{packageInfo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByPackageInfo(@PathParam("packageInfo") String packageInfoId) {

        List<PackageInfoModel> packageInfoModels = new PackageInfoMapper().mapList(packageInfoDao.procPackageInfo(null, null, null, null,null, null, null, null, "c"));

        if (packageInfoModels.isEmpty()) {

            throw new NoContentException("No Data found!!!!:");

        }

        PackageInfoModel packageInfoModel=packageInfoModels.get(0);

            List<AvailableDateRateModel> availableDateRateModels = new AvailableDateRateMappper().mapList(availableDateRateDao.procAvailableDateRate(null, null, packageInfoModel.getPackageInfoId(), null, null, "s"));

            packageInfoModel.setAvailableDateRates(new AvailableDateRateMappper().mapListSetNull(false, false, true, true, false, availableDateRateModels));

        return Response.status(Status.OK).entity(packageInfoModel)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/{availableDateRateId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(
            @PathParam("availableDateRateId") String availableDateRateId) {

        @SuppressWarnings({"rawtypes", "unchecked"})
        List<Map> list = availableDateRateDao.procAvailableDateRate(
                availableDateRateId, null, null, null, null, "s");

        if (list.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        @SuppressWarnings("rawtypes")
        AvailableDateRateModel avaRateModel = new AvailableDateRateMappper()
                .mapRow((Map) list.get(0));

        return Response.status(Status.OK).entity(avaRateModel)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertData(AvailableDateRateModel availableDateRateModel) {

        @SuppressWarnings("unchecked")
        Map databaseResponse = (Map) availableDateRateDao
                .procAvailableDateRate(null,
                        availableDateRateModel.getAvailableDate(),
                        availableDateRateModel.getPackageInfoId(),
                        availableDateRateModel.getRate(),
                        availableDateRateModel.getUser(), "i").get(0);

        return Response.status(Status.OK).entity(databaseResponse)
                .type(MediaType.APPLICATION_JSON).build();

    }

    //	@Path("/{availableDateRateId}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateData(

//	@PathParam("availableDateRateId") String availableDateRateId,
            AvailableDateRateModel availableDateRateModel) {

        Response rsp = getById(availableDateRateModel.getAvailableDateRateId());

        if (rsp.getStatus() == 200) {

            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) availableDateRateDao
                    .procAvailableDateRate(availableDateRateModel.getAvailableDateRateId(),
                            availableDateRateModel.getAvailableDate(),
                            availableDateRateModel.getPackageInfoId(),
                            availableDateRateModel.getRate(),
                            availableDateRateModel.getUser(), "u").get(0);
            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE else {

        return rsp;
    }

    //	@Path("/{availableDateRateId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteData(

//	@PathParam("availableDateRateId") String availableDateRateId,
            AvailableDateRateModel availableDateRateModel) {

        Response rsp = getById(availableDateRateModel.getAvailableDateRateId());

        if (rsp.getStatus() == 200) {

            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) availableDateRateDao
                    .procAvailableDateRate(availableDateRateModel.getAvailableDateRateId(), null, null,
                            null, availableDateRateModel.getUser(), "d").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        {
            return rsp;
        }

    }
}
