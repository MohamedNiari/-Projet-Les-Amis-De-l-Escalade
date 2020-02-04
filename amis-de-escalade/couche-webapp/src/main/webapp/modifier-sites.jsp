<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
<%@ include file="meta.jsp"%>
<title>Modifier site</title>
<%@ include file="header.jsp"%>
</head>

<!-- Changement de "Browser" en "Parcourir" -->
<style>
.custom-file-label::after {
	content: "Parcourir" !important;
}
</style>

<body>

	<!-- Barre de navigation -->
	<jsp:include page="barre-navigation.jsp"></jsp:include>

	<!-- Modals pour la création d'un site -->
	<jsp:include page="modal-creation-site.jsp"></jsp:include>

	<!-- Message d'alerte pour création des images -->
	<div class="alert alert-warning alert-dismissible fade show"
		role="alert">
		<strong>IMPORTANT!</strong> Pensez à enregistrer vos images avant de
		valider les longueurs
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>

	<section class="d-flex flex-wrap">
		<div class="col-md-4">
			<%@ include file="carousel.jsp"%>

			<div class="card border border-success">
				<form method="post" action="TelechargerImages?siteId=${siteId}"
					enctype="multipart/form-data">

					<div class="form-group m-3">
						<div class="custom-file mb-3">
							<input type="file" class="custom-file-input" id="customFile"
								lang="fr" multiple name="filename"> <label
								class="custom-file-label" for="customFile">Choisir 3
								images (max)</label>
						</div>
						<div class="mt-3">
							<input type="submit" class="btn btn-success" />
						</div>
					</div>

				</form>
			</div>
		</div>

		<div class="col-md-8">

			<!-- Information du site -->
			<div class="shadow-lg p-4 mb-4 bg-light border border-success">
				<c:if test="${nouveauNomSite == true}">
					<!-- Message d'alerte de changement de nom du site -->
					<div class="alert alert-info alert-dismissible fade show"
						role="alert">
						<strong>INFORMATION!</strong> Pour cause de doublon, le nom du
						site a été changé
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:if>
				
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
				<h5 class="text-success">
					Création des longueurs <small class="text-secondary"> (
						Veuillez définir les mesures, les cotations et les spits équipés
						ou pas )</small> <i
						class="far fa-hand-point-down float-right text-secondary font-weight-bold"></i>
				</h5>
				<hr>
				<br>
			</div>


			<!-- Creation des longueurs -->
			<div class="shadow-lg p-4 mb-4 bg-light border border-success">
				<form method="post" action="CreationLongueur">
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
							<input type="hidden" id="siteId" name="siteId" value="${siteId}">

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
												<div class="table-responsive">
													<table class="table">
														<thead>
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
																	<td><input type="number" class="form-control-sm"
																		min="1" max="30"
																		title="La hauteur doit être comprise entre 1 et 30 m"
																		required value="${itemLongueur.mesure}"
																		name="mesureSecteurNum${itemSecteur.numeroSecteur}VoieNum${itemVoie.numeroVoie}longueurNum${itemLongueur.numeroLongueur}">
																	</td>
																	<td><input type="text" class="form-control-sm"
																		pattern="[1-9][a-c]" required
																		value="${itemLongueur.cotation}"
																		name="cotationSecteurNum${itemSecteur.numeroSecteur}VoieNum${itemVoie.numeroVoie}longueurNum${itemLongueur.numeroLongueur}">
																	</td>
																	<td><select class="form-control-sm"
																		name="spitsSecteurNum${itemSecteur.numeroSecteur}VoieNum${itemVoie.numeroVoie}longueurNum${itemLongueur.numeroLongueur}">
																			<option>Non</option>
																			<option>Oui</option>
																	</select></td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>

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
					<button type="submit" class="btn btn-success"
						id="submitButtonLongueur">Envoyer les longueurs</button>
				</form>
			</div>
		</div>
	</section>

	<%@ include file="scriptJs.jsp"%>

	<!--  Gestion de l'upload d'images -->
	<script>
		$("#customFile").change(
				function() {
					var files = $(this)[0].files;
					$(this).siblings(".custom-file-label").html("");
					for (var i = 0; i < files.length; i++) {
						if (i == 0)
							$(this).siblings(".custom-file-label").append(
									files[i].name);
						else
							$(this).siblings(".custom-file-label").append(
									", " + files[i].name);
					}
				});
	</script>
</body>

</html>