<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="org.couche.model.entities.Voie"%>

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
</head>

<body>

	<nav
		class="navbar navbar-expand-lg navbar-dark bg-success justify-content-between"
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

		<div class="float-right">
			<div class="navbar-collapse collapse">
				<c:if test="${connexionOk == true}">
					<div class="dropdown show">
						<a class="btn btn-success" href="#" role="button"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<span style="color: white;"> <i
								class="fas fa-user-circle fa-3x"></i>
						</span>
						</a>

						<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<a class="dropdown-item font-weight-bold"> ${prenom} ${nom}</a> <a
								class="dropdown-item"
								href="${pageContext.request.contextPath}/partager-site.jsp">Partager
								un site</a> <a class="dropdown-item" href="/SiteEscalade/LogOut"><i
								class="fas fa-power-off"></i>&nbsp; Déconnexion</a>
						</div>
					</div>
				</c:if>

				<c:if test="${connexionOk != true}">
					<a href="/SiteEscalade/LoginCheck"
						class="btn btn-outline-light font-weight-bold buttons"
						role="button">SE CONNECTER / S'INSCRIRE</a>
				</c:if>
			</div>
		</div>

	</nav>

	<form>
		<div class="form-group">
			<label for="nom"></label> <input type="text" class="form-control"
				id="" placeholder="Donner un nom au site">
		</div>

		<div class="form-group">
			<label for="lieu"></label> <input type="text" class="form-control"
				id="" placeholder="Lieu du site">
		</div>

		<div class="form-group">
			<label for="hauteur"></label> <input type="text" class="form-control"
				id="" placeholder="Hauteur du site en mètre">
		</div>

		<div class="form-group">
			<label for="description"></label>
			<textarea class="form-control" id=""
				rows="5" placeholder="Description du site"></textarea>
		</div>
	</form>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/c07610da30.js"
		crossorigin="anonymous"></script>

</body>

</html>