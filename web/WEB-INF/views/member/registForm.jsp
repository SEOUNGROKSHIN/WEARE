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
<jsp:include page="../common/menubar.jsp"/>
<!-- /GNB -->

<section id="aa-myaccount">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
        <div class="aa-myaccount-area">         
            <div class="row-middle">
              <div class="col-md-6">
                <div class="aa-myaccount-register">                 
                 <h4>회원가입</h4>
                 <div class="aa-center">
                 <form id="regitForm" action="${ pageContext.servletContext.contextPath}/member/regist" class="aa-login-form" method="post">
                    <label for="">아이디<span>*</span></label>
                    <input type="text" placeholder="입력하실 아이디를 작성해주세요." name="memberId" required>
                    <label for="">비밀번호<span>*</span></label>
                    <input type="password" placeholder="Password" id="memberPwd" name="memberPwd" required>
                    <label for="">비밀번호확인<span>*</span></label>
                    <input type="password" placeholder="Password" id="memberPwd2" name="memberPwd2" required>
                    <label for="">닉네임<span>*</span></label>
                    <input type="text" placeholder="입력하실 닉네임을 작성해주세요." name="nickname" required>
                    <label for="">E-mail<span>*</span></label>
                    <input type="email" placeholder="이메일을 입력해주세요." name="email" required>
                    <label for="">핸드폰<span>*</span></label>
                    <input type="tel" placeholder="휴대폰번호를 입력해주세요" name="phone" required>
                    <button type="submit" class="aa-browse-btn" >회원가입</button>                    
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
 
 <!-- 추지훈  bootstrap 1615줄 추가
    .row-middle{
	margin-right: -15px;
    margin-left: -15px;
    display: flex;
    justify-content: center;
}
    style.css 2622줄 항목 추가
    .aa-login-form input[type="tel"],
    .aa-login-form input[type="email"]
    

     -->

<!-- footer -->
<jsp:include page="../common/footer.jsp"></jsp:include>
<!--/footer -->


<script type="text/javascript">
		function movePath(e){
			const $form = document.getElementById("regitForm");
			const passwordValue = document.getElementById("memberPwd").value;
			const idValue = document.getElementById("memberId").value;
			
			if(!passwordValue || passwordValue === ""){
				alert("비밀번호를 반드시 입력해야합니다.");
				document.getElementById("memberPwd").focus();
				e.preventDefault();
				
				return false;
			}

			
		}
		
	</script>


</body>
</html>