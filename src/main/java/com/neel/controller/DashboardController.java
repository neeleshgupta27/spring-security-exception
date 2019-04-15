package com.neel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.neel.entity.User;
import com.neel.service.AdminService;

@Controller
public class DashboardController {
	
	@Autowired
	private AdminService adminService;

	@GetMapping("/dashboard")
	public String dashboar(/*@AuthenticationPrincipal User user, */ModelMap map) {
		
		/*System.out.println("DashboardController:: user:"+user.toString());
		
		map.put("user", user);
		*/
		
		return "dashboard";
	}
}
