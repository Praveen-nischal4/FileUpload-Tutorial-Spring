package com.myProject.dao;

import com.myProject.Dto.InformationDTO;

public interface InformationDAO {

	public int saveData(InformationDTO informationDTO); 
	public InformationDTO getUserDEtails(int rollno);
}
