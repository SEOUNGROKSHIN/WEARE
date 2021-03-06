<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	
	<div class="outer outer-thumbnail-detail">
		<table class="detail" align="center">
			<tr>
				<td width="100px">제목</td>
				<td colspan="5" width="900px"><label><c:out value="${ requestScope.thumbnail.title }"/></label></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><label><c:out value="${ requestScope.thumbnail.writer.nickname }"/></label></td>
				<td>조회수</td>
				<td><label><c:out value="${ requestScope.thumbnail.count }"/></label></td>
				<td>작성일</td>
				<td><label><c:out value="${ requestScope.thumbnail.createdDate }"/></label></td>
			</tr>
			<tr>
				<td>대표사진</td>
				<td colspan="5">
					<div id="titleImgArea" align="center">
						<img src="${ pageContext.servletContext.contextPath }${ requestScope.thumbnail.attachmentList[0].thumbnailPath }"
							width="500" height="300">
					</div>
				</td>
			</tr>
			<tr>
				<td>사진메모</td>
				<td colspan="5">
					<p id="contentArea"><c:out value="${ requestScope.thumbnail.body }"/></p>
				</td>
			</tr>
		</table>
		<table class="detail">
			<tr>
				<td width="330px">
					<div class="detailImgArea">
						<img id="detailImg1" class="detailImg" width="250" height="180"
							src="${ pageContext.servletContext.contextPath }${ requestScope.thumbnail.attachmentList[1].thumbnailPath }">
					</div>
				</td>
				<td width="330px">
					<div class="detailImgArea">
						<img id="detailImg1" class="detailImg" width="250" height="180"
							src="${ pageContext.servletContext.contextPath }${ requestScope.thumbnail.attachmentList[2].thumbnailPath }">
					</div>
				</td>
				<td width="330px">
					<div class="detailImgArea">
						<img id="detailImg1" class="detailImg" width="250" height="180"
							src="${ pageContext.servletContext.contextPath }${ requestScope.thumbnail.attachmentList[3].thumbnailPath }">
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>












