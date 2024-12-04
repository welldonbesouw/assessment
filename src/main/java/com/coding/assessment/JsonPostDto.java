package com.coding.assessment;

public class JsonPostDto {
	private int id;
	private int userid;
	private String title;
	private String body;
	private int titleLength;
	
	public JsonPostDto(int id, int userid, String title, String body, int titleLength) {
		super();
		this.id = id;
		this.userid = userid;
		this.title = title;
		this.body = body;
		this.titleLength = titleLength;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getTitleLength() {
		return titleLength;
	}
	public void setTitleLength(int titleLength) {
		this.titleLength = titleLength;
	}
	
	
}
