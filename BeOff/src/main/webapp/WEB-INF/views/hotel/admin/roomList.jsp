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
        <title>Room</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
    	<%-- 인증 헤더 --%>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
			<!-- Room Header-->
            <header class="bg-write py-5">
                <div class="container px-5">
                    <div class="row gx-5 align-items-center justify-content-center">
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-8 col-xl-6">
                            <div class="text-center">
                                <h3 class="display-6 fw-bolder text-black mb-2 ">${roomList.hotelname }`s <br> ROOM - List</h3>
                                <p class="lead fw-normal text-muted mb-5">This is the room information of ${roomList.hotelname }`s If you need to edit, list please click the appropriate button</p>
                            </div>
                        </div>
                    </div>
                    <div class="row container px-4 px-lg-5 row-cols-lg-3 justify-content-center mx-auto">
					       <c:forEach var="r" items="${roomList.rooms }">
					       <form name="frm" action="roomUpdateOk" method="post" enctype="Multipart/form-data">
					       <!-- Content Row-->
					       <div class="row gx-4 gx-lg-5 ">
					         <div class="col-md-9 mb-5 ">
					           <div class="card h-100 ">
					              <div class="card-body ">
					            	<img class="card-img-top" src="${pageContext.request.contextPath }/upload/${r.files[0].file}" alt="NO IMAGE" /><br><br>
					            	<!-- Product reviews-->
									<div
										class="d-flex justify-content-center small text-warning mb-2">
										<%-- <div class="bi-star-fill"></div>--%>
									</div>
					                <input type="text" class="form-control display-5 fw-bolder text-black mb-1"  id="roomname" value="${r.roomname}" name="roomname" placeholder="Room Name을 입력하세요" readOnly>
					                <input type="text" class="form-control display-5 fw-bolder text-black mb-1"  id="price" value="${r.price}" name="price" placeholder="가격을 입력하세요" readOnly>
					                <input type="number" class="form-control display-5 fw-bolder text-black mb-1"  id="bed" value="${r.bed}" name="bed" placeholder="침대갯수를 입력하세요" readOnly>
									<input type="hidden" name="id" value="${r.id }">
					              </div>
					            <!-- Product actions-->
								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center">
										<a class="btn btn-outline-dark mt-auto" href="update?id=${r.hotel.id }">수정</a>
										<a class="btn btn-outline-dark mt-auto" href="list">목록</a>
										<%--<a class="btn btn-outline-dark mt-auto" href="reserve?id=${r.id }">예약</a> --%>
									</div>
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
	
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2022</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
