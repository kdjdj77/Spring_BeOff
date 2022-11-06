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
<html>

<head>
	<title>NavBar</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://kit.fontawesome.com/51772bd9bd.js" crossorigin="anonymous"></script>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@700&display=swap" rel="stylesheet">
	<style>
	 	a {text-decoration: none; color:white;}
		a:hover {color:white;}
		.nav-item:hover {border-bottom:3px solid crimson;}
		.nav-item {
			height:40px;
			-webkit-box-sizing: border-box;
		   	-moz-box-sizing: border-box;
		   	box-sizing: border-box;
		}	
		.navbar-brand {font-family: 'Dancing Script', cursive;}
	 </style>
</head>

<body>
  <nav class="navbar navbar-expand-sm navbar-dark bg-dark" style="position:fixed; height:56px; width:100%; top:0; z-index:999;">
    <div class="container-fluid">
      <a class="navbar-brand m-0 p-0 fs-4" href="${pageContext.request.contextPath }/home">BeOff</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse ms-5" id="mynavbar">
        <ul class="navbar-nav me-auto">
          <li class="nav-item me-3"><a class="nav-link active" href="${pageContext.request.contextPath }/air/basic">비행기</a></li>
          <li class="nav-item me-3"><a class="nav-link active" href="${pageContext.request.contextPath }/hotel/list">숙소</a></li>          
          <li class="nav-item me-3"><a class="nav-link active" href="${pageContext.request.contextPath }/rental/list">렌트카</a></li>
          <li class="nav-item me-3"><a class="nav-link active" href="${pageContext.request.contextPath }/board/list">QnA</a></li>
           
          <sec:authorize access="hasRole('ADMIN_AIR')">
	          <li class="nav-item me-3"><a class="nav-link active" href="${pageContext.request.contextPath }/air/admin/list">관리자(비행기)</a></li>
          </sec:authorize>
          <sec:authorize access="hasRole('ADMIN_AIR')">
	          <li class="nav-item me-3"><a class="nav-link active" href="${pageContext.request.contextPath }/user/admin/authcheck">관리자(권한관리)</a></li>
          </sec:authorize>
           <sec:authorize access="hasRole('ADMIN_HOTEL')">
	          <li class="nav-item me-3"><a class="nav-link active" href="${pageContext.request.contextPath }/hotel/admin/list">관리자(숙소)</a></li>
          </sec:authorize>
           <sec:authorize access="hasRole('ADMIN_RENTAL')">
	          <li class="nav-item me-3"><a class="nav-link active" href="${pageContext.request.contextPath }/rental/admin/list">관리자(렌트카)</a></li>
          </sec:authorize>
        </ul>
       
         <!-- 로그인 안했을때는 로그인 form 보여주기 -->
         <sec:authorize access="isAnonymous()">
         	<a class="btn btn-primary" type="submit" href="${pageContext.request.contextPath}/user/login">Login</a>       		
         </sec:authorize>

         <!-- 로그인 했을때는 username 과 로그아웃 form 보여주기 -->
         <sec:authorize access="isAuthenticated()">
	         <form action="${pageContext.request.contextPath}/user/logout" method="POST" TODO="">
	           <!--TODO : 로그아웃후 다시 돌아오기 -->
	           <span class="d-flex">
	             <span class="text-light p-2">
	             	<span>${userdetails.user.name }</span> 님 
	             	<a href="${pageContext.request.contextPath}/user/userinfo"><i class="fs-5 fa-solid fa-gear mx-1"></i></a>
	             </span>
	             <span><button class="btn btn-danger" type="submit">Logout</button></span>
	           </span>
	         </form>       		
         </sec:authorize>
         
      </div>
    </div>
  </nav>
  <p><br><br><br></p>
</body>
</html>