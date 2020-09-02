package com.dxc.beans;

public class Exam {
	int id;
	String exam_name;
	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Exam(int id, String exam_name) {
		super();
		this.id = id;
		this.exam_name = exam_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExam_name() {
		return exam_name;
	}
	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}
	@Override
	public String toString() {
		return "Exam [id=" + id + ", exam_name=" + exam_name + "]";
	}

	
}
