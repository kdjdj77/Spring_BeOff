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
    </head>
   
    <body class="d-flex flex-column h-100">
    <%-- 인증 헤더 --%>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <form name="frm" action="hotelWriteOk" method="post" enctype="Multipart/form-data">
        <main class="flex-shrink-0">
            <!-- Hotel Header-->
            <header class="bg-dark py-5">
                <div class="container px-5">
                    <div class="row gx-5 align-items-center justify-content-center">
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-8 col-xl-6">
                            <div class="text-center">
                                <h3 class="display-6 fw-bolder text-white mb-2 ">HOTEL</h3>
                                <p class="lead fw-normal text-muted mb-5">This is the hotel registration page. Please enter the required information and register.</p>
                            </div>
                        </div>
                    </div>
                        <div class="col-xl-5 col-xxl-6 d-none d-xl-block text-center"><img class="img-fluid rounded-3 my-5" src="https://dummyimage.com/600x400/343a40/6c757d" alt="..." /></div>
                        
                    	<div class="col-lg-8 col-xl-7 col-xxl-6">
                            <div class="my-5 text-center text-xl-start">
                            	<h3 class="display-7 fw-bolder text-white mb-2 ">Username</h3>
                            	<input type="text" class="form-control display-5 fw-bolder text-black mb-3"  id="username" value="${username}" name="username" readonly>
                           
                            	<h3 class="display-7 fw-bolder text-white mb-2 ">Hotel Name</h3>
                            	<input type="text" class="form-control display-5 fw-bolder text-black mb-3"  id="hotelname" placeholder="호텔명을 입력하세요" name="hotelname" required>
                                <h3 class="display-7 fw-bolder text-white mb-2 ">Hotel Region</h3>
                                <!-- 체크용 <script>console.log("${regionList}")</script>  -->
                                <select name="region">
                                	<c:forEach var="r" items="${regionList }">
                                		<option value="${r }">${r }</option>
                                	</c:forEach>
                                </select>
                                <br><br>
                                <h3 class="display-7 fw-bolder text-white mb-2 ">Hotel Content</h3>
                                <input type="text" class="form-control display-5 fw-bolder text-black mb-3"  id="content" placeholder="호텔설명을 입력하세요" name="content" required>
                                <div class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xl-start">
                                	<button class="btn btn-outline-dark text-white mb-2">등록</button>
                                	<a class="btn btn-outline-dark text-white mb-2" href="list ">목록</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
   </form>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
