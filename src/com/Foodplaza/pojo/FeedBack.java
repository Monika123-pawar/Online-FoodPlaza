package com.Foodplaza.pojo;

public class FeedBack {
public	FeedBack()
	{
		
	}
	private int feedid;
	private String feedback;
	private String name;
	private String cemail;
	public int getFeedid() {
		return feedid;
	}
	public void setFeedid(int feedid) {
		this.feedid = feedid;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	@Override
	public String toString() {
		return "FeedBack [feedid=" + feedid + ", feedback=" + feedback + ", name=" + name + ", cemail=" + cemail + "]";
	}
	
	
}
