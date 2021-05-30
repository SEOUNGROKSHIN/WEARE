package com.greedy.we.notice.model.service;

import static com.greedy.we.common.JDBC.JDBCTemplate.close;
import static com.greedy.we.common.JDBC.JDBCTemplate.commit;
import static com.greedy.we.common.JDBC.JDBCTemplate.getConnection;
import static com.greedy.we.common.JDBC.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.greedy.we.notice.model.dao.NoticeDAO;
import com.greedy.we.notice.model.dto.NoticeDTO;


public class NoticeService {
	
	private final NoticeDAO noticeDAO;
	
	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}
	
	/* 공지사항 전체 목록 조회용 메소드 */
	public List<NoticeDTO> selectAllNoticeList() {
		
		Connection con = getConnection();
		
		List<NoticeDTO> noticeList = noticeDAO.selectAllNoticeList(con);
		
		close(con);
		
		return noticeList;
	}

	public int insertNotice(NoticeDTO newNotice) {
		
		Connection con = getConnection();
		
		int result = noticeDAO.insertNotice(con, newNotice);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		return result;
	}
	
	public NoticeDTO selectNoticeDetail(int no) {
		
		Connection con = getConnection();		
		NoticeDTO noticeDetail = null;		
		
		 noticeDetail = noticeDAO.selectNoticeDetail(con, no);
			
		if(noticeDetail != null) {
			commit(con);
		} else {
			rollback(con);
		}		
		return noticeDetail;
	}

	public NoticeDTO selectNoticeForUpdate() {
		
		Connection con = getConnection();
		
		NoticeDTO noticeSelect = noticeDAO.selectNoticeUpdate(con);
		
		close(con);
		
		return noticeSelect;
	}

	public int updateNotice(NoticeDTO noticeUpdate) {
		
		Connection con = getConnection();
		
		int result = noticeDAO.updateNotice(con, noticeUpdate);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		
		return result;
	}

	public int deleteNotice(int memNo) {
		
		Connection con = getConnection();
		
		int result = noticeDAO.deleteNotice(con);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}




	

	
	

	
