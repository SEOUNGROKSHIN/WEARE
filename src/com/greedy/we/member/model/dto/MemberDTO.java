package com.greedy.we.member.model.dto;

import java.sql.Date;

public class MemberDTO {
	
	private int no;
	private String id;
	private String pwd;
	private String nickname;
	private String email;
	private String phone;
	private String status;
	private String role;
	private java.sql.Date enrollDate;
	private ReviseDTO modifyDate;
	private String writerMemberNo;

	public MemberDTO() {}

	public MemberDTO(int no, String id, String pwd, String nickname, String email, String phone, String status,
			String role, Date enrollDate, ReviseDTO modifyDate) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.role = role;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
	}

	public int getNo() {
		return no;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getStatus() {
		return status;
	}

	public String getRole() {
		return role;
	}

	public java.sql.Date getEnrollDate() {
		return enrollDate;
	}

	public ReviseDTO getModifyDate() {
		return modifyDate;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setEnrollDate(java.sql.Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public void setModifyDate(ReviseDTO modifyDate) {
		modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "MemberDTO [no=" + no + ", id=" + id + ", pwd=" + pwd + ", nickname=" + nickname + ", email=" + email
				+ ", phone=" + phone + ", status=" + status + ", role=" + role + ", enrollDate=" + enrollDate
				+ ", modifyDate=" + modifyDate + "]";
	}

	

	

	
	
	
	
}
