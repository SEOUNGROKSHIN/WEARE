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
public class ReservationStatusDTO {

	private String reservationing;
	private String travelStart;
	private String travelEnd;
	private String confirmPurchase;
	private int travelReservationNo;
	private ReservationDTO reservation;
	
}
