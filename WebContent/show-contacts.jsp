<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Contacts</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	</head>
	<body>
		<h2>Liste des contacts</h2>
		<div class="container">
			<div class="row"> 
				<c:forEach items="${contacts}" var="contact">	
			<div class="col-md-4">
				<div class="card" style="width:400px">
				   <img class="card-img-top" src="img_avatar1.png" alt="Card image" style="width:100%">
				  <div class="card-body">
				    <h4 class="card-title">${contact.civilite} ${contact.prenom} ${contact.nom}</h4>
				    
				    <a href="AfficherAdresseContactServlet?id=${contact.id }" class="btn btn-primary">adresses</a>
				    <a href="ModifierContact?id=${contact.id }" class="btn btn-primary">modifier</a> 
     				<a href="SupprimerContact?id=${contact.id }" class="btn btn-primary">supprimer</a> 
				  </div>
				</div>
			</div>
			</c:forEach>
			</div>
		</div>
			
	</body>
</html>