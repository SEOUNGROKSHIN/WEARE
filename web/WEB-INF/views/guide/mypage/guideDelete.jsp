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
					<h2>가이드 취소</h2>
					<ol class="breadcrumb">
						<li><a href="index.html">Home</a></li>
						<li class="active">GUIDE</li>
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
									<h4>가이드 취소</h4>
									<!-- TAB -->
                		 		<ul class="nav nav-tabs aa-products-tab">
			                     <li><a href="${ pageContext.servletContext.contextPath }/guide/goods">내상품리스트</a></li>
			                     <li><a href="${ pageContext.servletContext.contextPath }/travel/enrolltravel">상품 등록 페이지</a></li>
			                     <li><a href="${ pageContext.servletContext.contextPath }/guide/reservationCheckList">예약확인</a></li>
			                     <li><a href="${ pageContext.servletContext.contextPath }/calculate/applyList">정산확인</a></li>
                				  </ul><!-- TAB 영역 끝 -->
                				  </ul><!-- TAB 영역 끝 -->
									<!-- TAB 영역 끝 -->
									<div class="aa-center">
										<form clss="aa-login-form" method="post">
											<div class="aa-center" align="center">
												<pre><i class="fa fa-hand-o-right"></i>그동안 보내주신 성원에 감사드립니다.<br>개인정보 취급방침에 의거하여 <br>가이드 추가정보가 삭제되고<br>일반회원으로 유지 됩니다.<br></pre>
											</div>
											<br>
											<h4>가입정보</h4>
											<table>
												<tr>
													<td width="150" height="80"><label>ID</label></td>
													<td><input type="text" name="memberId" readonly><c:out value="${ sessionScope.loginMember.id }"/></td>
												</tr>
												<tr>
													<td><label>PWD</label></td>
													<td><input type="password" name="memberPwd" required></td>
												</tr>
											</table>
											<br>
											<h4>취소사유</h4>
											<textarea rows="3" cols="65"></textarea>
											<br>

											<button type="submit" class="aa-browse-btn">등록</button>
											<button type="reset" class="aa-browse-btn">취소</button>
											<br>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- / Blog Archive -->

	<jsp:include page="../../common/footer.jsp" />


</body>
</html>