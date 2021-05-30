<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<!-- GNB -->
<jsp:include page="../common/menubar.jsp"/>
<!-- /GNB -->


   <section id="aa-catg-head-banner">
			<img src="../resources/img/sr/elephant.jpg" width="1900" height="300">
			<div class="aa-catg-head-banner-area">
				<div class="container">
					<div class="aa-catg-head-banner-content">
						<h2>공지사항 수정</h2>
					</div>
				</div>
			</div>
		</section>
   
    <!--main content start-->
        <h1><i class="fa fa-angle-right"></i>공지사항</h1>
         <div class="outer outer-notice-list">
		<h2 align="center">공지 사항 수정</h2>
		<div class="table-area">
			<form action="${ pageContext.servletContext.contextPath }/notice/update" method="post">
				<table align="center">
					<tr>
						<td>제목</td>
						<td><input type="text"  value="${requestScope.notice.title}" size="50" name="title"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" value="${ sessionScope.loginMember.nickname }" name="writer"></td>
					</tr>
					<tr>
						<td>내용</td>
					</tr>
					<tr>
						<td>내용 </td>
					<td colspan="3">
						<textarea style="resize:none; width:250px; height:200px;" name="body"><c:out value="${ requestScope.notice.body }"/></textarea>
					</td>
					</tr>
					
				</table>
				<br>
				<div align="center">
					<button type="reset" id="cancelNotice">취소하기</button>
					<button type="submit" value="${ notice.no }">수정하기</button>
				</div>
			</form>
		</div>
	</div>
    <footer class="site-footer">
        <p>
        </p>
        <div class="credits">
        </div>
        <a href="blank.html#" class="go-top">
          <i class="fa fa-angle-up"></i>
          </a>
      </div>
    </footer>
    <!--footer end-->
  </section>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="/toy/admin/lib/jquery/jquery.min.js"></script>
  <script src="/toy/admin/lib/bootstrap/js/bootstrap.min.js"></script>
  <script src="/toy/admin/lib/jquery-ui-1.9.2.custom.min.js"></script>
  <script src="/toy/admin/lib/jquery.ui.touch-punch.min.js"></script>
  <script class="include" type="text/javascript" src="/toy/admin/lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="/toy/admin/lib/jquery.scrollTo.min.js"></script>
  <script src="/toy/admin/lib/jquery.nicescroll.js" type="text/javascript"></script>
  <!--common script for all pages-->
  <script src="/toy/admin/lib/common-scripts.js"></script>
  <!--script for this page-->

</body>

</html>
