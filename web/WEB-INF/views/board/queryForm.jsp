<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />


		<section id="aa-catg-head-banner">
			<img src="../resources/img/sr/elephant.jpg" width="1900" height="300">
			<div class="aa-catg-head-banner-area">
				<div class="container">
					<div class="aa-catg-head-banner-content">
						<h2>우리가요에게 문의 하기</h2>
					</div>
				</div>
			</div>
		</section>

		<form method="post">
		<div class="form-group"style="margin-top: 20px; margin-bottom: 50px;">
			<input type="text" placeholder="제목" class="form-control" style="width: 378px; margin: 0 auto; position: relative; top: 15px;" name="title">
		</div>

		<div class="form-group"></div>
		
		<select name="category" placeholder="문의 주제" class="form-control" 	
			style="width: 10cm; margin: 0 auto;">
			<option value="결제 관련">결제 관련</option>
			<option value="가이드 관련">가이드 관련</option>
			<option value="우리가요 관련">우리가요 관련</option>
		</select>
   					
			<textarea style="width: 10cm; margin: 0 auto;" class="form-control"
				rows="3" placeholder="전달할 내용" name="body">
             </textarea>

		<button type="submit" id="insertQform" method="post"
			style="margin-left: 15cm; width: 11cm; margin-bottom: 50px; display: block;  margin-left: auto; margin-right: auto;">Send</button>
	</form>
	<div class="col-md-4"></div>
	<script>
	"$(form-group:ask).val();"
	</script>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>