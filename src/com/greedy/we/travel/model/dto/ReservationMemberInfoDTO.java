package com.greedy.we.travel.model.dto;

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
public class ReservationMemberInfoDTO {

	private ReservationDTO travelReservationNo;
	
	private String korFirstName;
	private String engFirstName;
	private String gender;
	private String phone;
	private String memberEmail;
	private java.sql.Date birth;
	
	private String personcount;

	
}
