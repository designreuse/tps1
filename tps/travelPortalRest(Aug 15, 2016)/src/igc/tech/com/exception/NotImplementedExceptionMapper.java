package igc.tech.com.exception;

import igc.tech.com.model.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotImplementedExceptionMapper implements ExceptionMapper<NotImplementedException> {



	@Override
	public Response toResponse(NotImplementedException ex) {
		
		ErrorMessage errorMessage=new ErrorMessage(ex.getMessage(), "501", "http://test.com");
		return Response.status(501)
				.entity(errorMessage)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
