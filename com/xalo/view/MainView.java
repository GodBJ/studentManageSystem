package com.xalo.view;

import java.util.List;
import java.util.Scanner;

import com.xalo.controller.StudentManagerController;
import com.xalo.model.ScoreList;
import com.xalo.model.Student;
import com.xalo.model.Subject;

public class MainView {
	// 界面的入口方法
	public void mainView() {
		System.out.println("********学生成绩分析系统*********");
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("请选择要做的操作:1.根据学生获取学生成绩 2.根据学号获取学生成绩 3.添加学生及其各科成绩 4.根据学号修改学生姓名 5.根据姓名修改指定学科的成绩 6.删除指定学生及其成绩");
			int select = sc.nextInt();
			StudentManagerController controller = new StudentManagerController();
			switch (select) {
			case 1: {
				// 根据学生查询成绩
				System.out.println("请输入学号:");
				int num = sc.nextInt();
				System.out.println("请输入学生姓名:");
				String name = sc.next();
				List<ScoreList> list = controller.getScoreByStudent(new Student(num, name));
				for (ScoreList sl : list) {
					System.out.println(sl.getSubject().getSubjectName() + "\t" + sl.getScore());
				}
			}
				break;
			case 2: {
				// 根据学号查询成绩
				System.out.println("请输入学号:");
				int num = sc.nextInt();
				List<ScoreList> scoreLists = controller.getScoreByStuNumber(num);
				for (ScoreList sl : scoreLists) {
					System.out.println(sl.getSubject().getSubjectName() + "\t" + sl.getScore());
				}
			}
				break;
			case 3: {
				// 添加学生及其成绩
				System.out.println("请输入学生姓名:");
				String name = sc.next();
				System.out.println("请输入学生学号:");
				int num = sc.nextInt();
				System.out.println("请输入语文成绩:");
				double chinese = sc.nextDouble();
				System.out.println("请输入数学成绩:");
				double math = sc.nextDouble();
				System.out.println("请输入英语成绩:");
				double english = sc.nextDouble();
				// 调用controller的添加学生的方法
				controller.addStudentAndScore(new Student(num, name), chinese, math, english);
			}
				break;
			case 4: {
				// 根据学号修改姓名
				System.out.println("请输入学号");
				int num = sc.nextInt();
				System.out.println("请输入新姓名");
				String name = sc.next();
				Student student = controller.changeNameByStuNumber(num, name);
				System.out.println(student);
			}
				break;
			case 5:{
				  System.out.println("请输入姓名:");
				  String name = sc.next();
				  System.out.println("请输入学科名称:");
				  String subjectName = sc.next();
				  System.out.println("请输入学科编号:");
				  int subjectId = sc.nextInt();
				  System.out.println("请输入新成绩:");
				  double newScore = sc.nextDouble();
				  controller.changeScoreByNameAndSubject(name, new Subject(subjectId, subjectName), newScore);
			}
				 break;
			case 6: {
				System.out.println("请输入学号");
				int num = sc.nextInt();
				System.out.println("请输入姓名");
				String name = sc.next();
				controller.deleteStudentAndSubject(new Student(num,name));
			}
			
			default:
				System.out.println("输入的功能不存在");
				break;
			}
		}
	}
}
