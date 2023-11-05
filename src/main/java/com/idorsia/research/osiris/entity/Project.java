package com.idorsia.research.osiris.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(schema = "OSIRIS", name = "PROJECT")
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "PROJECT_NAME", unique = true, nullable = false)
	String projectName;

	@Column(name = "SHORT_NAME")
	String shortName;

	@Column(name = "THEME_NO")
	String themeNo;

	@Column(name = "RESPONSIBLE")
	String responsible;

	@Column(name = "CMNT")
	String cmnt;

	@Column(name = "USER_ID")
	String userId;

	@Column(name = "CATEGORY")
	String category;

	@Column(name = "RELEVANT_TEST_ID")
	Integer relevantTestId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INITIATED")
	Date initiated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPD_DATE")
	Date updDate;

	public Project() {
		super();
	}

	public Project(String projectName, String shortName, String themeNo, String responsible, String cmnt, String userId,
			String category, Integer relevantTestId, Date initiated, Date updDate) {
		super();
		this.projectName = projectName;
		this.shortName = shortName;
		this.themeNo = themeNo;
		this.responsible = responsible;
		this.cmnt = cmnt;
		this.userId = userId;
		this.category = category;
		this.relevantTestId = relevantTestId;
		this.initiated = initiated;
		this.updDate = updDate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getThemeNo() {
		return themeNo;
	}

	public void setThemeNo(String themeNo) {
		this.themeNo = themeNo;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getRelevantTestId() {
		return relevantTestId;
	}

	public void setRelevantTestId(Integer relevantTestId) {
		this.relevantTestId = relevantTestId;
	}

	public Date getInitiated() {
		return initiated;
	}

	public void setInitiated(Date initiated) {
		this.initiated = initiated;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((cmnt == null) ? 0 : cmnt.hashCode());
		result = prime * result + ((initiated == null) ? 0 : initiated.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result + ((relevantTestId == null) ? 0 : relevantTestId.hashCode());
		result = prime * result + ((responsible == null) ? 0 : responsible.hashCode());
		result = prime * result + ((shortName == null) ? 0 : shortName.hashCode());
		result = prime * result + ((themeNo == null) ? 0 : themeNo.hashCode());
		result = prime * result + ((updDate == null) ? 0 : updDate.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Project))
			return false;
		Project other = (Project) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (cmnt == null) {
			if (other.cmnt != null)
				return false;
		} else if (!cmnt.equals(other.cmnt))
			return false;
		if (initiated == null) {
			if (other.initiated != null)
				return false;
		} else if (!initiated.equals(other.initiated))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (relevantTestId == null) {
			if (other.relevantTestId != null)
				return false;
		} else if (!relevantTestId.equals(other.relevantTestId))
			return false;
		if (responsible == null) {
			if (other.responsible != null)
				return false;
		} else if (!responsible.equals(other.responsible))
			return false;
		if (shortName == null) {
			if (other.shortName != null)
				return false;
		} else if (!shortName.equals(other.shortName))
			return false;
		if (themeNo == null) {
			if (other.themeNo != null)
				return false;
		} else if (!themeNo.equals(other.themeNo))
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
