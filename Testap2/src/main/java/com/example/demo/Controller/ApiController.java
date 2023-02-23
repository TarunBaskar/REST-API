package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
        	@RequestMapping("/")
        	public String Handler() {
        		return "Welcome!!!";
        	}
}
