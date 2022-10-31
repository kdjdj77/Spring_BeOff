<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Landing Page - Start Bootstrap Theme</title>
        <script src="https://kit.fontawesome.com/51772bd9bd.js" crossorigin="anonymous"></script>
        
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" type="text/css" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/css/userinfostyles.css" rel="stylesheet" />
    </head>
    <body>
        <%-- 인증 헤더 --%>
		<jsp:include page="/WEB-INF/views/common/header.jsp"/>
        <!-- Masthead-->
        <header class="masthead bg-black">
            <div class="container position-relative">
                <div class="row justify-content-start">
                    <div class="col-xl-6">
                        <div class="font-weight-bold text-left text-white fs-2">
                            <h1 class="mb-5">
                            	UserInfo 
                            	<a href="#" class="fs-5 text-black btn btn-warning">수정</a>
                            	<a href="#" class="fs-5 text-black btn btn-danger">탈퇴</a>
                            </h1>
                            
                            <div class="mb-3">ID : ${user.username}</div>
                            <div class="mb-3">Name : ${user.name}</div>
                            <div class="mb-3">Phone : ${user.phonenum}</div>
                            <div class="mb-3">Email : ${user.email}</div>
                            <p><br></p>
                            
                            <div style="width:1000px;" class="d-flex justify-content-between fs-5">
                            	<div class="border">
                            		<form action="adminreq" method="post">
                            			<div class="fs-4">숙소 등록권한 요청</div>
                            			<input type="hidden" id="hreq" name="auth" value="ROLE_ADMIN_HOTEL">
                            			<input type="hidden" name="userId" value="${user.id}">
                            			<div><textarea maxlength="200" class="form-control" name="content" style="width:450px; height:200px; resize:none; font-size:1.3rem;" placeholder="요청 사유를 적어주세요" required></textarea></div>
                            			<button class="btn btn-primary">요청하기</button>
                            		</form>
                            	</div>
                            	<div class="border">
                            		<form action="adminreq" method="post">
                            			<div class="fs-4">렌트카 등록권한 요청</div>
                            			<input type="hidden" id="hreq" name="auth" value="ROLE_ADMIN_RENTAL">
                            			<input type="hidden" name="userId" value="${user.id}">
										<div><textarea maxlength="200" class="form-control" name="content" style="width:450px; height:200px; resize:none; font-size:1.3rem;" placeholder="요청 사유를 적어주세요" required></textarea></div>
                            			<button class="btn btn-primary">요청하기</button>
                            		</form>
                            	</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- Icons Grid-->
        <section class="features-icons bg-light text-center">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4">
                    	<div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
	                        <a href="#" style="text-decoration:none; color:black;">
	                            <div class="features-icons-icon d-flex"><i class="fa-solid fa-plane m-auto text-primary"></i></div>
	                            <h3>나의 비행기 예매</h3>
	                        </a>
	                    </div>
                    </div>
                    <div class="col-lg-4">
                    	<a href="#" style="text-decoration:none; color:black;">
	                        <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
	                            <div class="features-icons-icon d-flex"><i class="fa-solid fa-car m-auto text-primary"></i></div>
	                            <h3>나의 렌트카 예약</h3>
	                        </div>
                        </a>
                    </div>
                    <div class="col-lg-4">
	                    <a href="#" style="text-decoration:none; color:black;">
	                        <div class="features-icons-item mx-auto mb-0 mb-lg-3">
	                            <div class="features-icons-icon d-flex"><i class="fa-solid fa-square-h m-auto text-primary"></i></div>
	                            <h3>나의 호텔 예약</h3>
	                        </div>
                        </a>
                    </div>
                </div>
            </div>
        </section>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/userinfoscripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>
