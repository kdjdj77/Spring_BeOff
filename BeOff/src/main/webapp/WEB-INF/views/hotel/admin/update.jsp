<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%-- 로그인한 사용자 정보 Authentication 객체의 필요한 property 들을 변수에 담아 사용 가능  --%>
<sec:authentication property="name" var="username"/>  
<sec:authentication property="authorities" var="authorities"/> 
<sec:authentication property="principal" var="userdetails"/>   
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Modern Business - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/css/styles.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    </head>
   
    <body class="d-flex flex-column h-100">
    <%-- 인증 헤더 --%>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <form name="frm" action="hotelUpdateOk" method="post" enctype="Multipart/form-data">
        <main class="flex-shrink-0">
            <!-- Hotel Header-->
            <header class="bg-dark py-5">
                <div class="container px-5">
                    <div class="row gx-5 align-items-center justify-content-center">
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-8 col-xl-6">
                            <div class="text-center">
                                <h3 class="display-6 fw-bolder text-white mb-2 ">HOTEL - Update Page</h3>
                                <p class="lead fw-normal text-muted mb-5">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eaque fugit ratione dicta mollitia. Officiis ad.</p>
                            </div>
                        </div>
                    </div>
                        <div class="col-xl-5 col-xxl-6 d-none d-xl-block text-center"><img class="img-fluid rounded-3 my-5" src="https://dummyimage.com/600x400/343a40/6c757d" alt="..." /></div>
                    	<div class="col-lg-8 col-xl-7 col-xxl-6">
                            <div class="my-5 text-center text-xl-start">
                            <input type="hidden" name="id" value="${hotel.id }">
                            	<h3 class="display-7 fw-bolder text-white mb-2 ">Username</h3>
                            	<input type="text" class="form-control display-5 fw-bolder text-black mb-3"  id="username" value="${username}" name="username" readonly>
                           
                            	<h3 class="display-7 fw-bolder text-white mb-2 ">Hotel Name</h3>
                            	<input type="text" class="form-control display-5 fw-bolder text-black mb-3"  id="hotelname" value="${hotel.hotelname }" name="hotelname" required>
                                <h3 class="display-7 fw-bolder text-white mb-2 ">Hotel Region</h3>
                             
                                <!-- 체크용 <script>console.log("${regionList}")</script>  -->
                                <select name="region">
                                	<c:forEach var="r" items="${regionList }">
                                		<c:choose>
                                			<c:when test="${r == hotel.region.region }">
                                				<option value="${r }" selected>${r }</option>
                                			</c:when>
                                			<c:otherwise>
                                				<option value="${r }">${r }</option>
                                			</c:otherwise>
                                		</c:choose> 
                                	</c:forEach>
                                </select>
                                <h3 class="display-7 fw-bolder text-white mb-2 ">Hotel Content</h3>
                                <input type="text" class="form-control display-5 fw-bolder text-black mb-3"  id="content" value="${hotel.content }" name="content" required>
                                <div class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xl-start">
                                    <button class="btn btn-outline-dark">수정완료</button>
                                    <a class="btn btn-outline-dark" href="delete">삭제</a>
                                </div>
                                <div class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xl-start"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
         </main>   
     </form>
      <!-- Room Header-->
            <header class="bg-write py-5">
                <div class="container px-5">
                    <div class="row gx-5 align-items-center justify-content-center">
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-8 col-xl-6">
                            <div class="text-center">
                                <h3 class="display-6 fw-bolder text-black mb-2 ">ROOM - Update Page</h3>
                                <p class="lead fw-normal text-muted mb-5">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eaque fugit ratione dicta mollitia. Officiis ad.</p>
                            </div>
                        </div>
                    </div>
                    <div class="row container px-4 px-lg-5 row-cols-lg-3 justify-content-center mx-auto">
					       <c:forEach var="r" items="${hotel.rooms }">
					       <form name="frm" action="roomUpdateOk" method="post" enctype="Multipart/form-data">
					       <!-- Content Row-->
					       <div class="row gx-4 gx-lg-5 ">
					         <div class="col-md-9 mb-5 ">
					           <div class="card h-100 ">
					              <div class="card-body ">
					    <%--
					            	<label for="room${r.id }">
					            		<img class="card-img-top" src="${pageContext.request.contextPath }/upload/${r.files[0].file}" alt="..." /><br><br>
					            	</label>
					            	<div style="display: none">
					            		<input type="file" name="upfile" id="room${r.id }"/>	
					            	</div>
					     --%>       
					              
					             
							                <div class="image-container">
										         <img style="width: 200px;" id="preview-image" src="${pageContext.request.contextPath }/upload/${r.files[0].file}"/>
										    	 <input style="display: block;" type="file" id="room${r.id }" onchange="load('room${r.id }')">
										    </div>
											<script>
												function readImage(input) {
												    // 인풋 태그에 파일이 있는 경우
												    if(input.files && input.files[0]) {
												        // 이미지 파일인지 검사 (생략)
												        // FileReader 인스턴스 생성
												        const reader = new FileReader()
												        // 이미지가 로드가 된 경우
												        reader.onload = e => {
												            const previewImage = document.getElementById("preview-image")
												            previewImage.src = e.target.result
												        }
												        // reader가 이미지 읽도록 하기
												        reader.readAsDataURL(input.files[0])
												    }
												}
												
												function load(id){
													// input file에 change 이벤트 부여
													const inputImage = document.getElementById(id)
													inputImage.addEventListener("change", e => {
													    readImage(e.target)
													})
												})
									        </script> 
						       
									 	
					                <input type="text" class="form-control display-5 fw-bolder text-black mb-1"  id="roomname" value="${r.roomname}" name="roomname" placeholder="Room Name을 입력하세요" required>
					                <input type="text" class="form-control display-5 fw-bolder text-black mb-1"  id="price" value="${r.price}" name="price" placeholder="가격을 입력하세요" required>
					                <input type="number" class="form-control display-5 fw-bolder text-black mb-1"  id="bed" value="${r.bed}" name="bed" placeholder="침대갯수를 입력하세요" required>
					                <input type="hidden" name="id" value="${r.id }">
					              </div>
					              <div class="card-footer">
					                 <button class="btn btn-outline-dark">수정완료</button>
					                 <a class="btn btn-outline-dark mt-auto" href="list">목록</a>
					                 <a class="btn btn-outline-dark mt-auto" href="roomDelete?id=${r.id}">삭제</a>
					              </div>
					           </div>
					         </div>
					       </div>
					       </form>
					       </c:forEach>
					    </div>     
                </div>
            </div>
        </header>
   		
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
