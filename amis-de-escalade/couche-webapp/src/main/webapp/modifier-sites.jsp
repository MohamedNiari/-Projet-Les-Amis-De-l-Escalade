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
	<!-- Barre de navigation -->
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

		<div>
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

			<span class="navbar-text">&nbsp; Tout sur l'escalade </span>
		</div>

	</nav>


	<section class="d-flex flex-wrap">

		<!-- Carousel d'images pour le site -->
		<div class="col-md-4">
			<div class="row shadow-lg p-4 mb-4 bg-light border border-success">
				<div id="carouselImageSite" class="carousel slide"
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
								style="font-family: cursive; color: #695D5A">
								<br> <br>
								<h5>
									Découvez le site de <strong>${THE_SITE.nom}</strong>
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
			</div>
		</div>

		<!-- Détails du site, secteurs et longueurs -->
		<div class="col-md-8">

			<!-- Formulaire de modification du site et de ses composants -->
			<form method="post" id="formModifierSite" action="ModificationSite"
				enctype="multipart/form-data">

				<div class="shadow-lg p-4 mb-4 bg-light border border-success">
					<div class="col-md-12">
						<div class="form-group">
							<h4>
								<i class="fas fa-map-signs" style="color: #685450"></i> &nbsp;<strong
									style="font-family: cursive"> <label for="nomSite">Nom
										du Site </label> <input type="text" name="nomSite" id="nomSite"
									class="form-control" value="${THE_SITE.nom}" /></strong>
							</h4>
						</div>
						<hr>
						<br> <label for="descriptionSite" class="font-italic">Description
							du site</label>

						<textarea type="text" name="descriptionSite" id="descriptionSite"
							class="form-control input-sm font-italic" rows="5">${THE_SITE.description}</textarea>
						<br>
					</div>
				</div>

				<div class="shadow-lg p-4 mb-4 bg-light border border-success">

					<c:forEach items="${SECTEUR_LIST}" var="itemSecteur">
						<div style="margin-bottom: 2%">
							<div class="form-row">
								<div class="col">
									<h6 style="font-size: 1.1em">
										<i class="fas fa-share" style="color: #685450"></i> &nbsp;
										Secteur n° ${itemSecteur.numeroSecteur} : <strong> <input
											type="text" name="nomSecteur" class="form-control"
											value="${itemSecteur.nom}" />

										</strong>
									</h6>
								</div>
								<div class="col">
									<span class="float-right" style="font-size: 0.8em"> <label
										for="nombreVoies" class="font-weight-bold">Nombre de voies</label> <select
										class="form-control-sm" id="nombreVoies" name="nombreVoies">
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
											<option>6</option>
											<option>7</option>
											<option>8</option>
											<option>9</option>
											<option>10</option>
									</select>
									</span>
								</div>
							</div>
							<hr>
							<br>
							<p style="font-size: 0.9em; font-style: italic">

								<textarea type="text" name="descriptionSite"
									class="form-control input-sm font-italic" rows="3">${itemSecteur.description}</textarea>

							</p>

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
														<c:forEach items="${itemVoie.longueurs}"
															var="itemLongueur">
															<tr>
																<th scope="row">${itemLongueur.numeroLongueur}</th>
																<td>${itemLongueur.mesure}</td>
																<td>${itemLongueur.cotation}</td>
																<td><c:choose>
																		<c:when test="${itemLongueur.equiperSpits == true}">
															            Oui
															         </c:when>
																		<c:otherwise>
															            Non
															         </c:otherwise>
																	</c:choose></td>
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
				</div>
				<div>
					<button type="submit" class="btn btn-success btn md float-right">Valider
						le site</button>
				</div>
			</form>
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