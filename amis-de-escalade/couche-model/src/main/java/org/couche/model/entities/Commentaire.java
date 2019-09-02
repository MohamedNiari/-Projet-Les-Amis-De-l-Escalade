package org.couche.model.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * Objet Commentaire qui représente sous forme d'objet la table du même nom
 */
@Entity
public class Commentaire {

	/*
	 * Colonne Id de la table commentaire avec auto-incrementation
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Commentaire;
	private String texte;
	@Temporal(TemporalType.DATE)
	private Date date_du_commentaire;

	/*
	 * Relation "un à plusieurs" de commentaire à sites un à plusieurs sans
	 * supression en cascade
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "id_Site")
	private Sites sites;

	/*
	 * Relation "un à plusieurs" de commentaire à utilisateur sans supression en
	 * cascade
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "id_Utilisateur")
	private Utilisateur utilisateur;

	/*
	 * Constructeur
	 */
	public Commentaire() {

	}

	/*
	 * Constructeur avec Id
	 */
	public Commentaire(Long id_Commentaire, String texte, Date date_du_commentaire) {
		super();
		this.id_Commentaire = id_Commentaire;
		this.texte = texte;
		this.date_du_commentaire = date_du_commentaire;
	}

	/*
	 * Constructeur sans Id
	 */
	public Commentaire(String texte, Date date_du_commentaire) {
		super();
		this.texte = texte;
		this.date_du_commentaire = date_du_commentaire;
		// this.utilisateur = utilisateur;
	}

	/**************************************
	 * Generation des setters et getters *
	 **************************************/

	public Long getId_Commentaire() {
		return id_Commentaire;
	}

	public void setId_Commentaire(Long id_Commentaire) {
		this.id_Commentaire = id_Commentaire;
	}

	public String getTexte() {
		return texte;
	}

	public Sites getSites() {
		return sites;
	}

	public void setSites(Sites sites) {
		this.sites = sites;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Date getDate_du_commentaire() {
		return date_du_commentaire;
	}

	public void setDate_du_commentaire(Date date_du_commentaire) {
		this.date_du_commentaire = date_du_commentaire;
	}

}
