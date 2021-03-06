package com.mit.entity;

// Generated 9 juin 2016 18:19:25 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Contratmembre generated by hbm2java
 */
@Entity
@Table(name = "contratmembre", catalog = "mitdb")
public class Contratmembre implements java.io.Serializable {

	private ContratmembreId id;
	private Membre membre;
	private Tache tache;
	private Integer coutTache;
	private Date dateContrat;
	private Date debutContrat;
	private Date finContrat;

	public Contratmembre() {
	}

	public Contratmembre(ContratmembreId id, Membre membre, Tache tache,
			Date dateContrat, Date debutContrat, Date finContrat) {
		this.id = id;
		this.membre = membre;
		this.tache = tache;
		this.dateContrat = dateContrat;
		this.debutContrat = debutContrat;
		this.finContrat = finContrat;
	}

	public Contratmembre(ContratmembreId id, Membre membre, Tache tache,
			Integer coutTache, Date dateContrat, Date debutContrat,
			Date finContrat) {
		this.id = id;
		this.membre = membre;
		this.tache = tache;
		this.coutTache = coutTache;
		this.dateContrat = dateContrat;
		this.debutContrat = debutContrat;
		this.finContrat = finContrat;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cin", column = @Column(name = "cin", nullable = false)),
			@AttributeOverride(name = "idProjet", column = @Column(name = "idProjet", nullable = false)),
			@AttributeOverride(name = "idTache", column = @Column(name = "idTache", nullable = false)),
			@AttributeOverride(name = "idContrat", column = @Column(name = "idContrat", nullable = false)) })
	public ContratmembreId getId() {
		return this.id;
	}

	public void setId(ContratmembreId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cin", nullable = false, insertable = false, updatable = false)
	public Membre getMembre() {
		return this.membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "idProjet", referencedColumnName = "idProjet", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "idTache", referencedColumnName = "idTache", nullable = false, insertable = false, updatable = false) })
	public Tache getTache() {
		return this.tache;
	}

	public void setTache(Tache tache) {
		this.tache = tache;
	}

	@Column(name = "coutTache", precision = 8, scale = 0)
	public Integer getCoutTache() {
		return this.coutTache;
	}

	public void setCoutTache(Integer coutTache) {
		this.coutTache = coutTache;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateContrat", nullable = false, length = 10)
	public Date getDateContrat() {
		return this.dateContrat;
	}

	public void setDateContrat(Date dateContrat) {
		this.dateContrat = dateContrat;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "debutContrat", nullable = false, length = 10)
	public Date getDebutContrat() {
		return this.debutContrat;
	}

	public void setDebutContrat(Date debutContrat) {
		this.debutContrat = debutContrat;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "finContrat", nullable = false, length = 10)
	public Date getFinContrat() {
		return this.finContrat;
	}

	public void setFinContrat(Date finContrat) {
		this.finContrat = finContrat;
	}

}
