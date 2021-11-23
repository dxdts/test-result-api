package com.example.rez.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rez.exception.FeatureNotFound;
import com.example.rez.exception.ProjectNotFound;
import com.example.rez.model.Feature;
import com.example.rez.model.TestInfo;
import com.example.rez.repository.FeatureRepository;
import com.example.rez.repository.ProjectRepository;

@Service
public class TestInfoServiceImpl implements TestInfoService {

    private FeatureRepository featureRepository;
    private ProjectRepository projectRepository;

    @Override
    public Feature addNewTestInfo(final String projectName, final String featureName, final TestInfo testInfo) {
        final var project = projectRepository.findByName(projectName);
        final var feature = project.getFeatures().stream()
                .filter(p -> p.getName().equals(featureName))
                .findAny().orElseThrow(ProjectNotFound::new);
        final var testInf = new TestInfo();
        testInf.setFeature(feature);
        testInf.setTestName(testInfo.getTestName());
        testInf.setPassed(testInfo.isPassed());
        testInf.setDuration(testInfo.getDuration());
        feature.setTestInfo(testInf);
        return featureRepository.save(feature);
    }

    @Override
    public TestInfo getTestInfo(final String projectName, final String featureName) {
        return projectRepository.findByName(projectName).getFeatures().stream()
                .filter(p -> p.getName().equals(featureName))
                .findAny().orElseThrow(FeatureNotFound::new)
                .getTestInfo();
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
