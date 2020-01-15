<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<link rel="icon" type="image/png" href="img/Favicon.png" />

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/c07610da30.js"
	crossorigin="anonymous"></script>
</head>

<body>

	<!-- Barre de navigation -->
	<jsp:include page="barre-navigation.jsp"></jsp:include>

	<!-- Image de la page d'accueil pour les Topos -->
	<aside class="bg">

		<img src="img/mesTopos.PNG" class="rounded mx-auto d-block"
			height="236" alt="topos">

	</aside>


	<section>

		<div class="row">
			<div class="col-md-3">
				<span class="btn btn-success font-weight-bold"
					style="border-width: 3px;"> <i class="fas fa-book"></i>&nbsp;
					TOPOS DISPONIBLE
				</span>
			</div>
			<div class="col-md-6"></div>
			<div class="col-md-3"></div>
		</div>

		<br>
		<hr>
		<br>
		<table class="table col-md-12">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Numéro</th>
					<th scope="col">Nom</th>
					<th scope="col">Lieu</th>
					<th scope="col">Description</th>
					<th scope="col">Date de parution</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${mapTopoAttente}">
					<tr>
						<th scope="row"><c:out value="${item.key.id}" /></th>
						<td><c:out value="${item.key.nom}" /></td>
						<td><c:out value="${item.key.lieu}" /></td>
						<td><c:out value="${item.key.description}" /></td>
						<td><c:out value="${item.key.dateParution}" /></td>
						<td><c:if test="${item.value == false}">
								<form action="ReservationServlet" method="post">
									<input type="hidden" name="topoId" value="${item.key.id}">
									<button class="btn btn-outline-success" type="submit">Réserver</button>
								</form>
							</c:if> <c:if test="${item.value == true}">
								<form action="ReservationServlet" method="post">
									<input type="hidden" name="topoId" value="${item.key.id}">
									<button class="btn btn-outline-success" disabled>En
										Attente</button>
								</form>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</section>

</body>

</html>