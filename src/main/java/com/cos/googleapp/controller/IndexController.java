package com.cos.googleapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.googleapp.config.SentrySupport;


@Controller
public class IndexController {
	
	@Autowired
	private SentrySupport SentrySupport;

	@GetMapping({"","/"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/product")
	public String product() {
		SentrySupport.logSimpleMessage("product쪽 오류");
		return "product";
	}
	
	@GetMapping("/user")
	public String user() {
		SentrySupport.logSimpleMessage("user쪽 오류");
		return "user";
	}
	
}
