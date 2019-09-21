package org.couche.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Column(name = "site_id")
	private Long siteId;
	private String nom;
	@Column(name = "hauteur_max")
	private Integer hauteurMax;
	private String lieu;
	@Column(name = "taguer_officiel")
	private Boolean taguerOfficiel;
	private String description;
	@Column(columnDefinition = "enum('calcaire', 'granite', 'gneiss')")
	@Enumerated(EnumType.STRING)
	private Rocher rocher;
	@Column(name = "url_image")
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
	 * Constructeur sans Id
	 */
	public Site(String nom, Integer hauteurMax, String lieu, Boolean taguerOfficiel, String description,
			String urlImage, Rocher rocher, Topo topo) {
		this.nom = nom;
		this.hauteurMax = hauteurMax;
		this.lieu = lieu;
		this.taguerOfficiel = taguerOfficiel;
		this.description = description;
		this.urlImage = urlImage;
		this.rocher = rocher;
		this.topo = topo;
	}

	/*
	 * Méthode pour la relation bidirectionnelle
	 */
	public void addCommentaire(Commentaire commentaire) {
		if (commentaires == null) {
			commentaires = new ArrayList<>();
		}

		commentaires.add(commentaire);
		commentaire.setSite(this);
	}

	public void addSecteur(Secteur secteur) {
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
	
	public Rocher getRocher() {
		return rocher;
	}

	public void setRocher(Rocher rocher) {
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
	
	
	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Site [siteId=" + siteId + ", nom=" + nom + ", hauteurMax=" + hauteurMax + ", lieu=" + lieu
				+ ", taguerOfficiel=" + taguerOfficiel + ", description=" + description + ", rocher=" + rocher
				+ ", urlImage=" + urlImage + ", commentaires=" + commentaires + ", topo="
				+ topo.getNom() + "]";
	}

}
