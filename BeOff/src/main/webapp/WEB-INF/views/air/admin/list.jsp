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
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

	<script src="https://kit.fontawesome.com/51772bd9bd.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	
	<title>비행기 예매</title>
	<style>
		input[type="number"]::-webkit-outer-spin-button,
		input[type="number"]::-webkit-inner-spin-button {-webkit-appearance: none; margin: 0;}
	</style>
</head>

<body style="margin-bottom: 200px">
	<%-- 인증 헤더 --%>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>

	<div class="container mt-3">
		<h2>국가/타임테이블/항공사 관리</h2>
		<hr>
		<table>
			<thead>
				<tr>
                    <th width="30%">국가</th>
                    <th width="30%">출국시간</th>
                    <th width="40%">항공사</th>
                </tr>
			</thead>
			<tbody>
				<tr>
					<td valign="top" >
						<table>
							<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
							<form action="addregion" method="post">
								<tr>
									<td><input type="text" name="addregion" placeholder="국가" required></td>
									<td><button class="w-100 btn btn-sm btn-outline-dark">추가</button></td>
								</tr>
							</form>
							<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
							<c:forEach var="r" items="${regionList}">
								<tr style="border-top:1px solid #000;">
									<td>${r.region}</td>
									<td class="d-flex">
										<button onclick="updateOpen('region${r.id}')" type="button" class="btn btn-sm btn-outline-dark">수정</button>
										<form action="delregion" method="post">
											<input type="hidden" name="delregion" value="${r.id}">
											<button class="btn btn-sm btn-outline-dark">삭제</button>
										</form>
									</td>
								</tr>
								<form action="updateregion" method="post">
									<tr id="region${r.id}" style="display:none;">
										<td>
											<input type="text" name="updateregion" placeholder="국가수정" value="${r.region}" required>
											<input type="hidden" name="regionId" value="${r.id}">
										</td>
										<td class="d-flex justify-content-end">
											<button class="btn btn-sm btn-outline-dark">완료</button>
											<button onclick="updateClose('region${r.id}')" type="button" class="btn btn-sm btn-outline-dark">취소</button>
										</td>
									</tr>
								</form>
							</c:forEach>
						</table>
					</td>
					<td valign="top">
						<table>
							<tr><td>&nbsp;</td></tr>
							<form action="addtime" method="post">
								<tr>
									<td><input type="text" name="addtime" placeholder="시간" required></td>
									<td><button class="w-100 btn btn-sm btn-outline-dark">추가</button></td>
								</tr>
							</form>
							<tr><td>&nbsp;</td></tr>
							<c:forEach var="t" items="${timeList}">
								<tr style="border-top:1px solid #000;">
									<td>${t.time}</td>
									<td class="d-flex">
										<button onclick="updateOpen('time${t.id}')" type="button" class="btn btn-sm btn-outline-dark">수정</button>
										<form action="deltime" method="post">
											<input type="hidden" name="deltime" value="${t.id}">
											<button class="btn btn-sm btn-outline-dark">삭제</button>
										</form>
									</td>
								</tr>
								<form action="updatetime" method="post">
									<tr id="time${t.id}" style="display:none;">
										<td>
											<input type="text" name="updatetime" placeholder="시간수정" value="${t.time}" required>
											<input type="hidden" name="timeId" value="${t.id}">
										</td>
										<td class="d-flex justify-content-end">
											<button class="btn btn-sm btn-outline-dark">완료</button>
											<button onclick="updateClose('time${t.id}')" type="button" class="btn btn-sm btn-outline-dark">취소</button>
										</td>
									</tr>
								</form>
							</c:forEach>
						</table>
					</td>
					<td valign="top">
						<table>
							<tr><td>&nbsp;</td></tr>
							<form action="addname" method="post">
								<tr>
									<td><input type="text" name="addname" placeholder="항공사" required></td>
									<td><input type="number" name="addprice" step="0.1" placeholder="가격" required></td>
									<td><button class="w-100 btn btn-sm btn-outline-dark">추가</button></td>
								</tr>
							</form>
							<tr><td>&nbsp;</td></tr>
							<c:forEach var="n" items="${nameList}">
								<tr style="border-top:1px solid #000;">
									<td>${n.name}</td>
									<td>${n.price}￦</td>
									<td class="d-flex">
										<button onclick="updateOpen('name${n.id}')" type="button" class="btn btn-sm btn-outline-dark">수정</button>
										<form action="delname" method="post">
											<input type="hidden" name="delname" value="${n.id}">
											<button class="btn btn-sm btn-outline-dark">삭제</button>
										</form>
									</td>
								</tr>
								<form action="updatename" method="post">
									<tr id="name${n.id}" style="display:none;">
										<td>
											<input type="text" name="updatename" placeholder="항공사수정" value="${n.name}" required>
											<input type="hidden" name="nameId" value="${n.id}">
										</td>
										<td>
											<input type="number" name="updateprice" step="0.1" placeholder="가격수정" value="${n.price}" required>
										</td>
										<td class="d-flex justify-content-end">
											<button class="btn btn-sm btn-outline-dark">완료</button>
											<button onclick="updateClose('name${n.id}')" type="button" class="btn btn-sm btn-outline-dark">취소</button>
										</td>
									</tr>
								</form>
							</c:forEach>
						</table>
					</td>							
				</tr>
			</tbody>
		</table>
	</div>
</body>	
<script>
	function updateOpen(id) {
		let tr = document.getElementById(id);
		tr.style.display = "";
	}
	
	function updateClose(id) {
		let tr = document.getElementById(id);
		tr.style.display = "none";
	}

</script>
</html>
