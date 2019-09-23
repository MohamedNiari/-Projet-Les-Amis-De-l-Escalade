<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<title>Liste des Sites d'Escalade</title>

<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Liste des sites d'escalade</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<table>

				<tr>
					<th>Nom du Site</th>
					<th>Lieu</th>
					<th>Description</th>
					<th>Hauteur</th>
					<th>Officiel</th>
				</tr>

				<c:forEach var="tempSite" items="${SITE_LIST}">
				<c:out value="${SITE_LIST}"></c:out>
					<tr>
						<td>${tempSite}</td>
						<td>${tempSite.lieu}</td>
						<td>${tempSite.description}</td>
						<td>${tempSite.hauteur_max}</td>
						<td>${tempSite.taguer_officiel}</td>
					</tr>

				</c:forEach>

			</table>

		</div>
	</div>
</body>


</html>








