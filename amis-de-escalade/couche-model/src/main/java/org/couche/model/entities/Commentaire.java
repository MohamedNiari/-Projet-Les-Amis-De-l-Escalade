package org.couche.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	@Column(name = "commentaire_id")
	private Long commentaireId;
	private String texte;
	@Column(name = "date_du_commentaire")
	private String dateDuCommentaire;

	/*
	 * Relation de commentaire à site sans suppression en cascade
		 
	@ManyToOne
	@JoinColumn(name = "site_id")
	private Site site;
*/
	/*
	 * Relation de commentaire à utilisateur sans supression en cascade
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;

	/*
	 * Constructeur
	 */
	public Commentaire() {

	}

	/*
	 * Constructeur
	 */
	public Commentaire(String texte, String dateDuCommentaire, Utilisateur utilisateur) {
		this.texte = texte;
		this.dateDuCommentaire = dateDuCommentaire;
		//this.site = site;
		this.utilisateur = utilisateur;
	}

	/**************************************
	 * Generation des setters et getters *
	 **************************************/

	public String getTexte() {
		return texte;
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

	public Long getCommentaireId() {
		return commentaireId;
	}

	public void setCommentaireId(Long commentaireId) {
		this.commentaireId = commentaireId;
	}

	public String getDateDuCommentaire() {
		return dateDuCommentaire;
	}

	public void setDateDuCommentaire(String dateDuCommentaire) {
		this.dateDuCommentaire = dateDuCommentaire;
	}

	@Override
	public String toString() {
		return "Commentaire [commentaireId=" + commentaireId + ", texte=" + texte + ", dateDuCommentaire="
				+ dateDuCommentaire + ", site=" + ", utilisateur=" + utilisateur + "]";
	}

}
