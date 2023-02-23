package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day1Colorname {
	private String color="Green";
	@RequestMapping("/colorname")
	public String colorName() {
		return "Your Favrouite color :"+color;
	}
}
