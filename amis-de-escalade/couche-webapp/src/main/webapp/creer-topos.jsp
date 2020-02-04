<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<%@ include file="meta.jsp"%>
<title>Creation de topos</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<%@ include file="scriptJs.jsp"%>
<%@ include file="header.jsp"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>

</head>

<body>

	<!-- Barre de navigation -->
	<jsp:include page="barre-navigation.jsp"></jsp:include>

	<!--  modals pour la création d'un site -->
	<jsp:include page="modal-creation-site.jsp"></jsp:include>

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
						<option><c:out value="${item.nom}" /></option>
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
					placeholder="Description du Topo" maxlength="200"></textarea>
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