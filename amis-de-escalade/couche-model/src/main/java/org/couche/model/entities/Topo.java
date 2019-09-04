package org.couche.model.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private Long id_Topo;
	private String nom;
	private String description;
	private String lieu;
	private Date dateParution;
	private Boolean disponible;

	/*
	 * Relation de secteur à voie sans supression en cascade
	 */
	@OneToMany(mappedBy = "topo", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<Sites> sites;

	/*
	 * Relation de topo à utilisateur sans supression en cascade
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "id_Utilisateur")
	private Utilisateur utilisateur;

	/*
	 * Constructeur
	 */
	public Topo() {

	}

	/*
	 * Constructeur avec Id
	 */
	public Topo(Long id_Topo, String nom, String description, String lieu, Date dateParution, Boolean disponible) {
		this.id_Topo = id_Topo;
		this.nom = nom;
		this.description = description;
		this.lieu = lieu;
		this.dateParution = dateParution;
		this.disponible = disponible;
	}

	/*
	 * Constructeur sans Id
	 */
	public Topo(String nom, String description, String lieu, Date dateParution, Boolean disponible) {
		this.nom = nom;
		this.description = description;
		this.lieu = lieu;
		this.dateParution = dateParution;
		this.disponible = disponible;
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

	public List<Sites> getSites() {
		return sites;
	}

	public void setSites(List<Sites> sites) {
		this.sites = sites;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Long getId_Topo() {
		return id_Topo;
	}

	public void setId_Topo(Long id_Topo) {
		this.id_Topo = id_Topo;
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

	public Date getDateParution() {
		return dateParution;
	}

	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Topo [id_Topo=" + id_Topo + ", nom=" + nom + ", description=" + description + ", lieu=" + lieu
				+ ", dateParution=" + dateParution + ", disponible=" + disponible + ", sites=" + sites + "]";
	}

}
