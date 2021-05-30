package com.greedy.we.travel.model.dto;

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
public class PaymentDTO {
	
	private String paymentNo;
	private java.sql.Timestamp paymentDate;
	private String paymentCategory;
	private String paymentStatus;
	ReservationDTO reservation = new ReservationDTO();
	private long paymentApprovalNo;
	private String travelReservationNo;
	private MemberDTO customer;
	private int memberNo;
	private int calculateNo;
	
	
//	PAYMENT_NO, PAYMENT_DATE, PAYMENT_CATEGORY,
//	PAYMENT_STATUS, PAYMENT_APPROVAL_NO, TRAVEL_RESERVATION_NO, MEMBER_NO

}
