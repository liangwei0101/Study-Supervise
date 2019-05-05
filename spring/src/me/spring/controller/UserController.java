package me.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.spring.entity.User;
import me.spring.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(User user,Model model) {
		if(userService.validateUser(user)){
			model.addAttribute("user", userService.getUser(user));
			return "welcome";
		}else{
			if(user.getUsername()!=null ) model.addAttribute("message", "账号密码错误");
			return "login";
		}
	}
		
}
