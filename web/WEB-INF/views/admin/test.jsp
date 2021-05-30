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
		display:none;
	}
	.title-img-area {
		cursor:pointer;
	}
</style>

</head>
<body>
	<jsp:include page="../common/menubar.jsp" />




	<section id="aa-myaccount">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-myaccount-area">
						<div class="row-middle">
							<div class="col-md-6">
								<div class="aa-myaccount-register">
									<h4>가이드정보 수정</h4>
									<div class="aa-center">
										<form action="${ pageContext.servletContext.contextPath }/thumbnail/insert"
											class="aa-login-form" method="post" encType="multipart/form-data">

											<table align="center">
												<tr>
													<td rowspan="2">
														<div class="title-img-area" id="titleImgArea">
															<img id="titleImg" width="120" height="120">
														</div>
													</td>

													<td>이름</td>
													<td><input type="text" name="guideName"></td>
												</tr>
												<tr>
													<td><strong>E-mail</strong></td>
													<td><input type="email"></td>
												</tr>
												<tr>
													<td><strong>은행명</strong></td>
													<td colspan="2"><input type="text"></td>
												</tr>
												<tr>
													<td><strong>계좌번호</strong></td>
													<td colspan="2"><input type="text"></td>
												</tr>
												<tr>
													<td><strong>공인언어자격증</strong></td>
													<td colspan="3" height="50px">
														<div class="content-img-area1" id="contentImgArea1">
															<input type="file">
															
														</div>
													</td>
												</tr>
												<tr>
													<td><strong>주민등록사본</strong></td>
													<td colspan="3">
														<div class="content-img-area1" id="contentImgArea3">
															<input type="file">
															
														</div>
													</td>
												</tr>
												<tr>
													<td colspan="3" height="50px"><strong>경력 및
															자기소개</strong></td>
												</tr>
												<tr>
													<td colspan="3"><textarea name="body" rows="10"
															cols="70" style="resize: none;"></textarea></td>
												</tr>
												<tr>
													<td><button type="submit" class="aa-browse-btn">수정</button>
														<button type="reset" class="aa-browse-btn">취소</button></td>
											</table>
											<div class="thumbnail-file-area">
												<input type="file" id="thumbnailImg1" name="thumbnailImg1" onchange="loadImg(this, 1)"> 
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
	</script>









	<jsp:include page="../common/footer.jsp" />
</body>
</html>