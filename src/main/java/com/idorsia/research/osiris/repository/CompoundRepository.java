package com.idorsia.research.osiris.repository;

import com.idorsia.research.osiris.entity.Compound;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompoundRepository extends CrudRepository<Compound, Integer> {
	
	@Query("select c from Compound c where c.actNo = ?1")
	List<Compound> findByName(String compoundName);

	@Query("select c from Compound c where c.chemLabJournal = ?1")
	Optional<Compound> findByChemLabJournal(String chemLabJournal);

	@Query("select c from Compound c where c.compoundId = ?1")
	Optional<Compound> findByCompoundId(Integer compoundId);

}
