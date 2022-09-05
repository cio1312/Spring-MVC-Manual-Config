package com.springmvc.basics.entity;

import java.util.Date;

public class todo {

	private String title;
	private Date date;
	private String content;
	
	public todo(String title, Date date, String content) {
		super();
		this.title = title;
		this.date = date;
		this.content = content;
	}
	
	
	public todo() {
		// TODO Auto-generated constructor stub
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = (Date) date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "todo [title=" + title + ", date=" + date + ", content=" + content + "]";
	}


}
