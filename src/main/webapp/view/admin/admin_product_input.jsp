<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
		<div align="center">
			<hr width="65%" color="gray">
				<h3>상품 등록 페이지</h3>
			<hr width="65%" color="gray">
			<br><br>
			
			<form method="post" enctype="multipart/form-data" action="<%=request.getContextPath()%>/admin_product_input_ok.go">
				<table border="1" width="450">
					<c:set var="clist" value="${categoryList}"></c:set>
					<tr>
						<th>상품명</th>
						<td><input name="pname"></td>
					</tr>
					<tr>
						<th>카테고리 Code</th>
						<td>
							<select name="pcategoryFk">
								<c:if test="${empty clist}">
									<option value="">카테고리 없음</option>
								</c:if>
								<c:if test="${!empty clist }">
									<c:forEach items="${clist}" var="category">
										<option value="${category.categoryCode}">${category.categoryName} [${category.categoryCode}]</option>
									</c:forEach>
								</c:if>
							</select>
						</td>
					</tr>
					<tr>
						<th>상품 제조사</th>
						<td><input name="pcompany"></td>
					</tr>
					<tr>
						<th>상품 이미지</th>
						<td><input type="file" name="pimage"></td>
					</tr>
					<tr>
						<th>상품 수량</th>
						<td><input name="pqty" min="1" max="99" value="1"></td>
					</tr>
					<tr>
						<th>상품 가격</th>
						<td><input name="price"></td>
					</tr>
					<tr>
						<th>상품 사양</th>
						<td>
							<select name="pspec">
								<option value="none" selected>일반</option>
								<option value="hit" selected>인기</option>
								<option value="new" selected>신상</option>
								<option value="recomended" selected>추천</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>상품 설명</th>
						<td><input name="pcontents"></td>
					</tr>
					<tr>
						<th>상품 포인트</th>
						<td><input name="point"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="상품등록">&nbsp;&nbsp;&nbsp;
							<input type="reset" value="다시작성">
						</td>
					</tr>
				</table>
			</form>
		</div>
	
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>