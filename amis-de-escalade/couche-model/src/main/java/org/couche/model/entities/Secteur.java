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
import javax.persistence.OrderBy;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/*
 * Bean Secteur qui représente sous forme d'objet la table du même nom
 */
@Entity
public class Secteur {

	/*
	 * Colonne Id de la table secteur avec auto-incrementation
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@Column(name = "numero_secteur")
	private Integer numeroSecteur;
	private String description;

	/*
	 * Relation de secteur à voie avec supression en cascade
	 */
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "secteur", cascade = { CascadeType.ALL })
	@OrderBy("numeroVoie")
	private List<Voie> voies;

	/*
	 * Relation de secteur à site avec supression en cascade
	 */
	@ManyToOne()
	@JoinColumn(name = "site_id")
	private Site site;

	/*
	 * Constructeur
	 */
	public Secteur() {

	}

	/*
	 * Constructeur
	 */
	public Secteur(String nom, Integer numeroSecteur, String description, Site site) {
		this.nom = nom;
		this.numeroSecteur = numeroSecteur;
		this.description = description;
		this.site = site;
	}

	/**************************************
	 * Generation des setters and getters *
	 **************************************/
	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
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

	public List<Voie> getVoies() {
		return voies;
	}

	public void setVoies(List<Voie> voies) {
		this.voies = voies;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Secteur [secteurId=" + ", nom=" + nom + ", numeroSecteur=" + numeroSecteur
				+ ", description=" + description + ", voies=" + voies + ", site=" + site + "]";
	}

}
