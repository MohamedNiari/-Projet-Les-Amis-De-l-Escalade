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

<<<<<<< HEAD
	<nav class="navbar navbar-expand-lg navbar-dark bg-success" id="footer">
=======
	<nav
		class="navbar navbar-expand-lg navbar-dark bg-success border border-white"
		>
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
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

<<<<<<< HEAD
	<section>
		<div class="container-fluid">
			<div class="row">
				<div id="carouselImageSite" class="carousel slide col-md-4"
=======
	<section class="d-flex flex-wrap">
		<div class="col-md-4">
			<div class="row shadow-lg p-4 mb-4 bg-light border border-success">
				<div id="carouselImageSite" class="carousel slide"
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
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
<<<<<<< HEAD
								style="font-family: cursive; color: #685450">
								<br> <br>
								<h5>
									Découvez le site <strong>${THE_SITE.nom}</strong>
=======
								style="font-family: cursive; color: #695D5A">
								<br> <br>
								<h5>
									Découvez le site de <strong>${THE_SITE.nom}</strong>
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
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
<<<<<<< HEAD

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
=======
			</div>
		</div>

		<div class="col-md-8">

			<div class="shadow-lg p-4 mb-4 bg-light border border-success">
				<div class="col-md-12">
					<h4>
						<i class="fas fa-map-signs" style="color: #685450"></i> &nbsp;<strong
							style="font-family: cursive">Site de ${THE_SITE.nom}</strong>
					</h4>
					<hr>
					<br>
					<p style="font-size: 0.9em; font-style: italic">${THE_SITE.description}</p>
					<br>
				</div>

			</div>

			<div class="shadow-lg p-4 mb-4 bg-light border border-success">

				<c:forEach items="${SECTEUR_LIST}" var="itemSecteur">
					<div style="margin-bottom: 2%">
						<h6 style="font-size: 1.1em">
							<i class="fas fa-share" style="color: #685450"></i> &nbsp; Secteur n°
							${itemSecteur.numeroSecteur} : <strong>${itemSecteur.nom}</strong>
							<span class="float-right">${fn:length(itemSecteur.voies)}
								voies</span>
						</h6>
						<hr>
						<br>
						<p style="font-size: 0.9em; font-style: italic">${itemSecteur.description}</p>

						<c:forEach items="${itemSecteur.voies}" var="itemVoie">
							<div class="card-deck">
								<div class="card">
									<div class="card-body">
										<div class="row border-bottom card-title font-weight-bold"
											style="font-size: 0.8em">
											<div class="col-sm">
												<p>
													Voie n° ${itemVoie.numeroVoie} <i
														class="fas fa-flag-checkered float-right"></i>
												</p>
											</div>
										</div>
										<div class="card-text">
											<table class="table">
												<thead class="thead-light">
													<tr>
														<th scope="col">Longueur</th>
														<th scope="col">Mesure</th>
														<th scope="col">Cotation</th>
														<th scope="col">Equipée Spits</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${itemVoie.longueurs}" var="itemLongueur">
														<tr>
															<th scope="row">${itemLongueur.numeroLongueur}</th>
															<td>${itemLongueur.mesure}</td>
															<td>${itemLongueur.cotation}</td>
															<td>
																<c:choose>
																	<c:when test="${itemLongueur.equiperSpits == true}">
															            Oui
															         </c:when>
																	<c:otherwise>
															            Non
															         </c:otherwise>
																</c:choose>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>

										</div>
										<div class="card-footer">
											<small class="text-muted float-right">${itemVoie.nombreLongueurs}
												Longueurs</small>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</c:forEach>
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
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