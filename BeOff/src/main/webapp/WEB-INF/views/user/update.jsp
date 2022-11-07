<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<title>회원정보 수정</title>
</head>
<body>
	<form action="updateOk" method="POST">
		<main>
			<div class="container py-4">

				<div class="p-5 mb-4 bg-light rounded-3">
					<div class="container h-100">
						<div
							class="row d-flex justify-content-center align-items-center h-100">
							<div class="col-xl-9">

								<h1 class="text-black mb-4">회원정보 수정</h1>

								<div class="card" style="border-radius: 15px;">
									<div class="card-body">
										<div class="row align-items-center pt-4 pb-3">
											<div class="col-md-3 ps-5">
												<h6 class="mb-0">아이디</h6>
											</div>
											<div class="col-md-9 pe-5">
												<input type="text" class="form-control form-control-lg"
													id="username" name="username" value="${user.username }" disabled/>
											</div>
										</div>
										<hr class="mx-n3">
										<div class="row align-items-center pt-4 pb-3">
											<div class="col-md-3 ps-5">
												<h6 class="mb-0">닉네임</h6>
											</div>
											<div class="col-md-9 pe-5">
												<input type="text" class="form-control form-control-lg"
													id="name" name="name" value="${user.name }"/>
											</div>
										</div>
										<hr class="mx-n3">
										<div class="row align-items-center pt-4 pb-3">
											<div class="col-md-3 ps-5">
												<h6 class="mb-0">이메일</h6>
											</div>
											<div class="col-md-9 pe-5">
												<input type="text" class="form-control form-control-lg"
													id="email" name="email" value="${user.email }"/>
											</div>
										</div>
										<hr class="mx-n3">
										<div class="row align-items-center pt-4 pb-3">
											<div class="col-md-3 ps-5">
												<h6 class="mb-0">전화번호</h6>
											</div>
											<div class="col-md-9 pe-5">
												<input type="text" class="form-control form-control-lg"
													id="num" name="num" value="${user.phonenum }" disabled/>
											</div>
										</div>
										<hr class="mx-n3">
										<c:if test="${user.username.length() < 20 }">
											<div class="row align-items-center py-3">
												<div class="col-md-3 ps-5">
													<h6 class="mb-0">비밀번호</h6>
												</div>
												<div class="col-md-9 pe-5">
													<input type="password" class="form-control form-control-lg"
														id="pw" name="pw" value="" required/>
												</div>
											</div>
											<hr class="mx-n3">
										</c:if>
										<div class="px-5 py-4 d-flex justify-content-end">
											<button class="me-3 btn btn-secondary btn-warning btn-lg">수정</button>
											<a class="btn btn-secondary btn-danger btn-lg" href="userinfo">취소</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</main>
	</form>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>