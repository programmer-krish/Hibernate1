package com.wisdom.demo.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONFERENCE")

public class Conference {
	
	@Id
	@Column(name = "seq_no")
	private Integer seqNo;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "desc")
	private String desc;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "end_time")
	private Date endtime;
	
	@Column(name = "start_time")
	private Date starttime;
	
	public Conference() {
		
	}

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	
	
}
