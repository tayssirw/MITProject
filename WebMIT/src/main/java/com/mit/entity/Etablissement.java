package com.mit.entity;

// Generated 9 juin 2016 18:19:25 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Etablissement generated by hbm2java
 */
@Entity
@Table(name = "etablissement", catalog = "mitdb")
public class Etablissement implements java.io.Serializable {

	private Integer idEtab;
	private String nomEtab;
	private Set<Diplome> diplomes = new HashSet<Diplome>(0);

	public Etablissement() {
	}

	public Etablissement(String nomEtab) {
		this.nomEtab = nomEtab;
	}

	public Etablissement(String nomEtab, Set<Diplome> diplomes) {
		this.nomEtab = nomEtab;
		this.diplomes = diplomes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idEtab", unique = true, nullable = false)
	public Integer getIdEtab() {
		return this.idEtab;
	}

	public void setIdEtab(Integer idEtab) {
		this.idEtab = idEtab;
	}

	@Column(name = "nomEtab", nullable = false, length = 254)
	public String getNomEtab() {
		return this.nomEtab;
	}

	public void setNomEtab(String nomEtab) {
		this.nomEtab = nomEtab;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etablissement")
	public Set<Diplome> getDiplomes() {
		return this.diplomes;
	}

	public void setDiplomes(Set<Diplome> diplomes) {
		this.diplomes = diplomes;
	}

}
