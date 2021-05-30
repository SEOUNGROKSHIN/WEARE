package com.greedy.we.review.model.service;

import java.sql.Connection;
import java.util.List;
import static com.greedy.we.common.JDBC.JDBCTemplate.getConnection;
import static com.greedy.we.common.JDBC.JDBCTemplate.close;
import static com.greedy.we.common.JDBC.JDBCTemplate.rollback;
import static com.greedy.we.common.JDBC.JDBCTemplate.commit;

import com.greedy.we.review.model.dao.BoardDAO;
import com.greedy.we.review.model.dto.ReviewAttachmentDTO;
import com.greedy.we.review.model.dto.ReviewBoardDTO;
public class BoardService {

	private final BoardDAO boardDAO;

	public BoardService() {
		boardDAO = new BoardDAO();

	}

	public int insertThumbnail(ReviewBoardDTO thumbnail) {

		Connection con = getConnection();

		int result = 0;

		int boardResult = boardDAO.insertThumbnailContent(con, thumbnail);

		int boardNo = boardDAO.selectThumbnailSequence(con);

		List<ReviewAttachmentDTO> fileList = thumbnail.getAttachmentList();
		for(int i = 0; i < fileList.size(); i++) {
			fileList.get(i).setReviewno(boardNo);
		}

		int attachmentResult = 0;
		for(int i = 0; i < fileList.size(); i++) {
			attachmentResult += boardDAO.insertAttachment(con, fileList.get(i));
		}

		if(boardResult > 0 && attachmentResult == fileList.size()) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}

		close(con);

		return result;
	}

	public List<ReviewBoardDTO> selectThumbnailList() {
		
		Connection con = getConnection();

		List<ReviewBoardDTO> thumbnailList = boardDAO.selectThumbnailList(con);

		close(con);

		return thumbnailList;
	}


}
