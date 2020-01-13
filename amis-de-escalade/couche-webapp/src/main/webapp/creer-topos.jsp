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

	<jsp:include page="barre-navigation.jsp"></jsp:include>

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