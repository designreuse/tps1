package igc.tech.com.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NoContentExceptionMapper implements
		ExceptionMapper<NoContentException> {

	@Override
	public Response toResponse(NoContentException ex) {
		return Response.status(204)
				.type(MediaType.APPLICATION_JSON).build();

	}

}
