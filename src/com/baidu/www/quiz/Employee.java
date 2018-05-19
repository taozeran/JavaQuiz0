package com.baidu.www.quiz;

import java.io.Serializable;
import java.util.Comparator;

public class Employee implements Serializable,Comparable<Employee>{
	private String employeeNumber;
	private String name;
	private gender gen; //性别
	private double pay; //工资
	/**
	 * @param employeeNum
	 * @param name2
	 * @param gen2
	 * @param pay2
	 */
	
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public Employee(String employeeNumber, String name, gender gen, double pay) {
		this.employeeNumber = employeeNumber;
		this.name = name;
		this.gen = gen;
		this.pay = pay;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public gender getGender() {
		return gen;
	}
	public void setGender(gender gen) {
		this.gen = gen;
	}
	public double getPay() {
		return pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " 姓名："+name+" 工号："+employeeNumber+" 性别："+gen.getGender()+" 薪水："+pay;
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		if(this.pay>o.pay){
			return 1;
		}else if(this.pay<o.pay){
			return -1;
		}else{
			return this.employeeNumber.compareTo(o.employeeNumber);
		}

	}
	
}

enum gender{
	male("男"),female("女");
	private gender(String gen){
		this.setGender(gen);
	}
	private String gen;
	public void setGender(String gen){
		this.gen = gen;
	}
	public String getGender(){
		return gen;
	}
}
