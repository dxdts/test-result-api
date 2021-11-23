package com.example.rez.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rez.model.Feature;
import com.example.rez.service.FeatureService;

import static com.example.rez.controller.BaseController.FEATURE_URL;
import static com.example.rez.controller.BaseController.PROJECT_NAME;
import static com.example.rez.controller.BaseController.PROJECT_NAME_PATH;
import static com.example.rez.controller.BaseController.PROJECT_URL;

@RestController
public class FeatureController {
    private FeatureService featureService;

    @PostMapping(PROJECT_URL + PROJECT_NAME_PATH + FEATURE_URL)
    public ResponseEntity<Feature> createNewFeature(@PathVariable(PROJECT_NAME) String projectName, @RequestBody Feature feature) {
        return ResponseEntity.status(HttpStatus.CREATED).body(featureService.addNewFeature(projectName, feature));
    }

    @GetMapping(PROJECT_URL + PROJECT_NAME_PATH + FEATURE_URL)
    public ResponseEntity<List<Feature>> getAllFeaturesByProject(@PathVariable(PROJECT_NAME) String projectName) {
        return ResponseEntity.status(HttpStatus.OK).body(featureService.getAllFeaturesByProject(projectName));
    }

    @Autowired
    public void setFeatureService(final FeatureService featureService) {
        this.featureService = featureService;
    }
}
