package org.couche.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * Bean Voie qui repr©sente sous forme d'objet la table du mªme nom
 */
@Entity
public class Longueur {

	/*
	 * Colonne Id de la table voie avec auto-incrementation
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "voie_id")
	private Long longueurId;
	@Column(name = "longueur_metre")
	private Integer longueurMetre;

	/*
	 * Relation de voie   secteur sans supression en cascade
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "voie_id")
	private Voie voie;

	/*
	 * Constructeur
	 */
	public Longueur() {

	}

	/*
	 * Constructeur avec paramètres
	 */
	public Longueur(Integer longueurMetre, Voie voie) {
		this.longueurMetre = longueurMetre;
		this.voie = voie;
	}

	/**************************************
	 * Generation des setters and getters *
	 **************************************/

	public Long getLongueurId() {
		return longueurId;
	}

	public void setLongueurId(Long longueurId) {
		this.longueurId = longueurId;
	}

	public Integer getLongueurMetre() {
		return longueurMetre;
	}

	public void setLongueurMetre(Integer longueurMetre) {
		this.longueurMetre = longueurMetre;
	}

	public Voie getVoie() {
		return voie;
	}

	public void setVoie(Voie voie) {
		this.voie = voie;
	}

	@Override
	public String toString() {
		return "Longueur [longueurId=" + longueurId + ", longueurMetre=" + longueurMetre + ", voie=" + voie + "]";
	}

}
