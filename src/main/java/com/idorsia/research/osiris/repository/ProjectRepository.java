package com.idorsia.research.osiris.repository;

import com.idorsia.research.osiris.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
	
	@Query("select p from Project p where p.projectName = ?1")
	Optional<Project> findByName(String projectName);

    @Query("select p from Project p where p.responsible = ?1")
    List<Project> findByProjectResponsible(String Responsible);

}
