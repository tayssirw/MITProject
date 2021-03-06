package com.mit.entity;

// Generated 9 juin 2016 18:19:25 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Pvreunion generated by hbm2java
 */
@Entity
@Table(name = "pvreunion", catalog = "mitdb")
public class Pvreunion implements java.io.Serializable {

	private Integer idReunoin;
	private Membre membre;
	private Projet projet;
	private String objetReunion;
	private Date dateReunion;
	private String contenu;

	public Pvreunion() {
	}

	public Pvreunion(Membre membre, Projet projet) {
		this.membre = membre;
		this.projet = projet;
	}

	public Pvreunion(Membre membre, Projet projet, String objetReunion,
			Date dateReunion, String contenu) {
		this.membre = membre;
		this.projet = projet;
		this.objetReunion = objetReunion;
		this.dateReunion = dateReunion;
		this.contenu = contenu;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idReunoin", unique = true, nullable = false)
	public Integer getIdReunoin() {
		return this.idReunoin;
	}

	public void setIdReunoin(Integer idReunoin) {
		this.idReunoin = idReunoin;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cin", nullable = false)
	public Membre getMembre() {
		return this.membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProjet", nullable = false)
	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	@Column(name = "objetReunion", length = 254)
	public String getObjetReunion() {
		return this.objetReunion;
	}

	public void setObjetReunion(String objetReunion) {
		this.objetReunion = objetReunion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateReunion", length = 10)
	public Date getDateReunion() {
		return this.dateReunion;
	}

	public void setDateReunion(Date dateReunion) {
		this.dateReunion = dateReunion;
	}

	@Column(name = "contenu", length = 254)
	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

}
