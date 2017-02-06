package igc.tech.com.resource;

import igc.tech.com.dao.ClientDetailDao;
import igc.tech.com.dao.PackageInfoDao;
import igc.tech.com.exception.NoContentException;
import igc.tech.com.exception.NotImplementedException;
import igc.tech.com.mapper.ClientDetailMapper;
import igc.tech.com.mapper.PackageInfoMapper;
import igc.tech.com.model.ClientDetailModel;
import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.PackageInfoModel;

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
@Path("/packageInfo")
public class PackageInfoResource {

    @Autowired
    PackageInfoDao packageInfoDao;


    @Autowired
    ClientDetailDao clientDetailDao;


    ErrorMessage errorMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        List<PackageInfoModel> packageInfoModels = new PackageInfoMapper().mapList(packageInfoDao.
                procPackageInfo(null, null, null, null, null, null, null, null, "a"));

        if (packageInfoModels.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        return Response.status(Status.OK).entity(packageInfoModels)
                .type(MediaType.APPLICATION_JSON).build();
    }


    @Path("clientDetail")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllByClient() {

        List<ClientDetailModel> clientDetailModels = new ClientDetailMapper().mapList(clientDetailDao.
                procClientDetail(null, null, null, null, null, null, null, null, null, null, null, "c"));

        if (clientDetailModels.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        for (ClientDetailModel clientDetailModel : clientDetailModels) {


            List<PackageInfoModel> packageInfoModels = new PackageInfoMapper().mapList(packageInfoDao.
                    procPackageInfo(null, null, null, null, null, null, clientDetailModel.getClientDetailId(), null, "s"));

            clientDetailModel.setPackageInfo(new PackageInfoMapper().mapListSetNull(false, false, false, false, false, false, false, true, true, packageInfoModels));

        }

        return Response.status(Status.OK).entity(clientDetailModels)
                .type(MediaType.APPLICATION_JSON).build();
    }

    @Path("clientDetail/{clientDetailId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByClientDetailId(@PathParam("clientDetailId") String clientDetailId) {

        List<ClientDetailModel> clientDetailModels = new ClientDetailMapper().mapList(clientDetailDao.
                procClientDetail(clientDetailId, null, null, null, null, null, null, null, null, null, null, "s"));

        if (clientDetailModels.isEmpty()) {

            throw new NoContentException("data not found!!!!:" + clientDetailId);

        }

        ClientDetailModel clientDetailModel = clientDetailModels.get(0);

        List<PackageInfoModel> packageInfoModels = new PackageInfoMapper().mapList(packageInfoDao.
                procPackageInfo(null, null, null, null, null, null, clientDetailModel.getClientDetailId(), null, "s"));

        clientDetailModel.setPackageInfo(new PackageInfoMapper().mapListSetNull(false, false, false, false, false, false, false, true, true, packageInfoModels));

        return Response.status(Status.OK).entity(clientDetailModel)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/{packageInfoId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("packageInfoId") String packageInfoId) {


        List<PackageInfoModel> packageInfoModels = new PackageInfoMapper().mapList(packageInfoDao.
                procPackageInfo(packageInfoId, null, null, null, null, null, null, null, "s"));

        if (packageInfoModels.isEmpty()) {

            throw new NoContentException("data not found!!!!:" + packageInfoId);

        }

        PackageInfoModel packageInfoModel = packageInfoModels.get(0);


        return Response.status(Status.OK).entity(packageInfoModel)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertData(PackageInfoModel packageInfo) {

        Map databaseResponse = (Map) packageInfoDao
                .procPackageInfo(null, packageInfo.getDescription(),
                        packageInfo.getNoOfDays(), packageInfo.getNoOfNights(),
                        packageInfo.getTotalDays(),
                        packageInfo.getPackageDetails(), packageInfo.getClientDetailId(),
                        packageInfo.getUser(), "i").get(0);

        if (!databaseResponse.get("STATUS").equals("SUCCESS")) {

            throw new NotImplementedException(databaseResponse.get("MSG").toString());
        }

        return Response.status(Status.OK).entity(databaseResponse)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateData(PackageInfoModel packageInfoModel) {

        Response rsp = getById(packageInfoModel.getPackageInfoId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) packageInfoDao
                    .procPackageInfo(packageInfoModel.getPackageInfoId(),
                            packageInfoModel.getDescription(),
                            packageInfoModel.getNoOfDays(),
                            packageInfoModel.getNoOfNights(),
                            packageInfoModel.getTotalDays(),
                            packageInfoModel.getPackageDetails(),
                            packageInfoModel.getClientDetailId(),
                            packageInfoModel.getUser(), "u").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE
        else {

            return rsp;
        }

    }


    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteData(PackageInfoModel packageInfoModel) {

        Response rsp = getById(packageInfoModel.getPackageInfoId());

        if (rsp.getStatus() == 200) {
            Map databaseResponse = (Map) packageInfoDao
                    .procPackageInfo(packageInfoModel.getPackageInfoId(), null, null, null, null,
                            null, null, packageInfoModel.getUser(), "d").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE
        else {

            return rsp;
        }

    }

}
