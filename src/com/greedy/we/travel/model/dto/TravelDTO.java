package com.greedy.we.travel.model.dto;

import java.util.List;

import com.greedy.we.guide.model.dto.GuideInformationDTO;
import com.greedy.we.guide.model.dto.GuideRankDTO;
import com.greedy.we.member.model.dto.MemberDTO;

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
public class TravelDTO {

	private int travelNo;
	private int travelCost;
	private java.sql.Date travelStartDate;
	private java.sql.Date travelEndDate;
	private String travelIntro;
	private String travelCourse;
	private String travelInfromation;
	private java.sql.Date travelEnrollDate;
	private java.sql.Date travelChangeDate;
	private String travelEnrollStatus;
	private String travelSellStatus;
	private MemberDTO guideNo;
	private int travelMax;
	private String travelName;
	private String showStatus;
	private String travelSummery;
	
	private List<TravelOptionDTO> optionList;
	private List<TravelAttachmentDTO> attachmentList;
	
	private GuideInformationDTO guideRank;
	private GuideRankDTO guideCommision;
	private List<ReservationDTO> reservation;
	private String reservationStatus;
	private String reservationNo;
	private TravelHistoryDTO history;
	
	
}
