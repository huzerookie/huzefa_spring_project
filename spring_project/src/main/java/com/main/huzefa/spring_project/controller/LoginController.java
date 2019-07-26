package com.main.huzefa.spring_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.main.huzefa.spring_project.bean.User;

@Controller
@SessionAttributes("message")
public class LoginController {

	@Autowired
	private User user;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String helloString() {
		
		return "Hello World";
	}
	
	
	@RequestMapping(value="/index_wname", method=RequestMethod.GET)
	public String helloIndex(ModelMap model) {
		//model.addAttribute("name", model.get("name"));
		System.out.println("This is being called");
		return "index_wname";
	}
	
	@RequestMapping(value="/index_wname", method=RequestMethod.POST)
	public String validateDetails(@RequestParam String username, @RequestParam String password, ModelMap model) {
		//user.setCredentials(username, password);
		if(user.validateCredentials(username, password)) {
			model.put("message", "");
			model.put("username", username);
			return "index";
		}	
		model.put("message", "Invalid Username/Password");
		System.out.println(model.get("message"));
		return "redirect:/index_wname";
	}
	
	
}
