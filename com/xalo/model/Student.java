package com.xalo.model;

//实体类: 数据模型 不做具体的业务处理
//学生
public class Student {
	private int sn; // 学号
	private String name; // 学生姓名

	public Student() {

	}

	public Student(int sn, String name) {

		this.sn = sn;
		this.name = name;
	}

	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [sn=" + sn + ", name=" + name + "]";
	}
}
