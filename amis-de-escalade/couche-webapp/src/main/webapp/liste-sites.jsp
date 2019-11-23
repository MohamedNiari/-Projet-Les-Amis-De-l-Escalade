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
<script src="https://kit.fontawesome.com/c07610da30.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/style.css">
<link rel="icon" type="image/png" href="img/Favicon.png" />
</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-success"
		id="barreNavigation">

		<c:url var="listeDesSites" value="ListeDesSites" />
		<a class="navbar-brand" href="${listeDesSites}"><img
			src="img/amisEscaladeNav.png" alt="escalade"
			class="border border-white rounded"></a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="true" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="">
			<ul class="navbar-nav nav-fill w-100">
				<li class="navbar-nav mr-auto"><a class="nav-link" href="#">Mon
						compte <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Réserver</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Topos</a></li>
			</ul>
		</div>

		<div class="navbar-collapse collapse">
			<form action="RechercheSite" method="post"
				class="form-inline my-2 my-lg-0" style="margin: 0 auto;">

				<div class="col-auto">
					<label for="nombreSecteurs" class="text-white"
						style="font-size: 0.7em;"> <c:out
							value="Nombre de Secteurs" />
					</label> <select
						class="form-control input-sm btn btn-secondary dropdown-toggle border border-white"
						name="nombreSecteurs" onchange="this.form.submit()"
						style="font-size: 0.9em;">
						<c:set var="listNombreSecteurs">Tous,1,2,3,4,5</c:set>
						<c:forEach var="item" items="${listNombreSecteurs}">
							<option value="${item}"
								${item == nombreSecteurs ? "selected" : ""}>${item}</option>
						</c:forEach>
						<option disabled>------------------</option>
					</select>
				</div>

				<div class="col-auto">
					<label for="typeRoche" class="text-white" style="font-size: 0.7em;">
						<c:out value="Type de Roche" />
					</label> <select
						class="form-control input-sm btn btn-secondary dropdown-toggle border border-white"
						name="typeRoche" onchange="this.form.submit()"
						style="font-size: 0.9em;">
						<c:set var="listTypeRoche">Tous,Calcaire,Granite,Gneiss</c:set>
						<c:forEach var="item" items="${listTypeRoche}">
							<option value="${item}"
								<c:if test="${item == typeRoche}"> selected </c:if>>${item}</option>
						</c:forEach>
						<option disabled>------------------</option>
					</select>
				</div>

				<div class="col-auto">
					<label for="lieu" class="text-white" style="font-size: 0.7em;">
						<c:out value="Lieu" />
					</label> <input
						class="form-control input-sm btn btn-secondary dropdown-toggle border border-white"
						name="lieu" onchange="this.form.submit()"
						style="font-size: 0.9em;" value="${lieu}">
				</div>
			</form>
			<c:if test="${connexionOk == true}">
				<div class="dropdown show">
					<a class="btn btn-success" href="#" role="button"
						 data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <span style="color: white;"> <i
							class="fas fa-user-circle fa-3x"></i>
					</span>
					</a>

					<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a> <a
							class="dropdown-item" href="/SiteEscalade/LogOut"><i class="fas fa-power-off"></i>&nbsp; Déconnexion</a>
					</div>
				</div>
			</c:if>

			<c:if test="${connexionOk != true}">
				<a href="/SiteEscalade/LoginCheck"
					class="btn btn-outline-light font-weight-bold buttons"
					role="button">SE CONNECTER / S'INSCRIRE</a>
			</c:if>
		</div>

	</nav>

	<aside class="bg">
		<img src="img/presentation.png" alt="escalade">

	</aside>

	<section class="d-flex flex-wrap" id="cards">

		<c:forEach var="tempSite" items="${SITE_LIST}">

			<div class="card border-success mb-3 col-md-4 shadow-lg p-4 mb-4">
				<div class="card-header bg-transparent border-success">
					<span class="float-left"><strong>${tempSite.nom}</strong></span> <span
						class="float-right"><small> <i
							class="fas fa-level-up-alt"></i> ${tempSite.hauteurMax} m
					</small></span>
				</div>
				<div class="card-body text-success">
					<h6 class="card-title">
						<strong>Lieu</strong> ${tempSite.lieu}
						<c:if test="${tempSite.taguerOfficiel}">
							<span><img src="img/official.png" class="float-right"
								id="official" alt="official"></img></span>
						</c:if>
					</h6>
					<br> <br>
					<p class="card-text">${tempSite.description}</p>

					<c:url var="detailsDesSites" value="DetailsDesSites">
						<c:param name="siteId" value="${tempSite.siteId}" />
					</c:url>
					<a href="${detailsDesSites}" class="stretched-link"></a>
				</div>
				<div
					class="card-footer bg-transparent border-success text-secondary">
					<strong> Type </strong> <em>${tempSite.typeRocher}</em>
				</div>
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