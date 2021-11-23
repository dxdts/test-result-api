package com.example.rez.service;

import java.util.List;

import com.example.rez.model.Feature;

public interface FeatureService {

    Feature addNewFeature(String projectName, Feature feature);

    List<Feature> getAllFeaturesByProject(String projectName);
}
