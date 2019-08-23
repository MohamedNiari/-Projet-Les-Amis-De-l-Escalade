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
 * Bean utilisateur qui représente sous forme d'objet la table du même nom
 */
@Entity
public class Utilisateur {
	
	/*
	 * Colonne Id de la table utilisateur avec auto-incrementation
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_Utilisateur;
	private String nom;
	private String adresseMail;
	private String identifiant;
	private String motDePasse;
	private Date dateInscription;
	private Boolean membreAssociation;
	private String prenom;
	private String ville;
	private String pays;
	
	/*
	 * Relation de "un à plusieurs" de secteur à voie
	 */
	@OneToMany(mappedBy = "utilisateur")
	private Set<Topo> topos;
	
	/*
	 * Relation de "un à plusieurs" de secteur à voie
	 */
	@OneToMany(mappedBy = "utilisateur")
	private Set<Commentaire> commentaires;
	
	
	/**************************************
	 * Generation des setters and getters *
	 **************************************/	

	public Long getId_Utilisateur() {
		return id_Utilisateur;
	}

	public void setId_Utilisateur(Long id_Utilisateur) {
		this.id_Utilisateur = id_Utilisateur;
	}

	public Set<Topo> getTopos() {
		return topos;
	}

	public void setTopos(Set<Topo> topos) {
		this.topos = topos;
	}

	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Long getId() {
		return id_Utilisateur;
	}

	public void setId(Long id_Utilisateur) {
		this.id_Utilisateur = id_Utilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Boolean getMembreAssociation() {
		return membreAssociation;
	}

	public void setMembreAssociation(Boolean membreAssociation) {
		this.membreAssociation = membreAssociation;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

}
