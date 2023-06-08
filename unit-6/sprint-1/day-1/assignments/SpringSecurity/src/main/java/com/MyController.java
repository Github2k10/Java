package com;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/masai")
public class MyController {

	@GetMapping("/welcome")
	public ResponseEntity<String> getWelcome(){
		return new ResponseEntity<>("Welcome to Spring Project!!!", HttpStatus.OK);
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> getHello(){
		return new ResponseEntity<>("Hello to Spring Project!!!", HttpStatus.OK);
	}
}
