<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.shopMain {
	width: 300px;
	height: 200px;
	margin: 0 auto;
	vertical-align: text-top;
	display: inline-block;
	zoom: 1;
	border: 1px #eee solid;
	padding: 5px;
	cursor: pointer;
}

.mypagemain {
	border: 1px #eaeaea solid;
	display: table-cell;
	table-layout:;
	padding: 10px 0;
	width: 1100px;
}

.a {
	padding-bottom: 50px;
	padding-top: 20px;
}

</style>
</head>
<body>
	<jsp:include page="../../common/menubar.jsp" />

	<!-- catg header banner section -->
	<section id="aa-catg-head-banner">
		<img src="../resources/img/sr/elephant.jpg" width="1900" height="300" alt="fashion img">
		<div class="aa-catg-head-banner-area">
			<div class="container">
				<div class="aa-catg-head-banner-content">
					<h2>MY PAGE</h2>
					<ol class="breadcrumb">
						<li><a href="index.html">Home</a></li>
						<li class="active">MY PAGE</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	
	<!-- / catg header banner section -->

	<!-- 메인메뉴 -->
	<section id="aa-product">
		<div class="container a">
			<div class="row">
				<div class="col-md-12">
					<div class="row">

						<!-- 마이페이지메인 영역 -->
						<div class="a">
							<table class="mypagemain">
								<tr>
									<td colspan="2" style="padding: 10px 25px;"><img
										src="../resources/img/mypage/user.png"></td>
									<td style="border-left: 1px solid #eaeaea; padding-left: 10px;">저희
										쇼핑몰을 이용해 주셔서 감사합니다. <strong>${ sessionScope.loginMember.nickname }</strong>님은 [${ sessionScope.loginMember.role }]이십니다.
									
									</td>
								</tr>
							</table>
						</div>
						<!-- 메인 영역 끝 -->
						<br>
						<!-- 이미지(부트스트랩.css)6771에 id로 저장됨 -->
						<!-- 첫번째 영역 -->
						<div class="col-md-4 col-sm-4 a">
							<article class="aa-blog-content-single">
								<div class="shopMain" onclick="location.href='${ pageContext.servletContext.contextPath }/member/check'">
									<h3 align="center">FROFILE</h3>
									<p style="border-top: 1px #eaeaea solid; text-align: center">
										<i class="fa fa-wrench" id="icon_myPage"></i><br>회원이신 고객님의<br>
										개인정보를 관리하는 공간입니다.
									</p>
								</div>
							</article>
						</div>
						
						<!-- 두번째 영역 -->
						<div class="col-md-4 col-sm-4 a">
							<article class="aa-blog-content-single">
								<div class="shopMain" onclick="location.href='${ pageContext.servletContext.contextPath }/memeber/wishList'">
									<h3 align="center">WISH LIST</h3>
									<p style="border-top: 1px #eaeaea solid; text-align: center">
										<i class="fa fa-shopping-cart" id="icon_myPage"></i><br>관심상품으로 등록하신<br>
										상품의 목록을 보여주는 공간입니다.
									</p>
								</div>
							</article>
						</div>
						
						<!-- 셋째 영역 -->
						<div class="col-md-4 col-sm-4 a">
							<article class="aa-blog-content-single">
								<div class="shopMain" onclick="location.href='${ pageContext.servletContext.contextPath }/travel/reservationList'">
									<h3 align="center">ORDER</h3>
									<p style="border-top: 1px #eaeaea solid; text-align: center">
											<i class="fa fa-rocket" id="icon_myPage"></i><br>회원이신 고객님의<br>
										예약내역을 확인하는 공간입니다.
									</p>
								</div>
							</article>
						</div>
						
						
						<!-- 넷째 영역 -->
						<c:set var="role" value="${ sessionScope.loginMember.role }"/>
						<c:if test="${ 'MEMBER' eq role }">
						<div class="col-md-4 col-sm-4 a">
							<article class="aa-blog-content-single">
								<div class="shopMain"  onclick="location.href='${ pageContext.servletContext.contextPath }/guide/signUp'">
									<h3 align="center">GUIDE JOIN</h3>  
									<p style="border-top: 1px #eaeaea solid; text-align: center">
										<i class="fa fa-user" id="icon_myPage"></i><br>회원이신 고객님이<br>
										가이드 신청 할 수 있는 공간입니다.
									</p>
								</div>
							</article>
						</div></c:if>
						
						<!-- 넷째 영역 -->
						<c:set var="role" value="${ sessionScope.loginMember.role }"/>
						<c:if test="${ 'GUIDE' eq role }">
						<div class="col-md-4 col-sm-4 a">
							<article class="aa-blog-content-single">
								<div class="shopMain"  onclick="location.href='${ pageContext.servletContext.contextPath }/guide/goods'">
									<h3 align="center">GUIDE JOIN</h3>
									<p style="border-top: 1px #eaeaea solid; text-align: center">
										<i class="fa fa-user" id="icon_myPage"></i><br>가이드이신 고객님의<br>
										정보를 수정 할 수 있는 공간입니다.
									</p>
								</div>
							</article>
						</div>
						</c:if>
						
						<!-- 다섯째 영역 -->
						<div class="col-md-4 col-sm-4 a">
							<article class="aa-blog-content-single">
								<div class="shopMain" onclick="location.href='${ pageContext.servletContext.contextPath }/board/querylist'">
									<h3 align="center">BOARD</h3>
									<p style="border-top: 1px #eaeaea solid; text-align: center">
										<i class="fa fa-comment" id="icon_myPage"></i><br>고객님께서 문의하신 <br>
										게시물을 관리하는 공간입니다.
									</p>
								</div>
							</article>
						</div>
						<!-- 여섯째 영역 -->
						<div class="col-md-4 col-sm-4 a">
							<article class="aa-blog-content-single" >
								<div class="shopMain" onclick="location.href='${ pageContext.servletContext.contextPath }/board/query'">
									<h3 align="center">HELP</h3>
									<p style="border-top: 1px #eaeaea solid; text-align: center">
										<i class="fa fa-envelope-o" id="icon_myPage"></i><br>무엇을 도와드릴까요?<br>
										고객센터 바로가기
									</p>
							
								</div>
							</article>
						</div>
						<!-- 여섯째 영역 끝 -->

					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- / Blog Archive -->

	<jsp:include page="../../common/footer.jsp" />
	
	<script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	</script>
</body>
</html>