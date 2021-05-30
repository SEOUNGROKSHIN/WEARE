<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../../common/menubar.jsp" />

	<!-- catg header banner section -->
	<section id="aa-catg-head-banner">
		<img src="../resources/img/sr/elephant.jpg" width="1900" height="300"
			alt="fashion img">
		<div class="aa-catg-head-banner-area">
			<div class="container">
				<div class="aa-catg-head-banner-content">
					<h2>회원탈퇴</h2>
					<ol class="breadcrumb">
						<li><a href="index.html">Home</a></li>
						<li class="active">FROFILE</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	<!-- / catg header banner section -->

	<!-- Blog Archive -->
	<section id="aa-myaccount">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-myaccount-area">
						<div class="row-middle">
							<div class="col-md-6">
								<div class="aa-myaccount-register">
									<h4>회원 탈퇴</h4>
									<!-- TAB -->
										<ul class="nav nav-tabs aa-products-tab">
											<li><a href="${ pageContext.servletContext.contextPath }/member/update">회원정보수정</a></li>
											<li><a href="${ pageContext.servletContext.contextPath }/member/pwd">비밀번호변경</a></li>
											<li><a href="${ pageContext.servletContext.contextPath }/member/delete">회원탈퇴</a></li>
										</ul>
										<!-- TAB 영역 끝 -->
										<form action="" method="post">
										<div class="aa-center">
											<pre>    <i class="fa fa-hand-o-right"></i>그동안 보내주신 성원에 감사드립니다.<br>· 개인정보 취급방침에 의거하여 모든 개인정보가 삭제됩니다<br>· 단, 고객게시판, 후기 등의 게시물은 후에도 유지됩니다<br>· 게시물 삭제는 고객센터(3496-6251)로 별도 문의가 필요합니다.</pre>
										</div>
										<br>
										<h4>가입정보</h4>
										<table>
											<tr>
												<td width="150px" height="50px"><label>아이디</label></td>
												<td><input type="text" name="memberId" readonly
													value="${ sessionScope.loginMember.id }"></td>
											</tr>
											<tr>
												<td><label>비밀번호</label></td>
												<td><input type="password" maxlength="13"
													name="memberPwd" id="memberPwd" required></td>
											</tr>
										</table>
										<br>
										<h4>탈퇴사유</h4>
										<table>
											<tr>
												<td width="300px" height="50px"><input type="radio"
													name="delete" id="event" value="e"><label for="e">이벤트
														등의 목적으로 한시 사용함</label></td>
												<td width="300px" height="30px"><input type="radio"
													name="delete" id="price" value="p"><label for="p">상품의
														품질, 가격 등의 불만</label></td>
											</tr>
											<tr>
												<td width="300px" height="50px"><input type="radio"
													name="delete" id="help" value="h"><label for="h">문의사항에
														대한 불친절한 응대</label></td>
												<td><input type="radio" name="delete" id="email"
													value="em"><label for="em">원치않는 상품 및 정보성 이메일</label></td>
											</tr>
											<tr>
												<td><input type="radio" name="delete" id="secret"
													value="s"><label for="s">개인정보 및 보안우려</label></td>
												<td><input type="radio" name="delete" id="etc"
													value="et"><label for="et">기타<input
														type="text"></label></td>
											</tr>
											<tr align="center">
												<td colspan="3" height="150px"><button type="submit"
													class="aa-browse-btn">탈퇴</button>
												<button type="reset" class="aa-browse-btn">취소</button></td>
											</tr>
										</table>
										<br>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>


	<jsp:include page="../../common/footer.jsp" />

</body>
</html>