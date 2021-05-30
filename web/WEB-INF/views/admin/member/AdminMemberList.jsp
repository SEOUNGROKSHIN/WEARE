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
	<jsp:include page="../../common/adminMenubar.jsp"/>
	
	
	
	<!--main content start-->
<section id="main-content">
    <section class="wrapper">
      <h3><i class="fa fa-angle-right"></i>회원 관리</h3>
      
      <div class="row mt">
          <div class="col-md-12">
            <!-- 목차 영역 -->
          <div class="content-panel">
            <table class="table table-striped table-advance table-hover">
              <h4><i class="fa fa-angle-right"></i>회원 리스트</h4>
              <hr>
                <tr>	
                  <th><i class="fa fa-bullhorn"></i> 회원번호</th>
                  <th class="hidden-phone"><i class="fa fa-question-circle"></i>아이디</th>
                  <th><i class="fa fa-bookmark"></i>닉네임</th>
                  <th><i class=" fa fa-edit"></i>E-MAIL</th>
                  <th><i class=" fa fa-edit"></i>연락처</th>
                  <th><i class=" fa fa-edit"></i>탈퇴여부</th>
                  <th><i class=" fa fa-edit"></i>회원구분</th>
                  <th><i class=" fa fa-edit"></i>가입일자</th>
                  <th></th>
                </tr>
                
                <c:forEach var="member" items="${ requestScope.memberList }">
                    <tr>
                        <td><c:out value="${ member.no }"/></td>
                        <td><c:out value="${ member.id }"/></td>
                        <td><c:out value="${ member.nickname }"/></td>
                        <td><c:out value="${ member.email }"/></td>
                        <td><c:out value="${ member.phone }"/></td>
                        <td><c:out value="${ member.status }"/></td>
                        <td><c:out value="${ member.role }"/></td>
                        <td><c:out value="${ member.enrollDate }"/></td>
                    </tr>
                </c:forEach>
            </table>
          </div><!-- 목차 영역 끝 -->
             <div align="center">
			    <select id="searchCondition" name="searchCondition">
				    <option value="no">NO</option>
				    <option value="nickname">NICKNAME</option>
				    <option value="role">ROLE</option>
			    </select>
			    <input type="search" name="searchValue">
			    <button type="button" class="btn btn-warning">search</button>
		</div>
    </div><!-- /col-md-12 -->
      </div><!-- /row -->
    </section>
  </section><!-- /MAIN CONTENT -->
  
</section>
<!-- js placed at the end of the document so the pages load faster -->
<script src="lib/jquery/jquery.min.js"></script>
<script src="lib/bootstrap/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="lib/jquery.dcjqaccordion.2.7.js"></script>
<script src="lib/jquery.scrollTo.min.js"></script>
<script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
<!--common script for all pages-->
<script src="lib/common-scripts.js"></script>
<!--script for this page-->

	
	
	
</body>
</html>