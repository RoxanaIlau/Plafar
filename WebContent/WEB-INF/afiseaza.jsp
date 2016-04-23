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
		<!--   
		<div class="row">
			<div class="col-sm-12">
				<div class="item-slider">
				  <c:forEach items="${articole}" var="articol">
				  	<img class="imagine" src="${articol.cale}"
										alt="${articol.den}">
				  </c:forEach>
				</div>
				
			</div>
		</div> 
		-->
		
		<div class="row">
			<div class="col-xs-12">
				<h1>LISTA COMPLETA DE PRODUSE</h1>
				<div class="row">
					<%@include  file="partials/listProducts.html" %>
				</div>
			</div>
			</div>
		
	</div>
	
	<%@include file="partials/footer.html" %>
	<script>
	$('.item-slider').slick({
		  infinite: true,
		  slidesToShow: 4,
		  slidesToScroll: 1
		});
	</script>
</body>
</html>