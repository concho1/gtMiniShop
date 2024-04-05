<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <jsp:include page="../header.jsp" />
   <div align="center">
      <hr>
         <h3>카테고리 테이블 전체 리스트 페이지</h3>
      <hr>
      <br><br>
      
      		<table border="1">
	         <tr bgcolor="#eeffee">
	         	<th>상품 no.</th>
	            <th>상품명</th> 
	            <th>카테고리 Code</th>
	            <th>상품 제조사</th> 
	            <th>상품 이미지</th>
	            <th>상품 수량</th> 
	            <th>상품 가격</th>
	            <th>상품 사양</th> 
	            <th>상품 설명</th>
	            <th>상품 포인트</th>
	            <th>상품 추가날짜</th>
	            <th>상품 수정</th>
	            <th>상품 삭제</th>
	         </tr> 
	         
	         <c:set var="list" value="${productsList }" />
	         <c:if test="${!empty list }">
	            <c:forEach items="${list }" var="dto">
	               <tr>
	                  <td> ${dto.pnum }</td>
	                  <td> ${dto.pname }</td>
	                  <td> ${dto.pcategoryFk }</td>
	                  <td> ${dto.pcompany }</td>
	                  <td> <img src="<%= request.getContextPath()%>/imgFolder/${dto.pimage}" 
	                  	 	style="width: 60px; height: 60px;" alt="Product Image" >
	                  </td>
	                  <td> ${dto.pqty }</td>
	                  <td><fmt:formatNumber value= "${dto.price }"/></td>
	                  <td> ${dto.pspec }</td>
	                  <td> ${dto.pcontents }</td>
	                  <td> ${dto.point }</td>
	                  <td> ${dto.pinputDate }</td>
	                  <td>
	                  	<input type="button" value="상품 수정"
	                        onclick="check(${dto.pcategoryFk })">
	                  </td>
	                  <td>
	                     <input type="button" value="상품 삭제"
	                        onclick="check(${dto.pcategoryFk })">
	                  </td>
	               </tr>
	            </c:forEach>
	         </c:if>
	         
	         <c:if test="${empty list }">
	            <tr>
	               <td colspan="11" align="center">
	                  <h3>상품 전체 x</h3>
	               </td>
	            </tr>
	         </c:if>
	      </table>
      </div>
      
</body>
</html>