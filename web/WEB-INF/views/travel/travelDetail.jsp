<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
   <jsp:include page="../common/menubar.jsp" />
   <section id="aa-product-details">
      <div class="container">
         <div class="row">
            <div class="col-md-12">
               <div class="aa-product-details-area">
                  <div class="aa-product-details-content">
                     <div class="row">
                        <!-- Modal view slider -->
                        <div class="col-md-5 col-sm-5 col-xs-12">
                           <div class="aa-product-view-slider">
                              <div id="demo-1" class="simpleLens-gallery-container">
                                 <div class="simpleLens-container">
                                    <div class="simpleLens-big-image-container" width="" heigth="">
                                       <a data-lens-image="../resources/upload/original/<c:out value="${ travel.attachmentList[0].savedName }"/>"class="simpleLens-lens-image">
                                       <img src="../<c:out value="${ travel.attachmentList[0].thumbnailPath }"/>"   class="simpleLens-big-image"></a>
                                    </div>
                                 </div>
                                 
                                 <div class="simpleLens-thumbnails-container">
                                 <c:forEach var="img" items="${ travel.attachmentList }">
                           <!-- 중간 -->   <a data-big-image="../<c:out value="${ img.thumbnailPath }"/>"
                                       data-lens-image="../resources/upload/original/<c:out value="${ img.savedName }"/>"
                                       class="simpleLens-thumbnail-wrapper" href="#"> 
                           <!-- 섬네일 --> <img width="45" height="55" src="../<c:out value="${ img.thumbnailPath }"/>">
                                    </a> 
                                 </c:forEach>
                                 
                                 </div>
                              </div>
                           </div>
                        </div>
                        <!-- Modal view content -->
                        <c:set var="travel" value="${ requestScope.travel }"/>
                        <div class="col-md-7 col-sm-7 col-xs-12">
                           <div class="aa-product-view-content">
                              <h1><c:out value="${ travel.travelName }"/></h1>
                              <h2><fmt:formatNumber value="${ travel.travelCost}" pattern="#,###"/> 원</h2>
                              <br>
                              <p><c:out value="${ travel.travelSummery }"/></p>
                              <br>
                              <table>
                                 <!-- <tr>
                                    <td style="width: 200px;"><p>평점</p></td>
                                    <td><p>★4.5</p></td>
                                 </tr> -->
                                 <tr>
                                    <td><p>여행 시작 날짜</p></td>
                                    <td><p> </p><td>
                                    <td><p><c:out value="${ travel.travelStartDate }"/></p></td>
                                 </tr>
                                 <tr>
                                    <td><p>여행 종료 날짜</p></td>
                                    <td> <td>
                                    <td><c:out value="${ travel.travelEndDate }"/></td>
                                 </tr>
                                 <tr>
                                    <td><p>미팅장소</p></td>
                                    <td> <td>
                                    <td><p>장소 협의</p></td>
                                 </tr>
                                 <tr>
                                    <td><p>옵션 선택</p></td>
                                    <td> <td>
                                    <td>
                                     <form name="form2" action="${ pageContext.servletContext.contextPath }/travel/reservation" method="get">
                                    <select name="option_checked">
                                    <c:forEach var="option" items="${ travel.optionList }">
                                          <option value=" ${ option.optionName }::${ option.optionPrice }"><c:out value="${ option.optionName }"/>  ::가격 :  <c:out value="${ option.optionPrice }"/> 원  </option>
                                    </c:forEach>
                                    </select>
                                    </form>
                                    </td>
                                 </tr>
                                 <tr>
                                    <td><p>최대 신청 가능 인원</p></td>
                                    <td> <td>
                                    <td><p> <c:out value="${ travel.travelMax }"/> 명</p></td>
                                 </tr>
                              </table>
                              <div class="aa-prod-view-bottom" align="center">
                                        <a class="aa-add-to-cart-btn" href="#" id="enrollbutton">결제하기</a>
                                       <a class="aa-add-to-cart-btn" href="#">찜하기</a>
                                   </div>
                           </div>
                             
                        </div>
                     </div>
                  </div>
                  <div class="aa-product-details-bottom">
                     <ul class="nav nav-tabs" id="myTab2">
                        <li><a href="#description" data-toggle="tab">전체보기</a></li>
                        <li><a href="#tourIntro" data-toggle="tab">투어소개</a></li>
                        <li><a href="#courseIntro" data-toggle="tab">코스소개</a></li>
                        <li><a href="#Infor" data-toggle="tab">안내사항</a></li>
                     </ul>

                     <!-- Tab panes -->
                     <div class="tab-content">
                     <div class="tab-pane fade in active" id="description">
                        
                     </div>
                     
                     
                     <div class="tab-pane fade" id="tourIntro">
                        <c:out value="${ travel.travelIntro }"  escapeXml="false"/>
                     </div>
                        
                     <div class="tab-pane fade" id="courseIntro">
                        <c:out value="${ travel.travelCourse }"  escapeXml="false"/>
                     </div>
                        
                     <div class="tab-pane fade" id="Infor">
                           <c:out value="${ travel.travelInfromation }"  escapeXml="false"/>
                     </div>
                           <div class="aa-product-review-area">
                              <h4>리뷰 리스트</h4>
                              <ul class="aa-review-nav">
                                 <li>
                                    <div class="media">
                                    
                                       <div class="media-body">
                                          <h4 class="media-heading">
                                             <strong>Marla Jobs</strong> - <span>March 26, 2016</span>
                                          </h4>
                                          <div class="aa-product-rating">
                                             <span class="fa fa-star"></span> <span class="fa fa-star"></span>
                                             <span class="fa fa-star"></span> <span class="fa fa-star"></span>
                                             <span class="fa fa-star-o"></span>
                                          </div>
                                          <p>Lorem ipsum dolor sit amet, consectetur adipisicing
                                             elit.</p>
                                       </div>
                                    </div>
                                 </li>
                                 <li>
                                    <div class="media">
                                       
                                       <div class="media-body">
                                          <h4 class="media-heading">
                                             <strong>Marla Jobs</strong> - <span>March 26, 2016</span>
                                          </h4>
                                          <div class="aa-product-rating">
                                             <span class="fa fa-star"></span> <span class="fa fa-star"></span>
                                             <span class="fa fa-star"></span> <span class="fa fa-star"></span>
                                             <span class="fa fa-star-o"></span>
                                          </div>
                                          <p>Lorem ipsum dolor sit amet, consectetur adipisicing
                                             elit.</p>
                                       </div>
                                    </div>
                                 </li>
                              </ul>
                              <h4>리뷰 남기기</h4>
                              <div class="aa-your-rating">
                                 <p>여행은 어떠셨나요?? 리뷰를 남겨주세요!</p>
                                 <a href="#"><span class="fa fa-star-o"></span></a> <a
                                    href="#"><span class="fa fa-star-o"></span></a> <a href="#"><span
                                    class="fa fa-star-o"></span></a> <a href="#"><span
                                    class="fa fa-star-o"></span></a> <a href="#"><span
                                    class="fa fa-star-o"></span></a>
                              </div>
                              <!-- review form -->
                              <form action="" class="aa-review-form">
                                 <div class="form-group">
                                    <label for="message">리뷰를 남겨 주세요!</label>
                                    <textarea class="form-control" rows="3" id="message"></textarea>
                                 </div>
                                 

                                 <button type="submit"
                                    class="btn btn-default aa-review-submit">리뷰 남기기</button>
                              </form>
                           </div>
                        
                     </div>
                  </div>
                  <!-- Related product -->
                  
               </div>
            </div>
         </div>
      </div>
   </section>
   
   <script type="text/javascript">
    
    var tourIntro = document.getElementById('tourIntro').innerHTML;
    var courseIntro = document.getElementById('courseIntro').innerHTML;
    var Infor = document.getElementById('Infor').innerHTML;
     document.getElementById('description').innerHTML += tourIntro;
     document.getElementById('description').innerHTML += courseIntro;
     document.getElementById('description').innerHTML += Infor;

     function makeTag(name, value){
         var hiddenTag = document.createElement('input');
         hiddenTag.setAttribute("type", "hidden") 
         hiddenTag.setAttribute("name", name) 
         hiddenTag.setAttribute("value", value) 
   

         return hiddenTag
      } 
         
         
      $("#enrollbutton").click(function(){
            
         var $form =  document.forms['form2'];
         var no = ${travel.travelNo} ;
         console.log(no);
         $form.append(makeTag('no', no));
            console.log($form)
            $form.submit();
            
      });
            /* $form.append(makeTag('travelName',travelName)); */
            
            
            
   </script>
   <!-- / product category -->
   <jsp:include page="../common/footer.jsp" />
</body>
</html>