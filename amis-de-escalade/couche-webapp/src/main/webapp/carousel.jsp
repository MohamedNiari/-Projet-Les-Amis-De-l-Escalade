<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--  Carousel d'image pour un site -->

<div class="row shadow-lg p-4 mb-4 bg-light border border-success">
	<div id="carouselImageSite" class="carousel slide" style="width: 100%;"
		data-ride="carousel">

		<ol class="carousel-indicators">
			<li data-target="#carouselImageSite" data-slide-to="0" class="active"></li>
			<li data-target="#carouselImageSite" data-slide-to="1"></li>
			<li data-target="#carouselImageSite" data-slide-to="2"></li>
			<li data-target="#carouselImageSite" data-slide-to="3"></li>
		</ol>

		<div class="carousel-inner" role="listbox" id="carouselStyle">
			<div class="carousel-item active">
				<img class="img-fluid img-responsive" src="img/amisEscalade.jpg"
					alt="slide presentation"></img>
				<div class="carousel-caption d-none d-md-block"
					style="font-family: cursive; color: #695D5A">
					<br> <br>
					<h5 id="decouvrezSite">
						Découvrez le site de <strong>${THE_SITE.nom}</strong>
					</h5>
				</div>
			</div>
			<c:forEach items="${IMAGE_LIST}" var="item">
				<div class="carousel-item">
					<figure class="cadre">
						<img class="img-fluid img-responsive" src="${item}"
							alt="Pas encore d'image pour ce site"></img>
					</figure>
				</div>
			</c:forEach>
		</div>

		<a class="carousel-control-prev" href="#carouselImageSite"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselImageSite"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
</div>