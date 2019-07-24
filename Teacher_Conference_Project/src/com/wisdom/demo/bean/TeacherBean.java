package com.wisdom.demo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.wisdom.demo.manager.TeacherManager;
import com.wisdom.demo.pojo.Teacher;


@ManagedBean(name = "teacherBean")
@ViewScoped

public class TeacherBean {

	private Teacher teacher = new Teacher();
	private List<Teacher> teachers = new ArrayList<Teacher>(0);
	//private List<Teacher> selectedTeachers = new ArrayList<Teacher>(0);
	
	public TeacherBean() {
		TeacherManager tc = new TeacherManager();
		teachers = tc.loadTeacher();
	}
	
	
	
	public void submitData() {
		
		TeacherManager teachermanager = new TeacherManager();
		boolean state = teachermanager.saveTeacherData(teacher);
		
		if (state) {
			System.out.println("Teacher Successfully Saved");
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "", " Teacher Successfully Saved"));
		} else {
			System.out.println("Error...");
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", " Operation Fail"));
		}
			
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	
	
}
