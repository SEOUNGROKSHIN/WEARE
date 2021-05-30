<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<!-- GNB -->
<jsp:include page="../common/menubar.jsp"></jsp:include>
<!-- /GNB -->
<section id="aa-myaccount">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
        <div class="aa-myaccount-area">         
            <div class="row-middle">
              <div class="col-md-6">
                <div class="aa-myaccount-login">
                <h4>비밀번호 재설정</h4>
                 <form action="" class="aa-login-form" method="post">
                   <label for="">새로운 비밀번호를 다시 입력 해주세요.<span>*</span></label>
                    <input type="password" placeholder="Password" id="memberPwd" name="memberPwd">
                    <button type="submit" class="aa-browse-btn" id="Pwdreset">비밀번호 재설정</button>
                  </form>
                </div>
              </div>
            </div>          
         </div>
       </div>
     </div>
   </div>
 </section>

<!-- footer -->
<jsp:include page="../common/footer.jsp"></jsp:include>
<!--/footer -->
</body>
</html>