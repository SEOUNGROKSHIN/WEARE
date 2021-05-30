package com.greedy.we.review.model.dto;

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

public class ReviewAttachmentDTO implements java.io.Serializable {
	
	private int reviewno;
	private int rerefBoardNo;
	private String reoriginalName;
	private String resavedName;
	private String resavePath;
	private String refileType;
	private String rethumbnailPath;
	private String restatus;
	private int travelNo;
	
	
}
