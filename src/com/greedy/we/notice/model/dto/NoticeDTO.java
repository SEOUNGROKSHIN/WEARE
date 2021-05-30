package com.greedy.we.notice.model.dto;

import java.sql.Date;

import com.greedy.we.member.model.dto.MemberDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
	
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NoticeDTO implements java.io.Serializable{
	
	private int no;
	private String title;
	private String body;
	private java.sql.Date date;
	private String category;
	private MemberDTO writer;
	private int boardWriter;
	
	
}	

	
	