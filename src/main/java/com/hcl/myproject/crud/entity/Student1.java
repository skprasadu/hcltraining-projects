package com.hcl.myproject.crud.entity;

public class Student1 {
	private int ID;
	private String name;
	private int age;
	private String dateAdded;

	public Student1(int id, String name, int age, String dateInString ) {
		this.ID = id;
		this.name = name;
		this.age = age;
		this.dateAdded = dateInString;
	}

	public int getID() {
		return ID;
	}

	public void setID(int rollno) {
		this.ID = rollno;
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

	public String getDate() {
		return dateAdded;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.ID + this.name.hashCode() + this.age;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Student1 s = (Student1) obj;
		return s.age == age && s.ID == ID && s.name.equals(name);
	}
}
