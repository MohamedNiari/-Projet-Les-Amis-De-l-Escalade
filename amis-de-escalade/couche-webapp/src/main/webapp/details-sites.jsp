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

	<nav class="navbar navbar-expand-lg navbar-dark bg-success" id="footer">
		<c:url var="listeDesSites" value="ListeDesSites" />
		<a class="navbar-brand" href="${listeDesSites}">Page d'accueil </a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Mon
						compte<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Réserver</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Topos</a></li>
			</ul>
			<span class="navbar-text">Tout sur l'escalade</span>
		</div>
	</nav>

	<section>
		<div class="container-fluid">
			<div class="row">
				<div id="carouselImageSite" class="carousel slide col-md-4"
					data-ride="carousel">

					<ol class="carousel-indicators">
						<li data-target="#carouselImageSite" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselImageSite" data-slide-to="1"></li>
						<li data-target="#carouselImageSite" data-slide-to="2"></li>
						<li data-target="#carouselImageSite" data-slide-to="3"></li>
					</ol>

					<div class="carousel-inner" role="listbox" id="carouselStyle">
						<div class="carousel-item active">
							<img class="img-fluid img-responsive" src="img/amisEscalade.jpg"
								alt="slide presentation"></img>
							<div class="carousel-caption d-none d-md-block"
								style="font-family: cursive; color: #685450">
								<br> <br>
								<h5>
									Découvez le site <strong>${THE_SITE.nom}</strong>
								</h5>
							</div>
						</div>
						<c:forEach items="${IMAGE_LIST}" var="item">
							<div class="carousel-item">
								<img class="img-fluid img-responsive" src="${item}"
									alt="slides du site"></img>
							</div>
						</c:forEach>
					</div>

					<a class="carousel-control-prev" href="#carouselImageSite"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselImageSite"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>

				<div class="col-md-8">
					<div class="row">
						<div class="col-md-12 box">
							<p></p>
							<h4>
								<strong>${THE_SITE.nom}</strong>
							</h4>
							<hr>
							<br>
							<p style="font-size: 0.9em; font-style: italic">${THE_SITE.description}</p>
							<br>
						</div>
					</div>

					<div class="row">
						<div class="col-md-12 box">
							<c:forEach items="${SECTEUR_LIST}" var="item">
								<h6 style="font-size: 0.8em">
									Secteur n° ${item.numeroSecteur} : <strong>${item.nom}</strong>
									<span>est composé de ${fn:length(item.voies)} voies</span>
								</h6>
								<hr>
								<p style="font-size: 0.7em; font-style: italic">${item.description}</p>

								<c:forEach items="${VOIE_LIST}" var="item">
									<table>
										<tr>
											<td>${item.cotation}</td>
											<td>${item.equiperSpits}</td>
											<td>${item.nombreLongueurs}</td>
										</tr>
									</table>
								</c:forEach>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
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