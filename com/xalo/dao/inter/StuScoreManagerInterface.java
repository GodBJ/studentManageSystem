package com.xalo.dao.inter;

import java.util.List;

import com.xalo.model.ScoreList;
import com.xalo.model.Student;
import com.xalo.model.Subject;

//对学生及其学生成绩进行操作的接口
public interface StuScoreManagerInterface {
	
	//获取指定学生的成绩
	public abstract List<ScoreList> getScoreByStudent(Student student);
	//获取指定学号的成绩
	public abstract List<ScoreList> getScoreByStuNumber(int sn);
	//根据学号修改姓名
	public abstract Student changeNameByStuNumber(int sn, String newName);
	//根据姓名修改指定学科的成绩
	public abstract void changeScoreByNameAndSubject(String stuName, Subject subject, double newScore);
	//删除指定学生及其成绩
	public abstract void deleteStudentAndSubject(Student student);
	//添加学生及其成绩
	public abstract void addStudentAndScore (Student student, double chinese, double math, double english);
	
	/*
	 * 判断学生是否存在，
	 * 如果存在，返回学生信息
	 * 不存在，返回null
	 */
	public abstract Student isExistsStudent(Student student);
	
}




