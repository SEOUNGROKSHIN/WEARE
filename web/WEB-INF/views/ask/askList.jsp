
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
	<jsp:include page="../common/menubar.jsp"/>
	
	
	<section id="aa-catg-head-banner">
			<img src="../resources/img/sr/elephant.jpg" width="1900" height="300">
			<div class="aa-catg-head-banner-area">
				<div class="container">
					<div class="aa-catg-head-banner-content">
						<h2>문의 내역</h2>
					</div>
				</div>
			</div>
		</section>
	
	
	
	<form method="post">
	<div class="outer outer-ask-list">
		<br>
		<br>
		<br>
		<br>
		<h2 align="center">문의 내역</h2>
		<div class="table-area">
			<table align="center" id="listArea">
				<tr>
				<td width="100">글번호</td>
				<td width="500">제목</td>
				<td width="300">문의 주제</td>
				<td width="100">날짜</td>
				</tr>
				<c:forEach var="ask" items="${ requestScope.askList }">
				<tr>
					<td><c:out value="${ask.no }"/></td>
					<td><c:out value="${ ask.title }"/></td>
					<td><c:out value="${ ask.category }"/></td>
					<td><c:out value="${ ask.askDate }"/></td>
				</c:forEach>
			</table>
		</div>
		<div class="search-area" align="center">
			<select id="searchCondition" name="searchCondition">
				<option value="title">제목</option>
				<option value="body">내용</option>
				<option value="ask">주제</option>
			</select>
			<input type="search" name="searchValue">
			<button type="submit">검색하기</button>
		</div>
	</div>
	</form>
	<script>
			if(document.getElementsByTagName("td")) {
				const $tds = document.getElementsByTagName("td");
				
				for(let i = 0; i < $tds.length; i++) {
					
					$tds[i].onmouseenter = function() {
						this.parentNode.style.backgroundColor = "white";
						this.parentNode.style.cursor = "pointer";
					}
					
					$tds[i].onmouseout = function() {
					}
					
					$tds[i].onclick = function() {
						const no = this.parentNode.children[0].innerText;
						location.href = "${ pageContext.servletContext.contextPath }/board/askdetail?no=" + no;
					}
				}
			}
			
			</script>
			}
		}
</body>
</html>