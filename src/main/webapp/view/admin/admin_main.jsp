<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#shop{
	
	}
</style>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div align="center">
		<ul>
			<li>
				<a href="<%=request.getContextPath()%>/admin_category_input.go">쇼핑 카테고리 등록</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/admin_category_list.go">쇼핑 카테고리 리스트</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/admin_product_input.go">쇼핑 상품 등록</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/admin_product_list.go">쇼핑 상품 목록</a>
			</li>
		</ul>
	</div>
	
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>