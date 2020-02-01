package org.couche.model.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/*
 * Bean Site qui représente sous forme d'objet la table du même nom
 */
@Entity
public class Site {

	/*
	 * Colonne Id de la table site avec auto-incrementation
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@Column(name = "hauteur_max")
	private Integer hauteurMax;
	private String lieu;
	@Column(name = "taguer_officiel")
	private Boolean taguerOfficiel;
	@Size(max = 500)
	private String description;
	// @Column(columnDefinition = "enum('calcaire', 'granite', 'gneiss')")
	@Enumerated(EnumType.STRING)
	@Column(name = "type_rocher")
	private TypeRocher typeRocher;

	/*
	 * Liste de prénoms
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "site_url_image", joinColumns = { @JoinColumn(name = "site_id") })
	@Column(name = "url_image")
	private List<String> urlImages = new ArrayList<String>();

	/*
	 * Relation de secteur à voie avec suppression en cascade
	 */
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "site", cascade = { CascadeType.ALL })
	@OrderBy("numeroSecteur")
	private List<Secteur> secteurs;


	@OneToMany(mappedBy = "site")
	@OrderBy("commentaireId DESC")
	private List<Commentaire> commentaires;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;

	@ManyToMany(mappedBy = "sites")
	private List<Topo> topos;

	/*
	 * Constructeur
	 */
	public Site() {

	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/*
	 * Constructeur sans Id
	 */
	public Site(String nom, Integer hauteurMax, String lieu, Boolean taguerOfficiel, String description,
			TypeRocher typeRocher) {
		this.nom = nom;
		this.hauteurMax = hauteurMax;
		this.lieu = lieu;
		this.taguerOfficiel = taguerOfficiel;
		this.description = description;
		this.typeRocher = typeRocher;
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

	public List<Topo> getTopos() {
		return topos;
	}

	public void setTopos(List<Topo> topos) {
		this.topos = topos;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getHauteurMax() {
		return hauteurMax;
	}

	public void setHauteurMax(Integer hauteurMax) {
		this.hauteurMax = hauteurMax;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Boolean getTaguerOfficiel() {
		return taguerOfficiel;
	}

	public void setTaguerOfficiel(Boolean taguerOfficiel) {
		this.taguerOfficiel = taguerOfficiel;
	}

	public List<Secteur> getSecteurs() {
		return secteurs;
	}

	public void setSecteurs(List<Secteur> secteurs) {
		this.secteurs = secteurs;
	}

	public TypeRocher getTypeRocher() {
		return typeRocher;
	}

	public void setTypeRocher(TypeRocher typeRocher) {
		this.typeRocher = typeRocher;
	}

	public String getDescription() {
		return description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getUrlImages() {
		return urlImages;
	}

	public void setUrlImages(List<String> urlImages) {
		this.urlImages = urlImages;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	@Override
	public String toString() {
		return "Site [id=" + id + ", nom=" + nom + ", hauteurMax=" + hauteurMax + ", lieu=" + lieu + ", taguerOfficiel="
				+ taguerOfficiel + ", description=" + description + ", typeRocher=" + typeRocher + ", urlImages="
				+ urlImages + ", secteurs=" + secteurs + ", commentaires=" + commentaires + ", utilisateur="
				+ utilisateur + ", topos=" + topos + "]";
	}

}
