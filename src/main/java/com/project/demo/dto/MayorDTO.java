package com.project.demo.dto;

public class MayorDTO {

	private Long mayorId;
	private String name;
	private int age;

	public long getMayorId() {
		return mayorId;
	}

	public void setMayorId(Long mayorId) {
		this.mayorId = mayorId;
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

	@Override
	public String toString() {
		return "MayorDTO [mayorId=" + mayorId + ", name=" + name + ", age=" + age + "]";
	}

	public MayorDTO(long mayorId, String name, int age) {
		super();
		this.mayorId = mayorId;
		this.name = name;
		this.age = age;
	}

	public MayorDTO() {

	}

}
