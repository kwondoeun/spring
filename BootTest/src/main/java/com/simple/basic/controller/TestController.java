package com.simple.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //스트링부트는 RestController (나중에 배움)
public class TestController {
	
	@GetMapping("/")
	public String test() {
		return "실행됨!!!!";
		
	}

}
