<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />

	<!-- product category -->
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
												<div class="simpleLens-big-image-container">
													<a data-lens-image="${ pageContext.servletContext.contextPath }/resources/user/img/view-slider/large/11.jpg"
														class="simpleLens-lens-image"><img
														src="${ pageContext.servletContext.contextPath }/resources/user/img/view-slider/medium/polo-shirt-4.jpg"
														class="simpleLens-big-image"></a>
												</div>
											</div>
											<div class="simpleLens-thumbnails-container">
												<a data-big-image="${ pageContext.servletContext.contextPath }/resources/user/img/view-slider/medium/polo-shirt-4.jpg"
													data-lens-image="${ pageContext.servletContext.contextPath }/resources/user/img/view-slider/large/polo-shirt-4.jpg"
													class="simpleLens-thumbnail-wrapper" href="#"> <img
													src="${ pageContext.servletContext.contextPath }/resources/user/img/view-slider/thumbnail/polo-shirt-4.jpg">
												</a> <a data-big-image="${ pageContext.servletContext.contextPath }/resources/user/img/view-slider/medium/polo-shirt-1.jpg"
													data-lens-image="${ pageContext.servletContext.contextPath }/resources/user/img/view-slider/large/polo-shirt-1.jpg"
													class="simpleLens-thumbnail-wrapper" href="#"> <img
													src="${ pageContext.servletContext.contextPath }/resources/user/img/view-slider/thumbnail/polo-shirt-4.jpg">
												</a> <a data-big-image="${ pageContext.servletContext.contextPath }/resources/user/img/view-slider/medium/polo-shirt-4.png"
													data-lens-image="${ pageContext.servletContext.contextPath }/resources/user/img/view-slider/large/polo-shirt-4.png"
													class="simpleLens-thumbnail-wrapper" href="#"> <img
													src="${ pageContext.servletContext.contextPath }/resources/user/img/view-slider/thumbnail/polo-shirt-4.png">
												</a>
											</div>
										</div>
									</div>
								</div>
								<!-- Modal view content -->
								<div class="col-md-7 col-sm-7 col-xs-12">
									<div class="aa-product-view-content">
										<h1><input type="text" placeholder="상품명을 입력해주세요."></h1>
										
										<br>
										<h2><input type="text" placeholder="기본 가격을 입력해주세요."></h2>
										<br>
										<table>
											<tr>
												<td style="width: 200px;"><p>평점</p></td>
												<td><p>★4.5</p></td>
											</tr>
											<tr>
												<td><p>날짜</p></td>
												<td><p>2021.03.05</p></td>
											</tr>
											<tr>
												<td><p>시간</p></td>
												<td><p>11시 - 2시</p></td>
											</tr>
											<tr>
												<td><p>미팅장소</p></td>
												<td><p>장소 협의</p></td>
											</tr>
											<tr>
												<td><p>옵션 선택</p></td>
												<td><select>
														<option>미니싸얌</option>
														<option>짜뚜짝주말시장</option>
														<option>왕궁</option>
														<option>쑤언 빡깟</option>
												</select></td>
											</tr>
											<tr>
												<td><p>인원</p></td>
												<td><select>
														<option>1명</option>
														<option>2명</option>
														<option>3명</option>
														<option>4명</option>
														<option>5명</option>
												</select></td>
											</tr>
										</table>
									</div>

									<div class="aa-prod-view-bottom">
										<a class="aa-add-to-cart-btn" href="#">찜하기</a> <a
											class="aa-add-to-cart-btn" href="#">결제하기</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="aa-product-details-bottom">
						<ul class="nav nav-tabs" id="myTab2">
							<li><a href="#tour" data-toggle="tab">투어소개</a></li>
							<li><a href="#course" data-toggle="tab">코스소개</a></li>
							<li><a href="#Guidance" data-toggle="tab">안내사항</a></li>
							<li><a href="#review" data-toggle="tab">Reviews</a></li>
						</ul>

						<!-- Tab panes -->
						<div class="tab-content">
							<!-- 투어소개 -->
							<div class="tab-pane fade in active" id="tour">
								<h1>아유타야(Ayutthaya)</h1>
								<p>태국의 과거를 이야기할 때 빠지지 않고 거론되는 도시, 아유타야. 1350년경에 건립된 이 도시는
									수코타이 왕족에 이어 타이 족의 두 번째 왕국이 거점을 잡은 수도이다. 수많은 건축물과 사원을 세우며 막강한
									왕권을 자랑하던 왕국은 400년간 지속되다 1767년 미얀마에게 침략을 받아 멸망하며 역사 속으로 사라졌다. 이후
									정글 속에 파묻혀 사람들의 기억 속에 차차 잊혀가던 도시의 시간은 유네스코에 의해 하나씩 발굴되며 다시 흐르기
									시작했다.</p>
								<h1>왓 마하탓(Wat Mahathat)</h1>
								<p>야유타야의 오래된 사원은 대부분 미얀마의 침략에 의해 파괴되었지만 이곳은 아유타야 왕국 초기에 세워진
									사원임에도 온전하게 남아 있다. 이곳에서는 개성 있는 불상과 탑들이 세워져 있는데, 가장 유명한 것은 보리수 나무
									뿌리에 감싸져있는 불상의 얼굴이다. 전쟁 중에 잘려진 불상의 머리가 보리수나무에 놓였고, 세월이 지나 나무가
									무성해져 지금의 모습을 갖게 되었다.</p>
							</div>
							<br>
							<!-- 투어소개 끝!! -->
							<!-- 코스소개 -->
							<div class="tab-pane fade in active" id="course">
								<h1>코스소개</h1>
								<p>- 선택 1 (말리까) 태국의 라마 5세 시대의 마을을 재현한 곳으로 그 당시 태국인들의 전통적인
									생활방식과 문화를 느낄 수 있는 곳입니다. 이국적인 아름다운 마을에서 태국전통 의상도 입어보시고 태국 전통
									생활상도 느껴보세요</p>
								<p>선택 2 ( 코끼리 & 뗏목 트래킹) 태국의 대표 상징인 코끼리와 칸차나부리의 잔잔한 강을 따라 뗏목을
									타고 내려오는 트래킹 체험! 칸차나부리의 평온한 정취에 취해보세요.</p>
							</div>
							<br>
							<!-- 코스소개 끝!! -->
							<!-- 안내사항 -->
							<div class="tab-pane fade in active" id="Guidance">
								<h1>안내사항</h1>
								<p>
									포함사항 : <br> 불포함 사항 :
								</p>
							</div>
							<!-- 안내사항 끝!! -->
						</div>
						<br>


						<!-- 리뷰작성 -->
					<%-- 	<jsp:include page="../board/review.jsp"/> --%>
						<!-- <div class="aa-product-review-area">
							<h2>-- 상품후기 --</h2>
							<ul class="aa-review-nav">
								<li>
									<div class="media">
										<div class="media-body">
											<h4 class="media-heading">
												<strong>Marla Jobs</strong> - <span>March 26, 2021</span>
											</h4>
											<div class="aa-product-rating">
												<span class="fa fa-star"></span> <span class="fa fa-star"></span>
												<span class="fa fa-star"></span> <span class="fa fa-star"></span>
												<span class="fa fa-star-o"></span>
											</div>
											<p>나는 힘들게 구현 했는데~</p>
										</div>
									</div>
								</li>
								<li>
									<div class="media">
										<div class="media-body">
											<h4 class="media-heading">
												<strong>Marla Jobs</strong> - <span>March 26, 2021</span>
											</h4>
											<div class="aa-product-rating">
												<span class="fa fa-star"></span> <span class="fa fa-star"></span>
												<span class="fa fa-star"></span> <span class="fa fa-star"></span>
												<span class="fa fa-star-o"></span>
											</div>
											<p>너는 즐거운 여행이냐?</p>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<br> -->
					<!-- 리뷰 완료! -->
				</div>
			</div>
		</div>
	</section>
	<!-- / product category -->

	<jsp:include page="../common/footer.jsp" />
</body>
</html>
