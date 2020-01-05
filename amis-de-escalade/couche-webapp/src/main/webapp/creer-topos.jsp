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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
<link rel="stylesheet" href="css/style.css">
<link rel="icon" type="image/png" href="img/Favicon.png" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
<script src="https://kit.fontawesome.com/c07610da30.js"
	crossorigin="anonymous"></script>
<style>
</style>

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

	<!-- Image de la page d'accueil pour les Topos -->
	<aside class="bg">

		<img src="img/mesTopos.PNG" class="rounded mx-auto d-block"
			height="236" alt="topos">

	</aside>

	<section>
		<form class="container" action="CreerTopos" method="post">
			<div
				class="form-group text-white bg-success text-center h-100 font-weight-bold">
				<label style="font-size: 20px;">Creation d'un Topo</label>
			</div>
			<br>
			<div class="form-group text-success">
				<label for="listeSites">Sites sélectionnés</label> <br> <select
					class="selectpicker" multiple data-live-search="true"
					title="Selectionnez les sites" id="selectSites" name="listeSites">
					
					<c:forEach var="item" items="${sites}">
						<option><c:out value="${item.nom}"/></option>
					</c:forEach>				

				</select>
			</div>
			<div class="form-group text-success">
				<label for="nomTopo">Nom du Topo</label> <input type="text"
					class="form-control" name="nomTopo" placeholder="Nom du Topo">
			</div>
			<div class="form-group text-success">
				<label for="lieuTopo">Lieu du Topo</label> <input type="text"
					class="form-control" name="lieuTopo" placeholder="Lieu du Topo">
			</div>
			<div class="form-group text-success">
				<label for="descriptionTopo">Description du Topo</label>
				<textarea class="form-control" name="descriptionTopo" rows="3"
					placeholder="Description du Topo"></textarea>
			</div>
			<button class="btn btn-success" type="submit">Envoyer le
				Topo</button>

		</form>
	</section>
</body>

<script>
	$('label[for="listeSites"]').hide();

	$(function() {
		$('#selectSites').change(function() {
			$('label[for="listeSites"]').show();
		});
	});
</script>

</html>