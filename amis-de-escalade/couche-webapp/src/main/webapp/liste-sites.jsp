<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<%@ include file="meta.jsp"%>

<title>Liste des Sites</title>

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

	<!--  modals pour la création d'un site -->
	<jsp:include page="modal-creation-site.jsp"></jsp:include>

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
</body>

</html>