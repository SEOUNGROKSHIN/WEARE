package com.greedy.we.board.model.dto;

import java.sql.Date;

public class AskDTO implements java.io.Serializable {
	
	
	private int no;
	private String title;
	private String category;
	private String body;
	private String pwd;
	private String status;
	private java.sql.Date askDate;
	private int travelno;
	private String answerbody;
	private int memberno;
	
	
	public AskDTO() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public java.sql.Date getAskDate() {
		return askDate;
	}

	public void setAskDate(java.sql.Date askDate) {
		this.askDate = askDate;
	}

	public int getTravelno() {
		return travelno;
	}

	public void setTravelno(int travelno) {
		this.travelno = travelno;
	}

	public String getAnswerbody() {
		return answerbody;
	}

	public void setAnswerbody(String answerbody) {
		this.answerbody = answerbody;
	}

	public int getMemberno() {
		return memberno;
	}

	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}

	public AskDTO(int no, String title, String category, String body, String pwd, String status, Date askDate,
			int travelno, String answerbody, int memberno) {
		super();
		this.no = no;
		this.title = title;
		this.category = category;
		this.body = body;
		this.pwd = pwd;
		this.status = status;
		this.askDate = askDate;
		this.travelno = travelno;
		this.answerbody = answerbody;
		this.memberno = memberno;
	}

	@Override
	public String toString() {
		return "AskDTO [no=" + no + ", title=" + title + ", category=" + category + ", body=" + body + ", pwd=" + pwd
				+ ", status=" + status + ", askDate=" + askDate + ", travelno=" + travelno + ", answerbody="
				+ answerbody + ", memberno=" + memberno + "]";
	}

	
}