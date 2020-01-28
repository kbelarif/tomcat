<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Modification de contact</title>
	</head>
	<body>
		<form action="FormulaireServlet" method="post">
			<input name="id"  value ='${c.id}' type="hidden" />
			<div>
				<label for="nom">Nom *</label> 
				<select id="civilite" name="civilite" value ='${c.civilite}'>
					<option value="M">M</option>
					<option value="Mme">Mme</option>
				</select>
				<input type="text" name="nom" placeholder='${c.nom}' value ='${c.nom}' id="nom" />
			</div>	
			<div>
				<label for="prenom">Prénom *</label>
				<input type="text" name="prenom" placeholder='${c.prenom}' value = '${c.prenom}' id="prenom"/>
			</div>
			<div class="buttons">
				<input type="submit" value="Modifier" id="submit"/>
			</div>
		</form>
	</body>
</html>