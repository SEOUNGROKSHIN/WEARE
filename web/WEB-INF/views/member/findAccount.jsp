<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- GNB -->
<jsp:include page="../common/menubar.jsp"></jsp:include>
<!-- /GNB -->
<!-- Cart view section -->
 <section id="aa-myaccount">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
        <div class="aa-myaccount-area">         
            <div class="row">
              <div class="col-md-6">
                <div class="aa-myaccount-login">
                <h4>아이디 찾기</h4>
                 <form action="${ pageContext.servletContext.contextPath}/member/findaccount" class="aa-login-form" method="post">
                  <label for="">닉네임<span>*</span></label>
                   <input type="text" placeholder="가입시 작성했던 닉네임을 입력해주세요." name = "memberNickname">
                   <label for="">이메일<span>*</span></label>
                    <input type="email" placeholder="이메일을 입력해주세요." name = "email">
                    <button type="submit" class="aa-browse-btn">아이디 찾기</button>
                  </form>
                </div>
              </div>
              <div class="col-md-6">
                <div class="aa-myaccount-register">                 
                 <h4>비밀번호 찾기</h4>
                 <form action="${ pageContext.servletContext.contextPath}/member/findaccount" class="aa-login-form" method="post">
                    <label for="">아이디<span>*</span></label>
                    <input type="text" placeholder="아이디를 입력해주세요." name = "memberId" >
                    <label for="">이메일<span>*</span></label>
                    <input type="email" placeholder="이메일을 입력해주세요."name = "email" >
                    <button type="submit" class="aa-browse-btn">비밀번호 찾기</button>                    
                  </form>
                </div>
              </div>
            </div>          
         </div>
       </div>
     </div>
   </div>
 </section>
 <!-- / Cart view section -->


<!-- footer -->
<jsp:include page="../common/footer.jsp"></jsp:include>
<!--/footer -->
</body>
</html>