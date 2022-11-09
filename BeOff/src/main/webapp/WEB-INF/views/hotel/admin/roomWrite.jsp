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
    	<style>
	    	input[type="number"]::-webkit-outer-spin-button,
			input[type="number"]::-webkit-inner-spin-button {
		    -webkit-appearance: none;
		    margin: 0;
		}
    	</style>
    </head>
   
    <body class="d-flex flex-column h-100">
    <%-- 인증 헤더 --%>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
   <form name="frm" action="roomWriteOk" method="post" enctype="Multipart/form-data">         
            <!-- Room Header-->
            <header class="bg-write py-5">
            <div>
                <div class="container px-5">
                    <div class="row gx-5 align-items-center justify-content-center">
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-8 col-xl-6">
                            <div class="text-center">
                                <h3 class="display-6 fw-bolder text-black mb-2 ">ROOM</h3>
                                <p class="lead fw-normal text-muted mb-5">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eaque fugit ratione dicta mollitia. Officiis ad.</p>
                            </div>
                        </div>
                    </div>
                        <div class="col-lg-8 col-xl-7 col-xxl-6">
                            <div class="my-5 text-center text-xl-start">
                            	<h3 class="display-7 fw-bolder text-black mb-2 ">Room Name</h3>
                            	<input type="text" class="form-control display-5 fw-bolder text-black mb-3"  id="roomname" placeholder="Room Name을 입력하세요" name="roomname" required>
                                <h3 class="display-7 fw-bolder text-black mb-2 ">Room Price</h3>
                                <input type="number" class="form-control display-5 fw-bolder text-black mb-3"  id="price" min="1" max="1000000" placeholder="가격을 입력하세요" name="price" required>
                                <h3 class="display-7 fw-bolder text-black mb-2 ">Room bed</h3>
                                <input type="number" class="form-control display-5 fw-bolder text-black mb-3"  id="bed" min="1" max="5" placeholder="침대갯수를 입력하세요" name="bed" required>
                    			<input type="hidden" name="id" value="${id }">
                    			
					            <%-- 상단에 jQuery 추가하기--%>
					            <h3 class="display-7 fw-bolder text-black mb-2 ">Room Image</h3>
								<div class="container mt-3 mb-3 border rounded">
									<div class="mb-3 mt-3">
										<div id="files">
										
										</div>
										<button type="button" id="btnAdd" class="btn btn-secondary">추가</button>
									</div>
								</div>
								<script>
								<%-- 주의! jsp 파일 안에서 Template Literal 사용하면 ${} 는 EL 구문으로 인식되어 서버단에서 먼저 처리된다
								     응답에 출력해야 하는 경우 \${ }  처럼 escaping 해야 한다 --%>
								var i = 0;
								$("#btnAdd").click(function(){
									$("#files").append(`
												<div class="input-group mb-2">
												<input class="form-control col-xs-3" type="file" name="upfile\${i}"/>
												</div>`);
									i++;
									$("#btnAdd").hide();
								});
								</script>
								<%-- ---------------------- --%>
                                    <button class="btn btn-outline-dark">등록</button>
                                    <a class="btn btn-outline-dark" href="list">목록</a>
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
