package com.example.rez.controller;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rez.model.Project;
import com.example.rez.service.ProjectService;

import static com.example.rez.controller.BaseController.PROJECT_URL;

@RestController
public class ProjectController {
    private ProjectService projectService;

    @GetMapping(PROJECT_URL)
    public ResponseEntity<Project> getProjectByName(@RequestParam(value = "name", required = false) String name) {
        if (Strings.isBlank(name)) {
            return new ResponseEntity(projectService.getAllProjects(), HttpStatus.OK);
        }
        return new ResponseEntity(projectService.getProjectByName(name), HttpStatus.OK);
    }

    @PostMapping(PROJECT_URL)
    public ResponseEntity<Project> createNewProject(@RequestBody Project project) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.addNewProject(project));
    }


    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }
}
