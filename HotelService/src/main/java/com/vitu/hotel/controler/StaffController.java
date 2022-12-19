package com.vitu.hotel.controler;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/staffs")
public class StaffController {

	@GetMapping("")
	public ResponseEntity<List<String>> getAllStaffs(){
		
java.util.List<String> list = Arrays.asList("vithal","nagappa","nivargi","mahesh","subhash","ravi","kavi");

return new ResponseEntity<>(list,HttpStatus.OK);

	}
}
