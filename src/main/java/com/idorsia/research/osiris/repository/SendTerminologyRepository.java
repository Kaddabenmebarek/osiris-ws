package com.idorsia.research.osiris.repository;

import com.idorsia.research.osiris.entity.SendTerminology;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SendTerminologyRepository extends CrudRepository<SendTerminology, Integer> {
	
	@Query(value = "select st1.cdisc_submission_value from send_terminology st1, send_terminology st2 where st1.codelist_code = st2.code and st2.cdisc_submission_value = ?", nativeQuery = true)
	//@Query(value = "select st1.cdisc_submission_value from send_terminology st1 where st1.codelist_code = (select st2.code from send_terminology st2 where st2.cdisc_submission_value = ? and st2.codelist_extensible is not null)", nativeQuery = true)
	List<String> findByCode(String code);

	@Query(value = "select distinct(codelist_name) from send_terminology where codelist_extensible is not null order by codelist_name", nativeQuery = true)
	List<String> findCodeNames();

	@Query(value = "select distinct(cdisc_submission_value) from send_terminology where codelist_extensible is not null and codelist_name = ?", nativeQuery = true)
	String getCodeByCodeName(String codename);

}
