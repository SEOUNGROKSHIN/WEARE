package com.greedy.we.review.model.dto;

import java.util.List;

import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.review.model.dto.ReviewAttachmentDTO;

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
public class ReviewBoardDTO {

	private int travelNo;
	private int grade;
	private int reservationNo;
	private int no;
	private String type;
	private int categorycode;
	private String title;
	private String body;
	private int writerMemberNo;
	private java.sql.Date date;
	private java.sql.Date mDate;
	private String status;
	private MemberDTO writer;
	
	private List<ReviewAttachmentDTO> attachmentList;
	
}
