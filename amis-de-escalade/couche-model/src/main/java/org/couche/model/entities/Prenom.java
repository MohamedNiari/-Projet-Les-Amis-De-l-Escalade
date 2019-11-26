package org.couche.model.entities;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Prenom {
	
	private String prenom;

	@Embedded
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}
