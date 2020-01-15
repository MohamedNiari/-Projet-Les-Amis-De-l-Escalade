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
	<jsp:include page="barre-navigation.jsp"></jsp:include>

	<!-- Image de la page d'accueil pour les Topos -->
	<aside class="bg">

		<img src="img/mesTopos.PNG" class="rounded mx-auto d-block"
			height="236" alt="topos">

	</aside>

	<section>
		<div class="row">
			<div class="col-md-3">
				<span class="btn btn-success font-weight-bold"
					style="border-width: 3px;"> <i class="fas fa-book"></i>&nbsp;
					MES TOPOS
				</span>
			</div>

			<div class="col-md-6">

				<!-- Toast pour notifier une demande de réservation en attente-->
				<c:if test="${nombreReservation > 0}">
					<div aria-live="polite" aria-atomic="true"
						class="d-flex justify-content-center align-items-center"
						style="min-height: 100px;">
						<div role="alert" aria-live="assertive" aria-atomic="true"
							class="toast" style="min-width: 500px;" data-autohide="false">
							<div
								class="toast-header bg-success text-white border border-light rounded">
								<i class="fas fa-chevron-circle-right text-dark"></i>&nbsp; <strong
									class="mr-auto">Demande de réservation</strong>

								<button type="button" class="ml-2 mb-1 close"
									data-dismiss="toast" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<c:forEach var="item" items="${mapReservationAttentes}">
								<div
									class="toast-body bg-success text-white border border-light rounded">
									<br>&nbsp;<strong>${item.value.prenoms.iterator().next()}
										${item.value.nom}</strong> souhaite réserver votre topo n° <strong>${item.key.id}</strong>
									<br> <br>
									<form action="ConfirmationReservation" method="post">
										<input type="hidden" name="topoId" value="${item.key.id}">
										<input type="hidden" name="reservationId" value="${item.key.id}">
										<button class="btn btn-dark btn-sm" name="accepter">Accepter</button>
										<button class="btn btn-dark btn-sm" name="refuser">Refuser</button>
									</form>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:if>
			</div>

			<div class="col-md-3">
				<a href="/SiteEscalade/CreerTopos"
					class="btn btn-outline-success font-weight-bold buttons float-right"
					role="button">Créer un nouveau Topo</a>
			</div>
		</div>

		<br>
		<hr>
		<br>
		<table class="table col-md-12">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Numéro</th>
					<th scope="col">Nom</th>
					<th scope="col">Lieu</th>
					<th scope="col">Description</th>
					<th scope="col">Date de parution</th>
					<th scope="col">Disponible</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${topos}">

					<tr>
						<th scope="row"><c:out value="${item.id}" /></th>
						<td><c:out value="${item.nom}" /></td>
						<td><c:out value="${item.lieu}" /></td>
						<td><c:out value="${item.description}" /></td>
						<td><c:out value="${item.dateParution}" /></td>
						<td>
							<form action="MesTopos" method="post">
								<input type="hidden" name="topoId" value="${item.id}"> <select
									name="disponibiliteSite" onchange="this.form.submit()">
									<option selected>${item.disponible == false ? "Non" : "Oui"}
									</option>
									<option>${item.disponible == false ? "Oui" : "Non"}</option>
								</select>
							</form>
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>

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

	<script>
		$('.toast').toast('show');
	</script>

</body>

</html>