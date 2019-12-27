$(document).ready(function() {
	
	$('#formCreationSite').submit(function (e) {
		e.preventDefault();
		$.ajax({
			url: 'CreationSite',
			type: 'POST',
			data: {
				nomSite: $('#nomSite').val(),
				lieuSite: $('#lieuSite').val(),
				hauteurSite: $('#hauteurSite').val(),
				descriptionSite: $('#descriptionSite').val(),
				nombreSecteurs: $('#nombreSecteurs').val(),
				typeRoche: $('#typeRoche').val()
			},

			success: function (response) {
				for (var i = 1; i <= response.nombreSecteurs; i++) {
					$('#secteursContent').append("<hr><br><h6 class='text-dark'>Secteur numéro " + i + "</h6>");
					$('#secteursContent').append("<div class='row'><div class='col'><label for='nomSecteurNum" + i + "' class='col-form-label'>Nom du secteur</label> <input type='text' class='form-control' id='nomSecteurNum" + i + "' name='nomSecteurNum" + i + "'></div><div class='col'><label for='nombreVoiesSecteurNum" + i + "' class='col-form-label'>Nombre de voies</label><select class='form-control' id='nombreVoiesSecteurNum" + i + "' name='nombreVoiesSecteurNum" + i + "'><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option><option>8</option><option>9</option><option>10</option></select></div></div>");
					$('#secteursContent').append("<div class='form-group'><label for='descriptionSecteurNum" + i + "' class='col-form-label'>Description du secteur</label><textarea class='form-control' id='descriptionSecteurNum" + i + "' name='descriptionSecteurNum" + i + "'	maxlength=200></textarea></div>");
				}
				
				$("#siteId").val(response.siteId);
				$('#creationSiteModal').modal('hide');
				$('#creationSecteursModal').css('overflow-y', 'auto');
				$('#creationSecteursModal').modal('show');
			}
		});

	});
	
	$('#formCreationSecteurs').submit(function(e) {
		e.preventDefault();
		var data = {}
		$('#formCreationSecteurs input, #formCreationSecteurs select, #formCreationSecteurs textarea').each(function () {
			data[this.name] = this.value;
		});
		$.ajax({
			url : 'CreationSecteurs',
			type : 'POST',
			data : {
				siteId : $("#siteId").val(),
				secteursData : JSON.stringify(data)
			},

			success : function(response) {
				for (var i = 0; i < response.nombreSecteurs; i++) {
					$('#voiesContent').append("<hr><br><h6 class='text-dark'>Secteur numéro " + (i + 1) + "</h6>");
										
					for (var j = 0; j < response.totalVoies[i]; j++) {
						$('#voiesContent').append("<div class='row'><div class='col'><label class='col-form-label'>Voie n° " + (j + 1) + "</label></div><div class='col d-flex justify-content-around'><label for='secteurNum" + (i + 1) + "nombrelongueurVoieNum" + (j + 1) + "' class='col-form-label'>Nombre de longueurs</label><select class='form-control-sm input-small' id='secteurNum" + (i + 1) + "nombrelongueurVoieNum" + (j + 1) + "'name='secteurNum" + (i + 1) + "nombrelongueurVoieNum" + (j + 1) + "'><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option><option>8</option><option>9</option><option>10</option></select></div></div>");
					}					
			
				}
				
				  $("#siteId").val(response.siteId);																											
				  $('#creationSecteursModal').modal('hide');
				  $('#creationVoiesModal').css('overflow-y', 'auto');
				  $('#creationVoiesModal').modal('show');
			}
		});
		
	});
	
	$('#formCreationVoies').submit(function(e) {
		e.preventDefault();
		var data = {}
		$('#formCreationVoies select').each(function () {
			data[this.name] = this.value;
		});
		$.ajax({
			url : 'CreationVoie',
			type : 'POST',
			data : {
				siteId : $("#siteId").val(),
				voiesData : JSON.stringify(data)
			},

			success : function() {
				  $('#creationVoiesModal').modal('hide');				 
			}
		});
		
	});
	
});