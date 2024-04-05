<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div align="center">
	<hr width="65%" color="marmoon">
		<h3>카테고리 등록 폼 페이지</h3>
	<hr width="65%" color="marmoon">
	
	<form method="post" action="<%=request.getContextPath()%>/admin_category_input_ok.go">
		<table style="border: 1px solid black;">
			<tr>
				<th>카테고리 코드</th>
				<td><input name="categoryCode"></td>
			</tr>
			<tr>
				<th>카테고리 이름</th>
				<td><input name="categoryName"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="등록">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
	</div>
	
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>