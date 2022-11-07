<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${result == 0 }">
		<script>
			alert("탈퇴 실패");
			history.back();
		</script>
	</c:when>
	<c:otherwise>
		<form id="frm" action="${pageContext.request.contextPath}/user/logout" method="POST" TODO="">
		</form>
		<script>
			alert("탈퇴 성공");
			let frm = document.getElementById("frm");
			frm.submit();
		</script>
	</c:otherwise>
</c:choose>