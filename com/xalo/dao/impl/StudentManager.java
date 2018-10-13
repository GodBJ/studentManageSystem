package com.xalo.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.xalo.dao.inter.StuScoreManagerInterface;
import com.xalo.model.ScoreList;
import com.xalo.model.Student;
import com.xalo.model.Subject;

public class StudentManager implements StuScoreManagerInterface {

	//三个静态变量 集合类型 存储 学生 学科  成绩单
	public final static ArrayList<Student> STUDENTS = new ArrayList<>();
	public final static ArrayList<Subject> SUBJECTS = new ArrayList<>();
	public final static ArrayList<ScoreList> SCORELISTS = new ArrayList<>();
	
	static {
		  Subject chinese = new Subject(1, "语文");
		  SUBJECTS.add(chinese);
		  Subject math = new Subject(2, "数学");
		  SUBJECTS.add(math);
		  Subject english = new Subject(3, "英语");
		  SUBJECTS.add(english);
	}
	
	@Override
	public List<ScoreList> getScoreByStudent(Student student) {
		//学生的唯一标识符就是学号
		return this.getScoreByStuNumber(student.getSn());
	}

	@Override
	public List<ScoreList> getScoreByStuNumber(int sn) {
		//根据学号获取成绩单
		/*
		 * 遍历成绩单集合，
		 * 根据学号，找到对应的成绩单
		 * 将符合条件的成绩单添加进集合，
		 * 返回给controller
		 */
		ArrayList<ScoreList> list = new ArrayList<>();
		Iterator<ScoreList> iterator = SCORELISTS.iterator();
		while(iterator.hasNext()) {
			//获取集合中的成绩单
		    ScoreList sl =	iterator.next();
		    //获取该成绩单中的学生的学号
		    int num = sl.getStudent().getSn();
		    if (sn == num) {
		    	list.add(sl);
		    }
		}
		return list;
	}

	@Override
	public Student changeNameByStuNumber(int sn,String newName) {
		/*
		 * 遍历学生集合，
		 * 根据学号修改学生姓名
		 */
		Student student = null;
		for(Student stu : STUDENTS) {
			if (sn == stu.getSn()) {
				stu.setName(newName);
				student = stu;
				break;
			}
		}
		/*
		 * 修改成绩单中该学生的姓名
		 */
		for(ScoreList sl : SCORELISTS) {
			if (sn == sl.getStudent().getSn()) {
				sl.getStudent().setName(newName);
			}
		}
		return student;	
	}

	@Override
	public void changeScoreByNameAndSubject(String stuName, Subject subject, double newScore) {
		/*
		 * 遍历成绩单集合，修改对应学科的成绩
		 */
		for(ScoreList sl : SCORELISTS) {
			if (stuName.equals(sl.getStudent().getName())) {
				if (subject.getSubjectId() == sl.getSubject().getSubjectId()) {
					sl.setScore(newScore);
					System.out.println(stuName + subject.getSubjectName() + sl.getScore());
					break;
				}
			}
		}
		
	}

	@Override
	public void deleteStudentAndSubject(Student student) {
		//删除学生
		Iterator<Student> iterator =	STUDENTS.iterator();
		while(iterator.hasNext()) {
			Student stu = iterator.next();
			if(stu.getSn() == student.getSn()) {
				iterator.remove();
			}
		}
		// 删除学生成绩
		Iterator<ScoreList> iterator2 = SCORELISTS.iterator();
		while(iterator2.hasNext()) {
			ScoreList sl = iterator2.next();
			if(student.getSn() == sl.getStudent().getSn()) {
				iterator2.remove();
			}
		}
		
	}

	@Override
	public void addStudentAndScore(Student student, double chinese, double math, double english) {
		/*
		 * 由于该处理的代码已经在controller中书写完毕，
		 * dao层只负责数据的 CRUD
		 */
		STUDENTS.add(student);
		//为学生添加成绩单
		//语文成绩单
		ScoreList chineseScore = new ScoreList(student, SUBJECTS.get(0), chinese);
		//数学成绩单
		ScoreList mathScore = new ScoreList(student, SUBJECTS.get(1), math);
		//英语成绩单
		ScoreList englishScore = new ScoreList(student, SUBJECTS.get(2), english);
		
		SCORELISTS.add(chineseScore);
		SCORELISTS.add(mathScore);
		SCORELISTS.add(englishScore);
	}

	@Override
	public Student isExistsStudent(Student student) {
		//遍历学生集合，查找是否有该学生
		for(Student stu : STUDENTS) {
			if ( student.getSn() == stu.getSn()) {
				//该学生存在，返回学生信息
				return stu;
			}
		}
		//说明没有找到该学生
		return null;
	}
}





