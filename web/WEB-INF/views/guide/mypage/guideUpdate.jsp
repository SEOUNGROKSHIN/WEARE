<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>Insert title here</title>
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!--external css-->
<link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="lib/bootstrap-fileupload/bootstrap-fileupload.css" />
<link rel="stylesheet" type="text/css"
	href="lib/bootstrap-datepicker/css/datepicker.css" />
<link rel="stylesheet" type="text/css"
	href="lib/bootstrap-daterangepicker/daterangepicker.css" />
<link rel="stylesheet" type="text/css"
	href="lib/bootstrap-timepicker/compiled/timepicker.css" />
<link rel="stylesheet" type="text/css"
	href="lib/bootstrap-datetimepicker/datertimepicker.css" />
<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet">
<link href="css/style-responsive.css" rel="stylesheet">

<style>
.thumbnail-file-area input[type=file] {
	display: none;
}

.title-img-area {
	cursor: pointer;
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
					<h2>가이드정보 수정</h2>
					<ol class="breadcrumb">
						<li><a href="index.html">Home</a></li>
						<li class="active">GUIDE</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	<!-- / catg header banner section -->





	<section id="aa-myaccount">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-myaccount-area">
						<div class="row-middle">
							<div class="col-md-6">
								<div class="aa-myaccount-register">
									<h4>가이드정보 수정</h4>
									<!-- TAB -->
										<ul class="nav nav-tabs aa-products-tab">
											<li><a href="${ pageContext.servletContext.contextPath }/guide/update">가이드정보수정</a></li>
											<li><a href="${ pageContext.servletContext.contextPath }/guide/delete">가이드취소</a></li>
										</ul>
									<!-- TAB 영역 끝 -->
									<div class="aa-center">
										<form action=""  method="post"
											encType="multipart/form-data">
											<table clss="aa-login-form">
												<tr>
													<td rowspan="2">
														<div class="title-img-area" id="titleImgArea">
															<img id="titleImg" width="150" height="150" name="body" >
														</div>
													</td>

													<td><strong>이름</strong></td>
													<td><label><c:out value="${ requestScope.guideInfo.guideName }"/></label></td>
												</tr>
												<tr>
													<td><strong>E-mail</strong></td>
													<td><input type="email" name="guideEmail" readonly value=""></td>
												</tr>
												<tr>
													<td height="60"><strong>은행명</strong></td>
													<td colspan="3"><input type="text" name="guideBank"></td>
													
												</tr>
												<tr>
													<td height="60"><strong>계좌번호</strong></td>
													<td colspan="3"><input type="text" name="guideAccount">
														<button type="submit" id="certification"
															class="aa-checkout-login" size="10">인증</button></td>
													
												</tr>
												<tr>
													<td height="60"><strong>공인언어자격증</strong></td>
													<td colspan="3" height="50">
														<div class="content-img-area1" id="contentImgArea1">
															<input type="file" name="body">

														</div>
													</td>
												</tr>
												<tr>
													<td height="60"><strong>주민등록사본</strong></td>
													<td colspan="3">
														<div class="content-img-area3" id="contentImgArea3">
															<input type="file" name="body">

														</div>
													</td>
												</tr>
												<tr>
													<td colspan="3" height="60"><strong>경력 및
															자기소개</strong></td>
												</tr>
												<tr>
													<td colspan="3"><textarea name="guideIntro" rows="10"
															cols="70" style="resize: none;"></textarea></td>
												</tr>
												<tr>
													<td colspa="3"><button type="submit" class="aa-browse-btn">수정</button>
														<button type="reset" class="aa-browse-btn">취소</button></td>
											</table>
											<div class="thumbnail-file-area">
												<input type="file" id="thumbnailImg1" name="thumbnailImg1"
													onchange="loadImg(this, 1)"> <input type="file"
													id="thumbnailImg2" name="thumbnailImg2"
													onchange="loadImg(this, 2)"> <input type="file"
													id="thumbnailImg3" name="thumbnailImg3"
													onchange="loadImg(this, 3)">
											</div>
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

	<script>
		const $titleImgArea = document.getElementById("titleImgArea");
		const $contentImgArea1 = document.getElementById("contentImgArea1");
		const $contentImgArea3 = document.getElementById("contentImgArea3");

		$titleImgArea.onclick = function() {
			document.getElementById("thumbnailImg1").click();
		}

		function loadImg(value, num) {
			if (value.files && value.files[0]) {
				const reader = new FileReader();

				reader.onload = function(e) {
					switch (num) {
					case 1:
						document.getElementById("titleImg").src = e.target.result;
						break;

					}
				}

				reader.readAsDataURL(value.files[0]);
			}
		}

		/* 계좌 인증 */
		$("#certification").click(function() {

		});
	</script>









	<jsp:include page="../../common/footer.jsp" />
</body>
</html>