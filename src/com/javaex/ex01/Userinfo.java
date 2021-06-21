package com.javaex.ex01;

public class Userinfo {

	// fields
	private String name;
	private String hp;
	private String company;

	// constructors
	public Userinfo(String name, String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;

	}

	// method g/s
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	// method
	public void showList() {
		System.out.println("  " + this.name + "   " + hp + "   " + company);
		
	}
	
	
}
