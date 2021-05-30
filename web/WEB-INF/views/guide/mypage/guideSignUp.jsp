<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<h2>가이드 신청 </h2>
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
									<h4>가이드 신청</h4>
									<div class="aa-center">
										<form id="guidesignupform" action=""  method="post"
											encType="multipart/form-data">
											<table clss="aa-login-form">
												<tr>
													<td rowspan="2">
														<div class="title-img-area" id="titleImgArea">
															<img id="titleImg" width="150" height="150" name="title" >
														</div>
													</td>

													<td><strong>이름</strong></td>
													<td><input type="text" name="guideName"></td>
												</tr>
												<tr>
													<td><strong>E-mail</strong></td>
													<td><input type="email" name="guideEmail"></td>
												</tr>
												<tr>
													<td height="60"><strong>은행명</strong></td>
													<td colspan="3"><input type="text" name="guideBank"></td>
												</tr>
												<tr>
													<td height="60"><strong>계좌번호</strong></td>
													<td colspan="3"><input type="text" name="guideAccount"></td>
												</tr>
												<tr>
													<td height="60"><strong>공인언어자격증</strong></td>
													<td colspan="3" height="50">
														<div class="content-img-area1" id="contentImgArea1">
															<input type="file" name="body" id="contentImg1">
														</div>
													</td>
												</tr>
												<tr>
													<td height="60"><strong>주민등록사본</strong></td>
													<td colspan="3">
														<div class="content-img-area3" id="contentImgArea3">
															<input type="file" name="body" id="contentImg3">
														</div>
													</td>
												</tr>
												<tr>
													<td colspan="3" height="60"><strong>경력 및 자기소개</strong></td>
												</tr>
												<tr>
													<td colspan="3"><textarea name="guideIntro" rows="10"
															cols="70" style="resize: none;"></textarea></td>
												</tr>
												<tr>
													<td><div id="guidesignup"  class="aa-browse-btn">신청</div>
														<button type="reset" class="aa-browse-btn">취소</button></td>
											</table>
											<div class="thumbnail-file-area">
												<input type="file" id="thumbnailImg1" name="thumbnailImg1" onchange="loadImg(this, 1)"> 
												<input type="file" id="thumbnailImg2" name="thumbnailImg2"	onchange="loadImg(this, 2)">
												<input type="file" id="thumbnailImg3" name="thumbnailImg3"	onchange="loadImg(this, 3)">
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
					case 2 : 
						document.getElementById("contentImg1").src = e.target.result;
						break;
					case 3 : 
						document.getElementById("contentImg3").src = e.target.result;
						break;
					}
				}

				reader.readAsDataURL(value.files[0]);
			}
		}

		/* 회원번호 안보이게 불러오기 */		
		const $guidesignup = document.getElementById("guidesignup");
		$guidesignup.onmouseenter = function(){
			this.style.cursor = "pointer";
		}
		$("#guidesignup").click(function(){
			
			
			
			
			const $form = document.forms['guidesignupform']; 
			const input = document.createElement('input');
			var memberbeforenum = "${ sessionScope.loginMember.no}";
			input.setAttribute('type','hidden');
			input.setAttribute('name','memberNo');
			input.setAttribute('value',memberbeforenum);
			
			$form.append(input);
			
			$form.submit();
			
			
		});
	</script>









	<jsp:include page="../../common/footer.jsp" />
</body>
</html>