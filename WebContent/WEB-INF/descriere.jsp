<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include  file="partials/head.html" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${articol.den}</title>
</head>
<body>
<%@include file="partials/header.html" %>

<div class="container" style="margin-bottom:150px;">
<div class="row"></div>
	<div class="col-xs-12">
		<h1>${articol.den}</h1>
	</div>
	<div class="col-xs-12 col-md-5">
		<img style="width:100%;" src="${articol.cale}">
	</div>
	<div class="col-xs-12 col-md-7">
	<div class="row">
		<div class="col-xs-12" style="margin-bottom:25px;">
		  <label style="font-size:14px;font-weight:bold;">Descriere:</label></br>
		  <label>${articol.descriere}</label>
		</div>
		
		<div class="col-xs-12" style="margin-bottom:25px;">
		  <label style="font-size:14px; font-weight:bold;">Pret:</label></br>
		  <label>${articol.pret} Lei</label>
		</div>
		
		<div class="col-xs-12 text-center" style="margin-bottom:25px;">
			<form action="cos" method="post">
			<input type="hidden" name="id" value="${articol.id}"> 
			<input class="btn btn-info" type="submit" value="Adauga in cos">
		</form>
		
		</div>
	</div>
		
		
	</div>
	
	<div class="row">
		<div class="col-xs-12">

		  <!-- Nav tabs -->
		  <ul class="nav nav-tabs"  id="description_tab" role="tablist">
		    <li role="presentation" class="active"><a href="#rec" aria-controls="home" role="tab" data-toggle="tab">Recomandat</a></li>
		    <li role="presentation"><a href="#comp" aria-controls="profile" role="tab" data-toggle="tab">Compozitie</a></li>
		    <li role="presentation"><a href="#sub" aria-controls="profile" role="tab" data-toggle="tab">Substante Active</a></li>
		    <li role="presentation"><a href="#ci" aria-controls="profile" role="tab" data-toggle="tab">Contraindicatii</a></li>
		  </ul>
		
		  <!-- Tab panes -->
		  <div class="tab-content">
		    <div role="tabpanel" class="tab-pane active" id="rec">${articol.recomandare}</div>
		    <div role="tabpanel" class="tab-pane" id="comp">${articol.compozitie}</div>
		    <div role="tabpanel" class="tab-pane" id="sub">${articol.substante}</div>
		    <div role="tabpanel" class="tab-pane" id="ci">${articol.ci}</div>
		  </div>
			
		</div>
	</div>
	

</div>

<%@include file="partials/footer.html" %>

<script>
$('#description_tab').click(function (e) {
	  e.preventDefault()
	  $(this).tab('show')
	})
</script>

</body>
</html>