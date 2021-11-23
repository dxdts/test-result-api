package com.example.rez.service;

import java.util.List;

import com.example.rez.model.Project;

public interface ProjectService {

    Project getProjectByName(String name);

    List<Project> getAllProjects();

    Project addNewProject(Project project);
}
