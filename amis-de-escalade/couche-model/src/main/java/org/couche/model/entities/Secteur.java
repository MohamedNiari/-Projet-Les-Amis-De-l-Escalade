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
	@Column(name="secteur_id")
	private Long secteurId;
	private String nom;
	@Column(name="numero_secteur")
	private Integer numeroSecteur;
	private String description;

	/*
	 * Relation de secteur à voie avec supression en cascade
	 */
	@OneToMany(mappedBy = "secteur", cascade = { CascadeType.ALL })
	private List<Voie> voies;

	/*
	 * Relation de secteur à site sans supression en cascade
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "site_id")
	private Site site;

	/*
	 * Constructeur
	 */
	public Secteur() {

	}

	/*
	 * Constructeur avec Id
	 */
	public Secteur(Long id_Secteur, String nom, Integer numeroSecteur, String descriptions) {
		this.secteurId = id_Secteur;
		this.nom = nom;
		this.numeroSecteur = numeroSecteur;
		this.description = descriptions;
	}

	/*
	 * Constructeur sans Id
	 */
	public Secteur(String nom, Integer numeroSecteur, String descriptions) {
		this.nom = nom;
		this.numeroSecteur = numeroSecteur;
		this.description = descriptions;
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

	public Long getId_Secteur() {
		return secteurId;
	}

	public void setId_Secteur(Long id_Secteur) {
		this.secteurId = id_Secteur;
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
		return description;
	}

	public void setDescriptions(String descriptions) {
		this.description = descriptions;
	}

	public List<Voie> getVoies() {
		return voies;
	}

	public void setVoies(List<Voie> voies) {
		this.voies = voies;
	}

	@Override
	public String toString() {
		return "Secteur [id_Secteur=" + secteurId + ", nom=" + nom + ", numeroSecteur=" + numeroSecteur
				+ ", descriptions=" + description + ", voies=" + voies + ", site=" + site + "]";
	}

}
