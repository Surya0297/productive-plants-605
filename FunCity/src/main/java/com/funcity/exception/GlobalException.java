package com.funcity.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler
	public ResponseEntity<MyErrorDetails> adminException(AdminException adminException, WebRequest wr){
		MyErrorDetails myerrordetails = new MyErrorDetails();
		myerrordetails.setTimeStamp(LocalDateTime.now());
		myerrordetails.setMsg(adminException.getMessage());
		myerrordetails.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(myerrordetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<MyErrorDetails> customerException(CustomerException customerException, WebRequest wr){
		MyErrorDetails myerrordetails = new MyErrorDetails();
		myerrordetails.setTimeStamp(LocalDateTime.now());
		myerrordetails.setMsg(customerException.getMessage());
		myerrordetails.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(myerrordetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<MyErrorDetails> activityException(ActivityException activityException, WebRequest wr){
		MyErrorDetails myerrordetails = new MyErrorDetails();
		myerrordetails.setTimeStamp(LocalDateTime.now());
		myerrordetails.setMsg(activityException.getMessage());
		myerrordetails.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(myerrordetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<MyErrorDetails> ticketException(TicketException ticketException, WebRequest wr){
		MyErrorDetails myerrordetails = new MyErrorDetails();
		myerrordetails.setTimeStamp(LocalDateTime.now());
		myerrordetails.setMsg(ticketException.getMessage());
		myerrordetails.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(myerrordetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler5(Exception he,WebRequest req){
		MyErrorDetails err=new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMsg(he.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler6(NoHandlerFoundException he,WebRequest req){
		MyErrorDetails err=new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMsg(he.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler7(MethodArgumentNotValidException he){
		MyErrorDetails err=new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMsg(he.getMessage());
		err.setDetails(he.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
}
