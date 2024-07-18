package com.myProject.Dto;

import java.util.Arrays;

public class InformationDTO {

	private int rollno;
	private String name;
	private int age;
	private byte[] photo;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "InformationDTO [rollno=" + rollno + ", name=" + name + ", age=" + age + ", photo="
				+ Arrays.toString(photo) + "]";
	}
	
	
}
