package com.pivotal.q1.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
	@XmlElement
	@Size(min=5)
	private String	name;
	@XmlElement
	@Max(10)
	private int		age;
	
	public Customer ()	{};
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
		return "Customer [name=" + name + ", age=" + age + "]";
	}
	
}
