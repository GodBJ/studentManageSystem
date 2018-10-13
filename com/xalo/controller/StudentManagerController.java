package com.xalo.controller;

import java.util.ArrayList;
import java.util.List;

import com.xalo.dao.impl.StudentManager;
import com.xalo.dao.inter.StuScoreManagerInterface;
import com.xalo.model.ScoreList;
import com.xalo.model.Student;
import com.xalo.model.Subject;

//学生及其成绩的控制类
public class StudentManagerController {
	
	private StuScoreManagerInterface stuDao = new StudentManager();
	
	/*
	 * 在view层调用 controller中的方法，controller 的方法中对view传递过来的数据进行判断，
	 * 如果数据没有问题，在controller的方法中 调用dao层的对应方法，将数据交给dao处理
	 */
	public List<ScoreList> getScoreByStudent(Student student) {
		if (student == null) {
			System.out.println("没有输入学生信息，无法查询");
			return null;
		}
		Student stu = stuDao.isExistsStudent(student);
		if ( stu == null || !stu.getName().equals(student.getName())) {
			System.out.println("没有该学生，无法查询成绩");
			return new ArrayList<ScoreList>();
		}
		
		return stuDao.getScoreByStudent(student);
	}

	public List<ScoreList> getScoreByStuNumber(int sn) {
		Student student = new Student();
		student.setSn(sn);
	    Student stu =	stuDao.isExistsStudent(student);
		if (stu == null) {
			//按照学号查找，没有该学生
			System.out.println("没有该学号的学生");
			return new ArrayList<ScoreList>();
		}
		return stuDao.getScoreByStuNumber(sn);
	}

	public Student changeNameByStuNumber(int sn,String newName) {
		
		
		return stuDao.changeNameByStuNumber(sn, newName);

	}

	public void changeScoreByNameAndSubject(String stuName, Subject subject, double newScore) {
		
		stuDao.changeScoreByNameAndSubject(stuName, subject, newScore);
	}

	public void deleteStudentAndSubject(Student student) {
		stuDao.deleteStudentAndSubject(student);

	}

	public void addStudentAndScore(Student student, double chinese, double math, double english) {
		/*
		 * 对提交过来的数据进行处理， 如果数据没有问题，就交给dao层
		 */

		if (student == null) {
			System.out.println("没有学生信息");
			return;
		} else if (null == student.getName() || "".equals(student.getName())) {
			System.out.println("姓名不能为空");
			return;
		}else if (stuDao.isExistsStudent(student) != null) {
			System.out.println("学生已存在");
			return;
		}
		//数据没有问题，交给dao层进行操作
		stuDao.addStudentAndScore(student, chinese, math, english);
	}
}




