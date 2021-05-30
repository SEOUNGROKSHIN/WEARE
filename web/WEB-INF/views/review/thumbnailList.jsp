<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<!-- GNB -->
<jsp:include page="../common/menubar2.jsp"/>
<!-- /GNB -->

	<div class="outer outer-thumbnail-list">
		<br>
		<h2 align="center">여행 후기</h2>
		
		<div class="thumbnail-area" id="thumbnailArea">
		
		<c:forEach var="thumbnail" items="${requestScope.thumbnailList }"></c:forEach>
					<div class="thumb-list" align="center">
				<div>
					<img src="${ pageContext.servletContext.contextPath }${ thumbnail.attachmentList[0].thumbnailPath }" 
						width="200" height="150">
				</div>
				<p>
				No. <label><c:out value="${ thumbnail.no }"/></label> <c:out value="${ thumbnail.title }"/>
				
				<label><c:out value="${ thumbnail.title }"/></label><br>
				</p>
			</div>
		
		</div>
		
		<div class="search-area" align="center">
			<select id="searchCondition" name="searchCondition">
				<option value="writer">작성자</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
			<input type="search">
			<button type="submit">검색하기</button>
			<c:if test="${ !empty sessionScope.loginMember }">
				<button id="writeThumbnail">작성하기</button>
			</c:if>
		</div>
		
		
		
		
	</div>
	
	<script>
		$("#thumbnailArea > div").click(function() {
			const no = $(this).find("label").text();
			console.log(no);
			location.href = "${ pageContext.servletContext.contextPath }/thumbnail/detail?no=" + no;
		});
	</script>
</body>
</html>









