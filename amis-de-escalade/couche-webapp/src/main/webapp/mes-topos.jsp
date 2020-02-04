<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<%@ include file="meta.jsp"%>
<title>Mes topos</title>
<%@ include file="header.jsp"%>
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
							<c:forEach var="item" items="${reservations}">
								<div
									class="toast-body bg-success text-white border border-light rounded">
									<br>&nbsp;<strong>${item.utilisateur.prenoms.iterator().next()}
										${item.utilisateur.nom}</strong> souhaite réserver votre topo n° <strong>${item.topo.id}</strong>
									<br> <br>
									<form action="ConfirmationReservation" method="post">
										<input type="hidden" name="topoId" value="${item.topo.id}">
										<input type="hidden" name="reservationId" value="${item.id}">
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
		<div class="table-responsive">
			<table class="table">
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
									<input type="hidden" name="topoId" value="${item.id}">
									<select name="disponibiliteSite" onchange="this.form.submit()">
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
		</div>

	</section>

	<%@ include file="scriptJs.jsp"%>
	<script>
		$('.toast').toast('show');
	</script>

</body>

</html>