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
        <title>Agency - Start Bootstrap Theme</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/css/roomRev.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <!-- Masthead-->
        <header class="masthead">
        <form name="getReserve" action="getReserve" method="post">
            <div class="container">
                <div class="masthead-heading text-uppercase">Reserve</div>
                <div class="fs-2">User Name</div><div id="username" class="fs-4">${r.hotel.user.username }</div><br>
                <div class="fs-2">Hotel Name</div> <div id="hotelname" class="fs-4">${r.hotel.hotelname }</div> <br>
				<div class="fs-2">Room Name</div> <div id="roomname" class="fs-4">${r.roomname }</div> <br>
				<div class="fs-2">Price</div> <div id="price" class="fs-4">${r.price }</div> <br>
				<div class="fs-2">Choice Room Image</div> 
				<div id="roomImg" style="width: 500px; height: 500px; margin: 0 auto">
					<img class="card-img-top" src="${pageContext.request.contextPath }/upload/${r.files[0].file}" alt="..." />
				</div>
				<input type="hidden" name="id" value="${r.id }">
                <input class="btn btn-primary btn-xl text-uppercase" type="button" onclick="requestPay('${r.hotel.hotelname}', '${r.price}')" value="결제하러 간다?">
            </div>
        </form>    
        </header>
        <!-- Services-->
        
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="/js/roomRev.js"></script>
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script src="${pageContext.request.contextPath }/js/rev.js"></script>
</html>

