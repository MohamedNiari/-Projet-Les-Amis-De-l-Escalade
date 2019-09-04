package org.couche.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/*
 * Bean Sites qui représente sous forme d'objet la table du même nom
 */
@Entity
public class Sites {

	/*
	 * Colonne Id de la table sites avec auto-incrementation
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Site;
	private String nom;
	private Integer hauteurMax;
	private String lieu;
	private Boolean taguerOfficiel;
	private String description;
	@Embedded
	private TypeRoche rocher;

	/*
	 * Relation de secteur à voie sans supression en cascade
	 */
	@OneToMany(mappedBy = "sites", cascade = { CascadeType.ALL })
	private List<Secteur> secteurs;

	@OneToMany(mappedBy = "sites", cascade = { CascadeType.ALL })
	private List<Commentaire> commentaires;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "id_Topo")
	private Topo topo;

	/*
	 * Constructeur
	 */
	public Sites() {

	}

	/*
	 * Constructeur avec Id
	 */
	public Sites(Long id_Site, String nom, Integer hauteurMax, String lieu, Boolean taguerOfficiel, String descriptions,
			TypeRoche rocher) {
		this.id_Site = id_Site;
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
	public Sites(String nom, Integer hauteurMax, String lieu, Boolean taguerOfficiel, String descriptions,
			TypeRoche rocher) {
		this.nom = nom;
		this.hauteurMax = hauteurMax;
		this.lieu = lieu;
		this.taguerOfficiel = taguerOfficiel;
		this.description = descriptions;
		this.rocher = rocher;
	}

	public void add(Secteur secteur) {
		if (secteurs == null) {
			secteurs = new ArrayList<>();
		}

		secteurs.add(secteur);
		secteur.setSites(this);
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
		return id_Site;
	}

	public void setId_Site(Long id_Site) {
		this.id_Site = id_Site;
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

}
