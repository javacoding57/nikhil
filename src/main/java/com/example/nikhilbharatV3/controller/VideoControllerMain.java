package com.example.nikhilbharatV3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VideoControllerMain {
	
	@GetMapping("/videoplay")
	public String videoplay() {
		return "videoplay";
	}

}
