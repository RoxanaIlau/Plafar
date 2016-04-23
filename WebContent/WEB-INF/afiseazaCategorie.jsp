<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

      
<!DOCTYPE html >
<html>
<head>
<%@include  file="partials/head.html" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Plafar</title>
</head>
<body>

<%@include  file="partials/header.html" %>
	
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
			<c:set var="i" value="1"/>
			<c:forEach items="${articole}" var="articol">
				<c:if test="${i==1}">
					<h1>${articol.categorie}</h1>
				</c:if>
				<c:set var="i" value="${i+1}"/>
			</c:forEach>
				
			</div>
		</div>
		<div class="row">
			<%@include  file="partials/listProducts.html" %>
		</div>
	</div>
	



<%@include file="partials/footer.html" %>

</body>
</html>