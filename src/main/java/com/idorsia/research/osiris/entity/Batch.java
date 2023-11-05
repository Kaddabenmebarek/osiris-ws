package com.idorsia.research.osiris.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(schema = "OSIRIS", name = "BATCH")
public class Batch implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CHEM_LAB_JOURNAL", unique = true, nullable = false)
	String chemLabJournal;

	@Column(name = "ACT_NO")
	String actNo;

	@Column(name = "CHEMIST")
	String chemist;

	@Column(name = "PRODUCER")
	String producer;

	@Column(name = "PROJECT_NAME")
	String projectName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PREPARATION_DATE")
	Date preparationDate;

	@Column(name = "PREPARATION_DESC")
	String preparationDesc;

	@Column(name = "PURIFICATION")
	String purification;

	@Column(name = "MELTING_POINT")
	Integer meltingPoint;

	@Column(name = "BOILING_POINT")
	Integer boilingPoint;

	@Column(name = "COLOR")
	String color;

	@Column(name = "AMOUNT")
	BigDecimal amount;

	@Column(name = "YIELD")
	BigDecimal yield;

	@Column(name = "CMNT")
	String cmnt;

	@Column(name = "USER_ID")
	String userId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPD_DATE")
	Date updDate;

	@Column(name = "LOCATION")
	String location;

	public Batch() {
	}

	public Batch(String chemLabJournal, String actNo, String chemist, String producer, String projectName,
			Date preparationDate, String preparationDesc, String purification, Integer meltingPoint,
			Integer boilingPoint, String color, BigDecimal amount, BigDecimal yield, String cmnt, String userId, Date updDate,
			String location) {
		super();
		this.chemLabJournal = chemLabJournal;
		this.actNo = actNo;
		this.chemist = chemist;
		this.producer = producer;
		this.projectName = projectName;
		this.preparationDate = preparationDate;
		this.preparationDesc = preparationDesc;
		this.purification = purification;
		this.meltingPoint = meltingPoint;
		this.boilingPoint = boilingPoint;
		this.color = color;
		this.amount = amount;
		this.yield = yield;
		this.cmnt = cmnt;
		this.userId = userId;
		this.updDate = updDate;
		this.location = location;
	}

	public String getChemLabJournal() {
		return chemLabJournal;
	}

	public void setChemLabJournal(String chemLabJournal) {
		this.chemLabJournal = chemLabJournal;
	}

	public String getActNo() {
		return actNo;
	}

	public void setActNo(String actNo) {
		this.actNo = actNo;
	}

	public String getChemist() {
		return chemist;
	}

	public void setChemist(String chemist) {
		this.chemist = chemist;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getPreparationDate() {
		return preparationDate;
	}

	public void setPreparationDate(Date preparationDate) {
		this.preparationDate = preparationDate;
	}

	public String getPreparationDesc() {
		return preparationDesc;
	}

	public void setPreparationDesc(String preparationDesc) {
		this.preparationDesc = preparationDesc;
	}

	public String getPurification() {
		return purification;
	}

	public void setPurification(String purification) {
		this.purification = purification;
	}

	public Integer getMeltingPoint() {
		return meltingPoint;
	}

	public void setMeltingPoint(Integer meltingPoint) {
		this.meltingPoint = meltingPoint;
	}

	public Integer getBoilingPoint() {
		return boilingPoint;
	}

	public void setBoilingPoint(Integer boilingPoint) {
		this.boilingPoint = boilingPoint;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getYield() {
		return yield;
	}

	public void setYield(BigDecimal yield) {
		this.yield = yield;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actNo == null) ? 0 : actNo.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((boilingPoint == null) ? 0 : boilingPoint.hashCode());
		result = prime * result + ((chemLabJournal == null) ? 0 : chemLabJournal.hashCode());
		result = prime * result + ((chemist == null) ? 0 : chemist.hashCode());
		result = prime * result + ((cmnt == null) ? 0 : cmnt.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((meltingPoint == null) ? 0 : meltingPoint.hashCode());
		result = prime * result + ((preparationDate == null) ? 0 : preparationDate.hashCode());
		result = prime * result + ((preparationDesc == null) ? 0 : preparationDesc.hashCode());
		result = prime * result + ((producer == null) ? 0 : producer.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result + ((purification == null) ? 0 : purification.hashCode());
		result = prime * result + ((updDate == null) ? 0 : updDate.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((yield == null) ? 0 : yield.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Batch other = (Batch) obj;
		if (actNo == null) {
			if (other.actNo != null)
				return false;
		} else if (!actNo.equals(other.actNo))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (boilingPoint == null) {
			if (other.boilingPoint != null)
				return false;
		} else if (!boilingPoint.equals(other.boilingPoint))
			return false;
		if (chemLabJournal == null) {
			if (other.chemLabJournal != null)
				return false;
		} else if (!chemLabJournal.equals(other.chemLabJournal))
			return false;
		if (chemist == null) {
			if (other.chemist != null)
				return false;
		} else if (!chemist.equals(other.chemist))
			return false;
		if (cmnt == null) {
			if (other.cmnt != null)
				return false;
		} else if (!cmnt.equals(other.cmnt))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (meltingPoint == null) {
			if (other.meltingPoint != null)
				return false;
		} else if (!meltingPoint.equals(other.meltingPoint))
			return false;
		if (preparationDate == null) {
			if (other.preparationDate != null)
				return false;
		} else if (!preparationDate.equals(other.preparationDate))
			return false;
		if (preparationDesc == null) {
			if (other.preparationDesc != null)
				return false;
		} else if (!preparationDesc.equals(other.preparationDesc))
			return false;
		if (producer == null) {
			if (other.producer != null)
				return false;
		} else if (!producer.equals(other.producer))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (purification == null) {
			if (other.purification != null)
				return false;
		} else if (!purification.equals(other.purification))
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
		if (yield == null) {
			if (other.yield != null)
				return false;
		} else if (!yield.equals(other.yield))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{\"chemLabJournal\":\"" + chemLabJournal + "\",\"actNo\":\"" + actNo + "\",\"chemist\":\"" + chemist + "\",\"producer\":\""
				+ producer + "\",\"projectName\":\"" + projectName + "\",\"preparationDate\":" + preparationDate
				+ ", \"preparationDesc\":\"" + preparationDesc + "\",\"purification\":\"" + purification + "\",\"meltingPoint\":"
				+ meltingPoint + ",\"boilingPoint\":" + boilingPoint + ",\"color\":\"" + color + "\",\"amount\":" + amount
				+ ",\"yield\":" + yield + ",\"cmnt\":\"" + cmnt + "\",\"userId\":\"" + userId + "\",\"updDate\":" + updDate + ",\"location\":\""
				+ location + "\"}";
	}
	
	

}