<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/c07610da30.js"
	crossorigin="anonymous"></script>
<script src="js/creationSite.js" type="text/javascript"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<link rel="icon" type="image/png" href="img/Favicon.png" />
</head>

<body>

	<!-- Barre de navigation -->
	<jsp:include page="barre-navigation.jsp"></jsp:include>

	<!--  modal pour la création d'un site -->

	<div class="modal fade bd-example-modal-lg" id="creationSiteModal"
		tabindex="-1" role="dialog" aria-labelledby="creationSiteModal"
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header text-success">
					<h5 class="modal-title" id="creationSiteModal">Creation d'un
						site</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body text-success">
					<form id="formCreationSite">

						<div class="form-group">
							<label for="nomSite" class="col-form-label">Donner un nom
								au site</label> <input type="text" class="form-control" id="nomSite"
								name="nomSite" pattern="[a-z,A-Z,'-éèàêò ]+" minlength="3"
								maxlength="50"
								title="Le nom ne peut contenir que des lettres, un tiret ou un apostrophe"
								required>
						</div>
						<div class="form-group">
							<label for="lieuSite" class="col-form-label">Lieu du site</label>
							<input type="text" class="form-control" id="lieuSite"
								name="lieuSite" pattern="[a-z,A-Z,'-éèàêò ]+" minlength="3"
								maxlength="50"
								title="Le nom ne peut contenir que des lettres, un tiret ou un apostrophe"
								required>
						</div>
						<div class="form-group">
							<label for="hauteurSite" class="col-form-label">Hauteur
								du site en mètre</label> <input type="number" class="form-control"
								id="hauteurSite" name="hauteurSite" min="3" max="200"
								title="La hauteur doit être comprise entre 3 et 200 m" required>
						</div>
						<div class="form-group">
							<label for="descriptionSite" class="col-form-label">Description
								du site</label>
							<textarea class="form-control" id="descriptionSite"
								name="descriptionSite" minlength="3" maxlength=480 rows="5"
								required></textarea>
						</div>
						<div class="form-group">
							<label for="nombreSecteurs" class="col-form-label">Nombre
								de secteurs</label> <select
								class="form-control input-sm btn btn-light  dropdown-toggle border"
								name="nombreSecteurs" id="nombreSecteurs">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
						<div class="form-group">
							<label for="typeRoche" class="col-form-label">Type de
								roche</label> <select
								class="form-control input-sm btn btn-light  dropdown-toggle border"
								name="typeRoche" id="typeRoche">
								<option>Calcaire</option>
								<option>Gneiss</option>
								<option>Granite</option>
							</select>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal" onclick="resetFormSite()">Fermer</button>
							<button type="submit" class="btn btn-success"
								id="submitButtonSite">Envoyer le site</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

	<!--  modal pour la création des secteurs -->

	<div class="modal fade bd-example-modal-lg" id="creationSecteursModal"
		tabindex="-1" role="dialog" aria-labelledby="creationSecteursModal"
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header text-success">
					<h5 class="modal-title" id="creationSecteursModal">Creation
						des secteurs</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body text-success">
					<form id="formCreationSecteurs">

						<div id="secteursContent"></div>
						<input type="hidden" id="siteId" name="siteId">

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal" onclick="resetFormSecteur()">Fermer</button>
							<button type="submit" class="btn btn-success"
								id="submitButtonSecteurs">Envoyer les secteurs</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

	<!--  modal pour la création des voies -->

	<div class="modal fade bd-example-modal-lg" id="creationVoiesModal"
		tabindex="-1" role="dialog" aria-labelledby="creationVoiesModal"
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header text-success">
					<h5 class="modal-title" id="creationVoiesModal">
						Creation des voies <small>(Définir le nombre de longueurs
							par voie)</small>
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body text-success">
					<form id="formCreationVoies">

						<div id="voiesContent"></div>
						<input type="hidden" id="siteId" name="siteId">

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal" onclick="resetFormVoie()">Fermer</button>
							<button type="submit" class="btn btn-success"
								id="submitButtonVoies">Valider les voies</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>


	<!-- Image de la page d'accueil -->
	<aside class="bg">
		<img src="img/presentation.png" alt="escalade">

	</aside>

	<!-- Liste des sites spus forme de cards -->
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
						<c:param name="siteId" value="${tempSite.id}" />
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

</body>

</html>