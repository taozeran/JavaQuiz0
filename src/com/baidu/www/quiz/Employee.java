package com.baidu.www.quiz;

public class Employee {
	private long employeeNumber;
	private String name;
	private gender gen; //�Ա�
	private double pay; //����
	public long getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(long employeeNumber) {
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
		return "������"+name+"���ţ�"+employeeNumber+"�Ա�"+gen.getGender()+"нˮ��"+pay;
	}
}

enum gender{
	male("��"),female("Ů");
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