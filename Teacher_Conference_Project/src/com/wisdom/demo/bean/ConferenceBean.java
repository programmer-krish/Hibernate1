package com.wisdom.demo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.wisdom.demo.manager.ConferenceManager;
import com.wisdom.demo.pojo.Conference;

@ManagedBean(name = "confBean")
@ViewScoped

public class ConferenceBean {
	
	private Conference conference = new Conference();
	private List<Conference> confs = new ArrayList<Conference>(0);
	
	public ConferenceBean() {
		ConferenceManager cm = new ConferenceManager();
		confs = cm.loadConference();
	}
	
	
	public void submitData() {
		ConferenceManager conferencemanager = new ConferenceManager();
		boolean state = conferencemanager.saveConferenceData(conference);
		
		if (state) {
			System.out.println("Conference Successfully Saved");
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "", " Conference Successfully Saved"));
		} else {
			System.out.println("Error...");
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", " Operation Fail"));
		}
	}




	public Conference getConference() {
		return conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}

	public List<Conference> getConfs() {
		return confs;
	}
	
	public void setConfs(List<Conference> confs) {
		this.confs = confs;
	}
	
	

}
