package com.example.rez.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rez.model.Feature;
import com.example.rez.repository.FeatureRepository;
import com.example.rez.repository.ProjectRepository;

@Service
public class FeatureServiceImpl implements FeatureService {

    private FeatureRepository featureRepository;
    private ProjectRepository projectRepository;

    @Override
    public Feature addNewFeature(final String projectName, final Feature feature) {
        final var project = projectRepository.findByName(projectName);
        feature.setProject(project);
        return featureRepository.save(feature);
    }

    @Override
    public List<Feature> getAllFeaturesByProject(String projectName) {
        return projectRepository.findByName(projectName).getFeatures();
    }

    @Autowired
    public void setFeatureRepository(final FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    @Autowired
    public void setProjectRepository(final ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

}
