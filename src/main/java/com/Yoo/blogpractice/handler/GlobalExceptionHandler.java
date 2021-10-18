package com.Yoo.blogpractice.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.Yoo.blogpractice.dto.ResponseDto;

@ControllerAdvice	//어디서든 예외가 발생하면 클래스 실행
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseDto<String> handleArgumentException(Exception e){
		return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		
	}
}
