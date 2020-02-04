<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<%@ include file="meta.jsp"%>
<title>Page de Login</title>
<%@ include file="header.jsp"%>
<link rel="stylesheet" href="css/styleCompte.css" />
</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-success"
		id="barreNavigation">

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarDropDown" aria-controls="navbarText"
			aria-expanded="true" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarDropDown">
			<div class="col-10">
				<c:url var="listeDesSites" value="ListeDesSites" />
				<a class="navbar-brand" href="${listeDesSites}"><img
					src="img/amisEscaladeNav.png" alt="escalade"
					class="border border-white rounded"></a>
			</div>
			<div class="col-2">
				<a href="/SiteEscalade/LoginCheck"
					class="btn btn-outline-light font-weight-bold buttons"
					role="button">SE CONNECTER / S'INSCRIRE</a>
			</div>
		</div>
	</nav>

	<section>

		<div class="page-content">
			<div class="form-v8-content">
				<div class="form-right">
					<div class="tab">
						<c:if test="${defaultOpenRegister}">
							<div class="tab-inner">
								<button class="tablinks" onclick="choiceLogin(event, 'sign-in')">SE
									CONNECTER</button>
							</div>
							<div class="tab-inner">
								<button class="tablinks" onclick="choiceLogin(event, 'sign-up')"
									id="defaultOpen">S'INSCRIRE</button>
							</div>
						</c:if>

						<c:if test="${not defaultOpenRegister}">
							<div class="tab-inner">
								<button class="tablinks" onclick="choiceLogin(event, 'sign-in')"
									id="defaultOpen">SE CONNECTER</button>
							</div>
							<div class="tab-inner">
								<button class="tablinks" onclick="choiceLogin(event, 'sign-up')">S'INSCRIRE</button>
							</div>
						</c:if>
					</div>

					<form class="form-detail" action="LoginCheck" method="post">
						<div class="tabcontent" id="sign-in">
							<c:if test="${connexionKo != null}">
								<div class="form-row">
									<label class="form-row-inner"> <input type="text"
										class="input-text" disabled> <span
										class="label text-danger"> <i
											class="fas fa-times-circle"></i>&nbsp;<c:out
												value="${connexionKo}" />

									</span> <span class="border"></span></label>

								</div>
							</c:if>
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

	<%@ include file="scriptJs.jsp"%>
	<script type="text/javascript">
		function choiceLogin(evt, screen) {

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

			document.getElementById(screen).style.display = "block";
			evt.currentTarget.className += " active";

		}

		document.getElementById("defaultOpen").click();
	</script>

</body>

</html>