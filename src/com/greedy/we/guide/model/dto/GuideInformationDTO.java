package com.greedy.we.guide.model.dto;

import java.sql.Date;
import java.util.List;

import com.greedy.we.member.model.dto.MemberDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class GuideInformationDTO {
	
	private int memberNo;
	private String guideName;
	private String guideEmail;
	private String guideBank;
	private String guideAccount;
	private String guideIntro;
	private String guideRank;
	private String guideStatus;
	private int guideWarningCount;
	private java.sql.Date enRollDate;
	private String guideApprove;
	
	private List<AttachmentDTO> attachmentList;

	public GuideInformationDTO() {}

	public GuideInformationDTO(int memberNo, String guideName, String guideEmail, String guideBank, String guideAccount,
			String guideIntro, String guideRank, String guideStatus, int guideWarningCount, Date enRollDate,
			String guideApprove, List<AttachmentDTO> attachmentList) {
		super();
		this.memberNo = memberNo;
		this.guideName = guideName;
		this.guideEmail = guideEmail;
		this.guideBank = guideBank;
		this.guideAccount = guideAccount;
		this.guideIntro = guideIntro;
		this.guideRank = guideRank;
		this.guideStatus = guideStatus;
		this.guideWarningCount = guideWarningCount;
		this.enRollDate = enRollDate;
		this.guideApprove = guideApprove;
		this.attachmentList = attachmentList;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public String getGuideName() {
		return guideName;
	}

	public String getGuideEmail() {
		return guideEmail;
	}

	public String getGuideBank() {
		return guideBank;
	}

	public String getGuideAccount() {
		return guideAccount;
	}

	public String getGuideIntro() {
		return guideIntro;
	}

	public String getGuideRank() {
		return guideRank;
	}

	public String getGuideStatus() {
		return guideStatus;
	}

	public int getGuideWarningCount() {
		return guideWarningCount;
	}

	public java.sql.Date getEnRollDate() {
		return enRollDate;
	}

	public String getGuideApprove() {
		return guideApprove;
	}

	public List<AttachmentDTO> getAttachmentList() {
		return attachmentList;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}

	public void setGuideEmail(String guideEmail) {
		this.guideEmail = guideEmail;
	}

	public void setGuideBank(String guideBank) {
		this.guideBank = guideBank;
	}

	public void setGuideAccount(String guideAccount) {
		this.guideAccount = guideAccount;
	}

	public void setGuideIntro(String guideIntro) {
		this.guideIntro = guideIntro;
	}

	public void setGuideRank(String guideRank) {
		this.guideRank = guideRank;
	}

	public void setGuideStatus(String guideStatus) {
		this.guideStatus = guideStatus;
	}

	public void setGuideWarningCount(int guideWarningCount) {
		this.guideWarningCount = guideWarningCount;
	}

	public void setEnRollDate(java.sql.Date enRollDate) {
		this.enRollDate = enRollDate;
	}

	public void setGuideApprove(String guideApprove) {
		this.guideApprove = guideApprove;
	}

	public void setAttachmentList(List<AttachmentDTO> attachmentList) {
		this.attachmentList = attachmentList;
	}

	@Override
	public String toString() {
		return "GuideInformationDTO [memberNo=" + memberNo + ", guideName=" + guideName + ", guideEmail=" + guideEmail
				+ ", guideBank=" + guideBank + ", guideAccount=" + guideAccount + ", guideIntro=" + guideIntro
				+ ", guideRank=" + guideRank + ", guideStatus=" + guideStatus + ", guideWarningCount="
				+ guideWarningCount + ", enRollDate=" + enRollDate + ", guideApprove=" + guideApprove
				+ ", attachmentList=" + attachmentList + "]";
	}

}
