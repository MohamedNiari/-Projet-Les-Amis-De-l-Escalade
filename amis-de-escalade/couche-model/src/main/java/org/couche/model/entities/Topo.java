package org.couche.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	@Column(name = "topo_id")
	private Long topoId;
	private String nom;
	private String description;
	private String lieu;
	@Column(name = "date_parution")
	private String dateParution;
	private Boolean disponible;

	/*
	 * Relation de secteur à voie sans supression en cascade
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "topo")
	private List<Site> sites;

	/*
	 * Relation de topo à utilisateur sans supression en cascade
	 */
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;
	
	/*
	 * Relation plusieurs à plusieurs pour la réservation
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="reservation",
			joinColumns = @JoinColumn(name="topo_id"),
			inverseJoinColumns = @JoinColumn(name="utilisateur_id")
			)
	private List<Utilisateur> utilisateurs;

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
	 * Méthode pour la relation bidirectionnelle
	 */
	public void addSite(Site site) {
		if (sites == null) {
			sites = new ArrayList<>();
		}

		sites.add(site);
		site.setTopo(this);
	}

	/**************************************
	 * Generation des setters and getters *
	 **************************************/

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

	public Long getId_Topo() {
		return topoId;
	}

	public void setId_Topo(Long id_Topo) {
		this.topoId = id_Topo;
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

	public Long getTopoId() {
		return topoId;
	}

	public void setTopoId(Long topoId) {
		this.topoId = topoId;
	}
	
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	@Override
	public String toString() {
		return "Topo [topoId=" + topoId + ", nom=" + nom + ", description=" + description + ", lieu=" + lieu
				+ ", dateParution=" + dateParution + ", disponible=" + disponible + ", sites=" + sites
				+ ", utilisateur=" + utilisateur + "]";
	}

}
