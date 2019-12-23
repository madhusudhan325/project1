package com.mindtree.channelshows.controller.handler;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.channelshows.controller.AppController;
import com.mindtree.channelshows.exception.AppException;

@RestControllerAdvice(assignableTypes = AppController.class)
public class AppExceptionHandler {

	@ExceptionHandler(AppException.class)
	public ResponseEntity<Map<String, Object>> ServiceExceptionHandler(Exception e, Throwable cause) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("header", "Channel Group");
		response.put("Error", true);
		response.put("body", e.getMessage());
		response.put("Httpstatus", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
	}

}
