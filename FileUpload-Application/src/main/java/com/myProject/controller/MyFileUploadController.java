package com.myProject.controller;



import com.myProject.Dto.InformationDTO;
import com.myProject.dao.InformationDAO;
import com.myProject.service.SaveInformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MyFileUploadController {
	
	@Autowired
	private InformationDAO informationDAO;

	@Autowired
	private SaveInformation saveinfo;
	
	@GetMapping("/info")
	public String getDetails()
	{
		return "uploadData";
	}
	
	
	@PostMapping("/saveDetails")
	public String saveData(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("photo") MultipartFile photo , Model model)
	{
		
		
		try
		{
			//save data in database using service 
			
			int rollno  =saveinfo.saveDetail(name, age, photo);
			
			 model.addAttribute("message", "User details uploaded successfully!");
			 model.addAttribute("rollno", rollno); 
			 return "uploadSuccess";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "Failed to upload user details");
		}
		
		
		return null;
	}
	
	
	@GetMapping("/getPhotograph")
	public ResponseEntity<Resource> getPhotograph(@RequestParam("rollno") int rollno)
	{
		//get the details of user
		
		InformationDTO userDetails = informationDAO.getUserDEtails(rollno);
		
		//cehck condition is phtograph exists or not
		
		if(userDetails != null && userDetails.getPhoto() != null)
		{
			ByteArrayResource resource = new ByteArrayResource(userDetails.getPhoto());
			
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_TYPE, "image/jpg")
					.contentLength(resource.contentLength())
                    .body(resource);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
}
