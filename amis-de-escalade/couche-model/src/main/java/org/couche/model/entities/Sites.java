package org.couche.model.entities;

import java.util.Set;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_Site;
	private String nom;
	private Long hauteurMax;
	private String lieu;
	private Boolean taguerOfficiel;
	private String descriptions;
	@Embedded
	private TypeRoche rocher;
	
	/*
	 * Relation de "un à plusieurs" de secteur à voie
	 */
	@OneToMany(mappedBy = "sites")
	private Set<Secteur> secteurs;
	
	
	/**************************************
	 * Generation des setters and getters *
	 **************************************/
	
	public Set<Secteur> getSecteurs() {
		return secteurs;
	}

	public void setSecteurs(Set<Secteur> secteurs) {
		this.secteurs = secteurs;
	}

	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	@OneToMany(mappedBy = "sites")
	private Set<Commentaire> commentaires;
	
	@ManyToOne
	@JoinColumn(name = "id_Topo")
	private Topo topo;

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

	public Long getHauteurMax() {
		return hauteurMax;
	}

	public void setHauteurMax(Long hauteurMax) {
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
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public TypeRoche getRocher() {
		return rocher;
	}

	public void setRocher(TypeRoche rocher) {
		this.rocher = rocher;
	}
	
	

}
