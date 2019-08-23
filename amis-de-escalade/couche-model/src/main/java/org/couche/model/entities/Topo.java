package org.couche.model.entities;

import java.util.Date;
import java.util.Set;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_Topo;
	private String nom;
	private String descriptions;
	private String lieu;
	private Date dateParution;
	private Boolean disponible;
	
	/*
	 * Relation de "un à plusieurs" de secteur à voie
	 */
	@OneToMany(mappedBy = "topo")
	private Set<Sites> sites;
	
	/*
	 * Relation "plusieurs à un" de topo à utilisateur
	 */
	@ManyToOne
	@JoinColumn(name = "id_Utilisateur")
	private Utilisateur utilisateur;	
	
	
	/**************************************
	 * Generation des setters and getters *
	 **************************************/
	
	public Set<Sites> getSites() {
		return sites;
	}

	public void setSites(Set<Sites> sites) {
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

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
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

}
