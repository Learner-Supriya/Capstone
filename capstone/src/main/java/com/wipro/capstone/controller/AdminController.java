package com.wipro.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.capstone.model.Admin;
import com.wipro.capstone.service.AdminService;

@RestController
@RequestMapping("/Admin")
@CrossOrigin(origins = "http://localhost:4200")
 public class AdminController {
	@Autowired
	AdminService adminService;
	
	@PostMapping(value="register"/*,consumes=MediaType.APPLICATION_JSON_VALUE*/)
	public String adminRegister(@RequestBody Admin adm) {
	return adminService.adminRegistration(adm);
	}
	
	@PostMapping(value="login")
	public String checkAdminInfo(@RequestBody Admin adm) {
		return adminService.checkAdminDetails(adm);	
	}
	
	@GetMapping(value="displayAdmin")
	public List<Admin> getAllAdminAvaliable() {
		return adminService.getAllAdminAvaliable();
	}
	
	
	 @GetMapping(value = "logout/{email}")
	 public String adminLogoutInfo(@PathVariable("email") String email) {
	 return adminService.adminLogout(email);
        }
	 
}

