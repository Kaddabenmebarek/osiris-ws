package com.idorsia.research.osiris.repository;

import com.idorsia.research.osiris.entity.Batch;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BatchRepository extends CrudRepository<Batch, Integer> {
	
	@Query("select b from Batch b where b.chemLabJournal = ?1")
	Optional<Batch> findByChemLabjournal(String chemLabJournal);
	
	@Query("select b from Batch b where b.actNo = ?1")
	List<Batch> findByActNo(String actNo);

    @Query("select b from Batch b where b.chemist = ?1")
    List<Batch> findByChemist(String chemist);

    @Query("select b from Batch b where b.producer = ?1")
    List<Batch> findByProducer(String producer);

    @Query("select b from Batch b where b.projectName = ?1")
    List<Batch> findByProjectName(String projectName);
    
//    @Query(value = "select CHEM_LAB_JOURNAL from BATCH order by upd_date asc FETCH FIRST 50000 ROWS ONLY", nativeQuery = true)
//    List<String> findAllBatches();
    
    @Query(value = "select CHEM_LAB_JOURNAL from BATCH order by upd_date asc", nativeQuery = true)
    List<String> findAllBatches();

    @Query(value = "select b from Batch b, Sample s where b.actNo = s.actNo and s.extReferfence = ?1")
	List<Batch> findBySampleExternalReference(String externalReference);

}
