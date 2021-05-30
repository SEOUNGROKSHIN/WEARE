package com.greedy.we.guide.model.dto;

public class AttachmentDTO implements java.io.Serializable {
	
	private int no;
	private int memberNo;
	private String originalName;
	private String savedName;
	private String savePath;
	private String fileType;
	private String thumbnailPath;
	private String status;
	
	public AttachmentDTO() {}

	public AttachmentDTO(int no, int memberNo, String originalName, String savedName, String savePath, String fileType,
			String thumbnailPath, String status) {
		super();
		this.no = no;
		this.memberNo = memberNo;
		this.originalName = originalName;
		this.savedName = savedName;
		this.savePath = savePath;
		this.fileType = fileType;
		this.thumbnailPath = thumbnailPath;
		this.status = status;
	}

	public int getNo() {
		return no;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public String getOriginalName() {
		return originalName;
	}

	public String getSavedName() {
		return savedName;
	}

	public String getSavePath() {
		return savePath;
	}

	public String getFileType() {
		return fileType;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public String getStatus() {
		return status;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AttachmentDTO [no=" + no + ", memberNo=" + memberNo + ", originalName=" + originalName + ", savedName="
				+ savedName + ", savePath=" + savePath + ", fileType=" + fileType + ", thumbnailPath=" + thumbnailPath
				+ ", status=" + status + "]";
	}

	

	 
}
