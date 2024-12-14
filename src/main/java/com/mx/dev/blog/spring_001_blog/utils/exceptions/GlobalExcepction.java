package com.mx.dev.blog.spring_001_blog.utils.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExcepction {

	/**
	 * catch any exception
	 * 
	 * @param ex
	 * @return
	 */
	/*
	 * @ExceptionHandler(Exception.class) public ResponseEntity<?>
	 * handleException(Exception ex) {
	 * 
	 * ApiResponse<String> response = new
	 * ApiResponse<>(ResponseStatus.INTERNAL_SERVER_ERROR.getHttpStatusCode(),
	 * PathsConstants.PATH_USER, null,
	 * ExceptionsConstants.MESSAGE_INTERNAL_SERVER_ERROR + ex.getMessage(), null,
	 * true);
	 * 
	 * return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); }
	 */

}
