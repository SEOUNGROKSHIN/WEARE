<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <script src="/we/resources/admin/js/event.js"></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>우리가요 Admin</title>

  <!-- Favicons -->
  <link href="/we/resources/admin/img/favicon.png" rel="icon">
  <link href="/we/resources/admin/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="/we/resources/admin/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="/we/resources/admin/lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="/we/resources/admin/css/style.css" rel="stylesheet">
  <link href="/we/resources/admin/css/style-responsive.css" rel="stylesheet">
<!-- #########################남경 table link href########################### -->
  <link href="/we/resources/admin/lib/advanced-datatable/css/demo_page.css" rel="stylesheet" />
  <link href="/we/resources/admin/lib/advanced-datatable/css/demo_table.css" rel="stylesheet" />
  <link rel="stylesheet" href="/we/resources/admin/lib/advanced-datatable/css/DT_bootstrap.css" />
<!-- #########################/남경 table link href########################### -->
  <!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>

<body>
  <section id="container">
    <!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
    <!--header start-->
    <header class="header black-bg">
      <div class="sidebar-toggle-box">
        <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
      </div>
      <!--logo start-->
      <a href="${ pageContext.servletContext.contextPath }" class="logo"><b>우리가요<span>Admin</span></b></a>
      <!--logo end-->

    </header>
    <!--header end-->
    <!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
    <!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
          
       
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-cogs"></i>
              <span>회원관리</span>
              </a>
            <ul class="sub">
              <li><a href="${ pageContext.servletContext.contextPath }/admin/memberList">회원관리</a></li>
              <li><a href="${ pageContext.servletContext.contextPath }/admin/nomemberList">회원탈퇴관리</a></li>
              <li><a href="${ pageContext.servletContext.contextPath }/admin/signUpGuideList">가이드관리</a></li>
              <li><a href="${ pageContext.servletContext.contextPath }/admin/noGuideList">가이드취소관리</a></li>
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-book"></i>
              <span>가이드 상품 관리</span>
              </a>
            <ul class="sub">
  				<li><a href="${ pageContext.servletContext.contextPath }/admin/travel/enrollConfirm">상품 등록 심사 페이지</a></li>
            	<li><a href="${ pageContext.servletContext.contextPath }/admin/travel/travelList">상품 리스트 페이지</a></li>
            </ul>
          </li>
            <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-desktop"></i>
              <span>결제관리</span>
              </a>
            <ul class="sub">

              <li><a href="${ pageContext.servletContext.contextPath }/reservation/statuslist">결제상태</a></li>
              <li><a href="${ pageContext.servletContext.contextPath }/calculaterequest/list">가이드 정산</a></li>
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-th"></i>
              <span>게시판 관리</span>
              </a>
            <ul class="sub">
              <li><a href="${ pageContext.servletContext.contextPath }/notice/list">공지사항 게시판</a></li>
          

            </ul>
          </li>
        </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>
    <!--sidebar end-->
    </section>
<!-- ###################남경- 밑에 table에 대한 script 포함되어있음! 순서가 중요한가봄!! 순서 뒤밖이니 
table 적용이 안되니 추가할거 있으면 위나 아래에 추가해주길 바랍니다!!!!!!! -->
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="/we/resources/admin/lib/jquery/jquery.min.js"></script>
  <script type="text/javascript" language="javascript" src="/we/resources/admin/lib/advanced-datatable/js/jquery.js"></script>
  <script src="/we/resources/admin/lib/bootstrap/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="/we/resources/admin/lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="/we/resources/admin/lib/jquery.scrollTo.min.js"></script>
  <script src="/we/resources/admin/lib/jquery.nicescroll.js" type="text/javascript"></script>
  <script type="text/javascript" language="javascript" src="/we/resources/admin/lib/advanced-datatable/js/jquery.dataTables.js"></script>
 <script type="text/javascript" src="/we/resources/admin/lib/advanced-datatable/js/DT_bootstrap.js"></script>
  <!--common script for all pages-->
  <script src="/we/resources/admin/lib/common-scripts.js"></script>
  <!--script for this page--> 
  <!-- ###################/남경- 밑에 table에 대한 script 포함되어있음! 순서가 중요한가봄!! 순서 뒤밖이니 
table 적용이 안되니 추가할거 있으면 위나 아래에 추가해주길 바랍니다!!!!!!! -->
    
    
</body>
</html>