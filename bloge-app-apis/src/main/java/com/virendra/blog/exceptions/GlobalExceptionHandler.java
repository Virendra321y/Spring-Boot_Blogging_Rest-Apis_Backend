package com.virendra.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.virendra.blog.payloads.ApiResponse;

//like this we can create custom Exception for to handle Exception ham Es tarike Se handle kar Sakte hai..
@RestControllerAdvice                       //this Anotation is User to handle global Exception for All Controllers..
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class) //<--mere controller me ye ResourceNot... Exception aaye to ye mera run ho jaye ga
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	
	//this is golbal Exception handling method proper data ko agar ham dataBase me send karna chate hai to ham aise kar sakte hai
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMathodArgsNotValidException(MethodArgumentNotValidException ex){
		
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			
		  String fieldName = ((FieldError) error).getField(); //type costing error into FiledError
		  String message = error.getDefaultMessage();
		  resp.put(fieldName, message);
		});
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ApiEception.class) //<--mere controller me ye ResourceNot... Exception aaye to ye mera run ho jaye ga
	public ResponseEntity<ApiResponse> handleApiException(ApiEception ex){
		String message = ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,true);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
	}
	

}
