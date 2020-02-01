<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
						<label for="hauteurSite" class="col-form-label">Hauteur du
							site en mètre</label> <input type="number" class="form-control"
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
				<h5 class="modal-title" id="creationSecteursModal">Creation des
					secteurs</h5>
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