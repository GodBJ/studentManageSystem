package com.xalo.model;

//成绩单
public class ScoreList {

	private Student student; // 学生
	private Subject subject; // 学科
	private double score; // 成绩

	public ScoreList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScoreList(Student student, Subject subject, double score) {
		super();
		this.student = student;
		this.subject = subject;
		this.score = score;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "ScoreList [student=" + student + ", subject=" + subject + ", score=" + score + "]";
	}

}
