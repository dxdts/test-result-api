package com.example.rez.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rez.model.Project;
import com.example.rez.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project getProjectByName(String name) {
        return projectRepository.findByName(name);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project addNewProject(final Project project) {
        return projectRepository.save(project);
    }
}
