<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<%@ include file="meta.jsp"%>
<title>Topos disponible</title>
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
					TOPOS DISPONIBLE
				</span>
			</div>
			<div class="col-md-6"></div>
			<div class="col-md-3"></div>
		</div>

		<br>
		<hr>
		<br>
		<div class="table-responsive">
			<table class="table col-md-12">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Numéro</th>
						<th scope="col">Nom</th>
						<th scope="col">Lieu</th>
						<th scope="col">Description</th>
						<th scope="col">Date de parution</th>
						<th scope="col">Statut</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${mapTopoAttente}">
						<tr>
							<th scope="row"><c:out value="${item.key.id}" /></th>
							<td><c:out value="${item.key.nom}" /></td>
							<td><c:out value="${item.key.lieu}" /></td>
							<td><c:out value="${item.key.description}" /></td>
							<td><c:out value="${item.key.dateParution}" /></td>
							<td><c:if test="${item.value == false}">
									<form action="ReservationServlet" method="post">
										<input type="hidden" name="topoId" value="${item.key.id}">
										<button class="btn btn-outline-success" type="submit">Réserver</button>
									</form>
								</c:if> <c:if test="${item.value == true}">
									<form action="ReservationServlet" method="post">
										<input type="hidden" name="topoId" value="${item.key.id}">
										<button class="btn btn-outline-success" disabled>En
											Attente</button>
									</form>
								</c:if></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
	<%@ include file="scriptJs.jsp"%>

</body>

</html>