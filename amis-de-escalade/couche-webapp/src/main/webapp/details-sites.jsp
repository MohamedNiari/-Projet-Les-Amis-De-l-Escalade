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

		<!-- Recherche multi-critères -->
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
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<span style="color: white;"> <i
							class="fas fa-user-circle fa-3x"></i>
					</span>
					</a>

					<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<a class="dropdown-item font-weight-bold"> ${prenom} ${nom}</a>

						<button type="button" class="dropdown-item" data-toggle="modal"
							data-target="#creationSiteModal" data-whatever="@mdo">Partager
							un site</button>

						<a class="dropdown-item" href="/SiteEscalade/LogOut"><i
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

	</nav>

	<!-- Carousel d'images d'un site -->
	<section class="d-flex flex-wrap">
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

			<!-- Commentaire -->
			<c:if test="${connexionOk == true}">
				<div class="row shadow-lg p-4 mb-4 bg-light border border-success">
					<form action="CommentaireServlet" method="post"
						id="formCreationSite" style="width: 100%;">
						<h5>
							<strong style="font-family: cursive">Laissez votre
								commentaire</strong>&nbsp; <i class="far fa-comment float-right"
								style="color: #685450"></i> <input type="hidden" name="siteId"
								value="${THE_SITE.siteId}">
						</h5>
						<hr>
						<br>
						<div class="form-group">
							<textarea class="form-control" name="commentaire" minlength="3"
								maxlength="300" rows="3" required></textarea>

						</div>
						<button type="submit" class="btn btn-success"
							id="submitCommentaire">Envoyer</button>
						<br> <br>
						<hr>
						<br>
					</form>

					<c:forEach var="tempCommentaire" items="${commentaires}">
						<div style="width: 100%;">
						
							<c:set var="enableDisable" value="disabled"></c:set>
							<c:set var="tohide" value="hidden"></c:set>
							<c:if test="${membreAssociation == true}">
								<c:set var="enableDisable" value=""></c:set>
								<c:set var="tohide" value="submit"></c:set>
							</c:if>
							
							<form action="CommentaireServlet" method="get"
								style="width: 100%;">
								<input type="hidden" name="commentaireId" value="${tempCommentaire.commentaireId}">
								<input type="hidden" name="siteId" value="${THE_SITE.siteId}">

								<textarea class="form-control text-success" name="commentaire" minlength="3"
									maxlength="300" rows="3" required <c:out value="${enableDisable}"/>>${tempCommentaire.texte}</textarea>

								<small>Par <strong>${tempCommentaire.utilisateur.prenoms.iterator().next()}
				
										${tempCommentaire.utilisateur.nom}</strong> le
									${tempCommentaire.dateDuCommentaire}
								</small> 
								<br>
								<input type="${tohide}" class="btn btn-success btn-sm" name="update" value="Modifier" >
								<input type="${tohide}" class="btn btn-success btn-sm"
									name="delete" value="Supprimer">
							</form>
							<br>
							<hr>
							<br>
						</div>
					</c:forEach>

				</div>
			</c:if>

		</div>

		<div class="col-md-8">

			<!-- Information du site -->
			<div class="shadow-lg p-4 mb-4 bg-light border border-success">
				<div class="col-md-12">
					<div class="container">
						<div class="row">
							<div class="col-md-6">
								<h4>
									<i class="fas fa-map-signs" style="color: #685450"></i> &nbsp;<strong
										style="font-family: cursive">Site ${THE_SITE.nom}</strong>
								</h4>
							</div>
							<div class="col-md-6">
								<c:if test="${connexionOk == true && membreAssociation == true}">
									<form class="float-right" action="TaguerSite" method="post">
										<input type="hidden" name="siteId" value="${THE_SITE.siteId}">
										<select style="font-size: 70%;"
											class="form-control-sm input-small btn btn-light dropdown-toggle border text-success font-weight-bold"
											name="taguerOfficiel" onchange="this.form.submit()">
											<option>Taguer Officiel</option>
											<option>Oui</option>
											<option>Non</option>
										</select>
									</form>
								</c:if>
							</div>
						</div>
					</div>
					<hr>
					<br>

					<p style="font-size: 0.9em; font-style: italic">
						<c:if test="${THE_SITE.taguerOfficiel}">
							<span><img src="img/official.png" alt="official"
								id="official2" class="float-right"></img></span>
						</c:if>${THE_SITE.description}</p>

					<br>
				</div>
			</div>

			<!-- Détails des secteurs -->
			<div class="shadow-lg p-4 mb-4 bg-light border border-success">

				<c:forEach items="${SECTEUR_LIST}" var="itemSecteur">
					<div style="margin-bottom: 2%">
						<h6 style="font-size: 1.1em">
							<i class="fas fa-share" style="color: #685450"></i> &nbsp;
							Secteur n° ${itemSecteur.numeroSecteur} : <strong>${itemSecteur.nom}</strong>
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