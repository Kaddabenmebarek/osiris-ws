package com.idorsia.research.osiris.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "OSIRIS", name = "EMPLOYEE")
@SequenceGenerator(name = "EMPLOYEE_GEN", sequenceName = "OSIRIS.EMPLOYEE_SEQ", allocationSize = 1)
public class Employee implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
		
	@Id
	@Column(name = "EMPLOYEE_ID", unique = true, nullable = false, precision = 9, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_GEN")
	private int employeeId;
	
	@Column(name = "MANAGER_ID", precision = 9, scale = 0)
	private Integer managerId;
	
	@Column(name = "USER_NAME", length = 16)
	private String userName;
	
	@Column(name = "FIRST_NAME", length = 30)
	private String firstName;
	
	@Column(name = "LAST_NAME", length = 40)
	private String lastName;
	
	@Column(name = "TITLE", length = 128)
	private String title;
	
	@Column(name = "UPD_USER", length = 20)
	private String updUser;
	
	@Column(name = "UPD_DATE", nullable = false, length = 7)
	private Date updDate;
	
	@Column(name = "LASTWORKINGDATE", length = 7)
	private Date lastWorkingDate;
	
	@Column(name = "PASSWORD", length = 20)
	private String password;
	
	@Column(name = "DISABLED", precision = 2, scale = 0)
	private Byte disabled;
	
	@Column(name = "ROLES", length = 64)
	private String roles;
	
	@Column(name = "EMAIL", length = 128)
	private String email;
	
	@Column(name = "FAILEDCONNECTIONS", nullable = false, precision = 8, scale = 0)
	private int failedconnections;

	public Employee() {
	}

	public Employee(int employeeId, Integer managerId, String userName, String firstName, String lastName,
			String title, String updUser, Date updDate, Date lastWorkingDate, String password, Byte disabled, String roles,
			int failedconnections) {
		this.employeeId = employeeId;
		this.managerId = managerId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.updUser = updUser;
		this.updDate = updDate;
		this.lastWorkingDate = lastWorkingDate;
		this.password = password;
		this.disabled = disabled;
		this.roles = roles;
		this.failedconnections = failedconnections;
	}


	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getManagerId() {
		return this.managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUpdUser() {
		return this.updUser;
	}

	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}
	
	public Date getLastWorkingDate() {
		return lastWorkingDate;
	}

	public void setLastWorkingDate(Date lastWorkingDate) {
		this.lastWorkingDate = lastWorkingDate;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Byte getDisabled() {
		return this.disabled;
	}

	public void setDisabled(Byte disabled) {
		this.disabled = disabled;
	}

	public String getRoles() {
		return this.roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public int getFailedconnections() {
		return this.failedconnections;
	}

	public void setFailedconnections(int failedconnections) {
		this.failedconnections = failedconnections;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disabled == null) ? 0 : disabled.hashCode());
		result = prime * result + employeeId;
		result = prime * result + failedconnections;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((managerId == null) ? 0 : managerId.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((updDate == null) ? 0 : updDate.hashCode());
		result = prime * result + ((updUser == null) ? 0 : updUser.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Employee other = (Employee) obj;
		if (disabled == null) {
			if (other.disabled != null)
				return false;
		} else if (!disabled.equals(other.disabled))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (failedconnections != other.failedconnections)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (managerId == null) {
			if (other.managerId != null)
				return false;
		} else if (!managerId.equals(other.managerId))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (updDate == null) {
			if (other.updDate != null)
				return false;
		} else if (!updDate.equals(other.updDate))
			return false;
		if (updUser == null) {
			if (other.updUser != null)
				return false;
		} else if (!updUser.equals(other.updUser))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}



}
