<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<%@include  file="partials/head.html" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rezultate cautare</title>

</head>
<body>

	<%@include  file="partials/header.html" %>

	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<h1>Rezultate cautare</h1>
			</div>
		</div>
		<div class="row">
			<c:if test="${articole != null }">
				<%@include  file="partials/listProducts.html" %>
			</c:if>
			
			<c:if test="${articole == null }">
				<div> Nu s-au gasit articole.</div>
			</c:if>
			
		</div>
	</div>


<%@include file="partials/footer.html" %>

</body>
</html>

</body>
</html>