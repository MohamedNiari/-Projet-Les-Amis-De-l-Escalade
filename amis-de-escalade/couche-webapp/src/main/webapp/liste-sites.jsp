<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<script src="https://kit.fontawesome.com/c07610da30.js"
	crossorigin="anonymous"></script>
</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-success" id="footer">
		<a class="navbar-brand" href="#">Page d'accueil </a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Mon
						compte <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Réserver</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Topos</a></li>
			</ul>
			<span class="navbar-text"> Tout sur l'escalade </span>
		</div>
	</nav>

	<section class="d-flex align-content-end flex-wrap bd-highlight mb-3"
		id="cards">

		<c:forEach var="tempSite" items="${SITE_LIST}">

			<div
				class="card border-success mb-3 col-md-4 d-flex align-items-stretch">
				<div class="card-header">
					<span class="float-left">${tempSite.nom}</span> <span
						class="float-right"><small> <i
							class="fas fa-level-up-alt"></i> ${tempSite.hauteurMax} m
					</small></span>
				</div>
				<div class="card-body text-success">
					<h8 class="card-title"> <strong>Lieu</strong> ${tempSite.lieu}
					<c:if test="${tempSite.taguerOfficiel}">
						<span><img src="css/official.png" class="float-right"
							id="official" alt="official"></span></h8>
					</c:if>
					<br>
					<br>
					<p class="card-text">${tempSite.description}</p>

					<a href="https://www.w3schools.com/html/default.asp"
						class="stretched-link"></a>
				</div>
				<span class="text-secondary"><strong> Type </strong> <em>${tempSite.typeRocher}</em></span>
			</div>

		</c:forEach>
	</section>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>

</html>