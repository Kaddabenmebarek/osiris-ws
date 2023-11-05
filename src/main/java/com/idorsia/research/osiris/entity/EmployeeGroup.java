package com.idorsia.research.osiris.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_GROUP", schema = "OSIRIS")
@SequenceGenerator(name = "EMPLOYEE_GROUP_GEN", sequenceName = "OSIRIS.EMPLOYEE_GROUP_SEQUENCE", allocationSize = 1)
public class EmployeeGroup implements java.io.Serializable {

	private static final long serialVersionUID = 6491305701570457100L;
	private BigDecimal groupId;
	private Integer groupParent;
	private String groupName;
	private String wikiName;
	private String comments;
	private BigDecimal disabled;
	private String upduser;
	private Date upddate;
	private BigDecimal functional;
	private BigDecimal nuboId;

	public EmployeeGroup() {
	}

	public EmployeeGroup(BigDecimal groupId, String groupName, Date upddate) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.upddate = upddate;
	}

	public EmployeeGroup(BigDecimal groupId, Integer groupParent, String groupName, String wikiName, String comments,
			BigDecimal disabled, String upduser, Date upddate, BigDecimal functional, BigDecimal nuboId) {
		this.groupId = groupId;
		this.groupParent = groupParent;
		this.groupName = groupName;
		this.wikiName = wikiName;
		this.comments = comments;
		this.disabled = disabled;
		this.upduser = upduser;
		this.upddate = upddate;
		this.functional = functional;
		this.nuboId = nuboId;
	}

	@Id
	@Column(name = "GROUP_ID", unique = true, nullable = false, precision = 9, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_GROUP_GEN")
	public BigDecimal getGroupId() {
		return this.groupId;
	}

	public void setGroupId(BigDecimal groupId) {
		this.groupId = groupId;
	}

	@Column(name = "GROUP_PARENT", precision = 9, scale = 0)
	public Integer getGroupParent() {
		return this.groupParent;
	}

	public void setGroupParent(Integer groupParent) {
		this.groupParent = groupParent;
	}

	@Column(name = "GROUP_NAME", nullable = false, length = 60)
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column(name = "WIKI_NAME", length = 60)
	public String getWikiName() {
		return this.wikiName;
	}

	public void setWikiName(String wikiName) {
		this.wikiName = wikiName;
	}

	@Column(name = "COMMENTS", length = 30)
	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "DISABLED", precision = 22, scale = 0)
	public BigDecimal getDisabled() {
		return this.disabled;
	}

	public void setDisabled(BigDecimal disabled) {
		this.disabled = disabled;
	}

	@Column(name = "UPDUSER", length = 20)
	public String getUpduser() {
		return this.upduser;
	}

	public void setUpduser(String upduser) {
		this.upduser = upduser;
	}

	@Column(name = "UPDDATE", nullable = false, length = 7)
	public Date getUpddate() {
		return this.upddate;
	}

	public void setUpddate(Date upddate) {
		this.upddate = upddate;
	}
	
	@Column(name = "FUNCTIONAL", precision = 22, scale = 0)
	public BigDecimal getFunctional() {
		return functional;
	}

	public void setFunctional(BigDecimal functional) {
		this.functional = functional;
	}

	@Column(name = "NUBO_ID", precision = 22, scale = 0)
	public BigDecimal getNuboId() {
		return nuboId;
	}

	public void setNuboId(BigDecimal nuboId) {
		this.nuboId = nuboId;
	}


}
