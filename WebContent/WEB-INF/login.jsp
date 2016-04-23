<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<%@include  file="partials/head.html" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Autentificare utilizator</title>
</head>
<body>
<%@include file="partials/header.html" %>

<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Autentificare</h1>
            <div class="account-wall">
                <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120" alt="">
                <form class="form-signin" action="login" method="post">
	                <c:if test="${mesaj != null}">
	                	<label class="label-danger">${mesaj}</label>
	                </c:if>
                    <input name="user" style="margin-bottom:10px" type="text" class="form-control" placeholder="Username" value="" autofocus>
                    <input name="password" style="margin-bottom:10px" type="password" class="form-control" placeholder="Parola" value="" >
                    <input class="btn btn-lg btn-primary btn-block" type="submit" value="Logheaza-te">
                       
                </form>
            </div>
            <!--   <a href="#" class="text-center new-account">Creaza un cont </a> -->
        </div>
    </div>
</div>
<%@include file="partials/footer.html" %>

</body>
</html>