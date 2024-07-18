package com.myProject.service;

import com.itextpdf.io.exceptions.IOException;
import com.myProject.Dto.InformationDTO;
import com.myProject.dao.InformationDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SaveInformation {

	@Autowired InformationDAO informationDAO;
	
	public int saveDetail(String name, int age,MultipartFile photo) throws IOException, java.io.IOException {
		
		InformationDTO info = new InformationDTO();
		info.setName(name);
		info.setAge(age);
		info.setPhoto(photo.getBytes());
		
		return informationDAO.saveData(info);
	}
}
