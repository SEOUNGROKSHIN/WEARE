package com.greedy.we.member.model.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greedy.we.member.model.dao.MemberDAO;
import com.greedy.we.member.model.dto.MemberDTO;
import static com.greedy.we.common.JDBC.JDBCTemplate.getConnection;
import static com.greedy.we.common.JDBC.JDBCTemplate.commit;
import static com.greedy.we.common.JDBC.JDBCTemplate.rollback;
import static com.greedy.we.common.JDBC.JDBCTemplate.commit;
import static com.greedy.we.common.JDBC.JDBCTemplate.rollback;
import static com.greedy.we.common.JDBC.JDBCTemplate.close;


public class MemberService {
	
	private final MemberDAO memberDAO;
	
	public MemberService() {
		memberDAO = new MemberDAO();
	}
	public int registMember(MemberDTO memberDTO) {
		Connection con = getConnection();
		int result = memberDAO.insertOneMember(con,memberDTO);
		if(result > 0 ) {
			commit(con);
		}else {
			rollback(con);
		}
		
		
		close(con);
		return result;
	}
	
	public MemberDTO logincheck(MemberDTO memberDTO) {
		
		Connection con = getConnection();
		MemberDTO loginMember = null;
		
		/* 1. DB에 저장된 회원 아이디와 일치하는 회원의 비밀번호 조회 */
		String encPwd = memberDAO.selectEncryptPwd(con, memberDTO);
		
		System.out.println("");
		/* 2. 파라미터로 전달받은 비밀번호와 DB에 저장된 비밀번호가 일치하는지 확인 */
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(memberDTO.getPwd(), encPwd)) {
			/* 3. 비밀번호가 일치하면 회원 정보 조회 */
			loginMember = memberDAO.selectLoginMember(con, memberDTO);
		}
		
		close(con);
		
		return loginMember;
	}
	
	/* 회원 탈퇴 메소드 <한미화>*/
	public int delteMember(MemberDTO requestMember) {

		Connection con = getConnection();
		
		int result = 0;
		
		String encPwd = memberDAO.selectEncryptPwd(con, requestMember);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(requestMember.getPwd(), encPwd)) {
			
			result = memberDAO.delteMember(con, requestMember);
		}
		
		if(result > 0) {
			commit(con);
			System.out.println("서비스 왔고! 커밋 완료되찌렁~");
		} else {
			rollback(con);
			System.out.println("서비스 왔는데!! 롤백이다;;");
		}
		
		close(con);
		
		return result;
	}
	
	/* 정보수정 찐탱! 메소드<한미화> */
	public MemberDTO updateMember(MemberDTO memberDTO) {

		Connection con = getConnection();
		
		MemberDTO changedMember = null;
		
		int result = memberDAO.updateMember(con, memberDTO);
		
		System.out.println(result);
		
		changedMember = memberDAO.selectLoginMember(con, memberDTO);
		
		System.out.println(changedMember);
		
		if(result > 0) {
			commit(con);
			System.out.println("정보수정 찐탱 커밋완료");
		} else {
			rollback(con);
			System.out.println("정보수정 찐탱 롤백!!!!실패");
		}
		
		close(con);
		
		return changedMember;
	}
	
	/* 비밀번호 변경 <한미화> */
	public MemberDTO pwdUpdate(MemberDTO changePwd) {

		Connection con = getConnection();
		
		MemberDTO changedPwd = null;
		
		/* DB에 저장된 회원 아이디와 일치하는 회원의 비밀번호 조회 */
		String encPwd = memberDAO.selectEncryptPwd(con, changePwd);
		/* 비밀번호가 일치하면 회원정보 수정 */
		int result = memberDAO.pwdUpdate(con, changePwd);
		/* 성공하면 회원 정보 조회 */
		changedPwd = memberDAO.selectLoginMember(con, changePwd);
		
		if(result > 0) {
			commit(con);
			System.out.println("정보수정 찐탱 커밋완료");
		} else {
			rollback(con);
			System.out.println("정보수정 찐탱 롤백!!!!실패");
		}
		
		close(con);
		
		return changedPwd;
	}
		
	/* 가이드 취소 <한미화> */
	public int deleteGuide(MemberDTO member) {
			
		Connection con = getConnection();
		
		int result = 0;
		
		/* DB에 저장된 회원 아이디와 일치하는 회원의 비밀번호 조회 */
		String encPwd = memberDAO.selectEncryptPwd(con, member);
		
		/* 전달 받은 비밀번호와 DB 비밀번호가 일치하는지 확인 */
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(member.getPwd(), encPwd)) {
		
			/* 비밀번호가 일치하면 회원 정보 수정 */
			result = memberDAO.deleteGuide(con, member);
			
		}
			
		if(result > 0) {
			commit(con);
			System.out.println("서비스 왔고! 커밋 완료되찌렁~");
		} else {
			rollback(con);
			System.out.println("서비스 왔는데!! 롤백이다;;");
		}
			
		close(con);
		
		return result;
	}
	
	/* 회원 정보 수정하기 위한 체크 <한미화> */
	public MemberDTO memberCheck(MemberDTO memberCheck) {

		Connection con = getConnection();
		
		MemberDTO memberChecked = null;
		
		String encPwd = memberDAO.selectEncryptPwd(con, memberCheck);
		
		/* 성공하면 회원 정보 조회 */
		memberChecked = memberDAO.memberCheck(con, memberCheck);
		
		if(memberChecked != null) {
			commit(con);
			System.out.println("정보수정 찐탱 커밋완료");
		} else {
			rollback(con);
			System.out.println("정보수정 찐탱 롤백!!!!실패");
		}
		
		return memberChecked;
	}
	
	
	/* 관리자 회원 리스트 조회 <한미화> */
	public List<MemberDTO> selectAllMemberList() {

		Connection con = getConnection();
		
		List<MemberDTO> memberList = memberDAO.selectAllMemberList(con);
		
		System.out.println("서비스라고!!!!");
		close(con);
		
		return memberList;
	}
	
	/* 관리자 탈퇴 회원 조회 리스트 <한미화> */
	public List<MemberDTO> selectNoMemberList() {
		
		Connection con = getConnection();
		
		List<MemberDTO> memberList = memberDAO.selectNoMemberList(con);
		
		System.out.println("서비스라고!!!!");
		close(con);
		
		return memberList;
	}
	
	public MemberDTO checkMemberToNickName(MemberDTO member) {
		Connection con = getConnection();
		MemberDTO findMember = memberDAO.selectMemberNickNameEmail(con, member);
		
		close(con);
		return findMember;
	}
	public MemberDTO checkMemberToIdEmail(MemberDTO member) {
		Connection con = getConnection();
		MemberDTO findMember = memberDAO.selectMemberIdEmail(con, member);
		
	
		
		close(con);
		return findMember;
	}
	public int resetPwd(MemberDTO member) {
		Connection con = getConnection();
		int result = 0;
		
		result =  memberDAO.resetPwd(con, member);
		
		close(con);
		return result;
	}
	


}
