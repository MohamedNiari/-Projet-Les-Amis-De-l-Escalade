package org.couche.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/*
 * Bean Voie qui reprÃ Â©sente sous forme d'objet la table du mÃ Âªme nom
 */
@Entity
public class Voie {

	/*
	 * Colonne Id de la table voie avec auto-incrementation
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "voie_id")
	private Long voieId;
	@Column(name = "numero_voie")
	private Integer numeroVoie;
	@Column(name = "nombre_longueur")
	private Integer nombreLongueurs;

	/*
	 * Relation de voie à secteur sans supression en cascade
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "secteur_id")
	private Secteur secteur;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "voie", cascade = { CascadeType.ALL })
	private List<Longueur> longueurs;

	/*
	 * Constructeur
	 */
	public Voie() {

	}

	/*
	 * Constructeur avec paramètres
	 */
	public Voie(Integer nombreLongueurs, Integer numeroVoie, Secteur secteur) {
		this.nombreLongueurs = nombreLongueurs;
		this.numeroVoie = numeroVoie;
		this.secteur = secteur;
	}

	/**************************************
	 * Generation des setters and getters *
	 **************************************/

	public Long getId_Voie() {
		return voieId;
	}

	public void setId_Voie(Long id_Voie) {
		this.voieId = id_Voie;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

	public void setNombreLongueurs(Integer nombreLongueurs) {
		this.nombreLongueurs = nombreLongueurs;
	}

	public void setNumeroVoie(Integer numeroVoie) {
		this.numeroVoie = numeroVoie;
	}

	public Long getVoieId() {
		return voieId;
	}

	public void setVoieId(Long voieId) {
		this.voieId = voieId;
	}

	public List<Longueur> getLongueurs() {
		return longueurs;
	}

	public void setLongueurs(List<Longueur> longueurs) {
		this.longueurs = longueurs;
	}	
	
	public Integer getNumeroVoie() {
		return numeroVoie;
	}

	public Integer getNombreLongueurs() {
		return nombreLongueurs;
	}

	@Override
	public String toString() {
		return "Voie [voieId=" + voieId + ", numeroVoie=" + numeroVoie + ", nombreLongueurs=" + nombreLongueurs
				+ ", secteur=" + secteur + ", longueurs=" + longueurs + "]";
	}

	
}
