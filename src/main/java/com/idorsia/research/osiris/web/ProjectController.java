package com.idorsia.research.osiris.web;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.idorsia.research.osiris.data.JsonUtils;
import com.idorsia.research.osiris.data.ProjectDto;
import com.idorsia.research.osiris.entity.Project;
import com.idorsia.research.osiris.service.ProjectService;


@RestController
@RequestMapping(path = "/project")
public class ProjectController {
    private static Logger logger = LogManager.getLogger(ProjectController.class);
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    protected ProjectController() {

    }

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getAllProjects() {
        logger.info("Getting all project");

        boolean firstProject = true;
        long count = projectService.count();
        Iterable<Project> projects = projectService.findAll();
        StringBuffer bodyResponse = new StringBuffer("{");
        bodyResponse.append("\"count\":\"" + count + "\",");
        bodyResponse.append("\"projects\":[");
        try {
            for (Project project : projects) {
                if (firstProject) {
                	firstProject = false;
                } else {
                    bodyResponse.append(",");
                }

                bodyResponse.append(JsonUtils.mapToJson(project));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        bodyResponse.append("]}");

        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json;encoding=UTF-8")
                .body(bodyResponse.toString());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{projectName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getProject(@PathVariable(value = "projectName") String projectName) {
        logger.info("Getting project : " + projectName);

        Optional<Project> project = projectService.findByName(projectName);
        if (project == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"Project name doesn't match.\"}");

        }
        Project proj = project.get();

        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(proj));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/projects/{responsible}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getProjectByResponsible(@PathVariable(value = "responsible") String responsible) {
        logger.info("Getting project for : " + responsible);

        List<Project> projects = projectService.findByProjectResponsible(responsible);
        if (projects == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No project found.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(projects));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }

    @RequestMapping(method = RequestMethod.POST, path="/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addProject(@RequestBody ProjectDto projectDto) {
        logger.info("Adding project");
        StringBuffer bodyResponse = new StringBuffer("{");
        Project project = new Project();
        project.setProjectName(projectDto.getProjectName());
        project.setShortName(projectDto.getShortName());
        project.setThemeNo(projectDto.getThemeNo());
        project.setResponsible(projectDto.getResponsible());
        project.setCmnt(projectDto.getCmnt());
        project.setUserId(projectDto.getUserId());
        project.setCategory(projectDto.getCategory());
        project.setRelevantTestId(projectDto.getRelevantTestId());
        project.setInitiated(projectDto.getInitiated());
        project.setUpdDate(projectDto.getUpdDate());
        projectService.save(project);
        bodyResponse.append("}");
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
	/*@RequestMapping(method = RequestMethod.PUT, path = "/update")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> updateProject(@RequestBody ProjectDto projectDto) {
		logger.info("Updating project");
		String projectName = String.valueOf(projectDto.getProjectName());
		Optional<Project> project = projectService.findByName(projectName);
        if (project == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"Project not saved.\"}");

        }
		Project proj = project.get();
		proj.setProjectName(projectDto.getProjectName());
		proj.setShortName(projectDto.getShortName());
		proj.setThemeNo(projectDto.getThemeNo());
		proj.setResponsible(projectDto.getResponsible());
		proj.setCmnt(projectDto.getCmnt());
		proj.setUserId(projectDto.getUserId());
		proj.setCategory(projectDto.getCategory());
		proj.setRelevantTestId(projectDto.getRelevantTestId());
		proj.setInitiated(projectDto.getInitiated());
		proj.setUpdDate(projectDto.getUpdDate());

		StringBuffer bodyResponse = new StringBuffer("{}");
		projectService.save(proj);
		bodyResponse.append("}");
		return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json")
				.body(bodyResponse.toString());
	}
	
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{projectName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteProject(@PathVariable(value = "projectName") String projectName) {
        logger.info("Deleting project : " + projectName);

        Optional<Project> project = projectService.findByName(projectName);
        if (project == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"Project cannot be removed.\"}");

        }
        Project proj = project.get();
		StringBuffer bodyResponse = new StringBuffer("{}");
		projectService.delete(proj);
		bodyResponse.append("}");
		return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json")
				.body(bodyResponse.toString());
    }*/
}
