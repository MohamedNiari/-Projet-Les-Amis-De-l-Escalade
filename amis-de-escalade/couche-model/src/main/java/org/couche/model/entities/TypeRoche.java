package org.couche.model.entities;

import javax.persistence.Embeddable;

/*
 * Enumération pour lister les différents type de roche
 * Sous composant de l'objet Sites
 */
@Embeddable
public class TypeRoche {

	private enum rocher {
		calcaire, granite, gneiss
	}

}
