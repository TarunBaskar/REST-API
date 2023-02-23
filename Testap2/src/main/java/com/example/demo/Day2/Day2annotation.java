package com.example.demo.Day2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day2annotation {
	@Value("${greeting.message}")
	private String message;
	@RequestMapping("/annotation")
	public String valueannotation() {
		return message;
	}

}
