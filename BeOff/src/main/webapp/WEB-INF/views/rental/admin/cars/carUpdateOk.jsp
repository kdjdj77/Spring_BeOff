<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${result == 0 }">
		<script>
			alert("수정 실패");
			history.back();
		</script>
	</c:when>
	<c:otherwise>
	<input type="hidden" id="id" value="${id }">
		<script>
			alert("수정 성공");
			const id = document.getElementById("id").value;
			location.href="${pageContext.request.contextPath }/rental/admin/cars/list?id=" + id;
		</script>
	</c:otherwise>
</c:choose>