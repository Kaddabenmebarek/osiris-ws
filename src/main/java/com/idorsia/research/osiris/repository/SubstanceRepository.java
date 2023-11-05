package com.idorsia.research.osiris.repository;

import com.idorsia.research.osiris.entity.Substance;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SubstanceRepository extends CrudRepository<Substance, Integer> {
	
	@Query("select s from Substance s where s.actNo = ?1")
	Optional<Substance> findByName(String actNo);

    @Query("select s from Substance s where s.formula = ?1")
    List<Substance> findByFormula(String formula);
    
    @Query(value = "select ACT_NO from SUBSTANCE order by upd_date asc", nativeQuery = true)
    List<String> findAllSubstances();

}
