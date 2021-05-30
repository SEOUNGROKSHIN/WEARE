package com.greedy.we.travel.model.dto;

import java.sql.Timestamp;
import java.util.Date;
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
public class ReservationDTO {

	private String travelReservationNo;
	private java.sql.Date travelReservationDate;
	private String travelName;
	private String travelIntro;
	private String travelCourse;
	private String traelInformation;
	private int memberNo;
	private int travelNo;
	private String reservationStatus;
	private java.sql.Date travelStartDate;
	private java.sql.Date travelEndDate;
	private int calculateNo;
	private int guideNo;
	private int travelCost;
	
	private String peoplecount;
	private List<MemberDTO> memberList;
	private List<TravelDTO> travelList;
	
	
	private ReservationStatusDTO status;
	
	
	private String guideName;
	private String guideEmail;
	private List<GuideInformationDTO> guideinfoList;
	
	
	private List<PaymentDTO> payList;
	private String paymentNo;
	private String paymentCategory;
	private Timestamp paymentDate;
	private String paymentStatus;
	private int paymentApproveNo;
	
	private List<ReservationMemberInfoDTO> reservationmemberList;

	private String korFirstName;
	private String korLastName;
	private String engFirstName;
	private String engLastName;
	private String gender;
	private String phone;
	private String memberEmail;
	private java.sql.Date birth;
	
    
	private List<TravelOptionDTO> traveloptionList;
	private String optionName;
	private int optionPrice;
	private int optionCode;
	private TravelOptionDTO option;
	
	private GuideRankDTO guideCommision;

	
	
	
	/*
	 * 
	 * private int travelReservationNo; 
	 * private java.sql.Date travelreservationdate;
	 * 
	 * private int memberNo; 
	 * private MemberDTO user;
	 * 
	 * private int travelNo; private TravelDTO travelProduct;
	 * 
	 * private String travelIntro; private TravelDTO traveltitle;
	 * 
	 * private String travelCourse; private TravelDTO course;
	 * 
	 * private int calculationNo;
	 * 
	 * private int guideNo; private MemberDTO guide;
	 * 
	 * private String guideName; private String guideEmail; private
	 * GuideInformationDTO guideinfo;
	 * 
	 * private ReservationStatusDTO reservationStatus;
	 * 
	 * private ReservationMemberInfoDTO phone;
	 * 
	 * private int paymentNo; private String paymentCategory; private PaymentDTO
	 * pay;
	 */
   
	
	
	
	
}
