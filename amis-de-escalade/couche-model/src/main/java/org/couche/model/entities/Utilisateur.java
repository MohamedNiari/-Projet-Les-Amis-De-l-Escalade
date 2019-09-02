package org.couche.model.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	 * Relation de "plusieurs à un" de utilisateur à topo sans supression en cascade
	 */
	@OneToMany(mappedBy = "utilisateur", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<Topo> topos;

	/*
	 * Relation de "plusieurs à un" de utilisateur à commentaire sans supression en
	 * cascade
	 */
	@OneToMany(mappedBy = "utilisateur", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<Commentaire> commentaires;

	/*
	 * Constructeur
	 */
	public Utilisateur() {

	}

	/*
	 * Constructeur avec Id
	 */
	public Utilisateur(Long id_Utilisateur, String nom, String adresseMail, String identifiant, String motDePasse,
			Date dateInscription, Boolean membreAssociation, String prenom, String ville, String pays) {
		this.id_Utilisateur = id_Utilisateur;
		this.nom = nom;
		this.adresseMail = adresseMail;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.dateInscription = dateInscription;
		this.membreAssociation = membreAssociation;
		this.prenom = prenom;
		this.ville = ville;
		this.pays = pays;
	}

	/*
	 * Constructeur sans Id
	 */
	public Utilisateur(String nom, String adresseMail, String identifiant, String motDePasse, Date dateInscription,
			Boolean membreAssociation, String prenom, String ville, String pays) {
		this.nom = nom;
		this.adresseMail = adresseMail;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.dateInscription = dateInscription;
		this.membreAssociation = membreAssociation;
		this.prenom = prenom;
		this.ville = ville;
		this.pays = pays;
	}

	/**************************************
	 * Generation des setters and getters *
	 **************************************/

	public Long getId_Utilisateur() {
		return id_Utilisateur;
	}

	public void setId_Utilisateur(Long id_Utilisateur) {
		this.id_Utilisateur = id_Utilisateur;
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

	public List<Topo> getTopos() {
		return topos;
	}

	public void setTopos(List<Topo> topos) {
		this.topos = topos;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

}
