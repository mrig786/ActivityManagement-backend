package com.mrig.rest.webservices.restfulwebservices.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {

	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String desc;
	private Date targetDate;
	private boolean isDone;
	public Todo() {
	}
	public Todo(Long id, String username, String desc, Date targetDate, boolean isDone) {
		super();
		this.id = id;
		this.username = username;
		this.desc = desc;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", desc=" + desc + ", targetDate=" + targetDate
				+ ", isDone=" + isDone + "]";
	}
	
	
}
