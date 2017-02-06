package igc.tech.com.resource;

import igc.tech.com.dao.RegionDao;
import igc.tech.com.exception.NoContentException;
import igc.tech.com.exception.NotImplementedException;
import igc.tech.com.mapper.RegionMapper;
import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.RegionModel;

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
@Path("/region")
public class RegionResource {

    @Autowired
    RegionDao regionDao;

    ErrorMessage errorMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        List<RegionModel> regionModels = new RegionMapper().mapList(regionDao.procRegion(null, null, null, null, "h"));

        if (regionModels.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        for (RegionModel m : regionModels) {

            List<RegionModel> regionModels1 = new RegionMapper().mapList(regionDao.procRegion(null, null, m.getCountryID(), null, "f"));

            m.setRegions(regionModels1);

        }


        return Response.status(Status.OK).entity(regionModels)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/{regionID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("regionID") String regionID) {

        @SuppressWarnings({"rawtypes", "unchecked"})
        List<Map> list = regionDao.procRegion(regionID, null, null, null, "s");

        if (list.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        @SuppressWarnings("rawtypes")
        RegionModel regionModel = new RegionMapper().mapRow((Map) list.get(0));

        return Response.status(Status.OK).entity(regionModel)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/country/{countryId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByHotelDetailId(@PathParam("countryId") String countryId) {


        List<Map> list = regionDao.procRegion(null, null, null, null, "h");

        if (list.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        RegionModel regionModel = new RegionMapper().mapRow(list.get(0));

        regionModel.setRegions(new RegionMapper().mapList(regionDao.procRegion(null, null, regionModel.getCountryID(), null, "f")));

        return Response.status(Status.OK).entity(regionModel)
                .type(MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertData(RegionModel region) {

        Map databaseResponse = (Map) regionDao.procRegion(null,
                region.getRegionName(), region.getCountryID(),
                region.getUser(), "i").get(0);

        if (!databaseResponse.get("STATUS").equals("SUCCESS")) {

            throw new NotImplementedException(databaseResponse.get("MSG").toString());
        }

        return Response.status(Status.OK).entity(databaseResponse)
                .type(MediaType.APPLICATION_JSON).build();

    }

    //	@Path("/{regionID}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateData(/*@PathParam("regionID") String regionID,*/
                               RegionModel regionModel) {
        /*
         * GETTING DATA FROM GETBYID METHOD TO CHECK THE EMPTY CONTENT FOR
		 * PROVIDED UPDATE ID
		 */
        Response rsp = getById(regionModel.getRegionId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")
            Map databaseResponse =(Map) regionDao.procRegion(
                    regionModel.getRegionId(), regionModel.getRegionName(), regionModel.getCountryID(),
                    regionModel.getUser(), "u").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE
        else {

            return rsp;
        }

    }

    //	@Path("/{regionID}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteData(/*@PathParam("regionID") String regionID,*/
                               RegionModel regionModel) {
        /*
         * GETTING DATA FROM GETBYID METHOD TO CHECK THE EMPTY CONTENT FOR
		 * PROVIDED UPDATE ID
		 */

        Response rsp = getById(regionModel.getRegionId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")
            Map databaseResponse =(Map) regionDao.procRegion(
                    regionModel.getRegionId(), null, null, regionModel.getUser(), "d").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE
        else {
            return rsp;
        }

    }

}
