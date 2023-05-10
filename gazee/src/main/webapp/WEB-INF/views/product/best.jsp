<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- <h3>게시글 갯수: ${fn:length(list)}개</h3> --%>

<c:forEach items="${list}" var="bag">
	<div class="item">
		<img class="itemImage" alt="제품이미지" src="../../resources/img/${bag.img}">
		<div class="itemContent">
			${bag.productName}<!-- 출력용(expression language-EL) -->
		</div>
		<div class="itemContent">
			${bag.productContent}
		</div>
		<div class="itemContent">
			${bag.price}원
		</div>
	</div>
</c:forEach>


