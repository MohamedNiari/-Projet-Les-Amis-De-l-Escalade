<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Barre de navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-success"
	id="barreNavigation">

	<c:url var="listeDesSites" value="ListeDesSites" />
	<a class="navbar-brand" href="${listeDesSites}"><img
		src="img/amisEscaladeNav.png" alt="escalade"
		class="border border-white rounded"></a>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarDropDown" aria-controls="navbarText"
		aria-expanded="true" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="navbar-collapse collapse" id="navbarDropDown">
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
					name="lieu" onchange="this.form.submit()" style="font-size: 0.9em;"
					value="${lieu}">
			</div>
		</form>
		<c:if test="${connexionOk == true}">
			<div class="dropdown show">
				<a class="btn btn-success" href="#" role="button"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<span style="color: white;"> <i
						class="fas fa-user-circle fa-3x fas fa-bell"></i>
				</span> 
				
				<c:if test="${nombreReservation > 0}">
					<span class="badge badge-danger">${nombreReservation}</span>
				</c:if>
				</a>

				<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
					<a class="dropdown-item font-weight-bold"> ${prenom} ${nom}</a>

					<button type="button" class="dropdown-item" data-toggle="modal"
						data-target="#creationSiteModal" data-whatever="@mdo">Partager
						un Site</button>

					<a class="dropdown-item" href="/SiteEscalade/MesTopos"> Mes
						Topos 
						<c:if test="${nombreReservation > 0}">
						<span class="badge badge-danger">${nombreReservation}</span>
						</c:if>
					</a> <a class="dropdown-item" href="/SiteEscalade/ReservationServlet">
						Réservation </a> <a class="dropdown-item" href="/SiteEscalade/LogOut"><i
						class="fas fa-power-off"></i>&nbsp; Déconnexion</a>
				</div>
			</div>
		</c:if>

		<c:if test="${connexionOk != true}">
			<a href="/SiteEscalade/LoginCheck"
				class="btn btn-outline-light font-weight-bold buttons" role="button">SE
				CONNECTER / S'INSCRIRE</a>
		</c:if>
	</div>

</nav>