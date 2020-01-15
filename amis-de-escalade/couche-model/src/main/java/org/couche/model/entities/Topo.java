package org.couche.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/*
 * Bean Topo qui représente sous forme d'objet la table du même nom
 */
@Entity
public class Topo {

	/*
	 * Colonne Id de la table topo avec auto-incrementation
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String description;
	private String lieu;
	@Column(name = "date_parution")
	private String dateParution;
	private Boolean disponible;

	/*
	 * Relation de plusieurs à plusieurs Topo/Site
	 */
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
				name = "topo_site", 
				joinColumns = { @JoinColumn(name = "topo_id") }, 
				inverseJoinColumns = {@JoinColumn(name = "site_id") })
	private List<Site> sites;

	/*
	 * Relation de topo à utilisateur sans supression en cascade
	 */
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;

	/*
	 * Constructeur
	 */
	public Topo() {

	}

	/*
	 * Constructeur sans Id
	 */
	public Topo(String nom, String description, String lieu, String dateParution, Boolean disponible,
			Utilisateur utilisateur) {
		this.nom = nom;
		this.description = description;
		this.lieu = lieu;
		this.dateParution = dateParution;
		this.disponible = disponible;
		this.utilisateur = utilisateur;
	}
	
	/*
	 * Creation d'une methode add pour l'ajout des sites au topo
	 */
	
	public void addSite(Site site) {
		
		if(sites == null) {
			sites = new ArrayList<>();
		}
		
		sites.add(site);
	}

	/**************************************
	 * Generation des setters and getters *
	 **************************************/
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getDateParution() {
		return dateParution;
	}

	public void setDateParution(String dateParution) {
		this.dateParution = dateParution;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
