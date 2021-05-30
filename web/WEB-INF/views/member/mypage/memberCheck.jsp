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
		<img src="../resources/img/sr/elephant.jpg" width="1900" height="300" alt="fashion img">
		<div class="aa-catg-head-banner-area">
			<div class="container">
				<div class="aa-catg-head-banner-content">
					<h2>회원정보 수정</h2>
					<ol class="breadcrumb">
						<li><a href="index.html">Home</a></li>
						<li class="active">EDIT</li>
					</ol>
				</div>
			</div>
		</div>
	</section>

	<section id="aa-myaccount">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
        <div class="aa-myaccount-area">         
            <div class="row-middle">
              <div class="col-md-6">
                <div class="aa-myaccount-register">                 
                 <h4>회원정보</h4>
                 <div class="aa-center">
                 <form action="" class="aa-login-form" method="post">
                    <label for="">아이디<span>*</span></label>
                    <input type="text" readonly	value="${ sessionScope.loginMember.id }">
                    <label for="">비밀번호<span>*</span></label> 
                    <input type="password" required>
                    
                    <button type="submit" class="aa-browse-btn">확인</button>                    
                    <button type="reset" class="aa-browse-btn">취소</button>                    
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


	<jsp:include page="../../common/footer.jsp" />
	
	
	
</body>
</html>