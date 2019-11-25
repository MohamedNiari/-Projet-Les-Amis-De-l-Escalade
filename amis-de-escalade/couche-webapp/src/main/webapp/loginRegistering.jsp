<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c07610da30.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/sourcesanspro-font.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/styleCompte.css" />
<link rel="icon" type="image/png" href="img/Favicon.png" />
</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-success"
		id="barreNavigation">

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="true" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse">
			<c:url var="listeDesSites" value="ListeDesSites" />
			<a class="navbar-brand" href="${listeDesSites}"><img
				src="img/amisEscaladeNav.png" alt="escalade"
				class="border border-white rounded"></a>

			<ul class="navbar-nav mr-auto">
				<li class="navbar-nav mr-auto"><a class="nav-link" href="#">Mon
						compte <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Réserver</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Topos</a></li>
			</ul>

			<a href="/SiteEscalade/LoginCheck"
				class="btn btn-outline-light font-weight-bold buttons" role="button">SE
				CONNECTER / S'INSCRIRE</a>
		</div>
	</nav>

	<section>

		<div class="page-content">
			<div class="form-v8-content">
				<div class="form-right">
					<div class="tab">
						<div class="tab-inner">
							<button class="tablinks" onclick="openCity(event, 'sign-in')"
								id="defaultOpen">SE CONNECTER</button>
						</div>
						<div class="tab-inner">
							<button class="tablinks" onclick="openCity(event, 'sign-up')">S'INSCRIRE</button>
						</div>
					</div>
					<form class="form-detail" action="LoginCheck" method="post">
						<div class="tabcontent" id="sign-in">
							<div class="form-row">
								<label class="form-row-inner"> <input type="text"
									class="input-text" disabled> <span
									class="label text-danger"> <c:if
											test="${connexionKo != null}">
											<i class="fas fa-times-circle"></i>&nbsp;<c:out
												value="${connexionKo}" />
										</c:if>
								</span> <span class="border"></span></label>

							</div>
							<div class="form-row">
								<label class="form-row-inner"> <input type="text"
									name="adresseMail" class="input-text" required> <span
									class="label">Adresse Mail</span><span class="border"></span>
								</label>
							</div>
							<div class="form-row">
								<label class="form-row-inner"> <input type="password"
									name="motDePasse" class="input-text" required> <span
									class="label">Mot de Passe</span> <span class="border"></span>
								</label>
							</div>
							<div class="form-row-last">
								<input type="submit" name="register" class="register"
									value="Se Connecter">
							</div>
						</div>
					</form>
					<form class="form-detail" action="Inscription" method="post">
						<div class="tabcontent" id="sign-up">
							<div class="form-row">
								<label class="form-row-inner"> <span
									class="text-danger float-right">${erreurs['prenom']}</span> <input
									type="text" name="prenomInscription" class="input-text"
									value="${prenom}" required> <span class="label">Prenom</span>
									<span class="border"></span>
								</label>
							</div>
							<div class="form-row">
								<label class="form-row-inner"> <span
									class="text-danger float-right">${erreurs['nom']}</span> <input
									type="text" name="nomInscription" class="input-text"
									value="${nom}" required> <span class="label">Nom</span>
									<span class="border"></span>
								</label>
							</div>
							<div class="form-row">
								<label class="form-row-inner"> <span
									class="text-danger float-right">${erreurs['email']}</span> <input
									type="text" name="emailInscription" class="input-text"
									value="${email}" required> <span class="label">Adresse
										Mail</span> <span class="border"></span>
								</label>
							</div>
							<div class="form-row">
								<label class="form-row-inner"> <span
									class="text-danger float-right">${erreurs['motDePasse']}</span>
									<input type="password" name="motDePasseInscription"
									class="input-text" required> <span class="label">Mot
										de Passe</span> <span class="border"></span>
								</label>
							</div>
							<div class="form-row">
								<label class="form-row-inner"> <input type="password"
									name="motDePasseConfirmationInscription" class="input-text"
									required> <span class="label">Confirmez Mot de
										Passe</span> <span class="border"></span>
								</label>
							</div>
							<div class="form-row">
								<label class="form-row-inner"> <span
									class="text-danger float-right">${erreurs['ville']}</span> <input
									type="text" name="villeInscription" class="input-text"
									value="${ville}" required> <span class="label">Ville</span>
									<span class="border"></span>
								</label>
							</div>
							<div class="form-row">
								<label class="form-row-inner"> <span
									class="text-danger float-right">${erreurs['pays']}</span> <input
									type="text" name="paysInscription" class="input-text"
									value="${not empty pays ? pays : 'France'}" required> <span
									class="label">Pays</span> <span class="border"></span>
								</label>
							</div>
							<div class="form-row-last">
								<input type="submit" name="register" class="register"
									value="S'inscrire">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</section>


	<script type="text/javascript">
		function openCity(evt, cityName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " active";
		}

		document.getElementById("defaultOpen").click();
	</script>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>

</html>