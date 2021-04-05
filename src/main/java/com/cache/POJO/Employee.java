package com.cache.POJO;


public class Employee {

	private int id;
	private String name;
	private int age;
	private boolean existing;
	
	public Employee(int id,boolean flag) {
		super();
		this.id = id;
		this.name = "TestName"+id;
		this.age = 12+id;
		this.existing=flag;
	}
	public Employee(int id) {
		super();
		this.id = id;
		this.name = "TestName"+id;
		this.age = 12+id;
		this.existing=false;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public boolean isExisting() {
		return existing;
	}
	public void setExisting(boolean existing) {
		this.existing = existing;
	}
	
}
