package com.idorsia.research.osiris.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(schema = "OSIRIS", name = "SUBSTANCE")
public class Substance implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ACT_NO", unique = true, nullable = false, precision = 8, scale = 0)
	String actNo;

	@Column(name = "FORMULA")
	String formula;

	@Column(name = "MOL_WEIGHT")
	BigDecimal molWeight;

	@Column(name = "ABS_WEIGHT")
	BigDecimal absWeight;

	@Column(name = "SYSTEMATIC_NAME")
	String systematicName;

	@Column(name = "KNOWN")
	Character known;

	@Column(name = "KNOWN_SOURCE")
	String knownSource;

	@Column(name = "SUBSTANCE_CLASS")
	String substanceClass;

	@Column(name = "MOLFILE", columnDefinition = "LONGTEXT")
	String molFile;

	@Column(name = "CMNT")
	String cmnt;

	@Column(name = "USER_ID")
	String userId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPD_DATE")
	Date updDate;

	@Column(name = "CLOGP")
	BigDecimal clogp;

	@Column(name = "IDCODE")
	String idCode;

	@Column(name = "COORDINATES")
	String coordinates;

	@Column(name = "TAUTOMER")
	Long tautomer;

	@Column(name = "FLAG")
	Integer flag;

	public Substance() {
	}

	public Substance(String actNo, String formula, BigDecimal molWeight, BigDecimal absWeight, String systematicName,
			Character known, String knownSource, String substanceClass, String molFile, String cmnt, String userId,
			Date updDate, BigDecimal clogp, String idCode, String coordinates, Long tautomer, Integer flag) {
		super();
		this.actNo = actNo;
		this.formula = formula;
		this.molWeight = molWeight;
		this.absWeight = absWeight;
		this.systematicName = systematicName;
		this.known = known;
		this.knownSource = knownSource;
		this.substanceClass = substanceClass;
		this.molFile = molFile;
		this.cmnt = cmnt;
		this.userId = userId;
		this.updDate = updDate;
		this.clogp = clogp;
		this.idCode = idCode;
		this.coordinates = coordinates;
		this.tautomer = tautomer;
		this.flag = flag;
	}

	public String getActNo() {
		return actNo;
	}

	public void setActNo(String actNo) {
		this.actNo = actNo;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public BigDecimal getMolWeight() {
		return molWeight;
	}

	public void setMolWeight(BigDecimal molWeight) {
		this.molWeight = molWeight;
	}

	public BigDecimal getAbsWeight() {
		return absWeight;
	}

	public void setAbsWeight(BigDecimal absWeight) {
		this.absWeight = absWeight;
	}

	public String getSystematicName() {
		return systematicName;
	}

	public void setSystematicName(String systematicName) {
		this.systematicName = systematicName;
	}

	public Character getKnown() {
		return known;
	}

	public void setKnown(Character known) {
		this.known = known;
	}

	public String getKnownSource() {
		return knownSource;
	}

	public void setKnownSource(String knownSource) {
		this.knownSource = knownSource;
	}

	public String getSubstanceClass() {
		return substanceClass;
	}

	public void setSubstanceClass(String substanceClass) {
		this.substanceClass = substanceClass;
	}

	public String getMolFile() {
		return molFile;
	}

	public void setMolFile(String molFile) {
		this.molFile = molFile;
	}

	public String getCmnt() {
		return cmnt;
	}

	public void setCmnt(String cmnt) {
		this.cmnt = cmnt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public BigDecimal getClogp() {
		return clogp;
	}

	public void setClogp(BigDecimal clogp) {
		this.clogp = clogp;
	}

	public String getIdCode() {
		return idCode;
	}

	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public Long getTautomer() {
		return tautomer;
	}

	public void setTautomer(Long tautomer) {
		this.tautomer = tautomer;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((absWeight == null) ? 0 : absWeight.hashCode());
		result = prime * result + ((actNo == null) ? 0 : actNo.hashCode());
		result = prime * result + ((clogp == null) ? 0 : clogp.hashCode());
		result = prime * result + ((cmnt == null) ? 0 : cmnt.hashCode());
		result = prime * result + ((coordinates == null) ? 0 : coordinates.hashCode());
		result = prime * result + ((flag == null) ? 0 : flag.hashCode());
		result = prime * result + ((formula == null) ? 0 : formula.hashCode());
		result = prime * result + ((idCode == null) ? 0 : idCode.hashCode());
		result = prime * result + ((known == null) ? 0 : known.hashCode());
		result = prime * result + ((knownSource == null) ? 0 : knownSource.hashCode());
		result = prime * result + ((molFile == null) ? 0 : molFile.hashCode());
		result = prime * result + ((molWeight == null) ? 0 : molWeight.hashCode());
		result = prime * result + ((substanceClass == null) ? 0 : substanceClass.hashCode());
		result = prime * result + ((systematicName == null) ? 0 : systematicName.hashCode());
		result = prime * result + ((tautomer == null) ? 0 : tautomer.hashCode());
		result = prime * result + ((updDate == null) ? 0 : updDate.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Substance))
			return false;
		Substance other = (Substance) obj;
		if (absWeight == null) {
			if (other.absWeight != null)
				return false;
		} else if (!absWeight.equals(other.absWeight))
			return false;
		if (actNo == null) {
			if (other.actNo != null)
				return false;
		} else if (!actNo.equals(other.actNo))
			return false;
		if (clogp == null) {
			if (other.clogp != null)
				return false;
		} else if (!clogp.equals(other.clogp))
			return false;
		if (cmnt == null) {
			if (other.cmnt != null)
				return false;
		} else if (!cmnt.equals(other.cmnt))
			return false;
		if (coordinates == null) {
			if (other.coordinates != null)
				return false;
		} else if (!coordinates.equals(other.coordinates))
			return false;
		if (flag == null) {
			if (other.flag != null)
				return false;
		} else if (!flag.equals(other.flag))
			return false;
		if (formula == null) {
			if (other.formula != null)
				return false;
		} else if (!formula.equals(other.formula))
			return false;
		if (idCode == null) {
			if (other.idCode != null)
				return false;
		} else if (!idCode.equals(other.idCode))
			return false;
		if (known == null) {
			if (other.known != null)
				return false;
		} else if (!known.equals(other.known))
			return false;
		if (knownSource == null) {
			if (other.knownSource != null)
				return false;
		} else if (!knownSource.equals(other.knownSource))
			return false;
		if (molFile == null) {
			if (other.molFile != null)
				return false;
		} else if (!molFile.equals(other.molFile))
			return false;
		if (molWeight == null) {
			if (other.molWeight != null)
				return false;
		} else if (!molWeight.equals(other.molWeight))
			return false;
		if (substanceClass == null) {
			if (other.substanceClass != null)
				return false;
		} else if (!substanceClass.equals(other.substanceClass))
			return false;
		if (systematicName == null) {
			if (other.systematicName != null)
				return false;
		} else if (!systematicName.equals(other.systematicName))
			return false;
		if (tautomer == null) {
			if (other.tautomer != null)
				return false;
		} else if (!tautomer.equals(other.tautomer))
			return false;
		if (updDate == null) {
			if (other.updDate != null)
				return false;
		} else if (!updDate.equals(other.updDate))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	
	
}