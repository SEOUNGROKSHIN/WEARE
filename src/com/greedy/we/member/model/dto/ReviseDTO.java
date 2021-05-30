package com.greedy.we.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter 

@Getter

@NoArgsConstructor

@AllArgsConstructor

@ToString
public class ReviseDTO {

	private java.sql.Date reviseDate;
	private String before;
	private String after;
	private String category;
	private MemberDTO no;
}

