package com.mit.entity;

// Generated 9 juin 2016 18:19:25 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AttestationId generated by hbm2java
 */
@Embeddable
public class AttestationId implements java.io.Serializable {

	private int cin;
	private int idProjet;
	private int idAttestation;

	public AttestationId() {
	}

	public AttestationId(int cin, int idProjet, int idAttestation) {
		this.cin = cin;
		this.idProjet = idProjet;
		this.idAttestation = idAttestation;
	}

	@Column(name = "cin", nullable = false)
	public int getCin() {
		return this.cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	@Column(name = "idProjet", nullable = false)
	public int getIdProjet() {
		return this.idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}

	@Column(name = "idAttestation", nullable = false)
	public int getIdAttestation() {
		return this.idAttestation;
	}

	public void setIdAttestation(int idAttestation) {
		this.idAttestation = idAttestation;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AttestationId))
			return false;
		AttestationId castOther = (AttestationId) other;

		return (this.getCin() == castOther.getCin())
				&& (this.getIdProjet() == castOther.getIdProjet())
				&& (this.getIdAttestation() == castOther.getIdAttestation());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCin();
		result = 37 * result + this.getIdProjet();
		result = 37 * result + this.getIdAttestation();
		return result;
	}

}
