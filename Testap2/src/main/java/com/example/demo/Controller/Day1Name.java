package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day1Name {
	private String name="Tarun";
	@RequestMapping("/Name")
	public String getName() {
		return "Welcome "+name+"!";
	}
}
