package com.myProject.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@GetMapping("/fileUpload")
	public String myupload()
	{
		return "myupload";
	}
	
	
	
	@PostMapping("/upload")
	public String myFileUpload(@RequestParam("file") MultipartFile file,Model model) throws IllegalStateException, IOException
	{
		 if (!file.isEmpty()) {
			 
	   try
	   {
		 String uploadDirectory ="C:\\Users\\PRAVEEN\\eclipse-workspace\\FileUpload-Application\\src\\main\\webapp\\resources\\static\\images";
		 
		 String filename = file.getOriginalFilename();
		 
		 File uploadFile = new File(uploadDirectory +"/"+filename);
		 
		 file.transferTo(uploadFile);
		 
		// Add file details to the model
         model.addAttribute("fileName", filename);
         model.addAttribute("fileSize", file.getSize());
         
         return "uploadSuccess";
		
	   }catch(IOException e)
	   {
		   e.printStackTrace();
		   return "uploadFailure";
	   }
		 }
		 else
		 {
			  return "uploadFailure";
		 }
		 
		 
	}
}
		 
		 
		 
		 
		 
		 