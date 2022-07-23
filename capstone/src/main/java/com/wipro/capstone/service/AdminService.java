package com.wipro.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.capstone.model.Admin;
import com.wipro.capstone.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
   public String adminRegistration(Admin adm) {
	   if(adminRepository.existsById(adm.getEmail())) {
		   return "Your Details Already Present";
	   }else {
		   adminRepository.save(adm);
		   return "Details Saved Sucessfully";
	   }	   
   }
   
   public String checkAdminDetails(Admin adm) {
	   if(adminRepository.existsById(adm.getEmail())) {
		   Admin a=adminRepository.getById(adm.getEmail());
		   if(a.getPassword().equals(adm.getPassword())) {
			   return "You Logged In sucessfully";
		   }else {
			   return "Please Enter Correct Details";
		   }				   
	   }else {
		   return "Your Details Are Not Exists!!";
	   }
	   
   }
   
 //Admin logout checking
 		public String adminLogout(String email) {
 			   if(adminRepository.existsById(email)) {
 					   return " Admin LogOut Sucessfully";
 				   }else {
 					   return "Please Enter Correct Details";
 				   }				   	   
 		   }

   public List<Admin> getAllAdminAvaliable(){
		return adminRepository.findAll();
	}
   
}
