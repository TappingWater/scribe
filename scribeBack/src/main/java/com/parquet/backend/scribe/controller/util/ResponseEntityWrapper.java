package com.parquet.backend.scribe.controller.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.Getter;

@Getter
/**
 * Utility class that is used to wrap an object as a response entity
 * Default values such as headers configured here
 */
public class ResponseEntityWrapper<T> {
	
	private final ResponseEntity<T> responseEntity;
	private HttpHeaders responseHeaders = new HttpHeaders();
	
	
	public ResponseEntityWrapper(T object) {
		setResponseHeaders();
		responseEntity = new ResponseEntity<>(object, responseHeaders, HttpStatus.OK);
		
	}

	public ResponseEntityWrapper(T object, HttpStatus status) {
		setResponseHeaders();
		responseEntity = new ResponseEntity<>(object, responseHeaders, status);
		
	}

	private void setResponseHeaders() {
		responseHeaders.set("app-Name", "scribe back end");
		responseHeaders.set("purpose", "manage logical operations and communicate with front end");
	}
}
