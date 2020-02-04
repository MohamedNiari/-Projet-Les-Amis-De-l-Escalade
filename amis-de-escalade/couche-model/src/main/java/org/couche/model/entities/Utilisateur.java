package org.couche.model.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/*
 * Bean utilisateur qui représente sous forme d'objet la table du même nom
 */
@Entity
public class Utilisateur {

	/*
	 * Colonne Id de la table utilisateur avec auto-incrementation
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@Column(name = "adresse_mail")
	private String adresseMail;
	@Column(name = "mot_de_passe")
	private String motDePasse;
	@Column(name = "date_inscription")
	private String dateInscription;
	@Column(name = "membre_association")
	private Boolean membreAssociation;
	private String ville;
	private String pays;

	/*
	 * Liste de prénoms
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "prenoms", joinColumns = @JoinColumn(name = "utilisateur_id"))
	private Set<String> prenoms = new HashSet<String>();

	/*
	 * Relation de utilisateur à commentaire sans suppression en cascade
	 */
	@OneToMany(mappedBy = "utilisateur")
	private List<Reservation> commentaires;

	@OneToMany(mappedBy = "utilisateur", cascade = { CascadeType.PERSIST})
	@OrderBy("nom")
	private List<Site> sites = new ArrayList<Site>();

	@OneToMany(mappedBy = "proprietaire")
	private List<Reservation> reservationsProprietaire;

	@OneToMany(mappedBy = "utilisateur")
	private List<Reservation> reservationsUtilisateur;

	/*
	 * Constructeur
	 */
	public Utilisateur() {

	}

	/*
	 * Constructeur sans Id
	 */
	public Utilisateur(String nom, String adresseMail, String motDePasse, String dateInscription,
			Boolean membreAssociation, String ville, String pays) {
		this.nom = nom;
		this.adresseMail = adresseMail;
		this.motDePasse = motDePasse;
		this.dateInscription = dateInscription;
		this.membreAssociation = membreAssociation;
		this.ville = ville;
		this.pays = pays;
	}

	public void addCommentaire(Reservation commentaire) {
		if (commentaires == null) {
			commentaires = new ArrayList<>();
		}

		commentaires.add(commentaire);
		commentaire.setUtilisateur(this);
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

	public List<Reservation> getReservationsProprietaire() {
		return reservationsProprietaire;
	}

	public void setReservationsProprietaire(List<Reservation> reservationsProprietaire) {
		this.reservationsProprietaire = reservationsProprietaire;
	}

	public List<Reservation> getReservationsUtilisateur() {
		return reservationsUtilisateur;
	}

	public void setReservationsUtilisateur(List<Reservation> reservationsUtilisateur) {
		this.reservationsUtilisateur = reservationsUtilisateur;
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

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(String dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Boolean getMembreAssociation() {
		return membreAssociation;
	}

	public void setMembreAssociation(Boolean membreAssociation) {
		this.membreAssociation = membreAssociation;
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

	public List<Reservation> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Reservation> commentaires) {
		this.commentaires = commentaires;
	}

	public Set<String> getPrenoms() {
		return prenoms;
	}

	public void setPrenoms(Set<String> prenoms) {
		this.prenoms = prenoms;
	}

	public List<Site> getSites() {
		return sites;
	}

}
