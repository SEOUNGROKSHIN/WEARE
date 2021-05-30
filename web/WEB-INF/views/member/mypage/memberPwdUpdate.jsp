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

 <!-- Cart view section -->
 <section id="aa-myaccount">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
        <div class="aa-myaccount-area">         
            <div class="row-middle">
              <div class="col-md-6">
                <div class="aa-myaccount-register">                 
                 <h4>비밀번호 변경</h4>
                 <!-- TAB -->
					<ul class="nav nav-tabs aa-products-tab">
						<li><a href="${ pageContext.servletContext.contextPath }/member/update">회원정보수정</a></li>
						<li><a href="${ pageContext.servletContext.contextPath }/member/pwd">비밀번호변경</a></li>
						<li><a href="${ pageContext.servletContext.contextPath }/member/delete">회원탈퇴</a></li>
					</ul>
				<!-- TAB 영역 끝 -->
                 <div class="aa-center">
                 <form action="" class="aa-login-form" method="post">
                  <label for="">아이디</label> <input type="text" name="memberId" readonly value="${ sessionScope.loginMember.id }">
                  <label for="">변경 할 비밀번호</label> <input type="password" id="memberPwd" name="memberPwd" required>
                  <label for="">비밀번호 확인</label> <input type="password" id="memberPwd2" name="memberPwd2" required>

                    <button type="submit" class="aa-browse-btn">수정</button>                    
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