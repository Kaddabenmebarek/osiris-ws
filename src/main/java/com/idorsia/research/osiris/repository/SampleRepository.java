package com.idorsia.research.osiris.repository;

import com.idorsia.research.osiris.entity.Sample;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SampleRepository extends CrudRepository<Sample, Integer> {
	
	@Query("select s from Sample s where s.sampleId = ?1")
	Optional<Sample> findBySampleId(Integer sampleId);
	
	@Query("select s from Sample s where s.actNo = ?1")
	List<Sample> findByActNo(String actNo);

	@Query("select s from Sample s where s.extReferfence = ?1")
	List<Sample> findByExtReference(String extReference);

	@Query("select s from Sample s where s.supplier = ?1")
	List<Sample> findBySupplier(String supplier);

	@Query("select s from Sample s where s.catalogNo = ?1")
	List<Sample> findByCatalogNo(String catalogNo);

	@Query("select s from Sample s where s.location = ?1")
	List<Sample> findByLocation(String location);

	@Query("select s from Sample s where s.userId = ?1")
	List<Sample> findByUserId(String userId);

    @Query(value = "select EXT_REFERENCE from SAMPLE order by upd_date asc", nativeQuery = true)
    List<String> findAllSamples();

}
