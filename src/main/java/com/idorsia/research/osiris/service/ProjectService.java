package com.idorsia.research.osiris.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idorsia.research.osiris.entity.Project;
import com.idorsia.research.osiris.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Iterable<Project> findAll() { return projectRepository.findAll(); }

    public long count() { return projectRepository.count(); }

    public Optional<Project> findByName(String projectName) {
        return this.projectRepository.findByName(projectName);
    }

    public List<Project> findByProjectResponsible(String responsible) {
        return this.projectRepository.findByProjectResponsible(responsible);
    }


    public Project save(Project project) {
        return projectRepository.save(project);
    }
    
    public void delete(Project project) {
    	projectRepository.delete(project);
    }
}
