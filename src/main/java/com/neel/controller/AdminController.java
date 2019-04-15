package com.neel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neel.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="admin", method = RequestMethod.GET)
	public String adminPage() {
		return "admin";
	}
	
	//check condition for security config:: .antMatchers("/admin**").hasAnyRole("ADMIN")
	@RequestMapping(value="adminService", method = RequestMethod.GET)
	public String adminService() {
		adminService.performSomeAdminService();
		return "admin";
	}
	
	//check condition for security config:: .antMatchers("/admin**/**").hasAnyRole("ADMIN")
	@RequestMapping(value="admin/service", method = RequestMethod.GET)
	public String adminSubService() {
		adminService.performSomeAdminService();
		return "admin";
	}
}
