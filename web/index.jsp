<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <jsp:forward page="/WEB-INF/views/main/main.jsp" />
	 <%--  <form name="form2" action="${ pageContext.servletContext.contextPath }/main" method="post">
	  </form>
	
<script type="text/javascript">
window.onload = function(){
	var $form =  document.forms['form2'];
	 $form.submit();
}
</script>	
 --%>






	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

</body>
</html>