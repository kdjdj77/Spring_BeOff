<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>목적지</th>
				<th>체크인 날짜</th>
				<th>체크아웃 날짜</th>
				<th>인원</th>
			</tr>
			<tr>
				<td>
				<select name="hotelregion" id="region">
					<c:forEach var="region" items="${regionList}">    
						<option value="${region }">${region }</option>
					</c:forEach>
				</select>
				</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</thead>
	</table>



</body>




</html>