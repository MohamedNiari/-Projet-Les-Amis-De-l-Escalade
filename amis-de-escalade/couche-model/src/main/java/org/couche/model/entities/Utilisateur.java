package org.couche.model.entities;

import java.util.ArrayList;
import java.util.Collection;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.ManyToAny;

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
	@Column(name = "utilisateur_id")
	private Long utilisateurId;
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
	private List<Commentaire> commentaires;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
	@OrderBy("nom")
	private List<Site> sites;
	
	/*
	 * Relation plusieurs à plusieurs pour la réservation
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="reservation",
			joinColumns = @JoinColumn(name="utilisateur_id"),
			inverseJoinColumns = @JoinColumn(name="topo_id")
			)
	private List<Topo> topos;
	
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

	/*
	 * Méthode pour la relation bidirectionnelle
	 */
	public void addTopo(Topo topo) {
		if (topos == null) {
			topos = new ArrayList<>();
		}

		topos.add(topo);
		topo.setUtilisateur(this);
	}

	public void addCommentaire(Commentaire commentaire) {
		if (commentaires == null) {
			commentaires = new ArrayList<>();
		}

		commentaires.add(commentaire);
		commentaire.setUtilisateur(this);
	}

	/**************************************
	 * Generation des setters and getters *
	 **************************************/

	public Long getId_Utilisateur() {
		return utilisateurId;
	}

	public void setId_Utilisateur(Long id_Utilisateur) {
		this.utilisateurId = id_Utilisateur;
	}

	public Long getId() {
		return utilisateurId;
	}

	public void setId(Long id_Utilisateur) {
		this.utilisateurId = id_Utilisateur;
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

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Long getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(Long utilisateurId) {
		this.utilisateurId = utilisateurId;
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

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}	
	
	public List<Topo> getTopos() {
		return topos;
	}

	public void setTopos(List<Topo> topos) {
		this.topos = topos;
	}

	@Override
	public String toString() {
		return "Utilisateur [utilisateurId=" + utilisateurId + ", nom=" + nom + ", adresseMail=" + adresseMail
				+ ", motDePasse=" + motDePasse + ", dateInscription=" + dateInscription + ", membreAssociation="
				+ membreAssociation + ", ville=" + ville + ", pays=" + pays + ", prenoms=" + prenoms + ", topos="
				+ topos + ", commentaires=" + commentaires + "]";
	}

}
