package igc.tech.com.controller;

import igc.tech.com.exception.CustomGenericException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex) {

		System.out.println("global testing***");
		
		ModelAndView model = new ModelAndView("error");
//		model.addObject("errCode", ex.getErrCode());
		model.addObject("errorMessage", ex.getErrMsg());

		return model;

	}
	
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSqlException(SQLException ex) {
		System.out.println("sqlException");
		System.out.println("msg***"+ ex.getMessage());
		
		System.out.println("cause***"+ ex.getLocalizedMessage());

		ModelAndView model = new ModelAndView("error");
		model.addObject("errorMessage", ex.getMessage());

		return model;

	}
	
	@ExceptionHandler(IOException.class)
	public ModelAndView handleIoException(IOException ex) {
		System.out.println("ioException");
		System.out.println("msg***"+ ex.getMessage());
		ex.printStackTrace();
		
		System.out.println("cause***"+ ex.getLocalizedMessage());

		ModelAndView model = new ModelAndView("error");
		model.addObject("errorMessage", ex.getMessage());

		return model;

	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ModelAndView handleIoException(IllegalArgumentException ex) {
		System.out.println("IllegalArgumentException");
		System.out.println("msg***"+ ex.getMessage());
		
		
		System.out.println("cause***"+ ex.getLocalizedMessage());

		ModelAndView model = new ModelAndView("error");
		model.addObject("errorMessage", ex.getMessage());

		return model;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
ex.printStackTrace();
		
		System.out.println("cause:"+ex.getCause());
		System.out.println("all");
		
		System.out.println("msg***"+ ex.getMessage());
		
		System.out.println("cause***"+ ex.getLocalizedMessage());

		ModelAndView model = new ModelAndView("error");
		model.addObject("errorMessage", ex.getMessage());

		return model;

	}
	
}