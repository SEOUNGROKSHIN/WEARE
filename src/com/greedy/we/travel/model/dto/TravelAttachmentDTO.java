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

public class TravelAttachmentDTO {
	
	private int no;
	private int travelNo;
	private String originalName;
	private String savedName;
	private String savePath;
	private String fileType;
	private String thumbnailPath;
	private String attachmentStatus;
	

}
