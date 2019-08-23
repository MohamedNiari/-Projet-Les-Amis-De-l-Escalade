package org.couche.model.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/*
 * Bean Secteur qui représente sous forme d'objet la table du même nom
 */
@Entity
public class Secteur {
	
	/*
	 * Colonne Id de la table secteur avec auto-incrementation
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_Secteur;
	private String nom;
	private Integer numeroSecteur;
	private String descriptions;
	
	/*
	 * Relation de un à plusieurs de secteur à voie
	 */
	@OneToMany(mappedBy = "secteur")
	private Set<Voie> voies;
	
	/*
	 * Relation "plusieurs à un" de secteur à sites
	 */
	@ManyToOne
	@JoinColumn(name = "id_Site")
	private Sites sites;	
	
	
	/**************************************
	 * Generation des setters and getters *
	 **************************************/

	public Sites getSites() {
		return sites;
	}

	public void setSites(Sites sites) {
		this.sites = sites;
	}

	public Long getId_Secteur() {
		return id_Secteur;
	}

	public void setId_Secteur(Long id_Secteur) {
		this.id_Secteur = id_Secteur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNumeroSecteur() {
		return numeroSecteur;
	}

	public void setNumeroSecteur(Integer numeroSecteur) {
		this.numeroSecteur = numeroSecteur;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public Set<Voie> getVoies() {
		return voies;
	}

	public void setVoies(Set<Voie> voies) {
		this.voies = voies;
	}

}
