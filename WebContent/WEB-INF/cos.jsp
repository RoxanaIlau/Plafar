<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<%@include  file="partials/head.html" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cosul Dumneavoastra</title>
</head>
<body>

<%@include  file="partials/header.html" %>

<div class="container">
    <h2>Cos de cumparaturi</h2>
</div>
<div class="container">
    <div class="row">
        <div class="col-xs-12">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <td>Nr. crt.</td>
                        <td>Imagine</td>
                        <td>Produs</td>
                        <td>Pret</td>
                    </tr>
                </thead>
                <tbody>
                <c:set var="i" value="0"/>
                <c:set var="crt" value="1"/>
                
                <c:if test="${cos != null}">
	                <c:forEach items="${sessionScope.cos }" var="articol">
						<c:set var="i" value="${i+articol.pret}"/>
						<c:set var="crt" value="${crt+1}"/>
						<tr>
							<td>${i}</td>
		                    <td><img style="max-height:100%; max-width:100px;" src="${articol.cale}"></td>
		                    <td>${articol.den}</td>
		                    <td>${articol.pret} lei</td>
		                    <td class="text-center"><a href="cos?id=${articol.id}&action=1">sterge</a></td>
						</tr>
					</c:forEach>
                </c:if>
                <c:if test="${cos == null}">
                	<tr><td colspan="4">Nu aveti produse in cos.</td></tr>
                </c:if>
                
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="3">Total plata:</td>
                        <td>${i} Lei</td>
                    </tr>
                </tfoot>
                </table>
        </div>
    </div>
</div>




<%@include file="partials/footer.html" %>


</body>
</html>