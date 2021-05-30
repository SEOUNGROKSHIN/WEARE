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
 <section id="aa-error">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-error-area">
            <h3>비밀번호 변경 완료</h3>
            <span>비밀번호 변경이 완료되었습니다. </span>
            <p>우리 이제 더 다양한 상품을 보러 떠나볼까요?? </p>
            <a href="${ pageContext.servletContext.contextPath }">메인 화면으로</a>
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