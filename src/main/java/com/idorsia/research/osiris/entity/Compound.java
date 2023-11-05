package com.idorsia.research.osiris.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(schema = "OSIRIS", name = "COMPOUND")
@SequenceGenerator(name = "COMPOUND_GEN", sequenceName = "OSIRIS.COMPOUNDID_SEQ", allocationSize = 1)
public class Compound implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COMPOUND_ID", unique = true, nullable = false, precision = 8, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPOUND_GEN")
	Integer compoundId;

	@Column(name = "ACT_NO")
	String actNo;

	@Column(name = "CHEM_LAB_JOURNAL")
	String chemLabJournal;

	public Compound() {
	}

	public Compound(Integer compoundId, String actNo, String chemLabJournal) {
		super();
		this.compoundId = compoundId;
		this.actNo = actNo;
		this.chemLabJournal = chemLabJournal;
	}

	public Integer getCompoundId() {
		return compoundId;
	}

	public void setCompoundId(Integer compoundId) {
		this.compoundId = compoundId;
	}

	public String getActNo() {
		return actNo;
	}

	public void setActNo(String actNo) {
		this.actNo = actNo;
	}

	public String getChemLabJournal() {
		return chemLabJournal;
	}

	public void setChemLabJournal(String chemLabJournal) {
		this.chemLabJournal = chemLabJournal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actNo == null) ? 0 : actNo.hashCode());
		result = prime * result + ((chemLabJournal == null) ? 0 : chemLabJournal.hashCode());
		result = prime * result + ((compoundId == null) ? 0 : compoundId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Compound))
			return false;
		Compound other = (Compound) obj;
		if (actNo == null) {
			if (other.actNo != null)
				return false;
		} else if (!actNo.equals(other.actNo))
			return false;
		if (chemLabJournal == null) {
			if (other.chemLabJournal != null)
				return false;
		} else if (!chemLabJournal.equals(other.chemLabJournal))
			return false;
		if (compoundId == null) {
			if (other.compoundId != null)
				return false;
		} else if (!compoundId.equals(other.compoundId))
			return false;
		return true;
	}
	
	
	
	
}