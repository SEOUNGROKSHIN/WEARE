package com.greedy.we.member.model.dao;

import static com.greedy.we.common.JDBC.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.greedy.we.common.config.ConfigLocation;
import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.member.model.dto.ReviseDTO;

public class MemberDAO {
	 private final Properties prop;

	
	 public MemberDAO() {
	      prop = new Properties();
	      
	      try {
	         prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "member/member-mapper.xml"));
	         
	         
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      
	   }

	 // 회원 정보를 전달하여, 한명의 회원을 추가하는 메소드
	public int insertOneMember(Connection con, MemberDTO memberDTO) {
		PreparedStatement pstmt = null;
		   
		int result = 0;
		String query = prop.getProperty("insertMember");
		
		
		try {
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, memberDTO.getId());
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getNickname());
			pstmt.setString(4, memberDTO.getPhone());
			pstmt.setString(5, memberDTO.getEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		   
	      return result;
	}

	// 회원 정보를 전달하여, 비밀번호를 가져오는 메소드
	public String selectEncryptPwd(Connection con, MemberDTO memberDTO) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String encpwd = null;
		String query = prop.getProperty("selectEncryptPwd");
		
		try {			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberDTO.getId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				encpwd = rset.getString("MEMBER_PWD");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return encpwd;
	}

	public MemberDTO selectLoginMember(Connection con, MemberDTO memberDTO) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO loginMember = null;
		String query = prop.getProperty("selectLoginMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberDTO.getId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginMember = new MemberDTO();
				loginMember.setNo(rset.getInt("MEMBER_NO"));
				loginMember.setId(rset.getString("MEMBER_ID"));
				loginMember.setNickname(rset.getString("MEMBER_NICKNAME"));
				loginMember.setEmail(rset.getString("MEMBER_EMAIL"));
				loginMember.setRole(rset.getString("MEMBER_ROLE"));
				loginMember.setStatus(rset.getString("MEMBER_STATUS"));
				loginMember.setEnrollDate(rset.getDate("MEMBER_ENROLLDATE"));
				loginMember.setPhone(rset.getString("MEMBER_PHONE"));
		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return loginMember;
	}
	
	/* 회원정보 찐탱 수정 <한미화> */
	public int updateMember(Connection con, MemberDTO changeInfo) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, changeInfo.getNickname());
			pstmt.setString(2, changeInfo.getPhone());
			pstmt.setString(3, changeInfo.getEmail());
			pstmt.setInt(4, changeInfo.getNo());
			
			result = pstmt.executeUpdate();
			System.out.println("DAO :" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/* 회원 탈퇴 <한미화> */
	public int delteMember(Connection con, MemberDTO requestMember) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("delteMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, requestMember.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	

	// 아이디와 이메일을 통해 멤버를 조회하는 DAO
	public MemberDTO selectMemberIdEmail(Connection con, MemberDTO member) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO checkMember = null;
		
		
		String query = prop.getProperty("selectMemberIdEmail");
		
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getEmail());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				checkMember = new MemberDTO();
				checkMember.setNo(rset.getInt("MEMBER_NO"));
				checkMember.setId(rset.getString("MEMBER_ID"));
				checkMember.setNickname(rset.getString("MEMBER_NICKNAME"));
				checkMember.setEmail(rset.getString("MEMBER_EMAIL"));
				checkMember.setRole(rset.getString("MEMBER_ROLE"));
				checkMember.setStatus(rset.getString("MEMBER_STATUS"));
				checkMember.setEnrollDate(rset.getDate("MEMBER_ENROLLDATE"));
				checkMember.setPhone(rset.getString("MEMBER_PHONE"));
		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return checkMember;
	}
		
	//닉네임으로 멤버를 조회하는 DAO
	public MemberDTO selectMemberNickNameEmail(Connection con, MemberDTO member) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO checkMember = null;
		
		
		String query = prop.getProperty("selectMemberNickNameEmail");
		
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getNickname());
			pstmt.setString(2, member.getEmail());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				checkMember = new MemberDTO();
				checkMember.setNo(rset.getInt("MEMBER_NO"));
				checkMember.setId(rset.getString("MEMBER_ID"));
				checkMember.setNickname(rset.getString("MEMBER_NICKNAME"));
				checkMember.setEmail(rset.getString("MEMBER_EMAIL"));
				checkMember.setRole(rset.getString("MEMBER_ROLE"));
				checkMember.setStatus(rset.getString("MEMBER_STATUS"));
				checkMember.setEnrollDate(rset.getDate("MEMBER_ENROLLDATE"));
				checkMember.setPhone(rset.getString("MEMBER_PHONE"));
		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return checkMember;
	}
	
	//비밀번호를 업데이트 하는 DAO
	public int updatePwd(Connection con, MemberDTO member) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updatePwd");
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		return result;
	}
	
	/* 비밀번호 변경 <한미화> */
	public int pwdUpdate(Connection con, MemberDTO changePwd) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("pwdUpdate");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, changePwd.getPwd());
			pstmt.setInt(2, changePwd.getNo());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	/* 가이드 취소 <한미화> */
	public int deleteGuide(Connection con, MemberDTO member) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("deleteGuide");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, member.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteRole(Connection con, MemberDTO member) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("deleteRole");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, member.getNo());
			pstmt.setString(2, member.getRole());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/* 정보수정 확인용 <한미화> */
	public MemberDTO memberCheck(Connection con, MemberDTO memberCheck) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
	
		
		String query = prop.getProperty("memberCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberCheck.getNo());
			
			
			rset = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return memberCheck;
	}
	
	/* 관리자 회원리스트 조회 <한미화> */
	public List<MemberDTO> selectAllMemberList(Connection con) {

		Statement stmt = null;
		ResultSet rset = null;
		
		List<MemberDTO> memberList = null;
		
		String query = prop.getProperty("selectAllMemberList");
		
		
			try {
				stmt = con.createStatement();
				rset = stmt.executeQuery(query);
				
				memberList = new ArrayList<>();
				
				while(rset.next()) {
					MemberDTO member = new MemberDTO();
					
					member.setNo(rset.getInt("MEMBER_NO"));
					member.setId(rset.getString("MEMBER_ID"));
					member.setNickname(rset.getString("MEMBER_NICKNAME"));
					member.setEmail(rset.getString("MEMBER_EMAIL"));
					member.setPhone(rset.getString("MEMBER_PHONE"));
					member.setStatus(rset.getString("MEMBER_STATUS"));
					member.setRole(rset.getString("MEMBER_ROLE"));
					member.setEnrollDate(rset.getDate("MEMBER_ENROLLDATE"));
				
					memberList.add(member);
					
					System.out.println("DAO 오캉?");
				}
					
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(stmt);
			}
			
		return memberList;
	}

	/* 관리자 탈퇴 회원 리스트 <한미화> */
	public List<MemberDTO> selectNoMemberList(Connection con) {

		Statement stmt = null;
		ResultSet rset = null;
		
		List<MemberDTO> memberList = null;
		
		String query = prop.getProperty("selectNoMemberList");
		
			try {
				stmt = con.createStatement();
				rset = stmt.executeQuery(query);
				
				memberList = new ArrayList<>();
				
				while(rset.next()) {
					MemberDTO member = new MemberDTO();
					
					member.setNo(rset.getInt("MEMBER_NO"));
					member.setId(rset.getString("MEMBER_ID"));
					member.setNickname(rset.getString("MEMBER_NICKNAME"));
					member.setEmail(rset.getString("MEMBER_EMAIL"));
					member.setPhone(rset.getString("MEMBER_PHONE"));
					member.setStatus(rset.getString("MEMBER_STATUS"));
					member.setRole(rset.getString("MEMBER_ROLE"));
					member.setEnrollDate(rset.getDate("MEMBER_ENROLLDATE"));
				
					memberList.add(member);
					
					System.out.println("DAO 오캉?");
				}
					
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(stmt);
			}
			
		return memberList;
		
	}

	public int resetPwd(Connection con, MemberDTO member) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("resetPwd");
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		return result;
	}

	

	

}
