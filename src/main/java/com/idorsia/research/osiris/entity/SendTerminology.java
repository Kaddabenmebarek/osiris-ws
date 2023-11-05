package com.idorsia.research.osiris.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(schema = "OSIRIS", name = "SEND_TERMINOLOGY")
public class SendTerminology implements Serializable {

	private static final long serialVersionUID = -4890555420857339987L;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "CODELIST_CODE")
	private String codeListCode;

	@Column(name = "CODELIST_EXTENSIBLE")
	private String codeListExtensible;

	@Column(name = "CODELIST_NAME")
	private String codeListName;

	@Column(name = "CDISC_SUBMISSION_VALUE")
	private String cdiscSubmissionValue;

	@Column(name = "CDISC_SYNONYM")
	private String cdiscSynonym;

	@Column(name = "CDISC_DEFINITION")
	private String cdiscDefinition;

	@Column(name = "NCI_PREFERED_TERM")
	private String nciPreferedTerm;

	//@Temporal(TemporalType.DATE)
	@Column(name = "CT_VERSION")
	private Date ctVersion;

	public SendTerminology(Integer id, String code, String codeListCode, String codeListExtensible, String codeListName,
			String cdiscSubmissionValue, String cdiscSynonym, String cdiscDefinition, String nciPreferedTerm,
			Date ctVersion) {
		super();
		this.id = id;
		this.code = code;
		this.codeListCode = codeListCode;
		this.codeListExtensible = codeListExtensible;
		this.codeListName = codeListName;
		this.cdiscSubmissionValue = cdiscSubmissionValue;
		this.cdiscSynonym = cdiscSynonym;
		this.cdiscDefinition = cdiscDefinition;
		this.nciPreferedTerm = nciPreferedTerm;
		this.ctVersion = ctVersion;
	}

	public SendTerminology() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeListCode() {
		return codeListCode;
	}

	public void setCodeListCode(String codeListCode) {
		this.codeListCode = codeListCode;
	}

	public String getCodeListExtensible() {
		return codeListExtensible;
	}

	public void setCodeListExtensible(String codeListExtensible) {
		this.codeListExtensible = codeListExtensible;
	}

	public String getCodeListName() {
		return codeListName;
	}

	public void setCodeListName(String codeListName) {
		this.codeListName = codeListName;
	}

	public String getCdiscSubmissionValue() {
		return cdiscSubmissionValue;
	}

	public void setCdiscSubmissionValue(String cdiscSubmissionValue) {
		this.cdiscSubmissionValue = cdiscSubmissionValue;
	}

	public String getCdiscSynonym() {
		return cdiscSynonym;
	}

	public void setCdiscSynonym(String cdiscSynonym) {
		this.cdiscSynonym = cdiscSynonym;
	}

	public String getCdiscDefinition() {
		return cdiscDefinition;
	}

	public void setCdiscDefinition(String cdiscDefinition) {
		this.cdiscDefinition = cdiscDefinition;
	}

	public String getNciPreferedTerm() {
		return nciPreferedTerm;
	}

	public void setNciPreferedTerm(String nciPreferedTerm) {
		this.nciPreferedTerm = nciPreferedTerm;
	}

	public Date getCtVersion() {
		return ctVersion;
	}

	public void setCtVersion(Date ctVersion) {
		this.ctVersion = ctVersion;
	}

}