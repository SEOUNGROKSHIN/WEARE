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

<h1 align="center">${ requestScope.message }</h1>
<!-- footer -->
<jsp:include page="../common/footer.jsp"></jsp:include>
<!--/footer -->
</body>
</html>