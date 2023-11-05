package com.idorsia.research.osiris.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(schema = "OSIRIS", name = "SAMPLE")
@SequenceGenerator(name = "SAMPLE_GEN", sequenceName = "OSIRIS.SAMPLEID_SEQ", allocationSize = 1)
public class Sample implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SAMPLE_ID", unique = true, nullable = false, precision = 8, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SAMPLE_GEN")
	Integer sampleId;;

	@Column(name = "ACT_NO")
	String actNo;

	@Column(name = "EXT_REFERENCE")
	String extReferfence;

	@Column(name = "CMNT")
	String cmnt;

	@Column(name = "USER_ID")
	String userId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPD_DATE")
	Date updDate;

	@Column(name = "LOCATION")
	String location;

	@Column(name = "SUPPLIER")
	String supplier;

	@Column(name = "CATALOG_NO")
	String catalogNo;

	@Column(name = "PRIMARY_PURPOSE")
	String primaryPurpose;

	@Column(name = "LOT_NO")
	String loNo;

	public Sample() {
		super();
	}

	public Sample(Integer sampleId, String actNo, String extReferfence, String cmnt, String userId, Date updDate,
			String location, String supplier, String catalogNo, String primaryPurpose, String loNo) {
		super();
		this.sampleId = sampleId;
		this.actNo = actNo;
		this.extReferfence = extReferfence;
		this.cmnt = cmnt;
		this.userId = userId;
		this.updDate = updDate;
		this.location = location;
		this.supplier = supplier;
		this.catalogNo = catalogNo;
		this.primaryPurpose = primaryPurpose;
		this.loNo = loNo;
	}

	public Integer getSampleId() {
		return sampleId;
	}

	public void setSampleId(Integer sampleId) {
		this.sampleId = sampleId;
	}

	public String getActNo() {
		return actNo;
	}

	public void setActNo(String actNo) {
		this.actNo = actNo;
	}

	public String getExtReferfence() {
		return extReferfence;
	}

	public void setExtReferfence(String extReferfence) {
		this.extReferfence = extReferfence;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getCatalogNo() {
		return catalogNo;
	}

	public void setCatalogNo(String catalogNo) {
		this.catalogNo = catalogNo;
	}

	public String getPrimaryPurpose() {
		return primaryPurpose;
	}

	public void setPrimaryPurpose(String primaryPurpose) {
		this.primaryPurpose = primaryPurpose;
	}

	public String getLoNo() {
		return loNo;
	}

	public void setLoNo(String loNo) {
		this.loNo = loNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actNo == null) ? 0 : actNo.hashCode());
		result = prime * result + ((catalogNo == null) ? 0 : catalogNo.hashCode());
		result = prime * result + ((cmnt == null) ? 0 : cmnt.hashCode());
		result = prime * result + ((extReferfence == null) ? 0 : extReferfence.hashCode());
		result = prime * result + ((loNo == null) ? 0 : loNo.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((primaryPurpose == null) ? 0 : primaryPurpose.hashCode());
		result = prime * result + ((sampleId == null) ? 0 : sampleId.hashCode());
		result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
		result = prime * result + ((updDate == null) ? 0 : updDate.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Sample))
			return false;
		Sample other = (Sample) obj;
		if (actNo == null) {
			if (other.actNo != null)
				return false;
		} else if (!actNo.equals(other.actNo))
			return false;
		if (catalogNo == null) {
			if (other.catalogNo != null)
				return false;
		} else if (!catalogNo.equals(other.catalogNo))
			return false;
		if (cmnt == null) {
			if (other.cmnt != null)
				return false;
		} else if (!cmnt.equals(other.cmnt))
			return false;
		if (extReferfence == null) {
			if (other.extReferfence != null)
				return false;
		} else if (!extReferfence.equals(other.extReferfence))
			return false;
		if (loNo == null) {
			if (other.loNo != null)
				return false;
		} else if (!loNo.equals(other.loNo))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (primaryPurpose == null) {
			if (other.primaryPurpose != null)
				return false;
		} else if (!primaryPurpose.equals(other.primaryPurpose))
			return false;
		if (sampleId == null) {
			if (other.sampleId != null)
				return false;
		} else if (!sampleId.equals(other.sampleId))
			return false;
		if (supplier == null) {
			if (other.supplier != null)
				return false;
		} else if (!supplier.equals(other.supplier))
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