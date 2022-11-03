<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>회원가입</title>
</head>

<body style="margin-bottom: 200px">
    <div class="container mt-3">
        <div class="row mt-5">
            <div class="col-12 text-center">
                <h1>회원가입</h1>
            </div>
        </div>
        <div class="row mt-5">
            <div class="col-12 text-danger">
                ${error }
            </div>
        </div>
        <div class="row">
            <form method="POST" action="${pageContext.request.contextPath}/user/register">
                <div class="form-group mt-3">
                    <label for="username">사용자 아이디</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="사용자아이디" value="${username }" required>
                </div>
                <div class="form-group mt-3">
                    <label for="name">사용자 이름</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="사용자 이름" value="${name }" required>
                </div>
                <div class="form-group mt-3">
                    <label for="password">비밀번호</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호" required>
                </div>
                <div class="form-group mt-3">
                    <label for="re-password">비밀번호 확인</label>   <%-- binding 을 위해 hyphen 사용 자제 --%>
                    <input type="password" class="form-control" id="re_password" name="re_password" placeholder="비밀번호 확인" required>
                </div>
                <div class="form-group mt-3">
                    <label for="email">이메일</label>
                	<input type="email" id="email" name="email" class="form-control" pattern="[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}" placeholder="예) id@domain.com" required/>
                </div>
                <div class="form-group mt-3">
                    <label for="phonenum">휴대폰번호</label>
                	<input type="number" id="phonenum" name="phonenum" class="form-control" pattern="^(010|011|016|017|018|019)[0-9]{3,4}[0-9]{4}$" placeholder="예) 01012341234" required/>
                </div>
                <button type="submit" class="w-100 btn btn-lg btn-primary mt-3">등록</button>
            </form>
        </div>
	</div>
</body>
</html>