<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		(function() {
			const successCode = "${ requestScope.successCode }";
			
			let successMessage = "";
			let movePath = "";
			
			switch(successCode) {
				case "updateMember" : 
					successMessage = "회원 정보가 수정 되었습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/member/mypage";
					break;
				case "pwdUpdate" : 
					successMessage = "비밀번호가 변경 되었습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/member/mypage";
					break;
				case "deleteMember" : 
					successMessage = "회원 탈퇴가 완료 되었습니다.";
					movePath = "${ pageContext.servletContext.contextPath }";
					break;
				case "deleteGuide" : 
					successMessage = "일반 회원으로 변경 되었습니다.";
					movePath = "${ pageContext.servletContext.contextPath }";
					break;
				case "memberCheck" : 
					successMessage = "회원 정보를 수정 할 수 있습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/member/update";
					break;
				case "approveGuie" : 
					successMessage = "가이드 승인에 동의 하셨습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/admin/signUpGuideList";
					break;
				case "insertNotice" :
					successMessage = "공지사항 등록에 성공 했습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/notice/list";
					break;
				case "insertAsk" :	
					successMessage = "문의 등록에 성공!!";
					movePath = "${ pageContext.servletContext.contextPath }/board/querylist";
					break;
					
				case "insertThumbnail" :
					successMessage = "가이드 신청 등록에 성공 했습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/member/mypage";
					break;
						
				case "insertReview" :
					successMessage = "리뷰 등록에 성공 했습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/review/list";
					break;
					
				case "updateNotice" :
					successMessage = "공지사항 수정에 성공 했습니다."
					movePath = "${ pageContext.servletContext.contextPath}/notice/update";
					break;
					
				case "updateAsk" :	
					successMessage = "문의 수정에 성공 했습니다. "
					movePath = "${ pageContext.servletContext.contextPath}/board/update";
					break;				
				case "deleteNotice" :
					successMessage = "공지사항 삭제에 성공 했습니다. "
					movePath = "${ pageContext.servletContext.contextPath}/notice/list";
					break;

				case "insertCalculation" :
					successMessage = "정산 신청에 성공하셨습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/calculate/applyList";
					break;
					
				case "approveCalculation" :
					successMessage = "정산에 성공하셨습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/calculaterequest/list";
					break;
					
				case "updateReservationStatusNorefund" :
					successMessage = "구매확정 처리가 완료되셨습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/travel/reservationList";
					break;

			}
			alert(successMessage);
			location.href = movePath;
		})();
	</script>
</body>
</html>