package com.main.java.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SpringJspViewController {

	@GetMapping(path = "/")
	public ModelAndView index(Map<String, Object> model) {
		model.put("index", "this is an index page");
		return new ModelAndView("index");
	}

	@GetMapping(path = "/next")
	public ModelAndView next(Map<String, Object> model) {
		model.put("next", "this is another page");
		return new ModelAndView("next");
	}
}
