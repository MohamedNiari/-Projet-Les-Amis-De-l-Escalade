package org.couche.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	@Column(name="site_id")
	private Long siteId;
	private String nom;
	@Column(name="hauteur_max")
	private Integer hauteurMax;
	private String lieu;
	@Column(name="taguer_officiel")
	private Boolean taguerOfficiel;
	private String description;
	@Embedded
	private TypeRoche rocher;
	@Column(name="url_image")
	private String urlImage;

	/*
	 * Relation de secteur à voie sans supression en cascade
	 */
	@OneToMany(mappedBy = "site", cascade = { CascadeType.ALL })
	private List<Secteur> secteurs;

	@OneToMany(mappedBy = "site", cascade = { CascadeType.ALL })
	private List<Commentaire> commentaires;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "topo_id")
	private Topo topo;

	/*
	 * Constructeur
	 */
	public Site() {

	}

	/*
	 * Constructeur avec Id
	 */
	public Site(Long id_Site, String nom, Integer hauteurMax, String lieu, Boolean taguerOfficiel, String descriptions, String urlImage, TypeRoche rocher) {
		this.siteId = id_Site;
		this.nom = nom;
		this.hauteurMax = hauteurMax;
		this.lieu = lieu;
		this.taguerOfficiel = taguerOfficiel;
		this.description = descriptions;
		this.rocher = rocher;
	}

	/*
	 * Constructeur sans Id
	 */
	public Site(String nom, Integer hauteurMax, String lieu, Boolean taguerOfficiel, String descriptions, String urlImage, TypeRoche rocher) {
		this.nom = nom;
		this.hauteurMax = hauteurMax;
		this.lieu = lieu;
		this.taguerOfficiel = taguerOfficiel;
		this.description = descriptions;
		this.rocher = rocher;
	}
	
	/*
	 * Méthode pour la relation bidirectionnelle
	 */
	public void add(Commentaire commentaire) {
		if (commentaires == null) {
			commentaires = new ArrayList<>();
		}

		commentaires.add(commentaire);
		commentaire.setSite(this);
	}

	public void add(Secteur secteur) {
		if (secteurs == null) {
			secteurs = new ArrayList<>();
		}

		secteurs.add(secteur);
		secteur.setSite(this);
	}

	/**************************************
	 * Generation des setters and getters *
	 **************************************/

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	public Long getId_Site() {
		return siteId;
	}

	public void setId_Site(Long id_Site) {
		this.siteId = id_Site;
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

	public boolean isTaguerOfficiel() {
		return taguerOfficiel;
	}

	public void setTaguerOfficiel(boolean taguerOfficiel) {
		this.taguerOfficiel = taguerOfficiel;
	}

	public String getDescriptions() {
		return description;
	}

	public void setDescriptions(String descriptions) {
		this.description = descriptions;
	}

	public TypeRoche getRocher() {
		return rocher;
	}

	public void setRocher(TypeRoche rocher) {
		this.rocher = rocher;
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

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	@Override
	public String toString() {
		return "Site [id_Site=" + siteId + ", nom=" + nom + ", hauteurMax=" + hauteurMax + ", lieu=" + lieu
				+ ", taguerOfficiel=" + taguerOfficiel + ", description=" + description + ", rocher=" + rocher
				+ ", urlImage=" + urlImage + ", secteurs=" + secteurs + ", commentaires=" + commentaires + ", topo="
				+ topo + "]";
	}
	

}
